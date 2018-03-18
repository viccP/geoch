package com.jlu.magmalab.expr.impl;

import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;

/**
 * 
 * ClassName: FM <br/>
 * Function: 部分熔融分离熔融公式. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class FM implements IExpr {

	/**
	 * 
	 * y=c0.*((1-P*F/D).^(1./P-1))./D;
	 * 
	 * @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		Matrix P = prm.getP();
		double[] pArray = P.toDoubleArray()[0];
		double F = prm.getF();

		// -PF/D+1
		Matrix A = (P.times(F).divide(D).times(-1)).plus(1);
		double[] aArray = A.toDoubleArray()[0];
		double[] bArray = new double[pArray.length];
		for (int i = 0; i < pArray.length; i++) {
			bArray[i] = Math.pow(aArray[i], (1 / pArray[i] - 1));
		}
		Matrix B = Matrix.Factory.importFromArray(bArray);
		return C0.times(B).divide(D);
	}
}
