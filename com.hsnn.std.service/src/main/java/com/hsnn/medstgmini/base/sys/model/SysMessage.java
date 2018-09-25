package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-03-04 14:32:12
 *
 */
public class SysMessage  {
	
	//alias
	public static final String TABLE_ALIAS = "SysMessage";
	
	//columns START
	/**
	 * @Fields messageId:消息ID
	 */
	private String messageId;
	
	/**
	 * @Fields fatherId:父级消息id
	 */
	private String fatherId;
	
	/**
	 * @Fields acctType:账户类型1:中心、2:生产企业、3:配送企业、4:医疗机构、5:专家、6:卫生局
	 */
	private Integer acctType;
	
	/**
	 * @Fields orgId:所属机构ID
	 */
	private String orgId;
	
	/**
	 * @Fields orgName:所属机构名称
	 */
	private String orgName;
	
	/**
	 * @Fields groupId:消息组号
	 */
	private String groupId;
	
	/**
	 * @Fields sendUser:发送人
	 */
	private String sendUser;
	
	/**
	 * @Fields title:消息标题
	 */
	private String title;
	
	/**
	 * @Fields content:消息内容
	 */
	private String content;
	
	/**
	 * @Fields type:消息类型1.系统2.用户
	 */
	private Integer type;
	
	/**
	 * @Fields status:状态0新建1.发送2删除3彻底删除
	 */
	private Integer status;
	
	/**
	 * @Fields deliveryTime:定时发送时间
	 */
	private Date deliveryTime;
	
	/**
	 * @Fields sendDatetime:发送时间
	 */
	private Date sendDatetime;
	
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

	public SysMessage(){
	}

	public SysMessage(String messageId){
		this.messageId = messageId;
	}

	
	public void setMessageId(String messageId){
		this.messageId = messageId;
	}
	
	public String getMessageId(){
		return messageId;
	}
	
	public void setFatherId(String fatherId){
		this.fatherId = fatherId;
	}
	
	public String getFatherId(){
		return fatherId;
	}
	
	public void setAcctType(Integer acctType){
		this.acctType = acctType;
	}
	
	public Integer getAcctType(){
		return acctType;
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
	
	public void setGroupId(String groupId){
		this.groupId = groupId;
	}
	
	public String getGroupId(){
		return groupId;
	}
	
	public void setSendUser(String sendUser){
		this.sendUser = sendUser;
	}
	
	public String getSendUser(){
		return sendUser;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public Integer getType(){
		return type;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setDeliveryTime(Date deliveryTime){
		this.deliveryTime = deliveryTime;
	}
	
	public Date getDeliveryTime(){
		return deliveryTime;
	}
	
	public void setSendDatetime(Date sendDatetime){
		this.sendDatetime = sendDatetime;
	}
	
	public Date getSendDatetime(){
		return sendDatetime;
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