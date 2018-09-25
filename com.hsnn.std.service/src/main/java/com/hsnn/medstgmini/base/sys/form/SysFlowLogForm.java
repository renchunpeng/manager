package com.hsnn.medstgmini.base.sys.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-05-15 17:37:12
 *
 */
public class SysFlowLogForm  {

	//columns START
	
	/**
	 * @Fields LOG_ID:logId
	 */
	@NotEmpty(message = "请填写logId")
	@Length(max = 32, message = "logId的长度不能超过{1}")
	private String logId;
	
	/**
	 * @Fields TABLE_NAME:tableName
	 */
	@Length(max = 128, message = "tableName的长度不能超过{1}")
	private String tableName;
	
	/**
	 * @Fields FOREIGN_ID:foreignId
	 */
	@Length(max = 64, message = "foreignId的长度不能超过{1}")
	private String foreignId;
	
	/**
	 * @Fields DO_TYPE:doType
	 */
	@Length(max = 128, message = "doType的长度不能超过{1}")
	private String doType;
	
	/**
	 * @Fields DO_USER:doUser
	 */
	@Length(max = 64, message = "doUser的长度不能超过{1}")
	private String doUser;
	
	/**
	 * @Fields DO_REASON:doReason
	 */
	@Length(max = 1024, message = "doReason的长度不能超过{1}")
	private String doReason;
	
	/**
	 * @Fields DO_DATE:doDate
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date doDate;
	//columns END
	

	public SysFlowLogForm(){
	}

	public SysFlowLogForm(String logId){
		this.logId = logId;
	}

	
	public void setLogId(String logId){
		this.logId = logId;
	}
	public String getLogId(){
		return logId;
	}
	
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	public String getTableName(){
		return tableName;
	}
	
	public void setForeignId(String foreignId){
		this.foreignId = foreignId;
	}
	public String getForeignId(){
		return foreignId;
	}
	
	public void setDoType(String doType){
		this.doType = doType;
	}
	public String getDoType(){
		return doType;
	}
	
	public void setDoUser(String doUser){
		this.doUser = doUser;
	}
	public String getDoUser(){
		return doUser;
	}
	
	public void setDoReason(String doReason){
		this.doReason = doReason;
	}
	public String getDoReason(){
		return doReason;
	}
	
	public void setDoDate(Date doDate){
		this.doDate = doDate;
	}
	public Date getDoDate(){
		return doDate;
	}

}