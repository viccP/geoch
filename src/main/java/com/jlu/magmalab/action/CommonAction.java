package com.jlu.magmalab.action;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.Select;
import com.jlu.magmalab.dao.tables.daos.TmExprDao;
import com.jlu.magmalab.dao.tables.daos.TmMineralDao;
import com.jlu.magmalab.dao.tables.daos.TmMixTypeDao;
import com.jlu.magmalab.dao.tables.daos.TmStdTypeDao;
import com.jlu.magmalab.dao.tables.pojos.TmExpr;
import com.jlu.magmalab.dao.tables.pojos.TmMineral;
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
	
	@Autowired
	private TmMineralDao tmMineralDao;
	
	@Autowired
	private TmExprDao tmExprDao;
	
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
			List<Select> res = record.stream().map(rs->{
				Select bean=new Select();
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
			List<Select> res = record.stream().map(rs->{
				Select bean=new Select();
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
	
	

	/**
	 * 
	 * mineralType:(获取矿物种类). <br/> 
	 * 
	 * @author liboqiang
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/mineralType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String mineralType() {
		try {
			
			List<TmMineral> record = tmMineralDao.findAll();
			List<Select> res = record.stream().sorted((s1,s2)-> s1.getIndex().compareTo(s2.getIndex())).map(rs->{
				Select bean=new Select();
				bean.setCode(String.valueOf(rs.getIndex()));
				bean.setValue(rs.getMineralName());
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
	 * exprType:(获取定量公式). <br/> 
	 * 
	 * @author liboqiang
	 * @param exprType:公式类型 0->结晶 1->熔融
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/exprType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String exprType(int exprType) {
		try {
			List<TmExpr> record = tmExprDao.fetchByExprType(exprType);
			List<Select> res = record.stream().map(rs->{
				Select bean=new Select();
				bean.setCode(rs.getExprId());
				bean.setValue(rs.getExprName());
				return bean;
			}).collect(Collectors.toList());
			
			return Ajax.responseString(CST.RES_SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

}
