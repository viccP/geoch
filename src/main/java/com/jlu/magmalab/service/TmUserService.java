package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmRole.TM_ROLE;
import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;
import static com.jlu.magmalab.dao.tables.TmUserRole.TM_USER_ROLE;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record3;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.TmUserEx;
import com.jlu.magmalab.bean.UserForm;
import com.jlu.magmalab.dao.tables.daos.TmUserDao;
import com.jlu.magmalab.dao.tables.daos.TmUserRoleDao;
import com.jlu.magmalab.dao.tables.pojos.TmUserRole;
import com.jlu.magmalab.page.Page;
import com.jlu.magmalab.page.PageHelper;
import com.jlu.utils.MD5;
import com.jlu.utils.Utils;

@Component
public class TmUserService {

	@Autowired
	private TmUserDao tmUserDao;

	@Autowired
	private TmUserRoleDao tmUserRoleDao;

	@Autowired
	private DefaultDSLContext dsl;

	@Autowired
	private PageHelper<TmUserEx> pageHelper;

	/**
	 * 
	 * edit:(编辑用户). <br/>
	 * 
	 * @author liboqiang
	 * @param tmUser
	 * @return
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public String edit(TmUserEx tmUser) {

		try {
			// 判断新增还是更新
			if (StringUtils.isEmpty(tmUser.getUserId())) {
				// 验证重复性
				if (tmUserDao.fetchByLoginId(tmUser.getLoginId()).size() != 0) {
					return CST.RES_LOGIC_ERROR_1;
				}

				// 插入用户表
				String userId = Utils.genId();
				tmUser.setUpdTime(new Timestamp(System.currentTimeMillis()));
				tmUser.setPassword(MD5.getHash(CST.PWD_DEFAULT));
				tmUser.setPwdStatus(CST.PWD_STATUS_INIT);
				tmUser.setUserId(userId);
				tmUserDao.insert(tmUser);

				// 插入用户角色表
				TmUserRole userRole = new TmUserRole();
				userRole.setRoleId(tmUser.getRoleId());
				userRole.setUserId(userId);
				tmUserRoleDao.insert(userRole);
			} else {
				// 获取用户ID
				String userId = tmUser.getUserId();
				// 获取角色ID
				String roleId = tmUser.getRoleId();
				// 设置更新时间
				tmUser.setUpdTime(new Timestamp(System.currentTimeMillis()));
				// 根据用户ID查询用户不可修改的属性
				Record3<String, Integer, String> userConstPro =
						dsl.select(TM_USER.PASSWORD, TM_USER.PWD_STATUS, TM_USER.LOGIN_ID).from(TM_USER).where(TM_USER.USER_ID.eq(userId)).fetchOne();
				// 设置用户密码
				tmUser.setPassword(userConstPro.value1());
				// 设置用户密码状态
				tmUser.setPwdStatus(userConstPro.value2());
				// 设置用户登录Id
				if (StringUtils.isEmpty(tmUser.getLoginId())) {
					tmUser.setLoginId(userConstPro.value3());
				}
				// 更新用户表
				tmUserDao.update(tmUser);

				if (!StringUtils.isEmpty(roleId)) {
					// 删除用户的角色信息
					dsl.deleteFrom(TM_USER_ROLE).where(TM_USER_ROLE.USER_ID.eq(userId)).execute();
					// 插入用户的角色信息
					dsl.insertInto(TM_USER_ROLE, TM_USER_ROLE.USER_ID, TM_USER_ROLE.ROLE_ID).values(userId, roleId).execute();
				}
			}
			return CST.RES_AUTO_DIALOG;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * list:(查询用户). <br/>
	 * 
	 * @author liboqiang
	 * @param userForm.getTmUser()
	 * @return
	 * @since JDK 1.6
	 */
	public Page<TmUserEx> list(UserForm userForm) {
		try {
			TmUserEx tmUser = userForm.getTmUser();
			SelectConditionStep<?> sql = dsl
					.select(TM_USER.LOGIN_ID, TM_USER.MEMO, TM_USER.PHONE_NO, TM_USER.PWD_STATUS, TM_USER.SEX, TM_USER.UPD_TIME, TM_USER.USER_ID,
							TM_USER.USER_NAME, TM_ROLE.ROLE_NAME, TM_ROLE.ROLE_ID)
					.from(TM_USER).leftJoin(TM_USER_ROLE).on(TM_USER.USER_ID.eq(TM_USER_ROLE.USER_ID)).leftJoin(TM_ROLE)
					.on(TM_USER_ROLE.ROLE_ID.eq(TM_ROLE.ROLE_ID)).where("1=1");

			if (tmUser != null) {
				// 用户登录ID是否为空
				if (!StringUtils.isEmpty(tmUser.getLoginId())) {
					sql.and(TM_USER.LOGIN_ID.contains(tmUser.getLoginId()));
				}

				// 用户登录ID是否为空
				if (!StringUtils.isEmpty(tmUser.getUserName())) {
					sql.and(TM_USER.USER_NAME.contains(tmUser.getUserName()));
				}

				// 性别是否为空
				if (tmUser.getSex() != null) {
					sql.and(TM_USER.SEX.eq(tmUser.getSex()));
				}

				// 密码状态是否为空
				if (tmUser.getPwdStatus() != null) {
					sql.and(TM_USER.PWD_STATUS.eq(tmUser.getPwdStatus()));
				}

				// 角色是否为空
				if (!StringUtils.isEmpty(tmUser.getRoleId())) {
					sql.and(TM_ROLE.ROLE_ID.eq(tmUser.getRoleId()));
				}
			}

			// 添加排序
			sql.orderBy(TM_USER.UPD_TIME.asc());

			return pageHelper.get(userForm.getPage(), userForm.getRows(), sql, TmUserEx.class);

		} catch (Exception e) {
			e.printStackTrace();
			return new Page<TmUserEx>();
		}
	}

	/**
	 * 
	 * delete:(删除用户). <br/>
	 * 
	 * @author liboqiang
	 * @param userId
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String userId, String roleId) {
		try {
			// 删除用户
			tmUserDao.deleteById(userId);

			// 删除角色
			dsl.deleteFrom(TM_USER_ROLE).where(TM_USER_ROLE.USER_ID.eq(userId)).and(TM_USER_ROLE.ROLE_ID.eq(roleId)).execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
