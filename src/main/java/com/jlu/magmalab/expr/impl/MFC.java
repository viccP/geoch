package com.jlu.magmalab.expr.impl;

import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;

/**
 * 
 * ClassName: FMC <br/>
 * Function: 开放体系下先分离结晶后混染. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class MFC implements IExpr {

	/**
	 * 
	 * y=(c0*(1-R)+R*ca).*(F.^(D-1))
	 * 
	 * @see com.jlu.magmalab.expr.IExpr#expr(com.jlu.magmalab.expr.Parameter)
	 */
	public Matrix expr(Parameter prm) {
		Matrix C0 = prm.getC0();
		Matrix D = prm.getD();
		Matrix CA = prm.getCA();
		double F = prm.getF();
		double R = prm.getMR();
		double[] dArray = D.toDoubleArray()[0];
		double[] fPowD = new double[dArray.length];
		for (int i = 0; i < dArray.length; i++) {
			fPowD[i] = Math.pow(F, dArray[i] - 1);
		}
		Matrix fPowDMatrix = Matrix.Factory.importFromArray(fPowD);
		return (C0.times(1-R).plus(CA.times(R))).times(fPowDMatrix);
	}
}
