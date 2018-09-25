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
 * @date 2017-12-11 17:24:13
 *
 */
public class YimiaoPriceadjplanForm  {

	//columns START
	
	/**
	 * @Fields PRICE_ADJ_PLAN_ID:调价计划id
	 */
	@NotEmpty(message = "请填写调价计划id")
	@Length(max = 36, message = "调价计划id的长度不能超过{1}")
	private String priceAdjPlanId;
	
	/**
	 * @Fields PRICE_ADJ_PLAN_NAME:调价计划名称
	 */
	@Length(max = 512, message = "调价计划名称的长度不能超过{1}")
	private String priceAdjPlanName;
	
	/**
	 * @Fields PRICE_ADJ_PLAN_CAT:调价计划类型
	 */
	@Length(max = 128, message = "调价计划类型的长度不能超过{1}")
	private String priceAdjPlanCat;
	
	/**
	 * @Fields EXECUTE_CAT:执行类型：1立刻执行2定时执行
	 */
	@Range(message = "数值范围不正确")
	private Integer executeCat;
	
	/**
	 * @Fields CREATE_DATETIME:创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDatetime;
	
	/**
	 * @Fields CREATE_USER:创建人
	 */
	@Length(max = 36, message = "创建人的长度不能超过{1}")
	private String createUser;
	
	/**
	 * @Fields CREATE_ORG_ID:createOrgId
	 */
	@Length(max = 36, message = "createOrgId的长度不能超过{1}")
	private String createOrgId;
	
	/**
	 * @Fields EXECUTE_DATETIME:执行时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date executeDatetime;
	
	/**
	 * @Fields PRICE_ADJ_ACCORD:调价依据
	 */
	@Length(max = 512, message = "调价依据的长度不能超过{1}")
	private String priceAdjAccord;
	
	/**
	 * @Fields REMARK:备注
	 */
	@Length(max = 1024, message = "备注的长度不能超过{1}")
	private String remark;
	
	/**
	 * @Fields STATUS:状态0未执行1已执行
	 */
	@Range(message = "数值范围不正确")
	private Integer status;
	
	/**
	 * @Fields UPD_DATETIME:更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updDatetime;
	
	/**
	 * @Fields UPD_USER:更新人
	 */
	@Length(max = 36, message = "更新人的长度不能超过{1}")
	private String updUser;
	//columns END
	

	public YimiaoPriceadjplanForm(){
	}

	public YimiaoPriceadjplanForm(String priceAdjPlanId){
		this.priceAdjPlanId = priceAdjPlanId;
	}

	
	public void setPriceAdjPlanId(String priceAdjPlanId){
		this.priceAdjPlanId = priceAdjPlanId;
	}
	public String getPriceAdjPlanId(){
		return priceAdjPlanId;
	}
	
	public void setPriceAdjPlanName(String priceAdjPlanName){
		this.priceAdjPlanName = priceAdjPlanName;
	}
	public String getPriceAdjPlanName(){
		return priceAdjPlanName;
	}
	
	public void setPriceAdjPlanCat(String priceAdjPlanCat){
		this.priceAdjPlanCat = priceAdjPlanCat;
	}
	public String getPriceAdjPlanCat(){
		return priceAdjPlanCat;
	}
	
	public void setExecuteCat(Integer executeCat){
		this.executeCat = executeCat;
	}
	public Integer getExecuteCat(){
		return executeCat;
	}
	
	public void setCreateDatetime(Date createDatetime){
		this.createDatetime = createDatetime;
	}
	public Date getCreateDatetime(){
		return createDatetime;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateUser(){
		return createUser;
	}
	
	public void setCreateOrgId(String createOrgId){
		this.createOrgId = createOrgId;
	}
	public String getCreateOrgId(){
		return createOrgId;
	}
	
	public void setExecuteDatetime(Date executeDatetime){
		this.executeDatetime = executeDatetime;
	}
	public Date getExecuteDatetime(){
		return executeDatetime;
	}
	
	public void setPriceAdjAccord(String priceAdjAccord){
		this.priceAdjAccord = priceAdjAccord;
	}
	public String getPriceAdjAccord(){
		return priceAdjAccord;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	
	public void setUpdDatetime(Date updDatetime){
		this.updDatetime = updDatetime;
	}
	public Date getUpdDatetime(){
		return updDatetime;
	}
	
	public void setUpdUser(String updUser){
		this.updUser = updUser;
	}
	public String getUpdUser(){
		return updUser;
	}

}