package com.jlu.magmalab.action;

import static com.jlu.magmalab.dao.tables.TmRole.TM_ROLE;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;
import static com.jlu.magmalab.dao.tables.TmUserRole.TM_USER_ROLE;

import java.sql.Timestamp;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.TmUserEx;
import com.jlu.magmalab.bean.UserForm;
import com.jlu.magmalab.dao.tables.daos.TmUserDao;
import com.jlu.magmalab.dao.tables.pojos.TmUser;
import com.jlu.magmalab.page.Page;
import com.jlu.magmalab.service.TmUserService;
import com.jlu.utils.Ajax;
import com.jlu.utils.MD5;
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
@RequestMapping(value = "/user")
public class UserAction {

	@Autowired
	private TmUserService tmUserService;
	
	@Autowired
	private DefaultDSLContext dsl;

	@Autowired
	private TmUserDao tmUserDao;

	/**
	 * 
	 * add:(新增用户). <br/>
	 * 
	 * @author liboqiang
	 * @param tmUser
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String edit(@RequestBody TmUserEx tmUser) {
		try {
			if (tmUser.getSex() == null) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_2);
			}
			if (tmUser.getRoleId() == null) {
				return Ajax.responseString(CST.RES_LOGIC_ERROR_3);
			}
			String status = tmUserService.edit(tmUser);
			return Ajax.responseString(status, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * list:(查询用户列表). <br/>
	 * 
	 * @author liboqiang
	 * @param tmUser
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String list(@RequestBody UserForm userForm) {
		try {
			// 0.身份认证
			if (!Session.isSuperAdmin()) {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, "抱歉您没有权限");
			}

			// 1.查询数据
			Page<TmUserEx> pageBean = tmUserService.list(userForm);
			return Ajax.responseString(CST.RES_SUCCESS, pageBean, true);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * delete:(删除用户). <br/>
	 * 
	 * @author liboqiang
	 * @param userId
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String delete(String userId,String roleId) {
		try {
			// 1.查询数据
			tmUserService.delete(userId,roleId);
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	/**
	 * 
	 * get:(获取用户). <br/>
	 * 
	 * @author liboqiang
	 * @param userId
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String get(String userId,String roleId) {
		try {
			// 0.参数调整
			userId = (userId == null ? Session.getUser().getUserId() : userId);
			// 1.查询数据
			TmUserEx tmUser = dsl
					.select(
							TM_USER.LOGIN_ID,
							TM_USER.SEX,
							TM_USER.MEMO,
							TM_USER.PHONE_NO,
							TM_USER.USER_ID,
							TM_USER.USER_NAME,
							TM_ROLE.ROLE_ID
					 )
					.from(TM_USER)
					.leftJoin(TM_USER_ROLE).on(TM_USER.USER_ID.eq(TM_USER_ROLE.USER_ID).and(TM_USER_ROLE.ROLE_ID.eq(roleId)))
					.leftJoin(TM_ROLE).on(TM_USER_ROLE.ROLE_ID.eq(TM_ROLE.ROLE_ID))
					.where(TM_USER.USER_ID.eq(userId))
					.fetchOneInto(TmUserEx.class);
			
			return Ajax.responseString(CST.RES_SUCCESS, tmUser);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

	@RequestMapping(value = "/initPwd", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String initPwd(String userId) {
		try {
			// 1.查询数据
			TmUser tmUser = tmUserDao.fetchOneByUserId(userId);
			tmUser.setPassword(MD5.getHash(CST.PWD_DEFAULT));
			tmUser.setPwdStatus(CST.PWD_STATUS_INIT);
			tmUser.setUpdTime(new Timestamp(System.currentTimeMillis()));
			tmUserDao.update(tmUser);
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "初始化密码成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

}
