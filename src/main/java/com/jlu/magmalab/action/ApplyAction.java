package com.jlu.magmalab.action;

import static com.jlu.magmalab.dao.tables.ApplyInfo.APPLY_INFO;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.MainForm;
import com.jlu.magmalab.bean.TodoForm;
import com.jlu.magmalab.dao.tables.daos.ApplyInfoDao;
import com.jlu.magmalab.dao.tables.pojos.ApplyInfo;
import com.jlu.magmalab.page.Page;
import com.jlu.magmalab.page.PageHelper;
import com.jlu.magmalab.service.EmailService;
import com.jlu.utils.Ajax;
import com.jlu.utils.CmdUtils;
import com.jlu.utils.IdGenerator;
import com.jlu.utils.SerializUtil;
import com.jlu.utils.Session;

/**
 * 
 * ClassName: ApplyAction <br/>
 * Function: 申请控制器. <br/>
 * date: 2017年10月9日 下午3:20:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/apply")
public class ApplyAction {

	@Autowired
	private EmailService emailService;

	@Autowired
	private ApplyInfoDao applyInfoDao;

	@Autowired
	private DefaultDSLContext dsl;

	@Autowired
	private PageHelper<TodoForm> pageHelper;

	/**
	 * 
	 * apply:(提交申请). <br/>
	 * 
	 * @author liboqiang
	 * @param apply
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/doApply", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String apply(MainForm apply) {
		try {

			// 获取申请ID
			String applyId = apply.getApplyId();

			if (Session.isSuperAdmin()) {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, "管理员不能提交申请哦:)");
			}

			// 操作文件夹
			String userName = Session.getUser().getUserName();
			String uniID = UUID.randomUUID().toString();
			String dstDir = CST.UPLOAD_DIR + "/upload_tmp_" + uniID;
			String attachFile = userName + "_申请文件.zip";

			// 1.制作上传文件夹
			mkUploadDir(apply, dstDir);

			// 2.替换word文档
			mkWord(apply, dstDir);

			// 3.压缩并发送
			String[] cmds = { "/bin/sh", "-c", "cd " + dstDir + " && " + "zip -r " + attachFile + " ./*" };
			CmdUtils.exec(cmds);
			emailService.setFromUser(userName);
			emailService.setToUser("友车金融");
			emailService.setSubject("申请表");
			emailService.setFile(new File(dstDir + "/" + attachFile));
			emailService.setAttchName(attachFile);
			emailService.send();

			// 4.删除文件
			CmdUtils.exec("rm -rf " + dstDir);

			// 5.存入数据库
			ApplyInfo object = new ApplyInfo();
			object.setApplyUser(Session.getUser().getUserId());
			object.setData(SerializUtil.java2Stream(apply));
			object.setStatus(CST.APPLY_STATUS_WAITE);
			object.setApplyCar(apply.getCarType());
			object.setLoanVal(apply.getLoanVal());

			if (StringUtils.isEmpty(applyId)) {
				object.setProType(apply.getProType());
				object.setApplyId(IdGenerator.genId());
				object.setApplyTime(new Timestamp(System.currentTimeMillis()));
				applyInfoDao.insert(object);
			} else {
				object.setApplyId(applyId);
				object.setProType(apply.getProType() + "(驳回后再次申请)");
				object.setApplyTime(new Timestamp(System.currentTimeMillis()));
				applyInfoDao.update(object);
			}

			// 6.返回前台
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * mkWord:(制作word文档). <br/>
	 * 
	 * @author liboqiang
	 * @param apply
	 * @param dstDir
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @since JDK 1.6
	 */
	private void mkWord(MainForm apply, String dstDir) throws Exception {
		String fileName = dstDir + "/车贷险资料.doc";
		String desFileName = dstDir + "/des.doc";
		HWPFDocument document = new HWPFDocument(new FileInputStream(new File(fileName)));
		Range range = (Range) document.getRange();
		Class<?> clazz = apply.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			// 过滤上传图片
			if (String.class != field.getType()) {
				continue;
			}
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
			String fieldVal = (String) pd.getReadMethod().invoke(apply);
			fieldVal = (fieldVal == null ? "" : fieldVal);
			range.replaceText("${" + fieldName + "}", fieldVal);
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(desFileName);
			document.write(out);

			// 删除文件、重命名文件
			CmdUtils.exec("rm -rf " + fileName);
			CmdUtils.exec("mv " + desFileName + " " + fileName);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			document.close();
		}
	}

	/**
	 * 
	 * mkUploadDir:(制作上传文件夹). <br/>
	 * 
	 * @author liboqiang
	 * @param apply
	 * @param dstDir
	 * @throws IOException
	 * @since JDK 1.6
	 */
	private void mkUploadDir(MainForm apply, String dstDir) throws Exception {
		// 1.拷贝模板文件夹
		CmdUtils.exec("cp -r " + CST.UPLOAD_DIR + "/upload " + dstDir);

		// 分发文件
		for (Map.Entry<String, String> entry : CST.PIC_MAPPER.entrySet()) {
			Class<?> clazz = apply.getClass();
			Class<?>[] parameterTypes = new Class[] {};
			Object[] methodPramas = new Object[] {};
			Method method = clazz.getMethod(entry.getKey(), parameterTypes);
			MultipartFile[] files = (MultipartFile[]) method.invoke(apply, methodPramas);
			if (files == null) {
				continue;
			}
			for (MultipartFile file : files) {
				File upFile = new File(dstDir + "/" + entry.getValue(), file.getOriginalFilename());
				file.transferTo(upFile);
			}
		}
	}

	/**
	 * 
	 * getApplyRecords:(获取申请记录列表). <br/>
	 * 
	 * @author liboqiang
	 * @param todoForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/getApplyRecords", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getApplyRecords(@RequestBody TodoForm todoForm) {
		try {
			SelectConditionStep<?> sql = null;
			// 身份认证
			if (Session.isSuperAdmin()) {
				// 定义sql
				sql = dsl
						.select(APPLY_INFO.APPLY_ID,
								DSL.field("date_format({0},'%Y-%m-%d %H:%i:%s')", String.class, APPLY_INFO.APPLY_TIME)
										.as("applyTime"),
								APPLY_INFO.LOAN_VAL, APPLY_INFO.APPLY_CAR, APPLY_INFO.PRO_TYPE,
								TM_USER.USER_NAME.as("applyUser"), DSL.val(Session.isSuperAdmin()).as("isAdmin"),
								APPLY_INFO.STATUS, APPLY_INFO.REJECT_MSG)
						.from(APPLY_INFO).leftJoin(TM_USER).on(TM_USER.USER_ID.eq(APPLY_INFO.APPLY_USER)).where("1=1");

				// 申请人是否为空
				if (!StringUtils.isEmpty(todoForm.getApplyUser())) {
					sql.and(TM_USER.USER_NAME.contains(todoForm.getApplyUser()));
				}
			} else {
				// 定义sql
				sql = dsl
						.select(APPLY_INFO.APPLY_ID,
								DSL.field("date_format({0},'%Y-%m-%d %H:%i:%s')", String.class, APPLY_INFO.APPLY_TIME)
										.as("applyTime"),
								APPLY_INFO.LOAN_VAL, APPLY_INFO.APPLY_CAR, APPLY_INFO.PRO_TYPE,
								TM_USER.USER_NAME.as("applyUser"), DSL.val(Session.isSuperAdmin()).as("isAdmin"),
								APPLY_INFO.STATUS, APPLY_INFO.REJECT_MSG)
						.from(APPLY_INFO).leftJoin(TM_USER).on(TM_USER.USER_ID.eq(APPLY_INFO.APPLY_USER))
						.where(TM_USER.USER_ID.eq(Session.getUser().getUserId()));
			}

			// 申请状态是否为空
			if (todoForm.getStatus() != null) {
				sql.and(APPLY_INFO.STATUS.contains(todoForm.getStatus()));
			}

			// 申请ID是否为空
			if (!StringUtils.isEmpty(todoForm.getApplyId())) {
				sql.and(APPLY_INFO.APPLY_ID.eq(todoForm.getApplyId()));
			}

			// 添加排序
			sql.orderBy(TM_USER.UPD_TIME.asc());
			Page<TodoForm> res = pageHelper.get(todoForm.getPage(), todoForm.getRows(), sql, TodoForm.class);
			return Ajax.responseString(CST.RES_SUCCESS, res, true);

		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * getApplyRecords:(获取申请记录列表). <br/>
	 * 
	 * @author liboqiang
	 * @param todoForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String approve(@RequestBody TodoForm todoForm) {
		try {
			// 更新申请记录表
			dsl.update(APPLY_INFO).set(APPLY_INFO.STATUS, todoForm.getStatus())
					.set(APPLY_INFO.REJECT_MSG, todoForm.getRejectMsg())
					.where(APPLY_INFO.APPLY_ID.eq(todoForm.getApplyId())).execute();

			return Ajax.responseString(CST.RES_AUTO_DIALOG, "审批成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * rebuild:(重构申请页面). <br/>
	 * 
	 * @author liboqiang
	 * @param applyId
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/rebuild", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String rebuild(String applyId) {
		try {
			ApplyInfo bean = applyInfoDao.fetchOneByApplyId(applyId);
			MainForm data = SerializUtil.stream2Java(bean.getData());
			return Ajax.responseString(CST.RES_SUCCESS, data);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

}
