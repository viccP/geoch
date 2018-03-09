package com.jlu.magmalab.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ujmp.core.Matrix;

import com.jlu.SpringTest;
import com.jlu.cst.CST;

public class ExcelServiceTest extends SpringTest {

	@Autowired
	private ExcelService excelService;

	@Test
	public void test() {

		try {
			File file = new File("/Users/lbqrcy/Downloads/测试数据1.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Map<String, List<Map<String, Double>>> dataMap = excelService.transferData(fileInputStream, "xlsx");

			List<Map<String, Double>> sampleData = dataMap.get("57qi5peX5bKtMDE=");

			List<Double> simpleReeData = sampleData.parallelStream().filter(s -> CST.REE_ELE_NAME_ARRAY.contains(s.keySet().stream().findFirst().get())).sorted((s1, s2) -> {
				int io1 = CST.REE_ELE_NAME_ARRAY.indexOf(s1.keySet().stream().findFirst().get());
				int io2 = CST.REE_ELE_NAME_ARRAY.indexOf(s2.keySet().stream().findFirst().get());
				return io1 - io2;
			}).map(s->s.values().parallelStream().findFirst().get()).collect(Collectors.toList());

			// 转为矩阵
			Matrix stdDataMatix = Matrix.Factory.importFromArray(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 });
			Matrix simpleReeDataMatix = Matrix.Factory.importFromArray(simpleReeData.toArray());

			// 样品数据除以标准化值
			Matrix reeRes = simpleReeDataMatix.divide(stdDataMatix);
			double[] res = reeRes.toDoubleArray()[0];
			
			//
			// File file = new File("/Users/lbqrcy/Downloads/parameters1.xls");
			// FileInputStream fileInputStream = new FileInputStream(file);
			// excelService.transferData(fileInputStream,"xls",0);
			System.out.println(simpleReeDataMatix);
			System.out.println(stdDataMatix);
			System.out.println(reeRes);
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
