package com.hsnn.medstgmini.yimiao.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-12-15 16:56:19
 *
 */
public class YimiaoProcurecatalogForm  {

	//columns START
	
	/**
	 * @Fields PROCURECATALOG_ID:procurecatalogId
	 */
	@NotNull(message = "请填写procurecatalogId")
	@Range(message = "数值范围不正确")
	private Integer procurecatalogId;
	
	/**
	 * @Fields GOODS_ID:产品代码
	 */
	@NotNull(message = "请填写产品代码")
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal goodsId;
	
	/**
	 * @Fields PRODUCT_NAME:通用名
	 */
	@Length(max = 512, message = "通用名的长度不能超过{1}")
	private String productName;
	
	/**
	 * @Fields PRODUCT_SPEL_NAME:通用名拼音码
	 */
	@Length(max = 512, message = "通用名拼音码的长度不能超过{1}")
	private String productSpelName;
	
	/**
	 * @Fields PRODUCT_WB_NAME:通用名五笔码
	 */
	@Length(max = 512, message = "通用名五笔码的长度不能超过{1}")
	private String productWbName;
	
	/**
	 * @Fields GOODS_NAME:商品名
	 */
	@NotEmpty(message = "请填写商品名")
	@Length(max = 36, message = "商品名的长度不能超过{1}")
	private String goodsName;
	
	/**
	 * @Fields MEDICINEMODEL:剂型
	 */
	@Length(max = 256, message = "剂型的长度不能超过{1}")
	private String medicinemodel;
	
	/**
	 * @Fields OUTLOOK:规格
	 */
	@Length(max = 256, message = "规格的长度不能超过{1}")
	private String outlook;
	
	/**
	 * @Fields FACTOR:转换比
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal factor;
	
	/**
	 * @Fields MATERIAL_NAME:包装材质
	 */
	@Length(max = 36, message = "包装材质的长度不能超过{1}")
	private String materialName;
	
	/**
	 * @Fields UNIT:单位
	 */
	@Length(max = 36, message = "单位的长度不能超过{1}")
	private String unit;
	
	/**
	 * @Fields MIDDLE_PACK:中包装
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal middlePack;
	
	/**
	 * @Fields MAX_PACK:大包装
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxPack;
	
	/**
	 * @Fields COMPANY_ID_SC:生产企业编号
	 */
	@Length(max = 50, message = "生产企业编号的长度不能超过{1}")
	private String companyIdSc;
	
	/**
	 * @Fields COMPANY_NAME_SC:生产企业名称
	 */
	@Length(max = 512, message = "生产企业名称的长度不能超过{1}")
	private String companyNameSc;
	
	/**
	 * @Fields SPLIT_COMPANY_NAME:分包装企业
	 */
	@Length(max = 512, message = "分包装企业的长度不能超过{1}")
	private String splitCompanyName;
	
	/**
	 * @Fields TRUST_COMPANY_NAME:委托加工企业
	 */
	@Length(max = 512, message = "委托加工企业的长度不能超过{1}")
	private String trustCompanyName;
	
	/**
	 * @Fields COMPANY_ID_TB:投标企业编号
	 */
	@Length(max = 36, message = "投标企业编号的长度不能超过{1}")
	private String companyIdTb;
	
	/**
	 * @Fields COMPANY_NAME_TB:投标企业名称
	 */
	@Length(max = 512, message = "投标企业名称的长度不能超过{1}")
	private String companyNameTb;
	
	/**
	 * @Fields IS_BASE_DRUG:是否基药(0:否,1:是)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isBaseDrug;
	
	/**
	 * @Fields QUALITY_LEVEL:qualityLevel
	 */
	@Length(max = 50, message = "qualityLevel的长度不能超过{1}")
	private String qualityLevel;
	
	/**
	 * @Fields PURCHASE_TYPE:采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseType;
	
	/**
	 * @Fields SOURCE_ID:来源id
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal sourceId;
	
	/**
	 * @Fields SOURCE_NAME:来源名称
	 */
	@Length(max = 1024, message = "来源名称的长度不能超过{1}")
	private String sourceName;
	
	/**
	 * @Fields BID_PRICE:中标价格（医院端看到为“采购价”，配送企业端为“供应价”）
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal bidPrice;
	
	/**
	 * @Fields TEMPORARY_RETAIL_PRICE:临时零售价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal temporaryRetailPrice;
	
	/**
	 * @Fields MAX_RETAIL_PRICE:最高零售价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxRetailPrice;
	
	/**
	 * @Fields MAX_PURCHASE_PRICE:最高采购价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxPurchasePrice;
	
	/**
	 * @Fields REFERENCE_PRICE:参照价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal referencePrice;
	
	/**
	 * @Fields MAX_LISTING_PRICE:最高挂网价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxListingPrice;
	
	/**
	 * @Fields USING_RANG:使用范围（0：县上，1：基层，2：全省）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal usingRang;
	
	/**
	 * @Fields REMARK:备注
	 */
	@Length(max = 1024, message = "备注的长度不能超过{1}")
	private String remark;
	
	/**
	 * @Fields SUBMIT_STATUS:提交状态（0：保存待提交，1：提交待审核）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal submitStatus;
	
	/**
	 * @Fields SUBMIT_USER_ID:提交人id
	 */
	@Length(max = 36, message = "提交人id的长度不能超过{1}")
	private String submitUserId;
	
	/**
	 * @Fields SUBMIT_USER_NAME:提交人
	 */
	@Length(max = 256, message = "提交人的长度不能超过{1}")
	private String submitUserName;
	
	/**
	 * @Fields SUBMIT_TIME:提交时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	
	/**
	 * @Fields AUDIT_STATUS:审核状态（0：待审核，1：审核通过，2：审核不通过）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal auditStatus;
	
	/**
	 * @Fields AUDIT_USER_ID:审核人id
	 */
	@Length(max = 36, message = "审核人id的长度不能超过{1}")
	private String auditUserId;
	
	/**
	 * @Fields AUDIT_USER_NAME:审核人
	 */
	@Length(max = 256, message = "审核人的长度不能超过{1}")
	private String auditUserName;
	
	/**
	 * @Fields AUDIT_TIME:审核时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime;
	
	/**
	 * @Fields AUDIT_REMARK:auditRemark
	 */
	@Length(max = 1024, message = "auditRemark的长度不能超过{1}")
	private String auditRemark;
	
	/**
	 * @Fields IS_USING:是否有效(0:禁用,1:启用)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isUsing;
	
	/**
	 * @Fields DEAL_PERSON_ID:处理人编号
	 */
	@Length(max = 36, message = "处理人编号的长度不能超过{1}")
	private String dealPersonId;
	
	/**
	 * @Fields DEAL_PERSON:处理人
	 */
	@Length(max = 1024, message = "处理人的长度不能超过{1}")
	private String dealPerson;
	
	/**
	 * @Fields DEAL_TIME:处理时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dealTime;
	
	/**
	 * @Fields DEAL_REASON:处理原因
	 */
	@Length(max = 1024, message = "处理原因的长度不能超过{1}")
	private String dealReason;
	
	/**
	 * @Fields ADD_USER_ID:记录添加人id
	 */
	@Length(max = 36, message = "记录添加人id的长度不能超过{1}")
	private String addUserId;
	
	/**
	 * @Fields ADD_USER_NAME:记录添加人
	 */
	@Length(max = 256, message = "记录添加人的长度不能超过{1}")
	private String addUserName;
	
	/**
	 * @Fields ADD_TIME:记录添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields LAST_UPDATE_USER_ID:最后一次更新记录人id
	 */
	@Length(max = 36, message = "最后一次更新记录人id的长度不能超过{1}")
	private String lastUpdateUserId;
	
	/**
	 * @Fields LAST_UPDATE_USER_NAME:最后一次更新记录人
	 */
	@Length(max = 256, message = "最后一次更新记录人的长度不能超过{1}")
	private String lastUpdateUserName;
	
	/**
	 * @Fields LAST_UPDATE_TIME:最后一次更新记录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	/**
	 * @Fields YIMIAO_YEAR:年度
	 */
	@Length(max = 50, message = "年度的长度不能超过{1}")
	private String yimiaoYear;

	/**
	 * @Fields productId:一级目录id
	 */
	private Integer productId;

	/**
	 * @Fields sortId:二级目录id
	 */
	private String sortId;
	//columns END
	

	public YimiaoProcurecatalogForm(){
	}

	public YimiaoProcurecatalogForm(Integer procurecatalogId,BigDecimal goodsId){
		this.procurecatalogId = procurecatalogId;
		this.goodsId = goodsId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public void setProcurecatalogId(Integer procurecatalogId){
		this.procurecatalogId = procurecatalogId;
	}
	public Integer getProcurecatalogId(){
		return procurecatalogId;
	}
	
	public void setGoodsId(BigDecimal goodsId){
		this.goodsId = goodsId;
	}
	public BigDecimal getGoodsId(){
		return goodsId;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}
	
	public void setProductSpelName(String productSpelName){
		this.productSpelName = productSpelName;
	}
	public String getProductSpelName(){
		return productSpelName;
	}
	
	public void setProductWbName(String productWbName){
		this.productWbName = productWbName;
	}
	public String getProductWbName(){
		return productWbName;
	}
	
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	public String getGoodsName(){
		return goodsName;
	}
	
	public void setMedicinemodel(String medicinemodel){
		this.medicinemodel = medicinemodel;
	}
	public String getMedicinemodel(){
		return medicinemodel;
	}
	
	public void setOutlook(String outlook){
		this.outlook = outlook;
	}
	public String getOutlook(){
		return outlook;
	}
	
	public void setFactor(BigDecimal factor){
		this.factor = factor;
	}
	public BigDecimal getFactor(){
		return factor;
	}
	
	public void setMaterialName(String materialName){
		this.materialName = materialName;
	}
	public String getMaterialName(){
		return materialName;
	}
	
	public void setUnit(String unit){
		this.unit = unit;
	}
	public String getUnit(){
		return unit;
	}
	
	public void setMiddlePack(BigDecimal middlePack){
		this.middlePack = middlePack;
	}
	public BigDecimal getMiddlePack(){
		return middlePack;
	}
	
	public void setMaxPack(BigDecimal maxPack){
		this.maxPack = maxPack;
	}
	public BigDecimal getMaxPack(){
		return maxPack;
	}
	
	public void setCompanyIdSc(String companyIdSc){
		this.companyIdSc = companyIdSc;
	}
	public String getCompanyIdSc(){
		return companyIdSc;
	}
	
	public void setCompanyNameSc(String companyNameSc){
		this.companyNameSc = companyNameSc;
	}
	public String getCompanyNameSc(){
		return companyNameSc;
	}
	
	public void setSplitCompanyName(String splitCompanyName){
		this.splitCompanyName = splitCompanyName;
	}
	public String getSplitCompanyName(){
		return splitCompanyName;
	}
	
	public void setTrustCompanyName(String trustCompanyName){
		this.trustCompanyName = trustCompanyName;
	}
	public String getTrustCompanyName(){
		return trustCompanyName;
	}
	
	public void setCompanyIdTb(String companyIdTb){
		this.companyIdTb = companyIdTb;
	}
	public String getCompanyIdTb(){
		return companyIdTb;
	}
	
	public void setCompanyNameTb(String companyNameTb){
		this.companyNameTb = companyNameTb;
	}
	public String getCompanyNameTb(){
		return companyNameTb;
	}
	
	public void setIsBaseDrug(BigDecimal isBaseDrug){
		this.isBaseDrug = isBaseDrug;
	}
	public BigDecimal getIsBaseDrug(){
		return isBaseDrug;
	}
	
	public void setQualityLevel(String qualityLevel){
		this.qualityLevel = qualityLevel;
	}
	public String getQualityLevel(){
		return qualityLevel;
	}
	
	public void setPurchaseType(BigDecimal purchaseType){
		this.purchaseType = purchaseType;
	}
	public BigDecimal getPurchaseType(){
		return purchaseType;
	}
	
	public void setSourceId(BigDecimal sourceId){
		this.sourceId = sourceId;
	}
	public BigDecimal getSourceId(){
		return sourceId;
	}
	
	public void setSourceName(String sourceName){
		this.sourceName = sourceName;
	}
	public String getSourceName(){
		return sourceName;
	}
	
	public void setBidPrice(BigDecimal bidPrice){
		this.bidPrice = bidPrice;
	}
	public BigDecimal getBidPrice(){
		return bidPrice;
	}
	
	public void setTemporaryRetailPrice(BigDecimal temporaryRetailPrice){
		this.temporaryRetailPrice = temporaryRetailPrice;
	}
	public BigDecimal getTemporaryRetailPrice(){
		return temporaryRetailPrice;
	}
	
	public void setMaxRetailPrice(BigDecimal maxRetailPrice){
		this.maxRetailPrice = maxRetailPrice;
	}
	public BigDecimal getMaxRetailPrice(){
		return maxRetailPrice;
	}
	
	public void setMaxPurchasePrice(BigDecimal maxPurchasePrice){
		this.maxPurchasePrice = maxPurchasePrice;
	}
	public BigDecimal getMaxPurchasePrice(){
		return maxPurchasePrice;
	}
	
	public void setReferencePrice(BigDecimal referencePrice){
		this.referencePrice = referencePrice;
	}
	public BigDecimal getReferencePrice(){
		return referencePrice;
	}
	
	public void setMaxListingPrice(BigDecimal maxListingPrice){
		this.maxListingPrice = maxListingPrice;
	}
	public BigDecimal getMaxListingPrice(){
		return maxListingPrice;
	}
	
	public void setUsingRang(BigDecimal usingRang){
		this.usingRang = usingRang;
	}
	public BigDecimal getUsingRang(){
		return usingRang;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}
	
	public void setSubmitStatus(BigDecimal submitStatus){
		this.submitStatus = submitStatus;
	}
	public BigDecimal getSubmitStatus(){
		return submitStatus;
	}
	
	public void setSubmitUserId(String submitUserId){
		this.submitUserId = submitUserId;
	}
	public String getSubmitUserId(){
		return submitUserId;
	}
	
	public void setSubmitUserName(String submitUserName){
		this.submitUserName = submitUserName;
	}
	public String getSubmitUserName(){
		return submitUserName;
	}
	
	public void setSubmitTime(Date submitTime){
		this.submitTime = submitTime;
	}
	public Date getSubmitTime(){
		return submitTime;
	}
	
	public void setAuditStatus(BigDecimal auditStatus){
		this.auditStatus = auditStatus;
	}
	public BigDecimal getAuditStatus(){
		return auditStatus;
	}
	
	public void setAuditUserId(String auditUserId){
		this.auditUserId = auditUserId;
	}
	public String getAuditUserId(){
		return auditUserId;
	}
	
	public void setAuditUserName(String auditUserName){
		this.auditUserName = auditUserName;
	}
	public String getAuditUserName(){
		return auditUserName;
	}
	
	public void setAuditTime(Date auditTime){
		this.auditTime = auditTime;
	}
	public Date getAuditTime(){
		return auditTime;
	}
	
	public void setAuditRemark(String auditRemark){
		this.auditRemark = auditRemark;
	}
	public String getAuditRemark(){
		return auditRemark;
	}
	
	public void setIsUsing(BigDecimal isUsing){
		this.isUsing = isUsing;
	}
	public BigDecimal getIsUsing(){
		return isUsing;
	}
	
	public void setDealPersonId(String dealPersonId){
		this.dealPersonId = dealPersonId;
	}
	public String getDealPersonId(){
		return dealPersonId;
	}
	
	public void setDealPerson(String dealPerson){
		this.dealPerson = dealPerson;
	}
	public String getDealPerson(){
		return dealPerson;
	}
	
	public void setDealTime(Date dealTime){
		this.dealTime = dealTime;
	}
	public Date getDealTime(){
		return dealTime;
	}
	
	public void setDealReason(String dealReason){
		this.dealReason = dealReason;
	}
	public String getDealReason(){
		return dealReason;
	}
	
	public void setAddUserId(String addUserId){
		this.addUserId = addUserId;
	}
	public String getAddUserId(){
		return addUserId;
	}
	
	public void setAddUserName(String addUserName){
		this.addUserName = addUserName;
	}
	public String getAddUserName(){
		return addUserName;
	}
	
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	public Date getAddTime(){
		return addTime;
	}
	
	public void setLastUpdateUserId(String lastUpdateUserId){
		this.lastUpdateUserId = lastUpdateUserId;
	}
	public String getLastUpdateUserId(){
		return lastUpdateUserId;
	}
	
	public void setLastUpdateUserName(String lastUpdateUserName){
		this.lastUpdateUserName = lastUpdateUserName;
	}
	public String getLastUpdateUserName(){
		return lastUpdateUserName;
	}
	
	public void setLastUpdateTime(Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}
	public Date getLastUpdateTime(){
		return lastUpdateTime;
	}
	
	public void setYimiaoYear(String yimiaoYear){
		this.yimiaoYear = yimiaoYear;
	}
	public String getYimiaoYear(){
		return yimiaoYear;
	}

}