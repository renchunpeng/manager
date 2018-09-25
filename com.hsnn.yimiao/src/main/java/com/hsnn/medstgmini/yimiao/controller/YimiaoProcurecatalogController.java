package com.hsnn.medstgmini.yimiao.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.ExcelController;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelShowColInfo;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.ExportUtil;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;
import com.hsnn.medstgmini.yimiao.form.YimiaoProcurecatalogForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoProcurecatalog;
import com.hsnn.medstgmini.yimiao.service.StdSortManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoProcurecatalogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(YimiaoProcurecatalogController.ACTION_PATH)
public class YimiaoProcurecatalogController extends ExcelController {
	private static final Logger log = Logger.getLogger(YimiaoProcurecatalogController.class);
	protected static final String ACTION_PATH="/yimiaoProcurecatalog";
	protected static final String MODEL_PATH="/yimiao/yimiaoProcurecatalog/";// TODO 修改
	@Autowired
	private YimiaoProcurecatalogManager yimiaoProcurecatalogManager;
	@Autowired
	private StdSortManager stdSortManager;
	//============================================================================
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpSession getSession() {
		return session;
	}


	public SysUser getSysUser() {
		return (SysUser) this.getSession().getAttribute(Constants.USERINFO);
	}
	
	public void modelToForm(Object model,Object form){
		BeanUtils.copyProperties(model, form);
	}
	
	public void formToModel(Object form,Object model){
		BeanUtils.copyProperties(form, model);
	}
	
	//============================================================================
	
	
	
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("toyimiaoAddList")
	public String toyimiaoAddList() {
		return MODEL_PATH + "yimiaoAddList";
	}
	
	
	@RequestMapping("toyimiaoadd")
	public String toyimiaoadd(Model model, Integer procurecatalogId) {
		if(procurecatalogId!=null){
		YimiaoProcurecatalog yimiaoProcurecatalog = yimiaoProcurecatalogManager.getById(procurecatalogId);
		YimiaoProcurecatalogForm yimiaoProcurecatalogForm = new YimiaoProcurecatalogForm();
		modelToForm(yimiaoProcurecatalog, yimiaoProcurecatalogForm);
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoProcurecatalogForm.class));
		model.addAttribute("yimiaoProcurecatalogForm", yimiaoProcurecatalogForm);
		}
		return MODEL_PATH + "yimiaoadd";
	}
	
	/**
	 * 跳转疫苗管理页面
	 * @return
	 */
	@RequestMapping("/toYimiaoProcatalogList")
	public String toYimiaoProcatalogList() {
		return MODEL_PATH + "yimiaoProcatalogList";
	}
	
	/**
	 * 跳转疫苗列表页面
	 * @return
	 */
	@RequestMapping("/toYimiaoList")
	public String toYimiaoList() {
		return MODEL_PATH + "yimiaoList";
	}

	/**
	 * 跳转疫苗列表页面
	 * @return
	 */
	@RequestMapping("/toYimiaoRelationList")
	public String toYimiaoRelationList() {
		try{
			Map<String,String> map = yimiaoProcurecatalogManager.getSwtichState();
			request.setAttribute("state",map.get("state").toString());
		}catch (Exception e){
			log.error("",e);
		}
		return MODEL_PATH + "yimiaoRelationList";
	}
	/**
	 * 获取疫苗商品列表
	 * @return
	 */
	@RequestMapping("/getYimiaoData")
	@ResponseBody
	public Pagination getYimiaoData() {
		Pagination page = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
            SysUser user = this.getSysUser();
            if(user.getUserType().equals(UserType.scqy.getKey())){
                page.getConditions().put("companyIdTb",user.getOrgId());
            }
			page = yimiaoProcurecatalogManager.getAllList(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoData", e);
		}
		return page;
	}
	/**
	 * 获取疫苗管理列表
	 * @return
	 */
	@RequestMapping("getYimiaoProcurecatalogData")
	@ResponseBody
	public Pagination getYimiaoProcurecatalogData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = yimiaoProcurecatalogManager.getAllList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoProcurecatalogData", e);
		}
		return pagination;
	}

	/*@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoProcurecatalogForm.class));
		return MODEL_PATH + "add";
	}*/
	
	@RequestMapping(value ="/addYimiaoProcurecatalog" )
	@ResponseBody
	public Pagination addYimiaoProcurecatalog(YimiaoProcurecatalogForm yimiaoProcurecatalogForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoProcurecatalog yimiaoProcurecatalog = new YimiaoProcurecatalog();
		formToModel(yimiaoProcurecatalogForm, yimiaoProcurecatalog);
		String goodsid=yimiaoProcurecatalog.getGoodsId();
		YimiaoProcurecatalog gg=yimiaoProcurecatalogManager.getbygood(goodsid);
		if(gg==null){
		// TODO 其他信息
		yimiaoProcurecatalog.setIsUsing(new BigDecimal("0"));
		yimiaoProcurecatalogManager.add(yimiaoProcurecatalog);
		pagination.setSuccess(true);
		}else{
		pagination.setSuccess(false);
		}
		return pagination;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, Integer procurecatalogId) {
		YimiaoProcurecatalog yimiaoProcurecatalog = yimiaoProcurecatalogManager.getById(procurecatalogId);
		YimiaoProcurecatalogForm yimiaoProcurecatalogForm = new YimiaoProcurecatalogForm();
		modelToForm(yimiaoProcurecatalog, yimiaoProcurecatalogForm);
		
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoProcurecatalogForm.class));
		model.addAttribute("yimiaoProcurecatalogForm", yimiaoProcurecatalogForm);
		return MODEL_PATH + "update";
	}
	
	@RequestMapping(value ="/updateYimiaoProcurecatalog" )
	@ResponseBody
	public Pagination updateYimiaoProcurecatalog(YimiaoProcurecatalogForm yimiaoProcurecatalogForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoProcurecatalog yimiaoProcurecatalog = yimiaoProcurecatalogManager.getById(yimiaoProcurecatalogForm.getProcurecatalogId());
		BeanTool.copyProperties(yimiaoProcurecatalogForm, yimiaoProcurecatalog);// TODO null拷贝问题
		
		yimiaoProcurecatalogManager.updateById(yimiaoProcurecatalog);
		pagination.setSuccess(true);
		return pagination;
	}
	/**
	 * 状态启用
	 * @param procurecatalogId
	 * @return
	 */
	@RequestMapping("/updateStart")
	@ResponseBody
	public Pagination updateStart(Integer procurecatalogId) {
		Pagination page = new Pagination(this.getRequest());
		int count = yimiaoProcurecatalogManager.updateStart(procurecatalogId);
		if (count == 1) {
			page.setSuccess(true);
		} else {
			page.setSuccess(false);
			page.setMsg("操作失败！");
		}
		return page;
	}
	/**
	 * 状态停用
	 * @param procurecatalogId
	 * @return
	 */
	@RequestMapping("/updateDisable")
	@ResponseBody
	public Pagination updateDisable(Integer procurecatalogId) {
		Pagination page = new Pagination(this.getRequest());
		int count = yimiaoProcurecatalogManager.updateDisable(procurecatalogId);
		if (count == 1) {
			page.setSuccess(true);
		} else {
			page.setSuccess(false);
			page.setMsg("操作失败！");
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
			int procurecatalogId=Integer.valueOf(map.get("procurecatalogId"));
			int count = yimiaoProcurecatalogManager.updateStart(procurecatalogId);
			if (count == 1) {
				page.setSuccess(true);
			} else {
				page.setSuccess(false);
				page.setMsg("操作失败！");
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
			int procurecatalogId=Integer.valueOf(map.get("procurecatalogId"));
			int count = yimiaoProcurecatalogManager.updateDisable(procurecatalogId);
			if (count == 1) {
				page.setSuccess(true);
			} else {
				page.setSuccess(false);
				page.setMsg("操作失败！");
			}
		}
		return page;
	}
	
	
	/**
	 * 疫苗列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcel")
	public void exportDataToExcel(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		if(user.getUserType().equals(1)){
			pagination.getConditions().put("companyIdTb",user.getOrgId());
		}
		List<String> titles = Arrays.asList(
				"采购目录编号",
				"产品编号",
				"疫苗通用名",
			    "产品名称",
			    "制剂规格（申报剂型）",
			    "批准文号",
				"生产企业（投标企业）",
			    "最小制剂单位中标价格（元）",
			    "最小制剂单位"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoProcurecatalogManager.getExportExcelData(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("疫苗列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"疫苗列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}

	/**
	 * 疫苗配送关系列表导出 方法
	 *
	 * @Title: exportData
	 * @param response
	 * @throws Exception
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToRelationExcel")
	public void exportDataToRelationExcel(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		if(user.getUserType().equals(1)){
			pagination.getConditions().put("companyIdTb",user.getOrgId());
		}
		List<String> titles = Arrays.asList(
				"委托配送企业名称",
				"疫苗编号",
				"疫苗名称",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"最小制剂单位中标价格（元）",
				"最小制剂单位",
				"疫苗状态"
		);

		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoProcurecatalogManager.getExportExcelRelationData(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);

		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("疫苗配送关系列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"疫苗配送关系列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}


	@Override
	public ExcelShowColInfo getExcelShowColInfo(String tmpImportTableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagination getExcelShowDataInfo(String tmpImportTableName, Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcelExportDataInfo getExcelExportDataInfo(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcelExportDataInfo getExcelExportErrorDataInfo(String tmpImportTableName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean importDataInfo(String tmpImportTableName, Map<String, Object> expandInfos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExcelExportDataInfo getExportExcelData(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 跳转疫苗目录页面
	 * @return
	 */
	@RequestMapping("/toSortList")
	public String toSortList() {
		return MODEL_PATH + "sortList";
	}

	@RequestMapping("getSortData")
	@ResponseBody
	public Pagination getSortData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = stdSortManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoProcurecatalogData", e);
		}
		return pagination;
	}

	/**
	 * 根据药品编号修改配送企业
	 * @param procurecatalogId
	 * @return
	 */
	@RequestMapping("/updateCompanyNamePsByProcurecatalogId")
	@ResponseBody
	public Pagination updateCompanyNamePsByProcurecatalogId(String str, Integer procurecatalogId) {
		Pagination page = new Pagination(this.getRequest());

		String companyNamePs = "";

		Gson gson = new Gson();
		Type type = new TypeToken<List<Map<String, String>>>() {
		}.getType();
		List<Map<String, String>> list = gson.fromJson(str, type);
		if(null != list && list.size() > 0 ) {
			for (Map<String, String> map : list) {
				companyNamePs += map.get("companyNamePs") + ",";
			}
		}
		companyNamePs = companyNamePs.substring(0,companyNamePs.length()-1);

		int count = yimiaoProcurecatalogManager.updateCompanyNamePsByProcurecatalogId(companyNamePs,procurecatalogId);
		if (count == 1) {
			page.setSuccess(true);
		} else {
			page.setSuccess(false);
			page.setMsg("操作失败！");
		}
		return page;
	}

	/**
	 * 修改订单提交开关
	 * @param state
	 * @return
	 */
	@RequestMapping("/changeSwitch")
	@ResponseBody
	public Pagination changeSwitch(String state){
		Pagination page = new Pagination();
		int count = yimiaoProcurecatalogManager.changeSwitch(state);
		if (count == 1) {
			page.setSuccess(true);
		} else {
			page.setSuccess(false);
			page.setMsg("操作开关失败！");
		}
		return page;
	}
}