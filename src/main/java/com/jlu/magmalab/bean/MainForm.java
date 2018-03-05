package com.jlu.magmalab.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MainForm implements Serializable {

	/** 生成的序列号 **/
	private static final long serialVersionUID = 8968042052714753811L;

	// 申请ID
	private String applyId;
	
	//产品类型信息
	private String proType;

	// 基本信息
	private String name;
	private String sex;
	private String age;
	private String isMarried;
	private String hasChild;
	private String idCodeType;
	private String idCode;
	private String idPolice;
	private String idAddr;
	private String idAddrPostCode;
	private String rsdType;
	private String rsdAge;
	private String addr;
	private String addrPostCode;
	private String eduLevel;
	private String compName;
	private String career;
	private String compType;
	private String compAddr;
	private String compPostCode;
	private String position;
	private String jobTitle;
	private String telNo;
	private String compNo;
	private String cellNo;

	// 家庭信息
	private String wagesPm;
	private String annualE;
	private String paymentPm;
	private String spouseName;
	private String spouseAge;
	private String spouseJobTitle;
	private String spousePolice;
	private String spouseIdCode;
	private String spouseWagesPm;
	private String spouseIdAddr;
	private String spouseCompAddr;
	private String spouseComp;
	private String spouseCellNo;
	private String spouseCompNo;
	private String spouseCompPostCode;

	// 车辆信息
	private String carType;
	private String carPrice;
	private String loanVal;
	private String loanAge;
	private String adPaymentPt;

	// 上传图片
	private MultipartFile[] carRegPic;
	private MultipartFile[] carPic;
	private MultipartFile[] homePic;
	private MultipartFile[] householdPic;
	private MultipartFile[] drivePic;
	private MultipartFile[] marriedPic;
	private MultipartFile[] examPic;
	private MultipartFile[] idPic;
	private MultipartFile[] bankPic;
	private MultipartFile[] driveUsePic;
	private MultipartFile[] creditPic;

	/**
	 * name.
	 * 
	 * @return the name
	 * @since JDK 1.6
	 */
	public String getName() {
		return name;
	}

	/**
	 * name.
	 * 
	 * @param name
	 *            the name to set
	 * @since JDK 1.6
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * sex.
	 * 
	 * @return the sex
	 * @since JDK 1.6
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * sex.
	 * 
	 * @param sex
	 *            the sex to set
	 * @since JDK 1.6
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * age.
	 * 
	 * @return the age
	 * @since JDK 1.6
	 */
	public String getAge() {
		return age;
	}

	/**
	 * age.
	 * 
	 * @param age
	 *            the age to set
	 * @since JDK 1.6
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * isMarried.
	 * 
	 * @return the isMarried
	 * @since JDK 1.6
	 */
	public String getIsMarried() {
		return isMarried;
	}

	/**
	 * isMarried.
	 * 
	 * @param isMarried
	 *            the isMarried to set
	 * @since JDK 1.6
	 */
	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}

	/**
	 * hasChild.
	 * 
	 * @return the hasChild
	 * @since JDK 1.6
	 */
	public String getHasChild() {
		return hasChild;
	}

	/**
	 * hasChild.
	 * 
	 * @param hasChild
	 *            the hasChild to set
	 * @since JDK 1.6
	 */
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	/**
	 * idCodeType.
	 * 
	 * @return the idCodeType
	 * @since JDK 1.6
	 */
	public String getIdCodeType() {
		return idCodeType;
	}

	/**
	 * idCodeType.
	 * 
	 * @param idCodeType
	 *            the idCodeType to set
	 * @since JDK 1.6
	 */
	public void setIdCodeType(String idCodeType) {
		this.idCodeType = idCodeType;
	}

	/**
	 * idCode.
	 * 
	 * @return the idCode
	 * @since JDK 1.6
	 */
	public String getIdCode() {
		return idCode;
	}

	/**
	 * idCode.
	 * 
	 * @param idCode
	 *            the idCode to set
	 * @since JDK 1.6
	 */
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	/**
	 * idPolice.
	 * 
	 * @return the idPolice
	 * @since JDK 1.6
	 */
	public String getIdPolice() {
		return idPolice;
	}

	/**
	 * idPolice.
	 * 
	 * @param idPolice
	 *            the idPolice to set
	 * @since JDK 1.6
	 */
	public void setIdPolice(String idPolice) {
		this.idPolice = idPolice;
	}

	/**
	 * idAddr.
	 * 
	 * @return the idAddr
	 * @since JDK 1.6
	 */
	public String getIdAddr() {
		return idAddr;
	}

	/**
	 * idAddr.
	 * 
	 * @param idAddr
	 *            the idAddr to set
	 * @since JDK 1.6
	 */
	public void setIdAddr(String idAddr) {
		this.idAddr = idAddr;
	}

	/**
	 * idAddrPostCode.
	 * 
	 * @return the idAddrPostCode
	 * @since JDK 1.6
	 */
	public String getIdAddrPostCode() {
		return idAddrPostCode;
	}

	/**
	 * idAddrPostCode.
	 * 
	 * @param idAddrPostCode
	 *            the idAddrPostCode to set
	 * @since JDK 1.6
	 */
	public void setIdAddrPostCode(String idAddrPostCode) {
		this.idAddrPostCode = idAddrPostCode;
	}

	/**
	 * rsdType.
	 * 
	 * @return the rsdType
	 * @since JDK 1.6
	 */
	public String getRsdType() {
		return rsdType;
	}

	/**
	 * rsdType.
	 * 
	 * @param rsdType
	 *            the rsdType to set
	 * @since JDK 1.6
	 */
	public void setRsdType(String rsdType) {
		this.rsdType = rsdType;
	}

	/**
	 * rsdAge.
	 * 
	 * @return the rsdAge
	 * @since JDK 1.6
	 */
	public String getRsdAge() {
		return rsdAge;
	}

	/**
	 * rsdAge.
	 * 
	 * @param rsdAge
	 *            the rsdAge to set
	 * @since JDK 1.6
	 */
	public void setRsdAge(String rsdAge) {
		this.rsdAge = rsdAge;
	}

	/**
	 * addr.
	 * 
	 * @return the addr
	 * @since JDK 1.6
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * addr.
	 * 
	 * @param addr
	 *            the addr to set
	 * @since JDK 1.6
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * addrPostCode.
	 * 
	 * @return the addrPostCode
	 * @since JDK 1.6
	 */
	public String getAddrPostCode() {
		return addrPostCode;
	}

	/**
	 * addrPostCode.
	 * 
	 * @param addrPostCode
	 *            the addrPostCode to set
	 * @since JDK 1.6
	 */
	public void setAddrPostCode(String addrPostCode) {
		this.addrPostCode = addrPostCode;
	}

	/**
	 * eduLevel.
	 * 
	 * @return the eduLevel
	 * @since JDK 1.6
	 */
	public String getEduLevel() {
		return eduLevel;
	}

	/**
	 * eduLevel.
	 * 
	 * @param eduLevel
	 *            the eduLevel to set
	 * @since JDK 1.6
	 */
	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	/**
	 * compName.
	 * 
	 * @return the compName
	 * @since JDK 1.6
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * compName.
	 * 
	 * @param compName
	 *            the compName to set
	 * @since JDK 1.6
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}

	/**
	 * career.
	 * 
	 * @return the career
	 * @since JDK 1.6
	 */
	public String getCareer() {
		return career;
	}

	/**
	 * career.
	 * 
	 * @param career
	 *            the career to set
	 * @since JDK 1.6
	 */
	public void setCareer(String career) {
		this.career = career;
	}

	/**
	 * compType.
	 * 
	 * @return the compType
	 * @since JDK 1.6
	 */
	public String getCompType() {
		return compType;
	}

	/**
	 * compType.
	 * 
	 * @param compType
	 *            the compType to set
	 * @since JDK 1.6
	 */
	public void setCompType(String compType) {
		this.compType = compType;
	}

	/**
	 * position.
	 * 
	 * @return the position
	 * @since JDK 1.6
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * position.
	 * 
	 * @param position
	 *            the position to set
	 * @since JDK 1.6
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * jobTitle.
	 * 
	 * @return the jobTitle
	 * @since JDK 1.6
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * jobTitle.
	 * 
	 * @param jobTitle
	 *            the jobTitle to set
	 * @since JDK 1.6
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * telNo.
	 * 
	 * @return the telNo
	 * @since JDK 1.6
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * telNo.
	 * 
	 * @param telNo
	 *            the telNo to set
	 * @since JDK 1.6
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * compNo.
	 * 
	 * @return the compNo
	 * @since JDK 1.6
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * compNo.
	 * 
	 * @param compNo
	 *            the compNo to set
	 * @since JDK 1.6
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * cellNo.
	 * 
	 * @return the cellNo
	 * @since JDK 1.6
	 */
	public String getCellNo() {
		return cellNo;
	}

	/**
	 * cellNo.
	 * 
	 * @param cellNo
	 *            the cellNo to set
	 * @since JDK 1.6
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	/**
	 * wagesPm.
	 * 
	 * @return the wagesPm
	 * @since JDK 1.6
	 */
	public String getWagesPm() {
		return wagesPm;
	}

	/**
	 * wagesPm.
	 * 
	 * @param wagesPm
	 *            the wagesPm to set
	 * @since JDK 1.6
	 */
	public void setWagesPm(String wagesPm) {
		this.wagesPm = wagesPm;
	}

	/**
	 * annualE.
	 * 
	 * @return the annualE
	 * @since JDK 1.6
	 */
	public String getAnnualE() {
		return annualE;
	}

	/**
	 * annualE.
	 * 
	 * @param annualE
	 *            the annualE to set
	 * @since JDK 1.6
	 */
	public void setAnnualE(String annualE) {
		this.annualE = annualE;
	}

	/**
	 * paymentPm.
	 * 
	 * @return the paymentPm
	 * @since JDK 1.6
	 */
	public String getPaymentPm() {
		return paymentPm;
	}

	/**
	 * paymentPm.
	 * 
	 * @param paymentPm
	 *            the paymentPm to set
	 * @since JDK 1.6
	 */
	public void setPaymentPm(String paymentPm) {
		this.paymentPm = paymentPm;
	}

	/**
	 * spouseName.
	 * 
	 * @return the spouseName
	 * @since JDK 1.6
	 */
	public String getSpouseName() {
		return spouseName;
	}

	/**
	 * spouseName.
	 * 
	 * @param spouseName
	 *            the spouseName to set
	 * @since JDK 1.6
	 */
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	/**
	 * spouseAge.
	 * 
	 * @return the spouseAge
	 * @since JDK 1.6
	 */
	public String getSpouseAge() {
		return spouseAge;
	}

	/**
	 * spouseAge.
	 * 
	 * @param spouseAge
	 *            the spouseAge to set
	 * @since JDK 1.6
	 */
	public void setSpouseAge(String spouseAge) {
		this.spouseAge = spouseAge;
	}

	/**
	 * spousePolice.
	 * 
	 * @return the spousePolice
	 * @since JDK 1.6
	 */
	public String getSpousePolice() {
		return spousePolice;
	}

	/**
	 * spousePolice.
	 * 
	 * @param spousePolice
	 *            the spousePolice to set
	 * @since JDK 1.6
	 */
	public void setSpousePolice(String spousePolice) {
		this.spousePolice = spousePolice;
	}

	/**
	 * spouseIdCode.
	 * 
	 * @return the spouseIdCode
	 * @since JDK 1.6
	 */
	public String getSpouseIdCode() {
		return spouseIdCode;
	}

	/**
	 * spouseIdCode.
	 * 
	 * @param spouseIdCode
	 *            the spouseIdCode to set
	 * @since JDK 1.6
	 */
	public void setSpouseIdCode(String spouseIdCode) {
		this.spouseIdCode = spouseIdCode;
	}

	/**
	 * spouseWagesPm.
	 * 
	 * @return the spouseWagesPm
	 * @since JDK 1.6
	 */
	public String getSpouseWagesPm() {
		return spouseWagesPm;
	}

	/**
	 * spouseWagesPm.
	 * 
	 * @param spouseWagesPm
	 *            the spouseWagesPm to set
	 * @since JDK 1.6
	 */
	public void setSpouseWagesPm(String spouseWagesPm) {
		this.spouseWagesPm = spouseWagesPm;
	}

	/**
	 * spouseIdAddr.
	 * 
	 * @return the spouseIdAddr
	 * @since JDK 1.6
	 */
	public String getSpouseIdAddr() {
		return spouseIdAddr;
	}

	/**
	 * spouseIdAddr.
	 * 
	 * @param spouseIdAddr
	 *            the spouseIdAddr to set
	 * @since JDK 1.6
	 */
	public void setSpouseIdAddr(String spouseIdAddr) {
		this.spouseIdAddr = spouseIdAddr;
	}

	/**
	 * spouseCompAddr.
	 * 
	 * @return the spouseCompAddr
	 * @since JDK 1.6
	 */
	public String getSpouseCompAddr() {
		return spouseCompAddr;
	}

	/**
	 * spouseCompAddr.
	 * 
	 * @param spouseCompAddr
	 *            the spouseCompAddr to set
	 * @since JDK 1.6
	 */
	public void setSpouseCompAddr(String spouseCompAddr) {
		this.spouseCompAddr = spouseCompAddr;
	}

	/**
	 * spouseComp.
	 * 
	 * @return the spouseComp
	 * @since JDK 1.6
	 */
	public String getSpouseComp() {
		return spouseComp;
	}

	/**
	 * spouseComp.
	 * 
	 * @param spouseComp
	 *            the spouseComp to set
	 * @since JDK 1.6
	 */
	public void setSpouseComp(String spouseComp) {
		this.spouseComp = spouseComp;
	}

	/**
	 * spouseCellNo.
	 * 
	 * @return the spouseCellNo
	 * @since JDK 1.6
	 */
	public String getSpouseCellNo() {
		return spouseCellNo;
	}

	/**
	 * spouseCellNo.
	 * 
	 * @param spouseCellNo
	 *            the spouseCellNo to set
	 * @since JDK 1.6
	 */
	public void setSpouseCellNo(String spouseCellNo) {
		this.spouseCellNo = spouseCellNo;
	}

	/**
	 * spouseCompNo.
	 * 
	 * @return the spouseCompNo
	 * @since JDK 1.6
	 */
	public String getSpouseCompNo() {
		return spouseCompNo;
	}

	/**
	 * spouseCompNo.
	 * 
	 * @param spouseCompNo
	 *            the spouseCompNo to set
	 * @since JDK 1.6
	 */
	public void setSpouseCompNo(String spouseCompNo) {
		this.spouseCompNo = spouseCompNo;
	}

	/**
	 * spouseCompPostCode.
	 * 
	 * @return the spouseCompPostCode
	 * @since JDK 1.6
	 */
	public String getSpouseCompPostCode() {
		return spouseCompPostCode;
	}

	/**
	 * spouseCompPostCode.
	 * 
	 * @param spouseCompPostCode
	 *            the spouseCompPostCode to set
	 * @since JDK 1.6
	 */
	public void setSpouseCompPostCode(String spouseCompPostCode) {
		this.spouseCompPostCode = spouseCompPostCode;
	}

	/**
	 * carType.
	 * 
	 * @return the carType
	 * @since JDK 1.6
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * carType.
	 * 
	 * @param carType
	 *            the carType to set
	 * @since JDK 1.6
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * carPrice.
	 * 
	 * @return the carPrice
	 * @since JDK 1.6
	 */
	public String getCarPrice() {
		return carPrice;
	}

	/**
	 * carPrice.
	 * 
	 * @param carPrice
	 *            the carPrice to set
	 * @since JDK 1.6
	 */
	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}

	/**
	 * loanVal.
	 * 
	 * @return the loanVal
	 * @since JDK 1.6
	 */
	public String getLoanVal() {
		return loanVal;
	}

	/**
	 * loanVal.
	 * 
	 * @param loanVal
	 *            the loanVal to set
	 * @since JDK 1.6
	 */
	public void setLoanVal(String loanVal) {
		this.loanVal = loanVal;
	}

	/**
	 * loanAge.
	 * 
	 * @return the loanAge
	 * @since JDK 1.6
	 */
	public String getLoanAge() {
		return loanAge;
	}

	/**
	 * loanAge.
	 * 
	 * @param loanAge
	 *            the loanAge to set
	 * @since JDK 1.6
	 */
	public void setLoanAge(String loanAge) {
		this.loanAge = loanAge;
	}

	/**
	 * adPaymentPt.
	 * 
	 * @return the adPaymentPt
	 * @since JDK 1.6
	 */
	public String getAdPaymentPt() {
		return adPaymentPt;
	}

	/**
	 * adPaymentPt.
	 * 
	 * @param adPaymentPt
	 *            the adPaymentPt to set
	 * @since JDK 1.6
	 */
	public void setAdPaymentPt(String adPaymentPt) {
		this.adPaymentPt = adPaymentPt;
	}

	/**
	 * carRegPic.
	 * 
	 * @return the carRegPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getCarRegPic() {
		return carRegPic;
	}

	/**
	 * carRegPic.
	 * 
	 * @param carRegPic
	 *            the carRegPic to set
	 * @since JDK 1.6
	 */
	public void setCarRegPic(MultipartFile[] carRegPic) {
		this.carRegPic = carRegPic;
	}

	/**
	 * carPic.
	 * 
	 * @return the carPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getCarPic() {
		return carPic;
	}

	/**
	 * carPic.
	 * 
	 * @param carPic
	 *            the carPic to set
	 * @since JDK 1.6
	 */
	public void setCarPic(MultipartFile[] carPic) {
		this.carPic = carPic;
	}

	/**
	 * homePic.
	 * 
	 * @return the homePic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getHomePic() {
		return homePic;
	}

	/**
	 * homePic.
	 * 
	 * @param homePic
	 *            the homePic to set
	 * @since JDK 1.6
	 */
	public void setHomePic(MultipartFile[] homePic) {
		this.homePic = homePic;
	}

	/**
	 * householdPic.
	 * 
	 * @return the householdPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getHouseholdPic() {
		return householdPic;
	}

	/**
	 * householdPic.
	 * 
	 * @param householdPic
	 *            the householdPic to set
	 * @since JDK 1.6
	 */
	public void setHouseholdPic(MultipartFile[] householdPic) {
		this.householdPic = householdPic;
	}

	/**
	 * drivePic.
	 * 
	 * @return the drivePic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getDrivePic() {
		return drivePic;
	}

	/**
	 * drivePic.
	 * 
	 * @param drivePic
	 *            the drivePic to set
	 * @since JDK 1.6
	 */
	public void setDrivePic(MultipartFile[] drivePic) {
		this.drivePic = drivePic;
	}

	/**
	 * marriedPic.
	 * 
	 * @return the marriedPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getMarriedPic() {
		return marriedPic;
	}

	/**
	 * marriedPic.
	 * 
	 * @param marriedPic
	 *            the marriedPic to set
	 * @since JDK 1.6
	 */
	public void setMarriedPic(MultipartFile[] marriedPic) {
		this.marriedPic = marriedPic;
	}

	/**
	 * examPic.
	 * 
	 * @return the examPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getExamPic() {
		return examPic;
	}

	/**
	 * examPic.
	 * 
	 * @param examPic
	 *            the examPic to set
	 * @since JDK 1.6
	 */
	public void setExamPic(MultipartFile[] examPic) {
		this.examPic = examPic;
	}

	/**
	 * idPic.
	 * 
	 * @return the idPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getIdPic() {
		return idPic;
	}

	/**
	 * idPic.
	 * 
	 * @param idPic
	 *            the idPic to set
	 * @since JDK 1.6
	 */
	public void setIdPic(MultipartFile[] idPic) {
		this.idPic = idPic;
	}

	/**
	 * bankPic.
	 * 
	 * @return the bankPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getBankPic() {
		return bankPic;
	}

	/**
	 * bankPic.
	 * 
	 * @param bankPic
	 *            the bankPic to set
	 * @since JDK 1.6
	 */
	public void setBankPic(MultipartFile[] bankPic) {
		this.bankPic = bankPic;
	}

	/**
	 * driveUsePic.
	 * 
	 * @return the driveUsePic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getDriveUsePic() {
		return driveUsePic;
	}

	/**
	 * driveUsePic.
	 * 
	 * @param driveUsePic
	 *            the driveUsePic to set
	 * @since JDK 1.6
	 */
	public void setDriveUsePic(MultipartFile[] driveUsePic) {
		this.driveUsePic = driveUsePic;
	}

	/**
	 * creditPic.
	 * 
	 * @return the creditPic
	 * @since JDK 1.6
	 */
	public MultipartFile[] getCreditPic() {
		return creditPic;
	}

	/**
	 * creditPic.
	 * 
	 * @param creditPic
	 *            the creditPic to set
	 * @since JDK 1.6
	 */
	public void setCreditPic(MultipartFile[] creditPic) {
		this.creditPic = creditPic;
	}

	/**
	 * compAddr.
	 * 
	 * @return the compAddr
	 * @since JDK 1.6
	 */
	public String getCompAddr() {
		return compAddr;
	}

	/**
	 * compAddr.
	 * 
	 * @param compAddr
	 *            the compAddr to set
	 * @since JDK 1.6
	 */
	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	/**
	 * compPostCode.
	 * 
	 * @return the compPostCode
	 * @since JDK 1.6
	 */
	public String getCompPostCode() {
		return compPostCode;
	}

	/**
	 * compPostCode.
	 * 
	 * @param compPostCode
	 *            the compPostCode to set
	 * @since JDK 1.6
	 */
	public void setCompPostCode(String compPostCode) {
		this.compPostCode = compPostCode;
	}

	/**
	 * spouseJobTitle.
	 * 
	 * @return the spouseJobTitle
	 * @since JDK 1.6
	 */
	public String getSpouseJobTitle() {
		return spouseJobTitle;
	}

	/**
	 * spouseJobTitle.
	 * 
	 * @param spouseJobTitle
	 *            the spouseJobTitle to set
	 * @since JDK 1.6
	 */
	public void setSpouseJobTitle(String spouseJobTitle) {
		this.spouseJobTitle = spouseJobTitle;
	}

	/** 
	* applyId. 
	* 
	* @return  the applyId 
	* @since   JDK 1.6 
	*/
	public String getApplyId() {
		return applyId;
	}

	/** 
	 * applyId. 
	 * 
	 * @param   applyId    the applyId to set 
	 * @since   JDK 1.6 
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	/** 
	* proType. 
	* 
	* @return  the proType 
	* @since   JDK 1.6 
	*/
	public String getProType() {
		return proType;
	}

	/** 
	 * proType. 
	 * 
	 * @param   proType    the proType to set 
	 * @since   JDK 1.6 
	 */
	public void setProType(String proType) {
		this.proType = proType;
	}
}
