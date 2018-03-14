package com.jlu.magmalab.expr.impl;

import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;

/**
 * 
 * ClassName: CystalExpr <br/>
 * Function: 封闭体系下分离结晶公式. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class FC implements IExpr {

	/**
	 * 
	 * y=c0.*(F.^(D-1));.
	 * 
	 * @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		double F = prm.getF();
		double[] dArray = D.toDoubleArray()[0];
		double[] fPowD = new double[dArray.length];
		for (int i = 0; i < dArray.length; i++) {
			fPowD[i] = Math.pow(F, dArray[i] - 1);
		}
		return C0.times(Matrix.Factory.importFromArray(fPowD));
	}
}
