package com.jlu.magmalab.expr.impl;

import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;

/**
 * 
 * ClassName: BM <br/>
 * Function: 部分熔融批量熔融公式. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class BM implements IExpr {

	/**
	 * 
	 * y=c0./(D+F.*(1-P));
	 * 
	 * @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		Matrix P = prm.getP();
		double F = prm.getF();
		return C0.divide(D.plus((P.times(-1).plus(1)).times(F)));
	}
}
