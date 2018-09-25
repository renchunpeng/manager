package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;


import com.hsnn.medstgmini.common.model.Attachment;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;



/**
 *
 * @author ZXL
 * @date 2016-02-25
 *
 */
public class StdAppointmentSetting implements ICreateInfo,IUpdateInfo,IAttachment<Integer>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "StdAppointmentSetting";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields appointmentType:预约类型
	 */
	private String appointmentType;
	
	/**
	 * @Fields limitNumberBefore10Morning:上午10点之前限制数
	 */
	private Integer limitNumberBefore10Morning;
	
	/**
	 * @Fields limitNumberAfter10Morning:上午10点之后限制数
	 */
	private Integer limitNumberAfter10Morning;
	
	/**
	 * @Fields limitNumberBefore15Afternoon:下午15点之前限制数
	 */
	private Integer limitNumberBefore15Afternoon;
	
	/**
	 * @Fields limitNumberAfter15Afternoon:下午15点之后限制数
	 */
	private Integer limitNumberAfter15Afternoon;
	
	/**
	 * @Fields beginTime:开始时间
	 */
	private Date beginTime;
	
	/**
	 * @Fields endTime:endTime
	 */
	private Date endTime;
	
	/**
	 * @Fields isUsing:isUsing
	 */
	private boolean isUsing;
	
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

	public StdAppointmentSetting(){
	}

	public StdAppointmentSetting(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setAppointmentType(String appointmentType){
		this.appointmentType = appointmentType;
	}
	
	public String getAppointmentType(){
		return appointmentType;
	}
	
	public void setLimitNumberBefore10Morning(Integer limitNumberBefore10Morning){
		this.limitNumberBefore10Morning = limitNumberBefore10Morning;
	}
	
	public Integer getLimitNumberBefore10Morning(){
		return limitNumberBefore10Morning;
	}
	
	public void setLimitNumberAfter10Morning(Integer limitNumberAfter10Morning){
		this.limitNumberAfter10Morning = limitNumberAfter10Morning;
	}
	
	public Integer getLimitNumberAfter10Morning(){
		return limitNumberAfter10Morning;
	}
	
	public void setLimitNumberBefore15Afternoon(Integer limitNumberBefore15Afternoon){
		this.limitNumberBefore15Afternoon = limitNumberBefore15Afternoon;
	}
	
	public Integer getLimitNumberBefore15Afternoon(){
		return limitNumberBefore15Afternoon;
	}
	
	public void setLimitNumberAfter15Afternoon(Integer limitNumberAfter15Afternoon){
		this.limitNumberAfter15Afternoon = limitNumberAfter15Afternoon;
	}
	
	public Integer getLimitNumberAfter15Afternoon(){
		return limitNumberAfter15Afternoon;
	}
	
	public void setBeginTime(Date beginTime){
		this.beginTime = beginTime;
	}
	
	public Date getBeginTime(){
		return beginTime;
	}
	
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	
	public Date getEndTime(){
		return endTime;
	}
	
	public void setIsUsing(boolean isUsing){
		this.isUsing = isUsing;
	}
	
	public boolean getIsUsing(){
		return isUsing;
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
	
	private Attachment attachment;
	@Override
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}


}