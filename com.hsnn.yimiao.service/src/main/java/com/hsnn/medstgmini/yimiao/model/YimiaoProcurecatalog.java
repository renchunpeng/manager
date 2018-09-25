package com.hsnn.medstgmini.yimiao.model;

import java.util.Date;
import java.math.BigDecimal;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-11-18 10:49:46
 *
 */
public class YimiaoProcurecatalog  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "疫苗_商品表";
	
	//columns START
	/**
	 * @Fields procurecatalogId:procurecatalogId
	 */
	private Integer procurecatalogId;
	
	/**
	 * @Fields goodsId:产品代码
	 */
	private String goodsId;
	
	/**
	 * @Fields productName:通用名
	 */
	private String productName;
	
	/**
	 * @Fields productSpelName:通用名拼音码
	 */
	private String productSpelName;
	
	/**
	 * @Fields productWbName:通用名五笔码
	 */
	private String productWbName;
	
	/**
	 * @Fields goodsName:商品名
	 */
	private String goodsName;
	
	/**
	 * @Fields medicinemodel:剂型
	 */
	private String medicinemodel;
	
	/**
	 * @Fields outlook:规格
	 */
	private String outlook;
	
	/**
	 * @Fields factor:转换比
	 */
	private BigDecimal factor;
	
	/**
	 * @Fields materialName:包装材质
	 */
	private String materialName;
	
	/**
	 * @Fields unit:单位
	 */
	private String unit;
	
	/**
	 * @Fields yimiaoYear:年度
	 */
	private String 	yimiaoYear;
	/**
	 * @Fields middlePack:中包装
	 */
	private BigDecimal middlePack;
	
	/**
	 * @Fields maxPack:大包装
	 */
	private BigDecimal maxPack;
	
	/**
	 * @Fields companyIdSc:生产企业编号
	 */
	private String companyIdSc;
	
	/**
	 * @Fields companyNameSc:生产企业名称
	 */
	private String companyNameSc;
	
	/**
	 * @Fields splitCompanyName:分包装企业
	 */
	private String splitCompanyName;
	
	/**
	 * @Fields trustCompanyName:委托加工企业
	 */
	private String trustCompanyName;

	/**
	 * @Fields companyIdTb:投标企业编号
	 */
	private String companyIdTb;

	/**
	 * @Fields companyNameTb:投标企业名称
	 */
	private String companyNameTb;

	private String companyNamePs;
	/**
	 * @Fields isBaseDrug:是否基药(0:否,1:是)
	 */
	private BigDecimal isBaseDrug;
	
	/**
	 * @Fields qualityLevel:qualityLevel
	 */
	private String qualityLevel;
	
	/**
	 * @Fields purchaseType:采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品)
	 */
	private BigDecimal purchaseType;
	
	/**
	 * @Fields sourceId:来源id
	 */
	private BigDecimal sourceId;
	
	/**
	 * @Fields sourceName:来源名称
	 */
	private String sourceName;
	
	/**
	 * @Fields bidPrice:中标价格（医院端看到为“采购价”，配送企业端为“供应价”）
	 */
	private BigDecimal bidPrice;
	
	/**
	 * @Fields temporaryRetailPrice:临时零售价
	 */
	private BigDecimal temporaryRetailPrice;
	
	/**
	 * @Fields maxRetailPrice:最高零售价
	 */
	private BigDecimal maxRetailPrice;
	
	/**
	 * @Fields maxPurchasePrice:最高采购价
	 */
	private BigDecimal maxPurchasePrice;
	
	/**
	 * @Fields referencePrice:参照价
	 */
	private BigDecimal referencePrice;
	
	/**
	 * @Fields maxListingPrice:最高挂网价
	 */
	private BigDecimal maxListingPrice;
	
	/**
	 * @Fields usingRang:使用范围（0：县上，1：基层，2：全省）
	 */
	private BigDecimal usingRang;
	
	/**
	 * @Fields remark:备注
	 */
	private String remark;
	
	/**
	 * @Fields submitStatus:提交状态（0：保存待提交，1：提交待审核）
	 */
	private BigDecimal submitStatus;
	
	/**
	 * @Fields submitUserId:提交人id
	 */
	private String submitUserId;
	
	/**
	 * @Fields submitUserName:提交人
	 */
	private String submitUserName;
	
	/**
	 * @Fields submitTime:提交时间
	 */
	private Date submitTime;
	
	/**
	 * @Fields auditStatus:审核状态（0：待审核，1：审核通过，2：审核不通过）
	 */
	private BigDecimal auditStatus;
	
	/**
	 * @Fields auditUserId:审核人id
	 */
	private String auditUserId;
	
	/**
	 * @Fields auditUserName:审核人
	 */
	private String auditUserName;
	
	/**
	 * @Fields auditTime:审核时间
	 */
	private Date auditTime;
	
	/**
	 * @Fields auditRemark:auditRemark
	 */
	private String auditRemark;
	
	/**
	 * @Fields isUsing:是否有效(0:禁用,1:启用)
	 */
	private BigDecimal isUsing;
	
	/**
	 * @Fields dealPersonId:处理人编号
	 */
	private String dealPersonId;
	
	/**
	 * @Fields dealPerson:处理人
	 */
	private String dealPerson;
	
	/**
	 * @Fields dealTime:处理时间
	 */
	private Date dealTime;
	
	/**
	 * @Fields dealReason:处理原因
	 */
	private String dealReason;
	
	/**
	 * @Fields addUserId:记录添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:记录添加人
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:记录添加时间
	 */
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	private Date lastUpdateTime;

	/**
	 * @Fields productId:一级目录id
	 */
	private Integer productId;

	/**
	 * @Fields sortId:二级目录id
	 */
	private String sortId;
	
	//columns END

	public YimiaoProcurecatalog(){
	}

	public YimiaoProcurecatalog(Integer procurecatalogId,String goodsId){
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
	
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;
	}
	
	public String getGoodsId(){
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

	public String getYimiaoYear() {
		return yimiaoYear;
	}

	public void setYimiaoYear(String yimiaoYear) {
		this.yimiaoYear = yimiaoYear;
	}

	public String getCompanyNamePs() {
		return companyNamePs;
	}

	public void setCompanyNamePs(String companyNamePs) {
		this.companyNamePs = companyNamePs;
	}
}