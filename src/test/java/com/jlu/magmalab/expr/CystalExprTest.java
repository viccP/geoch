package com.jlu.magmalab.expr;

import org.junit.Test;
import org.ujmp.core.Matrix;

/**
 * 
 * ClassName: CystalExpr <br/>
 * Function: 结晶公式测试类. <br/>
 * date: 2018年3月5日 上午8:59:07 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class CystalExprTest {

	@Test
	public void testEc() {
		Matrix C0=Matrix.Factory.importFromArray(new double[] {1,2,3,4});
		Matrix D=Matrix.Factory.importFromArray(new double[] {1,2,3,4});
		double F=0.15;
		Matrix res = CrystalExpr.EC(C0, F, D);
		System.out.println(res);
	}
	
}
