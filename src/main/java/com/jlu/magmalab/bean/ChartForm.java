package com.jlu.magmalab.bean;

import java.util.List;

/**
 * 
 * ClassName: ChartForm <br/>
 * Function: 绘图表单. <br/>
 * date: 2018年3月14日 上午9:56:06 <br/>
 * 
 * @author liboqiang
 * @version
 * @since JDK 1.6
 */
public class ChartForm {

	/** 矿物比例(D) **/
	private List<Select<Double>> mineralsD;

	/** 矿物比例(P) **/
	private List<Select<Double>> mineralsP;

	/** 公式Id **/
	private String exprId;

	/** 混染物体Id **/
	private String mixId;

	/** 标准化值Id **/
	private String stdId;

	/** 岩浆类型 **/
	private Integer magmaType;

	/**
	 * 混染程度
	 */
	private double cR;

	/**
	 * 结晶程度
	 */
	private double fVal;

	/**
	 * 同化作用速率（Ma）与分离结晶速率（Mc）的比值
	 */
	private double mR;

	/** 图例名称 **/
	private String legend;

	/** 是否为预览 **/
	private boolean preview;

	/**
	 * mineralsD.
	 * 
	 * @return the mineralsD
	 * @since JDK 1.6
	 */
	public List<Select<Double>> getMineralsD() {
		return mineralsD;
	}

	/**
	 * mineralsD.
	 * 
	 * @param mineralsD
	 *            the mineralsD to set
	 * @since JDK 1.6
	 */
	public void setMineralsD(List<Select<Double>> mineralsD) {
		this.mineralsD = mineralsD;
	}

	/**
	 * mineralsP.
	 * 
	 * @return the mineralsP
	 * @since JDK 1.6
	 */
	public List<Select<Double>> getMineralsP() {
		return mineralsP;
	}

	/**
	 * mineralsP.
	 * 
	 * @param mineralsP
	 *            the mineralsP to set
	 * @since JDK 1.6
	 */
	public void setMineralsP(List<Select<Double>> mineralsP) {
		this.mineralsP = mineralsP;
	}

	/**
	 * exprId.
	 * 
	 * @return the exprId
	 * @since JDK 1.6
	 */
	public String getExprId() {
		return exprId;
	}

	/**
	 * exprId.
	 * 
	 * @param exprId
	 *            the exprId to set
	 * @since JDK 1.6
	 */
	public void setExprId(String exprId) {
		this.exprId = exprId;
	}

	/**
	 * mixId.
	 * 
	 * @return the mixId
	 * @since JDK 1.6
	 */
	public String getMixId() {
		return mixId;
	}

	/**
	 * mixId.
	 * 
	 * @param mixId
	 *            the mixId to set
	 * @since JDK 1.6
	 */
	public void setMixId(String mixId) {
		this.mixId = mixId;
	}

	/**
	 * stdId.
	 * 
	 * @return the stdId
	 * @since JDK 1.6
	 */
	public String getStdId() {
		return stdId;
	}

	/**
	 * stdId.
	 * 
	 * @param stdId
	 *            the stdId to set
	 * @since JDK 1.6
	 */
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	/**
	 * magmaType.
	 * 
	 * @return the magmaType
	 * @since JDK 1.6
	 */
	public Integer getMagmaType() {
		return magmaType;
	}

	/**
	 * magmaType.
	 * 
	 * @param magmaType
	 *            the magmaType to set
	 * @since JDK 1.6
	 */
	public void setMagmaType(Integer magmaType) {
		this.magmaType = magmaType;
	}

	/**
	 * cR.
	 * 
	 * @return the cR
	 * @since JDK 1.6
	 */
	public double getcR() {
		return cR;
	}

	/**
	 * cR.
	 * 
	 * @param cR
	 *            the cR to set
	 * @since JDK 1.6
	 */
	public void setcR(double cR) {
		this.cR = cR;
	}

	/**
	 * fVal.
	 * 
	 * @return the fVal
	 * @since JDK 1.6
	 */
	public double getfVal() {
		return fVal;
	}

	/**
	 * fVal.
	 * 
	 * @param fVal
	 *            the fVal to set
	 * @since JDK 1.6
	 */
	public void setfVal(double fVal) {
		this.fVal = fVal;
	}

	/**
	 * mR.
	 * 
	 * @return the mR
	 * @since JDK 1.6
	 */
	public double getmR() {
		return mR;
	}

	/**
	 * mR.
	 * 
	 * @param mR
	 *            the mR to set
	 * @since JDK 1.6
	 */
	public void setmR(double mR) {
		this.mR = mR;
	}

	/**
	 * legend.
	 * 
	 * @return the legend
	 * @since JDK 1.6
	 */
	public String getLegend() {
		return legend;
	}

	/**
	 * legend.
	 * 
	 * @param legend
	 *            the legend to set
	 * @since JDK 1.6
	 */
	public void setLegend(String legend) {
		this.legend = legend;
	}

	/**
	 * preview.
	 * 
	 * @return the preview
	 * @since JDK 1.6
	 */
	public boolean isPreview() {
		return preview;
	}

	/**
	 * preview.
	 * 
	 * @param preview
	 *            the preview to set
	 * @since JDK 1.6
	 */
	public void setPreview(boolean preview) {
		this.preview = preview;
	}
}
