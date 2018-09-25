package com.hsnn.medstgmini.yimiao.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.std.service.StdManageOrgManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.ExportUtil;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.ParseNumber;
import com.hsnn.medstgmini.util.enums.ReturnOrderStatus;
import com.hsnn.medstgmini.util.validate.ValidateUtil;
import com.hsnn.medstgmini.yimiao.form.YimiaoOrderdetailRetForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailRet;
import com.hsnn.medstgmini.yimiao.service.YimiaoCompanyManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoDelrelationshipManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailRetManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(YimiaoOrderdetailRetController.ACTION_PATH)
public class YimiaoOrderdetailRetController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoOrderdetailRetController.class);
	protected static final String ACTION_PATH="/yimiaoOrderdetailRet";
	protected static final String MODEL_PATH="/yimiao/yimiaoOrderdetailRet/";// TODO 修改
	@Autowired
	private YimiaoOrderdetailRetManager yimiaoOrderdetailRetManager;

	@Autowired
	private YimiaoCompanyManager yimiaoCompanyManager;
	@Autowired
	private StdHospitalManager stdHospitalManager;
	
	@Autowired
	private YimiaoDelrelationshipManager yimiaoDelrelationshipManager;
	@Autowired
	private StdManageOrgManager stdManageOrgManager;
	@Autowired
	private StdAreaManager dicAreaManager;

	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}

	@RequestMapping("toYimiaoPSList")
	public String toYimiaoPSList() {
		return MODEL_PATH + "toYimiaoPSList";
	}
	
	@RequestMapping("toYimiaoSCList")
	public String toYimiaoSCList() {
		return MODEL_PATH + "toYimiaoSCList";
	}

	@RequestMapping("toWCList")
	public String toWCListJsp() {
		return MODEL_PATH + "WCList";
	}

	@RequestMapping("toWWCList")
	public String toWWCListJsp() {
		return MODEL_PATH + "WWCList";
	}

	@RequestMapping("toWJWList")
	public String toWJWList() {
		return MODEL_PATH + "wjwList";
	}

	@RequestMapping("toSJKList")
	public String toSJKList() {
		return MODEL_PATH + "sjkList";
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
		page.getConditions().put("prodCompCode", user.getOrgId());
		page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);

		return page;
	}

	/**
	 * 获取与生产企业已绑定的配送企业
	 * @return
	 */
	@RequestMapping("getYimiaoSCData")
	@ResponseBody
	public Pagination getYimiaoSCData(){
		Pagination page = new Pagination(this.getRequest());
		page.getConditions().put("companyType", "0");
		page = yimiaoCompanyManager.getList(page);
		return page;
	}
	@RequestMapping("getYimiaoOrderdetailRetData")
	@ResponseBody
	public Pagination getYimiaoOrderdetailRetData() {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		try {
			 if(user.getUserType().equals(UserType.scqy.getKey())){
				pagination.getConditions().put("companyIdTb", user.getOrgId());
				List<Integer> list = new ArrayList<Integer>();
			 	list.add(ReturnOrderStatus.PASS.getKey());
				pagination.getConditions().put("orderdetailStateList",list);
				pagination = yimiaoOrderdetailRetManager.getRetNoFinishList(pagination);
				//caption取值
				Map<String, Object> data = yimiaoOrderdetailRetManager.getRetNoFinishCountList(pagination.getConditions());
				if(data!=null){			
					String amount1 =data.get("amount1").toString();
					String amount2 =data.get("amount2").toString();
					String radio =data.get("radio").toString();
					data.put("amount1", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1, 2)));
					data.put("amount2", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2, 2)));
					data.put("radio", radio==null?"":ParseNumber.stringToFormat(new BigDecimal(radio).stripTrailingZeros().toPlainString(),2));
					pagination.setMsg("未完成退货记录  [申请退货数量:"+data.get("count1")
							+",申请退货金额:"+data.get("amount1") +"]");
				}else{
					pagination.setMsg("未完成退货记录  [申请退货数量:0,申请退货金额:0.00]");
					
				}
			}else if(user.getUserType().equals(UserType.jkzx.getKey())){
				pagination = yimiaoOrderdetailRetManager.getList(pagination);
			}else if(user.getUserType().equals(UserType.wsj.getKey())){
				//卫计委		
				StdManageOrg smo=stdManageOrgManager.getById(user.getOrgId());
				String areaId = smo.getAreaId();
				pagination.getConditions().put("areaId", areaId.replaceAll("0*$", ""));

				 pagination = yimiaoOrderdetailRetManager.getList(pagination);
			}else{
				 pagination = yimiaoOrderdetailRetManager.getList(pagination);
			 }
			//caption取值
			if(user.getUserType()!=1){
			Map<String, Object> data = yimiaoOrderdetailRetManager.findCountList(pagination.getConditions());
			if(data!=null){			
				String amount1 =data.get("amount1").toString();
				String amount2 =data.get("amount2").toString();
				String radio =data.get("radio").toString();
				data.put("amount1", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1, 2)));
				data.put("amount2", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2, 2)));
				data.put("radio", radio==null?"":ParseNumber.stringToFormat(new BigDecimal(radio).stripTrailingZeros().toPlainString(),2));
				pagination.setMsg("退货记录  [申请退货数量:"+data.get("count1")
						+",申请退货金额:"+data.get("amount1")+",已完成退货数量:"
						+data.get("count2")+",已完成退货金额:"+data.get("amount2")
						+",平均完成率（%）:"+data.get("radio")+"]");							
			}else{
				pagination.setMsg("退货记录  [申请退货数量:0,申请退货金额:0.00,已完成退货数量:0,已完成退货金额:0.00,平均完成率（%）:0.00]");
				
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagination;
	}
	
	@RequestMapping("getYimiaoOrderdetailRetFinData")
	@ResponseBody
	public Pagination getYimiaoOrderdetailRetFinData() {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd"); 
			Object sdate=pagination.getConditions().get("starttime");
			Object edate=pagination.getConditions().get("endtime");
			if(sdate!=null){
				pagination.getConditions().put("starttime", formatter.parse(sdate.toString()));
				if(edate!=null)
					pagination.getConditions().put("endtime", edate.toString());
			}
			// TODO 涉及角色区分
			if(user.getUserType()==2){		
				pagination.getConditions().put("companyIdPs", user.getOrgId());			
				pagination = yimiaoOrderdetailRetManager.getList(pagination);	
			}else if(user.getUserType()==1){
				pagination.getConditions().put("companyIdTb", user.getOrgId());
				pagination = yimiaoOrderdetailRetManager.getRetFinishList(pagination);
				
				//caption取值
				Map<String, Object> data = yimiaoOrderdetailRetManager.getRetFinishCountList(pagination.getConditions());
				if(data!=null){			
					String amount1 =data.get("amount1").toString();
					String amount2 =data.get("amount2").toString();
					String radio =data.get("radio").toString();
					data.put("amount1", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1, 2)));
					data.put("amount2", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2, 2)));
					data.put("radio", radio==null?"":ParseNumber.stringToFormat(new BigDecimal(radio).stripTrailingZeros().toPlainString(),2));
					pagination.setMsg("已完成退货记录  [申请退货数量:"+data.get("count1")
							+",申请退货金额:"+data.get("amount1")+",已退货数量:"
							+data.get("count2")+",已退货金额:"+data.get("amount2")
							+",平均完成率（%）:"+data.get("radio")+"]");							
				}else{
					pagination.setMsg("已完成退货记录  [申请退货数量:0,申请退货金额:0.00,已退货数量:0,已退货金额:0.00,平均完成率（%）:0.00]");
					
				}
				
			}else if(user.getUserType()==4){
				//省疾控中心		
				pagination = yimiaoOrderdetailRetManager.getList(pagination);
			}else if(user.getUserType()==6){
				//卫计委		
				pagination = yimiaoOrderdetailRetManager.getList(pagination);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagination;
	}

	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoOrderdetailRetForm.class));
		return MODEL_PATH + "add";
	}

	@RequestMapping(value ="/addYimiaoOrderdetailRet" )
	@ResponseBody
	public Pagination addYimiaoOrderdetailRet(YimiaoOrderdetailRetForm yimiaoOrderdetailRetForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoOrderdetailRet yimiaoOrderdetailRet = new YimiaoOrderdetailRet();
		formToModel(yimiaoOrderdetailRetForm, yimiaoOrderdetailRet);
		// TODO 其他信息

		yimiaoOrderdetailRetManager.add(yimiaoOrderdetailRet);
		pagination.setSuccess(true);
		return pagination;
	}

	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, java.lang.String orderdetailRetId) {
		YimiaoOrderdetailRet yimiaoOrderdetailRet = yimiaoOrderdetailRetManager.getById(orderdetailRetId);
		YimiaoOrderdetailRetForm yimiaoOrderdetailRetForm = new YimiaoOrderdetailRetForm();
		modelToForm(yimiaoOrderdetailRet, yimiaoOrderdetailRetForm);

		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoOrderdetailRetForm.class));
		model.addAttribute("yimiaoOrderdetailRetForm", yimiaoOrderdetailRetForm);
		return MODEL_PATH + "update";
	}

	/**
	 * 同意退货/不退货
	 * @param str
	 * @return
	 */
	@RequestMapping(value ="/updateYimiaoOrderdetailRet" )
	@ResponseBody
	public Pagination updateYimiaoOrderdetailRet(String str){
		Pagination pagination = new Pagination(this.getRequest());
		try {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {}.getType();
				List<Map<String, Object>> list = gson.fromJson(str, type);
				yimiaoOrderdetailRetManager.updateByRetList(list);
				pagination.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
				pagination.setSuccess(false);
				pagination.setMsg("操作异常，请联系管理员！");
			}
		return pagination;
	}
	
	/**
	 * 采购列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelWSJ")
	public void exportDataToExcelWSJ(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList(
				"申请单日期",
				"申请单名称",
				"采购单位",
				"疫苗编号",
				"疫苗名称",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"配送企业",
				"最小制剂单位",
				"申请退货数量",
				"退货单价",
				"申请退货金额",
				"退货原因",
				"订单执行状态",
				"未退货原因",
				"已退货数量",
				"已退货金额",
				"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();

		List<Map<String,Object>> list = yimiaoOrderdetailRetManager.getExportExcelDataWSJ(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("退货记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"退货记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
}