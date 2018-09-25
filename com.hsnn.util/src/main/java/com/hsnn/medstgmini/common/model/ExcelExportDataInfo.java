package com.hsnn.medstgmini.common.model;

import java.util.List;
import java.util.Map;

/**
 * 
 * 导出信息
 *
 * @ClassName: ExcelExportDataInfo
 * @author zhou.xy
 * @date 2016年4月14日 下午9:31:47
 *
 */
public class ExcelExportDataInfo {
	private List<String> titles;// 标题
	private List<Map<String, Object>> excelExportDatas;// 导出数据集

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<Map<String, Object>> getExcelExportDatas() {
		return excelExportDatas;
	}

	public void setExcelExportDatas(List<Map<String, Object>> excelExportDatas) {
		this.excelExportDatas = excelExportDatas;
	}

}
