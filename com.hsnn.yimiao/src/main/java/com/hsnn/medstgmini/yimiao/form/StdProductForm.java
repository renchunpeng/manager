package com.hsnn.medstgmini.yimiao.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-12-06 10:26:14
 *
 */
public class StdProductForm  {

	//columns START
	
	/**
	 * @Fields PRODUCT_ID:一级目录id
	 */
	@NotNull(message = "请填写一级目录id")
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private Integer productId;
	
	/**
	 * @Fields PRODUCT_NAME:一级目录名称
	 */
	@Length(max = 256, message = "一级目录名称的长度不能超过{1}")
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
	 * @Fields MEDICINEMODEL:medicinemodel
	 */
	@Length(max = 256, message = "medicinemodel的长度不能超过{1}")
	private String medicinemodel;
	
	/**
	 * @Fields MEDICINEMODEL_SPEL:medicinemodelSpel
	 */
	@Length(max = 256, message = "medicinemodelSpel的长度不能超过{1}")
	private String medicinemodelSpel;
	
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
	 * @Fields LEVEL_DAY:levelDay
	 */
	@Length(max = 512, message = "levelDay的长度不能超过{1}")
	private String levelDay;
	
	/**
	 * @Fields REMARK:remark
	 */
	@Length(max = 512, message = "remark的长度不能超过{1}")
	private String remark;
	
	/**
	 * @Fields STATUS:status
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal status;
	
	/**
	 * @Fields AUDIT_USER_NAME:auditUserName
	 */
	@Length(max = 255, message = "auditUserName的长度不能超过{1}")
	private String auditUserName;
	
	/**
	 * @Fields AUDIT_REMARK:auditRemark
	 */
	@Length(max = 2048, message = "auditRemark的长度不能超过{1}")
	private String auditRemark;
	
	/**
	 * @Fields AUDIT_TIME:auditTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime;
	
	/**
	 * @Fields IS_USING:isUsing
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isUsing;
	
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
	 * @Fields DRUG_CLASSIFICATION:药品分类
	 */
	@Length(max = 256, message = "药品分类的长度不能超过{1}")
	private String drugClassification;
	
	/**
	 * @Fields COMPONENT:主成分
	 */
	@Length(max = 2048, message = "主成分的长度不能超过{1}")
	private String component;
	
	/**
	 * @Fields DRUG_CATEGORY:药品类别
	 */
	@Length(max = 256, message = "药品类别的长度不能超过{1}")
	private String drugCategory;
	
	/**
	 * @Fields PRODUCT_CODE:productCode
	 */
	@Length(max = 36, message = "productCode的长度不能超过{1}")
	private String productCode;
	
	/**
	 * @Fields SORT_ID:sortId
	 */
	@Range(message = "数值范围不正确")
	private Integer sortId;
	
	/**
	 * @Fields SORT_NAME:sortName
	 */
	@Length(max = 128, message = "sortName的长度不能超过{1}")
	private String sortName;
	
	/**
	 * @Fields BELONG_AREA_ID:belongAreaId
	 */
	@Range(message = "数值范围不正确")
	private Integer belongAreaId;
	
	/**
	 * @Fields BELONG_AREA_NAME:belongAreaName
	 */
	@Length(max = 36, message = "belongAreaName的长度不能超过{1}")
	private String belongAreaName;
	
	/**
	 * @Fields PRODUCT_NAME_FIRST:productNameFirst
	 */
	@Length(max = 128, message = "productNameFirst的长度不能超过{1}")
	private String productNameFirst;
	
	/**
	 * @Fields PRODUCT_NAME_SECOND:productNameSecond
	 */
	@Length(max = 128, message = "productNameSecond的长度不能超过{1}")
	private String productNameSecond;
	
	/**
	 * @Fields SUBMIT_STATE:submitState
	 */
	@Range(message = "数值范围不正确")
	private Integer submitState;
	
	/**
	 * @Fields SUBMIT_USER_ID:submitUserId
	 */
	@Length(max = 36, message = "submitUserId的长度不能超过{1}")
	private String submitUserId;
	
	/**
	 * @Fields SUBMIT_USER_NAME:submitUserName
	 */
	@Length(max = 36, message = "submitUserName的长度不能超过{1}")
	private String submitUserName;
	
	/**
	 * @Fields SUBMIT_TIME:submitTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	
	/**
	 * @Fields AUDIT_STATE:auditState
	 */
	@Range(message = "数值范围不正确")
	private Integer auditState;
	
	/**
	 * @Fields AUDITOR_USER_ID:auditorUserId
	 */
	@Length(max = 36, message = "auditorUserId的长度不能超过{1}")
	private String auditorUserId;
	
	/**
	 * @Fields AUDITOR:auditor
	 */
	@Length(max = 36, message = "auditor的长度不能超过{1}")
	private String auditor;
	
	/**
	 * @Fields IS_CAN_ADD_GOODS:isCanAddGoods
	 */
	@Range(message = "数值范围不正确")
	private Integer isCanAddGoods;
	
	/**
	 * @Fields OLD_PRODUCT_ID:oldProductId
	 */
	@Length(max = 12, message = "oldProductId的长度不能超过{1}")
	private String oldProductId;
	
	/**
	 * @Fields OLD_SORT_ID:oldSortId
	 */
	@Length(max = 12, message = "oldSortId的长度不能超过{1}")
	private String oldSortId;
	//columns END
	

	public StdProductForm(){
	}

	public StdProductForm(Integer productId){
		this.productId = productId;
	}

	
	public void setProductId(Integer productId){
		this.productId = productId;
	}
	public Integer getProductId(){
		return productId;
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
	
	public void setMedicinemodel(String medicinemodel){
		this.medicinemodel = medicinemodel;
	}
	public String getMedicinemodel(){
		return medicinemodel;
	}
	
	public void setMedicinemodelSpel(String medicinemodelSpel){
		this.medicinemodelSpel = medicinemodelSpel;
	}
	public String getMedicinemodelSpel(){
		return medicinemodelSpel;
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
	
	public void setLevelDay(String levelDay){
		this.levelDay = levelDay;
	}
	public String getLevelDay(){
		return levelDay;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}
	
	public void setStatus(BigDecimal status){
		this.status = status;
	}
	public BigDecimal getStatus(){
		return status;
	}
	
	public void setAuditUserName(String auditUserName){
		this.auditUserName = auditUserName;
	}
	public String getAuditUserName(){
		return auditUserName;
	}
	
	public void setAuditRemark(String auditRemark){
		this.auditRemark = auditRemark;
	}
	public String getAuditRemark(){
		return auditRemark;
	}
	
	public void setAuditTime(Date auditTime){
		this.auditTime = auditTime;
	}
	public Date getAuditTime(){
		return auditTime;
	}
	
	public void setIsUsing(BigDecimal isUsing){
		this.isUsing = isUsing;
	}
	public BigDecimal getIsUsing(){
		return isUsing;
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
	
	public void setDrugClassification(String drugClassification){
		this.drugClassification = drugClassification;
	}
	public String getDrugClassification(){
		return drugClassification;
	}
	
	public void setComponent(String component){
		this.component = component;
	}
	public String getComponent(){
		return component;
	}
	
	public void setDrugCategory(String drugCategory){
		this.drugCategory = drugCategory;
	}
	public String getDrugCategory(){
		return drugCategory;
	}
	
	public void setProductCode(String productCode){
		this.productCode = productCode;
	}
	public String getProductCode(){
		return productCode;
	}
	
	public void setSortId(Integer sortId){
		this.sortId = sortId;
	}
	public Integer getSortId(){
		return sortId;
	}
	
	public void setSortName(String sortName){
		this.sortName = sortName;
	}
	public String getSortName(){
		return sortName;
	}
	
	public void setBelongAreaId(Integer belongAreaId){
		this.belongAreaId = belongAreaId;
	}
	public Integer getBelongAreaId(){
		return belongAreaId;
	}
	
	public void setBelongAreaName(String belongAreaName){
		this.belongAreaName = belongAreaName;
	}
	public String getBelongAreaName(){
		return belongAreaName;
	}
	
	public void setProductNameFirst(String productNameFirst){
		this.productNameFirst = productNameFirst;
	}
	public String getProductNameFirst(){
		return productNameFirst;
	}
	
	public void setProductNameSecond(String productNameSecond){
		this.productNameSecond = productNameSecond;
	}
	public String getProductNameSecond(){
		return productNameSecond;
	}
	
	public void setSubmitState(Integer submitState){
		this.submitState = submitState;
	}
	public Integer getSubmitState(){
		return submitState;
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
	
	public void setAuditState(Integer auditState){
		this.auditState = auditState;
	}
	public Integer getAuditState(){
		return auditState;
	}
	
	public void setAuditorUserId(String auditorUserId){
		this.auditorUserId = auditorUserId;
	}
	public String getAuditorUserId(){
		return auditorUserId;
	}
	
	public void setAuditor(String auditor){
		this.auditor = auditor;
	}
	public String getAuditor(){
		return auditor;
	}
	
	public void setIsCanAddGoods(Integer isCanAddGoods){
		this.isCanAddGoods = isCanAddGoods;
	}
	public Integer getIsCanAddGoods(){
		return isCanAddGoods;
	}
	
	public void setOldProductId(String oldProductId){
		this.oldProductId = oldProductId;
	}
	public String getOldProductId(){
		return oldProductId;
	}
	
	public void setOldSortId(String oldSortId){
		this.oldSortId = oldSortId;
	}
	public String getOldSortId(){
		return oldSortId;
	}

}