package com.hsnn.medstgmini.base.sys.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-19 10:49:36
 *
 */
public class SysDepartmentForm  {

	//columns START
	
	/**
	 * @Fields department_id:部门编号
	 */
	private Integer departmentId;
	
	/**
	 * @Fields org_id:机构编号
	 */
	private String orgId;
	
	/**
	 * @Fields org_name:orgName
	 */
	private String orgName;
	
	/**
	 * @Fields bur_spel_code:burSpelCode
	 */
	@Length(max = 128, message = "burSpelCode的长度不能超过{1}")
	private String burSpelCode;
	
	/**
	 * @Fields area_id:所属地区
	 */
	@Length(max = 36, message = "所属地区的长度不能超过{1}")
	private String areaId;
	
	@Length(max = 128, message = "areaName的长度不能超过{1}")
	private String areaName;
	
	/**
	 * @Fields area_shortname:areaShortname
	 */
	@Length(max = 50, message = "areaShortname的长度不能超过{1}")
	private String areaShortname;
	
	/**
	 * @Fields department_type:部门类型：1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
	 */
	@NotNull(message = "请填写部门类型：1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构")
	@Range(message = "数值范围不正确")
	private Integer departmentType;
	
	/**
	 * @Fields group_name:部门名称
	 */
	@NotEmpty(message = "请填写部门名称")
	@Length(max = 128, message = "部门名称的长度不能超过{1}")
	private String groupName;
	
	/**
	 * @Fields non_basedrug_distribute_area_id:非基药配送区域,适用于药品采购
	 */
	@Range(message = "数值范围不正确")
	private Integer nonBasedrugDistributeAreaId;
	
	/**
	 * @Fields basedrug_distribute_area_id:基药配送区域,适用于药品
	 */
	@Range(message = "数值范围不正确")
	private Integer basedrugDistributeAreaId;
	
	/**
	 * @Fields supplies_distribute_area_id:耗材配送区域,适用于耗材
	 */
	@Range(message = "数值范围不正确")
	private Integer suppliesDistributeAreaId;
	
	/**
	 * @Fields drug_purchase_property:采购属性(0:县及县以上,1:基层)，适用于药品采购
	 */
	@Range(message = "数值范围不正确")
	private Integer drugPurchaseProperty;
	
	/**
	 * @Fields department_leader:部门负责人
	 */
	@Length(max = 255, message = "部门负责人的长度不能超过{1}")
	private String departmentLeader;
	
	/**
	 * @Fields department_tel:部门联系方式
	 */
	@Length(max = 36, message = "部门联系方式的长度不能超过{1}")
	private String departmentTel;
	
	/**
	 * @Fields is_using:状态：0.停用，1启用
	 */
	@NotNull(message = "请填写状态：0.停用，1.启用")
	@Range(message = "数值范围不正确")
	private Integer isUsing;
	
	/**
	 * @Fields sort:排序
	 */
	@NotNull(message = "请填写排序")
	@Range(message = "数值范围不正确")
	private Integer sort;
	
	/**
	 * @Fields remark:排序
	 */
	@NotEmpty(message = "请填写描述")
	@Length(max = 5000, message = "描述的长度不能超过{1}")
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
	
	/**
	 * @Fields last_update_user_id:最后一次更新记录人id
	 */
	@Length(max = 36, message = "最后一次更新记录人id的长度不能超过{1}")
	private String lastUpdateUserId;
	
	/**
	 * @Fields last_update_user_name:最后一次更新记录人
	 */
	@Length(max = 256, message = "最后一次更新记录人的长度不能超过{1}")
	private String lastUpdateUserName;
	
	/**
	 * @Fields last_update_time:最后一次更新记录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	/**
	 * @Fields isBalance:是否结算账号:0.否,1.是
	 */
	@Range(message = "数值范围不正确")
	private Integer isBalance;
	//columns END
	

	public SysDepartmentForm(){
	}

	public SysDepartmentForm(Integer departmentId){
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

	public Integer getIsBalance() {
		return isBalance;
	}

	public void setIsBalance(Integer isBalance) {
		this.isBalance = isBalance;
	}
	
	
}