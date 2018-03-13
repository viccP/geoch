package com.jlu.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.EchartOpt;
import com.jlu.magmalab.dao.tables.pojos.TmUser;

public class Session {

	private static final String SAMPLE_CHACH = "sampleChachRee";
	private static final String TM_USER = "tmUser";
	private static final String MELT_DATA = "meltData";
	private static final String CRYSTAL_DATA = "crystalData";

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
	public static TmUser getUser() {
		try {
			TmUser tmUser = (TmUser) getSession().getAttribute(TM_USER);
			if (tmUser == null) {
				return new TmUser();
			}
			return tmUser;
		} catch (Exception e) {
			e.printStackTrace();
			return new TmUser();
		}
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
			Map<String, List<Map<String, Double>>> crystalData = (Map<String, List<Map<String, Double>>>) getSession().getAttribute(CRYSTAL_DATA);
			if (crystalData == null) {
				return new HashMap<String, List<Map<String, Double>>>();
			}
			return crystalData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new HashMap<String, List<Map<String, Double>>>();
		}
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
			Map<String, List<Map<String, Double>>> meltData = (Map<String, List<Map<String, Double>>>) getSession().getAttribute(MELT_DATA);
			if (meltData == null) {
				return new HashMap<String, List<Map<String, Double>>>();
			}
			return meltData;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, List<Map<String, Double>>>();
		}
	}

	/**
	 * 
	 * getSampleCache:(获取缓存的样品稀土元素数据). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	public static EchartOpt getSampleCache() {
		return (EchartOpt) getSession().getAttribute(SAMPLE_CHACH);
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
}
