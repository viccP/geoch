package com.jlu.magmalab.action;

import static com.jlu.magmalab.dao.tables.TmLabReport.TM_LAB_REPORT;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.Record1;
import org.jooq.SelectJoinStep;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.ReportForm;
import com.jlu.magmalab.bean.Select;
import com.jlu.magmalab.page.Page;
import com.jlu.magmalab.service.ReportService;
import com.jlu.utils.Ajax;
import com.jlu.utils.Session;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: ReportAction <br/>
 * Function: 实验报告控制器. <br/>
 * date: 2018年3月30日 下午4:30:09 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/report")
public class ReportAction {

	@Autowired
	private ReportService taskService;

	@Autowired
	private DefaultDSLContext dsl;

	/**
	 * 
	 * save:(保存实验报告). <br/>
	 * 
	 * @author liboqiang
	 * @param html
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String save(String html) {
		try {
			taskService.save(Utils.base64Decode(html));
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * update:(更新报告). <br/>
	 * 
	 * @author liboqiang
	 * @param html
	 * @param reportId
	 * @param score
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String check(String html, String reportId, int score) {
		try {
			taskService.check(Utils.base64Decode(html), reportId, score);
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * list:(查询报告列表). <br/>
	 * 
	 * @author liboqiang
	 * @param reportForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String list(@RequestBody ReportForm reportForm) {
		try {
			Page<ReportForm> res = taskService.list(reportForm);
			return Ajax.responseString(CST.RES_SUCCESS, res,true);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * refresh:(更新报告读写状态). <br/>
	 * 
	 * @author liboqiang
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/refresh", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String refresh(String id) {
		try {
			taskService.refresh(id);
			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * scoreSelect:(初始化分数下拉菜单). <br/>
	 * 
	 * @author liboqiang
	 * @param type
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/scoreSelect", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String scoreSelect() {
		try {
			SelectJoinStep<Record1<Integer>> sql = dsl.selectDistinct(TM_LAB_REPORT.REPORT_SCORE).from(TM_LAB_REPORT);
			if (!Session.isTeacher()) {
				sql.where(TM_LAB_REPORT.USER_ID.eq(Session.getUser().getUserId()));
			}

			List<Select<String>> res = sql.stream().map(s -> {
				Select<String> select = new Select<>();
				String value = (s.value1() == null) ? CST.NOTHING : String.valueOf(s.value1().intValue());
				select.setCode(value);
				select.setValue(value);
				return select;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * userSelect:(提交人下拉菜单). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/userSelect", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String userSelect() {
		try {
			List<Select<String>> res = dsl.selectDistinct(TM_USER.USER_ID, TM_USER.USER_NAME).from(TM_LAB_REPORT).leftJoin(TM_USER)
					.on(TM_LAB_REPORT.USER_ID.eq(TM_USER.USER_ID)).stream().map(s -> {
						Select<String> select = new Select<>();
						select.setCode(s.value1());
						select.setValue(s.value2());
						return select;
					}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

}
