package com.jlu.magmalab.action;

import static com.jlu.magmalab.dao.tables.ApplyInfo.APPLY_INFO;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import com.jlu.magmalab.bean.TodoForm;
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
			TmUser result = dsl.selectFrom(TM_USER).where(TM_USER.LOGIN_ID.eq(loginId))
					.and(TM_USER.PASSWORD.eq(password.toUpperCase())).fetchOneInto(TmUser.class);

			if (result != null) {
				Session.getSession().setAttribute("tmUser", result);
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
			if (session.getAttribute("tmUser") == null) {
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
			TmUser res = dsl.selectFrom(TM_USER).where(TM_USER.USER_ID.eq(userId))
					.and(TM_USER.PASSWORD.eq(oldPwd.toUpperCase())).fetchOneInto(TmUser.class);

			if (res == null) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_1, "旧密码验证错误");
			}

			// 2.密码一致性验证
			if (!newPwd.equals(confirmPwd)) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_2, "两次密码不一致,请重新输入");
			}

			// 3.修改密码
			dsl.update(TM_USER).set(TM_USER.PASSWORD, newPwd.toUpperCase())
					.set(TM_USER.PWD_STATUS, CST.PWD_STATUS_ALTERED).where(TM_USER.USER_ID.eq(userId)).execute();

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
			TmUser tmUser = dsl.selectFrom(TM_USER).where(TM_USER.USER_ID.eq(Session.getUser().getUserId()))
					.fetchOneInto(TmUser.class);
			if (CST.PWD_STATUS_INIT == tmUser.getPwdStatus()) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_1);
			}
			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
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
			// 管理员查看所有申请
			if (Session.isSuperAdmin()) {
				List<TodoForm> reslst = dsl
						.select(APPLY_INFO.APPLY_ID,
								DSL.field("date_format({0},'%Y%m%d%H%i%s')", String.class, APPLY_INFO.APPLY_TIME)
										.as("applyTime"),
								APPLY_INFO.APPLY_CAR, APPLY_INFO.PRO_TYPE, TM_USER.USER_NAME.as("applyUser"))
						.from(APPLY_INFO).leftJoin(TM_USER).on(TM_USER.USER_ID.eq(APPLY_INFO.APPLY_USER))
						.where(APPLY_INFO.STATUS.eq(CST.APPLY_STATUS_WAITE)).orderBy(APPLY_INFO.APPLY_TIME).limit(5)
						.fetchInto(TodoForm.class);

				// 添加自定义信息
				reslst.stream().map(apply -> {
					apply.setApplyTime(resetTime(apply.getApplyTime()));
					apply.setProType("发起了报件申请");
					return apply;
				}).collect(Collectors.toList());

				return Ajax.responseString(CST.RES_SUCCESS, reslst);
			} else {
				List<TodoForm> reslst = dsl
						.select(APPLY_INFO.APPLY_ID,
								DSL.field("date_format({0},'%Y%m%d%H%i%s')", String.class, APPLY_INFO.APPLY_TIME)
										.as("applyTime"),
								APPLY_INFO.APPLY_CAR, APPLY_INFO.PRO_TYPE, TM_USER.USER_NAME.as("applyUser"),
								APPLY_INFO.STATUS)
						.from(APPLY_INFO).leftJoin(TM_USER).on(TM_USER.USER_ID.eq(APPLY_INFO.APPLY_USER))
						.where(APPLY_INFO.STATUS.notEqual(CST.APPLY_STATUS_FINISH))
						.and(APPLY_INFO.APPLY_USER.eq(Session.getUser().getUserId())).orderBy(APPLY_INFO.APPLY_TIME)
						.limit(5).fetchInto(TodoForm.class);
				// 添加自定义信息
				reslst.stream().map(apply -> {
					apply.setApplyTime(resetTime(apply.getApplyTime()));
					apply.setApplyUser("我");
					if (CST.APPLY_STATUS_REJECTED == apply.getStatus()) {
						apply.setProType("报件申请被驳回");
					} else {
						apply.setProType("报件申请等待管理员审批中");
					}
					return apply;
				}).collect(Collectors.toList());

				return Ajax.responseString(CST.RES_SUCCESS, reslst);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * resetTime:(重置时间). <br/>
	 * 
	 * @author liboqiang
	 * @param applyTime
	 * @return
	 * @throws ParseException
	 * @since JDK 1.6
	 */
	private String resetTime(String applyTime) {
		try {
			long applyTimeNum = new SimpleDateFormat("yyyyMMddHHmmss").parse(applyTime).getTime();
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
