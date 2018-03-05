package com.jlu.magmalab.bean;

import com.jlu.magmalab.dao.tables.pojos.TmUser;

public class UserForm {

	private TmUser tmUser;
	private int page;
	private int rows;

	/**
	 * tmUser.
	 * 
	 * @return the tmUser
	 * @since JDK 1.6
	 */
	public TmUser getTmUser() {
		return tmUser;
	}

	/**
	 * tmUser.
	 * 
	 * @param tmUser
	 *            the tmUser to set
	 * @since JDK 1.6
	 */
	public void setTmUser(TmUser tmUser) {
		this.tmUser = tmUser;
	}

	/**
	 * page.
	 * 
	 * @return the page
	 * @since JDK 1.6
	 */
	public int getPage() {
		return page;
	}

	/**
	 * page.
	 * 
	 * @param page
	 *            the page to set
	 * @since JDK 1.6
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * rows.
	 * 
	 * @return the rows
	 * @since JDK 1.6
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * rows.
	 * 
	 * @param rows
	 *            the rows to set
	 * @since JDK 1.6
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
}
