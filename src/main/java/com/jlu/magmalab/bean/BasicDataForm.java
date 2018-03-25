package com.jlu.magmalab.bean;

import java.util.List;

import com.jlu.magmalab.dao.tables.pojos.TmBasicDataType;
import com.jlu.magmalab.dao.tables.pojos.TmBasicDataValue;

/**
 * 
 * ClassName: BasicDataForm <br/>
 * Function: 基础数据表单. <br/>
 * date: 2018年3月25日 下午5:29:10 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class BasicDataForm {

	/** 数据类型 **/
	private TmBasicDataType dataType;

	/** 数据元素值 **/
	private List<TmBasicDataValue> dataValLst;

	/**
	 * dataType.
	 * 
	 * @return the dataType
	 * @since JDK 1.6
	 */
	public TmBasicDataType getDataType() {
		return dataType;
	}

	/**
	 * dataType.
	 * 
	 * @param dataType
	 *            the dataType to set
	 * @since JDK 1.6
	 */
	public void setDataType(TmBasicDataType dataType) {
		this.dataType = dataType;
	}

	/**
	 * dataValLst.
	 * 
	 * @return the dataValLst
	 * @since JDK 1.6
	 */
	public List<TmBasicDataValue> getDataValLst() {
		return dataValLst;
	}

	/**
	 * dataValLst.
	 * 
	 * @param dataValLst
	 *            the dataValLst to set
	 * @since JDK 1.6
	 */
	public void setDataValLst(List<TmBasicDataValue> dataValLst) {
		this.dataValLst = dataValLst;
	}
}
