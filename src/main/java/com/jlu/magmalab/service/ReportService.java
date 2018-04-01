package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmLabReport.TM_LAB_REPORT;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.jooq.SelectOnConditionStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.ReportForm;
import com.jlu.magmalab.dao.tables.daos.TmLabReportDao;
import com.jlu.magmalab.dao.tables.pojos.TmLabReport;
import com.jlu.magmalab.page.Page;
import com.jlu.magmalab.page.PageHelper;
import com.jlu.utils.Session;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: TaskService <br/>
 * Function: 任务service. <br/>
 * date: 2018年3月30日 下午4:28:09 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Service
public class ReportService {

	@Autowired
	private TmLabReportDao tmLabReportDao;

	@Autowired
	private DefaultDSLContext dsl;

	@Autowired
	private PageHelper<ReportForm> pageHelper;

	/**
	 * 
	 * save:(保存实验报告). <br/>
	 * 
	 * @author liboqiang
	 * @param base64Decode
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(String html) throws Exception {
		String path = "";
		try {
			// 生成ID
			String id = Utils.genId();

			// 存入数据库
			TmLabReport object = new TmLabReport();
			object.setReportId(id);
			object.setUserId(Session.getUser().getUserId());
			object.setUpdTime(new Timestamp(System.currentTimeMillis()));
			object.setReportStudentStatus(CST.NON_READ);
			object.setReportTeacherStatus(CST.NON_READ);
			object.setReportStatus(CST.NON_READ);
			tmLabReportDao.insert(object);

			// 保存文件
			path = Session.getSession().getServletContext().getRealPath("/labreport/");
			String fileName = path + id;
			Files.write(Paths.get(fileName), html.getBytes());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * update:(更新实验报告). <br/>
	 * 
	 * @author liboqiang
	 * @param base64Decode
	 * @param reportId
	 * @param score
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void check(String html, String id, int score) throws Exception {
		String path = "";
		try {
			// 更新数据库
			dsl.update(TM_LAB_REPORT).set(TM_LAB_REPORT.UPD_TIME, new Timestamp(System.currentTimeMillis())).set(TM_LAB_REPORT.REPORT_SCORE, score)
					.set(TM_LAB_REPORT.REPORT_TEACHER_STATUS, CST.HAS_READED)
					.set(TM_LAB_REPORT.REPORT_STUDENT_STATUS, CST.NON_READ)
					.set(TM_LAB_REPORT.REPORT_STATUS,CST.HAS_READED)
					.where(TM_LAB_REPORT.REPORT_ID.eq(id)).execute();
			// 保存文件
			path = Session.getSession().getServletContext().getRealPath("/labreport/");
			String fileName = path + id;
			Files.write(Paths.get(fileName), html.getBytes());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 
	 * refresh:(更新报告读写状态). <br/>
	 * 
	 * @author liboqiang
	 * @param id
	 * @since JDK 1.6
	 */
	public void refresh(String id) throws Exception {
		try {
			if (Session.isTeacher()) {
				// 更新数据库
				dsl.update(TM_LAB_REPORT).set(TM_LAB_REPORT.REPORT_TEACHER_STATUS, CST.HAS_READED).where(TM_LAB_REPORT.REPORT_ID.eq(id)).execute();
			} else {
				// 更新数据库
				dsl.update(TM_LAB_REPORT).set(TM_LAB_REPORT.REPORT_STUDENT_STATUS, CST.HAS_READED).where(TM_LAB_REPORT.REPORT_ID.eq(id)).execute();
			}
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
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
	public Page<ReportForm> list(ReportForm reportForm) {
		//定义sql文
		SelectOnConditionStep<?> sql =dsl.select(
				TM_LAB_REPORT.REPORT_ID,
				DSL.decode(TM_LAB_REPORT.REPORT_SCORE,null,CST.NOTHING,TM_LAB_REPORT.REPORT_SCORE).as("REPORT_SCORE"),
				TM_LAB_REPORT.REPORT_STATUS,
				TM_LAB_REPORT.UPD_TIME,
				TM_LAB_REPORT.USER_ID,
				TM_USER.USER_NAME
			)
			.from(TM_LAB_REPORT)
			.leftJoin(TM_USER).on(TM_LAB_REPORT.USER_ID.eq(TM_USER.USER_ID));
		
		//如果不为老师
		if(!Session.isTeacher()) {
			sql.where(TM_LAB_REPORT.USER_ID.eq(Session.getUser().getUserId()));
		}
		else {
			sql.where("1=1");
			
			//报告提交人下拉框
			if(!StringUtils.isEmpty(reportForm.getUserId())) {
				sql.and(TM_LAB_REPORT.USER_ID.eq(reportForm.getUserId()));
			}
		}
		
		//实验报告状态下拉框
		if(reportForm.getReportStatus()!=null) {
			sql.and(TM_LAB_REPORT.REPORT_STATUS.eq(reportForm.getReportStatus()));
		}
		
		//分数下拉框
		if(!StringUtils.isEmpty(reportForm.getReportScore())) {
			if(!CST.NOTHING.equals(reportForm.getReportScore())) {
				Integer score=Integer.parseInt(reportForm.getReportScore());
				sql.and(TM_LAB_REPORT.REPORT_SCORE.eq(score));	
			}
			else {
				sql.and(TM_LAB_REPORT.REPORT_SCORE.isNull());
			}
		}
		
		// 添加排序
		sql.orderBy(TM_LAB_REPORT.UPD_TIME.asc());

		return pageHelper.get(reportForm.getPage(), reportForm.getRows(), sql, ReportForm.class);
	}
}
