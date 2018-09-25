package com.hsnn.medstgmini.yimiao.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.yimiao.model.YimiaoPriceadjplandetail;
import com.hsnn.medstgmini.yimiao.service.YimiaoPriceadjplandetailManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoProcurecatalogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsnn.medstgmini.yimiao.service.YimiaoPriceadjplanManager;

import com.hsnn.medstgmini.yimiao.form.YimiaoPriceadjplanForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoPriceadjplan;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(YimiaoPriceadjplanController.ACTION_PATH)
public class YimiaoPriceadjplanController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoPriceadjplanController.class);
	protected static final String ACTION_PATH="/yimiaoPriceadjplan";
	protected static final String MODEL_PATH="/yimiao/yimiaoPriceadjplan/";// TODO 修改
	@Autowired
	private YimiaoPriceadjplanManager yimiaoPriceadjplanManager;
	@Autowired
	private YimiaoPriceadjplandetailManager yimiaoPriceadjplandetailManager;
	@Autowired
	private YimiaoProcurecatalogManager yimiaoProcurecatalogManager;
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}

	@RequestMapping("getYimiaoPriceadjplanData")
	@ResponseBody
	public Pagination getYimiaoPriceadjplanData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = yimiaoPriceadjplanManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoPriceadjplanData", e);
		}
		return pagination;
	}

	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPriceadjplanForm.class));
		return MODEL_PATH + "add";
	}

	@RequestMapping(value ="/addYimiaoPriceadjplan" )
	@ResponseBody
	public Pagination addYimiaoPriceadjplan(YimiaoPriceadjplanForm yimiaoPriceadjplanForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPriceadjplan yimiaoPriceadjplan = new YimiaoPriceadjplan();
		formToModel(yimiaoPriceadjplanForm, yimiaoPriceadjplan);
		// TODO 其他信息

		yimiaoPriceadjplanManager.add(yimiaoPriceadjplan);
		pagination.setSuccess(true);
		return pagination;
	}

	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, String priceAdjPlanId) {
		YimiaoPriceadjplan yimiaoPriceadjplan = yimiaoPriceadjplanManager.getById(priceAdjPlanId);
		YimiaoPriceadjplanForm yimiaoPriceadjplanForm = new YimiaoPriceadjplanForm();
		modelToForm(yimiaoPriceadjplan, yimiaoPriceadjplanForm);

		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPriceadjplanForm.class));
		model.addAttribute("yimiaoPriceadjplanForm", yimiaoPriceadjplanForm);
		return MODEL_PATH + "update";
	}

	@RequestMapping(value ="/updateYimiaoPriceadjplan" )
	@ResponseBody
	public Pagination updateYimiaoPriceadjplan(YimiaoPriceadjplanForm yimiaoPriceadjplanForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPriceadjplan yimiaoPriceadjplan = yimiaoPriceadjplanManager.getById(yimiaoPriceadjplanForm.getPriceAdjPlanId());
		BeanTool.copyProperties(yimiaoPriceadjplanForm, yimiaoPriceadjplan);// TODO null拷贝问题

		yimiaoPriceadjplanManager.updateById(yimiaoPriceadjplan);
		pagination.setSuccess(true);
		return pagination;
	}

	/**
	 * @category 进入新增调价计划页面
	 * @auth linyang
	 * @return
	 * @date 2016年5月24日
	 */
	@RequestMapping("toPricePlanAdd")
	public String toPricePlanAdd() {
		return MODEL_PATH + "pricePlanAdd";
	}

	/**
	 * @category 提交调价计划新增
	 * @auth linyang
	 * @return 计划设置页面
	 * @date 2016年5月24日
	 */
	@RequestMapping("submitPricePlanAdd")
	@ResponseBody
	public Pagination submitPricePlanAdd(YimiaoPriceadjplanForm form) {
		Pagination page = new Pagination(this.getRequest());
		SysUser user= this.getSysUser();
		YimiaoPriceadjplan drugpurPriceadjplan=new YimiaoPriceadjplan();
		formToModel(form, drugpurPriceadjplan);
		drugpurPriceadjplan.setCreateOrgId(user.getOrgId());
		drugpurPriceadjplan.setCreateUser(user.getUserId());
		drugpurPriceadjplan.setCreateDatetime(new Date());
		drugpurPriceadjplan.setStatus(0);
		drugpurPriceadjplan.setExecuteCat(1);
		try {
			yimiaoPriceadjplanManager.add(drugpurPriceadjplan);
			/*if ("2".equals(drugpurPriceadjplan.getExecuteCat().toString())) {
				//自动执行，设置定时任务
				QuartzUtil quartzUtil = new QuartzUtil();
				TaskObject taskObject = new TaskObject();
				taskObject.setTaskName(drugpurPriceadjplan.getPriceAdjPlanId());
				taskObject.setTaskGroupName(drugpurPriceadjplan.getPriceAdjPlanName());
				taskObject.setMethodName("executePricePlan");
				taskObject.setSpringBean("pricePlanImpl");
				taskObject.setTimeExpression(QuartzToolUtil.dateToCron(drugpurPriceadjplan.getExecuteDatetime()));
				Map<String, String> paraMap = new HashMap<>();
				taskObject.setParaMap(paraMap);
				quartzUtil.addTask(taskObject);
			}*/
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
		}
		return page;
	}

	/**
	 * @category 进入未处理调价计划
	 * @auth linyang
	 * @date 2016年5月24日
	 */
	@RequestMapping("toUnChangePlan")
	public String toUnChangePlan(){

		return MODEL_PATH + "unChangePlan";
	}

	/**
	 * @category 未处理调价计划列表
	 */
	@RequestMapping("getUnChangePlanList")
	@ResponseBody
	public Pagination getUnChangePlanList(){
		Pagination page = new Pagination(this.getRequest());
		Map<String,Object> map = new HashMap<String,Object>();
		SysUser user = new SysUser();
		map.put("status", 0);
		map.put("createOrgId", user.getOrgId());
		page.getConditions().putAll(map);
		page=yimiaoPriceadjplanManager.getList(page);

		return page;
	}

	/**
	 * @category 进入药品调价操作页面
	 * @return 药品调价操作页面
	 */
	@RequestMapping("/toPricePlanChange")
	public String toPricePlanChange(Model model, String priceAdjPlanId) {

		model.addAttribute("pricePlan", yimiaoPriceadjplanManager.getById(priceAdjPlanId));
		return MODEL_PATH + "pricePlanChange";
	}

	/**
	 * @category 获取调价计划明细的商品列表json
	 * @return 商品列表json
	 */
	@RequestMapping("/getPriceDurgList")
	@ResponseBody
	public Pagination getPriceDurgList(String priceAdjPlanId) {
		Pagination page = new Pagination(this.getRequest());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("priceAdjPlanId", priceAdjPlanId);
		page.getConditions().putAll(map);
		page=yimiaoPriceadjplandetailManager.getPlanGoods(page);

		return page;
	}

	/**
	 * @category 弹出添加药品页面
	 * @category 弹出添加药品页面
	 * @return 药品调价操作页面
	 */
	@RequestMapping("/toPricePlanAddDrug")
	public String toPricePlanAddDrug(Model model, String priceAdjPlanId) {

		model.addAttribute("pricePlan", yimiaoPriceadjplanManager.getById(priceAdjPlanId));
		return MODEL_PATH + "pricePlanAddDrug";
	}

	/**
	 * @category 获取未加入调价计划的商品列表json
	 * @return 商品列表json
	 */
	@RequestMapping("/getPriceChangeDurgList")
	@ResponseBody
	public Pagination getPriceChangeDurgList() {
		Pagination page = new Pagination(this.getRequest());
		page=yimiaoProcurecatalogManager.getGoodsList(page);
		return page;

	}

	/**
	 *
	 * @category 批量提交调价药品
	 * @return
	 */
	@RequestMapping("/batchSubmitDrugTOPlan")
	@ResponseBody
	public Pagination batchSubmitDrugTOPlan(String drugs) {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		YimiaoPriceadjplandetail drugpurPriceadjplandetail=new YimiaoPriceadjplandetail();
		int count=0;
		try {
			if (drugs != null && !"".equals(drugs)) {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String,String>>>() {}.getType();
				List<Map<String,String>> list = gson.fromJson(drugs, type);
				for(int i=0;i<list.size();i++){
					drugpurPriceadjplandetail.setPriceAdjPlanId(list.get(i).get("priceAdjPlanId"));
					drugpurPriceadjplandetail.setGoodsCode(list.get(i).get("procurecatalogId"));
					drugpurPriceadjplandetail.setRemarks(list.get(i).get("remark"));
					if(list.get(i).get("origProPriceLimit") != null && !("").equals(list.get(i).get("origProPriceLimit"))){
						drugpurPriceadjplandetail.setOrigProPriceLimit(BigDecimal.valueOf(Double.valueOf((list.get(i).get("origProPriceLimit")))));
					}
					drugpurPriceadjplandetail.setCurrProPriceLimit(BigDecimal.valueOf(Double.valueOf((list.get(i).get("currProPriceLimit")))));
					drugpurPriceadjplandetail.setAddDatetime(new Date());
					drugpurPriceadjplandetail.setAddUser(user.getName());
					yimiaoPriceadjplandetailManager.add(drugpurPriceadjplandetail);
					count++;
				}
				page.setOperCount(count);
				page.setSuccess(true);
			}
		} catch (JsonSyntaxException e) {
			page.setSuccess(false);
			e.printStackTrace();
		}
		return page;

	}

	/**
	 *
	 * @category 批量保存调价药品
	 * @return
	 */
	@RequestMapping("/batchSubmitPlanDrugEdit")
	@ResponseBody
	public Pagination batchSubmitPlanDrugEdit(String drugs) {
		Pagination page = new Pagination(this.getRequest());
		try {
			if (drugs != null && !"".equals(drugs)) {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String,String>>>() {}.getType();
				List<Map<String,String>> list = gson.fromJson(drugs, type);
				for(int i=0;i<list.size();i++){
					YimiaoPriceadjplandetail drugpurPriceadjplandetail=yimiaoPriceadjplandetailManager.getById(list.get(i).get("priceAdjPalnDetailId"));
					drugpurPriceadjplandetail.setCurrProPriceLimit(BigDecimal.valueOf(Double.valueOf((list.get(i).get("currProPriceLimit")))));
					yimiaoPriceadjplandetailManager.updateBySelective(drugpurPriceadjplandetail);
				}
				page.setSuccess(true);
			}
		} catch (JsonSyntaxException e) {
			page.setSuccess(false);
			e.printStackTrace();
		}
		return page;

	}
	/**
	 *
	 * @category 执行操作
	 * @return
	 */
	@RequestMapping("/runChangePlan")
	@ResponseBody
	public Pagination runChangePlan(String priceAdjPlanId) {
		Pagination page = new Pagination(this.getRequest());
		YimiaoPriceadjplan drugpurPriceadjplan=yimiaoPriceadjplanManager.getById(priceAdjPlanId);
		drugpurPriceadjplan.setStatus(1);
		drugpurPriceadjplan.setExecuteDatetime(new Date());
		yimiaoPriceadjplanManager.updateById(drugpurPriceadjplan);
		page.setSuccess(true);
		return page;

	}

	/**
	 * @category 批量删除调价明细
	 * @param drugs
	 * @return
	 */
	@RequestMapping("/batchDeleteDrug")
	@ResponseBody
	public Pagination batchDeleteDrug(String drugs) {
		Pagination page = new Pagination();
		int count=0;
		try {
			if (drugs != null && !"".equals(drugs)) {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String,String>>>() {}.getType();
				List<Map<String,String>> list = gson.fromJson(drugs, type);
				for(int i=0;i<list.size();i++){
					yimiaoPriceadjplandetailManager.deleteById(list.get(i).get("priceAdjPalnDetailId"));
					count++;
				}
				page.setOperCount(count);
				page.setSuccess(true);
			}
		} catch (JsonSyntaxException e) {
			page.setSuccess(false);
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 进入已处理调价计划界面
	 */
	@RequestMapping("/toDataListJsp")
	public String toDataListJsp() {
		return MODEL_PATH + "settlePriceChangePlan";
	}
	@RequestMapping("/getDataList")
	@ResponseBody
	public Pagination getDataList() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = new SysUser();
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("status", 1);
		map.put("createOrgId", user.getOrgId());
		page.getConditions().putAll(map);
		page=yimiaoPriceadjplanManager.getList(page);
		return page;
	}

	/**
	 * @category 跳转到明细列表页面
	 * @param @param request
	 * @param @return
	 */
	@RequestMapping( "/toDeatilList")
	public String toDeatilList(Model model,String priceAdjPlanId) {

		YimiaoPriceadjplan drugpurPriceadjplan =yimiaoPriceadjplanManager.getById(priceAdjPlanId);
		model.addAttribute("drugpurPriceadjplan", drugpurPriceadjplan);
		model.addAttribute("priceAdjPlanId", priceAdjPlanId);
		return  MODEL_PATH + "priceChangeShow";
	}

}