package com.jlu.magmalab.expr;

import org.junit.Test;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;

public class SigamaDTest {
	
	@Test
	public void test() {
		Matrix d=SparseMatrix.Factory.randn(10,9);
		Matrix percent=Matrix.Factory.importFromArray(new double[] {0.9,0.1,0,0,0,0,0,0,0});
		System.out.println(d);
		System.out.println(percent);
		System.out.println(SigamaD.sigma(d, percent));
	}

}