package com.hsnn.medstgmini.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.hsnn.medstgmini.base.std.service.StdDictManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoProcurecatalogManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.std.model.StdCompanys;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.model.BeanInfo;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.common.util.QueryUtils;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;
import com.hsnn.medstgmini.util.StringTool;
import com.hsnn.medstgmini.util.compile.BeanCompileUtil;
import com.hsnn.medstgmini.util.excel.ExcelUtil;
import com.hsnn.medstgmini.util.excel.bean.IExcelExport;

/**
 * 
 * 弹窗controller  
 *
 * @ClassName: DialogController  
 * @author zhou.xy
 * @date 2016年3月18日 下午1:14:32  
 *
 */
@Controller
@RequestMapping(DialogController.ACTION_PATH)
public class DialogController extends GenericController {
	private static final Logger log = Logger.getLogger(DialogController.class);
	protected static final String ACTION_PATH="/dialog";
	protected static final String MODEL_PATH="/dialog/";
	
	@Value("${system.province}")
	private String sysProvince;
	@Value("${system.province.name}")
	private String sysProvinceName;
	
	@Autowired
	private StdAreaManager dicAreaManager;
	@Autowired
	private StdDictManager stdDictManager;
	@Autowired
	private YimiaoProcurecatalogManager yimiaoProcurecatalogManager;
	/**
	 * 弹窗页面 
	 *
	 * @Title: toProductDialogList 
	 * @param busType
	 * @param
	 * @param model
	 * @return 
	 * @return String
	 * @throws
	 */
	@RequestMapping("/to{busType}DialogList")
	public String toProductDialogList(@PathVariable("busType") String busType, Model model){
		QueryUtils.setQueryParameters(model, getRequest());// 获取request中存在的参数并存入mode，供页面调用

		busType = StringTool.toLowerCaseFirstOne(busType);
		
		model.addAttribute("provinceName",  sysProvinceName);
		model.addAttribute("province", sysProvince);
		
		return MODEL_PATH + busType +"DialogList";
	}
	@RequestMapping("toHosptialDialog")
	public String toHosptialDialog(Model model){
		return MODEL_PATH+"hospitalDialog";
	}
	/**
	 * 获取显示数据 
	 *
	 * @Title: getInfoList 
	 * @param beanName service的name
	 * @return 
	 * @return Pagination
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/getInfo" )
	@ResponseBody
	public Pagination getInfoList(String beanName){
		Pagination page = new Pagination(this.getRequest());
		SysUser user = getSysUser();

//		if(UserType.psqy.getKey().equals(user.getUserType()) || UserType.psqy.getKey().equals(user.getUserType()) ||
//				UserType.psqy.getKey().equals(user.getUserType())){
		if(UserType.scqy.getKey().equals(user.getUserType())){
			StdCompanys stdCompany = user.getStdCompany();
			page.getConditions().put("companyIdPs", stdCompany.getCompanyId());
	/*	}else if(user.getUserType().equals(UserType.jg.getKey()) || user.getUserType().equals( UserType.zx.getKey()) ){
			
		}else if(user.getUserType().equals(UserType.yy.getKey()) || user.getUserType().equals(UserType.jcyy.getKey())){
			StdHospital hospital = user.getInfo();*/
		}
		
		// 扩展查询条件含有区域选项的
		String provId = sysProvince;
		String cityId = this.getRequest().getParameter("adminAreaIdDrug2");
		if(StringUtils.isNotBlank(cityId)) {
			String townId = this.getRequest().getParameter("adminAreaIdDrug3");
			String adminAreaIdDrug = provId;
			if (StringUtils.isNotBlank(townId)) {
				adminAreaIdDrug = townId;
			} else if (StringUtils.isNotBlank(cityId)) {
				adminAreaIdDrug = cityId.replaceAll("0*$", "");
			} else if (StringUtils.isNotBlank(provId)) {
				adminAreaIdDrug = provId.replaceAll("0*$", "");
			} else {
				adminAreaIdDrug = "";
			}
			page.getConditions().put("adminAreaIdDrug", adminAreaIdDrug+"%");
		}
		
		try {
			GenericManager manager = SessionUtil.getBean(beanName + "Impl");
			manager.getList(page);
		} catch (Exception e) {
			log.error("Failed to getInfoList", e);
		}
		return page;
	}
	
	/**
	 * 导入跳转页面 
	 *
	 * @Title: importDataDialogList 
	 * @param model
	 * @param beanInfoStr
	 * @return 
	 * @return String
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/importDataDialogList")
	public String importDataDialogList(Model model, String beanInfoStr){
		SysUser sysUser = getSysUser();
		List<BeanInfo> beanInfos = JSON.parseArray(beanInfoStr, BeanInfo.class);
		BeanInfo beanInfo = new BeanInfo();
		if(beanInfos != null && beanInfos.size() > 0) {
			beanInfo = beanInfos.get(0);
		}
		model.addAttribute("beanInfo", beanInfo);
		
		List<String> colNames = new ArrayList<String>();
		List<String> colModel = new ArrayList<String>();
		int errorSize = 0;
		if(beanInfo != null) {
			String beanName = beanInfo.getBeanName();
			String tableName = beanInfo.getTableName();
			String fullBeanName = beanInfo.getFullBeanName();
			if(StringUtils.isNotEmpty(beanName) && StringUtils.isNotEmpty(tableName) && StringUtils.isNotEmpty(fullBeanName)) {
				GenericManager genericManager = SessionUtil.getBean(beanName + "ManagerImpl");
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("tableName", Constants.TMP_ERROR + sysUser.getUserName());
				List<?> result = genericManager.getListWithImports(params);
				Map<String, List<String>> fieldsInfo = new HashMap<String, List<String>>();
				Class clazz = null;
				try {
					clazz = Class.forName(fullBeanName);
					fieldsInfo = BeanCompileUtil.getClassFields(clazz.newInstance());// 根据注解获取需要展示的页面信息
					if(fieldsInfo != null && fieldsInfo.size() > 0) {
						colNames = fieldsInfo.get("colNames");
						colModel = fieldsInfo.get("colModel");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if(result != null && result.size() > 0) {
					errorSize = result.size();
				}
			}
		}
		model.addAttribute("colNames", JSON.toJSONString(colNames));
		model.addAttribute("colModel", JSON.toJSONString(colModel));
		model.addAttribute("errorSize", errorSize);
		return MODEL_PATH + "importDataDialogList";
	}
	
	/**
	 * 获取导入到临时表的数据信息 
	 *
	 * @Title: getImportInfo 
	 * @param beanInfo
	 * @return 
	 * @return Pagination
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/getImportInfo" )
	@ResponseBody
	public Pagination getImportInfo(BeanInfo beanInfo){
		SysUser user = getSysUser();
		Pagination page = new Pagination(this.getRequest());
		try {
			GenericManager genericManager = SessionUtil.getBean(beanInfo.getBeanName() + "ManagerImpl");
			Map<String, Object> map = page.getConditions();
			String tableName = Constants.TMP_ADD + user.getUserName();
			map.put("tableName", tableName);
			genericManager.getListWithImport(page);
		} catch (Exception e) {
			log.error("Failed to getInfoList", e);
		}
		return page;
	}
	
	/**
	 * 将临时表中的正确数据导入到正式表 
	 *
	 * @Title: confirmImportData 
	 * @param beanInfo
	 * @return 
	 * @return boolean
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/confirmImportData" )
	@ResponseBody
	public boolean confirmImportData(BeanInfo beanInfo) {
		int addNum = 0;
		SysUser user = getSysUser();
		if(beanInfo != null) {
			String beanName = beanInfo.getBeanName();
			String tableName = beanInfo.getTableName();
			if(StringUtils.isNotEmpty(beanName) && StringUtils.isNotEmpty(tableName)) {
				GenericManager genericManager = SessionUtil.getBean(beanName + "ManagerImpl");
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("tableName", Constants.TMP_ADD + user.getUserName());
				List<?> dataToImport = genericManager.getListWithImports(params);
				addNum = genericManager.insertBatch(dataToImport);
			}
		}
		return addNum > 0;
	}
	
	/**
	 * 导出错误数据 
	 *
	 * @Title: exportErrorData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("exportErrorData")
	public void exportErrorData(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, Object> map = pagination.getConditions();
		if(map != null && map.size() > 0) {
			String beanName = (String) map.get("beanName");
			String fullBeanName = (String) map.get("fullBeanName");
			if(StringUtils.isNotEmpty(beanName) && StringUtils.isNotEmpty(fullBeanName)) {
				GenericManager genericManager = SessionUtil.getBean(beanName + "ManagerImpl");
				map.put("tableName", Constants.TMP_ERROR + getSysUser().getUserName());
				map.put("isError", "isError");
				List<?> exportLists = genericManager.getListWithImports(map);
				
				IExcelExport exp = ExcelUtil.getExport();
				try {
					response.setContentType("text/html; charset=utf-8");
					response.setContentType("application/octet-stream");
					response.addHeader("Content-Disposition", "attachment;filename=" + new String("错误数据.xls".getBytes("UTF-8"), "ISO-8859-1"));
					exp.execute(response.getOutputStream(), exportLists, Class.forName(fullBeanName), true);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				exp.setTitleStyel(null);// 设置标题样式
			}
		}
	}
	
	/**
	 * 商品列表-供货区域
	 */
	@RequestMapping("toSupplyArea")
	public String toSuppliArea(Model model){
		QueryUtils.setQueryParameters(model, getRequest());// 获取request中存在的参数并存入mode，供页面调用
	
		model.addAttribute("provinceName",  sysProvinceName);
		model.addAttribute("province", sysProvince);
		return MODEL_PATH + "supplyArea";
	}

	/**
	 * 商品列表-医院等级
	 */
	@RequestMapping("toHosLevelDiaLog")
	public String toHosLevelDiaLog(Model model){
		QueryUtils.setQueryParameters(model, getRequest());// 获取request中存在的参数并存入mode，供页面调用
		return MODEL_PATH + "hospitalLevelDiaLog";
	}

	@RequestMapping("toCompanyDialog")
	public String toCompanyDialog(Model model){
		return MODEL_PATH+"companyDialog";
	}
	@RequestMapping("toOrderDialog")
	public String toOrderDialog(Model model){
		return MODEL_PATH+"orderDialog";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping("/getInfosup" )
	@ResponseBody
	public Pagination getInfosup(String beanName){
		Pagination page = new Pagination(this.getRequest());
		try {
			GenericManager manager = SessionUtil.getBean(beanName + "Impl");
			manager.getList(page);
		} catch (Exception e) {
			log.error("Failed to getInfoList", e);
		}
		return page;
	}
	@RequestMapping("toProductDialog")
	public String toProductDialog(Model model){
		return MODEL_PATH+"productDialog";
	}
	@RequestMapping("/getProductInfo" )
	@ResponseBody
	public Pagination getProductInfo(){
		Pagination page = new Pagination(this.getRequest());
		try {
			page = stdDictManager.getDictListByProduct(page);
		} catch (Exception e) {
			log.error("Failed to getProductInfo", e);
		}
		return page;
	}
	@RequestMapping("toProductDialogForSup")
	public String toProductDialogForSup(Model model){
		return MODEL_PATH+"productDialogForSup";
	}
	@RequestMapping("/getProductInfoForSup" )
	@ResponseBody
	public Pagination getProductInfoForSup(){
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoProcurecatalogManager.getYimiaoProductName(page);
		} catch (Exception e) {
			log.error("Failed to getProductInfo", e);
		}
		return page;
	}
}
