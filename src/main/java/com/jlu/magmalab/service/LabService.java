package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmInitialValue.TM_INITIAL_VALUE;
import static com.jlu.magmalab.dao.tables.TmMixValue.TM_MIX_VALUE;
import static com.jlu.magmalab.dao.tables.TmStdValue.TM_STD_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlu.cst.CST;
import com.jlu.magmalab.dao.tables.pojos.TmInitialValue;
import com.jlu.magmalab.dao.tables.pojos.TmMixValue;
import com.jlu.magmalab.dao.tables.pojos.TmStdValue;

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
	 * getStdData:(获取标准化值). <br/>
	 * 
	 * @author liboqiang
	 * @param eleIndexArray
	 * @param stdId
	 * @return
	 * @since JDK 1.6
	 */
	public List<Double> getStdData(List<Integer> eleIndexArray, String stdId) {
		return dsl.select(TM_STD_VALUE.STD_VALUE, TM_STD_VALUE.ELE_INDEX).from(TM_STD_VALUE).where(TM_STD_VALUE.ELE_INDEX.in(eleIndexArray)).and(TM_STD_VALUE.STD_ID.eq(stdId)).fetchInto(TmStdValue.class).stream().sorted((s1, s2) -> {
			int io1 = eleIndexArray.indexOf(s1.getEleIndex());
			int io2 = eleIndexArray.indexOf(s2.getEleIndex());
			return io1 - io2;
		}).map(s -> s.getStdValue()).collect(Collectors.toList());
	}

	/**
	 * 
	 * getInitialData:(获取初始岩浆或者熔体). <br/>
	 * 
	 * @author liboqiang
	 * @param eleIndexArray
	 * @param stdId
	 * @return
	 * @since JDK 1.6
	 */
	public List<Double> getInitialData(List<Integer> eleIndexArray, String initialId) {
		return dsl.select(TM_INITIAL_VALUE.INITIAL_VALUE, TM_INITIAL_VALUE.ELE_INDEX).from(TM_INITIAL_VALUE).where(TM_INITIAL_VALUE.ELE_INDEX.in(eleIndexArray)).and(TM_INITIAL_VALUE.INITIAL_ID.eq(initialId)).fetchInto(TmInitialValue.class).stream().sorted((s1, s2) -> {
			int io1 = eleIndexArray.indexOf(s1.getEleIndex());
			int io2 = eleIndexArray.indexOf(s2.getEleIndex());
			return io1 - io2;
		}).map(s -> s.getInitialValue()).collect(Collectors.toList());
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
			return dsl.select(TM_MIX_VALUE.MIX_VALUE, TM_MIX_VALUE.ELE_INDEX).from(TM_MIX_VALUE).where(TM_MIX_VALUE.ELE_INDEX.in(eleIndexArray)).and(TM_MIX_VALUE.MIX_ID.eq(mixId)).fetchInto(TmMixValue.class).stream().sorted((s1, s2) -> {
				int io1 = eleIndexArray.indexOf(s1.getEleIndex());
				int io2 = eleIndexArray.indexOf(s2.getEleIndex());
				return io1 - io2;
			}).map(s -> s.getMixValue()).collect(Collectors.toList());
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
