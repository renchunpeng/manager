package com.hsnn.medstgmini.util.form;

import java.util.List;

public class LogDetailForm {

	private String colName;
	private String newValue;
	private String oldValue;
	private String newUpduser;
	private String oldUpduser;
	private String newUpdtime;
	private String oldUpdtime;
	private List<LogDetailForm> list;
	
	public String getNewUpduser() {
		return newUpduser;
	}
	public void setNewUpduser(String newUpduser) {
		this.newUpduser = newUpduser;
	}
	public String getOldUpduser() {
		return oldUpduser;
	}
	public void setOldUpduser(String oldUpduser) {
		this.oldUpduser = oldUpduser;
	}
	public String getNewUpdtime() {
		return newUpdtime;
	}
	public void setNewUpdtime(String newUpdtime) {
		this.newUpdtime = newUpdtime;
	}
	public String getOldUpdtime() {
		return oldUpdtime;
	}
	public void setOldUpdtime(String oldUpdtime) {
		this.oldUpdtime = oldUpdtime;
	}
	public List<LogDetailForm> getList() {
		return list;
	}
	public void setList(List<LogDetailForm> list) {
		this.list = list;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	
}
