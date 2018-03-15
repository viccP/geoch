package com.jlu.magmalab.action;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ujmp.core.Matrix;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.CrystalForm;
import com.jlu.magmalab.bean.EchartOpt;
import com.jlu.magmalab.bean.Serie;
import com.jlu.magmalab.dao.tables.daos.TmExprDao;
import com.jlu.magmalab.dao.tables.pojos.TmExpr;
import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;
import com.jlu.magmalab.service.CommonService;
import com.jlu.magmalab.service.DistributeService;
import com.jlu.utils.Ajax;
import com.jlu.utils.Session;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: CrystalAction <br/>
 * Function: 结晶模块绘图控制器. <br/>
 * date: 2018年3月14日 上午9:54:06 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/crystal")
public class CrystalAction {

	private static final String BUSINESS_ERR_MSG = "您没有选择初始岩浆，请选择后再次绘图";
	private static final String BUSINESS_ERR_MSG_1 = "请选择定量模型再进行绘图";
	private static final String BUSINESS_ERR_MSG_2 = "请选择岩浆类型再进行绘图";
	private static final String BUSINESS_ERR_MSG_3 = "矿物总量不为100%,请重新填写后再绘图";

	@Autowired
	private DistributeService distributeService;

	@Autowired
	private TmExprDao tmExprDao;

	@Autowired
	private CommonService commonService;

	/**
	 * 
	 * draw:(绘图). <br/>
	 * 
	 * @author liboqiang
	 * @param crystalForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/draw", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String draw(@RequestBody CrystalForm crystalForm) {
		try {
			EchartOpt opt = Session.getCrystalDrawCache();
			String msg = genChartData(opt, crystalForm);
			if (!CST.RES_SUCCESS.equals(msg)) {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, msg);
			}
			return Ajax.responseString(CST.RES_SUCCESS, opt);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * reDraw:(重新绘图). <br/>
	 * 
	 * @author liboqiang
	 * @param crystalForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/reDraw", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String reDraw(@RequestBody CrystalForm crystalForm) {

		try {
			EchartOpt opt = new EchartOpt();
			String msg = genChartData(opt, crystalForm);
			if (!CST.RES_SUCCESS.equals(msg)) {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, msg);
			}
			return Ajax.responseString(CST.RES_SUCCESS, opt);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * genChartData:(生成绘图数据). <br/>
	 * 
	 * @author liboqiang
	 * @param opt
	 * @param crystalForm
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private String genChartData(EchartOpt opt, CrystalForm crystalForm) throws Exception {
		// 验证缓存数据是否为空
		if (Session.getInitialCache().getLegend().isEmpty()) {
			return BUSINESS_ERR_MSG;
		}
		// 验证参数
		String chkMsg = checkPrm(crystalForm);
		if (!CST.RES_SUCCESS.equals(chkMsg)) {
			return chkMsg;
		}
		// 重新整理矿物比例
		List<Double> minerals = crystalForm.getMinerals().parallelStream().sorted((s1, s2) -> {
			Integer si1 = Integer.parseInt(s1.getCode());
			Integer si2 = Integer.parseInt(s2.getCode());
			return si1.compareTo(si2);
		}).map(s -> s.getValue()).collect(Collectors.toList());
		// 验证矿物比例
		if (minerals.parallelStream().reduce((s1, s2) -> s1 + s2).get() != 1) {
			return BUSINESS_ERR_MSG_3;
		}
		opt.getRee().add(doDraw(Session.getInitialCache().getRee(), crystalForm, minerals, CST.REE_ELE_INDEX_ARRAY));
		opt.getTrace().add(doDraw(Session.getInitialCache().getTrace(), crystalForm, minerals, CST.TRACE_ELE_INDEX_ARRAY));
		opt.getLegend().add(crystalForm.getLegend());
		// 缓存数据
		Session.saveCrystalDrawCache(Utils.clone(opt));
		commonService.render(crystalForm.getStdId(), opt, Session.getInitialCache(), Session.getCrystalSampleCache());
		return CST.RES_SUCCESS;
	}

	/**
	 * 
	 * doDraw:(绘制图形). <br/>
	 * 
	 * @author liboqiang
	 * @param initialData
	 * @param crystalForm
	 * @param minerals
	 * @param eleIndexArray
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private Serie doDraw(List<Serie> initialData, CrystalForm crystalForm, List<Double> minerals, List<Integer> eleIndexArray) throws Exception {
		// 绘制稀土元素配分模式图
		Matrix D = distributeService.sigma(minerals, crystalForm.getMagmaType(), eleIndexArray);
		Matrix C0 = Matrix.Factory.importFromArray(initialData.stream().findFirst().get().getData());
		Matrix CA = Matrix.Factory.importFromArray(commonService.getMixData(eleIndexArray, crystalForm.getMixId()).toArray());

		// 设置参数
		Parameter prm = new Parameter();
		prm.setC0(C0);
		prm.setCA(CA);
		prm.setCR(crystalForm.getcR());
		prm.setD(D);
		prm.setF(crystalForm.getfVal());
		prm.setMR(crystalForm.getmR());
		// 获取公式
		TmExpr tmExpr = tmExprDao.fetchOneByExprId(crystalForm.getExprId());
		IExpr expr = (IExpr) Class.forName(tmExpr.getExprClassPath()).newInstance();
		Matrix res = expr.expr(prm);

		// 设置返回值
		Serie serie = new Serie();
		serie.setData(res.toDoubleArray()[0]);
		serie.setName(crystalForm.getLegend());
		serie.setType(CST.CHART_TYPE_LINE);
		return serie;
	}

	/**
	 * 
	 * checkPrm:(验证参数). <br/>
	 * 
	 * @author liboqiang
	 * @param crystalForm
	 * @return
	 * @since JDK 1.6
	 */
	private String checkPrm(CrystalForm crystalForm) {
		if (StringUtils.isEmpty(crystalForm.getExprId()) || CST.NOT_EXIST.equals(crystalForm.getExprId())) {
			return BUSINESS_ERR_MSG_1;
		}

		if (crystalForm.getMagmaType() == null || crystalForm.getMagmaType() == 0 || crystalForm.getMagmaType() == -1) {
			return BUSINESS_ERR_MSG_2;
		}

		return CST.RES_SUCCESS;
	}

}
