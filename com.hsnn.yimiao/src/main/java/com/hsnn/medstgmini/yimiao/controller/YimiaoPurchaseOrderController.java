package com.hsnn.medstgmini.yimiao.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.base.std.model.StdHospital;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.*;
import com.hsnn.medstgmini.util.validate.ValidateUtil;
import com.hsnn.medstgmini.yimiao.form.YimiaoPurchaseOrderForm;
import com.hsnn.medstgmini.yimiao.form.YimiaoPurchaseReturnForm;
import com.hsnn.medstgmini.yimiao.model.*;
import com.hsnn.medstgmini.yimiao.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(YimiaoPurchaseOrderController.ACTION_PATH)
public class YimiaoPurchaseOrderController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoPurchaseOrderController.class);
	protected static final String ACTION_PATH="/yimiaoPurchaseOrder";
	protected static final String MODEL_PATH="/yimiao/yimiaoPurchaseOrder/";// TODO 修改
	@Autowired
	private YimiaoPurchaseOrderManager yimiaoPurchaseOrderManager;

	@Autowired
	private YimiaoProcurecatalogManager yimiaoProcurecatalogManager;

	@Autowired
	private YimiaoOrderdetailManager yimiaoOrderdetailManager;

	@Autowired
	private YimiaoOrderdetailLogManager yimiaoOrderdetailLogManager;

	@Autowired
	private YimiaoPurchaseReturnManager yimiaoPurchaseReturnManager;

	@Autowired
	private YimiaoOrderdetailRetlogManager yimiaoOrderdetailretLogManager;

	@Autowired
	private YimiaoOrderdetailRetManager yimiaoOrderdetailretManager;

	@Autowired
	private StdHospitalManager stdHospitalManager;

    @Autowired
    private YimiaoCatalogManager yimiaoCatalogManager;

    @Value("${system.checkTime}")
    private int checkTime;

    @Value("${system.submitted}")
    private boolean submitted;

    @Value("${system.checkSubmit}")
    private boolean checkSubmit;

	/**
	 * 跳转订单列表页面
	 * @return
	 */
	@RequestMapping("toList")
	public String toListJsp() {
		StdHospital hospital=stdHospitalManager.getById(this.getSysUser().getOrgId());
		this.getRequest().setAttribute("OrderControl", hospital.getOrderControl());
		return MODEL_PATH + "list";
	}

	@RequestMapping("getYimiaoPurchaseOrderData")
	@ResponseBody
	public Pagination getYimiaoPurchaseOrderData() {
		Pagination pagination = new Pagination(this.getRequest());
		pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
		try {
			pagination = yimiaoPurchaseOrderManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoPurchaseOrderData", e);
		}
		return pagination;
	}

	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPurchaseOrderForm.class));
		return MODEL_PATH + "add";
	}

	@RequestMapping(value ="/addYimiaoPurchaseOrder" )
	@ResponseBody
	public Pagination addYimiaoPurchaseOrder(YimiaoPurchaseOrderForm yimiaoPurchaseOrderForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPurchaseOrder yimiaoPurchaseOrder = new YimiaoPurchaseOrder();
		formToModel(yimiaoPurchaseOrderForm, yimiaoPurchaseOrder);
		// TODO 其他信息

		yimiaoPurchaseOrderManager.add(yimiaoPurchaseOrder);
		pagination.setSuccess(true);
		return pagination;
	}

	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, java.lang.String orderId) {
		YimiaoPurchaseOrder yimiaoPurchaseOrder = yimiaoPurchaseOrderManager.getById(orderId);
		YimiaoPurchaseOrderForm yimiaoPurchaseOrderForm = new YimiaoPurchaseOrderForm();
		modelToForm(yimiaoPurchaseOrder, yimiaoPurchaseOrderForm);

		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPurchaseOrderForm.class));
		model.addAttribute("yimiaoPurchaseOrderForm", yimiaoPurchaseOrderForm);
		return MODEL_PATH + "update";
	}

	@RequestMapping(value ="/updateYimiaoPurchaseOrder" )
	@ResponseBody
	public Pagination updateYimiaoPurchaseOrder(YimiaoPurchaseOrderForm yimiaoPurchaseOrderForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPurchaseOrder yimiaoPurchaseOrder = yimiaoPurchaseOrderManager.getById(yimiaoPurchaseOrderForm.getOrderId());
		BeanTool.copyProperties(yimiaoPurchaseOrderForm, yimiaoPurchaseOrder);// TODO null拷贝问题

		yimiaoPurchaseOrderManager.updateById(yimiaoPurchaseOrder);
		pagination.setSuccess(true);
		return pagination;
	}


	/***
	 * wyy
	 * @return pagination
	 * 下一步-->新增采购单
	 */
	@RequestMapping("toPreAdd")
	public String toPreAdd(Model model) {
		model.addAttribute("orderName", new  StringBuffer(this.getSysUser().getName()).append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).append("采购单").toString());
		return MODEL_PATH + "preAdd";
	}

	/***
	 * wyy
	 * @return pagination
	 * 下一步-->新增采购单验证
	 */
	@RequestMapping("toCheckOrderCount")
	@ResponseBody
	public Pagination toCheckOrderCount(){
		Pagination pagination = new Pagination(this.getRequest());
		String hospitalId=this.getSysUser().getOrgId();
		//验证开关是否开启
		int state = yimiaoOrderdetailManager.toCheckSwitch();
		// 验证是否是可提交日期
		int result = yimiaoOrderdetailretManager.toCheckDate();
		if(result > checkTime){
			pagination.setSuccess(false);
			pagination.setMsg("订单提交失败，只能在规定的工作日内进行操作!");
			return pagination;
		}
		//开关开启，需进行验证
		if(state==1){
			// 获取当月订单数量
			result = yimiaoOrderdetailManager.toCheckOrderCount(hospitalId);
			if (result > 0) {
				pagination.setMsg("你当月已提交过订单，不能再次提交或创建！");
				pagination.setSuccess(false);
			}else {
				pagination.setSuccess(true);
			}
        }
		return pagination;
	}

	/***
	 * wyy
	 * @return pagination
	 * 新增采购单明细
	 */
	@RequestMapping("toOrderList")
	public String toOrderList(Model model,String orderId) {
        YimiaoPurchaseOrder order =  yimiaoPurchaseOrderManager.getById(orderId);
		model.addAttribute("orderName",order.getOrderName());
		model.addAttribute("orderRamarks", order.getOrderRemarks());
		model.addAttribute("orderId", orderId);
		return MODEL_PATH + "orderList";
	}

		//查询疫苗商品表
		@RequestMapping(value ="/getProcureList" )
		@ResponseBody
		public Pagination getProcureList(){
			Pagination pagination = new Pagination(this.getRequest());
			pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			pagination.getConditions().put("isUsing", 1);
			try {
				pagination = yimiaoCatalogManager.getCatalogList(pagination);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}

	//退货查询疫苗订单商品表
	@RequestMapping(value ="/getYimiaoOrderDetailList" )
	@ResponseBody
	public Pagination getYimiaoOrderDetailList(){
		Pagination pagination = new Pagination(this.getRequest());
		try {
			pagination.getConditions().put("hospitalId", this.getSysUser().getOrgId());
			pagination = yimiaoOrderdetailManager.getYLOkListByHospitalId(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderDetailList", e);
		}
		return pagination;
	}

		@RequestMapping("toaddPro")
		public String toaddPro(Model model,String orderName,String orderRamarks,String orderId) {
			model.addAttribute("orderName",orderName);
			model.addAttribute("orderRamarks", orderRamarks);
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "addPro";
		}

		@RequestMapping("toaddProtoList")
		public String toaddProtoList(Model model,String orderName,String orderRamarks,String orderId) {
			model.addAttribute("orderName",orderName);
			model.addAttribute("orderRamarks", orderRamarks);
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "addProtoList";
		}
		//查询不在采购单中的疫苗商品表
		@RequestMapping(value ="/getNotProcureList" )
		@ResponseBody
		public Pagination getNotProcureList(String orderId){
			Pagination pagination = new Pagination(this.getRequest());
			pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			pagination.getConditions().put("isUsing", 1);
			pagination.getConditions().put("orderId", orderId);
			try {
				pagination = yimiaoProcurecatalogManager.queryByNot(pagination);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}
		//新增疫苗数据不在退货详情表中
		@RequestMapping(value ="/getNotProcureListret" )
		@ResponseBody
		public Pagination getNotProcureListret(String orderId){
			Pagination pagination = new Pagination(this.getRequest());
			pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			pagination.getConditions().put("isUsing", 1);
			pagination.getConditions().put("orderId", orderId);
			try {
				pagination = yimiaoOrderdetailManager.queryYimiaoOrderDetailNotret(pagination);
				//pagination = yimiaoProcurecatalogManager.queryByNotret(pagination);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}


		@RequestMapping(value ="/addOrder" )
		@ResponseBody
		public Pagination addOrder(Model model,YimiaoPurchaseOrderForm yimiaoPurchaseOrderForm ){
			Pagination pagination = new Pagination(this.getRequest());
			try {
				//验证采购单
				String hospitalId=this.getSysUser().getOrgId();
				//验证开关是否开启
				int state = yimiaoOrderdetailManager.toCheckSwitch();
				//开关打开，需进行验证
                if(state==1){
					// 获取当月订单数量
					int resultForOrder = yimiaoOrderdetailManager.toCheckOrderCount(hospitalId);
                    if (resultForOrder > 0) {
                        pagination.setMsg("你当月已提交过订单，不能再次提交或创建！");
                        pagination.setSuccess(false);
                        return pagination;
                    }
                }

				YimiaoPurchaseOrder ympur = new YimiaoPurchaseOrder();
				formToModel(yimiaoPurchaseOrderForm, ympur);
				ympur.setOrderId(UUID.randomUUID().toString());
				ympur.setHospitalId(JudgmentRole.judgmentRoleId(getSysUser()));
				ympur.setHospitalName(JudgmentRole.judgmentRole(getSysUser()));
				ympur.setOrderAmount(new BigDecimal(0));
				ympur.setAddUserId(getSysUser().getUserId());
				ympur.setAddUserName(getSysUser().getUserName());
				ympur.setOrderState(new BigDecimal(0));
				ympur.setLastUpdateUserId(getSysUser().getUserId());
				ympur.setLastUpdateUserName(getSysUser().getUserName());

				if(state==1){
                    int t = yimiaoPurchaseOrderManager.checkPurchaseOrder(hospitalId);
                    if(t > 0){
                        pagination.setSuccess(false);
                        pagination.setMsg("创建订单失败，请先处理上一个未提交或审核未通过的订单！");
                        return  pagination;
                    }
                }

				int result = yimiaoPurchaseOrderManager.add(ympur);
				if(result > 0){
                    pagination.setSuccess(true);
                    pagination.setMsg(ympur.getOrderId());
                }else{
                    pagination.setSuccess(false);
                    pagination.setMsg("采购订单新增异常，请刷新页面重试！");
                }
			} catch (Exception e) {
				log.error("Failed to addOrder", e);
				pagination.setSuccess(false);
				pagination.setMsg("采购订单新增异常，请联系管理员！");
			}
			return pagination;
		}

	/**
	 * 采购订单提交
	 * @param str
	 * @return
	 */
		@RequestMapping(value ="/toSubmit" )
		@ResponseBody
		public Pagination toSubmit(String str){
			Pagination pagination = new Pagination(this.getRequest());
			try {
               String hospitalId=this.getSysUser().getOrgId();
               //查询开关是否开启
				int state = yimiaoOrderdetailManager.toCheckSwitch();
				// 验证是否是可提交日期
				int result = yimiaoOrderdetailretManager.toCheckDate();
				if(result > checkTime){
					pagination.setSuccess(false);
					pagination.setMsg("订单提交失败，只能在规定的工作日内进行操作!");
					return pagination;
				}
				//开关打开，需进行验证
				if(state==1){
					// 获取当月订单数量
					if (yimiaoOrderdetailManager.toCheckOrderCount(hospitalId) > 0) {
						pagination.setMsg("你当月已提交过订单，不能再次提交或创建！");
						pagination.setSuccess(false);
						return pagination;
					}

				}

				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, String>> list = gson.fromJson(str, type);
				int i = yimiaoOrderdetailManager.changeStatus(list);
				if(i < 1){
					pagination.setSuccess(false);
					pagination.setMsg("提交失败，请提交本月订单！");
					return pagination;
				}
				pagination.setSuccess(true);
			} catch (Exception e) {
				log.error("Failed to toSubmit", e);
				pagination.setMsg("提交异常，请联系管理员！");
				pagination.setSuccess(false);
			}
			return pagination;
		}

		/***
		 * wyy
		 * @return pagination
		 * 新增采购单
		 */
		@SuppressWarnings("unused")
		@RequestMapping(value ="/addPurOrderpack" )
		@ResponseBody
		public Pagination addPurOrderpack(String str){
			Pagination pagination = new Pagination(this.getRequest());
			try {
                SysUser user = this.getSysUser();
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, Object>> list = gson.fromJson(str, type);
				String orderId=(String) pagination.getConditions().get("orderId");
                String userId = user.getOrgId();
                String name = user.getName()+"("+user.getUserName()+")";
                pagination.getConditions().put("userId",userId);
                pagination.getConditions().put("name",name);

                yimiaoOrderdetailManager.addAndUpdateForDetail(list,pagination);
				//计算总金额
				pagination.setSuccess(true);
			} catch (JsonSyntaxException e) {
				pagination.setSuccess(false);
				e.printStackTrace();
			} catch (NumberFormatException e) {
				pagination.setSuccess(false);
				e.printStackTrace();
			}
			return pagination;
		}


		// -------------------------------更改总金额-------------------------------//
		public void changeMoney(String orderId) {
			YimiaoPurchaseOrder pack = yimiaoPurchaseOrderManager.getById(orderId);

			if (pack != null) {

				List<YimiaoOrderdetail> infoList =yimiaoOrderdetailManager.getByOrderId(orderId);
				if (infoList != null && infoList.size() > 0) {
					BigDecimal proPrice = new BigDecimal(0);
					for (YimiaoOrderdetail entity : infoList) {
						BigDecimal price = entity.getPurchasePrice();
						BigDecimal count = new BigDecimal(entity.getPurchaseCount());
						proPrice = proPrice.add(price.multiply(count));
					}
					pack.setOrderAmount(proPrice);
				} else {
					pack.setOrderAmount(new BigDecimal(0));
				}
				yimiaoPurchaseOrderManager.updateById(pack);
			}
		}
		// -------------------------------更改总金额-------------------------------//
				public void changeMoneyret(String orderId) {
					YimiaoPurchaseReturn pack = yimiaoPurchaseReturnManager.getById(orderId);

					if (pack != null) {

						List<YimiaoOrderdetailRet> infoList = yimiaoOrderdetailretManager.getOrderdetailRetByOrderId(orderId);
						if (infoList != null && infoList.size() > 0) {
							BigDecimal proPrice = new BigDecimal(0);
							for (YimiaoOrderdetailRet entity : infoList) {
								BigDecimal price = entity.getPurchasePrice();
								BigDecimal count = new BigDecimal(entity.getPurchaseCount());
								proPrice = proPrice.add(price.multiply(count));
							}
							pack.setOrderAmount(proPrice);
						} else {
							pack.setOrderAmount(new BigDecimal(0));
						}
						yimiaoPurchaseReturnManager.updateById(pack);
					}
				}

		@SuppressWarnings("unchecked")
		@RequestMapping("updateIsusing")
		public String toListJsp(Model model,String orderPackId,String orderPackName) throws Exception {
			YimiaoPurchaseOrder purOrderpack=yimiaoPurchaseOrderManager.getById(orderPackId);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("hospCode", JudgmentRole.judgmentRoleId(getSysUser()));
			model.addAttribute("orderPackId", orderPackId);
			model.addAttribute("orderPackName", purOrderpack.getOrderName());
			model.addAttribute("purOrderpackForm", purOrderpack);
			Pagination page=new Pagination();
			page.getConditions().put("orderPackId", orderPackId);
			List<YimiaoOrderdetail> purOrderinfoList = (List<YimiaoOrderdetail>) yimiaoOrderdetailManager.getList(page);
			model.addAttribute("purOrderinfoList",purOrderinfoList);
			return MODEL_PATH + "list";
		}

	/**
	 * 跳转添加完成的采购明细页面
	 * @param model
	 * @param orderId
	 * @return
	 */
		@RequestMapping("todetails")
		public String todetails(Model model,String orderId) {
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "details";
		}
		@RequestMapping("tolistdetails")
		public String tolistdetails(Model model,String orderId) {
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "listDetails";
		}
		@RequestMapping("toretlistDetails")
		public String toretlistDetails(Model model,String orderId) {
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "retlistDetails";
		}


		@RequestMapping("getDetails")
		@ResponseBody
		public Pagination getDetails(Model model,String orderId) {
			Pagination page=new Pagination(this.getRequest());
			Pagination pagination = null;
			try {
				pagination=yimiaoOrderdetailManager.getList(page);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}

	/**
	 * 采购订单删除
	 * @param model
	 * @param str
	 * @return
	 */
		@RequestMapping("deleteOrder")
		@ResponseBody
		public Pagination deleteOrder(Model model,String str) {
			Pagination page = new Pagination(this.getRequest());
			try {
				List<YimiaoPurchaseOrder> list = new ArrayList<YimiaoPurchaseOrder>();
				if (!StringTool.isEmpty(str)) {
					list = JSON.parseArray(str, YimiaoPurchaseOrder.class);
				}
				yimiaoPurchaseOrderManager.deletePurOrder(list);
				page.setSuccess(true);
			}catch (Exception e) {
				log.error("Failed to deleteOrder", e);
				page.setMsg("采购订单删除异常，请联系管理员！");
				page.setSuccess(false);
			}
			return page;
		}

    /**
     * 删除退货订单
     * @param model
     * @param str
     * @return
     */
		@RequestMapping("deleteOrderRet")
		@ResponseBody
		public Pagination deleteOrderRet(Model model,String str) {
			Pagination page = new Pagination(this.getRequest());
			try {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, String>> list = gson.fromJson(str, type);
				List<String> retorderIdList = new ArrayList<String>();
				for (int i= 0;i<list.size();i++) {
					String retOrderId = list.get(i).get("retOrderId");
                    retorderIdList.add(retOrderId);
				}
				//删除退货单及退货单明细并还原采购明细可退货数量
                yimiaoPurchaseReturnManager.deleteAndUpdateData(retorderIdList);
				page.setSuccess(true);
			}catch (Exception e) {
				log.error("Failed to deleteOrderRet", e);
				page.setSuccess(false);
			}
			return page;
		}

		@RequestMapping("getDelete")
		@ResponseBody
		public Pagination getDelete(Model model,String str) {
			Pagination page = new Pagination(this.getRequest());
			try {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, String>> list = gson.fromJson(str, type);
				for (int i= 0;i<list.size();i++) {
					String orderdetailId = list.get(i).get("orderdetailId");
					String orderId = list.get(i).get("orderId");
					yimiaoOrderdetailManager.deleteById(orderdetailId);
					changeMoney(orderId);
				}
				page.setSuccess(true);
			} catch (Exception e) {
				log.error("Failed to getDelete", e);
				page.setSuccess(false);
			}
			return page;
		}

		@RequestMapping("updateDetailCount")
		@ResponseBody
		public Pagination updateDetailCount(Model model,String str) {
			Pagination page = new Pagination(this.getRequest());
			try {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, String>> list = gson.fromJson(str, type);
				for (int i= 0;i<list.size();i++) {
					String orderdetailId = list.get(i).get("orderdetailId");
					int purCount = Integer.valueOf(list.get(i).get("purCount"));
					String orderId = list.get(i).get("orderId");
					BigDecimal purPrice = new BigDecimal(list.get(i).get("purPrice"));
					YimiaoOrderdetail orderDetail = new YimiaoOrderdetail();
					orderDetail.setOrderdetailId(orderdetailId);
					orderDetail.setPurchaseCount(purCount);
					orderDetail.setPurchaseAmount(purPrice.multiply(new BigDecimal(purCount)));
					yimiaoOrderdetailManager.updateBySelective(orderDetail);
					changeMoney(orderId);
				}
				page.setSuccess(true);
			} catch (Exception e) {
				log.error("Failed to getDelete", e);
				page.setSuccess(false);
			}
			return page;
		}

		public void savelog(String orderdetailId) {
			YimiaoOrderdetail ym=yimiaoOrderdetailManager.getById(orderdetailId);
			YimiaoOrderdetailLog detaillog=new YimiaoOrderdetailLog();
			BeanCopierUtils.copyProperties(ym, detaillog);
			detaillog.setLogId(UUID.randomUUID().toString());
			yimiaoOrderdetailLogManager.add(detaillog);
		}

    /**
     * 跳转到退货订单列表页面
     * @return
     */
		@RequestMapping("toretList")
			public String toretList() {
			StdHospital hospital=stdHospitalManager.getById(this.getSysUser().getOrgId());
			this.getRequest().setAttribute("OrderControl", hospital.getOrderControl());
				return MODEL_PATH + "retList";
			}


		@ResponseBody
		@RequestMapping("getYimiaoPurchaseReturnData")
		public Pagination getYimiaoPurchaseReturnData() {
			Pagination pagination = new Pagination(this.getRequest());
			// TODO 涉及角色区分
			pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			try {
				pagination = yimiaoPurchaseReturnManager.getList(pagination);
			} catch (Exception e) {
				log.error("Failed to getYimiaoPurchaseReturnData", e);
			}
			return pagination;
		}

    /**
     * 跳转到退货新增页面
     * @param model
     * @return
     */
		@RequestMapping("toretPreAdd")
		public String toretPreAdd(Model model) {
			model.addAttribute("orderName", new  StringBuffer(this.getSysUser().getName()).append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).append("退货单").toString());
			return MODEL_PATH + "retpreAdd";
		}

    /**
     * 跳转到添加退货明细页面
     * @param model
     * @param orderId
     * @return
     */
		@RequestMapping("toretOrderList")
		public String toretOrderList(Model model,String orderId) {
		   YimiaoPurchaseReturn orderRet = yimiaoPurchaseReturnManager.getById(orderId);
			model.addAttribute("orderId", orderId);
            model.addAttribute("orderName", orderRet.getOrderName());
			return MODEL_PATH + "retorderList";
		}

		//查询疫苗商品表
		@RequestMapping(value ="/getretProcureList" )
		@ResponseBody
		public Pagination getretProcureList(){
			Pagination pagination = new Pagination(this.getRequest());
			pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			pagination.getConditions().put("isUsing", 1);
			try {
				pagination = yimiaoProcurecatalogManager.getList(pagination);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}
		@RequestMapping("toretaddPro")
		public String toretaddPro(Model model,String orderName,String orderRamarks,String orderId) {
			model.addAttribute("orderName",orderName);
			model.addAttribute("orderRamarks", orderRamarks);
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "retaddPro";
		}
		@RequestMapping("toretaddProtoList")
		public String toretaddProtoList(Model model,String orderName,String orderRamarks,String orderId) {
			model.addAttribute("orderName",orderName);
			model.addAttribute("orderRamarks", orderRamarks);
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "retaddProtoList";
		}
		@RequestMapping(value ="/getretNotProcureList" )
		@ResponseBody
		public Pagination getretNotProcureList(String orderId){
			Pagination pagination = new Pagination(this.getRequest());
			pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			pagination.getConditions().put("isUsing", 1);
			pagination.getConditions().put("orderId", orderId);
			try {
				pagination = yimiaoProcurecatalogManager.queryByNot(pagination);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}

    /**
     * 新增退货订单
     * @param model
     * @param yimiaoPurchaseOrderForm
     * @return
     */
		@RequestMapping(value ="/addretOrder" )
		@ResponseBody
		public Pagination addretOrder(Model model,YimiaoPurchaseOrderForm yimiaoPurchaseOrderForm ){
			Pagination pagination = new Pagination(this.getRequest());
			try {
				YimiaoPurchaseReturn ympur = new YimiaoPurchaseReturn();
				formToModel(yimiaoPurchaseOrderForm, ympur);
				ympur.setRetOrderId(UUID.randomUUID().toString());
				ympur.setHospitalId(JudgmentRole.judgmentRoleId(getSysUser()));
				ympur.setHospitalName(JudgmentRole.judgmentRole(getSysUser()));
				ympur.setOrderAmount(new BigDecimal(0));
				ympur.setSubminter(getSysUser().getUserId());
				ympur.setAddUserId(getSysUser().getUserId());
				ympur.setAddUserName(getSysUser().getUserName());
				ympur.setOrderState(new BigDecimal(0));
				ympur.setAddTime(new Date());
				int result = yimiaoPurchaseReturnManager.add(ympur);
				if(result < 1 ){
                    pagination.setMsg("新增退货订单失败，请刷新页面再试！");
                    pagination.setSuccess(false);
                    return pagination;

				}
                pagination.setSuccess(true);
                pagination.setMsg(ympur.getRetOrderId());
			} catch (Exception e) {
				log.error("Failed to addretOrder", e);
                pagination.setMsg("新增退货订单异常，请联系管理员！");
				pagination.setSuccess(false);
			}
			return pagination;
		}
		@SuppressWarnings("unchecked")
		@RequestMapping("retupdateIsusing")
		public String toretListJsp(Model model,String retPackId,String orderPackName) throws Exception {
			YimiaoPurchaseReturn purOrderpack=yimiaoPurchaseReturnManager.getById(retPackId);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("hospCode", JudgmentRole.judgmentRoleId(getSysUser()));
			model.addAttribute("orderPackId", retPackId);
			model.addAttribute("orderPackName", purOrderpack.getOrderName());
			model.addAttribute("purOrderpackForm", purOrderpack);
			Pagination page=new Pagination();
			page.getConditions().put("orderPackId", retPackId);
			List<YimiaoOrderdetailRet> purOrderinfoList = (List<YimiaoOrderdetailRet>) yimiaoOrderdetailretManager.getList(page);
			model.addAttribute("purOrderinfoList",purOrderinfoList);
			return MODEL_PATH + "retlist";
		}

    /**
     * 跳转到退货明细页面
     * @param model
     * @param orderId
     * @return
     */
		@RequestMapping("toretdetails")
		public String toretdetails(Model model,String orderId) {
			model.addAttribute("orderId", orderId);
			return MODEL_PATH + "retdetails";
		}

		@RequestMapping("getretDetails")
		@ResponseBody
		public Pagination getretDetails(Model model,String orderId) {
			Pagination page=new Pagination(this.getRequest());
			Pagination pagination = null;
			try {
				pagination=yimiaoOrderdetailretManager.getList(page);
			} catch (Exception e) {
				log.error("Failed to getOrderList", e);
			}
			return pagination;
		}

		@RequestMapping(value ="/addretYimiaoPurchaseOrder" )
		@ResponseBody
		public Pagination addretYimiaoPurchaseOrder(YimiaoPurchaseReturnForm yimiaoPurchaseReturnForm){
			Pagination pagination = new Pagination(this.getRequest());
			YimiaoPurchaseReturn yimiaoPurchaseReturn = new YimiaoPurchaseReturn();
			formToModel(yimiaoPurchaseReturnForm, yimiaoPurchaseReturn);
			// TODO 其他信息

			yimiaoPurchaseReturnManager.add(yimiaoPurchaseReturn);
			pagination.setSuccess(true);
			return pagination;
		}

    /**
     * 提交退货订单
     * @param str
     * @return
     */
        @RequestMapping(value ="/toretSubmit" )
        @ResponseBody
        public Pagination toretSubmit(String str){
            Pagination pagination = new Pagination(this.getRequest());
            try {
                Gson gson = new Gson();
                Type type = new TypeToken<List<Map<String, String>>>() {
                }.getType();
                List<Map<String, String>> list = gson.fromJson(str, type);
                yimiaoOrderdetailretManager.updataByListForSubmit(list);
                pagination.setSuccess(true);
            } catch (Exception e) {
                log.error("Failed to toretSubmit", e);
                pagination.setMsg("提交退货订单异常，请联系管理员！");
                pagination.setSuccess(false);
            }
            return pagination;
        }

				//第二

	/**
	 * 添加退货明细
	 * @param str
	 * @return
	 */
	@RequestMapping(value ="/addretPurOrderpack" )
	@ResponseBody
	public Pagination addretPurOrderpack(String str){
		Pagination pagination = new Pagination(this.getRequest());
		try {
			SysUser user = this.getSysUser();
			Gson gson = new Gson();
			Type type = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, Object>> list = gson.fromJson(str, type);
			String userId = user.getUserId();
			String name = user.getName()+"("+user.getUserName()+")";
			pagination.getConditions().put("userId",userId);
			pagination.getConditions().put("name",name);
			yimiaoOrderdetailretManager.addAndUpdateForDetail(list,pagination);
			//计算总金额
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("Fail to addretPurOrderpack ",e);
			pagination.setSuccess(false);
		}
		return pagination;
	}

				//第四
				@RequestMapping("toretUpdate")
				public String toretUpdateJsp(Model model, java.lang.String orderId) {
					YimiaoPurchaseReturn yimiaoPurchaseReturn = yimiaoPurchaseReturnManager.getById(orderId);
					YimiaoPurchaseReturnForm yimiaoPurchaseReturnForm = new YimiaoPurchaseReturnForm();
					modelToForm(yimiaoPurchaseReturn, yimiaoPurchaseReturnForm);

					model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPurchaseReturnForm.class));
					model.addAttribute("yimiaoPurchaseOrderForm", yimiaoPurchaseReturnForm);
					return MODEL_PATH + "retupdate";
				}

				//第五
				@RequestMapping(value ="/updateretYimiaoPurchaseOrder" )
				@ResponseBody
				public Pagination updateretYimiaoPurchaseOrder(YimiaoPurchaseReturnForm yimiaoPurchaseReturnForm){
					Pagination pagination = new Pagination(this.getRequest());
					YimiaoPurchaseReturn yimiaoPurchaseReturn= yimiaoPurchaseReturnManager.getById(yimiaoPurchaseReturnForm.getRetOrderId());
					BeanTool.copyProperties(yimiaoPurchaseReturnForm, yimiaoPurchaseReturn);// TODO null拷贝问题
					yimiaoPurchaseReturnManager.updateById(yimiaoPurchaseReturn);
					pagination.setSuccess(true);
					return pagination;
				}

	/**
	 * 删除退货明细
	 * @param model
	 * @param str
	 * @return
	 */
	@RequestMapping("getretDelete")
		@ResponseBody
		public Pagination getretDelete(Model model,String str) {
			Pagination page = new Pagination(this.getRequest());
			try {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, Object>> list = gson.fromJson(str, type);
				yimiaoOrderdetailretManager.deleteAndUpdateByRetDetailId(list);
				page.setSuccess(true);
			} catch (Exception e) {
				log.error("Failed to getretDelete", e);
                page.setMsg("退货明细删除异常，请联系管理员！");
				page.setSuccess(false);
			}
			return page;
		}

	/**
	 * 修改退货明细数量
	 * @param model
	 * @param str
	 * @return
	 */
		@RequestMapping("updateRetDetailCount")
		@ResponseBody
		public Pagination updateRetDetailCount(Model model,String str) {
			Pagination page = new Pagination(this.getRequest());
			try {
				Gson gson = new Gson();
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				List<Map<String, Object>> list = gson.fromJson(str, type);
				int result = yimiaoOrderdetailretManager.toCheckCount(list);
				if(result>0){
					page.setSuccess(false);
					page.setMsg("退货数量超过可退货数量，请重新设置！");
					return page;
				}
                yimiaoOrderdetailretManager.updateByDataList(list);
                page.setSuccess(true);
			} catch (Exception e) {
				log.error("Failed to updateRetDetailCount", e);
                page.setMsg("退货数量修改异常，请联系管理员！");
				page.setSuccess(false);
			}
			return page;
		}



	/**
     * 订单审核页面跳转
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
    @RequestMapping("toCheckOrder")
    public String toCheckOrder() {
        return MODEL_PATH + "checkOrder";
    }

    /**
     * 获取已经提交的订单
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("getSubmitOrder")
    @ResponseBody
    public Pagination getSubmitOrder() {
        Pagination pagination = new Pagination(this.getRequest());
        pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
        try {
            pagination = yimiaoPurchaseOrderManager.getSubmitOrder(pagination);
        } catch (Exception e) {
            log.error("Failed to getSubmitOrder", e);
        }
        return pagination;
    }

    /**
     * 审核详情页面跳转
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("toCheckOrderDetails")
    public String toCheckOrderDetails(Model model,String orderId) {
        model.addAttribute("orderId", orderId);
        return MODEL_PATH + "checkOrderDetails";
    }

    /**
     * 审核
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("checkOrder")
    @ResponseBody
    public Pagination checkOrder() {
        Pagination pagination = new Pagination(this.getRequest());
        try {
            String data = (String) pagination.getConditions().get("data");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, String>>>() {
            }.getType();
            List<Map<String, String>> list = gson.fromJson(data, type);
            pagination.getConditions().put("list",list);
            pagination.getConditions().remove("data");

			//验证开关是否开启
			int state = yimiaoOrderdetailManager.toCheckSwitch();
			//开关开启，需进行验证
			if(state==1){
				int result = yimiaoOrderdetailretManager.toCheckDate();
				if(result > checkTime){
					pagination.setSuccess(false);
					pagination.setMsg("订单审核失败，只能在规定的工作日内进行操作!");
					return pagination;
				}
			}

            boolean run = yimiaoPurchaseOrderManager.starRun(pagination);
            if(!run){
                pagination.setSuccess(false);
				pagination.setMsg("审核失败，请刷新页面再试！");
				return pagination;
            }
			pagination.setSuccess(true);
        } catch (Exception e) {
            pagination.setSuccess(false);
            pagination.setMsg("操作异常，请联系管理员！");
            log.error("Failed to checkOrder", e);
        }
        return pagination;
    }

    /**
     * 采购单审核记录
     * @author ZhuMingYuan
     * @date 2018/5/30
     * @param
     * @return
     */
    @RequestMapping("toOrderCheckList")
    public String toOrderChackList() {
        return MODEL_PATH + "orderCheckList";
    }

    /**
     * 获取审核订单记录
     * @author ZhuMingYuan
     * @date 2018/5/30
     * @param
     * @return
     */
    @RequestMapping("getOrderData")
    @ResponseBody
    public Pagination getOrderData() {
        Pagination pagination = new Pagination(this.getRequest());
        pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
        try {
            pagination = yimiaoPurchaseOrderManager.getOrderList(pagination);
        } catch (Exception e) {
            log.error("Failed to getSubmitOrder", e);
        }
        return pagination;
    }

    /**
     * 审核记录详情页面跳转
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("toCheckOrderDetailList")
    public String toCheckOrderDetailList(Model model,String orderId) {
        model.addAttribute("orderId", orderId);
        return MODEL_PATH + "checkOrderDetailList";
    }
}