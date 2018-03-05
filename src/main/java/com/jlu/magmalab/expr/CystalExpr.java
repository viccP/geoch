package com.jlu.magmalab.expr;

import org.ujmp.core.Matrix;

/**
 * 
 * ClassName: CystalExpr <br/>
 * Function: 结晶公式. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class CystalExpr {

	/**
	 * 
	 * 私有构造函数：CystalExpr.
	 *
	 */
	private CystalExpr() {
	}

	/**
	 * 
	 * ec:(封闭体系下平衡结晶公式). <br/>
	 * y=C0/(F+D*(1-F))
	 * 
	 * @author liboqiang
	 * @param c0
	 * @param f
	 * @param d
	 * @return
	 * @since JDK 1.6
	 */
	public static Matrix EC(Matrix C0, double F, Matrix D) {
		return C0.divide(D.times(1-F).plus(F));
	}
}
