package com.jlu.magmalab.listener;

import static com.jlu.magmalab.dao.tables.TmUser.TM_USER;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jooq.impl.DefaultDSLContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jlu.cst.CST;
import com.jlu.magmalab.dao.tables.pojos.TmUser;
import com.jlu.utils.PropUtil;

public class ServerInitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 容器初始化
	 */
	public void contextInitialized(ServletContextEvent sce) {
//		// 获取spring上下文
//		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//
//		//获取JOOQ DSL
//		DefaultDSLContext dsl = springContext.getBean(DefaultDSLContext.class);
//		
//		List<TmUser> record = dsl.select().from(TM_USER).fetchInto(TmUser.class);
		
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
