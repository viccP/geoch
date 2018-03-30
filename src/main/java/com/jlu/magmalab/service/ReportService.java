package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmLabReport.TM_LAB_REPORT;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlu.cst.CST;
import com.jlu.magmalab.dao.tables.daos.TmLabReportDao;
import com.jlu.magmalab.dao.tables.pojos.TmLabReport;
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
			object.setReportStudentStatus(CST.HAS_READED);
			object.setReportTeacherStatus(CST.NON_READ);
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
					.set(TM_LAB_REPORT.REPORT_TEACHER_STATUS, CST.HAS_READED).set(TM_LAB_REPORT.REPORT_STUDENT_STATUS, CST.NON_READ)
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
}
