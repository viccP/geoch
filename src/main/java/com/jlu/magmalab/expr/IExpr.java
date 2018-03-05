package com.jlu.magmalab.expr;

import org.ujmp.core.Matrix;

/**
 * 
 * ClassName: IExpr <br/> 
 * Function: 公式接口. <br/> 
 * date: 2018年3月5日 下午1:18:43 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public interface IExpr {
	

	/**
	 * 
	 * expr:(公式接口). <br/> 
	 * 
	 * @author liboqiang
	 * @param prm 参数
	 * @return 
	 * @since JDK 1.6
	 */
	public Matrix expr(Parameter prm);

}
