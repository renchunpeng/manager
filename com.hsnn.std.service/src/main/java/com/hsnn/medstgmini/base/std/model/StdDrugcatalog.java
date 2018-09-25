package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;

public class StdDrugcatalog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 111225503649133864L;

	//alias
	public static final String TABLE_ALIAS = "StdDrugcatalog";



	private String 	audictOpinion;
	private String 	auditState;
	//columns START
	
	/**
	 * @Fields drugcatalogCode:药物目录编码
	 */
	@PropertyNameAnnotation(annotation="药物目录编码")
	private String drugcatalogCode;
	
	/**
	 * @Fields drugcatalogName:药物目录名称
	 */
	@PropertyNameAnnotation(annotation="药物目录名称")
	private String drugcatalogName;
	
	/**
	 * @Fields drugcatalogCodeSelf:药物目录自定义编码
	 */
	@PropertyNameAnnotation(annotation="药物目录自定义编码")
	private String drugcatalogCodeSelf;
	
	/**
	 * @Fields drugcatalogCodeKind:药物目录自定义类别名称
	 */
	@PropertyNameAnnotation(annotation="药物目录自定义类别名称")
	private String drugcatalogCodeKind;
	
	/**
	 * @Fields drugcatalogCkRemark:药物目录自定义类别备注
	 */
	@PropertyNameAnnotation(annotation="药物目录自定义类别备注")
	private String drugcatalogCkRemark;
	
	/**
	 * @Fields version:目录版本号
	 */
	@PropertyNameAnnotation(annotation="目录版本号")
	private String version;
	
	/**
	 * @Fields remark:目录备注
	 */
	@PropertyNameAnnotation(annotation="目录备注")
	private String remark;
	
	/**
	 * @Fields type:目录类型0基础目录1采购目录
	 */
	@PropertyNameAnnotation(annotation="目录类型")
	private Integer type;
	
	/**
	 * @Fields updDatetime:更新时间
	 */
	@PropertyNameAnnotation(annotation="更新时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updDatetime;
	
	/**
	 * @Fields updUser:更新人
	 */
	@PropertyNameAnnotation(annotation="更新人")
	private String updUser;

	//columns END
	
	
	public String getDrugcatalogCode() {
		return drugcatalogCode;
	}

	public void setDrugcatalogCode(String drugcatalogCode) {
		this.drugcatalogCode = drugcatalogCode;
	}

	public String getDrugcatalogName() {
		return drugcatalogName;
	}

	public void setDrugcatalogName(String drugcatalogName) {
		this.drugcatalogName = drugcatalogName;
	}

	public String getDrugcatalogCodeSelf() {
		return drugcatalogCodeSelf;
	}

	public void setDrugcatalogCodeSelf(String drugcatalogCodeSelf) {
		this.drugcatalogCodeSelf = drugcatalogCodeSelf;
	}

	public String getDrugcatalogCodeKind() {
		return drugcatalogCodeKind;
	}

	public void setDrugcatalogCodeKind(String drugcatalogCodeKind) {
		this.drugcatalogCodeKind = drugcatalogCodeKind;
	}

	public String getDrugcatalogCkRemark() {
		return drugcatalogCkRemark;
	}

	public void setDrugcatalogCkRemark(String drugcatalogCkRemark) {
		this.drugcatalogCkRemark = drugcatalogCkRemark;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}


	public String getAudictOpinion() {
		return audictOpinion;
	}

	public void setAudictOpinion(String audictOpinion) {
		this.audictOpinion = audictOpinion;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
}