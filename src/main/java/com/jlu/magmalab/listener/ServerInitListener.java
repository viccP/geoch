package com.jlu.magmalab.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jlu.cst.CST;
import com.jlu.magmalab.service.DistributeService;
import com.jlu.utils.PropUtil;

public class ServerInitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	* 系统初始化. 
	* @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// 获取spring上下文
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());

		//获取分配系数矩阵
		DistributeService distributeService = springContext.getBean(DistributeService.class);
		CST.GLOBAL_DIST_LIST = distributeService.fetchDistrubute();
		
		Properties props = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = getClass().getResourceAsStream("/config.properties");
			props.load(inputStream);
			CST.UPLOAD_DIR = PropUtil.get(props, "upload.dir");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
