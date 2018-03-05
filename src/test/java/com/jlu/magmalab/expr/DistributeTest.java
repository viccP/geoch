package com.jlu.magmalab.expr;

import org.junit.Test;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;

public class DistributeTest {
	
	@Test
	public void test() {
		Matrix d=SparseMatrix.Factory.randn(9,10);
		Matrix percent=Matrix.Factory.importFromArray(new double[] {0.9,0.1,0,0,0,0,0,0,0});
		System.out.println(d);
		System.out.println(Distribute.sigma(d, percent));
	}

}
