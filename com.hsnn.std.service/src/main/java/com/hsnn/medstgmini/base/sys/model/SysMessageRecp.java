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
public class SysMessageRecp  {
	
	//alias
	public static final String TABLE_ALIAS = "SysMessageRecp";
	
	//columns START
	/**
	 * @Fields messageId:messageId
	 */
	private String messageId;
	
	/**
	 * @Fields receUser:接收人
	 */
	private String receUser;
	
	/**
	 * @Fields userName:用户名
	 */
	private String userName;
	
	/**
	 * @Fields recOrgId:接收人机构ID
	 */
	private String recOrgId;
	
	/**
	 * @Fields recOrgName:接收人机构名称
	 */
	private String recOrgName;
	
	/**
	 * @Fields status:状态1.删除2彻底删除
	 */
	private Integer status;
	
	/**
	 * @Fields readDatetime:阅读时间
	 */
	private Date readDatetime;
	
	/**
	 * @Fields hasRead:是否已阅读0否1是
	 */
	private Integer hasRead;
	
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
	
	private SysMessage message;
	//columns END

	public SysMessageRecp(){
	}

	public SysMessageRecp(String messageId,String receUser){
		this.messageId = messageId;
		this.receUser = receUser;
	}

	
	public void setMessageId(String messageId){
		this.messageId = messageId;
	}
	
	public String getMessageId(){
		return messageId;
	}
	
	public void setReceUser(String receUser){
		this.receUser = receUser;
	}
	
	public String getReceUser(){
		return receUser;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setRecOrgId(String recOrgId){
		this.recOrgId = recOrgId;
	}
	
	public String getRecOrgId(){
		return recOrgId;
	}
	
	public void setRecOrgName(String recOrgName){
		this.recOrgName = recOrgName;
	}
	
	public String getRecOrgName(){
		return recOrgName;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setReadDatetime(Date readDatetime){
		this.readDatetime = readDatetime;
	}
	
	public Date getReadDatetime(){
		return readDatetime;
	}
	
	public void setHasRead(Integer hasRead){
		this.hasRead = hasRead;
	}
	
	public Integer getHasRead(){
		return hasRead;
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

	public SysMessage getMessage() {
		return message;
	}

	public void setMessage(SysMessage message) {
		this.message = message;
	}
	

}