package com.jlu.magmalab.bean;

public class Select<T> {

	/**编号**/
	private String code;
	
	/**值**/
	private T value;

	/** 
	* code. 
	* 
	* @return  the code 
	* @since   JDK 1.6 
	*/
	public String getCode() {
		return code;
	}

	/** 
	 * code. 
	 * 
	 * @param   code    the code to set 
	 * @since   JDK 1.6 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** 
	* value. 
	* 
	* @return  the value 
	* @since   JDK 1.6 
	*/
	public T getValue() {
		return value;
	}

	/** 
	 * value. 
	 * 
	 * @param   value    the value to set 
	 * @since   JDK 1.6 
	 */
	public void setValue(T value) {
		this.value = value;
	}
}
