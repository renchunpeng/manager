package com.hsnn.medstgmini.base.sys.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-19 10:49:37
 *
 */
public class SysPost implements Serializable  {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;


	//alias
	public static final String TABLE_ALIAS = "SysPost";
	
	
	//columns START
	/**
	 * @Fields postId:岗位id
	 */
	@PropertyNameAnnotation(annotation="岗位id")
	private Integer postId;
	
	/**
	 * @Fields postName:岗位名称
	 */
	@PropertyNameAnnotation(annotation="岗位名称")
	private String postName;
	
	/**
	 * @Fields departmentId:部门id
	 */
	@PropertyNameAnnotation(annotation="部门id")
	private Integer departmentId;
	
	/**
	 * @Fields isUsing:是否启用
	 */
	@PropertyNameAnnotation(annotation="是否启用")
	private Integer isUsing;
	
	/**
	 * @Fields addUserId:记录添加人id
	 */
	@PropertyNameAnnotation(annotation="记录添加人id")
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
	@PropertyNameAnnotation(annotation="最后一次更新记录人id")
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
	 * @Fields areaId:所属地区
	 */
	private String areaName;
	
	/**
	 * @Fields orgName:orgName
	 */
	private String orgName;
	
	/**
	 * @Fields groupName:部门名称
	 */
	private String groupName;
	
	/**
	 * @Fields departmentType:部门类型：1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
	 */
	private Integer departmentType;
	
	

	/**
	 * @Fields userId:用户id
	 */
	private String userId;
	/**
	 * @Fields userName:用户名
	 */
	private String userName;
	
	/**
	 * @Fields name:姓名
	 */
	private String name;
	
	/**
	 * @Fields phone:联系电话
	 */
	private String phone;
	
	
	
	//columns END

	public SysPost(){
	}

	public SysPost(Integer postId){
		this.postId = postId;
	}

	
	public void setPostId(Integer postId){
		this.postId = postId;
	}
	
	public Integer getPostId(){
		return postId;
	}
	
	public void setPostName(String postName){
		this.postName = postName;
	}
	
	public String getPostName(){
		return postName;
	}
	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
	
	public Integer getDepartmentId(){
		return departmentId;
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
	
	
	
	

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	


	public Integer getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(Integer departmentType) {
		this.departmentType = departmentType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	

}