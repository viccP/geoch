package com.jlu.exception;

/**
 * 
 * ClassName: BusinessException <br/> 
 * Function: 业务异常. <br/> 
 * date: 2018年3月8日 下午12:15:57 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class BusinessException extends RuntimeException {

	/** 序列号. **/
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
}
