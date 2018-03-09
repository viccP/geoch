package com.jlu.magmalab.bean;

/**
 * 
 * ClassName: Series <br/>
 * Function: Echart数据系列. <br/>
 * date: 2018年3月8日 下午6:55:00 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class Series {

	/** 系列值 **/
	private String name;

	/** 类型 **/
	private String type;

	/** 堆积值 **/
	private String stack;

	/** 数据 **/
	private double[] data;

	/** 
	* name. 
	* 
	* @return  the name 
	* @since   JDK 1.6 
	*/
	public String getName() {
		return name;
	}

	/** 
	 * name. 
	 * 
	 * @param   name    the name to set 
	 * @since   JDK 1.6 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	* type. 
	* 
	* @return  the type 
	* @since   JDK 1.6 
	*/
	public String getType() {
		return type;
	}

	/** 
	 * type. 
	 * 
	 * @param   type    the type to set 
	 * @since   JDK 1.6 
	 */
	public void setType(String type) {
		this.type = type;
	}

	/** 
	* stack. 
	* 
	* @return  the stack 
	* @since   JDK 1.6 
	*/
	public String getStack() {
		return stack;
	}

	/** 
	 * stack. 
	 * 
	 * @param   stack    the stack to set 
	 * @since   JDK 1.6 
	 */
	public void setStack(String stack) {
		this.stack = stack;
	}

	/** 
	* data. 
	* 
	* @return  the data 
	* @since   JDK 1.6 
	*/
	public double[] getData() {
		return data;
	}

	/** 
	 * data. 
	 * 
	 * @param   data    the data to set 
	 * @since   JDK 1.6 
	 */
	public void setData(double[] data) {
		this.data = data;
	}
}
