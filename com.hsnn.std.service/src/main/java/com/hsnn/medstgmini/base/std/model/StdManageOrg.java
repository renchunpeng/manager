package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;

import com.hsnn.medstgmini.base.sys.model.SysUser;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-25 08:45:16
 *
 */
public class StdManageOrg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private StdArea stdArea;// 所属区域信息
	private StdArea stdAreaXZ;// 行政区域信息
	private SysUser sysUser;
	
	
	
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public StdArea getStdArea() {
		return stdArea;
	}

	public void setStdArea(StdArea stdArea) {
		this.stdArea = stdArea;
	}

	public StdArea getStdAreaXZ() {
		return stdAreaXZ;
	}

	public void setStdAreaXZ(StdArea stdAreaXZ) {
		this.stdAreaXZ = stdAreaXZ;
	}

	//alias
	public static final String TABLE_ALIAS = "StdManageOrg";
	
	//columns START
	/**
	 * @Fields id:group_id
	 */
	private String id;
	
	
	/**
	 * @Fields heaBurName:名称
	 */
	private String heaBurName;
	
	/**
	 * @Fields burSpelCode:burSpelCode
	 */
	private String burSpelCode;
	
	/**
	 * @Fields areaId:所属地区
	 */
	private String areaId;
	
	/**
	 * @Fields areaName:所属地区名称
	 */
	private String areaName;
	
	/**
	 * @Fields heaBurType:heaBurType
	 */
	private Integer heaBurType;
	
	/**
	 * @Fields orgAddress:机构地址
	 */
	private String orgAddress;
	
	/**
	 * @Fields contactor:联系人
	 */
	private String contactor;
	
	/**
	 * @Fields contactorTel:联系电话
	 */
	private String contactorTel;
	
	/**
	 * @Fields cellphone:手机号码
	 */
	private String cellphone;
	
	/**
	 * @Fields email:电子邮箱
	 */
	private String email;
	
	/**
	 * @Fields contactQq:联系人QQ
	 */
	private String contactQq;
	
	/**
	 * @Fields adminAreaId:行政区域
	 */
	private Integer adminAreaId;
	
	/**
	 * @Fields adminAreaName:行政区域名称
	 */
	private String adminAreaName;
	
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

	private Integer InitializationState;

	/**
	 * @Fields 机构类型
	 */
	private Integer superviseType;

	public Integer getSuperviseType() {
		return superviseType;
	}

	public void setSuperviseType(Integer superviseType) {
		this.superviseType = superviseType;
	}

	public Integer getInitializationState() {
		return InitializationState;
	}

	public void setInitializationState(Integer initializationState) {
		InitializationState = initializationState;
	}
	//columns END

	public StdManageOrg(){
	}

	public StdManageOrg(String id){
		this.id = id;
	}

	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setHeaBurName(String heaBurName){
		this.heaBurName = heaBurName;
	}
	
	public String getHeaBurName(){
		return heaBurName;
	}
	
	public void setBurSpelCode(String burSpelCode){
		this.burSpelCode = burSpelCode;
	}
	
	public String getBurSpelCode(){
		return burSpelCode;
	}
	
	public void setAreaId(String areaId){
		this.areaId = areaId;
	}
	
	public String getAreaId(){
		return areaId;
	}
	
	public void setHeaBurType(Integer heaBurType){
		this.heaBurType = heaBurType;
	}
	
	public Integer getHeaBurType(){
		return heaBurType;
	}
	
	public void setOrgAddress(String orgAddress){
		this.orgAddress = orgAddress;
	}
	
	public String getOrgAddress(){
		return orgAddress;
	}
	
	public void setContactor(String contactor){
		this.contactor = contactor;
	}
	
	public String getContactor(){
		return contactor;
	}
	
	public void setContactorTel(String contactorTel){
		this.contactorTel = contactorTel;
	}
	
	public String getContactorTel(){
		return contactorTel;
	}
	
	public void setCellphone(String cellphone){
		this.cellphone = cellphone;
	}
	
	public String getCellphone(){
		return cellphone;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setContactQq(String contactQq){
		this.contactQq = contactQq;
	}
	
	public String getContactQq(){
		return contactQq;
	}
	
	public void setAdminAreaId(Integer adminAreaId){
		this.adminAreaId = adminAreaId;
	}
	
	public Integer getAdminAreaId(){
		return adminAreaId;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAdminAreaName() {
		return adminAreaName;
	}

	public void setAdminAreaName(String adminAreaName) {
		this.adminAreaName = adminAreaName;
	}

	
}