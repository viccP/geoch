package com.jlu.magmalab.expr;

import org.ujmp.core.Matrix;

/**
 * 
 * ClassName: Distribute <br/> 
 * Function: 分配系数类. <br/> 
 * date: 2018年3月5日 下午2:33:01 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class Distribute {
	
	/**
	 * 
	* 私有构造函数：Distribute. 
	*
	 */
	private Distribute() {}
	
	/**
	 * 
	 * sigma:(计算总分配系数). <br/> 
	 * D=K1*D1+K2*D2+.....Kn*Dn
	 * 
	 * @author liboqiang
	 * @param singleD
	 * @param percent
	 * @return 
	 * @since JDK 1.6
	 */
	public static Matrix sigma(Matrix singleD,Matrix percent) {
		return percent.mtimes(singleD);
	}

}
