package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-22 22:42:20
 *
 */
public class SysChangeLog  {
	
	//alias
	public static final String TABLE_ALIAS = "SysChangeLog";
	
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
	 * @Fields operateType:操作类型
	 */
	private Integer operateType;
	
	/**
	 * @Fields serializeTable:序列化表
	 */
	private String serializeTable;
	
	/**
	 * @Fields tableCode:业务ID
	 */
	private String tableCode;
	
	/**
	 * @Fields serializeObj:序列化对象
	 */
	private byte[] serializeObj;
	
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

	public SysChangeLog(){
	}

	public SysChangeLog(Integer id){
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
	
	public void setOperateType(Integer operateType){
		this.operateType = operateType;
	}
	
	public Integer getOperateType(){
		return operateType;
	}
	
	public void setSerializeTable(String serializeTable){
		this.serializeTable = serializeTable;
	}
	
	public String getSerializeTable(){
		return serializeTable;
	}
	
	public void setTableCode(String tableCode){
		this.tableCode = tableCode;
	}
	
	public String getTableCode(){
		return tableCode;
	}
	
	public void setSerializeObj(byte[] serializeObj){
		this.serializeObj = serializeObj;
	}
	
	public byte[] getSerializeObj(){
		return serializeObj;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}