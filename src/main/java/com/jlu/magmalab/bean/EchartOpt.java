package com.jlu.magmalab.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class EchartOpt implements Serializable {

	/** 序列号. **/
	private static final long serialVersionUID = 1L;

	/** 稀土元素数据 **/
	private List<Serie> ree;

	/** 微量元素数据 **/
	private List<Serie> trace;

	/** 图例名称 **/
	private List<String> legend;

	/**
	 * 
	 * 构造函数：EchartOpt.
	 *
	 */
	public EchartOpt() {
		this.ree = new ArrayList<>();
		this.trace = new ArrayList<>();
		this.legend = new ArrayList<>();
	}

	/**
	 * ree.
	 * 
	 * @return the ree
	 * @since JDK 1.6
	 */
	public List<Serie> getRee() {
		return ree;
	}

	/**
	 * ree.
	 * 
	 * @param ree
	 *            the ree to set
	 * @since JDK 1.6
	 */
	public void setRee(List<Serie> ree) {
		this.ree = ree;
	}

	/**
	 * trace.
	 * 
	 * @return the trace
	 * @since JDK 1.6
	 */
	public List<Serie> getTrace() {
		return trace;
	}

	/**
	 * trace.
	 * 
	 * @param trace
	 *            the trace to set
	 * @since JDK 1.6
	 */
	public void setTrace(List<Serie> trace) {
		this.trace = trace;
	}

	/**
	 * legend.
	 * 
	 * @return the legend
	 * @since JDK 1.6
	 */
	public List<String> getLegend() {
		return legend;
	}

	/**
	 * legend.
	 * 
	 * @param legend
	 *            the legend to set
	 * @since JDK 1.6
	 */
	public void setLegend(List<String> legend) {
		this.legend = legend;
	}
}
