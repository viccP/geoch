package com.jlu.magmalab.bean;

/**
 * 
 * ClassName: ReportForm <br/>
 * Function: 实验报告Bean. <br/>
 * date: 2018年4月1日 上午11:03:12 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class ReportForm {

	/** 实验报告ID **/
	private String reportId;
	/** 报告提交人ID **/
	private String userId;
	/** 报告提交人 **/
	private String userName;
	/** 更新时间 **/
	private String updTime;
	/** 报告状态 **/
	private Integer reportStatus;
	/** 报告分数 **/
	private String reportScore;

	/** 分页信息 **/
	private int page;
	private int rows;

	/**
	 * reportId.
	 * 
	 * @return the reportId
	 * @since JDK 1.6
	 */
	public String getReportId() {
		return reportId;
	}

	/**
	 * reportId.
	 * 
	 * @param reportId
	 *            the reportId to set
	 * @since JDK 1.6
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	/**
	 * userName.
	 * 
	 * @return the userName
	 * @since JDK 1.6
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * userName.
	 * 
	 * @param userName
	 *            the userName to set
	 * @since JDK 1.6
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * updTime.
	 * 
	 * @return the updTime
	 * @since JDK 1.6
	 */
	public String getUpdTime() {
		return updTime;
	}

	/**
	 * updTime.
	 * 
	 * @param updTime
	 *            the updTime to set
	 * @since JDK 1.6
	 */
	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}

	/**
	 * reportStatus.
	 * 
	 * @return the reportStatus
	 * @since JDK 1.6
	 */
	public Integer getReportStatus() {
		return reportStatus;
	}

	/**
	 * reportStatus.
	 * 
	 * @param reportStatus
	 *            the reportStatus to set
	 * @since JDK 1.6
	 */
	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	/**
	 * reportScore.
	 * 
	 * @return the reportScore
	 * @since JDK 1.6
	 */
	public String getReportScore() {
		return reportScore;
	}

	/**
	 * reportScore.
	 * 
	 * @param reportScore
	 *            the reportScore to set
	 * @since JDK 1.6
	 */
	public void setReportScore(String reportScore) {
		this.reportScore = reportScore;
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

	/**
	 * userId.
	 * 
	 * @return the userId
	 * @since JDK 1.6
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userId.
	 * 
	 * @param userId
	 *            the userId to set
	 * @since JDK 1.6
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
