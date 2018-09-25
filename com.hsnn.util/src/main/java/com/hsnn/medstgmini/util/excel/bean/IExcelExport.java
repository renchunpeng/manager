package com.hsnn.medstgmini.util.excel.bean;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.util.excel.bean.impl.ExcelStyle;

/**
 * 
 * 导出接口规范
 *
 * @ClassName: IExcelExport
 * @author zhou.xy
 * @date 2016年4月11日 上午10:01:25
 *
 */
public interface IExcelExport {
	<T> void execute(OutputStream os, List<T> data, Class<?> clazz, boolean isError) throws Exception;

	/**
	 * 为了保证顺序，可以使用 LinkedHashMap
	 * 
	 * @param titleAndField
	 */
	void setCustomTitleRow(Map<String, String> titleAndField);

	ExcelStyle getTitleStyel();

	void setTitleStyel(ExcelStyle titleStyel);

	ExcelStyle getDataStyel();

	void setDataStyel(ExcelStyle dataStyel);
}
