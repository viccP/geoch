package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmStdValue.TM_STD_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlu.magmalab.dao.tables.pojos.TmStdValue;

/**
 * 
 * ClassName: CommonService <br/>
 * Function: 通用类Service. <br/>
 * date: 2018年3月13日 上午8:41:38 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Service
public class CommonService {

	@Autowired
	private DefaultDSLContext dsl;

	/**
	 * 
	 * getStdData:(获取标准化值). <br/>
	 * 
	 * @author liboqiang
	 * @param eleIndexArray
	 * @param stdId
	 * @return
	 * @since JDK 1.6
	 */
	public List<Double> getStdData(List<Integer> eleIndexArray, String stdId) {
		// 获取标准化值
		return dsl.select(TM_STD_VALUE.STD_VALUE, TM_STD_VALUE.ELE_INDEX).from(TM_STD_VALUE).where(TM_STD_VALUE.ELE_INDEX.in(eleIndexArray)).and(TM_STD_VALUE.STD_ID.eq(stdId)).fetchInto(TmStdValue.class).stream().sorted((s1, s2) -> {
			int io1 = eleIndexArray.indexOf(s1.getEleIndex());
			int io2 = eleIndexArray.indexOf(s2.getEleIndex());
			return io1 - io2;
		}).map(s -> s.getStdValue()).collect(Collectors.toList());
	}
}
