package com.jlu.magmalab.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ujmp.core.Matrix;

import com.jlu.cst.CST;
import com.jlu.magmalab.bean.ChartForm;
import com.jlu.magmalab.bean.EchartOpt;
import com.jlu.magmalab.bean.Serie;
import com.jlu.magmalab.dao.tables.daos.TmExprDao;
import com.jlu.magmalab.dao.tables.pojos.TmExpr;
import com.jlu.magmalab.expr.IExpr;
import com.jlu.magmalab.expr.Parameter;
import com.jlu.magmalab.service.LabService;
import com.jlu.magmalab.service.DistributeService;
import com.jlu.utils.Ajax;
import com.jlu.utils.Session;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: ChartAction <br/>
 * Function: 绘图控制器. <br/>
 * date: 2018年3月14日 上午9:54:06 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/chart")
public class ChartAction {

	private static final String BUSINESS_ERR_MSG = "您没有选择初始岩浆/熔体，请选择后再次绘图";
	private static final String BUSINESS_ERR_MSG_1 = "请选择定量模型再进行绘图";
	private static final String BUSINESS_ERR_MSG_2 = "请选择岩浆/熔体类型再进行绘图";

	@Autowired
	private DistributeService distributeService;

	@Autowired
	private TmExprDao tmExprDao;

	@Autowired
	private LabService labService;

	/**
	 * 
	 * draw:(绘图). <br/>
	 * 
	 * @author liboqiang
	 * @param chartForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/draw", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String draw(@RequestBody ChartForm chartForm) {
		try {
			EchartOpt opt = Utils.clone(Session.getDrawCache());
			String msg = genChartData(opt, chartForm);
			if (!CST.RES_SUCCESS.equals(msg)) {
				if (chartForm.isPreview()) {
					render(chartForm.getStdId(), opt, Session.getSampleCache(), Session.getInitialCache(), Session.getDrawCache());
					return Ajax.responseString(CST.RES_SUCCESS, opt);
				}
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
	 * @param chartForm
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/reDraw", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String reDraw(@RequestBody ChartForm chartForm) {

		try {
			EchartOpt opt = new EchartOpt();
			String msg = genChartData(opt, chartForm);
			if (!CST.RES_SUCCESS.equals(msg)) {
				if (chartForm.isPreview()) {
					render(chartForm.getStdId(), opt, Session.getSampleCache(), Session.getInitialCache(), Session.getDrawCache(), Session.getTmpCache());
					return Ajax.responseString(CST.RES_SUCCESS, opt);
				}
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
	 * initialChart:(初始岩浆或者熔体图形). <br/>
	 * 
	 * @author liboqiang
	 * @param initialId
	 * @param stdId
	 * @param labType
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/initial", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String initialChart(String initialId, String stdId, String legend) {
		try {
			EchartOpt opt = new EchartOpt();
			// 获取初始岩浆或者熔体数据
			opt.getRee().addAll((getInitialSeries(labService.getInitialData(CST.REE_ELE_INDEX_ARRAY, initialId), legend)));
			opt.getTrace().addAll((getInitialSeries(labService.getInitialData(CST.TRACE_ELE_INDEX_ARRAY, initialId), legend)));
			opt.getLegend().add(legend);
			// 存入缓存
			Session.saveInitialCache(Utils.clone(opt));
			// 渲染图形
			render(stdId, opt, Session.getSampleCache(), Session.getDrawCache(), Session.getTmpCache());
			return Ajax.responseString(CST.RES_SUCCESS, opt);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * sampleChart:(样品图形). <br/>
	 * 
	 * @author liboqiang
	 * @param stdType
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/sample", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String simpleChart(@RequestParam("sampleCodes[]") List<String> sampleCodes, String stdId, int sampleType) {
		try {
			EchartOpt opt = new EchartOpt();
			// 获取样品数据
			if (!sampleCodes.isEmpty() && !sampleCodes.contains(CST.NOT_EXIST)) {
				for (String sampleCode : sampleCodes) {
					// 获取样品数据
					List<Map<String, Double>> sampleData = (CST.IMP_DATA_TYPE_CRYSTAL == sampleType) ? Session.getCrystalData().get(sampleCode) : Session.getMeltData().get(sampleCode);
					// 获取样品名称
					String sampleName = Utils.base64Decode(sampleCode);
					// 获取稀土元素数据
					opt.getRee().add(getSampleSerie(CST.REE_ELE_NAME_ARRAY, sampleData, sampleName));
					// 获取微量元素数据
					opt.getTrace().add(getSampleSerie(CST.TRACE_ELE_NAME_ARRAY, sampleData, sampleName));
					// 设置图例名称
					opt.getLegend().add(sampleName);
				}
				// 存入缓存
				Session.saveSampleCache(Utils.clone(opt));
			}
			// 渲染图形
			render(stdId, opt, Session.getInitialCache(), Session.getDrawCache(), Session.getTmpCache());
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
	 * @param chartForm
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private String genChartData(EchartOpt opt, ChartForm chartForm) throws Exception {
		// 验证缓存数据是否为空
		if (Session.getInitialCache().getLegend().isEmpty()) {
			return BUSINESS_ERR_MSG;
		}
		// 验证参数
		String chkMsg = checkPrm(chartForm);
		if (!CST.RES_SUCCESS.equals(chkMsg)) {
			return chkMsg;
		}
		// 重新整理矿物比例
		List<Double> minerals = chartForm.getMinerals().parallelStream().sorted((s1, s2) -> {
			Integer si1 = Integer.parseInt(s1.getCode());
			Integer si2 = Integer.parseInt(s2.getCode());
			return si1.compareTo(si2);
		}).map(s -> s.getValue()).collect(Collectors.toList());

		// 获取绘图数据
		Serie reeD = doDraw(Session.getInitialCache().getRee(), chartForm, minerals, CST.REE_ELE_INDEX_ARRAY);
		Serie traceD = doDraw(Session.getInitialCache().getTrace(), chartForm, minerals, CST.TRACE_ELE_INDEX_ARRAY);

		// 加入绘图组
		opt.getRee().add(reeD);
		opt.getTrace().add(traceD);
		opt.getLegend().add(chartForm.getLegend());
		// 如果不为预览缓存数据
		if (!chartForm.isPreview()) {
			Session.saveDrawCache(Utils.clone(opt));
			Session.saveTmpCache(new EchartOpt());
		} else {
			EchartOpt tmpOpt = new EchartOpt();
			tmpOpt.getRee().add(reeD);
			tmpOpt.getTrace().add(traceD);
			tmpOpt.getLegend().add(chartForm.getLegend());
			Session.saveTmpCache(tmpOpt);
		}
		render(chartForm.getStdId(), opt, Session.getInitialCache(), Session.getSampleCache());
		return CST.RES_SUCCESS;
	}

	/**
	 * 
	 * doDraw:(绘制图形). <br/>
	 * 
	 * @author liboqiang
	 * @param initialData
	 * @param chartForm
	 * @param minerals
	 * @param eleIndexArray
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	private Serie doDraw(List<Serie> initialData, ChartForm chartForm, List<Double> minerals, List<Integer> eleIndexArray) throws Exception {
		// 绘制稀土元素配分模式图
		Matrix D = distributeService.sigma(minerals, chartForm.getMagmaType(), eleIndexArray);
		Matrix C0 = Matrix.Factory.importFromArray(initialData.stream().findFirst().get().getData());
		Matrix CA = Matrix.Factory.importFromArray(labService.getMixData(eleIndexArray, chartForm.getMixId()).toArray());

		// 设置参数
		Parameter prm = new Parameter();
		prm.setC0(C0);
		prm.setCA(CA);
		prm.setCR(chartForm.getcR());
		prm.setD(D);
		prm.setF(chartForm.getfVal());
		prm.setMR(chartForm.getmR());
		// 获取公式
		TmExpr tmExpr = tmExprDao.fetchOneByExprId(chartForm.getExprId());
		IExpr expr = (IExpr) Class.forName(tmExpr.getExprClassPath()).newInstance();
		Matrix res = expr.expr(prm);

		// 设置返回值
		Serie serie = new Serie();
		serie.setData(res.toDoubleArray()[0]);
		serie.setName(chartForm.getLegend());
		serie.setType(CST.CHART_TYPE_LINE);
		return serie;
	}

	/**
	 * 
	 * checkPrm:(验证参数). <br/>
	 * 
	 * @author liboqiang
	 * @param chartForm
	 * @return
	 * @since JDK 1.6
	 */
	private String checkPrm(ChartForm chartForm) {
		if (StringUtils.isEmpty(chartForm.getExprId()) || CST.NOT_EXIST.equals(chartForm.getExprId())) {
			return BUSINESS_ERR_MSG_1;
		}

		if (chartForm.getMagmaType() == null || chartForm.getMagmaType() == 0 || chartForm.getMagmaType() == -1) {
			return BUSINESS_ERR_MSG_2;
		}

		return CST.RES_SUCCESS;
	}

	/**
	 * 
	 * getSampleSeries:(获取样品图形数据). <br/>
	 * 
	 * @author liboqiang
	 * @param eleNameArray
	 * @param sampleData
	 * @param sampleName
	 * @return
	 * @since JDK 1.6
	 */
	private Serie getSampleSerie(List<String> eleNameArray, List<Map<String, Double>> sampleData, String sampleName) {

		// 元素数据
		List<Double> sampleArrayData = sampleData.parallelStream().filter(s -> eleNameArray.contains(s.keySet().stream().findFirst().get())).sorted((s1, s2) -> {
			int io1 = eleNameArray.indexOf(s1.keySet().stream().findFirst().get());
			int io2 = eleNameArray.indexOf(s2.keySet().stream().findFirst().get());
			return io1 - io2;
		}).map(s -> s.values().parallelStream().findFirst().get()).collect(Collectors.toList());

		// 转为矩阵
		Matrix sampleDataMatix = Matrix.Factory.importFromArray(sampleArrayData.toArray());

		// 构建echar数据
		Serie series = new Serie();
		series.setData(sampleDataMatix.toDoubleArray()[0]);
		series.setType(CST.CHART_TYPE_LINE);
		series.setName(sampleName);
		return series;
	}

	/**
	 * 
	 * getInitialSeries:(获取初始化岩浆或者熔体系列). <br/>
	 * 
	 * @author liboqiang
	 * @param initialData
	 * @param legend
	 * @return
	 * @since JDK 1.6
	 */
	private List<Serie> getInitialSeries(List<Double> initialData, String legend) {
		List<Serie> rtn = new ArrayList<>();
		Serie serie = new Serie();
		serie.setData(Matrix.Factory.importFromArray(initialData.toArray()).toDoubleArray()[0]);
		serie.setName(legend);
		serie.setType(CST.CHART_TYPE_LINE);
		rtn.add(serie);
		return rtn;
	}

	/**
	 * 
	 * divideByStd:(除以标准化数据). <br/>
	 * 
	 * @author liboqiang
	 * @param list
	 * @param stdData
	 * @return
	 * @since JDK 1.6
	 */
	public List<Serie> divideByStd(List<Serie> list, List<Double> stdData) {
		List<Serie> rtnLst = new ArrayList<>();
		for (Serie series : list) {
			Matrix reeMatix = Matrix.Factory.importFromArray(series.getData());
			Matrix reeStdMatrix = Matrix.Factory.importFromArray(stdData.toArray());
			// 设置返回值
			Serie tmp = new Serie();
			tmp.setName(series.getName());
			tmp.setType(series.getType());
			if (!stdData.isEmpty()) {
				tmp.setData(reeMatix.divide(reeStdMatrix).toDoubleArray()[0]);
			} else {
				tmp.setData(reeMatix.toDoubleArray()[0]);
			}
			rtnLst.add(tmp);
		}
		return rtnLst;
	}

	/**
	 * 
	 * render:(渲染图形). <br/>
	 * 
	 * @author liboqiang
	 * @param stdId
	 * @param opt
	 * @param opts
	 * @since JDK 1.6
	 */
	public void render(String stdId, EchartOpt opt, EchartOpt... opts) {
		// 获取标准化值
		List<Double> stdReeData = labService.getStdData(CST.REE_ELE_INDEX_ARRAY, stdId);
		List<Double> stdTraceData = labService.getStdData(CST.TRACE_ELE_INDEX_ARRAY, stdId);

		// 当前数据
		if (!opt.getRee().isEmpty()) {
			opt.setRee(divideByStd(opt.getRee(), stdReeData));
			opt.setTrace(divideByStd(opt.getTrace(), stdTraceData));
		}

		// 添加缓存数据
		for (EchartOpt tmp : opts) {
			opt.getRee().addAll(divideByStd(tmp.getRee(), stdReeData));
			opt.getTrace().addAll(divideByStd(tmp.getTrace(), stdTraceData));
			opt.getLegend().addAll(tmp.getLegend());
		}
	}
}
