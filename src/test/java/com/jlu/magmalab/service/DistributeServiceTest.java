package com.jlu.magmalab.service;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ujmp.core.Matrix;

import com.jlu.SpringTest;
import com.jlu.cst.CST;

public class DistributeServiceTest extends SpringTest {

	@Autowired
	private DistributeService distributeService;

	@Test
	public void test() {
		CST.GLOBAL_DIST_LIST=distributeService.fetchDistrubute();
		Matrix res = distributeService.sigma(Arrays.asList(new Double[]{0.9,0.1,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0}),1, CST.REE_ELE_INDEX_ARRAY);
		System.out.println(res);
	}
}
