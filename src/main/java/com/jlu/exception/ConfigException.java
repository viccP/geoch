package com.jlu.exception;

/**
 * 
 * ClassName: ConfigException <br/> 
 * Function: 配置类异常. <br/> 
 * date: 2018年2月8日 下午1:20:44 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class ConfigException  extends RuntimeException {

	/**序列号. **/  
	private static final long serialVersionUID = 1L;
	
	public ConfigException(String msg){
		super(msg);
	}
}
