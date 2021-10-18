package com.jlu.magmalab.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.service.knowledgeService;
import com.jlu.utils.Ajax;
import com.jlu.utils.Utils;

/**
 *
 * ClassName: IntroduceAction <br/>
 * Function: 知识库控制器. <br/>
 * date: 2018年3月26日 下午4:42:40 <br/>
 *
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/knowledge")
public class KnowledgeAction {

	@Autowired
	private knowledgeService knowledgeService;

	/**
	 *
	 * save:(保存知识库). <br/>
	 *
	 * @author liboqiang
	 * @param index
	 * @param html
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String save(int index, String html) {
		try {
			knowledgeService.save(index, Utils.base64Decode(html));
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}
}
