package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmBasicDataValue.TM_BASIC_DATA_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlu.cst.CST;
import com.jlu.magmalab.dao.tables.pojos.TmBasicDataValue;;

/**
 * 
 * ClassName: LabService <br/>
 * Function: 实验类Service. <br/>
 * date: 2018年3月13日 上午8:41:38 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Service
public class LabService {

	@Autowired
	private DefaultDSLContext dsl;

	/**
	 * 
	 * getBasicData:(获取基础数据). <br/>
	 * 
	 * @author liboqiang
	 * @param eleIndexArray
	 * @param stdId
	 * @return
	 * @since JDK 1.6
	 */
	public List<Double> getBasicData(List<Integer> eleIndexArray, String dataId) {
		return dsl.select(TM_BASIC_DATA_VALUE.DATA_VALUE, TM_BASIC_DATA_VALUE.ELE_INDEX).from(TM_BASIC_DATA_VALUE).where(TM_BASIC_DATA_VALUE.ELE_INDEX.in(eleIndexArray)).and(TM_BASIC_DATA_VALUE.DATA_ID.eq(dataId)).fetchInto(TmBasicDataValue.class).stream().sorted((s1, s2) -> {
			int io1 = eleIndexArray.indexOf(s1.getEleIndex());
			int io2 = eleIndexArray.indexOf(s2.getEleIndex());
			return io1 - io2;
		}).map(s -> s.getDataValue()).collect(Collectors.toList());
	}


	/**
	 * 
	 * getMixData:(获取混染物数据). <br/>
	 * 
	 * @author liboqiang
	 * @param eleIndexArray
	 * @param initialId
	 * @return
	 * @since JDK 1.6
	 */
	public List<Double> getMixData(List<Integer> eleIndexArray, String mixId) {
		if (StringUtils.isEmpty(mixId) || CST.NOT_EXIST.equals(mixId)) {
			List<Double> rtn = new ArrayList<>();
			for (int i = 0; i < eleIndexArray.size(); i++) {
				rtn.add(0.0);
			}
			return rtn;
		} else {
			return getBasicData(eleIndexArray,mixId);
		}
	}

	/**
	 * 
	 * reCalMinerals:(重新计算). <br/>
	 * 
	 * @author liboqiang
	 * @param mineralsD
	 * @param mineralsP
	 * @param fval
	 * @return
	 * @since JDK 1.6
	 */
	public List<Double> reCalMinerals(List<Double> mineralsD, List<Double> mineralsP, double fval) {
		List<Double> res = new ArrayList<>();
		for (int i = 0; i < mineralsD.size(); i++) {
			res.add((mineralsD.get(i) - fval * mineralsP.get(i)) / (1 - fval));
		}
		return res;
	}
}
