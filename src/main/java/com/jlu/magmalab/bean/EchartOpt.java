package com.jlu.magmalab.bean;

/**
 * 
 * ClassName: EchartOpt <br/>
 * Function: Echart数据配置. <br/>
 * date: 2018年3月8日 下午6:51:48 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class EchartOpt {

	/** 数据标题 **/
	private String legend;

	/** 稀土元素数据 **/
	private Series reeSeries;

	/** 微量元素数据 **/
	private Series traceSeries;

	/** 
	* legend. 
	* 
	* @return  the legend 
	* @since   JDK 1.6 
	*/
	public String getLegend() {
		return legend;
	}

	/** 
	 * legend. 
	 * 
	 * @param   legend    the legend to set 
	 * @since   JDK 1.6 
	 */
	public void setLegend(String legend) {
		this.legend = legend;
	}

	/** 
	* reeSeries. 
	* 
	* @return  the reeSeries 
	* @since   JDK 1.6 
	*/
	public Series getReeSeries() {
		return reeSeries;
	}

	/** 
	 * reeSeries. 
	 * 
	 * @param   reeSeries    the reeSeries to set 
	 * @since   JDK 1.6 
	 */
	public void setReeSeries(Series reeSeries) {
		this.reeSeries = reeSeries;
	}

	/** 
	* traceSeries. 
	* 
	* @return  the traceSeries 
	* @since   JDK 1.6 
	*/
	public Series getTraceSeries() {
		return traceSeries;
	}

	/** 
	 * traceSeries. 
	 * 
	 * @param   traceSeries    the traceSeries to set 
	 * @since   JDK 1.6 
	 */
	public void setTraceSeries(Series traceSeries) {
		this.traceSeries = traceSeries;
	}
}
