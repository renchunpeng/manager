package com.hsnn.medstgmini.base.sys.model;

import java.io.Serializable;
import java.util.Date;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-23 10:00:35
 *
 */
@SuppressWarnings("serial")
public class SysOperationLog  implements Serializable{
	
	//alias
	public static final String TABLE_ALIAS = "SysOperationLog";
	
	//columns START
	/**
	 * @Fields id:日志ID
	 */
	private Integer id;
	
	/**
	 * @Fields sysId:系统ID
	 */
	private String sysId;
	
	/**
	 * @Fields tableName:操作表
	 */
	private String tableName;
	
	/**
	 * @Fields tableCode:业务ID
	 */
	private String tableCode;
	
	/**
	 * @Fields serializeObj:序列化对象
	 */
	private byte[] serializeObj;
	
	/**
	 * @Fields operateType:操作类型
	 */
	private Integer operateType;
	
	/**
	 * @Fields operation:操作内容
	 */
	private String operation;
	
	/**
	 * @Fields createrId:操作人id
	 */
	private String createrId;
	
	/**
	 * @Fields createrName:操作人名称
	 */
	private String createrName;
	
	/**
	 * @Fields createrIp:操作人IP
	 */
	private String createrIp;
	
	/**
	 * @Fields mechanismName:机构
	 */
    private String mechanismName;
    /**
	 * @Fields departmentName:部门
	 */
    private String departmentName;
    /**
   	 * @Fields jobName:岗位
   	 */
    private String jobName;
	
	/**
	 * @Fields createrDatetime:操作时间
	 */
	private Date createrDatetime;
	
	//columns END
	
	private String userName;
	private String name;

	public SysOperationLog(){
	}

	public SysOperationLog(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setSysId(String sysId){
		this.sysId = sysId;
	}
	
	public String getSysId(){
		return sysId;
	}
	
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	
	public String getTableName(){
		return tableName;
	}
	
	public void setTableCode(String tableCode){
		this.tableCode = tableCode;
	}
	
	public String getTableCode(){
		return tableCode;
	}
	
	public byte[] getSerializeObj() {
		return serializeObj;
	}

	public void setSerializeObj(byte[] serializeObj) {
		this.serializeObj = serializeObj;
	}

	public void setOperateType(Integer operateType){
		this.operateType = operateType;
	}
	
	public Integer getOperateType(){
		return operateType;
	}
	
	public void setOperation(String operation){
		this.operation = operation;
	}
	
	public String getOperation(){
		return operation;
	}
	
	public void setCreaterId(String createrId){
		this.createrId = createrId;
	}
	
	public String getCreaterId(){
		return createrId;
	}
	
	public void setCreaterName(String createrName){
		this.createrName = createrName;
	}
	
	public String getCreaterName(){
		return createrName;
	}
	
	public void setCreaterIp(String createrIp){
		this.createrIp = createrIp;
	}
	
	public String getCreaterIp(){
		return createrIp;
	}
	
	public void setCreaterDatetime(Date createrDatetime){
		this.createrDatetime = createrDatetime;
	}
	
	public Date getCreaterDatetime(){
		return createrDatetime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getMechanismName() {
		return mechanismName;
	}

	public void setMechanismName(String mechanismName) {
		this.mechanismName = mechanismName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}