package com.hsnn.medstgmini.base.std.form;

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
 * @date 2016-04-11 14:35:11
 *
 */
public class StdProductSynonymForm  {

	//columns START
	
	/**
	 * @Fields id:product_id
	 */
	@NotNull(message = "请填写product_id")
	@Range(message = "数值范围不正确")
	private Integer id;
	
	/**
	 * @Fields product_name:通用名
	 */
	@Length(max = 256, message = "通用名的长度不能超过{1}")
	private String productName;
	
	/**
	 * @Fields synonym:异名
	 */
	@Length(max = 512, message = "异名的长度不能超过{1}")
	private String synonym;
	
	/**
	 * @Fields remark:备注
	 */
	@Length(max = 1024, message = "备注的长度不能超过{1}")
	private String remark;
	
	/**
	 * @Fields add_user_id:记录添加人id
	 */
	@Length(max = 36, message = "记录添加人id的长度不能超过{1}")
	private String addUserId;
	
	/**
	 * @Fields add_user_name:记录添加人
	 */
	@Length(max = 256, message = "记录添加人的长度不能超过{1}")
	private String addUserName;
	
	/**
	 * @Fields add_time:记录添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	//columns END
	

	public StdProductSynonymForm(){
	}

	public StdProductSynonymForm(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}
	
	public void setSynonym(String synonym){
		this.synonym = synonym;
	}
	public String getSynonym(){
		return synonym;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return remark;
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

}