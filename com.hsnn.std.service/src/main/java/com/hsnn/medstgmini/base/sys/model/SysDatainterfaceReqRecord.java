package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-05-23 11:23:19
 *
 */
public class SysDatainterfaceReqRecord {
	
	//alias
	public static final String TABLE_ALIAS = "SysDatainterfaceReqRecord";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields interfaceId:接口编号
	 */
	private String interfaceId;
	
	/**
	 * @Fields interfaceName:接口名称
	 */
	private String interfaceName;
	
	/**
	 * @Fields interfaceUrl:接口URL
	 */
	private String interfaceUrl;
	
	/**
	 * @Fields userType:用户类型
	 */
	private Integer userType;
	
	/**
	 * @Fields userName:请求账户
	 */
	private String userName;
	
	/**
	 * @Fields requestMessage:请求内容
	 */
	private String requestMessage;
	
	/**
	 * @Fields addTime:添加时间
	 */
	private Date addTime;
	
	//columns END

	public SysDatainterfaceReqRecord(){
	}

	public SysDatainterfaceReqRecord(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setInterfaceId(String interfaceId){
		this.interfaceId = interfaceId;
	}
	
	public String getInterfaceId(){
		return interfaceId;
	}
	
	public void setInterfaceName(String interfaceName){
		this.interfaceName = interfaceName;
	}
	
	public String getInterfaceName(){
		return interfaceName;
	}
	
	public void setInterfaceUrl(String interfaceUrl){
		this.interfaceUrl = interfaceUrl;
	}
	
	public String getInterfaceUrl(){
		return interfaceUrl;
	}
	
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	
	public Integer getUserType(){
		return userType;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setRequestMessage(String requestMessage){
		this.requestMessage = requestMessage;
	}
	
	public String getRequestMessage(){
		return requestMessage;
	}
	
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	
	public Date getAddTime(){
		return addTime;
	}


}