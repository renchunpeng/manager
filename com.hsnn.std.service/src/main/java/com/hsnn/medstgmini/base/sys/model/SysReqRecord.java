package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-06-15 13:16:13
 *
 */
public class SysReqRecord  {
	
	//alias
	public static final String TABLE_ALIAS = "SysReqRecord";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields executeTime:执行时间
	 */
	private String executeTime;
	
	/**
	 * @Fields executeContent:执行内容
	 */
	private String executeContent;
	
	/**
	 * @Fields addTime:请求时间
	 */
	private Date addTime;
	
	//columns END

	public SysReqRecord(){
	}

	public SysReqRecord(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setExecuteTime(String executeTime){
		this.executeTime = executeTime;
	}
	
	public String getExecuteTime(){
		return executeTime;
	}
	
	public void setExecuteContent(String executeContent){
		this.executeContent = executeContent;
	}
	
	public String getExecuteContent(){
		return executeContent;
	}
	
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	
	public Date getAddTime(){
		return addTime;
	}


}