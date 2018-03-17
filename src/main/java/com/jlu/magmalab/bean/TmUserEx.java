package com.jlu.magmalab.bean;

import com.jlu.magmalab.dao.tables.pojos.TmUser;

public class TmUserEx extends TmUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7263061485104722473L;

	/** 角色ID **/
	private String roleId;
	
	/** 角色名称 **/
	private String roleName;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
