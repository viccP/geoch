package com.jlu.magmalab.action;

import static com.jlu.magmalab.dao.tables.TmBasicDataType.TM_BASIC_DATA_TYPE;
import static com.jlu.magmalab.dao.tables.TmBasicDataValue.TM_BASIC_DATA_VALUE;
import static com.jlu.magmalab.dao.tables.TmElement.TM_ELEMENT;
import static org.jooq.impl.DSL.val;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.BasicDataForm;
import com.jlu.magmalab.bean.ElementEx;
import com.jlu.magmalab.bean.Select;
import com.jlu.magmalab.dao.tables.daos.TmBasicDataTypeDao;
import com.jlu.magmalab.service.BasicDataService;
import com.jlu.utils.Ajax;

/**
 * 
 * ClassName: ParamAction <br/>
 * Function: 参数控制器. <br/>
 * date: 2018年3月5日 下午8:35:20 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/basic")
public class BasicDataAction {

	@Autowired
	private TmBasicDataTypeDao tmBasicDataTypeDao;

	@Autowired
	private BasicDataService basicDataService;

	@Autowired
	private DefaultDSLContext dsl;

	/**
	 * 
	 * dataName:(数据类型). <br/>
	 * 
	 * @author liboqiang
	 * @param dataId
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/dataName", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String dataName(Integer dataType) {
		try {
			List<Select<String>> res = tmBasicDataTypeDao.fetchByDataType(dataType).stream().map(rs -> {
				Select<String> bean = new Select<>();
				bean.setCode(rs.getDataId());
				bean.setValue(rs.getDataName());
				return bean;
			}).collect(Collectors.toList());
			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * dataValue:(初始化元素值表). <br/>
	 * 
	 * @author liboqiang
	 * @param dataType
	 * @param dataId
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/dataValue", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String dataValue(Integer dataType, String dataId) {
		try {
			List<ElementEx> res = new ArrayList<>();
			if (StringUtils.isEmpty(dataId)) {
				res = dsl.select(
							val(0.00).as("ELEMENT_VALUE"), 
							TM_ELEMENT.INDEX, 
							TM_ELEMENT.ELEMENT_CODE, 
							TM_ELEMENT.ELEMENT_NAME,
							TM_ELEMENT.ELEMENT_PRONOUNCE)
						.from(TM_ELEMENT)
						.fetchInto(ElementEx.class);
			} else {
				res = dsl.select(
								TM_BASIC_DATA_VALUE.DATA_VALUE.as("ELEMENT_VALUE"), 
								TM_ELEMENT.INDEX, 
								TM_ELEMENT.ELEMENT_CODE,
								TM_ELEMENT.ELEMENT_NAME, 
								TM_ELEMENT.ELEMENT_PRONOUNCE)
						.from(TM_BASIC_DATA_VALUE)
						.leftJoin(TM_ELEMENT).on(TM_BASIC_DATA_VALUE.ELE_INDEX.eq(TM_ELEMENT.INDEX))
						.leftJoin(TM_BASIC_DATA_TYPE).on(TM_BASIC_DATA_VALUE.DATA_ID.eq(TM_BASIC_DATA_TYPE.DATA_ID))
						.where(TM_BASIC_DATA_VALUE.DATA_ID.eq(dataId))
						.and(TM_BASIC_DATA_TYPE.DATA_TYPE.eq(dataType))
						.fetchInto(ElementEx.class);
			}
			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * editDataValue:(编辑基础数据). <br/>
	 * 
	 * @author liboqiang
	 * @param value
	 * @param index
	 * @param dataId
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/editDataValue", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String editDataValue(double value, int index, String dataId) {
		try {
			// 更新数据
			basicDataService.update(value, index, dataId);
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "数据更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * addDataValue:(保存基础数据). <br/> 
	 * 
	 * @author liboqiang
	 * @param basicDataForm
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/addDataValue", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String addDataValue(@RequestBody BasicDataForm basicDataForm) {
		try {
			// 新增基础数据
			basicDataService.add(basicDataForm);
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "数据保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}
	
	
	/**
	 * 
	 * delDataValue:(删除基础数据). <br/> 
	 * 
	 * @author liboqiang
	 * @param dataId
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/delDataValue", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String delDataValue(String dataId) {
		try {
			// 新增基础数据
			basicDataService.delete(dataId);
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "数据删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}
}
