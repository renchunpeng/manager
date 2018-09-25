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
 * @date 2016-11-23 10:33:42
 *
 */
public class YimiaoOrderdetailRetForm  {

	//columns START
	
	/**
	 * @Fields ORDERDETAIL_RET_ID:orderdetailRetId
	 */
	@NotEmpty(message = "请填写orderdetailRetId")
	@Length(max = 36, message = "orderdetailRetId的长度不能超过{1}")
	private String orderdetailRetId;
	
	/**
	 * @Fields ORDER_ID:orderId
	 */
	@NotEmpty(message = "请填写orderId")
	@Length(max = 36, message = "orderId的长度不能超过{1}")
	private String orderId;
	
	/**
	 * @Fields PROCURECATALOG_ID:procurecatalogId
	 */
	@NotNull(message = "请填写procurecatalogId")
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal procurecatalogId;
	
	/**
	 * @Fields GOODS_ID:goodsId
	 */
	@NotNull(message = "请填写goodsId")
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal goodsId;
	
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
	@NotEmpty(message = "请填写goodsName")
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
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal factor;
	
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
	 * @Fields MIDDLE_PACK:middlePack
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal middlePack;
	
	/**
	 * @Fields MAX_PACK:maxPack
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxPack;
	
	/**
	 * @Fields IS_BASE_DRUG:isBaseDrug
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isBaseDrug;
	
	/**
	 * @Fields QUALITY_LEVEL:qualityLevel
	 */
	@Length(max = 50, message = "qualityLevel的长度不能超过{1}")
	private String qualityLevel;
	
	/**
	 * @Fields PURCHASE_TYPE:purchaseType
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseType;
	
	/**
	 * @Fields SOURCE_ID:sourceId
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal sourceId;
	
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
	 * @Fields USING_RANG:usingRang
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal usingRang;
	
	/**
	 * @Fields HOSPITAL_ID:hospitalId
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal hospitalId;
	
	/**
	 * @Fields HOSPITAL_NAME:hospitalName
	 */
	@Length(max = 1024, message = "hospitalName的长度不能超过{1}")
	private String hospitalName;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_ID:hospitalDepartmentId
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal hospitalDepartmentId;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_NAME:hospitalDepartmentName
	 */
	@Length(max = 1024, message = "hospitalDepartmentName的长度不能超过{1}")
	private String hospitalDepartmentName;
	
	/**
	 * @Fields ADMIN_AREA_ID_STATISTICS_DRUG:adminAreaIdStatisticsDrug
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal adminAreaIdStatisticsDrug;
	
	/**
	 * @Fields ADMIN_AREA_NAME_DRUG:adminAreaNameDrug
	 */
	@Length(max = 255, message = "adminAreaNameDrug的长度不能超过{1}")
	private String adminAreaNameDrug;
	
	/**
	 * @Fields ADMIN_AREA_ID_DRUG:adminAreaIdDrug
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal adminAreaIdDrug;
	
	/**
	 * @Fields BELONG_ORG_NAME:belongOrgName
	 */
	@Length(max = 1024, message = "belongOrgName的长度不能超过{1}")
	private String belongOrgName;
	
	/**
	 * @Fields ORDER_TYPE:orderType
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderType;
	
	/**
	 * @Fields ORDER_NAME:orderName
	 */
	@Length(max = 1024, message = "orderName的长度不能超过{1}")
	private String orderName;
	
	/**
	 * @Fields SUBMIT_TIME:submitTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	
	/**
	 * @Fields FILING_ID:filingId
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal filingId;
	
	/**
	 * @Fields COMPANY_ID_PS:companyIdPs
	 */
	@Length(max = 50, message = "companyIdPs的长度不能超过{1}")
	private String companyIdPs;
	
	/**
	 * @Fields COMPANY_NAME_PS:companyNamePs
	 */
	@Length(max = 1024, message = "companyNamePs的长度不能超过{1}")
	private String companyNamePs;
	
	/**
	 * @Fields PURCHASE_PRICE:purchasePrice
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchasePrice;
	
	/**
	 * @Fields PURCHASE_COUNT:purchaseCount
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseCount;
	
	/**
	 * @Fields PURCHASE_AMOUNT:purchaseAmount
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseAmount;
	
	/**
	 * @Fields IS_READ:isRead
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isRead;
	
	/**
	 * @Fields READ_USER_ID:readUserId
	 */
	@Length(max = 36, message = "readUserId的长度不能超过{1}")
	private String readUserId;
	
	/**
	 * @Fields READ_USER_NAME:readUserName
	 */
	@Length(max = 255, message = "readUserName的长度不能超过{1}")
	private String readUserName;
	
	/**
	 * @Fields READ_TIME:readTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date readTime;
	
	/**
	 * @Fields CONFIRM_USER_ID:confirmUserId
	 */
	@Length(max = 36, message = "confirmUserId的长度不能超过{1}")
	private String confirmUserId;
	
	/**
	 * @Fields CONFIRM_USER_NAME:confirmUserName
	 */
	@Length(max = 255, message = "confirmUserName的长度不能超过{1}")
	private String confirmUserName;
	
	/**
	 * @Fields CONFIRM_TIME:confirmTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date confirmTime;
	
	/**
	 * @Fields CONFIRM_STATE:confirmState
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal confirmState;
	
	/**
	 * @Fields ORDERDETAIL_STATE:orderdetailState
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderdetailState;
	
	/**
	 * @Fields REFUSE_REASON:refuseReason
	 */
	@Length(max = 1024, message = "refuseReason的长度不能超过{1}")
	private String refuseReason;
	
	/**
	 * @Fields DETAIL_DISTRIBUTE_ADDRESS:detailDistributeAddress
	 */
	@Length(max = 1024, message = "detailDistributeAddress的长度不能超过{1}")
	private String detailDistributeAddress;
	
	/**
	 * @Fields TOTAL_DISTRIBUTE_COUNT:totalDistributeCount
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalDistributeCount;
	
	/**
	 * @Fields TOTAL_DISTRIBUTE_AMOUNT:totalDistributeAmount
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalDistributeAmount;
	
	/**
	 * @Fields TOTAL_WAREHOUSE_COUNT:totalWarehouseCount
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalWarehouseCount;
	
	/**
	 * @Fields TOTAL_WAREHOUSE_AMOUNT:totalWarehouseAmount
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalWarehouseAmount;
	
	/**
	 * @Fields TOTAL_RETURN_AMOUNT:totalReturnAmount
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalReturnAmount;
	
	/**
	 * @Fields TOTAL_RETURN_COUNT:totalReturnCount
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalReturnCount;
	
	/**
	 * @Fields IS_USING:isUsing
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isUsing;
	
	/**
	 * @Fields COMP_RATIO:compRatio
	 */
	@Digits(integer = 18, fraction = 6, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal compRatio;
	
	/**
	 * @Fields ORDER_CUSTOM_INFO:orderCustomInfo
	 */
	@Length(max = 1024, message = "orderCustomInfo的长度不能超过{1}")
	private String orderCustomInfo;
	
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
	//columns END
	

	public YimiaoOrderdetailRetForm(){
	}

	public YimiaoOrderdetailRetForm(String orderdetailRetId){
		this.orderdetailRetId = orderdetailRetId;
	}

	
	public void setOrderdetailRetId(String orderdetailRetId){
		this.orderdetailRetId = orderdetailRetId;
	}
	public String getOrderdetailRetId(){
		return orderdetailRetId;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	public String getOrderId(){
		return orderId;
	}
	
	public void setProcurecatalogId(BigDecimal procurecatalogId){
		this.procurecatalogId = procurecatalogId;
	}
	public BigDecimal getProcurecatalogId(){
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
	
	public void setUsingRang(BigDecimal usingRang){
		this.usingRang = usingRang;
	}
	public BigDecimal getUsingRang(){
		return usingRang;
	}
	
	public void setHospitalId(BigDecimal hospitalId){
		this.hospitalId = hospitalId;
	}
	public BigDecimal getHospitalId(){
		return hospitalId;
	}
	
	public void setHospitalName(String hospitalName){
		this.hospitalName = hospitalName;
	}
	public String getHospitalName(){
		return hospitalName;
	}
	
	public void setHospitalDepartmentId(BigDecimal hospitalDepartmentId){
		this.hospitalDepartmentId = hospitalDepartmentId;
	}
	public BigDecimal getHospitalDepartmentId(){
		return hospitalDepartmentId;
	}
	
	public void setHospitalDepartmentName(String hospitalDepartmentName){
		this.hospitalDepartmentName = hospitalDepartmentName;
	}
	public String getHospitalDepartmentName(){
		return hospitalDepartmentName;
	}
	
	public void setAdminAreaIdStatisticsDrug(BigDecimal adminAreaIdStatisticsDrug){
		this.adminAreaIdStatisticsDrug = adminAreaIdStatisticsDrug;
	}
	public BigDecimal getAdminAreaIdStatisticsDrug(){
		return adminAreaIdStatisticsDrug;
	}
	
	public void setAdminAreaNameDrug(String adminAreaNameDrug){
		this.adminAreaNameDrug = adminAreaNameDrug;
	}
	public String getAdminAreaNameDrug(){
		return adminAreaNameDrug;
	}
	
	public void setAdminAreaIdDrug(BigDecimal adminAreaIdDrug){
		this.adminAreaIdDrug = adminAreaIdDrug;
	}
	public BigDecimal getAdminAreaIdDrug(){
		return adminAreaIdDrug;
	}
	
	public void setBelongOrgName(String belongOrgName){
		this.belongOrgName = belongOrgName;
	}
	public String getBelongOrgName(){
		return belongOrgName;
	}
	
	public void setOrderType(BigDecimal orderType){
		this.orderType = orderType;
	}
	public BigDecimal getOrderType(){
		return orderType;
	}
	
	public void setOrderName(String orderName){
		this.orderName = orderName;
	}
	public String getOrderName(){
		return orderName;
	}
	
	public void setSubmitTime(Date submitTime){
		this.submitTime = submitTime;
	}
	public Date getSubmitTime(){
		return submitTime;
	}
	
	public void setFilingId(BigDecimal filingId){
		this.filingId = filingId;
	}
	public BigDecimal getFilingId(){
		return filingId;
	}
	
	public void setCompanyIdPs(String companyIdPs){
		this.companyIdPs = companyIdPs;
	}
	public String getCompanyIdPs(){
		return companyIdPs;
	}
	
	public void setCompanyNamePs(String companyNamePs){
		this.companyNamePs = companyNamePs;
	}
	public String getCompanyNamePs(){
		return companyNamePs;
	}
	
	public void setPurchasePrice(BigDecimal purchasePrice){
		this.purchasePrice = purchasePrice;
	}
	public BigDecimal getPurchasePrice(){
		return purchasePrice;
	}
	
	public void setPurchaseCount(BigDecimal purchaseCount){
		this.purchaseCount = purchaseCount;
	}
	public BigDecimal getPurchaseCount(){
		return purchaseCount;
	}
	
	public void setPurchaseAmount(BigDecimal purchaseAmount){
		this.purchaseAmount = purchaseAmount;
	}
	public BigDecimal getPurchaseAmount(){
		return purchaseAmount;
	}
	
	public void setIsRead(BigDecimal isRead){
		this.isRead = isRead;
	}
	public BigDecimal getIsRead(){
		return isRead;
	}
	
	public void setReadUserId(String readUserId){
		this.readUserId = readUserId;
	}
	public String getReadUserId(){
		return readUserId;
	}
	
	public void setReadUserName(String readUserName){
		this.readUserName = readUserName;
	}
	public String getReadUserName(){
		return readUserName;
	}
	
	public void setReadTime(Date readTime){
		this.readTime = readTime;
	}
	public Date getReadTime(){
		return readTime;
	}
	
	public void setConfirmUserId(String confirmUserId){
		this.confirmUserId = confirmUserId;
	}
	public String getConfirmUserId(){
		return confirmUserId;
	}
	
	public void setConfirmUserName(String confirmUserName){
		this.confirmUserName = confirmUserName;
	}
	public String getConfirmUserName(){
		return confirmUserName;
	}
	
	public void setConfirmTime(Date confirmTime){
		this.confirmTime = confirmTime;
	}
	public Date getConfirmTime(){
		return confirmTime;
	}
	
	public void setConfirmState(BigDecimal confirmState){
		this.confirmState = confirmState;
	}
	public BigDecimal getConfirmState(){
		return confirmState;
	}
	
	public void setOrderdetailState(BigDecimal orderdetailState){
		this.orderdetailState = orderdetailState;
	}
	public BigDecimal getOrderdetailState(){
		return orderdetailState;
	}
	
	public void setRefuseReason(String refuseReason){
		this.refuseReason = refuseReason;
	}
	public String getRefuseReason(){
		return refuseReason;
	}
	
	public void setDetailDistributeAddress(String detailDistributeAddress){
		this.detailDistributeAddress = detailDistributeAddress;
	}
	public String getDetailDistributeAddress(){
		return detailDistributeAddress;
	}
	
	public void setTotalDistributeCount(BigDecimal totalDistributeCount){
		this.totalDistributeCount = totalDistributeCount;
	}
	public BigDecimal getTotalDistributeCount(){
		return totalDistributeCount;
	}
	
	public void setTotalDistributeAmount(BigDecimal totalDistributeAmount){
		this.totalDistributeAmount = totalDistributeAmount;
	}
	public BigDecimal getTotalDistributeAmount(){
		return totalDistributeAmount;
	}
	
	public void setTotalWarehouseCount(BigDecimal totalWarehouseCount){
		this.totalWarehouseCount = totalWarehouseCount;
	}
	public BigDecimal getTotalWarehouseCount(){
		return totalWarehouseCount;
	}
	
	public void setTotalWarehouseAmount(BigDecimal totalWarehouseAmount){
		this.totalWarehouseAmount = totalWarehouseAmount;
	}
	public BigDecimal getTotalWarehouseAmount(){
		return totalWarehouseAmount;
	}
	
	public void setTotalReturnAmount(BigDecimal totalReturnAmount){
		this.totalReturnAmount = totalReturnAmount;
	}
	public BigDecimal getTotalReturnAmount(){
		return totalReturnAmount;
	}
	
	public void setTotalReturnCount(BigDecimal totalReturnCount){
		this.totalReturnCount = totalReturnCount;
	}
	public BigDecimal getTotalReturnCount(){
		return totalReturnCount;
	}
	
	public void setIsUsing(BigDecimal isUsing){
		this.isUsing = isUsing;
	}
	public BigDecimal getIsUsing(){
		return isUsing;
	}
	
	public void setCompRatio(BigDecimal compRatio){
		this.compRatio = compRatio;
	}
	public BigDecimal getCompRatio(){
		return compRatio;
	}
	
	public void setOrderCustomInfo(String orderCustomInfo){
		this.orderCustomInfo = orderCustomInfo;
	}
	public String getOrderCustomInfo(){
		return orderCustomInfo;
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

}