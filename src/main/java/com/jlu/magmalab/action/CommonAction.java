package com.jlu.magmalab.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.ujmp.core.Matrix;

import com.jlu.cst.CST;
import com.jlu.exception.BusinessException;
import com.jlu.exception.SystemException;
import com.jlu.magmalab.bean.EchartOpt;
import com.jlu.magmalab.bean.ImportData;
import com.jlu.magmalab.bean.Select;
import com.jlu.magmalab.bean.Serie;
import com.jlu.magmalab.dao.tables.daos.TmExprDao;
import com.jlu.magmalab.dao.tables.daos.TmInitialTypeDao;
import com.jlu.magmalab.dao.tables.daos.TmMineralDao;
import com.jlu.magmalab.dao.tables.daos.TmMixTypeDao;
import com.jlu.magmalab.dao.tables.daos.TmStdTypeDao;
import com.jlu.magmalab.dao.tables.pojos.TmExpr;
import com.jlu.magmalab.dao.tables.pojos.TmInitialType;
import com.jlu.magmalab.dao.tables.pojos.TmMineral;
import com.jlu.magmalab.dao.tables.pojos.TmMixType;
import com.jlu.magmalab.dao.tables.pojos.TmStdType;
import com.jlu.magmalab.service.CommonService;
import com.jlu.magmalab.service.ExcelService;
import com.jlu.utils.Ajax;
import com.jlu.utils.Session;
import com.jlu.utils.Utils;

/**
 * 
 * ClassName: CrystalAction <br/>
 * Function: 结晶过程控制器. <br/>
 * date: 2018年3月5日 下午8:35:20 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
@Controller
@RequestMapping(value = "/common")
public class CommonAction {

	@Autowired
	private TmMixTypeDao tmMixTypeDao;

	@Autowired
	private TmStdTypeDao tmStdTypeDao;

	@Autowired
	private TmInitialTypeDao tmInitialTypeDao;

	@Autowired
	private TmMineralDao tmMineralDao;

	@Autowired
	private TmExprDao tmExprDao;

	@Autowired
	private ExcelService excelService;

	@Autowired
	private CommonService commonService;

	/**
	 * 
	 * mixType:(获取混染物类型). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/mixType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String mixType() {
		try {

			List<TmMixType> record = tmMixTypeDao.findAll();
			List<Select<String>> res = record.stream().map(rs -> {
				Select<String> bean = new Select<>();
				bean.setCode(rs.getMixId());
				bean.setValue(rs.getMixName());
				return bean;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * clearCache:(清空缓存). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/clearCache", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String clearCache() {
		try {

			Session.saveInitialCache(new EchartOpt());
			Session.saveSampleCache(new EchartOpt());
			Session.saveDrawCache(new EchartOpt());

			return Ajax.responseString(CST.RES_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * stdType:(获取标准化值类型). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/stdType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String stdType() {
		try {

			List<TmStdType> record = tmStdTypeDao.findAll();
			List<Select<String>> res = record.stream().map(rs -> {
				Select<String> bean = new Select<String>();
				bean.setCode(rs.getStdId());
				bean.setValue(rs.getStdName());
				return bean;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * mineralType:(获取矿物种类). <br/>
	 * 
	 * @author liboqiang
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/mineralType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String mineralType() {
		try {

			List<TmMineral> record = tmMineralDao.findAll();
			List<Select<String>> res = record.stream().sorted((s1, s2) -> s1.getIndex().compareTo(s2.getIndex())).map(rs -> {
				Select<String> bean = new Select<>();
				bean.setCode(String.valueOf(rs.getIndex()));
				bean.setValue(rs.getMineralName());
				return bean;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * exprType:(获取定量公式). <br/>
	 * 
	 * @author liboqiang
	 * @param exprType:公式类型
	 *            0->结晶 1->熔融
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/exprType", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String exprType(int exprType) {
		try {
			List<TmExpr> record = tmExprDao.fetchByExprType(exprType);
			List<Select<String>> res = record.stream().map(rs -> {
				Select<String> bean = new Select<>();
				bean.setCode(rs.getExprId());
				bean.setValue(rs.getExprName());
				return bean;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * initial:(获取初始岩浆/熔体). <br/>
	 * 
	 * @author liboqiang
	 * @param initialType
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/initial", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String initial(int initialType) {
		try {
			List<TmInitialType> record = tmInitialTypeDao.fetchByInitialTyp(initialType);
			List<Select<String>> res = record.stream().map(rs -> {
				Select<String> bean = new Select<>();
				bean.setCode(rs.getInitialId());
				bean.setValue(rs.getInitialName());
				return bean;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * meltBody:(获取初始熔体下拉菜单). <br/>
	 * 
	 * @author liboqiang
	 * @param dataType
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/sampleData", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String sampleData(int sampleType) {
		try {
			// 定义数据对象
			Map<String, List<Map<String, Double>>> data = null;
			// 获取用户导入数据
			if (CST.IMP_DATA_TYPE_CRYSTAL == sampleType) {
				data = Session.getCrystalData();
			} else {
				data = Session.getMeltData();
			}

			List<Select<String>> res = data.keySet().stream().map(rs -> {
				Select<String> bean = new Select<>();
				bean.setCode(rs);
				bean.setValue(Utils.base64Decode(rs));
				return bean;
			}).collect(Collectors.toList());

			return Ajax.responseString(CST.RES_SUCCESS, res);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
	}

	/**
	 * 
	 * upload:(导入数据文件). <br/>
	 * 
	 * @author liboqiang
	 * @param importData
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String upload(ImportData importData) {
		try {
			// 获取文件
			MultipartFile file = importData.getFile();
			// 获取输入流
			InputStream ins = file.getInputStream();
			// 获取文件名和文件扩展名
			String fileName = file.getOriginalFilename();
			String extType = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

			if (!CST.FILE_TYPE_XLS.equals(extType) && !CST.FILE_TYPE_XLSX.equals(extType)) {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, "您上传的文件格式不正确，请上传扩展名为xls或者xlsx的文件");
			}

			Map<String, List<Map<String, Double>>> userData = excelService.transferData(ins, extType);

			// 用户导入数据存入session
			if (CST.IMP_DATA_TYPE_CRYSTAL == importData.getDataType()) {
				Session.saveCrystalData(userData);
			} else {
				Session.saveMeltData(userData);
			}

			return Ajax.responseString(CST.RES_SUCCESS, "数据导入成功");
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof SystemException || e instanceof BusinessException) {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, e.getMessage());
			} else {
				return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
			}
		}
	}

	/**
	 * 
	 * stdChart:(根据标准化值改变图形). <br/>
	 * 
	 * @author liboqiang
	 * @param data
	 * @return
	 * @since JDK 1.6
	 */
	@RequestMapping(value = "/stdChart", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String stdChart(String stdId) {
		try {
			// 获取标准化值
			List<Double> stdReeData = commonService.getStdData(CST.REE_ELE_INDEX_ARRAY, stdId);
			List<Double> stdTraceData = commonService.getStdData(CST.TRACE_ELE_INDEX_ARRAY, stdId);

			// 获取页面数据
			List<Serie> ree = commonService.divideByStd(Session.getSampleCache().getRee(), stdReeData);
			List<Serie> trace = commonService.divideByStd(Session.getSampleCache().getTrace(), stdTraceData);
			List<String> legend = Session.getSampleCache().getLegend();

			// 获取初始岩浆或者熔体数据
			ree.addAll(commonService.divideByStd(Session.getInitialCache().getRee(), stdReeData));
			trace.addAll(commonService.divideByStd(Session.getInitialCache().getTrace(), stdTraceData));
			legend.addAll(Session.getInitialCache().getLegend());

			// 获取绘图数据
			ree.addAll(commonService.divideByStd(Session.getDrawCache().getRee(), stdReeData));
			trace.addAll(commonService.divideByStd(Session.getDrawCache().getTrace(), stdTraceData));
			legend.addAll(Session.getDrawCache().getLegend());

			EchartOpt data = new EchartOpt();
			data.setRee(ree);
			data.setTrace(trace);
			data.setLegend(legend);
			return Ajax.responseString(CST.RES_SUCCESS, data);
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
	@RequestMapping(value = "/initialChart", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String initialChart(String initialId, String stdId, String legend) {
		try {
			EchartOpt opt = new EchartOpt();
			List<Double> stdRee = new ArrayList<>();
			List<Double> stdTrace = new ArrayList<>();
			List<String> legendLst = new ArrayList<>();
			legendLst.add(legend);

			// 如果存在标准化值ID,获取标准化值
			if (!StringUtils.isEmpty(stdId) || CST.NOT_EXIST.equals(stdId)) {
				stdRee = commonService.getStdData(CST.REE_ELE_INDEX_ARRAY, stdId);
				stdTrace = commonService.getStdData(CST.TRACE_ELE_INDEX_ARRAY, stdId);
			}

			// 获取初始岩浆或者熔体数据
			opt.setRee(getInitialSeries(commonService.getInitialData(CST.REE_ELE_INDEX_ARRAY, initialId), legend));
			opt.setTrace(getInitialSeries(commonService.getInitialData(CST.TRACE_ELE_INDEX_ARRAY, initialId), legend));
			opt.setLegend(legendLst);

			// 存入缓存
			Session.saveInitialCache(Utils.clone(opt));

			// 除以标准化值
			opt.setRee(commonService.divideByStd(opt.getRee(), stdRee));
			opt.setTrace(commonService.divideByStd(opt.getTrace(), stdTrace));

			// 获取样品数据
			opt.getRee().addAll(commonService.divideByStd(Session.getSampleCache().getRee(), stdRee));
			opt.getTrace().addAll(commonService.divideByStd(Session.getSampleCache().getTrace(), stdTrace));
			opt.getLegend().addAll(Session.getSampleCache().getLegend());

			// 获取绘图数据
			opt.getRee().addAll(commonService.divideByStd(Session.getDrawCache().getRee(), stdRee));
			opt.getTrace().addAll(commonService.divideByStd(Session.getDrawCache().getTrace(), stdTrace));
			opt.getLegend().addAll(Session.getDrawCache().getLegend());

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
	@RequestMapping(value = "/sampleChart", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String simpleChart(@RequestParam("sampleCodes[]") List<String> sampleCodes, String stdId, int sampleType) {
		try {
			EchartOpt opt = new EchartOpt();
			List<Double> stdRee = new ArrayList<>();
			List<Double> stdTrace = new ArrayList<>();
			// 如果存在标准化值ID,获取标准化值
			if (!StringUtils.isEmpty(stdId) || CST.NOT_EXIST.equals(stdId)) {
				stdRee = commonService.getStdData(CST.REE_ELE_INDEX_ARRAY, stdId);
				stdTrace = commonService.getStdData(CST.TRACE_ELE_INDEX_ARRAY, stdId);
			}
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

				// 除以标准化值
				opt.setRee(commonService.divideByStd(opt.getRee(), stdRee));
				opt.setTrace(commonService.divideByStd(opt.getTrace(), stdTrace));
			}
			// 获取缓存数据
			opt.getRee().addAll(commonService.divideByStd(Session.getInitialCache().getRee(), stdRee));
			opt.getTrace().addAll(commonService.divideByStd(Session.getInitialCache().getTrace(), stdTrace));
			opt.getLegend().addAll(Session.getInitialCache().getLegend());

			// 获取绘图数据
			opt.getRee().addAll(commonService.divideByStd(Session.getDrawCache().getRee(), stdRee));
			opt.getTrace().addAll(commonService.divideByStd(Session.getDrawCache().getTrace(), stdTrace));
			opt.getLegend().addAll(Session.getDrawCache().getLegend());

			return Ajax.responseString(CST.RES_SUCCESS, opt);
		} catch (Exception e) {
			e.printStackTrace();
			return Ajax.responseString(CST.RES_AUTO_DIALOG, CST.MSG_SYS_ERR);
		}
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
}
