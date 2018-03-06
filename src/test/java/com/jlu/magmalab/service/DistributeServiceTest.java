package com.jlu.magmalab.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jlu.magmalab.bean.Distribute;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"}) 
public class DistributeServiceTest{
	
	@Autowired
	private DistributeService DistributeService;
	
	@Test
	public void test() {
		List<Distribute> res = DistributeService.fetchDistrubute();
		res.parallelStream().forEach(s->System.out.println(s.getDistribute()));
	}
}
