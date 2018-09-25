package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-08-10 15:27:45
 *
 */
public class StdOaDispatch  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "StdOaDispatch";
	
	//columns START
	/**
	 * @Fields id:发文ID(UUID)
	 */
	private String id;
	
	/**
	 * @Fields dispatchType:发文类型：1命令（令）、2议案、3决定、4指示、5公告、6通告、7通知、8通报、9报告
	 */
	private Integer dispatchType;
	
	/**
	 * @Fields secretLevel:秘密等级：1绝密、2机密、3秘密
	 */
	private Integer secretLevel;
	
	/**
	 * @Fields urgencyLevel:紧急程度：1特急、2急件、3平件
	 */
	private Integer urgencyLevel;
	
	/**
	 * @Fields dispatchTemplate:发文模版：1通知、2公告
	 */
	private Integer dispatchTemplate;
	
	/**
	 * @Fields content:发文内容
	 */
	private String content;
	
	/**
	 * @Fields auditRemark:审核备注
	 */
	private String auditRemark;
	
	/**
	 * @Fields dispatchStatus:发文状态：0未提交、1科长审核、2综合科审、3副主任审、4主任审核、5拟稿人发、6文书发文
	 */
	private Integer dispatchStatus;
	
	/**
	 * @Fields dispatchOffice:发文机关
	 */
	private String dispatchOffice;
	
	/**
	 * @Fields title:标题
	 */
	private String title;
	
	/**
	 * @Fields zsOffice:主送机关
	 */
	private String zsOffice;
	
	/**
	 * @Fields csOffice:抄送机关
	 */
	private String csOffice;
	
	/**
	 * @Fields dispatchNumber:份数
	 */
	private Integer dispatchNumber;
	
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
	
	//columns END

	public StdOaDispatch(){
	}

	public StdOaDispatch(String id){
		this.id = id;
	}

	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setDispatchType(Integer dispatchType){
		this.dispatchType = dispatchType;
	}
	
	public Integer getDispatchType(){
		return dispatchType;
	}
	
	public void setSecretLevel(Integer secretLevel){
		this.secretLevel = secretLevel;
	}
	
	public Integer getSecretLevel(){
		return secretLevel;
	}
	
	public void setUrgencyLevel(Integer urgencyLevel){
		this.urgencyLevel = urgencyLevel;
	}
	
	public Integer getUrgencyLevel(){
		return urgencyLevel;
	}
	
	public void setDispatchTemplate(Integer dispatchTemplate){
		this.dispatchTemplate = dispatchTemplate;
	}
	
	public Integer getDispatchTemplate(){
		return dispatchTemplate;
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
	
	public void setDispatchStatus(Integer dispatchStatus){
		this.dispatchStatus = dispatchStatus;
	}
	
	public Integer getDispatchStatus(){
		return dispatchStatus;
	}
	
	public void setDispatchOffice(String dispatchOffice){
		this.dispatchOffice = dispatchOffice;
	}
	
	public String getDispatchOffice(){
		return dispatchOffice;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setZsOffice(String zsOffice){
		this.zsOffice = zsOffice;
	}
	
	public String getZsOffice(){
		return zsOffice;
	}
	
	public void setCsOffice(String csOffice){
		this.csOffice = csOffice;
	}
	
	public String getCsOffice(){
		return csOffice;
	}
	
	public void setDispatchNumber(Integer dispatchNumber){
		this.dispatchNumber = dispatchNumber;
	}
	
	public Integer getDispatchNumber(){
		return dispatchNumber;
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


}