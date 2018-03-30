package com.jlu.magmalab.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Service;

import com.jlu.cst.CST;
import com.jlu.utils.Session;

/**
 * 
 * ClassName: knowledgeService <br/>
 * Function: 知识库Service. <br/>
 * date: 2018年3月27日 上午10:38:03 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Service
public class knowledgeService {

	/**
	 * 
	 * save:(保存知识库). <br/>
	 * 
	 * @author liboqiang
	 * @param index
	 * @param html
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public void save(int index, String html) throws Exception {
		try {
			String path = Session.getSession().getServletContext().getRealPath("/template/");
			String fileName = path + index + CST.SUFFIX_JSP;
			Files.write(Paths.get(fileName), CST.JSP_HEADER.getBytes());
			Files.write(Paths.get(fileName), html.getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
