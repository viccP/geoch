package com.jlu.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.EchartOpt;
import com.jlu.magmalab.bean.TmUserEx;
import com.jlu.magmalab.dao.tables.pojos.TmUser;

public class Session {

	private static final String TM_USER = "TM_USER";
	private static final String CRYSTAL_DATA = "CRYSTAL_DATA";
	private static final String MELT_DATA = "MELT_DATA";
	private static final String INITIAL_CHACH = "INITIAL_CHACH";
	private static final String SAMPLE_CHACH = "SAMPLE_CHACH";
	private static final String DRAW_CHACH = "DRAW_CHACH";
	private static final String TMP_CHACH = "TMP_CHACH";

	/**
	 * 
	 * 私有构造函数：Session.
	 *
	 */
	private Session() {
	}

	/**
	 * 
	 * @Title: getSession
	 * @Description: 获取session
	 * @return
	 */
	public static HttpSession getSession() {
		try {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			return attr.getRequest().getSession();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * isSuperAdmin:(是否超级管理员). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean isSuperAdmin() {
		try {
			TmUser tmUser = getUser();
			if (CST.USER_ID_DEFAULT.equals(tmUser.getUserId())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * getUser:(获取用户). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static TmUserEx getUser() {
		try {
			return Optional.of((TmUserEx) getSession().getAttribute(TM_USER)).orElseGet(TmUserEx::new);
		} catch (Exception e) {
			e.printStackTrace();
			return new TmUserEx();
		}
	}

	/**
	 * 
	 * saveInitialCache:(存入初始化岩浆或者熔体数据). <br/>
	 * 
	 * @author liboqiang
	 * @param clone
	 * @since JDK 1.6
	 */
	public static void saveInitialCache(EchartOpt opt) {
		getSession().setAttribute(Session.INITIAL_CHACH, opt);
	}

	/**
	 * 
	 * saveDrawCache:(保存绘图缓存). <br/>
	 * 
	 * @author liboqiang
	 * @param opt
	 * @since JDK 1.6
	 */
	public static void saveDrawCache(EchartOpt opt) {
		getSession().setAttribute(Session.DRAW_CHACH, opt);
	}

	/**
	 * 
	 * saveSampleCache:(存入样品数据). <br/>
	 * 
	 * @author liboqiang
	 * @param reeCache
	 * @since JDK 1.6
	 */
	public static void saveSampleCache(EchartOpt opt) {
		getSession().setAttribute(Session.SAMPLE_CHACH, opt);
	}

	/**
	 * 
	 * saveTmpCache:(存入临时数据). <br/>
	 * 
	 * @author liboqiang
	 * @param opt
	 * @since JDK 1.6
	 */
	public static void saveTmpCache(EchartOpt opt) {
		getSession().setAttribute(Session.TMP_CHACH, opt);
	}

	/**
	 * 
	 * saveCrystalData:(存储结晶实验数据). <br/>
	 * 
	 * @author liboqiang
	 * @param data
	 * @since JDK 1.6
	 */
	public static void saveCrystalData(Map<String, List<Map<String, Double>>> data) {
		getSession().setAttribute(CRYSTAL_DATA, data);
	}

	/**
	 * 
	 * saveMeltData:(存储熔融实验数据). <br/>
	 * 
	 * @author liboqiang
	 * @param data
	 * @since JDK 1.6
	 */
	public static void saveMeltData(Map<String, List<Map<String, Double>>> data) {
		getSession().setAttribute(MELT_DATA, data);
	}
	
	/**
	 * 
	 * getInitialCache:(获取缓存的初始化岩浆或者熔体数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static EchartOpt getInitialCache() {
		return Optional.ofNullable((EchartOpt) getSession().getAttribute(INITIAL_CHACH)).orElseGet(EchartOpt::new);
	}

	/**
	 * 
	 * getCrystalData:(获取结晶数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, List<Map<String, Double>>> getCrystalData() {
		try {
			return Optional.ofNullable((Map<String, List<Map<String, Double>>>) getSession().getAttribute(CRYSTAL_DATA)).orElseGet(HashMap::new);
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, List<Map<String, Double>>>();
		}
	}

	/**
	 * 
	 * getDrawCache:(获取绘图数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static EchartOpt getDrawCache() {
		return Optional.ofNullable((EchartOpt) getSession().getAttribute(DRAW_CHACH)).orElseGet(EchartOpt::new);
	}

	/**
	 * 
	 * getCrystalTmpCache:(获取结晶临时数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static EchartOpt getTmpCache() {
		return Optional.ofNullable((EchartOpt) getSession().getAttribute(TMP_CHACH)).orElseGet(EchartOpt::new);
	}

	/**
	 * 
	 * getCrystalSampleCache:(获取缓存的样品稀土元素数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static EchartOpt getSampleCache() {
		return Optional.ofNullable((EchartOpt) getSession().getAttribute(SAMPLE_CHACH)).orElseGet(EchartOpt::new);
	}

	/**
	 * 
	 * getMeltData:(获取熔融数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, List<Map<String, Double>>> getMeltData() {
		try {
			return Optional.ofNullable((Map<String, List<Map<String, Double>>>) getSession().getAttribute(MELT_DATA)).orElseGet(HashMap::new);
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, List<Map<String, Double>>>();
		}
	}

	/**
	 * 
	 * isTeacher:(这里用一句话描述这个方法的作用). <br/> 
	 * 
	 * @author liboqiang
	 * @return 
	 * @since JDK 1.6
	 */
	public static boolean isTeacher() {
		try {
			TmUserEx tmUserEx = getUser();
			if (CST.ROLE_ID_TEARCH.equals(tmUserEx.getRoleId())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
