package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-25 09:44:20
 *
 */
public class StdProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 111225503649133864L;

	//alias
	public static final String TABLE_ALIAS = "StdProduct";
	
	//columns START
	/**
	 * @Fields productId:product_id
	 */
	private Integer productId;
	private String nproductId;
	
	/**
	 * @Fields productName:通用名
	 */
	@PropertyNameAnnotation(annotation="通用名")
	private String productName;
	
	/**
	 * @Fields productSpelName:通用名拼音码
	 */
	private String productSpelName;
	
	/**
	 * @Fields productEngName:productEngName
	 */
	private String productWbName;
	
	/**
	 * @Fields medicinemodel:剂型
	 */
	@PropertyNameAnnotation(annotation="剂型")
	private String medicinemodel;
	/**
	 * @Fields outlook:规格
	 */
	@PropertyNameAnnotation(annotation="规格")
	private String outlook;
	
	/**
	 * @Fields factor:转换比
	 */
	@PropertyNameAnnotation(annotation="转换比")
	private Integer factor;
	
	/**
	 * @Fields levelDay:日服用量
	 */
	@PropertyNameAnnotation(annotation="日服用量")
	private String levelDay;
	
	/**
	 * @Fields remark:录入备注
	 */
	@PropertyNameAnnotation(annotation="录入备注")
	private String remark;
	
	/**
	 * @Fields status:状态(0:已保存待提交,1,已提交待审核,2审核通过,3审核不通过)
	 */
	@PropertyNameAnnotation(annotation="状态(0:已保存待提交,1:已提交待审核,2:审核通过,3:审核不通过)")
	private Integer status;
	
	/**
	 * @Fields isUsing:是否有效
	 */
	@PropertyNameAnnotation(annotation="是否有效(0:停用,1:启用)")
	private Integer isUsing;
	
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
	 * @Fields auditRemark:审核备注
	 */
	@PropertyNameAnnotation(annotation="审核备注")
	private String auditRemark;
	
	/**
	 * @Fields audit_user_name:审核人
	 */
	@Length(max = 256, message = "审核人")
	private String auditUserName;
	
	/**
	 * @Fields auditTime:审核时间
	 */
	@PropertyNameAnnotation(annotation="审核时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditTime;

	//新增字段：主成分，药品分类，药品类别
	@PropertyNameAnnotation(annotation="主成分")
	private String component;	
	
	@PropertyNameAnnotation(annotation="药品分类")
	private String drugClassification;
	
	@PropertyNameAnnotation(annotation="药品类别")
	private String drugCategory;
	
	
	/**
	 * @Fields productAttr:药品属性1中药2西药
	 */
	@PropertyNameAnnotation(annotation="药品属性")
	private String productAttr;
	
	//columns END

	public StdProduct(){
	}

	public StdProduct(Integer productId){
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
	
	public void setFactor(Integer factor){
		this.factor = factor;
	}
	
	public Integer getFactor(){
		return factor;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
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

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	//剂型拼音码
	private String medicinemodelSpel;

	public String getMedicinemodelSpel() {
		return medicinemodelSpel;
	}

	public void setMedicinemodelSpel(String medicinemodelSpel) {
		this.medicinemodelSpel = medicinemodelSpel;
	}

	public String getLevelDay() {
		return levelDay;
	}

	public void setLevelDay(String levelDay) {
		this.levelDay = levelDay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public String getProductWbName() {
		return productWbName;
	}

	public void setProductWbName(String productWbName) {
		this.productWbName = productWbName;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getDrugClassification() {
		return drugClassification;
	}

	public void setDrugClassification(String drugClassification) {
		this.drugClassification = drugClassification;
	}

	public String getDrugCategory() {
		return drugCategory;
	}

	public void setDrugCategory(String drugCategory) {
		this.drugCategory = drugCategory;
	}

	public String getProductAttr() {
		return productAttr;
	}

	public void setProductAttr(String productAttr) {
		this.productAttr = productAttr;
	}

	public String getNproductId() {
		return nproductId;
	}

	public void setNproductId(String nproductId) {
		this.nproductId = nproductId;
	}
}