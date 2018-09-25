package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-24 15:55:57
 *
 */
public class TestStdProduct  {
	
	//alias
	public static final String TABLE_ALIAS = "TestStdProduct";
	
	//columns START
	/**
	 * @Fields productId:product_id
	 */
	private Integer productId;
	
	/**
	 * @Fields productName:通用名
	 */
	private String productName;
	
	/**
	 * @Fields status:状态(0:已保存待提交,1,已提交待审核,2审核通过,3审核不通过)
	 */
	private Integer status;
	
	/**
	 * @Fields isUsing:是否有效
	 */
	private Integer isUsing;
	
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
	
	//columns END

	public TestStdProduct(){
	}

	public TestStdProduct(Integer productId){
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


}