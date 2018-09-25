package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-08-10 15:27:47
 *
 */
public class StdOaInformationDelivery  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "StdOaInformationDelivery";
	
	//columns START
	/**
	 * @Fields id:发文ID(UUID)
	 */
	private String id;
	
	/**
	 * @Fields informationType:信息类型：1命令（令）、2议案、3决定、4指示、5公告、6通告、7通知、8通报、9报告，多选用逗号分隔
	 */
	private String informationType;
	
	/**
	 * @Fields urgencyLevel:紧急程度：1特急、2急件、3平件
	 */
	private Integer urgencyLevel;
	
	/**
	 * @Fields informationTemplate:信息模版：1通知、2公告
	 */
	private Integer informationTemplate;
	
	/**
	 * @Fields informationDate:信息发布日期
	 */
	private Date informationDate;
	
	/**
	 * @Fields content:内容
	 */
	private String content;
	
	/**
	 * @Fields auditRemark:审核备注
	 */
	private String auditRemark;
	
	/**
	 * @Fields status:信息发布状态：0未提交、1科长审核、2综合科审、3副主任审、4主任审核、5信息整理、6信息发布
	 */
	private Integer status;
	
	/**
	 * @Fields informationOffice:信息发布科室
	 */
	private String informationOffice;
	
	/**
	 * @Fields title:标题
	 */
	private String title;
	
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

	public StdOaInformationDelivery(){
	}

	public StdOaInformationDelivery(String id){
		this.id = id;
	}

	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setInformationType(String informationType){
		this.informationType = informationType;
	}
	
	public String getInformationType(){
		return informationType;
	}
	
	public void setUrgencyLevel(Integer urgencyLevel){
		this.urgencyLevel = urgencyLevel;
	}
	
	public Integer getUrgencyLevel(){
		return urgencyLevel;
	}
	
	public void setInformationTemplate(Integer informationTemplate){
		this.informationTemplate = informationTemplate;
	}
	
	public Integer getInformationTemplate(){
		return informationTemplate;
	}
	
	public void setInformationDate(Date informationDate){
		this.informationDate = informationDate;
	}
	
	public Date getInformationDate(){
		return informationDate;
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
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setInformationOffice(String informationOffice){
		this.informationOffice = informationOffice;
	}
	
	public String getInformationOffice(){
		return informationOffice;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
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