package com.jlu.magmalab.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jlu.cst.CST;
import com.jlu.magmalab.service.ReportService;
import com.jlu.utils.Ajax;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: ReportAction <br/> 
 * Function: 实验报告控制器. <br/> 
 * date: 2018年3月30日 下午4:30:09 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/report")
public class ReportAction {

	@Autowired
	private ReportService taskService;

	/**
	 * 
	 * save:(保存实验报告). <br/>
	 * 
	 * @author liboqiang
	 * @param html
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String save(String html) {
		try {
			taskService.save(Utils.base64Decode(html));
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}
	
	/**
	 * 
	 * update:(更新报告). <br/> 
	 * 
	 * @author liboqiang
	 * @param html
	 * @param reportId
	 * @param score
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String check(String html,String reportId,int score) {
		try {
			taskService.check(Utils.base64Decode(html),reportId,score );
			return Ajax.responseString(CST.RES_AUTO_DIALOG, "提交成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}
	
	/**
	 * 
	 * refresh:(更新报告读写状态). <br/> 
	 * 
	 * @author liboqiang
	 * @param id
	 * @return 
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/refresh", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String refresh(String id) {
		try {
			taskService.refresh(id);
			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}
}
