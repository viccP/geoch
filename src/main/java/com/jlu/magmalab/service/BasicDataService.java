package com.jlu.magmalab.service;

import static com.jlu.magmalab.dao.tables.TmBasicDataValue.TM_BASIC_DATA_VALUE;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlu.magmalab.bean.BasicDataForm;
import com.jlu.magmalab.dao.tables.daos.TmBasicDataTypeDao;
import com.jlu.magmalab.dao.tables.daos.TmBasicDataValueDao;
import com.jlu.magmalab.dao.tables.pojos.TmBasicDataType;
import com.jlu.utils.Utils;

@Service
public class BasicDataService {

	@Autowired
	private DefaultDSLContext dsl;

	@Autowired
	private TmBasicDataTypeDao tmBasicDataTypeDao;

	@Autowired
	private TmBasicDataValueDao tmBasicDataValueDao;

	/**
	 * 
	 * add:(新增基础数据). <br/>
	 * 
	 * @author liboqiang
	 * @param basicDataForm
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(BasicDataForm basicDataForm) throws Exception {
		try {
			String dataId = Utils.genId();
			TmBasicDataType dataTypeBean = basicDataForm.getDataType();
			dataTypeBean.setDataId(dataId);

			// 保存数据类型
			tmBasicDataTypeDao.insert(dataTypeBean);

			// 保存元素值
			basicDataForm.getDataValLst().parallelStream().map(s -> {
				s.setDataId(dataId);
				return s;
			}).forEach(s -> {
				tmBasicDataValueDao.insert(s);
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * update:(更新基础数据). <br/>
	 * 
	 * @author liboqiang
	 * @param value
	 * @param index
	 * @param dataId
	 * @throws Exception
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(double value, int index, String dataId) throws Exception {
		try {
			dsl.update(TM_BASIC_DATA_VALUE).set(TM_BASIC_DATA_VALUE.DATA_VALUE, value).where(TM_BASIC_DATA_VALUE.DATA_ID.eq(dataId))
					.and(TM_BASIC_DATA_VALUE.ELE_INDEX.eq(index)).execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * delete:(删除基础数据). <br/>
	 * 
	 * @author liboqiang
	 * @param dataId
	 * @since JDK 1.6
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(String dataId) {
		try {
			// 删除数据类型
			tmBasicDataTypeDao.deleteById(dataId);

			// 删除数据内容
			dsl.delete(TM_BASIC_DATA_VALUE).where(TM_BASIC_DATA_VALUE.DATA_ID.eq(dataId));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
