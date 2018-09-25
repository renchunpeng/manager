package com.hsnn.medstgmini.common.model;

/**
 * 
 * 导入数据临时表额外字段
 *
 * @ClassName: ExcelImportTempBean
 * @author zhou.xy
 * @date 2016年4月15日 下午2:44:35
 *
 */
public class ExcelImportTempBean {
	private String tmpImportId;// 主键
	private Integer tmpImportDataState;// 数据标识
	private String tmpImportDataDescription;// 错误描述

	public String getTmpImportId() {
		return tmpImportId;
	}

	public void setTmpImportId(String tmpImportId) {
		this.tmpImportId = tmpImportId;
	}

	public Integer getTmpImportDataState() {
		return tmpImportDataState;
	}

	public void setTmpImportDataState(Integer tmpImportDataState) {
		this.tmpImportDataState = tmpImportDataState;
	}

	public String getTmpImportDataDescription() {
		return tmpImportDataDescription;
	}

	public void setTmpImportDataDescription(String tmpImportDataDescription) {
		this.tmpImportDataDescription = tmpImportDataDescription;
	}

}
