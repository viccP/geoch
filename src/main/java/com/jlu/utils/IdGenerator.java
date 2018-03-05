package com.jlu.utils;

import java.util.UUID;

/**
 * 
 * ClassName: IdGenerator <br/> 
 * Function: ID生成器. <br/> 
 * date: 2017年10月11日 下午10:44:43 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class IdGenerator {
	public static String genId() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
