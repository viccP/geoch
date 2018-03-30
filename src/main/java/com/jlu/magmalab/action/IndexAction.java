package com.jlu.magmalab.action;

import static com.jlu.magmalab.dao.tables.TmLabReport.TM_LAB_REPORT;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;
import static com.jlu.magmalab.dao.tables.TmUserRole.TM_USER_ROLE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.TmUserEx;
import com.jlu.magmalab.dao.tables.pojos.TmUser;
import com.jlu.utils.Ajax;
import com.jlu.utils.Session;

/**
 * 
 * ClassName: IndexAction <br/>
 * Function: index控制器. <br/>
 * date: 2017年9月29日 下午1:19:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/index")
public class IndexAction {

	@Autowired
	private DefaultDSLContext dsl;

	/**
	 * 
	 * isAdmin:(是否管理员). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/isAdmin", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String isAdmin() {

		try {
			return Ajax.responseString(CST.RES_SUCCESS, Session.isSuperAdmin());
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * isAdmin:(是否管理员). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/isTeacher", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String isTeacher() {
		try {
			return Ajax.responseString(CST.RES_SUCCESS, Session.isTeacher());
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * login:(登录). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String login(String loginId, String password) {

		try {
			TmUserEx result = dsl
					.select(TM_USER.LOGIN_ID, TM_USER.USER_ID, TM_USER.USER_NAME, TM_USER.PHONE_NO, TM_USER.MEMO, TM_USER.PASSWORD,
							TM_USER.PWD_STATUS, TM_USER.SEX, TM_USER.UPD_TIME, TM_USER_ROLE.ROLE_ID)
					.from(TM_USER).leftJoin(TM_USER_ROLE).on(TM_USER.USER_ID.eq(TM_USER_ROLE.USER_ID)).where(TM_USER.LOGIN_ID.eq(loginId))
					.and(TM_USER.PASSWORD.eq(password.toUpperCase())).fetchOneInto(TmUserEx.class);

			if (result != null) {
				Session.getSession().setAttribute("TM_USER", result);
				return Ajax.responseString(CST.RES_SUCCESS);
			} else {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_1, "用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * logout:(登出). <br/>
	 * 
	 * @author liboqiang
	 * @param session
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String logout(HttpSession session) {
		try {
			session.invalidate();
			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 检查session
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/checkSession", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String checkSession(HttpSession session) {
		try {
			if (session.getAttribute("TM_USER") == null) {
				return Ajax.responseString(CST.RES_SESSION_TIME_OUT, "用户已经过期，请重新登陆");
			}
			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * modifyPwd:(修改密码). <br/>
	 * 
	 * @author liboqiang
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String modifyPwd(String oldPwd, String newPwd, String confirmPwd) {
		try {
			// 0.获取用户ID
			String userId = Session.getUser().getUserId();

			// 1.旧密码验证
			TmUser res = dsl.selectFrom(TM_USER).where(TM_USER.USER_ID.eq(userId)).and(TM_USER.PASSWORD.eq(oldPwd.toUpperCase()))
					.fetchOneInto(TmUser.class);

			if (res == null) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_1, "旧密码验证错误");
			}

			// 2.密码一致性验证
			if (!newPwd.equals(confirmPwd)) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_2, "两次密码不一致,请重新输入");
			}

			// 3.修改密码
			dsl.update(TM_USER).set(TM_USER.PASSWORD, newPwd.toUpperCase()).set(TM_USER.PWD_STATUS, CST.PWD_STATUS_ALTERED)
					.where(TM_USER.USER_ID.eq(userId)).execute();

			return Ajax.responseString(CST.RES_AUTO_DIALOG, "密码修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * vlidatePwd:(验证密码状态). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/vlidatePwd", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String vlidatePwd() {
		try {
			TmUser tmUser = dsl.selectFrom(TM_USER).where(TM_USER.USER_ID.eq(Session.getUser().getUserId())).fetchOneInto(TmUser.class);
			if (CST.PWD_STATUS_INIT == tmUser.getPwdStatus()) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_1);
			}
			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * getTodoList:(获取待办列表). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/getTodoList", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String getTodoList() {
		try {
			// 定义别名
			com.jlu.magmalab.dao.tables.TmUser t1 = TM_USER.as("t1");
			com.jlu.magmalab.dao.tables.TmLabReport t2 = TM_LAB_REPORT.as("t2");
			List<Map<String, String>> res=new ArrayList<>();
			if(Session.isTeacher()) {
				res = dsl.select(
						t1.USER_NAME, 
						t2.REPORT_ID, 
						DSL.field("date_format({0},'%Y%m%d%H%i%s')", String.class, t2.UPD_TIME)
					)
					.from(t2).leftJoin(t1)
					.on(t2.USER_ID.eq(t1.USER_ID))
					.where(t2.REPORT_TEACHER_STATUS.eq(CST.NON_READ))
					.fetch().parallelStream().map(s -> {
							Map<String, String> map = new HashMap<>();
							map.put("submitTime", resetTime(s.value3()));
							map.put("reportId", s.value2());
							map.put("submitUser", s.value1());
							map.put("prompt", "提交了实验报告");
							return map;
						}).collect(Collectors.toList());
			}
			else {
				res = dsl.select(
						DSL.val(Session.getUser().getUserName()), 
						t2.REPORT_ID, 
						DSL.field("date_format({0},'%Y%m%d%H%i%s')", String.class, t2.UPD_TIME)
					)
					.from(t2).leftJoin(t1)
					.on(t2.USER_ID.eq(t1.USER_ID))
					.where(t2.REPORT_STUDENT_STATUS.eq(CST.NON_READ))
					.and(t2.USER_ID.eq(Session.getUser().getUserId()))
					.fetch().parallelStream().map(s -> {
							Map<String, String> map = new HashMap<>();
							map.put("submitTime", resetTime(s.value3()));
							map.put("reportId", s.value2());
							map.put("submitUser", s.value1());
							map.put("prompt", "您的实验报告已经被批阅");
							return map;
						}).collect(Collectors.toList());
			}
			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * resetTime:(重置时间). <br/>
	 * 
	 * @author liboqiang
	 * @param submitTime
	 * @return
	 * @throws ParseException
	 * @since JDK 1.6
	 */
	private String resetTime(String submitTime) {
		try {
			long applyTimeNum = new SimpleDateFormat("yyyyMMddHHmmss").parse(submitTime).getTime();
			long now = new Date().getTime();
			long recTime = (now - applyTimeNum) / 1000;
			if (recTime < 60) {
				return recTime + "秒前";
			} else {
				recTime = recTime / 60;
				if (recTime < 60) {
					return recTime + "分前";
				} else {
					recTime = recTime / 60;
					if (recTime < 24) {
						return recTime + "小时前";
					} else {
						recTime = recTime / 24;
						return recTime + "天前";
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
