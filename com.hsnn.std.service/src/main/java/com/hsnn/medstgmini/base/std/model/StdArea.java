package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 * 地区字典
 * @author qiulei
 *
 */
public class StdArea implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PropertyNameAnnotation(annotation="地区编码")
	private String areaId;
	
	@PropertyNameAnnotation(annotation="地区名称")
	private String areaName;
	
	@PropertyNameAnnotation(annotation="父级地区编码")
	private String fatherId;
	
	@PropertyNameAnnotation(annotation="地区简称")
	private String areaShortname;
	
	@PropertyNameAnnotation(annotation="地区完整名称")
	private String areaFullname;
	
	@PropertyNameAnnotation(annotation="状态")
	private Integer status;
	
	@PropertyNameAnnotation(annotation="更新时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updDatetime;
	
	@PropertyNameAnnotation(annotation="更新人")
	private String updUser;
	
	@PropertyNameAnnotation(annotation="排序ID")
	private int sortId;
	
	@PropertyNameAnnotation(annotation="记录添加人")
	private Integer maxDelnumCounty;
	
	@PropertyNameAnnotation(annotation="记录添加人")
	private Integer maxDelnumBase;
	
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
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public String getAreaShortname() {
		return areaShortname;
	}
	public void setAreaShortname(String areaShortname) {
		this.areaShortname = areaShortname;
	}
	public String getAreaFullname() {
		return areaFullname;
	}
	public void setAreaFullname(String areaFullname) {
		this.areaFullname = areaFullname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public Integer getMaxDelnumCounty() {
		return maxDelnumCounty;
	}
	public void setMaxDelnumCounty(Integer maxDelnumCounty) {
		this.maxDelnumCounty = maxDelnumCounty;
	}
	public Integer getMaxDelnumBase() {
		return maxDelnumBase;
	}
	public void setMaxDelnumBase(Integer maxDelnumBase) {
		this.maxDelnumBase = maxDelnumBase;
	}
	
	/**
	 * 
	 */
	List<StdArea> areaList = new ArrayList<>();

	public List<StdArea> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<StdArea> areaList) {
		this.areaList = areaList;
	}
	
}