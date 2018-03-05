package com.jlu.magmalab.bean;

public class TodoForm {
	private String applyId;
	private String proType;
	private String applyCar;
	private String applyUser;
	private String applyTime;
	private Integer status;
	private String rejectMsg;
	private String loanVal;
	private boolean isAdmin;
	private int page;
	private int rows;

	/**
	 * applyId.
	 * 
	 * @return the applyId
	 * @since JDK 1.6
	 */
	public String getApplyId() {
		return applyId;
	}

	/**
	 * applyId.
	 * 
	 * @param applyId
	 *            the applyId to set
	 * @since JDK 1.6
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	/**
	 * applyUser.
	 * 
	 * @return the applyUser
	 * @since JDK 1.6
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * applyUser.
	 * 
	 * @param applyUser
	 *            the applyUser to set
	 * @since JDK 1.6
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/**
	 * applyTime.
	 * 
	 * @return the applyTime
	 * @since JDK 1.6
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * applyTime.
	 * 
	 * @param applyTime
	 *            the applyTime to set
	 * @since JDK 1.6
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/** 
	* status. 
	* 
	* @return  the status 
	* @since   JDK 1.6 
	*/
	public Integer getStatus() {
		return status;
	}

	/** 
	 * status. 
	 * 
	 * @param   status    the status to set 
	 * @since   JDK 1.6 
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/** 
	* rejectMsg. 
	* 
	* @return  the rejectMsg 
	* @since   JDK 1.6 
	*/
	public String getRejectMsg() {
		return rejectMsg;
	}

	/** 
	 * rejectMsg. 
	 * 
	 * @param   rejectMsg    the rejectMsg to set 
	 * @since   JDK 1.6 
	 */
	public void setRejectMsg(String rejectMsg) {
		this.rejectMsg = rejectMsg;
	}


	/** 
	* page. 
	* 
	* @return  the page 
	* @since   JDK 1.6 
	*/
	public int getPage() {
		return page;
	}

	/** 
	 * page. 
	 * 
	 * @param   page    the page to set 
	 * @since   JDK 1.6 
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/** 
	* rows. 
	* 
	* @return  the rows 
	* @since   JDK 1.6 
	*/
	public int getRows() {
		return rows;
	}

	/** 
	 * rows. 
	 * 
	 * @param   rows    the rows to set 
	 * @since   JDK 1.6 
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/** 
	* isAdmin. 
	* 
	* @return  the isAdmin 
	* @since   JDK 1.6 
	*/
	public boolean isAdmin() {
		return isAdmin;
	}

	/** 
	 * isAdmin. 
	 * 
	 * @param   isAdmin    the isAdmin to set 
	 * @since   JDK 1.6 
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/** 
	* proType. 
	* 
	* @return  the proType 
	* @since   JDK 1.6 
	*/
	public String getProType() {
		return proType;
	}

	/** 
	 * proType. 
	 * 
	 * @param   proType    the proType to set 
	 * @since   JDK 1.6 
	 */
	public void setProType(String proType) {
		this.proType = proType;
	}

	/** 
	* applyCar. 
	* 
	* @return  the applyCar 
	* @since   JDK 1.6 
	*/
	public String getApplyCar() {
		return applyCar;
	}

	/** 
	 * applyCar. 
	 * 
	 * @param   applyCar    the applyCar to set 
	 * @since   JDK 1.6 
	 */
	public void setApplyCar(String applyCar) {
		this.applyCar = applyCar;
	}

	/** 
	* loanVal. 
	* 
	* @return  the loanVal 
	* @since   JDK 1.6 
	*/
	public String getLoanVal() {
		return loanVal;
	}

	/** 
	 * loanVal. 
	 * 
	 * @param   loanVal    the loanVal to set 
	 * @since   JDK 1.6 
	 */
	public void setLoanVal(String loanVal) {
		this.loanVal = loanVal;
	}
}
