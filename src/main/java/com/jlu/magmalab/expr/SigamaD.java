package com.jlu.magmalab.expr;

import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation.Ret;

/**
 * 
 * ClassName: SigamaD <br/>
 * Function: 分配系数类. <br/>
 * date: 2018年3月5日 下午2:33:01 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class SigamaD {

	/**
	 * 
	 * 私有构造函数：SigamaD.
	 *
	 */
	private SigamaD() {
	}

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
	public static Matrix sigma(Matrix singleD, Matrix percent) {
		Matrix res = Matrix.Factory.emptyMatrix();
		for (int i = 0; i < singleD.getRowCount(); i++) {
			Matrix singleElmD = singleD.selectRows(Ret.NEW, i);
			Matrix singleElmMineralD = singleElmD.times(percent);
			res = res.appendVertically(Ret.NEW, singleElmMineralD);
		}
		return res.sum(Ret.NEW, Matrix.COLUMN, true);
	}
}
