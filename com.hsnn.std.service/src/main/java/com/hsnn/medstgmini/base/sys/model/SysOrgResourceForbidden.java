package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;

/**
 *
 * @Since 2010-2016
 * @Description: 
 * @author ***
 * @date 2016-07-12 11:21:31
 *
 */
public class SysOrgResourceForbidden {
	
	//alias
	public static final String TABLE_ALIAS = "SysOrgResourceForbidden";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields orgId:用户id
	 */
	private String orgId;
	
	/**
	 * @Fields resourceId:资源id
	 */
	private Integer resourceId;
	
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

	public SysOrgResourceForbidden(){
	}

	public SysOrgResourceForbidden(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	
	public String getOrgId(){
		return orgId;
	}
	
	public void setResourceId(Integer resourceId){
		this.resourceId = resourceId;
	}
	
	public Integer getResourceId(){
		return resourceId;
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