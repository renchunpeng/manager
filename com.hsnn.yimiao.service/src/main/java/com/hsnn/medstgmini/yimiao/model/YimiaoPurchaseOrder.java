package com.hsnn.medstgmini.yimiao.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-11-18 11:35:37
 *
 */
public class YimiaoPurchaseOrder{
	
	//alias
	public static final String TABLE_ALIAS = "疫苗_订单表";
	
	//columns START
	/**
	 * @Fields orderId:order_id（有序guid编号）
	 */
	private String orderId;
	
	/**
	 * @Fields hospitalId:医疗机构编号
	 */
	private String hospitalId;
	
	/**
	 * @Fields hospitalName:医疗机构名称
	 */
	private String hospitalName;
	
	/**
	 * @Fields hospitalDepartmentId:医疗机构部门编号
	 */
	private BigDecimal hospitalDepartmentId;
	
	/**
	 * @Fields hospitalDepartmentName:医疗机构部门名称
	 */
	private String hospitalDepartmentName;
	
	/**
	 * @Fields orderType:订单类型（0：正常订单，1：急救药品临时订单）
	 */
	private BigDecimal orderType;
	
	/**
	 * @Fields orderName:订单名称
	 */
	private String orderName;
	
	/**
	 * @Fields orderAmount:订单金额
	 */
	private BigDecimal orderAmount;
	
	/**
	 * @Fields orderRemarks:订单备注
	 */
	private String orderRemarks;
	
	/**
	 * @Fields submitTime:提交时间
	 */
	private Date submitTime;
	
	/**
	 * @Fields subminter:提交人
	 */
	private String subminter;
	
	/**
	 * @Fields isAutoSubmint:是否自动提交
	 */
	private BigDecimal isAutoSubmint;
	
	/**
	 * @Fields autoSubmitTime:自动提交时间
	 */
	private Date autoSubmitTime;
	
	/**
	 * @Fields orderState:完成进度(0:待提交,1:已提交)
	 */
	private BigDecimal orderState;
	
	/**
	 * @Fields defaultDistributeAddr:defaultDistributeAddr
	 */
	private String defaultDistributeAddr;
	
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
	
	//columns END

	public YimiaoPurchaseOrder(){
	}

	public YimiaoPurchaseOrder(String orderId){
		this.orderId = orderId;
	}

	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public String getOrderId(){
		return orderId;
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
	
	public void setOrderAmount(BigDecimal orderAmount){
		this.orderAmount = orderAmount;
	}
	
	public BigDecimal getOrderAmount(){
		return orderAmount;
	}
	
	public void setOrderRemarks(String orderRemarks){
		this.orderRemarks = orderRemarks;
	}
	
	public String getOrderRemarks(){
		return orderRemarks;
	}
	
	public void setSubmitTime(Date submitTime){
		this.submitTime = submitTime;
	}
	
	public Date getSubmitTime(){
		return submitTime;
	}
	
	public void setSubminter(String subminter){
		this.subminter = subminter;
	}
	
	public String getSubminter(){
		return subminter;
	}
	
	public void setIsAutoSubmint(BigDecimal isAutoSubmint){
		this.isAutoSubmint = isAutoSubmint;
	}
	
	public BigDecimal getIsAutoSubmint(){
		return isAutoSubmint;
	}
	
	public void setAutoSubmitTime(Date autoSubmitTime){
		this.autoSubmitTime = autoSubmitTime;
	}
	
	public Date getAutoSubmitTime(){
		return autoSubmitTime;
	}
	
	public void setOrderState(BigDecimal orderState){
		this.orderState = orderState;
	}
	
	public BigDecimal getOrderState(){
		return orderState;
	}
	
	public void setDefaultDistributeAddr(String defaultDistributeAddr){
		this.defaultDistributeAddr = defaultDistributeAddr;
	}
	
	public String getDefaultDistributeAddr(){
		return defaultDistributeAddr;
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