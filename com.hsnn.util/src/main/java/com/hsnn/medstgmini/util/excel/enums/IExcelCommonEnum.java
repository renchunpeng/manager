package com.hsnn.medstgmini.util.excel.enums;

/**
 * 
 * 一般键值型枚举的接口，规范 获取键和值的方式  
 *
 * @ClassName: IExcelCommonEnum  
 * @author zhou.xy
 * @date 2016年4月11日 上午10:06:00  
 *
 */
public interface IExcelCommonEnum {
	public String getName();

	public int getValue();
}

/**
 * 
 * 通过值查找到名称， 通常用在 列表或者详情页面获取值 由于枚举不能继承， 接口不能声明静态方法
 * 
 */
/*
 * public static String getNameByValue(int ordinal) { for(ICommonEnum
 * ce:values()){ if(ce.getValue()==ordinal){ return ce.getName(); } } return
 * null; }
 */