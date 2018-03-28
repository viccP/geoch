package com.jlu.magmalab.action;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.utils.Ajax;
import com.jlu.utils.Session;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: IntroAction <br/>
 * Function: JS提示控制器. <br/>
 * date: 2018年3月28日 下午4:29:52 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/intro")
public class IntroAction {

	/**
	 * 
	 * crystal:(结晶提示). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/crystal/get", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String crystalGet() {
		try {
			List<Map<String,String>> res=new ArrayList<>();
			String path = Session.getSession().getServletContext().getRealPath("/template/crystal/");
			for (int i=1;i<19;i++) {
				String content=Files.lines(Paths.get(path+"crystal_intro_"+i)).reduce((s1,s2)->{
					return s1+s2;
				}).get();
				content=content.replaceAll("\"", "'");
				Map<String,String> map=new HashMap<>();
				map.put("element", ".intro-step"+i);
				map.put("intro", content);
				res.add(map);
			}
			return Ajax.responseString(CST.RES_SUCCESS,res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}
	
	/**
	 * 
	 * crystalSave:(保存提示消息). <br/> 
	 * 
	 * @author liboqiang
	 * @param index
	 * @param html
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/crystal/save", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String crystalSave(int index,String html) {
		try {
			String context=Utils.base64Decode(html);
			String path = Session.getSession().getServletContext().getRealPath("/template/crystal/");
			String fileName = path + "crystal_intro_"+index;
			Files.write(Paths.get(fileName), context.getBytes());
			return Ajax.responseString(CST.RES_SUCCESS,"保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

}
