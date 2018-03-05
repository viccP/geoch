package com.jlu.exception;

/**
 * 
 * ClassName: SystemException <br/> 
 * Function: 系统异常. <br/> 
 * date: 2018年2月8日 下午1:20:44 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class SystemException  extends RuntimeException {

	/**序列号. **/  
	private static final long serialVersionUID = 1L;
	
	public SystemException(String msg){
		super(msg);
	}
}
