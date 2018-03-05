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
public class EC implements IExpr {

	/**
	 *  ec:(封闭体系下平衡结晶公式).
	 *   y=C0/(F+D*(1-F))
	* TODO 简单描述该方法的实现功能（可选）. 
	* @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		double F = prm.getF();
		return C0.divide(D.times(1 - F).plus(F));
	}
}
