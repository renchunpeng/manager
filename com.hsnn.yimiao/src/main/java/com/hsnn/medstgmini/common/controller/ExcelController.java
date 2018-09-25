package com.hsnn.medstgmini.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelImportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelShowColInfo;
import com.hsnn.medstgmini.common.service.DatabaseManager;
import com.hsnn.medstgmini.util.ExcelUtils;
import com.hsnn.medstgmini.util.Pagination;
/**
 * 
 * 导入导出公共方法  
 *
 * @ClassName: ExcelController  
 * @author zhou.xy
 * @date 2016年4月14日 上午10:19:08  
 */
public abstract class ExcelController extends GenericController {
	@Autowired
	private DatabaseManager databaseManager;
	
//	public abstract List<T> getExportDataList(Map<String, Object> params);// 获取导出数据集合
	
	/**
	 * 根据需要返回jqgrid显示的表头信息以及数据映射信息 
	 *
	 * @Title: getExcelShowColInfo 
	 * @param tmpImportTableName
	 * @return ExcelShowColInfo
	 */
	public abstract ExcelShowColInfo getExcelShowColInfo(String tmpImportTableName);
	/**
	 * 返回导入数据的展示信息（分页） 
	 *
	 * @Title: getExcelShowDataInfo 
	 * @param tmpImportTableName
	 * @param page
	 * @return Pagination
	 */
	public abstract Pagination getExcelShowDataInfo(String tmpImportTableName, Pagination page);
	
	/**
	 * 获取导出数据  
	 *
	 * @Title: getExcelExportDataInfo 
	 * @param params
	 * @return ExcelExportDataInfo
	 */
	public abstract ExcelExportDataInfo getExcelExportDataInfo(Map<String, Object> params);
	
	/**
	 * 获取要导出的错误数据 
	 *
	 * @Title: getExcelExportErrorDataInfo 
	 * @return ExcelExportDataInfo
	 */
	public abstract ExcelExportDataInfo getExcelExportErrorDataInfo(String tmpImportTableName);
	
	/**
	 * 将正确的数据导入到表中  
	 *
	 * @Title: importDataInfo 
	 * @param tmpImportTableName
	 * @param expandInfos 导入到业务表所需要的一些信息
	 * @return boolean
	 */
	public abstract boolean importDataInfo(String tmpImportTableName, Map<String, Object> expandInfos);
	
	/**
	 * 导入  
	 *
	 * @Title: importData 
	 * @param file
	 * @param expandInfo
	 * @throws Exception 
	 * @return ExcelImportExpandInfo
	 */
	@RequestMapping(value = "importData")
	@ResponseBody
	public String importData(MultipartFile file) throws Exception {
		Pagination page = new Pagination(this.getRequest());
		Map<String, Object> params = page.getConditions();
		ExcelImportDataInfo importDataInfo = ExcelUtils.excel2DataInfo(file.getInputStream());
		if(importDataInfo == null) {
			return "";
		}
		SysUser user = getSysUser();
		databaseManager.batchDealImportDatas(user, importDataInfo);
//		Class<T> clazz = getGenericType(0);
//		databaseManager.batchDealImportDatas(user, tableName, file.getInputStream(), clazz);
//		BeanInfo beanInfo = new BeanInfo();
//		beanInfo.setBeanName(StringTool.toLowerCaseFirstOne(clazz.getSimpleName()));
//		beanInfo.setFullBeanName(clazz.getName());
//		beanInfo.setTableName(tableName);
//		return JSON.toJSONString(beanInfo);
		return JSON.toJSONString(params);
	}
	
	/**
	 * 跳转到导入数据查看页面 
	 *
	 * @Title: importDataDialogList 
	 * @param model
	 * @param actionPath
	 * @return String
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/importDataDialogList")
	public String importDataDialogList(Model model, String expandInfos){
		SysUser sysUser = getSysUser();
		String tableName = Constants.TMP_IMPORT + sysUser.getUserName();
		ExcelShowColInfo showColInfo = getExcelShowColInfo(tableName);
		
		List<String> colNames = new ArrayList<String>();
		List<String> colModel = new ArrayList<String>();
		if(showColInfo != null) {
			colNames = showColInfo.getColNames();
			colModel = showColInfo.getColModel();
		}
		
		int errorSize = 0;
		ExcelExportDataInfo errorInfo = getExcelExportErrorDataInfo(tableName);
		if(errorInfo != null && errorInfo.getExcelExportDatas() != null) {
			errorSize = errorInfo.getExcelExportDatas().size();
		}
		model.addAttribute("errorSize", errorSize);
		
		model.addAttribute("colNames", JSON.toJSONString(colNames));
		model.addAttribute("colModel", JSON.toJSONString(colModel));
		List<Map> expands = JSON.parseArray(expandInfos, Map.class);
		String actionPath = "";
		if(expands != null && expands.size() > 0) {
			Map<String, String> expandsMap = expands.get(0); 
			actionPath = expandsMap.get("actionPath");
			 Iterator<Entry<String, String>> it = expandsMap.entrySet().iterator();  
			 while(it.hasNext()){  
	            Entry<String, String> entry=it.next();  
	            String key = entry.getKey();
	            if("actionPath".equals(key)) {
	            	it.remove();
	            }
			 }
		}
		model.addAttribute("expandInfos", JSON.toJSONString(expands));
		model.addAttribute("actionPath", actionPath);// action路径
		return "/dialog/importDataDialogList";
	}
	
	/**
	 * 获取导入数据 
	 *
	 * @Title: getImportInfo 
	 * @param beanInfo
	 * @return Pagination
	 * @throws
	 */
	@RequestMapping("/getImportInfo" )
	@ResponseBody
	public Pagination getImportInfo(){
		SysUser user = getSysUser();
		Pagination page = new Pagination(this.getRequest());
		page.getConditions().put("tableName", Constants.TMP_IMPORT + user.getUserName());
		page = getExcelShowDataInfo(Constants.TMP_IMPORT + user.getUserName(), page);
		return page;
	}
	
	/**
	 * 将正确的数据导入到业务表  
	 *
	 * @Title: confirmImportData 
	 * @param expandInfos
	 * @return boolean
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/confirmImportData" )
	@ResponseBody
	public boolean confirmImportData(String expandInfos) {
		SysUser user = getSysUser();
		List<Map> expands = JSON.parseArray(expandInfos, Map.class);
		Map<String, Object> expandMap = new HashMap<String, Object>();
		if(expands != null && expands.size() > 0) {
			expandMap = expands.get(0);
		}
		return importDataInfo(Constants.TMP_IMPORT + user.getUserName(), expandMap);
	}
	
	/**
	 * 导出 
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportData")
	public void exportData(HttpServletResponse response, String errorData) throws Exception {
		SysUser user = getSysUser();
		String userName = user.getUserName();
		String tableName = Constants.TMP_IMPORT + userName;
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();// 导出数据
		if(StringUtils.isNotEmpty(errorData)) {// 获取错误数据
			dataInfos = getExcelExportErrorDataInfo(tableName);
		} else {// 正常导出
			Pagination pagination = new Pagination(this.getRequest());
			dataInfos = getExcelExportDataInfo(pagination.getConditions());
		}
//		ExcelUtils.dataInfo2excel(dataInfos, response.getOutputStream());
		
		
//		Pagination pagination = new Pagination(this.getRequest());
//		Class<T> genericType = getGenericType(0);
//		List<T> exportLists = getExportDataList(pagination.getConditions());
//
//		IExcelExport exp = ExcelUtil.getExport();
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("导出数据.xls".getBytes("GB2312"), "ISO-8859-1"));
			//exp.execute(response.getOutputStream(), exportLists, genericType, false);
			ExcelUtils.dataInfo2excel(dataInfos, response.getOutputStream(), errorData);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//exp.setTitleStyel(null);// 设置标题样式
	}
	
	/**
	 * 
	 * @Description: 获取类型
	 * @Title: getGenericType
	 * @return Class<T>
	 * @throws
	 */
//	@SuppressWarnings({"unchecked", "hiding" })
//	public <T> Class<T> getGenericType(int index) {
//		Type genType = getClass().getGenericSuperclass();
//		if (genType instanceof ParameterizedType) {
//			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//			return (Class<T>) params[index];
//		}
//		return null;
//	}
	
	
	@RequestMapping("exportDataToExcel")
	public void exportDataToExcel(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		ExcelExportDataInfo dataInfos = getExportExcelData(pagination.getConditions());
		
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("导出数据.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExcelUtils.exportExcelDataInfo(dataInfos, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @category 查询导出数据
	 * @author wangbing
	 * @date 2016年6月16日下午2:07:29
	 * @parameter
	 * @return
	 */
	public abstract ExcelExportDataInfo getExportExcelData(Map<String, Object> params);
}
