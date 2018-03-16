package com.jlu.magmalab.expr.impl;

import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;

/**
 * 
 * ClassName: CystalExpr <br/>
 * Function: 开放体系下的AFC(围岩同化作用与分离结晶作用结合的微量元素效应)公式. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class AFC implements IExpr {

	/**
	 * 
	 * z=(r+D-1)./(r-1)
	 * y=c0.*(F.^(-z)+(r./(r-1)).*(ca./(z.*c0)).*(1-F.^(-z)))
	 * 
	 * @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		Matrix CA = prm.getCA();
		double r = prm.getCR();
		double F = prm.getF();
		Matrix zMatrix = D.minus(1).plus(r).divide(r - 1);
		double[] z = zMatrix.toDoubleArray()[0];
		double[] fPowMinusZ = new double[z.length];
		for (int i = 0; i < z.length; i++) {
			fPowMinusZ[i] = Math.pow(F, -z[i]);
		}
		Matrix fPowMinusZMatirx = Matrix.Factory.importFromArray(fPowMinusZ);
		Matrix partA=((CA.divide(C0.times(zMatrix))).times(r/(r-1))).times(fPowMinusZMatirx.times(-1).plus(1));
		return C0.times(fPowMinusZMatirx.plus(partA));
	}
}
