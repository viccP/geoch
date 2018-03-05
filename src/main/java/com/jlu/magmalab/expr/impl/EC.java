package com.jlu.magmalab.expr.impl;

import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;

/**
 * 
 * ClassName: CystalExpr <br/>
 * Function: 封闭体系下平衡结晶公式. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class EC implements IExpr {


	/**
	 * 
	* y=C0/(F+D*(1-F)). 
	* @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		double F = prm.getF();
		return C0.divide(D.times(1 - F).plus(F));
	}
}
