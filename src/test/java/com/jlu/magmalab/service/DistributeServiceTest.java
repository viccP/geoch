package com.jlu.magmalab.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jlu.SpringTest;
import com.jlu.magmalab.bean.Distribute;

public class DistributeServiceTest extends SpringTest {

	@Autowired
	private DistributeService DistributeService;

	@Test
	public void test() {
		List<Distribute> res = DistributeService.fetchDistrubute();
		res.parallelStream().forEach(s -> System.out.println(s.getDistribute()));
	}
}
