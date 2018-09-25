package com.hsnn.medstgmini.common.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.dao.DatabaseDao;
import com.hsnn.medstgmini.common.model.ExcelImportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelImportTempBean;
import com.hsnn.medstgmini.common.service.DatabaseManager;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.SessionUtil;
import com.hsnn.medstgmini.util.StringTool;
import com.hsnn.medstgmini.util.excel.ExcelUtil;
@Service
public class DatabaseManagerImpl implements DatabaseManager {
	@Autowired
	private DatabaseDao databaseDao;

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
	public int createAddTable(SysUser sysUser, String tableName) {
		int addNum = 0;
		String userName = sysUser.getUserName();
		String newTableName = Constants.TMP_ADD + userName;
		addNum += databaseDao.createAddTable(tableName, newTableName);
		return addNum;
	}
	
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
	public int createErrorTable(SysUser sysUser, String tableName) {
		int addNum = 0;
		String userName = sysUser.getUserName();
		String errorTableName = Constants.TMP_ERROR + userName;
		addNum += databaseDao.createErrorTable(tableName, errorTableName);
		return addNum;
	}
	
	public int createImportTmpTable(SysUser sysUser, List<String> columns) {
		int addNum = 0;
		String userName = sysUser.getUserName();
		String tableName = Constants.TMP_IMPORT + userName;
		addNum += databaseDao.createImportTmpTable(tableName, columns);
		return addNum;
	}
	
	public int updateImportTmpData(String tableName, List<ExcelImportTempBean> beans) {
		return databaseDao.updateImportTmpData(tableName, beans);
	}
	
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> int batchDealDatas(SysUser sysUser, String tableName, InputStream inputStream, Class<T> clazz) {
		createAddTable(sysUser, tableName);
		createErrorTable(sysUser, tableName);
		
		List<T> addList = new ArrayList<T>();
		List<T> errorList = new ArrayList<T>();
		try {
			ExcelUtil.getImport().execute(addList, errorList, inputStream, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String beanName = StringTool.toLowerCaseFirstOne(clazz.getSimpleName()) + "ManagerImpl";
		GenericManager genericManager = SessionUtil.getBean(beanName);
		int addNum = 0;
		if(addList != null && addList.size() > 0) {
			addNum = genericManager.insertBatchTemp(addList, Constants.TMP_ADD + sysUser.getUserName(), "");
		}
		if(errorList != null && errorList.size() > 0) {
			genericManager.insertBatchTemp(errorList, Constants.TMP_ERROR + sysUser.getUserName(), "isError");
		}
		return addNum;
	}
	
	public int batchDealImportDatas(SysUser sysUser, ExcelImportDataInfo importDataInfo) {
		int addNum = 0;
		if(importDataInfo != null) {
			List<String> titles = importDataInfo.getTitles();
			if(titles != null && titles.size() > 0) {
				createImportTmpTable(sysUser, titles);

				titles.add("tmp_import_id");
				List<List<String>> dataInfos = importDataInfo.getExcelimportDatas();
				if(dataInfos != null && dataInfos.size() > 0) {
					for (List<String> list : dataInfos) {
						list.add(UUID.randomUUID().toString());
					}
				}
				
				addNum = databaseDao.insertImportTmpData(Constants.TMP_IMPORT + sysUser.getUserName(), importDataInfo);
			}
		}
		return addNum;
	}
	
	/**
	 * 获取数据库当前时间 
	 *
	 * @Title: getNow 
	 * @return Date
	 */
	public Date getNow() {
		return databaseDao.getNow();
	}
	
	/**
	 * 算工作日
	 * @param num 前几个工作日
	 * @return
	 */
	public String getworkdaybefore(String num) {
		return databaseDao.getworkdaybefore(num);
	}
}
