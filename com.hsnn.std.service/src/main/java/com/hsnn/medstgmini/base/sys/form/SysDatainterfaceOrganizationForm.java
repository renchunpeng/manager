package com.hsnn.medstgmini.base.sys.form;

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
 * @date 2016-05-04 17:43:27
 *
 */
public class SysDatainterfaceOrganizationForm  {

	//columns START
	
	/**
	 * @Fields id:id
	 */
	@NotNull(message = "请填写id")
	@Range(message = "数值范围不正确")
	private Integer id;
	
	/**
	 * @Fields org_id:org_id
	 */
	@Length(max = 36, message = "org_id的长度不能超过{1}")
	private String orgId;
	
	/**
	 * @Fields org_user_name:机构用户名
	 */
	@Length(max = 255, message = "机构用户名的长度不能超过{1}")
	private String orgUserName;
	
	/**
	 * @Fields department_user_name:部门用户名
	 */
	@Length(max = 255, message = "部门用户名的长度不能超过{1}")
	private String departmentUserName;
	
	/**
	 * @Fields org_type:机构类型
	 */
	@Range(message = "数值范围不正确")
	private Integer orgType;
	
	/**
	 * @Fields department_id:部门编号
	 */
	@Range(message = "数值范围不正确")
	private Integer departmentId;
	
	/**
	 * @Fields public_key:公钥
	 */
	@Length(max = 2048, message = "公钥的长度不能超过{1}")
	private String publicKey;
	
	/**
	 * @Fields private_key:私钥
	 */
	@Length(max = 2048, message = "私钥的长度不能超过{1}")
	private String privateKey;
	
	/**
	 * @Fields ipv4:ipv4
	 */
	@Length(max = 15, message = "ipv4的长度不能超过{1}")
	private String ipv4;
	
	/**
	 * @Fields access_token:访问令牌
	 */
	@Length(max = 36, message = "访问令牌的长度不能超过{1}")
	private String accessToken;
	
	/**
	 * @Fields expire_time:令牌失效时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expireTime;
	
	/**
	 * @Fields is_using:是否有效(0:无效,1:有效)
	 */
	@Range(message = "数值范围不正确")
	private Integer isUsing;
	
	/**
	 * @Fields last_access_time:最后访问时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastAccessTime;
	
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
	//columns END
	
	
	private String interfaceIds;

	public SysDatainterfaceOrganizationForm(){
	}

	public SysDatainterfaceOrganizationForm(Integer id){
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
	
	public void setOrgUserName(String orgUserName){
		this.orgUserName = orgUserName;
	}
	public String getOrgUserName(){
		return orgUserName;
	}
	
	public void setDepartmentUserName(String departmentUserName){
		this.departmentUserName = departmentUserName;
	}
	public String getDepartmentUserName(){
		return departmentUserName;
	}
	
	public void setOrgType(Integer orgType){
		this.orgType = orgType;
	}
	public Integer getOrgType(){
		return orgType;
	}
	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
	public Integer getDepartmentId(){
		return departmentId;
	}
	
	public void setPublicKey(String publicKey){
		this.publicKey = publicKey;
	}
	public String getPublicKey(){
		return publicKey;
	}
	
	public void setPrivateKey(String privateKey){
		this.privateKey = privateKey;
	}
	public String getPrivateKey(){
		return privateKey;
	}
	
	public void setIpv4(String ipv4){
		this.ipv4 = ipv4;
	}
	public String getIpv4(){
		return ipv4;
	}
	
	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}
	public String getAccessToken(){
		return accessToken;
	}
	
	public void setExpireTime(Date expireTime){
		this.expireTime = expireTime;
	}
	public Date getExpireTime(){
		return expireTime;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	public Integer getIsUsing(){
		return isUsing;
	}
	
	public void setLastAccessTime(Date lastAccessTime){
		this.lastAccessTime = lastAccessTime;
	}
	public Date getLastAccessTime(){
		return lastAccessTime;
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

	public String getInterfaceIds() {
		return interfaceIds;
	}

	public void setInterfaceIds(String interfaceIds) {
		this.interfaceIds = interfaceIds;
	}
	
}