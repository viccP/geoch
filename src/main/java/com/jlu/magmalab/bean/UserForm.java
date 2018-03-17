package com.jlu.magmalab.bean;

public class UserForm {

	private TmUserEx tmUser;
	private int page;
	private int rows;
	public TmUserEx getTmUser() {
		return tmUser;
	}
	public void setTmUser(TmUserEx tmUser) {
		this.tmUser = tmUser;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
}
