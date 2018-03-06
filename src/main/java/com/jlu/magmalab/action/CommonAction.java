package com.jlu.magmalab.action;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.SelectBean;
import com.jlu.magmalab.dao.tables.daos.TmMixTypeDao;
import com.jlu.magmalab.dao.tables.daos.TmStdTypeDao;
import com.jlu.magmalab.dao.tables.pojos.TmMixType;
import com.jlu.magmalab.dao.tables.pojos.TmStdType;
import com.jlu.utils.Ajax;

/**
 * 
 * ClassName: CrystalAction <br/> 
 * Function: 结晶过程控制器. <br/> 
 * date: 2018年3月5日 下午8:35:20 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/common")
public class CommonAction {
	
	@Autowired
	private TmMixTypeDao tmMixTypeDao;
	
	@Autowired
	private TmStdTypeDao tmStdTypeDao;
	
	/**
	 * 
	 * mixType:(获取混染物类型). <br/> 
	 * 
	 * @author liboqiang
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/mixType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String mixType() {
		try {
			
			List<TmMixType> record = tmMixTypeDao.findAll();
			List<SelectBean> res = record.stream().map(rs->{
				SelectBean bean=new SelectBean();
				bean.setCode(rs.getMixId());
				bean.setValue(rs.getMixName());
				return bean;
			}).collect(Collectors.toList());
			
			return Ajax.responseString(CST.RES_SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}
	
	/**
	 * 
	 * stdType:(获取标准化值类型). <br/> 
	 * 
	 * @author liboqiang
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/stdType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String stdType() {
		try {
			
			List<TmStdType> record = tmStdTypeDao.findAll();
			List<SelectBean> res = record.stream().map(rs->{
				SelectBean bean=new SelectBean();
				bean.setCode(rs.getStdId());
				bean.setValue(rs.getStdName());
				return bean;
			}).collect(Collectors.toList());
			
			return Ajax.responseString(CST.RES_SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

}
