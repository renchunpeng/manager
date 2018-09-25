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
 * @date 2016-11-18 11:35:37
 *
 */
public class YimiaoPurchaseOrderForm  {

	//columns START
	
	/**
	 * @Fields ORDER_ID:order_id（有序guid编号）
	 */
	@NotEmpty(message = "请填写order_id（有序guid编号）")
	@Length(max = 36, message = "order_id（有序guid编号）的长度不能超过{1}")
	private String orderId;
	
	/**
	 * @Fields HOSPITAL_ID:医疗机构编号
	 */
	@Length(max = 36, message = "医疗机构编号的长度不能超过{1}")
	private String hospitalId;
	
	/**
	 * @Fields HOSPITAL_NAME:医疗机构名称
	 */
	@Length(max = 1024, message = "医疗机构名称的长度不能超过{1}")
	private String hospitalName;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_ID:医疗机构部门编号
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal hospitalDepartmentId;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_NAME:医疗机构部门名称
	 */
	@Length(max = 1024, message = "医疗机构部门名称的长度不能超过{1}")
	private String hospitalDepartmentName;
	
	/**
	 * @Fields ORDER_TYPE:订单类型（0：正常订单，1：急救药品临时订单）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderType;
	
	/**
	 * @Fields ORDER_NAME:订单名称
	 */
	@Length(max = 1024, message = "订单名称的长度不能超过{1}")
	private String orderName;
	
	/**
	 * @Fields ORDER_AMOUNT:订单金额
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderAmount;
	
	/**
	 * @Fields ORDER_REMARKS:订单备注
	 */
	@Length(max = 1024, message = "订单备注的长度不能超过{1}")
	private String orderRemarks;
	
	/**
	 * @Fields SUBMIT_TIME:提交时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	
	/**
	 * @Fields SUBMINTER:提交人
	 */
	@Length(max = 1024, message = "提交人的长度不能超过{1}")
	private String subminter;
	
	/**
	 * @Fields IS_AUTO_SUBMINT:是否自动提交
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isAutoSubmint;
	
	/**
	 * @Fields AUTO_SUBMIT_TIME:自动提交时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date autoSubmitTime;
	
	/**
	 * @Fields ORDER_STATE:完成进度(0:待提交,1:已提交)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderState;
	
	/**
	 * @Fields DEFAULT_DISTRIBUTE_ADDR:defaultDistributeAddr
	 */
	@Length(max = 255, message = "defaultDistributeAddr的长度不能超过{1}")
	private String defaultDistributeAddr;
	
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
	//columns END
	

	public YimiaoPurchaseOrderForm(){
	}

	public YimiaoPurchaseOrderForm(String orderId){
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