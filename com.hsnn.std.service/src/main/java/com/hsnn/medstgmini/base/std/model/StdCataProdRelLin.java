package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;

public class StdCataProdRelLin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 111225503649133864L;

	//alias
	public static final String TABLE_ALIAS = "StdCataProdRelLin";
	
	//columns START
	
	
	
	/**
	 * @Fields drugcatalogCode:药物目录编码
	 */
	@PropertyNameAnnotation(annotation="药物目录编码")
	private String drugcatalogCode;
	
	/**
	 * @Fields prodId:药品编码
	 */
	@PropertyNameAnnotation(annotation="药品编码")
	private String prodId;
	
	/**
	 * @Fields prodIdStoc:药品入库编码
	 */
	@PropertyNameAnnotation(annotation="药品入库编码")
	private String prodIdStoc;
	
	/**
	 * @Fields productName:通用名
	 */
	@PropertyNameAnnotation(annotation="通用名")
	private String productName;
	
	/**
	 * @Fields productSpelName:通用名拼音码
	 */
	@PropertyNameAnnotation(annotation="通用名拼音码")
	private String productSpelName;
	
	/**
	 * @Fields productWbName:通用名五笔码
	 */
	@PropertyNameAnnotation(annotation="通用名五笔码")
	private String productWbName;
		
	/**
	 * @Fields medicinemodel:剂型
	 */
	@PropertyNameAnnotation(annotation="剂型")
	private String medicinemodel;
	
	/**
	 * @Fields medicinemodelSpel:剂型拼音码
	 */
	@PropertyNameAnnotation(annotation="剂型拼音码")
	private String medicinemodelSpel;
		
	/**
	 * @Fields outlook:规格
	 */
	@PropertyNameAnnotation(annotation="规格")
	private String outlook;
	
	/**
	 * @Fields cataSpelName:目录通用名
	 */
	@PropertyNameAnnotation(annotation="目录通用名")
	private String cataSpelName;
	
	/**
	 * @Fields cataMedicinemodel:目录剂型
	 */
	@PropertyNameAnnotation(annotation="目录剂型")
	private String cataMedicinemodel;
	
	/**
	 * @Fields cataOutlook:目录规格
	 */
	@PropertyNameAnnotation(annotation="目录规格")
	private String cataOutlook;
	
	/**
	 * @Fields cataIndexF:目录序号一
	 */
	@PropertyNameAnnotation(annotation="目录序号一")
	private String cataIndexF;
	
	/**
	 * @Fields cataIndexS:目录序号二
	 */
	@PropertyNameAnnotation(annotation="目录序号二")
	private String cataIndexS;
	
	/**
	 * @Fields classOne:分类一
	 */
	@PropertyNameAnnotation(annotation="分类一")
	private String classOne;
	
	/**
	 * @Fields classTwo:分类二
	 */
	@PropertyNameAnnotation(annotation="分类二")
	private String classTwo;
	
	/**
	 * @Fields pharId:药理分类一编码
	 */
	@PropertyNameAnnotation(annotation="药理分类一编码")
	private String pharOneId;
	
	/**
	 * @Fields pharOne:药理分类一
	 */
	@PropertyNameAnnotation(annotation="药理分类一")
	private String pharOne;
	
	/**
	 * @Fields pharId:药理分类二编码
	 */
	@PropertyNameAnnotation(annotation="药理分类二编码")
	private String pharTwoId;
	
	/**
	 * @Fields pharTwo:药理分类二
	 */
	@PropertyNameAnnotation(annotation="药理分类二")
	private String pharTwo;
	
	/**
	 * @Fields pharId:药理分类三编码
	 */
	@PropertyNameAnnotation(annotation="药理分类三编码")
	private String pharThreeId;
	
	/**
	 * @Fields pharThree:药理分类三
	 */
	@PropertyNameAnnotation(annotation="药理分类三")
	private String pharThree;
	
	/**
	 * @Fields pharFour:药理分类四编码
	 */
	@PropertyNameAnnotation(annotation="药理分类四编码")
	private String pharFourId;
	
	/**
	 * @Fields pharFour:药理分类四
	 */
	@PropertyNameAnnotation(annotation="药理分类四")
	private String pharFour;
	
	/**
	 * @Fields pharFive:药理分类五编码
	 */
	@PropertyNameAnnotation(annotation="药理分类五编码")
	private String pharFiveId;
	
	/**
	 * @Fields pharFive:药理分类五
	 */
	@PropertyNameAnnotation(annotation="药理分类五")
	private String pharFive;
	
	/**
	 * @Fields pharSix:药理分类六编码
	 */
	@PropertyNameAnnotation(annotation="药理分类六编码")
	private String pharSixId;
	
	/**
	 * @Fields pharSix:药理分类六
	 */
	@PropertyNameAnnotation(annotation="药理分类六")
	private String pharSix;
	
	/**
	 * @Fields productAttr:药品属性1中药2西药
	 */
	@PropertyNameAnnotation(annotation="药品属性1中药2西药")
	private String productAttr;
	
	/**
	 * @Fields remark:入库备注
	 */
	@PropertyNameAnnotation(annotation="入库备注")
	private String remark;
	
	/**
	 * @Fields status:状态
	 */
	@PropertyNameAnnotation(annotation="状态")
	private String status;
	
	/**
	 * @Fields auditUserName:审核人
	 */
	@PropertyNameAnnotation(annotation="审核人")
	private String auditUserName;
	
	/**
	 * @Fields auditRemark:审核备注
	 */
	@PropertyNameAnnotation(annotation="审核备注")
	private String auditRemark;
	
	/**
	 * @Fields auditTime:审核时间
	 */
	@PropertyNameAnnotation(annotation="审核时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime;
	
	/**
	 * @Fields isUsing:是否有效
	 */
	@PropertyNameAnnotation(annotation="是否有效(0:停用,1:启用)")
	private String isUsing;

	/**
	 * @Fields addUserId:记录添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:记录添加人
	 */
	@PropertyNameAnnotation(annotation="记录添加人")
	private String addUserName;
	
	/**
	 * @Fields addTime:记录添加时间
	 */
	@PropertyNameAnnotation(annotation="记录添加时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录人")
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	/**
	 * @Fields stdCataProdRelFileId:上传文件存储表id
	 */
	@PropertyNameAnnotation(annotation="上传文件存储表id")
	private String stdCataProdRelFileId;
	
	/**
	 * @Fields checkResult:校验结果
	 */
	@PropertyNameAnnotation(annotation="校验结果")
	private String checkResult;

	//columns END
	
	

	public String getDrugcatalogCode() {
		return drugcatalogCode;
	}

	public void setDrugcatalogCode(String drugcatalogCode) {
		this.drugcatalogCode = drugcatalogCode;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdIdStoc() {
		return prodIdStoc;
	}

	public void setProdIdStoc(String prodIdStoc) {
		this.prodIdStoc = prodIdStoc;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSpelName() {
		return productSpelName;
	}

	public void setProductSpelName(String productSpelName) {
		this.productSpelName = productSpelName;
	}

	public String getProductWbName() {
		return productWbName;
	}

	public void setProductWbName(String productWbName) {
		this.productWbName = productWbName;
	}

	public String getMedicinemodel() {
		return medicinemodel;
	}

	public void setMedicinemodel(String medicinemodel) {
		this.medicinemodel = medicinemodel;
	}

	public String getMedicinemodelSpel() {
		return medicinemodelSpel;
	}

	public void setMedicinemodelSpel(String medicinemodelSpel) {
		this.medicinemodelSpel = medicinemodelSpel;
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}

	public String getCataSpelName() {
		return cataSpelName;
	}

	public void setCataSpelName(String cataSpelName) {
		this.cataSpelName = cataSpelName;
	}

	public String getCataMedicinemodel() {
		return cataMedicinemodel;
	}

	public void setCataMedicinemodel(String cataMedicinemodel) {
		this.cataMedicinemodel = cataMedicinemodel;
	}

	public String getCataOutlook() {
		return cataOutlook;
	}

	public void setCataOutlook(String cataOutlook) {
		this.cataOutlook = cataOutlook;
	}

	public String getCataIndexF() {
		return cataIndexF;
	}

	public void setCataIndexF(String cataIndexF) {
		this.cataIndexF = cataIndexF;
	}

	public String getCataIndexS() {
		return cataIndexS;
	}

	public void setCataIndexS(String cataIndexS) {
		this.cataIndexS = cataIndexS;
	}

	public String getClassOne() {
		return classOne;
	}

	public void setClassOne(String classOne) {
		this.classOne = classOne;
	}

	public String getClassTwo() {
		return classTwo;
	}

	public void setClassTwo(String classTwo) {
		this.classTwo = classTwo;
	}

	public String getPharOneId() {
		return pharOneId;
	}

	public void setPharOneId(String pharOneId) {
		this.pharOneId = pharOneId;
	}

	public String getPharOne() {
		return pharOne;
	}

	public void setPharOne(String pharOne) {
		this.pharOne = pharOne;
	}

	public String getPharTwoId() {
		return pharTwoId;
	}

	public void setPharTwoId(String pharTwoId) {
		this.pharTwoId = pharTwoId;
	}

	public String getPharTwo() {
		return pharTwo;
	}

	public void setPharTwo(String pharTwo) {
		this.pharTwo = pharTwo;
	}

	public String getPharThreeId() {
		return pharThreeId;
	}

	public void setPharThreeId(String pharThreeId) {
		this.pharThreeId = pharThreeId;
	}

	public String getPharThree() {
		return pharThree;
	}

	public void setPharThree(String pharThree) {
		this.pharThree = pharThree;
	}

	public String getPharFourId() {
		return pharFourId;
	}

	public void setPharFourId(String pharFourId) {
		this.pharFourId = pharFourId;
	}

	public String getPharFour() {
		return pharFour;
	}

	public void setPharFour(String pharFour) {
		this.pharFour = pharFour;
	}

	public String getPharFiveId() {
		return pharFiveId;
	}

	public void setPharFiveId(String pharFiveId) {
		this.pharFiveId = pharFiveId;
	}

	public String getPharFive() {
		return pharFive;
	}

	public void setPharFive(String pharFive) {
		this.pharFive = pharFive;
	}

	public String getPharSixId() {
		return pharSixId;
	}

	public void setPharSixId(String pharSixId) {
		this.pharSixId = pharSixId;
	}

	public String getPharSix() {
		return pharSix;
	}

	public void setPharSix(String pharSix) {
		this.pharSix = pharSix;
	}

	public String getProductAttr() {
		return productAttr;
	}

	public void setProductAttr(String productAttr) {
		this.productAttr = productAttr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getIsUsing() {
		return isUsing;
	}

	public void setIsUsing(String isUsing) {
		this.isUsing = isUsing;
	}

	public String getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(String addUserId) {
		this.addUserId = addUserId;
	}

	public String getAddUserName() {
		return addUserName;
	}

	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getStdCataProdRelFileId() {
		return stdCataProdRelFileId;
	}

	public void setStdCataProdRelFileId(String stdCataProdRelFileId) {
		this.stdCataProdRelFileId = stdCataProdRelFileId;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	
	
	
	
	
}