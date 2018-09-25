package com.hsnn.medstgmini.common.service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.model.ExcelImportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelImportTempBean;

public interface DatabaseManager {
	/**
	 * 动态创建临时新增表 
	 *
	 * @Title: createAddTable 
	 * @param sysUser
	 * @param tableName
	 * @return 
	 * @return int
	 * @throws
	 */
	int createAddTable(SysUser sysUser, String tableName);
	/**
	 * 动态创建临时错误表 
	 *
	 * @Title: createErrorTable 
	 * @param sysUser
	 * @param tableName
	 * @return 
	 * @return int
	 * @throws
	 */
	int createErrorTable(SysUser sysUser, String tableName);
	/**
	 * 动态创建导入临时表 
	 *
	 * @Title: createImportTmpTable 
	 * @param sysUser
	 * @param columns
	 * @return 
	 * @return int
	 * @throws
	 */
	int createImportTmpTable(SysUser sysUser, List<String> columns);
	
	/**
	 * 修改临时表数据状态
	 *
	 * @Title: updateImportTmpData 
	 * @param tableName
	 * @param beans
	 * @return 
	 * @return int
	 * @throws
	 */
	int updateImportTmpData(String tableName, List<ExcelImportTempBean> beans);
	
	/**
	 * 导入数据处理 
	 *
	 * @Title: batchDealDatas 
	 * @param sysUser
	 * @param tableName
	 * @param is
	 * @param clazz
	 * @return 
	 * @return int
	 * @throws
	 */
	<T> int batchDealDatas(SysUser sysUser, String tableName, InputStream is, Class<T> clazz);
	
	/**
	 * 导入临时数据 
	 *
	 * @Title: batchDealImportDatas 
	 * @param sysUser
	 * @param importDataInfo
	 * @return 
	 * @return int
	 * @throws
	 */
	int batchDealImportDatas(SysUser sysUser, ExcelImportDataInfo importDataInfo);
	
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
