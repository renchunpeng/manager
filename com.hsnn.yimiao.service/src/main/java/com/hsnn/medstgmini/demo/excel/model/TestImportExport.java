package com.hsnn.medstgmini.demo.excel.model;

import java.util.Date;

/**
 *
 * @Since 2010-2016
 * @Description: 导入导出测试实例
 * @author zhou.xy
 * @date 2016-04-11 09:53:40
 *
 */
public class TestImportExport {
	private String tmpImportId;// 导入临时表数据主键
	private String tmpImportDataDescription;// 导入临时表数据行错误描述

	public String getTmpImportId() {
		return tmpImportId;
	}

	public void setTmpImportId(String tmpImportId) {
		this.tmpImportId = tmpImportId;
	}

	public String getTmpImportDataDescription() {
		return tmpImportDataDescription;
	}

	public void setTmpImportDataDescription(String tmpImportDataDescription) {
		this.tmpImportDataDescription = tmpImportDataDescription;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// alias
	public static final String TABLE_ALIAS = "TestImportExport";

	private String id;

	/**
	 * @Fields firstName:姓
	 */
	private String firstName;

	/**
	 * @Fields name:名
	 */
	private String name;

	/**
	 * @Fields addTime:创建时间
	 */
	private Date addTime;

	// columns END

	public TestImportExport() {
	}

	public TestImportExport(String id) {
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getAddTime() {
		return addTime;
	}

}