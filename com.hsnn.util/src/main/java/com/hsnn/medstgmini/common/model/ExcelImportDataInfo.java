package com.hsnn.medstgmini.common.model;

import java.util.List;

/**
 * 
 * 导入信息  
 *
 * @ClassName: ExcelImportDataInfo  
 * @author zhou.xy
 * @date 2016年4月14日 下午9:31:47  
 *
 */
public class ExcelImportDataInfo {
	private List<String> titles;// 标题
	private List<List<String>> excelimportDatas;// 导入excel数据集

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<List<String>> getExcelimportDatas() {
		return excelimportDatas;
	}

	public void setExcelimportDatas(List<List<String>> excelimportDatas) {
		this.excelimportDatas = excelimportDatas;
	}

}
