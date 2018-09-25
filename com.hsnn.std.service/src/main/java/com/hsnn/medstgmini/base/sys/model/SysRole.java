package com.hsnn.medstgmini.base.sys.model;

import java.io.Serializable;
import java.util.Date;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-19 10:49:37
 *
 */
public class SysRole implements Serializable {
	
	//alias
	public static final String TABLE_ALIAS = "SysRole";
	
	//columns START
	/**
	 * @Fields roleId:角色id
	 */
	private Integer roleId;
	
	/**
	 * @Fields roleName:角色名称
	 */
	private String roleName;
	
	/**
	 * @Fields roleType:角色类型：0:自建、1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
	 */
	private Integer roleType;
	
	/**
	 * @Fields belongOrg:所属机构id
	 */
	private String belongOrg;
	
	/**
	 * @Fields belongDepartmentId:所属部门id
	 */
	private Integer belongDepartmentId;
	
	/**
	 * @Fields isUsing:是否启用
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
	
	/**
	 * @Fields belongPostId:岗位id
	 */
	private Integer belongPostId;
	
	//columns END

	public SysRole(){
	}

	public SysRole(Integer roleId){
		this.roleId = roleId;
	}

	
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	
	public Integer getRoleId(){
		return roleId;
	}
	
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public String getRoleName(){
		return roleName;
	}
	
	public void setRoleType(Integer roleType){
		this.roleType = roleType;
	}
	
	public Integer getRoleType(){
		return roleType;
	}
	
	public void setBelongOrg(String belongOrg){
		this.belongOrg = belongOrg;
	}
	
	public String getBelongOrg(){
		return belongOrg;
	}
	
	public void setBelongDepartmentId(Integer belongDepartmentId){
		this.belongDepartmentId = belongDepartmentId;
	}
	
	public Integer getBelongDepartmentId(){
		return belongDepartmentId;
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

	public Integer getBelongPostId() {
		return belongPostId;
	}

	public void setBelongPostId(Integer belongPostId) {
		this.belongPostId = belongPostId;
	}
	
	
	


}