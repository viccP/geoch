package com.jlu.magmalab.expr;

import org.ujmp.core.Matrix;

/**
 * 
 * ClassName: Parameter <br/> 
 * Function: 参数Bean. <br/> 
 * date: 2018年3月5日 下午2:03:51 <br/> 
 * 
 * @author liboqiang 
 * @version  
 * @since JDK 1.6
 */
public class Parameter {

	/**
	 * 原始熔体元素浓度
	 */
	private Matrix C0;
	
	/**
	 * 围岩元素浓度
	 */
	private Matrix CA;
	
	/**
	 * 熔体总分配系数
	 */
	private Matrix D;
	
	/**
	 * 残余固相总分配系数
	 */
	private Matrix P;
	
	/**
	 * 混染程度
	 */
	private double CR;
	
	/**
	 * 结晶程度
	 */
	private double F;
	
	/**
	 * 同化作用速率（Ma）与分离结晶速率（Mc）的比值
	 */
	private double MR;

	public Matrix getC0() {
		return C0;
	}

	public void setC0(Matrix c0) {
		C0 = c0;
	}

	public Matrix getCA() {
		return CA;
	}

	public void setCA(Matrix cA) {
		CA = cA;
	}

	public Matrix getD() {
		return D;
	}

	public void setD(Matrix d) {
		D = d;
	}

	public Matrix getP() {
		return P;
	}

	public void setP(Matrix p) {
		P = p;
	}

	public double getCR() {
		return CR;
	}

	public void setCR(double cR) {
		CR = cR;
	}

	public double getF() {
		return F;
	}

	public void setF(double f) {
		F = f;
	}

	public double getMR() {
		return MR;
	}

	public void setMR(double mR) {
		MR = mR;
	}
}
