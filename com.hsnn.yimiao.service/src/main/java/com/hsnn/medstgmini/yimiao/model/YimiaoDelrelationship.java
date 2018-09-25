package com.hsnn.medstgmini.yimiao.model;

import java.util.Date;

public class YimiaoDelrelationship {
	
	private String delRelId;
	private String prodCompCode;
	private String prodCompName;
	private String prodCompNameSpel;
	private Integer prodCompStatus;
	private String delCompCode;
	private String delCompName;
	private String delCompNameSpel;
	private Integer delCompStatus;
	private String updUser;
	private Date updDatetime;
	
	
	
	public YimiaoDelrelationship() {
		super();
	}
	
	
	public YimiaoDelrelationship(String prodCompCode, String prodCompName, String prodCompNameSpel,
			Integer prodCompStatus, String delCompCode, String delCompName, String delCompNameSpel,
			Integer delCompStatus, String updUser, Date updDatetime) {
		super();
		this.prodCompCode = prodCompCode;
		this.prodCompName = prodCompName;
		this.prodCompNameSpel = prodCompNameSpel;
		this.prodCompStatus = prodCompStatus;
		this.delCompCode = delCompCode;
		this.delCompName = delCompName;
		this.delCompNameSpel = delCompNameSpel;
		this.delCompStatus = delCompStatus;
		this.updUser = updUser;
		this.updDatetime = updDatetime;
	}


	public String getDelRelId() {
		return delRelId;
	}
	public void setDelRelId(String delRelId) {
		this.delRelId = delRelId;
	}
	public String getProdCompCode() {
		return prodCompCode;
	}
	public void setProdCompCode(String prodCompCode) {
		this.prodCompCode = prodCompCode;
	}
	public String getProdCompName() {
		return prodCompName;
	}
	public void setProdCompName(String prodCompName) {
		this.prodCompName = prodCompName;
	}
	public String getProdCompNameSpel() {
		return prodCompNameSpel;
	}
	public void setProdCompNameSpel(String prodCompNameSpel) {
		this.prodCompNameSpel = prodCompNameSpel;
	}
	public Integer getProdCompStatus() {
		return prodCompStatus;
	}
	public void setProdCompStatus(Integer prodCompStatus) {
		this.prodCompStatus = prodCompStatus;
	}
	public String getDelCompCode() {
		return delCompCode;
	}
	public void setDelCompCode(String delCompCode) {
		this.delCompCode = delCompCode;
	}
	public String getDelCompName() {
		return delCompName;
	}
	public void setDelCompName(String delCompName) {
		this.delCompName = delCompName;
	}
	public String getDelCompNameSpel() {
		return delCompNameSpel;
	}
	public void setDelCompNameSpel(String delCompNameSpel) {
		this.delCompNameSpel = delCompNameSpel;
	}
	public Integer getDelCompStatus() {
		return delCompStatus;
	}
	public void setDelCompStatus(Integer delCompStatus) {
		this.delCompStatus = delCompStatus;
	}
	public String getUpdUser() {
		return updUser;
	}
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	public Date getUpdDatetime() {
		return updDatetime;
	}
	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}
	
	
	
	
	
}
