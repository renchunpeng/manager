package com.hsnn.medstgmini.util.excel.enums;

/**
 * 
 * Excel 字段的类型，用于控制字段在导入导出时候是否进行性处理
 *
 * @ClassName: ExcelColumnType
 * @author zhou.xy
 * @date 2016年4月11日 上午10:05:29
 *
 */
public enum ExcelColumnType {
	ALL(0, "导入和导出"), 
	IMP(1, "仅导入"), 
	EXP(2, "仅导出");

	private String name;
	private int value;

	private ExcelColumnType(int value, String name) {
		this.value = value;
		this.name = name;
	}
}
