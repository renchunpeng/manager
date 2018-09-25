package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-08-10 14:17:18
 *
 */
public class StdOaRecord  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "StdOaRecord";
	
	//columns START
	/**
	 * @Fields id:ID
	 */
	private Integer id;
	
	/**
	 * @Fields sourceId:来源编号：收文编号|发文编号|信息发布编号
	 */
	private String sourceId;
	
	/**
	 * @Fields source:来源：收文、发文、信息发布
	 */
	private String source;
	
	/**
	 * @Fields operationType:操作类型：1会签、2阅办
	 */
	private Integer operationType;
	
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
	
	//columns END

	public StdOaRecord(){
	}

	public StdOaRecord(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setSourceId(String sourceId){
		this.sourceId = sourceId;
	}
	
	public String getSourceId(){
		return sourceId;
	}
	
	public void setSource(String source){
		this.source = source;
	}
	
	public String getSource(){
		return source;
	}
	
	public void setOperationType(Integer operationType){
		this.operationType = operationType;
	}
	
	public Integer getOperationType(){
		return operationType;
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

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {
		// TODO Auto-generated method stub
		
	}


}