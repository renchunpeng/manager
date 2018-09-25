package com.hsnn.medstgmini.common.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.common.model.ExcelImportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelImportTempBean;

public interface  DatabaseDao {
	int createAddTable(@Param("tableName") String tableName, @Param("newTableName") String newTableName);
	int createErrorTable(@Param("tableName") String tableName, @Param("newTableName") String newTableName);
	
	int createImportTmpTable(@Param("tableName") String tableName, @Param("columns") List<String> columns);
	int insertImportTmpData(@Param("tableName") String tableName, @Param("dataInfos") ExcelImportDataInfo dataInfos);
	int updateImportTmpData(@Param("tableName") String tableName, @Param("beanInfos") List<ExcelImportTempBean> dataInfos);
	
	/**
	 * 获取数据库当前时间 
	 *
	 * @Title: getNow 
	 * @return Date
	 */
	Date getNow();
	
	/**
	 * 算工作日
	 * @param num 前几个工作日
	 * @return
	 */
	String getworkdaybefore(String num);
}
