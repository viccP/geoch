package com.jlu.magmalab.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * ClassName: ImportData <br/> 
 * Function: 导入数据. <br/> 
 * date: 2018年3月7日 下午4:51:29 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class ImportData {

	/**数据类型(0:结晶实验用数据 1:熔融实验用数据)**/
	private Integer dataType;
	
	/**数据文件(Excel)**/
	private MultipartFile file;

	/** 
	* dataType. 
	* 
	* @return  the dataType 
	* @since   JDK 1.6 
	*/
	public Integer getDataType() {
		return dataType;
	}

	/** 
	 * dataType. 
	 * 
	 * @param   dataType    the dataType to set 
	 * @since   JDK 1.6 
	 */
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	/** 
	* file. 
	* 
	* @return  the file 
	* @since   JDK 1.6 
	*/
	public MultipartFile getFile() {
		return file;
	}

	/** 
	 * file. 
	 * 
	 * @param   file    the file to set 
	 * @since   JDK 1.6 
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
