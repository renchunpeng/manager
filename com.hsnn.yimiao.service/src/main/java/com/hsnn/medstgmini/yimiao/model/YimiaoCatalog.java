package com.hsnn.medstgmini.yimiao.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @Since 2010-2018
 * @Description: TODO
 * @author ***
 * @date 2018-05-10 08:44:41
 *
 */
public class YimiaoCatalog{
	
	//alias
	public static final String TABLE_ALIAS = "YimiaoCatalog";
	
	//columns START
	/**
	 * @Fields catalogId:catalogId
	 */
	private Long catalogId;
	
	/**
	 * @Fields goodsId:goodsId
	 */
	private String goodsId;

    private Integer procurecatalogId;

    /**
	 * @Fields productName:productName
	 */
	private String productName;
	
	/**
	 * @Fields productSpelName:productSpelName
	 */
	private String productSpelName;
	
	/**
	 * @Fields productWbName:productWbName
	 */
	private String productWbName;
	
	/**
	 * @Fields goodsName:goodsName
	 */
	private String goodsName;
	
	/**
	 * @Fields medicinemodel:medicinemodel
	 */
	private String medicinemodel;
	
	/**
	 * @Fields outlook:outlook
	 */
	private String outlook;
	
	/**
	 * @Fields factor:factor
	 */
	private Double factor;
	
	/**
	 * @Fields materialName:materialName
	 */
	private String materialName;
	
	/**
	 * @Fields unit:unit
	 */
	private String unit;
	
	/**
	 * @Fields middlePack:middlePack
	 */
	private Double middlePack;
	
	/**
	 * @Fields maxPack:maxPack
	 */
	private Double maxPack;
	
	/**
	 * @Fields companyIdSc:companyIdSc
	 */
	private String companyIdSc;
	
	/**
	 * @Fields companyNameSc:companyNameSc
	 */
	private String companyNameSc;
	
	/**
	 * @Fields splitCompanyName:splitCompanyName
	 */
	private String splitCompanyName;
	
	/**
	 * @Fields trustCompanyName:trustCompanyName
	 */
	private String trustCompanyName;
	
	/**
	 * @Fields companyIdTb:companyIdTb
	 */
	private String companyIdTb;
	
	/**
	 * @Fields companyNameTb:companyNameTb
	 */
	private String companyNameTb;
	
	/**
	 * @Fields companyNamePs:委托配送企业名称
	 */
	private String companyNamePs;
	
	/**
	 * @Fields isBaseDrug:isBaseDrug
	 */
	private Double isBaseDrug;
	
	/**
	 * @Fields qualityLevel:qualityLevel
	 */
	private String qualityLevel;
	
	/**
	 * @Fields purchaseType:purchaseType
	 */
	private Double purchaseType;
	
	/**
	 * @Fields sourceId:sourceId
	 */
	private Double sourceId;
	
	/**
	 * @Fields sourceName:sourceName
	 */
	private String sourceName;
	
	/**
	 * @Fields bidPrice:bidPrice
	 */
	private BigDecimal bidPrice;
	
	/**
	 * @Fields temporaryRetailPrice:temporaryRetailPrice
	 */
	private BigDecimal temporaryRetailPrice;
	
	/**
	 * @Fields maxRetailPrice:maxRetailPrice
	 */
	private BigDecimal maxRetailPrice;
	
	/**
	 * @Fields maxPurchasePrice:maxPurchasePrice
	 */
	private BigDecimal maxPurchasePrice;
	
	/**
	 * @Fields referencePrice:referencePrice
	 */
	private BigDecimal referencePrice;
	
	/**
	 * @Fields maxListingPrice:maxListingPrice
	 */
	private BigDecimal maxListingPrice;
	
	/**
	 * @Fields usingRang:usingRang
	 */
	private Double usingRang;
	
	/**
	 * @Fields hospitalId:hospitalId
	 */
	private String hospitalId;
	
	/**
	 * @Fields hospitalName:hospitalName
	 */
	private String hospitalName;
	
	/**
	 * @Fields hospitalDepartmentId:hospitalDepartmentId
	 */
	private Integer hospitalDepartmentId;
	
	/**
	 * @Fields hospitalDepartmentName:hospitalDepartmentName
	 */
	private String hospitalDepartmentName;
	
	/**
	 * @Fields remark:remark
	 */
	private String remark;
	
	/**
	 * @Fields submitStatus:submitStatus
	 */
	private Double submitStatus;
	
	/**
	 * @Fields submitUserId:submitUserId
	 */
	private String submitUserId;
	
	/**
	 * @Fields submitUserName:submitUserName
	 */
	private String submitUserName;
	
	/**
	 * @Fields submitTime:submitTime
	 */
	private Date submitTime;
	
	/**
	 * @Fields auditStatus:auditStatus
	 */
	private Double auditStatus;
	
	/**
	 * @Fields auditUserId:auditUserId
	 */
	private String auditUserId;
	
	/**
	 * @Fields auditUserName:auditUserName
	 */
	private String auditUserName;
	
	/**
	 * @Fields auditTime:auditTime
	 */
	private Date auditTime;
	
	/**
	 * @Fields auditRemark:auditRemark
	 */
	private String auditRemark;
	
	/**
	 * @Fields isUsing:isUsing
	 */
	private Double isUsing;
	
	/**
	 * @Fields dealPersonId:dealPersonId
	 */
	private String dealPersonId;
	
	/**
	 * @Fields dealPerson:dealPerson
	 */
	private String dealPerson;
	
	/**
	 * @Fields dealTime:dealTime
	 */
	private Date dealTime;
	
	/**
	 * @Fields dealReason:dealReason
	 */
	private String dealReason;
	
	/**
	 * @Fields addUserId:addUserId
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:addUserName
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:addTime
	 */
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:lastUpdateUserId
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:lastUpdateUserName
	 */
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:lastUpdateTime
	 */
	private Date lastUpdateTime;
	
	/**
	 * @Fields yimiaoYear:yimiaoYear
	 */
	private String yimiaoYear;
	
	/**
	 * @Fields productId:productId
	 */
	private Double productId;
	
	/**
	 * @Fields sortId:sortId
	 */
	private String sortId;
	
	//columns END

	public YimiaoCatalog(){
	}

	public YimiaoCatalog(Long catalogId,String goodsId){
		this.catalogId = catalogId;
		this.goodsId = goodsId;
	}

    public Integer getProcurecatalogId() {
        return procurecatalogId;
    }

    public void setProcurecatalogId(Integer procurecatalogId) {
        this.procurecatalogId = procurecatalogId;
    }
	
	public void setCatalogId(Long catalogId){
		this.catalogId = catalogId;
	}
	
	public Long getCatalogId(){
		return catalogId;
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
	
	public void setFactor(Double factor){
		this.factor = factor;
	}
	
	public Double getFactor(){
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
	
	public void setMiddlePack(Double middlePack){
		this.middlePack = middlePack;
	}
	
	public Double getMiddlePack(){
		return middlePack;
	}
	
	public void setMaxPack(Double maxPack){
		this.maxPack = maxPack;
	}
	
	public Double getMaxPack(){
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
	
	public void setCompanyNamePs(String companyNamePs){
		this.companyNamePs = companyNamePs;
	}
	
	public String getCompanyNamePs(){
		return companyNamePs;
	}
	
	public void setIsBaseDrug(Double isBaseDrug){
		this.isBaseDrug = isBaseDrug;
	}
	
	public Double getIsBaseDrug(){
		return isBaseDrug;
	}
	
	public void setQualityLevel(String qualityLevel){
		this.qualityLevel = qualityLevel;
	}
	
	public String getQualityLevel(){
		return qualityLevel;
	}
	
	public void setPurchaseType(Double purchaseType){
		this.purchaseType = purchaseType;
	}
	
	public Double getPurchaseType(){
		return purchaseType;
	}
	
	public void setSourceId(Double sourceId){
		this.sourceId = sourceId;
	}
	
	public Double getSourceId(){
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
	
	public void setUsingRang(Double usingRang){
		this.usingRang = usingRang;
	}
	
	public Double getUsingRang(){
		return usingRang;
	}
	
	public void setHospitalId(String hospitalId){
		this.hospitalId = hospitalId;
	}
	
	public String getHospitalId(){
		return hospitalId;
	}
	
	public void setHospitalName(String hospitalName){
		this.hospitalName = hospitalName;
	}
	
	public String getHospitalName(){
		return hospitalName;
	}
	
	public void setHospitalDepartmentId(Integer hospitalDepartmentId){
		this.hospitalDepartmentId = hospitalDepartmentId;
	}
	
	public Integer getHospitalDepartmentId(){
		return hospitalDepartmentId;
	}
	
	public void setHospitalDepartmentName(String hospitalDepartmentName){
		this.hospitalDepartmentName = hospitalDepartmentName;
	}
	
	public String getHospitalDepartmentName(){
		return hospitalDepartmentName;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setSubmitStatus(Double submitStatus){
		this.submitStatus = submitStatus;
	}
	
	public Double getSubmitStatus(){
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
	
	public void setAuditStatus(Double auditStatus){
		this.auditStatus = auditStatus;
	}
	
	public Double getAuditStatus(){
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
	
	public void setIsUsing(Double isUsing){
		this.isUsing = isUsing;
	}
	
	public Double getIsUsing(){
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
	
	public void setProductId(Double productId){
		this.productId = productId;
	}
	
	public Double getProductId(){
		return productId;
	}
	
	public void setSortId(String sortId){
		this.sortId = sortId;
	}
	
	public String getSortId(){
		return sortId;
	}


}