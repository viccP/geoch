package com.jlu.video.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jlu.cst.CST;

/**
 * 
 * ClassName: VideoAction <br/> 
 * Function: 视频信息控制器. <br/> 
 * date: 2018年2月8日 下午3:57:45 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/video")
public class VideoAction {
	
	/**
	 * 
	 * list:(获取视频列表). <br/> 
	 * 
	 * @author liboqiang
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String list() {
		return JSON.toJSONString(CST.VIDEO_MAP);
	}
	
	/**
	 * 
	 * get:(获取视频信息). <br/> 
	 * 
	 * @author liboqiang
	 * @param id
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String get(String id) {
		return JSON.toJSONString(CST.VIDEO_MAP.get(id));
	}
}
