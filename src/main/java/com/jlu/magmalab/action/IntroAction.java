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
	 * get:(获取提示). <br/> 
	 * 
	 * @author liboqiang
	 * @param type
	 * @param size
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String get(String type,int size) {
		try {
			List<Map<String,String>> res=new ArrayList<>();
			String path = Session.getSession().getServletContext().getRealPath("/template/"+type+"/")+"/";
			for (int i=1;i<size+1;i++) {
				String content=Files.lines(Paths.get(path+type+"_intro_"+i)).reduce((s1,s2)->{
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
	 * save:(保存提示). <br/> 
	 * 
	 * @author liboqiang
	 * @param index
	 * @param html
	 * @param type
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String save(int index,String html,String type) {
		try {
			String context=Utils.base64Decode(html);
			String path = Session.getSession().getServletContext().getRealPath("/template/"+type+"/")+"/";
			String fileName = path + type+"_intro_"+index;
			Files.write(Paths.get(fileName), context.getBytes());
			return Ajax.responseString(CST.RES_SUCCESS,"保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
		}
	}

}
