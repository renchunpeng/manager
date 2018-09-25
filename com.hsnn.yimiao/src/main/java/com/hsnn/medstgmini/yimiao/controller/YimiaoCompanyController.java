package com.hsnn.medstgmini.yimiao.controller;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsnn.medstgmini.yimiao.model.YimiaoCompanyPs;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetail;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.util.ExportUtil;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.service.YimiaoCompanyManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoDelrelationshipManager;

@Controller
@RequestMapping(YimiaoCompanyController.ACTION_PATH)
public class YimiaoCompanyController extends  GenericController{
	private static final Logger log = Logger.getLogger(YimiaoCompanyController.class);
	protected static final String ACTION_PATH="/yimiaoCompany";
	protected static final String MODEL_PATH="/yimiao/yimiaoCompany/";// TODO 修改


	@Autowired
	private YimiaoDelrelationshipManager yimiaoDelrelationshipManager;

	@Autowired
	private YimiaoCompanyManager yimiaoCompanyManager;
	
	@Autowired
	private StdHospitalManager stdHospitalManager;

	@RequestMapping("toList")
	public String toListJsp() {
		SysUser user=this.getSysUser();
		int userType=user.getUserType();
		String strUrl="";

		if(userType==1){
			strUrl=MODEL_PATH + "list";
		}else if(userType==2){
			strUrl=MODEL_PATH + "psList";
		}else if(userType==4){
			strUrl=MODEL_PATH + "jkList";
		}else if(userType==6){
			strUrl=MODEL_PATH + "jkList";
		}

		return strUrl;
	}

	// 中心编辑页面
	@RequestMapping("toEdit")
	public String toEditJsp(@Param("prodCompCode") String prodCompCode, HttpSession session) {
		SysUser user=this.getSysUser();
		int userType=user.getUserType();
		String strUrl="";

		if(userType==6){
			strUrl=MODEL_PATH + "editRelation";
		}

		session.setAttribute("prodCompCode",prodCompCode);
		//model.addAttribute("prodCompCode",prodCompCode);
		return strUrl;
	}

	@RequestMapping("toYimiaoCompList")
	public String toYimiaoCompList() {
		return MODEL_PATH + "yimiaoCompList";
	}

	//请求药品配送企业页面
	@RequestMapping("toYimiaoCompPsList")
	public String toYimiaoCompPsList(Model model,Integer procurecatalogId) {
		model.addAttribute("procurecatalogId",procurecatalogId);
		return MODEL_PATH + "yimiaoCompPsList";
	}


	//添加配送企业页面
	@RequestMapping("toAddYimiaoCompPs")
	public String toAddYimiaoCompPs() {

		return MODEL_PATH + "addYimiaoCompPs";
	}
	/**
	 * 根据生产企业编号获取与生产企业已绑定的配送企业
	 * @return
	 */
	@RequestMapping("getYimiaoDelrelationDataByprodCompCode")
	@ResponseBody
	public Pagination getYimiaoDelrelationDataByprodCompCode(HttpSession session){
		Pagination page = new Pagination(this.getRequest());
		SysUser user=this.getSysUser();
		int userType=user.getUserType();
		//根据生产企业编号查询
		try {
			String prodCompCode = (String)session.getAttribute("prodCompCode");
			page.getConditions().put("prodCompCode", prodCompCode);
			page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 获取与生产企业已绑定的配送企业
	 * @return
	 */
	@RequestMapping("getYimiaoDelrelationData")
	@ResponseBody
	public Pagination getYimiaoDelrelationData(){
		Pagination page = new Pagination(this.getRequest());
		SysUser user=this.getSysUser();
		int userType=user.getUserType();
		//1 生产企业  2配送企业   4 疾控中心
		try {
			if(userType==1){
				page.getConditions().put("prodCompCode", user.getOrgId());
				page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);
			}else if(userType==2){
				page.getConditions().put("delCompCode", user.getOrgId());
				page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);
			}else if(userType==4){
				page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);
			}else if(userType==6){
				page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 获取与生产企业未绑定的配送企业
	 * @return
	 */
	@RequestMapping("getYimiaoCompanyData")
	@ResponseBody
	public Pagination getYimiaoCompanyData(HttpSession session){
		Pagination page = new Pagination(this.getRequest());
		SysUser user=this.getSysUser();
		String prodCompCode = (String)session.getAttribute("prodCompCode");
		try {
			page.getConditions().put("prodCompCode", prodCompCode);
			page = yimiaoCompanyManager.getYimiaoCompList(page);
		} catch (Exception e) {

		}
		return page;
	}

	/**
	 * 保存
	 * @return
	 */
	@RequestMapping("addYimiaodelrelationship")
	@ResponseBody
	public Pagination addYimiaodelrelationship(HttpSession session){
		Pagination page = new Pagination(this.getRequest());
		boolean flag=false;
		SysUser user=this.getSysUser();

		String prodCompCode = (String)session.getAttribute("prodCompCode");
		try {
			String uname = user.getUserName();
			page.getConditions().put("prodCompCode", prodCompCode);
			page.getConditions().put("userId", user.getUserId());
			flag = yimiaoDelrelationshipManager.addYimiaoDelrelationship(page.getConditions());
			if(flag)
				page.setSuccess(true);
			else{
				page.setSuccess(false);
				page.setMsg("添加失败");
			}
		} catch (Exception e) {

		}
		return page;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping("delYimiaodelrelationship")
	@ResponseBody
	public Pagination delYimiaodelrelationship(HttpSession session){
		Pagination page = new Pagination(this.getRequest());
		boolean flag=false;
		SysUser user=this.getSysUser();	
		try {
			String prodCompCode = (String)session.getAttribute("prodCompCode");
			page.getConditions().put("prodCompCode", prodCompCode);
			flag = yimiaoDelrelationshipManager.delYimiaoDelrelationship(page.getConditions());
			if(flag)
				page.setSuccess(true);
			else{
				page.setSuccess(false);
				page.setMsg("删除失败");
			}
		} catch (Exception e) {

		}
		return page;

	}

	/**
	 * 跳转企业管理页面
	 * @return
	 */
	@RequestMapping("/toYimiaoCompanyManagerList")
	public String toYimiaoCompanyManagerList() {
		return MODEL_PATH + "yimiaoCompanyManagerList";
	}
	
	/**
	 * 跳转下单管理页面
	 * @return
	 */
	@RequestMapping("/toyimiaoOrderControl")
	public String toyimiaoOrderControl() {
		return MODEL_PATH + "yimiaoOrderControl";
	}
	/**
	 * 获取企业管理列表
	 * @return
	 */
	@RequestMapping("/getYimiaoCompanyManagerData")
	@ResponseBody
	public Pagination getYimiaoCompanyManagerData() {
		Pagination page = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			page = yimiaoCompanyManager.getAllList(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoCompanyManagerData", e);
		}
		return page;
	}
	
	/**
	 * 获取医院管理列表
	 * @return
	 */
	@RequestMapping("/getStdHospitalManagerData")
	@ResponseBody
	public Pagination getStdHospitalManagerData() {
		Pagination page = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			page = stdHospitalManager.getAllList(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoCompanyManagerData", e);
		}
		return page;
	}
	
	/**
	 * 状态启用
	 * @param companyId
	 * @return
	 */
	@RequestMapping("/updateStart")
	@ResponseBody
	public Pagination updateStart(String companyId,String companyType) {
		Pagination page = new Pagination(this.getRequest());
		//companyType  0生产 1配送
		try {
			if(companyType=="1"){
				yimiaoCompanyManager.updateStart(companyId);
			}else{
				yimiaoCompanyManager.updateStartsc(companyId);
			}
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 状态停用
	 * @param companyId
	 * @return
	 */
	@RequestMapping("/updateDisable")
	@ResponseBody
	public Pagination updateDisable(String companyId,String companyType) {
		Pagination page = new Pagination(this.getRequest());
		//companyType  0生产 1配送
		try {
			if(companyType=="1"){
				yimiaoCompanyManager.updateDisable(companyId);
			}else{
				yimiaoCompanyManager.updateDisablesc(companyId);
			}
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}
	
	

	/**
	 * 下单启用
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping("/OrderStart")
	@ResponseBody
	public Pagination OrderStart(String hospitalId) {
		Pagination page = new Pagination(this.getRequest());
		try {
			stdHospitalManager.OrderStart(hospitalId);
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 下单停用
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping("/OrderDisable")
	@ResponseBody
	public Pagination OrderDisable(String hospitalId) {
		Pagination page = new Pagination(this.getRequest());
		try {
			stdHospitalManager.OrderDisable(hospitalId);
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}
	
	/**
	 * 下单状态批量停用
	 * @param str
	 * @return
	 */
	@RequestMapping("/OrderDisableAll")
	@ResponseBody
	public Pagination OrderDisableAll(String str) {
		Pagination page = new Pagination(this.getRequest());
		Gson gson = new Gson();
		Type type = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		List<Map<String, String>> list = gson.fromJson(str, type);
		for (Map<String, String> map : list) {
			String hospitalId= map.get("hospitalId");
			try {
				stdHospitalManager.OrderDisable(hospitalId);
				page.setSuccess(true);
			} catch (Exception e) {
				page.setSuccess(false);

				page.setMsg("操作失败！");
				e.printStackTrace();
			}
		}
		return page;
	}
	
	/**
	 * 下单状态批量启用
	 * @param str
	 * @return
	 */
	@RequestMapping("/OrderStartAll")
	@ResponseBody
	public Pagination  OrderStartAll(String str) {
		Pagination page = new Pagination(this.getRequest());
		Gson gson = new Gson();
		Type type = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		List<Map<String, String>> list = gson.fromJson(str, type);
		for (Map<String, String> map : list) {
			String hospitalId= map.get("hospitalId");
			try {
				stdHospitalManager.OrderStart(hospitalId);
				page.setSuccess(true);
			} catch (Exception e) {
				page.setSuccess(false);
				page.setMsg("操作失败！");
				e.printStackTrace();
			}	
		}
		return page;
	}
	/**
	 * 状态批量停用
	 * @param str
	 * @return
	 */
	@RequestMapping("/updateDisableAll")
	@ResponseBody
	public Pagination updateDisableAll(String str) {
		Pagination page = new Pagination(this.getRequest());
		Gson gson = new Gson();
		Type type = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		List<Map<String, String>> list = gson.fromJson(str, type);
		for (Map<String, String> map : list) {
			String companyId= map.get("companyId");
			try {
				yimiaoCompanyManager.updateDisable(companyId);
				page.setSuccess(true);
			} catch (Exception e) {
				page.setSuccess(false);
				page.setMsg("操作失败！");
				e.printStackTrace();
			}
		}
		return page;
	}
	/**
	 * 状态批量启用
	 * @param str
	 * @return
	 */
	@RequestMapping("/updateStartAll")
	@ResponseBody
	public Pagination updateStartAll(String str) {
		Pagination page = new Pagination(this.getRequest());
		Gson gson = new Gson();
		Type type = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		List<Map<String, String>> list = gson.fromJson(str, type);
		for (Map<String, String> map : list) {
			String companyId= map.get("companyId");
			try {
				yimiaoCompanyManager.updateStart(companyId);
				page.setSuccess(true);
			} catch (Exception e) {
				page.setSuccess(false);
				page.setMsg("操作失败！");
				e.printStackTrace();
			}	
		}
		return page;
	}
	
	
	/**
	 * 目录统计--导出
	 */
	@RequestMapping("exportDataToExcel")
	public void exportDataToExcel(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList(
				"企业名称",
				"企业类型",
				"状态" 
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoCompanyManager.getExportExcelData(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("企业列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"企业列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	/**
	 * 下单启用
	 * @param
	 * @return
	 */
	@RequestMapping("/AllEnable")
	@ResponseBody
	public Pagination AllEnable() {
		Pagination page = new Pagination(this.getRequest());
		try {
			String a="";
			stdHospitalManager.OrderALL(a);
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 下单停用
	 * @param
	 * @return
	 */
	@RequestMapping("/AllDisable")
	@ResponseBody
	public Pagination AllDisable() {
		Pagination page = new Pagination(this.getRequest());
		try {
			String a="";
			stdHospitalManager.DisableALL(a);
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 获取配送企业
	 * @param
	 * @return
	 */
	@RequestMapping("/getYimiaoCompanyPsData")
	@ResponseBody
	public Pagination getYimiaoCompanyPsData() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoDelrelationshipManager.yimiaoCompanyPs(page);
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			page.setMsg("操作失败！");
			e.printStackTrace();
		}
		return page;
	}



	/**
	 * 添加配送企业
	 * @param
	 * @return
	 */
	@RequestMapping("/addYimiaoCompanyPs")
	@ResponseBody
	public Pagination addYimiaoCompanyPs(String yimiaoCompanyPs) {
		Pagination page = new Pagination(this.getRequest());
		boolean flag=false;
		try {
			flag = yimiaoCompanyManager.addYimiaoCompanyPs(yimiaoCompanyPs);
			if(flag)
				page.setSuccess(true);
			else{
				page.setSuccess(false);
				page.setMsg("添加失败");
			}
		} catch (Exception e){

		}

		return page;
	}
}
