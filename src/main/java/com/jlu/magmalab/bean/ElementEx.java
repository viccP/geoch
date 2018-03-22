package com.jlu.magmalab.bean;

import com.jlu.magmalab.dao.tables.pojos.TmElement;

/**
 * 
 * ClassName: ElementEx <br/>
 * Function: 元素扩展类. <br/>
 * date: 2018年3月21日 下午5:14:21 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class ElementEx extends TmElement {

	/** 序列号 **/
	private static final long serialVersionUID = -5989664485534328561L;

	/** 元素值 **/
	private Double elementValue;

	/**
	 * elementValue.
	 * 
	 * @return the elementValue
	 * @since JDK 1.6
	 */
	public Double getElementValue() {
		return elementValue;
	}

	/**
	 * elementValue.
	 * 
	 * @param elementValue
	 *            the elementValue to set
	 * @since JDK 1.6
	 */
	public void setElementValue(Double elementValue) {
		this.elementValue = elementValue;
	}
}
