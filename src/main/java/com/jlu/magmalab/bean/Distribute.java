package com.jlu.magmalab.bean;

import org.ujmp.core.Matrix;

/**
 * 
 * ClassName: Distribute <br/> 
 * Function: 分配系数. <br/> 
 * date: 2018年3月6日 上午9:53:35 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class Distribute {
	
	/** 熔体类型 **/
	private Integer meltType;
	
	/** 分配系数矩阵 **/
	private Matrix distribute;

	/** 
	* meltType. 
	* 
	* @return  the meltType 
	* @since   JDK 1.6 
	*/
	public Integer getMeltType() {
		return meltType;
	}

	/** 
	 * meltType. 
	 * 
	 * @param   meltType    the meltType to set 
	 * @since   JDK 1.6 
	 */
	public void setMeltType(Integer meltType) {
		this.meltType = meltType;
	}

	/** 
	* distribute. 
	* 
	* @return  the distribute 
	* @since   JDK 1.6 
	*/
	public Matrix getDistribute() {
		return distribute;
	}

	/** 
	 * distribute. 
	 * 
	 * @param   distribute    the distribute to set 
	 * @since   JDK 1.6 
	 */
	public void setDistribute(Matrix distribute) {
		this.distribute = distribute;
	}
}
