package com.hsnn.medstgmini.common.model;

import java.util.List;

/**
 * 
 * 导入标题信息以及jqgrid中数据的映射name
 *
 * @ClassName: ExcelShowColInfo  
 * @author zhou.xy
 * @date 2016年4月14日 下午9:31:47  
 *
 */
public class ExcelShowColInfo {
	private List<String> colNames;// 标题
	private List<String> colModel;// 映射

	public List<String> getColNames() {
		return colNames;
	}

	public void setColNames(List<String> colNames) {
		this.colNames = colNames;
	}

	public List<String> getColModel() {
		return colModel;
	}

	public void setColModel(List<String> colModel) {
		this.colModel = colModel;
	}

}
