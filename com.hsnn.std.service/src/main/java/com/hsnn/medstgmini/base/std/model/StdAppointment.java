package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;



/**
 *
 * @author ZXL
 * @date 2016-02-29
 *
 */
public class StdAppointment implements ICreateInfo,IUpdateInfo  {
	
	//alias
	public static final String TABLE_ALIAS = "StdAppointment";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields appointmentType:预约类型
	 */
	private Integer appointmentType;
	
	/**
	 * @Fields appointmentArrivalDatetime:预约到场日期
	 */
	private Date appointmentArrivalDatetime;
	
	/**
	 * @Fields appointmentNumber:预约号
	 */
	private Integer appointmentNumber;
	
	/**
	 * @Fields appointmentDealTimeinterval:预约时间段
	 */
	private Integer appointmentDealTimeinterval;
	
	/**
	 * @Fields appointmentDealRecordNumber:预约处理记录数量
	 */
	private Integer appointmentDealRecordNumber;
	
	/**
	 * @Fields dealTime:受理时间
	 */
	private Date dealTime;
	
	/**
	 * @Fields orgId:预约企业id
	 */
	private String orgId;
	private StdCompany company;
	/**
	 * @Fields appointmentPerson:预约人
	 */
	private String appointmentPerson;
	
	/**
	 * @Fields dealPerson:受理人
	 */
	private String dealPerson;
	
	/**
	 * @Fields appointmentStatus:0：保存，1：提交，2已撤销，3：已受理，4：过期
	 */
	private Integer appointmentStatus;
	
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

	public StdAppointment(){
	}

	public StdAppointment(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setAppointmentType(Integer appointmentType){
		this.appointmentType = appointmentType;
	}
	
	public Integer getAppointmentType(){
		return appointmentType;
	}
	
	public void setAppointmentArrivalDatetime(Date appointmentArrivalDatetime){
		this.appointmentArrivalDatetime = appointmentArrivalDatetime;
	}
	
	public Date getAppointmentArrivalDatetime(){
		return appointmentArrivalDatetime;
	}
	
	public void setAppointmentNumber(Integer appointmentNumber){
		this.appointmentNumber = appointmentNumber;
	}
	
	public Integer getAppointmentNumber(){
		return appointmentNumber;
	}
	
	public void setAppointmentDealTimeinterval(Integer appointmentDealTimeinterval){
		this.appointmentDealTimeinterval = appointmentDealTimeinterval;
	}
	
	public Integer getAppointmentDealTimeinterval(){
		return appointmentDealTimeinterval;
	}
	
	public void setAppointmentDealRecordNumber(Integer appointmentDealRecordNumber){
		this.appointmentDealRecordNumber = appointmentDealRecordNumber;
	}
	
	public Integer getAppointmentDealRecordNumber(){
		return appointmentDealRecordNumber;
	}
	
	public void setDealTime(Date dealTime){
		this.dealTime = dealTime;
	}
	
	public Date getDealTime(){
		return dealTime;
	}
	
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	
	public String getOrgId(){
		return orgId;
	}
	
	public void setAppointmentPerson(String appointmentPerson){
		this.appointmentPerson = appointmentPerson;
	}
	
	public String getAppointmentPerson(){
		return appointmentPerson;
	}
	
	public void setDealPerson(String dealPerson){
		this.dealPerson = dealPerson;
	}
	
	public String getDealPerson(){
		return dealPerson;
	}
	
	public void setAppointmentStatus(Integer appointmentStatus){
		this.appointmentStatus = appointmentStatus;
	}
	
	public Integer getAppointmentStatus(){
		return appointmentStatus;
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

	public StdCompany getCompany() {
		return company;
	}

	public void setCompany(StdCompany company) {
		this.company = company;
	}
	
}