package com.hsnn.medstgmini.base.sys.model;

import com.hsnn.medstgmini.base.std.model.StdCompanys;
import com.hsnn.medstgmini.base.std.model.StdHospitals;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-22 17:41:06
 *
 */
public class SysUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "SysUser";
	
	//columns START
	/**
	 * @Fields userId:用户id
	 */
	private String userId;
	
	/**
	 * @Fields orgId:机构id
	 */
	private String orgId;
	
	/**
	 * @Fields roleId:角色ID
	 */
	private Integer roleId;
	
	/**
	 * @Fields departmentId:部门id
	 */
	private Integer departmentId;
	
	/**
	 * @Fields postId:岗位id
	 */
	private Integer postId;
	
	/**
	 * @Fields userName:用户名
	 */
	@PropertyNameAnnotation(annotation="用户名 ")
	private String userName;
	
	/**
	 * @Fields acctType:账户类型 0 管理账户  1业务账户
	 */
	@PropertyNameAnnotation(annotation="账户类型 ")
	private Integer acctType;
	
	/**
	 * @Fields userPassword:密码
	 */
	@PropertyNameAnnotation(annotation="密码")
	private String userPassword;
	
	/**
	 * @Fields passwordHint:密码提示
	 */
	@PropertyNameAnnotation(annotation="密码提示")
	private String passwordHint;
	
	/**
	 * @Fields acctExpired:账户过期
	 */
	@PropertyNameAnnotation(annotation="账户过期")
	private String acctExpired;
	
	/**
	 * @Fields passwordExpired:密码过期
	 */
	@PropertyNameAnnotation(annotation="密码过期")
	private String passwordExpired;
	
	/**
	 * @Fields isUsing:是否启用
	 */
	@PropertyNameAnnotation(annotation="是否启用")
	private Integer isUsing;
	
	/**
	 * @Fields userType:用户类型：0:自建、1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
	 */
	private Integer userType;
	
	/**
	 * @Fields email:邮箱
	 */
	@PropertyNameAnnotation(annotation="邮箱")
	private String email;
	
	/**
	 * @Fields name:姓名
	 */
	@PropertyNameAnnotation(annotation="姓名")
	private String name;
	
	/**
	 * @Fields phone:联系电话
	 */
	@PropertyNameAnnotation(annotation="联系电话")
	private String phone;
	
	/**
	 * @Fields locked:锁定帐号(0：未锁，1：锁定)
	 */
	@PropertyNameAnnotation(annotation="锁定帐号")
	private Integer locked;
	
	/**
	 * @Fields lastLoginTime:最后登录时间
	 */
	@PropertyNameAnnotation(annotation="最后登录时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;
	
	/**
	 * @Fields loginIp:最后登入ip
	 */
	@PropertyNameAnnotation(annotation="最后登入ip")
	private String loginIp;
	
	/**
	 * @Fields resetToken:用户重置密码key
	 */
	
	private String resetToken;
	
	/**
	 * @Fields resetTime:重置密码时间
	 */
	private String resetTime;

	private String CAKey;
	
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
	@PropertyNameAnnotation(annotation="记录添加时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	private String lastUpdateUserName;
	
	// 医疗机构、生产企业、配送企业信息	
	private StdManageOrg stdManageOrg;//监管机构
	private StdCompanys stdCompany;//企业
	private StdHospitals stdHospital;//医疗机构
	private Integer isCaUsing;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	private SysRole sysRole;

	private List<SysResource> resourceList;
	
	private SysDepartment sysDepartment;
	
	//父级名称
	private String fatherName;
	
	//岗位信息
	private SysPost sysPost;
	private Object info;
	/**
	 * @Fields isBalance:是否结算账号:0.否,1.是
	 */
	@PropertyNameAnnotation(annotation="是否结算账号")
	private Integer isBalance;
	
	//columns END
	private Integer isFirstLogin;

	public Integer getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin(Integer isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public SysUser(){
	}

	public SysUser(String userId){
		this.userId = userId;
	}

	
	public void setUserId(String userId){
		this.userId = userId;
	}

    public String getCAKey() {
        return CAKey;
    }

    public void setCAKey(String CAKey) {
        this.CAKey = CAKey;
    }

    public String getUserId(){
		return userId;
	}
	
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	
	public Integer getRoleId(){
		return roleId;
	}
	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
	
	public Integer getDepartmentId(){
		return departmentId;
	}
	
	public void setPostId(Integer postId){
		this.postId = postId;
	}
	
	public Integer getPostId(){
		return postId;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setAcctType(Integer acctType){
		this.acctType = acctType;
	}
	
	public Integer getAcctType(){
		return acctType;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	
	public String getUserPassword(){
		return userPassword;
	}
	
	public void setPasswordHint(String passwordHint){
		this.passwordHint = passwordHint;
	}
	
	public String getPasswordHint(){
		return passwordHint;
	}
	
	public void setAcctExpired(String acctExpired){
		this.acctExpired = acctExpired;
	}
	
	public String getAcctExpired(){
		return acctExpired;
	}
	
	public void setPasswordExpired(String passwordExpired){
		this.passwordExpired = passwordExpired;
	}
	
	public String getPasswordExpired(){
		return passwordExpired;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
		return isUsing;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setLocked(Integer locked){
		this.locked = locked;
	}
	
	public Integer getLocked(){
		return locked;
	}
	
	public void setLastLoginTime(Date lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}
	
	public Date getLastLoginTime(){
		return lastLoginTime;
	}
	
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}
	
	public String getLoginIp(){
		return loginIp;
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


	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public String getResetToken() {
		return resetToken;
	}

	public String getResetTime() {
		return resetTime;
	}

	public void setResetTime(String resetTime) {
		this.resetTime = resetTime;
	}

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", roleId=" + roleId +
                ", departmentId=" + departmentId +
                ", postId=" + postId +
                ", userName='" + userName + '\'' +
                ", acctType=" + acctType +
                ", userPassword='" + userPassword + '\'' +
                ", passwordHint='" + passwordHint + '\'' +
                ", acctExpired='" + acctExpired + '\'' +
                ", passwordExpired='" + passwordExpired + '\'' +
                ", isUsing=" + isUsing +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", locked=" + locked +
                ", lastLoginTime=" + lastLoginTime +
                ", loginIp='" + loginIp + '\'' +
                ", resetToken='" + resetToken + '\'' +
                ", resetTime='" + resetTime + '\'' +
                ", CAKey='" + CAKey + '\'' +
                ", addUserId='" + addUserId + '\'' +
                ", addUserName='" + addUserName + '\'' +
                ", addTime=" + addTime +
                ", lastUpdateUserId='" + lastUpdateUserId + '\'' +
                ", lastUpdateUserName='" + lastUpdateUserName + '\'' +
                ", stdManageOrg=" + stdManageOrg +
                ", stdCompany=" + stdCompany +
                ", stdHospital=" + stdHospital +
                ", isCaUsing=" + isCaUsing +
                ", lastUpdateTime=" + lastUpdateTime +
                ", sysRole=" + sysRole +
                ", resourceList=" + resourceList +
                ", sysDepartment=" + sysDepartment +
                ", fatherName='" + fatherName + '\'' +
                ", sysPost=" + sysPost +
                ", info=" + info +
                ", isBalance=" + isBalance +
                ", isFirstLogin=" + isFirstLogin +
                '}';
    }

    public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public List<SysResource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<SysResource> resourceList) {
		this.resourceList = resourceList;
	}

	public SysDepartment getSysDepartment() {
		return sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public SysPost getSysPost() {
		return sysPost;
	}

	public void setSysPost(SysPost sysPost) {
		this.sysPost = sysPost;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getIsBalance() {
		return isBalance;
	}

	public void setIsBalance(Integer isBalance) {
		this.isBalance = isBalance;
	}

	public StdManageOrg getStdManageOrg() {
		return stdManageOrg;
	}

	public void setStdManageOrg(StdManageOrg stdManageOrg) {
		this.stdManageOrg = stdManageOrg;
	}

	public StdCompanys getStdCompany() {
		return stdCompany;
	}

	public void setStdCompany(StdCompanys stdCompany) {
		this.stdCompany = stdCompany;
	}

	public StdHospitals getStdHospital() {
		return stdHospital;
	}

	public void setStdHospital(StdHospitals stdHospital) {
		this.stdHospital = stdHospital;
	}

	public <T> T getInfo() {
		if (info != null) {
			return (T) info;
		}
		return null;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public Integer getIsCaUsing() {
		return isCaUsing;
	}

	public void setIsCaUsing(Integer isCaUsing) {
		this.isCaUsing = isCaUsing;
	}
	

}