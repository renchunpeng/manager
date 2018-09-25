package com.hsnn.medstgmini.base.std.model;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

import java.util.Date;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-01-16 14:11:45
 *
 */
public class BidProjectResult implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "中标结果项目表";
	
	//columns START
	/**
	 * @Fields projCode:采购项目编号
	 */
	private String projCode;
	
	/**
	 * @Fields name:项目名称
	 */
	private String name;
	
	/**
	 * @Fields projIntro:项目简介
	 */
	private String projIntro;
	
	/**
	 * @Fields starttime:采购开始时间
	 */
	private Date starttime;
	
	/**
	 * @Fields endtime:采购结束时间
	 */
	private Date endtime;
	
	/**
	 * @Fields projCat:项目类型1.招标采购2定点生产3挂网直采4议价采购5备案采购
	 */
	private String projCat;
	
	/**
	 * @Fields drugcatalogCode:药物目录编码 - 基础库
	 */
	private String drugcatalogCode;
	
	/**
	 * @Fields drugcatalogName:药物目录名称 - 基础库
	 */
	private String drugcatalogName;
	
	/**
	 * @Fields remark:备注
	 */
	private String remark;
	
	/**
	 * @Fields status:状态0关闭1开启
	 */
	private Integer status;
	
	/**
	 * @Fields createDatetime:创建时间
	 */
	private Date createDatetime;
	
	/**
	 * @Fields createUser:创建人
	 */
	private String createUser;
	
	/**
	 * @Fields updDatetime:更新时间
	 */
	private Date updDatetime;
	
	/**
	 * @Fields updUser:更新人
	 */
	private String updUser;
	
	/**
	 * @Fields zbUrl:招标文件链接
	 */
	private String zbUrl;
	
	/**
	 * @Fields pubStatus:审核公示状态0未公示1已公示
	 */
	private Integer pubStatus;
	
	/**
	 * @Fields projSource:项目来源
	 */
	private String projSource;

	private String sxChose;

	private String jcChose;
	//columns END

	public BidProjectResult(){
	}

	public BidProjectResult(String projCode){
		this.projCode = projCode;
	}

	public String getSxChose() {
		return sxChose;
	}

	public void setSxChose(String sxChose) {
		this.sxChose = sxChose;
	}

	public String getJcChose() {
		return jcChose;
	}

	public void setJcChose(String jcChose) {
		this.jcChose = jcChose;
	}

	public void setProjCode(String projCode){
		this.projCode = projCode;
	}
	
	public String getProjCode(){
		return projCode;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setProjIntro(String projIntro){
		this.projIntro = projIntro;
	}
	
	public String getProjIntro(){
		return projIntro;
	}
	
	public void setStarttime(Date starttime){
		this.starttime = starttime;
	}
	
	public Date getStarttime(){
		return starttime;
	}
	
	public void setEndtime(Date endtime){
		this.endtime = endtime;
	}
	
	public Date getEndtime(){
		return endtime;
	}
	
	public void setProjCat(String projCat){
		this.projCat = projCat;
	}
	
	public String getProjCat(){
		return projCat;
	}
	
	public void setDrugcatalogCode(String drugcatalogCode){
		this.drugcatalogCode = drugcatalogCode;
	}
	
	public String getDrugcatalogCode(){
		return drugcatalogCode;
	}
	
	public void setDrugcatalogName(String drugcatalogName){
		this.drugcatalogName = drugcatalogName;
	}
	
	public String getDrugcatalogName(){
		return drugcatalogName;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setCreateDatetime(Date createDatetime){
		this.createDatetime = createDatetime;
	}
	
	public Date getCreateDatetime(){
		return createDatetime;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public String getCreateUser(){
		return createUser;
	}
	
	public void setUpdDatetime(Date updDatetime){
		this.updDatetime = updDatetime;
	}
	
	public Date getUpdDatetime(){
		return updDatetime;
	}
	
	public void setUpdUser(String updUser){
		this.updUser = updUser;
	}
	
	public String getUpdUser(){
		return updUser;
	}
	
	public void setZbUrl(String zbUrl){
		this.zbUrl = zbUrl;
	}
	
	public String getZbUrl(){
		return zbUrl;
	}
	
	public void setPubStatus(Integer pubStatus){
		this.pubStatus = pubStatus;
	}
	
	public Integer getPubStatus(){
		return pubStatus;
	}
	
	public void setProjSource(String projSource){
		this.projSource = projSource;
	}
	
	public String getProjSource(){
		return projSource;
	}

	@Override
	public void setAddUserName(String addUserName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAddUserId(String addUserId) {
		// TODO Auto-generated method stub
		
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