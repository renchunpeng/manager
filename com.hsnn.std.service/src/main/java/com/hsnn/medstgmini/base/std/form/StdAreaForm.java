package com.hsnn.medstgmini.base.std.form;

import org.hibernate.validator.constraints.NotEmpty;


public class StdAreaForm {
	
	private String areaId;
	@NotEmpty(message="地区名称不能为空")
	private String areaName;
	private String arFullname;
	private String arShortname;
	private int status;
	private String updUser;
	private String updDatetime;
	private int sortId;
	private String fatherAreaCode;
	private String fatherAreaName;
	private String DelCompCount;//配送企业数量（配送关系处用到）
	private String statusText;
	private String delRelId;
	private String maxDelnumCounty;
	private String maxDelnumBase;
	
	public String getDelRelId() {
		return delRelId;
	}
	public void setDelRelId(String delRelId) {
		this.delRelId = delRelId;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	public String getArFullname() {
		return arFullname;
	}
	public void setArFullname(String arFullname) {
		this.arFullname = arFullname;
	}
	
	public String getArShortname() {
		return arShortname;
	}
	public void setArShortname(String arShortname) {
		this.arShortname = arShortname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getUpdUser() {
		return updUser;
	}
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	public String getUpdDatetime() {
		return updDatetime;
	}
	public void setUpdDatetime(String updDatetime) {
		this.updDatetime = updDatetime;
	}
	
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getFatherAreaCode() {
		return fatherAreaCode;
	}
	public void setFatherAreaCode(String fatherAreaCode) {
		this.fatherAreaCode = fatherAreaCode;
	}
	public String getFatherAreaName() {
		return fatherAreaName;
	}
	public void setFatherAreaName(String fatherAreaName) {
		this.fatherAreaName = fatherAreaName;
	}
	public String getDelCompCount() {
		return DelCompCount;
	}
	public void setDelCompCount(String delCompCount) {
		DelCompCount = delCompCount;
	}
	public String getMaxDelnumCounty() {
		return maxDelnumCounty;
	}
	public void setMaxDelnumCounty(String maxDelnumCounty) {
		this.maxDelnumCounty = maxDelnumCounty;
	}
	public String getMaxDelnumBase() {
		return maxDelnumBase;
	}
	public void setMaxDelnumBase(String maxDelnumBase) {
		this.maxDelnumBase = maxDelnumBase;
	}
	
}
