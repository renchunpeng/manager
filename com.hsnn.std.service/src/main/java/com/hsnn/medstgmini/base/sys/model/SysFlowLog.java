package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;
import java.math.BigDecimal;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-05-15 17:37:12
 *
 */
public class SysFlowLog  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "SysFlowLog";
	
	//columns START
	/**
	 * @Fields logId:logId
	 */
	private String logId;
	
	/**
	 * @Fields tableName:tableName
	 */
	private String tableName;
	
	/**
	 * @Fields foreignId:foreignId
	 */
	private String foreignId;
	
	/**
	 * @Fields doType:doType
	 */
	private String doType;
	
	/**
	 * @Fields doUser:doUser
	 */
	private String doUser;
	
	/**
	 * @Fields doReason:doReason
	 */
	private String doReason;
	
	/**
	 * @Fields doDate:doDate
	 */
	private Date doDate;
	
	//columns END

	public SysFlowLog(){
	}

	public SysFlowLog(String logId){
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


	@Override
	public void setAddUserName(String addUserName) {

	}

	@Override
	public void setAddUserId(String addUserId) {

	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {

	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {

	}
}