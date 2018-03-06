package com.jlu.magmalab.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation.Ret;

import com.jlu.magmalab.bean.Distribute;
import com.jlu.magmalab.dao.tables.daos.TmDistributeValueDao;
import com.jlu.magmalab.dao.tables.pojos.TmDistributeValue;

/**
 * 
 * ClassName: DistributeService <br/>
 * Function: 分配系数service. <br/>
 * date: 2018年3月6日 上午9:33:22 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Service
public class DistributeService {

	@Autowired
	private TmDistributeValueDao tmDistributeValueDao;

	/**
	 * 
	 * fetchDistrubute:(这里用一句话描述这个方法的作用). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public List<Distribute> fetchDistrubute() {

		// 定义返回值
		List<Distribute> rtn = new ArrayList<>();

		// 获取数据
		List<TmDistributeValue> res = tmDistributeValueDao.findAll();

		// 按照熔体类型分组
		Map<Integer, List<TmDistributeValue>> resGroupMap = res.parallelStream().collect(Collectors.groupingBy(TmDistributeValue::getMeltIndex));

		// 组织返回值
		resGroupMap.forEach((key, val) -> {
			Distribute dist = new Distribute();
			Matrix matrix = Matrix.Factory.emptyMatrix();
			dist.setMeltType(key);
			
			//按照矿物分组
			Map<Integer, List<TmDistributeValue>> resSubGroupMap = val.parallelStream()
					.sorted((s1,s2)->s1.getMineralIndex().compareTo(s2.getMineralIndex()))
					.collect(Collectors.groupingBy(TmDistributeValue::getMineralIndex,TreeMap::new,Collectors.toList()));
			
			//定义行列计数器
			int cCount=0;
			int rCount=0;
			for(Entry<Integer, List<TmDistributeValue>> entry:resSubGroupMap.entrySet()) {
				List<TmDistributeValue> subValue = entry.getValue();
				Integer subKey = entry.getKey();
				
				//获取行数
				if(rCount==0) {
					rCount=subValue.size();
				}
				
				Object[] tmp = subValue.parallelStream()
						.sorted((s1,s2)->s1.getEleIndex().compareTo(s2.getEleIndex()))
						.map(s->s.getDistributeValue())
						.collect(Collectors.toList()).toArray();
				Matrix tmpMatrix = Matrix.Factory.importFromArray(tmp).transpose();
				matrix=matrix.appendHorizontally(Ret.NEW, tmpMatrix);
				
				//设置列标号
				matrix.setColumnLabel(cCount, String.valueOf(subKey));
				cCount++;
			}
			
			//设置行标号
			for(int i=0;i<rCount;i++) {
				matrix.setRowLabel(i, String.valueOf(i+1));
			}
			
			
			dist.setDistribute(matrix);
			rtn.add(dist);
		});
		return rtn;
	}
}
