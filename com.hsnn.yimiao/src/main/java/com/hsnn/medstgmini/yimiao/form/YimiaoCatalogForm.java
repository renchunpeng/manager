package com.hsnn.medstgmini.yimiao.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
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
public class YimiaoCatalogForm  {

	//columns START
	
	/**
	 * @Fields CATALOG_ID:catalogId
	 */
	private Long catalogId;
	
	/**
	 * @Fields GOODS_ID:goodsId
	 */
	@NotEmpty(message = "请填写goodsId")
	@Length(max = 20, message = "goodsId的长度不能超过{1}")
	private String goodsId;

	@Range(message = "数值范围不正确")
	private Integer procurecatalogId;

    /**
	 * @Fields PRODUCT_NAME:productName
	 */
	@Length(max = 512, message = "productName的长度不能超过{1}")
	private String productName;
	
	/**
	 * @Fields PRODUCT_SPEL_NAME:productSpelName
	 */
	@Length(max = 512, message = "productSpelName的长度不能超过{1}")
	private String productSpelName;
	
	/**
	 * @Fields PRODUCT_WB_NAME:productWbName
	 */
	@Length(max = 512, message = "productWbName的长度不能超过{1}")
	private String productWbName;
	
	/**
	 * @Fields GOODS_NAME:goodsName
	 */
	@Length(max = 36, message = "goodsName的长度不能超过{1}")
	private String goodsName;
	
	/**
	 * @Fields MEDICINEMODEL:medicinemodel
	 */
	@Length(max = 256, message = "medicinemodel的长度不能超过{1}")
	private String medicinemodel;
	
	/**
	 * @Fields OUTLOOK:outlook
	 */
	@Length(max = 256, message = "outlook的长度不能超过{1}")
	private String outlook;
	
	/**
	 * @Fields FACTOR:factor
	 */
	private Double factor;
	
	/**
	 * @Fields MATERIAL_NAME:materialName
	 */
	@Length(max = 36, message = "materialName的长度不能超过{1}")
	private String materialName;
	
	/**
	 * @Fields UNIT:unit
	 */
	@Length(max = 36, message = "unit的长度不能超过{1}")
	private String unit;
	
	/**
	 * @Fields MIDDLE_PACK:middlePack
	 */
	private Double middlePack;
	
	/**
	 * @Fields MAX_PACK:maxPack
	 */
	private Double maxPack;
	
	/**
	 * @Fields COMPANY_ID_SC:companyIdSc
	 */
	@Length(max = 50, message = "companyIdSc的长度不能超过{1}")
	private String companyIdSc;
	
	/**
	 * @Fields COMPANY_NAME_SC:companyNameSc
	 */
	@Length(max = 512, message = "companyNameSc的长度不能超过{1}")
	private String companyNameSc;
	
	/**
	 * @Fields SPLIT_COMPANY_NAME:splitCompanyName
	 */
	@Length(max = 512, message = "splitCompanyName的长度不能超过{1}")
	private String splitCompanyName;
	
	/**
	 * @Fields TRUST_COMPANY_NAME:trustCompanyName
	 */
	@Length(max = 512, message = "trustCompanyName的长度不能超过{1}")
	private String trustCompanyName;
	
	/**
	 * @Fields COMPANY_ID_TB:companyIdTb
	 */
	@Length(max = 36, message = "companyIdTb的长度不能超过{1}")
	private String companyIdTb;
	
	/**
	 * @Fields COMPANY_NAME_TB:companyNameTb
	 */
	@Length(max = 512, message = "companyNameTb的长度不能超过{1}")
	private String companyNameTb;
	
	/**
	 * @Fields COMPANY_NAME_PS:委托配送企业名称
	 */
	@Length(max = 512, message = "委托配送企业名称的长度不能超过{1}")
	private String companyNamePs;
	
	/**
	 * @Fields IS_BASE_DRUG:isBaseDrug
	 */
	private Double isBaseDrug;
	
	/**
	 * @Fields QUALITY_LEVEL:qualityLevel
	 */
	@Length(max = 50, message = "qualityLevel的长度不能超过{1}")
	private String qualityLevel;
	
	/**
	 * @Fields PURCHASE_TYPE:purchaseType
	 */
	private Double purchaseType;
	
	/**
	 * @Fields SOURCE_ID:sourceId
	 */
	private Double sourceId;
	
	/**
	 * @Fields SOURCE_NAME:sourceName
	 */
	@Length(max = 1024, message = "sourceName的长度不能超过{1}")
	private String sourceName;
	
	/**
	 * @Fields BID_PRICE:bidPrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal bidPrice;
	
	/**
	 * @Fields TEMPORARY_RETAIL_PRICE:temporaryRetailPrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal temporaryRetailPrice;
	
	/**
	 * @Fields MAX_RETAIL_PRICE:maxRetailPrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxRetailPrice;
	
	/**
	 * @Fields MAX_PURCHASE_PRICE:maxPurchasePrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxPurchasePrice;
	
	/**
	 * @Fields REFERENCE_PRICE:referencePrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal referencePrice;
	
	/**
	 * @Fields MAX_LISTING_PRICE:maxListingPrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxListingPrice;
	
	/**
	 * @Fields USING_RANG:usingRang
	 */
	private Double usingRang;
	
	/**
	 * @Fields HOSPITAL_ID:hospitalId
	 */
	@Length(max = 36, message = "hospitalId的长度不能超过{1}")
	private String hospitalId;
	
	/**
	 * @Fields HOSPITAL_NAME:hospitalName
	 */
	@Length(max = 1024, message = "hospitalName的长度不能超过{1}")
	private String hospitalName;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_ID:hospitalDepartmentId
	 */
	@Range(message = "数值范围不正确")
	private Integer hospitalDepartmentId;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_NAME:hospitalDepartmentName
	 */
	@Length(max = 1024, message = "hospitalDepartmentName的长度不能超过{1}")
	private String hospitalDepartmentName;
	
	/**
	 * @Fields REMARK:remark
	 */
	@Length(max = 1024, message = "remark的长度不能超过{1}")
	private String remark;
	
	/**
	 * @Fields SUBMIT_STATUS:submitStatus
	 */
	private Double submitStatus;
	
	/**
	 * @Fields SUBMIT_USER_ID:submitUserId
	 */
	@Length(max = 36, message = "submitUserId的长度不能超过{1}")
	private String submitUserId;
	
	/**
	 * @Fields SUBMIT_USER_NAME:submitUserName
	 */
	@Length(max = 256, message = "submitUserName的长度不能超过{1}")
	private String submitUserName;
	
	/**
	 * @Fields SUBMIT_TIME:submitTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	
	/**
	 * @Fields AUDIT_STATUS:auditStatus
	 */
	private Double auditStatus;
	
	/**
	 * @Fields AUDIT_USER_ID:auditUserId
	 */
	@Length(max = 36, message = "auditUserId的长度不能超过{1}")
	private String auditUserId;
	
	/**
	 * @Fields AUDIT_USER_NAME:auditUserName
	 */
	@Length(max = 256, message = "auditUserName的长度不能超过{1}")
	private String auditUserName;
	
	/**
	 * @Fields AUDIT_TIME:auditTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime;
	
	/**
	 * @Fields AUDIT_REMARK:auditRemark
	 */
	@Length(max = 1024, message = "auditRemark的长度不能超过{1}")
	private String auditRemark;
	
	/**
	 * @Fields IS_USING:isUsing
	 */
	private Double isUsing;
	
	/**
	 * @Fields DEAL_PERSON_ID:dealPersonId
	 */
	@Length(max = 36, message = "dealPersonId的长度不能超过{1}")
	private String dealPersonId;
	
	/**
	 * @Fields DEAL_PERSON:dealPerson
	 */
	@Length(max = 1024, message = "dealPerson的长度不能超过{1}")
	private String dealPerson;
	
	/**
	 * @Fields DEAL_TIME:dealTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dealTime;
	
	/**
	 * @Fields DEAL_REASON:dealReason
	 */
	@Length(max = 1024, message = "dealReason的长度不能超过{1}")
	private String dealReason;
	
	/**
	 * @Fields ADD_USER_ID:addUserId
	 */
	@Length(max = 36, message = "addUserId的长度不能超过{1}")
	private String addUserId;
	
	/**
	 * @Fields ADD_USER_NAME:addUserName
	 */
	@Length(max = 256, message = "addUserName的长度不能超过{1}")
	private String addUserName;
	
	/**
	 * @Fields ADD_TIME:addTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields LAST_UPDATE_USER_ID:lastUpdateUserId
	 */
	@Length(max = 36, message = "lastUpdateUserId的长度不能超过{1}")
	private String lastUpdateUserId;
	
	/**
	 * @Fields LAST_UPDATE_USER_NAME:lastUpdateUserName
	 */
	@Length(max = 256, message = "lastUpdateUserName的长度不能超过{1}")
	private String lastUpdateUserName;
	
	/**
	 * @Fields LAST_UPDATE_TIME:lastUpdateTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	/**
	 * @Fields YIMIAO_YEAR:yimiaoYear
	 */
	@Length(max = 10, message = "yimiaoYear的长度不能超过{1}")
	private String yimiaoYear;
	
	/**
	 * @Fields PRODUCT_ID:productId
	 */
	private Double productId;
	
	/**
	 * @Fields SORT_ID:sortId
	 */
	@Length(max = 36, message = "sortId的长度不能超过{1}")
	private String sortId;
	//columns END
	

	public YimiaoCatalogForm(){
	}

	public YimiaoCatalogForm(Long catalogId,String goodsId){
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