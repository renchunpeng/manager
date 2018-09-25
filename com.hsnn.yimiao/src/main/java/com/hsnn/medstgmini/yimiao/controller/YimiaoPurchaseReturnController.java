package com.hsnn.medstgmini.yimiao.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.JudgmentRole;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;
import com.hsnn.medstgmini.yimiao.form.YimiaoPurchaseReturnForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseReturn;
import com.hsnn.medstgmini.yimiao.service.YimiaoPurchaseReturnManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(YimiaoPurchaseReturnController.ACTION_PATH)
public class YimiaoPurchaseReturnController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoPurchaseReturnController.class);
	protected static final String ACTION_PATH="/yimiaoPurchaseReturn";
	protected static final String MODEL_PATH="/yimiao/yimiaoPurchaseReturn/";// TODO 修改
	@Autowired
	private YimiaoPurchaseReturnManager yimiaoPurchaseReturnManager;
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("getYimiaoPurchaseReturnData")
	@ResponseBody
	public Pagination getYimiaoPurchaseReturnData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = yimiaoPurchaseReturnManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoPurchaseReturnData", e);
		}
		return pagination;
	}
	
	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPurchaseReturnForm.class));
		return MODEL_PATH + "add";
	}

	/**
	 * 订单审核页面跳转
	 * @date 2018/5/15
	 * @param
	 * @return
	 */
	@RequestMapping("toCheckReturn")
	public  String toCheckReturn(){
		return MODEL_PATH + "checkReturn";
	}

	/**
	 * 获取已经提交的退货单
	 * @author
	 * @date 2018/5/15
	 * @param
	 * @return
	 */
	@RequestMapping("getSubmitReturn")
	@ResponseBody
	public Pagination getSubmitOrder() {
		Pagination pagination = new Pagination(this.getRequest());
		pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
		try {
			pagination = yimiaoPurchaseReturnManager.getSubmitReturn(pagination);
		} catch (Exception e) {
			log.error("Failed to getSubmitOrder", e);
		}
		return pagination;
	}

	/**
	 * 退货审核详情页面跳转
	 * @author
	 * @date 2018/5/15
	 * @param
	 * @return
	 */
	@RequestMapping("toCheckReturnDetails")
	public String toCheckReturnDetails(Model model,String orderId) {
		model.addAttribute("orderId", orderId);
		return MODEL_PATH + "checkReturnDetails";
	}

	/**
	 * 退货单审核
	 * @author
	 * @date 2018/5/15
	 * @param
	 * @return
	 */
	@RequestMapping("checkReturn")
	@ResponseBody
	public Pagination checkReturn(String data,Integer status) {
		Pagination pagination = new Pagination(this.getRequest());
		try {
			Gson gson = new Gson();
			Type type = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, String>> list = gson.fromJson(data, type);
			pagination.getConditions().put("list",list);
			pagination.getConditions().remove("data");
			yimiaoPurchaseReturnManager.updateByIdForAudit(pagination);
			pagination.setSuccess(true);
		} catch (Exception e) {
			pagination.setSuccess(false);
			pagination.setMsg("操作异常，请联系管理员！");
			log.error("Failed to checkReturn", e);
		}
		return pagination;
	}


	@RequestMapping(value ="/addYimiaoPurchaseReturn" )
	@ResponseBody
	public Pagination addYimiaoPurchaseReturn(YimiaoPurchaseReturnForm yimiaoPurchaseReturnForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPurchaseReturn yimiaoPurchaseReturn = new YimiaoPurchaseReturn();
		formToModel(yimiaoPurchaseReturnForm, yimiaoPurchaseReturn);
		// TODO 其他信息
		
		yimiaoPurchaseReturnManager.add(yimiaoPurchaseReturn);
		pagination.setSuccess(true);
		return pagination;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, java.lang.String retOrderId) {
		YimiaoPurchaseReturn yimiaoPurchaseReturn = yimiaoPurchaseReturnManager.getById(retOrderId);
		YimiaoPurchaseReturnForm yimiaoPurchaseReturnForm = new YimiaoPurchaseReturnForm();
		modelToForm(yimiaoPurchaseReturn, yimiaoPurchaseReturnForm);
		
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPurchaseReturnForm.class));
		model.addAttribute("yimiaoPurchaseReturnForm", yimiaoPurchaseReturnForm);
		return MODEL_PATH + "update";
	}
	
	@RequestMapping(value ="/updateYimiaoPurchaseReturn" )
	@ResponseBody
	public Pagination updateYimiaoPurchaseReturn(YimiaoPurchaseReturnForm yimiaoPurchaseReturnForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPurchaseReturn yimiaoPurchaseReturn = yimiaoPurchaseReturnManager.getById(yimiaoPurchaseReturnForm.getRetOrderId());
		BeanTool.copyProperties(yimiaoPurchaseReturnForm, yimiaoPurchaseReturn);// TODO null拷贝问题
		
		yimiaoPurchaseReturnManager.updateById(yimiaoPurchaseReturn);
		pagination.setSuccess(true);
		return pagination;
	}

	/**
	 * 退货单审核记录
	 * @author ZhuMingYuan
	 * @date 2018/5/30
	 * @param
	 * @return
	 */
	@RequestMapping("toReturnOrderCheckList")
	public String toOrderChackList() {
		return MODEL_PATH + "returnOrderCheckList";
	}

	/**
     * 获取退货单审核记录
	 * @author ZhuMingYuan
	 * @date 2018/5/30
	 * @param
	 * @return
	 */
    @RequestMapping("getReturnOrderData")
    @ResponseBody
    public Pagination getReturnOrderData() {
        Pagination pagination = new Pagination(this.getRequest());
        pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
        try {
            pagination = yimiaoPurchaseReturnManager.getReturnOrderData(pagination);
        } catch (Exception e) {
            log.error("Failed to getSubmitOrder", e);
        }
        return pagination;
    }

    /**
     * 退货审核记录详情页面跳转
     * @author
     * @date 2018/5/15
     * @param
     * @return
     */
    @RequestMapping("toCheckReturnDetailList")
    public String toCheckReturnDetailList(Model model,String orderId) {
        model.addAttribute("orderId", orderId);
        return MODEL_PATH + "checkReturnDetailList";
    }
}