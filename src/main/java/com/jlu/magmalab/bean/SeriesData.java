package com.jlu.magmalab.bean;

import java.util.List;

/**
 * 
 * ClassName: SeriesData <br/>
 * Function: 系列值. <br/>
 * date: 2018年3月12日 下午4:43:03 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class SeriesData {

	/** 稀土元素 **/
	private List<Series> ree;

	/** 微量元素 **/
	private List<Series> trace;

	/** 标准化值Id **/
	private String stdId;

	/** 
	* ree. 
	* 
	* @return  the ree 
	* @since   JDK 1.6 
	*/
	public List<Series> getRee() {
		return ree;
	}

	/** 
	 * ree. 
	 * 
	 * @param   ree    the ree to set 
	 * @since   JDK 1.6 
	 */
	public void setRee(List<Series> ree) {
		this.ree = ree;
	}

	/** 
	* trace. 
	* 
	* @return  the trace 
	* @since   JDK 1.6 
	*/
	public List<Series> getTrace() {
		return trace;
	}

	/** 
	 * trace. 
	 * 
	 * @param   trace    the trace to set 
	 * @since   JDK 1.6 
	 */
	public void setTrace(List<Series> trace) {
		this.trace = trace;
	}

	/** 
	* stdId. 
	* 
	* @return  the stdId 
	* @since   JDK 1.6 
	*/
	public String getStdId() {
		return stdId;
	}

	/** 
	 * stdId. 
	 * 
	 * @param   stdId    the stdId to set 
	 * @since   JDK 1.6 
	 */
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
}
