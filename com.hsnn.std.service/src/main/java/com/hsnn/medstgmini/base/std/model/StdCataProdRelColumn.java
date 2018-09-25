package com.hsnn.medstgmini.base.std.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;

public class StdCataProdRelColumn  {

	
	
	//columns START
	
	/**
	 * @Fields relId:基础库_目录药品关联表id
	 */
	@PropertyNameAnnotation(annotation="基础库_目录药品关联表id")
	private String relId;
	
	/**
	 * @Fields drugcatalogCode:药物目录编码
	 */
	@PropertyNameAnnotation(annotation="药物目录编码")
	private String drugcatalogCode;
	
	/**
	 * @Fields drugcatalogCode_key:药物目录编码_key
	 */
	@PropertyNameAnnotation(annotation="药物目录编码_key")
	private String drugcatalogCode_key;
	
	/**
	 * @Fields prodId:药品编码
	 */
	@PropertyNameAnnotation(annotation="药品编码")
	private String prodId;
	
	/**
	 * @Fields prodId_key:药品编码_key
	 */
	@PropertyNameAnnotation(annotation="药品编码_key")
	private String prodId_key;
	
	/**
	 * @Fields prodIdStoc:药品入库编码
	 */
	@PropertyNameAnnotation(annotation="药品入库编码")
	private String prodIdStoc;
	
	/**
	 * @Fields prodIdStoc_key:药品入库编码_key
	 */
	@PropertyNameAnnotation(annotation="药品入库编码_key")
	private String prodIdStoc_key;
	
	/**
	 * @Fields productName:通用名
	 */
	@PropertyNameAnnotation(annotation="通用名")
	private String productName;
	
	/**
	 * @Fields productName_key:通用名_key
	 */
	@PropertyNameAnnotation(annotation="通用名_key")
	private String productName_key;
	
	/**
	 * @Fields productSpelName:通用名拼音码
	 */
	@PropertyNameAnnotation(annotation="通用名拼音码")
	private String productSpelName;
	
	/**
	 * @Fields productSpelName_key:通用名拼音码_key
	 */
	@PropertyNameAnnotation(annotation="通用名拼音码_key")
	private String productSpelName_key;
	
	/**
	 * @Fields productWbName:通用名五笔码
	 */
	@PropertyNameAnnotation(annotation="通用名五笔码")
	private String productWbName;
	
	/**
	 * @Fields productWbName_key:通用名五笔码_key
	 */
	@PropertyNameAnnotation(annotation="通用名五笔码_key")
	private String productWbName_key;
		
	/**
	 * @Fields medicinemodel:剂型
	 */
	@PropertyNameAnnotation(annotation="剂型")
	private String medicinemodel;
	
	/**
	 * @Fields medicinemodel_key:剂型_key
	 */
	@PropertyNameAnnotation(annotation="剂型_key")
	private String medicinemodel_key;
	
	/**
	 * @Fields medicinemodelSpel:剂型拼音码
	 */
	@PropertyNameAnnotation(annotation="剂型拼音码")
	private String medicinemodelSpel;
	
	/**
	 * @Fields medicinemodelSpel_key:剂型拼音码_key
	 */
	@PropertyNameAnnotation(annotation="剂型拼音码_key")
	private String medicinemodelSpel_key;
		
	/**
	 * @Fields outlook:规格
	 */
	@PropertyNameAnnotation(annotation="规格")
	private String outlook;
	
	/**
	 * @Fields outlook_key:规格_key
	 */
	@PropertyNameAnnotation(annotation="规格_key")
	private String outlook_key;
	
	/**
	 * @Fields cataSpelName:目录通用名
	 */
	@PropertyNameAnnotation(annotation="目录通用名")
	private String cataSpelName;
	
	/**
	 * @Fields cataSpelName_key:目录通用名_key
	 */
	@PropertyNameAnnotation(annotation="目录通用名_key")
	private String cataSpelName_key;
	
	/**
	 * @Fields cataMedicinemodel:目录剂型
	 */
	@PropertyNameAnnotation(annotation="目录剂型")
	private String cataMedicinemodel;
	
	/**
	 * @Fields cataMedicinemodel_key:目录剂型_key
	 */
	@PropertyNameAnnotation(annotation="目录剂型_key")
	private String cataMedicinemodel_key;
	
	/**
	 * @Fields cataOutlook:目录规格
	 */
	@PropertyNameAnnotation(annotation="目录规格")
	private String cataOutlook;
	
	/**
	 * @Fields cataOutlook_key:目录规格_key
	 */
	@PropertyNameAnnotation(annotation="目录规格_key")
	private String cataOutlook_key;
	
	/**
	 * @Fields cataIndexF:目录序号一
	 */
	@PropertyNameAnnotation(annotation="目录序号一")
	private String cataIndexF;
	
	/**
	 * @Fields cataIndexF_key:目录序号一_key
	 */
	@PropertyNameAnnotation(annotation="目录序号一_key")
	private String cataIndexF_key;
	
	/**
	 * @Fields cataIndexS:目录序号二
	 */
	@PropertyNameAnnotation(annotation="目录序号二")
	private String cataIndexS;
	
	/**
	 * @Fields cataIndexS_key:目录序号二_key
	 */
	@PropertyNameAnnotation(annotation="目录序号二_key")
	private String cataIndexS_key;
	
	/**
	 * @Fields classOne:分类一
	 */
	@PropertyNameAnnotation(annotation="分类一")
	private String classOne;
	
	/**
	 * @Fields classOne_key:分类一_key
	 */
	@PropertyNameAnnotation(annotation="分类一_key")
	private String classOne_key;
	
	/**
	 * @Fields classTwo:分类二
	 */
	@PropertyNameAnnotation(annotation="分类二")
	private String classTwo;
	
	/**
	 * @Fields classTwo_key:分类二_key
	 */
	@PropertyNameAnnotation(annotation="分类二_key")
	private String classTwo_key;
	
	/**
	 * @Fields pharId:药理分类一编码
	 */
	@PropertyNameAnnotation(annotation="药理分类一编码")
	private String pharOneId;
	
	/**
	 * @Fields pharId_key:药理分类一编码_key
	 */
	@PropertyNameAnnotation(annotation="药理分类一编码_key")
	private String pharOneId_key;
	
	/**
	 * @Fields pharOne:药理分类一
	 */
	@PropertyNameAnnotation(annotation="药理分类一")
	private String pharOne;
	
	/**
	 * @Fields pharOne_key:药理分类一_key
	 */
	@PropertyNameAnnotation(annotation="药理分类一_key")
	private String pharOne_key;
	
	/**
	 * @Fields pharId:药理分类二编码
	 */
	@PropertyNameAnnotation(annotation="药理分类二编码")
	private String pharTwoId;
	
	/**
	 * @Fields pharId_key:药理分类二编码_key
	 */
	@PropertyNameAnnotation(annotation="药理分类二编码_key")
	private String pharTwoId_key;
	
	/**
	 * @Fields pharTwo:药理分类二
	 */
	@PropertyNameAnnotation(annotation="药理分类二")
	private String pharTwo;
	
	/**
	 * @Fields pharTwo_key:药理分类二_key
	 */
	@PropertyNameAnnotation(annotation="药理分类二_key")
	private String pharTwo_key;
	
	/**
	 * @Fields pharId:药理分类三编码
	 */
	@PropertyNameAnnotation(annotation="药理分类三编码")
	private String pharThreeId;
	
	/**
	 * @Fields pharId_key:药理分类三编码_key
	 */
	@PropertyNameAnnotation(annotation="药理分类三编码_key")
	private String pharThreeId_key;
	
	/**
	 * @Fields pharThree:药理分类三
	 */
	@PropertyNameAnnotation(annotation="药理分类三")
	private String pharThree;
	
	/**
	 * @Fields pharThree_key:药理分类三_key
	 */
	@PropertyNameAnnotation(annotation="药理分类三_key")
	private String pharThree_key;
	
	/**
	 * @Fields pharFour:药理分类四编码
	 */
	@PropertyNameAnnotation(annotation="药理分类四编码")
	private String pharFourId;
	
	/**
	 * @Fields pharFour_key:药理分类四编码_key
	 */
	@PropertyNameAnnotation(annotation="药理分类四编码_key")
	private String pharFourId_key;
	
	/**
	 * @Fields pharFour:药理分类四
	 */
	@PropertyNameAnnotation(annotation="药理分类四")
	private String pharFour;
	
	/**
	 * @Fields pharFour_key:药理分类四_key
	 */
	@PropertyNameAnnotation(annotation="药理分类四_key")
	private String pharFour_key;
	
	/**
	 * @Fields pharFive:药理分类五编码
	 */
	@PropertyNameAnnotation(annotation="药理分类五编码")
	private String pharFiveId;
	
	/**
	 * @Fields pharFive_key:药理分类五编码_key
	 */
	@PropertyNameAnnotation(annotation="药理分类五编码_key")
	private String pharFiveId_key;
	
	/**
	 * @Fields pharFive:药理分类五
	 */
	@PropertyNameAnnotation(annotation="药理分类五")
	private String pharFive;
	
	/**
	 * @Fields pharFive_key:药理分类五_key
	 */
	@PropertyNameAnnotation(annotation="药理分类五_key")
	private String pharFive_key;
	
	/**
	 * @Fields pharSix:药理分类六编码
	 */
	@PropertyNameAnnotation(annotation="药理分类六编码")
	private String pharSixId;
	
	/**
	 * @Fields pharSix_key:药理分类六编码_key
	 */
	@PropertyNameAnnotation(annotation="药理分类六编码_key")
	private String pharSixId_key;
	
	/**
	 * @Fields pharSix:药理分类六
	 */
	@PropertyNameAnnotation(annotation="药理分类六")
	private String pharSix;
	
	/**
	 * @Fields pharSix_key:药理分类六_key
	 */
	@PropertyNameAnnotation(annotation="药理分类六_key")
	private String pharSix_key;
	
	/**
	 * @Fields productAttr:药品属性1中药2西药
	 */
	@PropertyNameAnnotation(annotation="药品属性1中药2西药")
	private String productAttr;
	
	/**
	 * @Fields productAttr_key:药品属性_key1中药2西药
	 */
	@PropertyNameAnnotation(annotation="药品属性_key1中药2西药")
	private String productAttr_key;
	
	/**
	 * @Fields remark:入库备注
	 */
	@PropertyNameAnnotation(annotation="入库备注")
	private String remark;
	
	/**
	 * @Fields remark_key:入库备注_key
	 */
	@PropertyNameAnnotation(annotation="入库备注_key")
	private String remark_key;
	
	/**
	 * @Fields status:状态
	 */
	@PropertyNameAnnotation(annotation="状态")
	private String status;
	
	/**
	 * @Fields status_key:状态_key
	 */
	@PropertyNameAnnotation(annotation="状态_key")
	private String status_key;
	
	/**
	 * @Fields auditUserName:审核人
	 */
	@PropertyNameAnnotation(annotation="审核人")
	private String auditUserName;
	
	/**
	 * @Fields auditUserName_key:审核人_key
	 */
	@PropertyNameAnnotation(annotation="审核人_key")
	private String auditUserName_key;
	
	/**
	 * @Fields auditRemark:审核备注
	 */
	@PropertyNameAnnotation(annotation="审核备注")
	private String auditRemark;
	
	/**
	 * @Fields auditRemark_key:审核备注_key
	 */
	@PropertyNameAnnotation(annotation="审核备注_key")
	private String auditRemark_key;
	
	/**
	 * @Fields auditTime:审核时间
	 */
	@PropertyNameAnnotation(annotation="审核时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime;
	
	/**
	 * @Fields auditTime_key:审核时间_key
	 */
	@PropertyNameAnnotation(annotation="审核时间_key")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime_key;
	
	/**
	 * @Fields isUsing:是否有效
	 */
	@PropertyNameAnnotation(annotation="是否有效(0:停用,1:启用)")
	private String isUsing;

	/**
	 * @Fields isUsing_key:是否有效_key
	 */
	@PropertyNameAnnotation(annotation="是否有效_key(0:停用,1:启用)")
	private String isUsing_key;

	
	/**
	 * @Fields addUserId:记录添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserId_key:记录添加人id_key
	 */
	private String addUserId_key;
	
	/**
	 * @Fields addUserName:记录添加人
	 */
	@PropertyNameAnnotation(annotation="记录添加人")
	private String addUserName;
	
	/**
	 * @Fields addUserName_key:记录添加人_key
	 */
	@PropertyNameAnnotation(annotation="记录添加人_key")
	private String addUserName_key;
	
	/**
	 * @Fields addTime:记录添加时间
	 */
	@PropertyNameAnnotation(annotation="记录添加时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields addTime_key:记录添加时间_key
	 */
	@PropertyNameAnnotation(annotation="记录添加时间_key")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime_key;
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserId_key:最后一次更新记录人id_key
	 */
	private String lastUpdateUserId_key;
	
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录人")
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateUserName_key:最后一次更新记录人_key
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录人_key")
	private String lastUpdateUserName_key;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	/**
	 * @Fields lastUpdateTime_key:最后一次更新记录时间_key
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录时间_key")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime_key;
	
	/**
	 * @Fields stdCataProdRelFileId:上传文件存储表id
	 */
	@PropertyNameAnnotation(annotation="上传文件存储表id")
	private String stdCataProdRelFileId;
	
	/**
	 * @Fields stdCataProdRelFileId_key:上传文件存储表id_key
	 */
	@PropertyNameAnnotation(annotation="上传文件存储表id_key")
	private String stdCataProdRelFileId_key;
	
	
	/**
	 * @Fields checkResult:校验结果
	 */
	@PropertyNameAnnotation(annotation="校验结果")
	private String checkResult;
	
	/**
	 * @Fields checkResult_key:校验结果
	 */
	@PropertyNameAnnotation(annotation="校验结果_key")
	private String checkResult_key;
	

	//columns END
	
	
	
	public String getRelId() {
		return relId;
	}

	public void setRelId(String relId) {
		this.relId = relId;
	}

	public String getDrugcatalogCode() {
		return drugcatalogCode;
	}

	public void setDrugcatalogCode(String drugcatalogCode) {
		this.drugcatalogCode = drugcatalogCode;
	}

	public String getDrugcatalogCode_key() {
		return drugcatalogCode_key;
	}

	public void setDrugcatalogCode_key(String drugcatalogCode_key) {
		this.drugcatalogCode_key = drugcatalogCode_key;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdId_key() {
		return prodId_key;
	}

	public void setProdId_key(String prodId_key) {
		this.prodId_key = prodId_key;
	}

	public String getProdIdStoc() {
		return prodIdStoc;
	}

	public void setProdIdStoc(String prodIdStoc) {
		this.prodIdStoc = prodIdStoc;
	}

	public String getProdIdStoc_key() {
		return prodIdStoc_key;
	}

	public void setProdIdStoc_key(String prodIdStoc_key) {
		this.prodIdStoc_key = prodIdStoc_key;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName_key() {
		return productName_key;
	}

	public void setProductName_key(String productName_key) {
		this.productName_key = productName_key;
	}

	public String getProductSpelName() {
		return productSpelName;
	}

	public void setProductSpelName(String productSpelName) {
		this.productSpelName = productSpelName;
	}

	public String getProductSpelName_key() {
		return productSpelName_key;
	}

	public void setProductSpelName_key(String productSpelName_key) {
		this.productSpelName_key = productSpelName_key;
	}

	public String getProductWbName() {
		return productWbName;
	}

	public void setProductWbName(String productWbName) {
		this.productWbName = productWbName;
	}

	public String getProductWbName_key() {
		return productWbName_key;
	}

	public void setProductWbName_key(String productWbName_key) {
		this.productWbName_key = productWbName_key;
	}

	public String getMedicinemodel() {
		return medicinemodel;
	}

	public void setMedicinemodel(String medicinemodel) {
		this.medicinemodel = medicinemodel;
	}

	public String getMedicinemodel_key() {
		return medicinemodel_key;
	}

	public void setMedicinemodel_key(String medicinemodel_key) {
		this.medicinemodel_key = medicinemodel_key;
	}

	public String getMedicinemodelSpel() {
		return medicinemodelSpel;
	}

	public void setMedicinemodelSpel(String medicinemodelSpel) {
		this.medicinemodelSpel = medicinemodelSpel;
	}

	public String getMedicinemodelSpel_key() {
		return medicinemodelSpel_key;
	}

	public void setMedicinemodelSpel_key(String medicinemodelSpel_key) {
		this.medicinemodelSpel_key = medicinemodelSpel_key;
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}

	public String getOutlook_key() {
		return outlook_key;
	}

	public void setOutlook_key(String outlook_key) {
		this.outlook_key = outlook_key;
	}

	public String getCataSpelName() {
		return cataSpelName;
	}

	public void setCataSpelName(String cataSpelName) {
		this.cataSpelName = cataSpelName;
	}

	public String getCataSpelName_key() {
		return cataSpelName_key;
	}

	public void setCataSpelName_key(String cataSpelName_key) {
		this.cataSpelName_key = cataSpelName_key;
	}

	public String getCataMedicinemodel() {
		return cataMedicinemodel;
	}

	public void setCataMedicinemodel(String cataMedicinemodel) {
		this.cataMedicinemodel = cataMedicinemodel;
	}

	public String getCataMedicinemodel_key() {
		return cataMedicinemodel_key;
	}

	public void setCataMedicinemodel_key(String cataMedicinemodel_key) {
		this.cataMedicinemodel_key = cataMedicinemodel_key;
	}

	public String getCataOutlook() {
		return cataOutlook;
	}

	public void setCataOutlook(String cataOutlook) {
		this.cataOutlook = cataOutlook;
	}

	public String getCataOutlook_key() {
		return cataOutlook_key;
	}

	public void setCataOutlook_key(String cataOutlook_key) {
		this.cataOutlook_key = cataOutlook_key;
	}

	public String getCataIndexF() {
		return cataIndexF;
	}

	public void setCataIndexF(String cataIndexF) {
		this.cataIndexF = cataIndexF;
	}

	public String getCataIndexF_key() {
		return cataIndexF_key;
	}

	public void setCataIndexF_key(String cataIndexF_key) {
		this.cataIndexF_key = cataIndexF_key;
	}

	public String getCataIndexS() {
		return cataIndexS;
	}

	public void setCataIndexS(String cataIndexS) {
		this.cataIndexS = cataIndexS;
	}

	public String getCataIndexS_key() {
		return cataIndexS_key;
	}

	public void setCataIndexS_key(String cataIndexS_key) {
		this.cataIndexS_key = cataIndexS_key;
	}

	public String getClassOne() {
		return classOne;
	}

	public void setClassOne(String classOne) {
		this.classOne = classOne;
	}

	public String getClassOne_key() {
		return classOne_key;
	}

	public void setClassOne_key(String classOne_key) {
		this.classOne_key = classOne_key;
	}

	public String getClassTwo() {
		return classTwo;
	}

	public void setClassTwo(String classTwo) {
		this.classTwo = classTwo;
	}

	public String getClassTwo_key() {
		return classTwo_key;
	}

	public void setClassTwo_key(String classTwo_key) {
		this.classTwo_key = classTwo_key;
	}

	public String getPharOneId() {
		return pharOneId;
	}

	public void setPharOneId(String pharOneId) {
		this.pharOneId = pharOneId;
	}

	public String getPharOneId_key() {
		return pharOneId_key;
	}

	public void setPharOneId_key(String pharOneId_key) {
		this.pharOneId_key = pharOneId_key;
	}

	public String getPharOne() {
		return pharOne;
	}

	public void setPharOne(String pharOne) {
		this.pharOne = pharOne;
	}

	public String getPharOne_key() {
		return pharOne_key;
	}

	public void setPharOne_key(String pharOne_key) {
		this.pharOne_key = pharOne_key;
	}

	public String getPharTwoId() {
		return pharTwoId;
	}

	public void setPharTwoId(String pharTwoId) {
		this.pharTwoId = pharTwoId;
	}

	public String getPharTwoId_key() {
		return pharTwoId_key;
	}

	public void setPharTwoId_key(String pharTwoId_key) {
		this.pharTwoId_key = pharTwoId_key;
	}

	public String getPharTwo() {
		return pharTwo;
	}

	public void setPharTwo(String pharTwo) {
		this.pharTwo = pharTwo;
	}

	public String getPharTwo_key() {
		return pharTwo_key;
	}

	public void setPharTwo_key(String pharTwo_key) {
		this.pharTwo_key = pharTwo_key;
	}

	public String getPharThreeId() {
		return pharThreeId;
	}

	public void setPharThreeId(String pharThreeId) {
		this.pharThreeId = pharThreeId;
	}

	public String getPharThreeId_key() {
		return pharThreeId_key;
	}

	public void setPharThreeId_key(String pharThreeId_key) {
		this.pharThreeId_key = pharThreeId_key;
	}

	public String getPharThree() {
		return pharThree;
	}

	public void setPharThree(String pharThree) {
		this.pharThree = pharThree;
	}

	public String getPharThree_key() {
		return pharThree_key;
	}

	public void setPharThree_key(String pharThree_key) {
		this.pharThree_key = pharThree_key;
	}

	public String getPharFourId() {
		return pharFourId;
	}

	public void setPharFourId(String pharFourId) {
		this.pharFourId = pharFourId;
	}

	public String getPharFourId_key() {
		return pharFourId_key;
	}

	public void setPharFourId_key(String pharFourId_key) {
		this.pharFourId_key = pharFourId_key;
	}

	public String getPharFour() {
		return pharFour;
	}

	public void setPharFour(String pharFour) {
		this.pharFour = pharFour;
	}

	public String getPharFour_key() {
		return pharFour_key;
	}

	public void setPharFour_key(String pharFour_key) {
		this.pharFour_key = pharFour_key;
	}

	public String getPharFiveId() {
		return pharFiveId;
	}

	public void setPharFiveId(String pharFiveId) {
		this.pharFiveId = pharFiveId;
	}

	public String getPharFiveId_key() {
		return pharFiveId_key;
	}

	public void setPharFiveId_key(String pharFiveId_key) {
		this.pharFiveId_key = pharFiveId_key;
	}

	public String getPharFive() {
		return pharFive;
	}

	public void setPharFive(String pharFive) {
		this.pharFive = pharFive;
	}

	public String getPharFive_key() {
		return pharFive_key;
	}

	public void setPharFive_key(String pharFive_key) {
		this.pharFive_key = pharFive_key;
	}

	public String getPharSixId() {
		return pharSixId;
	}

	public void setPharSixId(String pharSixId) {
		this.pharSixId = pharSixId;
	}

	public String getPharSixId_key() {
		return pharSixId_key;
	}

	public void setPharSixId_key(String pharSixId_key) {
		this.pharSixId_key = pharSixId_key;
	}

	public String getPharSix() {
		return pharSix;
	}

	public void setPharSix(String pharSix) {
		this.pharSix = pharSix;
	}

	public String getPharSix_key() {
		return pharSix_key;
	}

	public void setPharSix_key(String pharSix_key) {
		this.pharSix_key = pharSix_key;
	}

	public String getProductAttr() {
		return productAttr;
	}

	public void setProductAttr(String productAttr) {
		this.productAttr = productAttr;
	}

	public String getProductAttr_key() {
		return productAttr_key;
	}

	public void setProductAttr_key(String productAttr_key) {
		this.productAttr_key = productAttr_key;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark_key() {
		return remark_key;
	}

	public void setRemark_key(String remark_key) {
		this.remark_key = remark_key;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_key() {
		return status_key;
	}

	public void setStatus_key(String status_key) {
		this.status_key = status_key;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public String getAuditUserName_key() {
		return auditUserName_key;
	}

	public void setAuditUserName_key(String auditUserName_key) {
		this.auditUserName_key = auditUserName_key;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getAuditRemark_key() {
		return auditRemark_key;
	}

	public void setAuditRemark_key(String auditRemark_key) {
		this.auditRemark_key = auditRemark_key;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Date getAuditTime_key() {
		return auditTime_key;
	}

	public void setAuditTime_key(Date auditTime_key) {
		this.auditTime_key = auditTime_key;
	}

	public String getIsUsing() {
		return isUsing;
	}

	public void setIsUsing(String isUsing) {
		this.isUsing = isUsing;
	}

	public String getIsUsing_key() {
		return isUsing_key;
	}

	public void setIsUsing_key(String isUsing_key) {
		this.isUsing_key = isUsing_key;
	}

	public String getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(String addUserId) {
		this.addUserId = addUserId;
	}

	public String getAddUserId_key() {
		return addUserId_key;
	}

	public void setAddUserId_key(String addUserId_key) {
		this.addUserId_key = addUserId_key;
	}

	public String getAddUserName() {
		return addUserName;
	}

	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}

	public String getAddUserName_key() {
		return addUserName_key;
	}

	public void setAddUserName_key(String addUserName_key) {
		this.addUserName_key = addUserName_key;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddTime_key() {
		return addTime_key;
	}

	public void setAddTime_key(Date addTime_key) {
		this.addTime_key = addTime_key;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserId_key() {
		return lastUpdateUserId_key;
	}

	public void setLastUpdateUserId_key(String lastUpdateUserId_key) {
		this.lastUpdateUserId_key = lastUpdateUserId_key;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	public String getLastUpdateUserName_key() {
		return lastUpdateUserName_key;
	}

	public void setLastUpdateUserName_key(String lastUpdateUserName_key) {
		this.lastUpdateUserName_key = lastUpdateUserName_key;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Date getLastUpdateTime_key() {
		return lastUpdateTime_key;
	}

	public void setLastUpdateTime_key(Date lastUpdateTime_key) {
		this.lastUpdateTime_key = lastUpdateTime_key;
	}

	public String getStdCataProdRelFileId() {
		return stdCataProdRelFileId;
	}

	public void setStdCataProdRelFileId(String stdCataProdRelFileId) {
		this.stdCataProdRelFileId = stdCataProdRelFileId;
	}

	public String getStdCataProdRelFileId_key() {
		return stdCataProdRelFileId_key;
	}

	public void setStdCataProdRelFileId_key(String stdCataProdRelFileId_key) {
		this.stdCataProdRelFileId_key = stdCataProdRelFileId_key;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getCheckResult_key() {
		return checkResult_key;
	}

	public void setCheckResult_key(String checkResult_key) {
		this.checkResult_key = checkResult_key;
	}


	
}