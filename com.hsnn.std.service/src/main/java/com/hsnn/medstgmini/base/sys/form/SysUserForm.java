package com.hsnn.medstgmini.base.sys.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-22 17:41:06
 *
 */
public class SysUserForm  {

	//columns START
	
	/**
	 * @Fields user_id:用户id
	 */
	
	private String userId;
	
	/**
	 * @Fields org_id:机构id
	 */
	
	private String orgId;
	
	/**
	 * @Fields role_id:角色ID
	 */
	
	private Integer roleId;
	
	/**
	 * @Fields department_id:部门id
	 */
	@NotNull(message="请选择部门名称")
	private Integer departmentId;
	
	/**
	 * @Fields post_id:岗位id
	 */
	@NotNull(message="请选择岗位名称")
	private Integer postId;
	
	/**
	 * @Fields user_name:用户名
	 */
	private String userName;
	
	/**
	 * @Fields acct_type:账户类型 0 管理账户  1业务账户
	 */
	private Integer acctType;
	
	/**
	 * @Fields user_password:密码
	 */
	private String userPassword;
	
	/**
	 * @Fields password_hint:密码提示
	 */
	private String passwordHint;
	
	/**
	 * @Fields acct_expired:账户过期
	 */
	private Date acctExpired;
	
	/**
	 * @Fields password_expired:密码过期
	 */
	private Date passwordExpired;
	
	/**
	 * @Fields is_using:是否启用
	 */
	private Integer isUsing;
	
	/**
	 * @Fields userType:用户类型：0:自建、1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
	 */
	private Integer userType;
	
	/**
	 * @Fields email:邮箱
	 */
	@NotEmpty(message="请填写邮箱")
	@Pattern(message="邮箱格式不正确",regexp="^(\\w)+([._\\-]*\\w)*@(\\w)+([.]*\\w)*$")
	@Length(max = 50, message = "邮箱的长度不能超过{1}")
	private String email;
	
	/**
	 * @Fields name:姓名
	 */
	@NotEmpty(message="请填写用户名称")
	@Length(max = 100, message = "姓名的长度不能超过{1}")
	private String name;
	
	/**
	 * @Fields phone:联系电话
	 */
	@NotEmpty(message="请填写联系方式")
	@Pattern(message="联系方式应该为手机号或座机号",regexp="^(\\d{3,4}-\\d{7,8}|\\d{11})$")
	private String phone;
	
	/**
	 * @Fields locked:锁定帐号(0：未锁，1：锁定)
	 */
	@Range(message = "数值范围不正确")
	private Integer locked;
	
	/**
	 * @Fields last_login_time:最后登录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;
	
	/**
	 * @Fields login_ip:最后登入ip
	 */
	@Length(max = 20, message = "最后登入ip的长度不能超过{1}")
	private String loginIp;
	
	/**
	 * @Fields reset_token:用户重置密码key
	 */
	@Length(max = 512, message = "用户重置密码key的长度不能超过{1}")
	private String resetToken;
	
	/**
	 * @Fields reset_time:重置密码时间
	 */
	@Length(max = 36, message = "重置密码时间的长度不能超过{1}")
	private String resetTime;
	
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
	

	public SysUserForm(){
	}

	public SysUserForm(String userId){
		this.userId = userId;
	}

	
	public void setUserId(String userId){
		this.userId = userId;
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
	
	public void setAcctExpired(Date acctExpired){
		this.acctExpired = acctExpired;
	}
	public Date getAcctExpired(){
		return acctExpired;
	}
	
	public void setPasswordExpired(Date passwordExpired){
		this.passwordExpired = passwordExpired;
	}
	public Date getPasswordExpired(){
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
	
	public void setResetToken(String resetToken){
		this.resetToken = resetToken;
	}
	public String getResetToken(){
		return resetToken;
	}
	
	public void setResetTime(String resetTime){
		this.resetTime = resetTime;
	}
	public String getResetTime(){
		return resetTime;
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
	
}