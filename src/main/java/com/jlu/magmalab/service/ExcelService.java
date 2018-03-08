package com.jlu.magmalab.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.jlu.cst.CST;
import com.jlu.exception.BusinessException;
import com.jlu.exception.SystemException;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: ExcelService <br/>
 * Function: Excel处理Service. <br/>
 * date: 2018年3月7日 下午5:11:31 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Service
public class ExcelService {

	/**
	 * 
	 * transferData:(数据转换). <br/>
	 * 
	 * @author liboqiang
	 * @param ins
	 * @param extType
	 * @return
	 * @throws SystemException
	 * @since JDK 1.6
	 */
	public Map<String, List<Map<String, Double>>> transferData(InputStream ins, String extType) throws Exception {
		Workbook workBook = null;
		Map<String, List<Map<String, Double>>> dataMap = new TreeMap<>();
		try {
			if (CST.FILE_TYPE_XLS.equals(extType)) {
				workBook = new HSSFWorkbook(ins);
			} else {
				workBook = new XSSFWorkbook(ins);
			}

			// 定义Excel规则：只取第一个sheet;c1r2起为元素名；r1c2起为样品数据名称；r1c1不储存数据;其余部分为数据
			// 获取第一个sheet
			Sheet sheet = workBook.getSheetAt(0);

			// i:行数 j:列数
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row r = sheet.getRow(i);
				// 元素名称
				String eleName = null;
				for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
					Cell cell = r.getCell(j);

					if (i == 0) {
						if (j > 0) {
							// 设置样品标题
							try {
								String dataTitle = cell.getStringCellValue();
								dataMap.put(Utils.base64Encode(dataTitle), new ArrayList<Map<String, Double>>());
							} catch (Exception e) {
								e.printStackTrace();
								throw new BusinessException("样品名称[" + cell + "]不可识别,请重新填写样品名称");
							}
						}
					} else {
						// 设置元素标题
						if (j == 0) {
							try {
								eleName = cell.getStringCellValue();
								if (!Utils.checkEleName(eleName)) {
									throw new BusinessException("元素名称[" + cell + "]不可识别,请重新填写元素名称,合理的元素名称为[A-Z][a-z]{0,2}(比如:Fe,H)");
								}
							} catch (Exception e) {
								e.printStackTrace();
								throw new BusinessException("元素名称[" + cell + "]不可识别,请重新填写元素名称,合理的元素名称为[A-Z][a-z]{0,2}(比如:Fe,H)");
							}
						} else {
							String dataTitle=sheet.getRow(0).getCell(j).getStringCellValue();
							List<Map<String, Double>> dataLst = dataMap.get(Utils.base64Encode(dataTitle));
							Map<String, Double> tmp = new HashMap<>();
							// 格式检查
							if (dataLst == null) {
								throw new BusinessException("导入Excel格式有误，请检查数据标题和数据列是否一一对应");
							}

							// 取值
							try {
								tmp.put(eleName, cell.getNumericCellValue());
							} catch (Exception e) {
								e.printStackTrace();
								throw new BusinessException("数值[" + cell + "]不可识别,请重新实验数据,合理的实验数据为数值型(比如:0.0085)");
							}
							dataLst.add(tmp);
						}
					}
				}
			}
			return dataMap;
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof SystemException || e instanceof BusinessException) {
				throw e;
			} else {
				throw new SystemException(CST.MSG_SYS_ERR);
			}
		} finally {
			try {
				workBook.close();
			} catch (IOException e) {
				throw new SystemException(CST.MSG_SYS_ERR);
			}
		}
	}
}
