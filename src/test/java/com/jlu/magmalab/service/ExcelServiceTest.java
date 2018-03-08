package com.jlu.magmalab.service;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jlu.SpringTest;

public class ExcelServiceTest extends SpringTest {

	@Autowired
	private ExcelService excelService;

	@Test
	public void test() {

		try {
			File file = new File("/Users/lbqrcy/Downloads/测试数据1.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			excelService.transferData(fileInputStream,"xlsx");
//			File file = new File("/Users/lbqrcy/Downloads/parameters1.xls");
//			FileInputStream fileInputStream = new FileInputStream(file);
//			excelService.transferData(fileInputStream,"xls",0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
