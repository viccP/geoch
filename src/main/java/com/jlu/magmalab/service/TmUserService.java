package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.UserForm;
import com.jlu.magmalab.dao.tables.daos.TmUserDao;
import com.jlu.magmalab.dao.tables.pojos.TmUser;
import com.jlu.magmalab.dao.tables.records.TmUserRecord;
import com.jlu.magmalab.page.Page;
import com.jlu.magmalab.page.PageHelper;
import com.jlu.utils.IdGenerator;
import com.jlu.utils.MD5;
import com.jlu.utils.Session;

@Component
public class TmUserService {

	@Autowired
	private TmUserDao tmUserDao;

	@Autowired
	private DefaultDSLContext dsl;

	@Autowired
	private PageHelper<TmUser> pageHelper;

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
	public String edit(TmUser tmUser) {
		try {
			// 判断新增还是更新
			if (StringUtils.isEmpty(tmUser.getUserId())) {
				//验证重复性
				if (tmUserDao.fetchByLoginId(tmUser.getLoginId()).size() != 0) {
					return CST.RES_LOGIC_ERROR_1;
				}
				tmUser.setUpdTime(new Timestamp(System.currentTimeMillis()));
				tmUser.setPassword(MD5.getHash(CST.PWD_DEFAULT));
				tmUser.setPwdStatus(CST.PWD_STATUS_INIT);
				tmUser.setUserId(IdGenerator.genId());
				tmUserDao.insert(tmUser);
			} else {
				tmUser.setUpdTime(new Timestamp(System.currentTimeMillis()));
				TmUser tmp = dsl.selectFrom(TM_USER).where(TM_USER.USER_ID.eq(Session.getUser().getUserId()))
						.fetchOneInto(TmUser.class);
				Integer pwdStatus = tmp.getPwdStatus();
				if(pwdStatus==null) {
					tmUser.setPwdStatus(CST.PWD_STATUS_INIT);
				}else {
					tmUser.setPwdStatus(pwdStatus);
				}
				tmUserDao.update(tmUser);
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
	public Page<TmUser> list(UserForm userForm) {
		try {
			TmUser tmUser = userForm.getTmUser();
			SelectConditionStep<TmUserRecord> sql = dsl.selectFrom(TM_USER).where("1=1");

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
			}

			// 添加排序
			sql.orderBy(TM_USER.UPD_TIME.asc());

			return pageHelper.get(userForm.getPage(), userForm.getRows(), sql, TmUser.class);

		} catch (Exception e) {
			e.printStackTrace();
			return new Page<TmUser>();
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
	public void delete(String userId) {
		try {
			tmUserDao.deleteById(userId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
