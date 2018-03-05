package com.jlu.magmalab.expr;

import org.junit.Test;
import org.ujmp.core.Matrix;

import com.jlu.magmalab.expr.impl.EC;

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
public class ECTest {

	@Test
	public void testEc() {
		Matrix C0=Matrix.Factory.importFromArray(new double[] {1,2,3,4});
		Matrix D=Matrix.Factory.importFromArray(new double[] {1,2,3,4});
		double F=0.15;
		Parameter prm=new Parameter();
		prm.setC0(C0);
		prm.setD(D);
		prm.setF(F);
		Matrix res = new EC().expr(prm);
		System.out.println(res);
	}
	
}
