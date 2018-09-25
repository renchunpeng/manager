package com.hsnn.medstgmini.base.std.model;

import java.util.Date;



/**
 *
 * @author ZXL
 * @date 2016-03-03
 *
 */
public class StdAttachment  {
	
	//alias
	public static final String TABLE_ALIAS = "StdAttachment";
	
	//columns START
	/**
	 * @Fields attrId:附件ID
	 */
	private String attrId;
	
	/**
	 * @Fields type:附件类型 text/html,image/jpeg等
	 */
	private String type;
	
	/**
	 * @Fields sysId:所属系统
	 */
	private String sysId;
	
	/**
	 * @Fields targetTable:所属表
	 */
	private String targetTable;
	
	/**
	 * @Fields targetField:所属表字段
	 */
	private String targetField;
	
	/**
	 * @Fields targetId:所属记录
	 */
	private String targetId;
	
	/**
	 * @Fields originName:原始文件名
	 */
	private String originName;
	
	/**
	 * @Fields suffix:后缀
	 */
	private String suffix;
	
	/**
	 * @Fields name:附件名称
	 */
	private String name;
	
	/**
	 * @Fields url:http绝对url
	 */
	private String url;
	
	/**
	 * @Fields relPath:相对路径
	 */
	private String relPath;
	
	/**
	 * @Fields downloadCount:下载次数
	 */
	private Integer downloadCount;
	
	/**
	 * @Fields remark:备注
	 */
	private String remark;
	
	/**
	 * @Fields deleted:删除标识0未删除1删除
	 */
	private Integer deleted;
	
	/**
	 * @Fields updUser:更新人
	 */
	private String updUser;
	
	/**
	 * @Fields updDatetime:更新时间
	 */
	private Date updDatetime;
	
	private String bidAttrId;
	private String signId;
	
	private Integer papersType;
	
	private String projCode;
	
	private String companyId;
	
	private String divId;
	//columns END

	public String getBidAttrId() {
		return bidAttrId;
	}

	public void setBidAttrId(String bidAttrId) {
		this.bidAttrId = bidAttrId;
	}

	public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public Integer getPapersType() {
		return papersType;
	}

	public void setPapersType(Integer papersType) {
		this.papersType = papersType;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public StdAttachment(){
	}

	public StdAttachment(String attrId){
		this.attrId = attrId;
	}

	
	public void setAttrId(String attrId){
		this.attrId = attrId;
	}
	
	public String getAttrId(){
		return attrId;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setSysId(String sysId){
		this.sysId = sysId;
	}
	
	public String getSysId(){
		return sysId;
	}
	
	public void setTargetTable(String targetTable){
		this.targetTable = targetTable;
	}
	
	public String getTargetTable(){
		return targetTable;
	}
	
	public void setTargetField(String targetField){
		this.targetField = targetField;
	}
	
	public String getTargetField(){
		return targetField;
	}
	
	public void setTargetId(String targetId){
		this.targetId = targetId;
	}
	
	public String getTargetId(){
		return targetId;
	}
	
	public void setOriginName(String originName){
		this.originName = originName;
	}
	
	public String getOriginName(){
		return originName;
	}
	
	public void setSuffix(String suffix){
		this.suffix = suffix;
	}
	
	public String getSuffix(){
		return suffix;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setRelPath(String relPath){
		this.relPath = relPath;
	}
	
	public String getRelPath(){
		return relPath;
	}
	
	public void setDownloadCount(Integer downloadCount){
		this.downloadCount = downloadCount;
	}
	
	public Integer getDownloadCount(){
		return downloadCount;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setDeleted(Integer deleted){
		this.deleted = deleted;
	}
	
	public Integer getDeleted(){
		return deleted;
	}
	
	public void setUpdUser(String updUser){
		this.updUser = updUser;
	}
	
	public String getUpdUser(){
		return updUser;
	}
	
	public void setUpdDatetime(Date updDatetime){
		this.updDatetime = updDatetime;
	}
	
	public Date getUpdDatetime(){
		return updDatetime;
	}


}