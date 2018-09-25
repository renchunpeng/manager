package com.hsnn.medstgmini.base.sys.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.KeywordsAnnotation;
import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-19 10:49:36
 *
 */
public class SysDepartment  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "SysDepartment";
	
	//columns START
	/**
	 * @Fields departmentId:部门编号
	 */
	@PropertyNameAnnotation(annotation="部门编号")
	private Integer departmentId;
	
	/**
	 * @Fields orgId:机构编号
	 */
	@PropertyNameAnnotation(annotation="机构编号")
	private String orgId;
	
	/**
	 * @Fields orgName:orgName
	 */
	@PropertyNameAnnotation(annotation="企业名称")
	private String orgName;
	
	/**
	 * @Fields burSpelCode:burSpelCode
	 */
	@PropertyNameAnnotation(annotation="企业名称拼音码")
	private String burSpelCode;
	
	/**
	 * @Fields areaId:所属地区
	 */
	@PropertyNameAnnotation(annotation="所属地区")
	private String areaId;
	
	/**
	 * @Fields areaId:地区名称
	 */
	@PropertyNameAnnotation(annotation="地区名称")
	private String areaName;
	
	private String orgAreaName;
	
	/**
	 * @Fields areaId:地区简称
	 */
	@PropertyNameAnnotation(annotation="地区简称")
	private String areaShortname;
	
	/**
	 * @Fields departmentType:部门类型：1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
	 */
	@PropertyNameAnnotation(annotation="部门类型(1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构)")
	private Integer departmentType;
	
	/**
	 * @Fields groupName:部门名称
	 */
	@KeywordsAnnotation(annotation="部门名称")
	@PropertyNameAnnotation(annotation="部门名称")
	private String groupName;
	
	/**
	 * @Fields nonBasedrugDistributeAreaId:非基药配送区域,适用于药品采购
	 */
	@PropertyNameAnnotation(annotation="非基药配送区域名称")
	private String nonBasedrugDistributeAreaName;
	
	/**
	 * @Fields nonBasedrugDistributeAreaId:非基药配送区域,适用于药品采购
	 */
	@PropertyNameAnnotation(annotation="非基药配送区域")
	private Integer nonBasedrugDistributeAreaId;
	
	/**
	 * @Fields basedrugDistributeAreaId:基药配送区域,适用于药品
	 */
	@PropertyNameAnnotation(annotation="基药配送区域名称")
	private String basedrugDistributeAreaName;
	
	/**
	 * @Fields basedrugDistributeAreaId:基药配送区域,适用于药品
	 */
	@PropertyNameAnnotation(annotation="基药配送区域")
	private Integer basedrugDistributeAreaId;
	
	/**
	 * @Fields suppliesDistributeAreaId:耗材配送区域,适用于耗材名称
	 */
	@PropertyNameAnnotation(annotation="耗材配送区域名称")
	private String suppliesDistributeAreaName;
	
	/**
	 * @Fields suppliesDistributeAreaId:耗材配送区域,适用于耗材
	 */
	@PropertyNameAnnotation(annotation="耗材配送区域")
	private Integer suppliesDistributeAreaId;
	
	/**
	 * @Fields drugPurchaseProperty:采购属性(0:县及县以上,1:基层)，适用于药品采购
	 */
	@PropertyNameAnnotation(annotation="采购属性(0:县及县以上,1:基层)")
	private Integer drugPurchaseProperty;
	
	/**
	 * @Fields departmentLeader:部门负责人
	 */
	@PropertyNameAnnotation(annotation="部门负责人")
	private String departmentLeader;
	
	/**
	 * @Fields departmentTel:部门联系方式
	 */
	@PropertyNameAnnotation(annotation="部门联系方式")
	private String departmentTel;
	
	/**
	 * @Fields isUsing:状态：0.停用，1.启用
	 */
	@PropertyNameAnnotation(annotation="状态(0.停用，1.启用)")
	private Integer isUsing;
	
	/**
	 * @Fields sort:排序
	 */
	@PropertyNameAnnotation(annotation="排序")
	private Integer sort;
	
	/**
	 * @Fields remark:备注
	 */
	@PropertyNameAnnotation(annotation="备注")
	private String remark;
	
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
	
	//columns END
     
	
	/**
	 * 部门管理员用户账户
	 */
	private String userName; 
	
	
	/**
	 * @Fields hospitalId:医疗机构id
	 */
	private String hospitalId;
	/**
	 * @Fields hospitalName:医疗机构名称
	 */
	private String hospitalName;
	/**
	 * @Fields hospitalAddress:医疗机构地址
	 */
	private String hospitalAddress;
	
	/**
	 * @Fields hospitalLevel:医疗机构等级(三级甲等...)
	 */
	private String hospitalLevel;
	
	private String contactPerson;
	
	private String contactTel;
	
	private String healthOrganizationCode;
	
	private String healthOrgSort;
	
	private Integer isHospUsing;
	
	private String director;
	private String directorId;
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}


	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getTableAlias() {
		return TABLE_ALIAS;
	}

	public SysDepartment(){
	}

	public SysDepartment(Integer departmentId){
		this.departmentId = departmentId;
	}

	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
	
	public Integer getDepartmentId(){
		return departmentId;
	}
	
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	
	public String getOrgId(){
		return orgId;
	}
	
	public void setOrgName(String orgName){
		this.orgName = orgName;
	}
	
	public String getOrgName(){
		return orgName;
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
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaShortname() {
		return areaShortname;
	}

	public void setAreaShortname(String areaShortname) {
		this.areaShortname = areaShortname;
	}
	
	public void setDepartmentType(Integer departmentType){
		this.departmentType = departmentType;
	}
	
	public Integer getDepartmentType(){
		return departmentType;
	}
	
	public void setGroupName(String groupName){
		this.groupName = groupName;
	}
	
	public String getGroupName(){
		return groupName;
	}
	
	public void setNonBasedrugDistributeAreaId(Integer nonBasedrugDistributeAreaId){
		this.nonBasedrugDistributeAreaId = nonBasedrugDistributeAreaId;
	}
	
	public Integer getNonBasedrugDistributeAreaId(){
		return nonBasedrugDistributeAreaId;
	}
	
	public void setBasedrugDistributeAreaId(Integer basedrugDistributeAreaId){
		this.basedrugDistributeAreaId = basedrugDistributeAreaId;
	}
	
	public Integer getBasedrugDistributeAreaId(){
		return basedrugDistributeAreaId;
	}
	
	public void setSuppliesDistributeAreaId(Integer suppliesDistributeAreaId){
		this.suppliesDistributeAreaId = suppliesDistributeAreaId;
	}
	
	public Integer getSuppliesDistributeAreaId(){
		return suppliesDistributeAreaId;
	}
	
	public void setDrugPurchaseProperty(Integer drugPurchaseProperty){
		this.drugPurchaseProperty = drugPurchaseProperty;
	}
	
	public Integer getDrugPurchaseProperty(){
		return drugPurchaseProperty;
	}
	
	public void setDepartmentLeader(String departmentLeader){
		this.departmentLeader = departmentLeader;
	}
	
	public String getDepartmentLeader(){
		return departmentLeader;
	}
	
	public void setDepartmentTel(String departmentTel){
		this.departmentTel = departmentTel;
	}
	
	public String getDepartmentTel(){
		return departmentTel;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
		return isUsing;
	}
	
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	public Integer getSort(){
		return sort;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNonBasedrugDistributeAreaName() {
		return nonBasedrugDistributeAreaName;
	}

	public void setNonBasedrugDistributeAreaName(
			String nonBasedrugDistributeAreaName) {
		this.nonBasedrugDistributeAreaName = nonBasedrugDistributeAreaName;
	}

	public String getBasedrugDistributeAreaName() {
		return basedrugDistributeAreaName;
	}

	public void setBasedrugDistributeAreaName(String basedrugDistributeAreaName) {
		this.basedrugDistributeAreaName = basedrugDistributeAreaName;
	}

	public String getSuppliesDistributeAreaName() {
		return suppliesDistributeAreaName;
	}

	public void setSuppliesDistributeAreaName(String suppliesDistributeAreaName) {
		this.suppliesDistributeAreaName = suppliesDistributeAreaName;
	}

	public String getOrgAreaName() {
		return orgAreaName;
	}

	public void setOrgAreaName(String orgAreaName) {
		this.orgAreaName = orgAreaName;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalLevel() {
		return hospitalLevel;
	}

	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getHealthOrganizationCode() {
		return healthOrganizationCode;
	}

	public void setHealthOrganizationCode(String healthOrganizationCode) {
		this.healthOrganizationCode = healthOrganizationCode;
	}

	public String getHealthOrgSort() {
		return healthOrgSort;
	}

	public void setHealthOrgSort(String healthOrgSort) {
		this.healthOrgSort = healthOrgSort;
	}

	public Integer getIsHospUsing() {
		return isHospUsing;
	}

	public void setIsHospUsing(Integer isHospUsing) {
		this.isHospUsing = isHospUsing;
	}
	
	

}