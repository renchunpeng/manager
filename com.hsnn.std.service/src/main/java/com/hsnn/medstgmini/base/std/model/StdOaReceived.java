package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-08-10 14:17:16
 *
 */
public class StdOaReceived implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "StdOaReceived";
	
	//columns START
	/**
	 * @Fields id:来文ID(UUID)
	 */
	private String id;
	
	/**
	 * @Fields receivedType:收文类型：命令（令）、议案、决定、指示、公告、通告、通知、通报、报告、请示、批复、函、会议纪要
	 */
	private Integer receivedType;
	
	/**
	 * @Fields secretLevel:秘密等级：绝密、机密、秘密
	 */
	private Integer secretLevel;
	
	/**
	 * @Fields urgencyLevel:紧急程度：特急、急件、平件
	 */
	private Integer urgencyLevel;
	
	/**
	 * @Fields receivedNumber:收文编号
	 */
	private String receivedNumber;
	
	/**
	 * @Fields receivedDate:收文日期
	 */
	private Date receivedDate;
	
	/**
	 * @Fields content:收文内容
	 */
	private String content;
	
	/**
	 * @Fields auditRemark:审核备注
	 */
	private String auditRemark;
	
	/**
	 * @Fields receivedStatus:收文状态：0未提交、1综合科审、2副主任审、3主任审、4收文、5已收文
	 */
	private Integer receivedStatus;
	
	/**
	 * @Fields addUserId:登记人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:登记人
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:添加时间
	 */
	private Date addTime;
	
	/**
	 * @Fields comCompany:来文单位
	 */
	private String comCompany;
	
	/**
	 * @Fields comTitle:来文标题
	 */
	private String comTitle;
	
	/**
	 * @Fields comNumber:来文编号
	 */
	private String comNumber;
	
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
	 * @Fields departmentId:登记部门id
	 */
	private String departmentId;
	
	/**
	 * @Fields departmentName:登记部门
	 */
	private String departmentName;
	
	
	
	
	//columns END

	public StdOaReceived(){
	}

	public StdOaReceived(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getReceivedType() {
		return receivedType;
	}

	public void setReceivedType(Integer receivedType) {
		this.receivedType = receivedType;
	}

	public Integer getSecretLevel() {
		return secretLevel;
	}

	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}

	public Integer getUrgencyLevel() {
		return urgencyLevel;
	}

	public void setUrgencyLevel(Integer urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}

	public void setReceivedStatus(Integer receivedStatus) {
		this.receivedStatus = receivedStatus;
	}

	public void setReceivedNumber(String receivedNumber){
		this.receivedNumber = receivedNumber;
	}
	
	public String getReceivedNumber(){
		return receivedNumber;
	}
	
	public void setReceivedDate(Date receivedDate){
		this.receivedDate = receivedDate;
	}
	
	public Date getReceivedDate(){
		return receivedDate;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setAuditRemark(String auditRemark){
		this.auditRemark = auditRemark;
	}
	
	public String getAuditRemark(){
		return auditRemark;
	}
	
	
	
	public Integer getReceivedStatus() {
		return receivedStatus;
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
	
	public void setComCompany(String comCompany){
		this.comCompany = comCompany;
	}
	
	public String getComCompany(){
		return comCompany;
	}
	
	public void setComTitle(String comTitle){
		this.comTitle = comTitle;
	}
	
	public String getComTitle(){
		return comTitle;
	}
	
	public void setComNumber(String comNumber){
		this.comNumber = comNumber;
	}
	
	public String getComNumber(){
		return comNumber;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


}