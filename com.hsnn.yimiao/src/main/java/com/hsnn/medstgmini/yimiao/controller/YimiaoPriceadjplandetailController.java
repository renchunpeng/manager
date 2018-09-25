package com.hsnn.medstgmini.yimiao.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsnn.medstgmini.yimiao.service.YimiaoPriceadjplandetailManager;

import com.hsnn.medstgmini.yimiao.form.YimiaoPriceadjplandetailForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoPriceadjplandetail;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;

@Controller
@RequestMapping(YimiaoPriceadjplandetailController.ACTION_PATH)
public class YimiaoPriceadjplandetailController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoPriceadjplandetailController.class);
	protected static final String ACTION_PATH="/yimiaoPriceadjplandetail";
	protected static final String MODEL_PATH="/yimiao/yimiaoPriceadjplandetail/";// TODO 修改
	@Autowired
	private YimiaoPriceadjplandetailManager yimiaoPriceadjplandetailManager;
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("getYimiaoPriceadjplandetailData")
	@ResponseBody
	public Pagination getYimiaoPriceadjplandetailData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = yimiaoPriceadjplandetailManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoPriceadjplandetailData", e);
		}
		return pagination;
	}
	
	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPriceadjplandetailForm.class));
		return MODEL_PATH + "add";
	}
	
	@RequestMapping(value ="/addYimiaoPriceadjplandetail" )
	@ResponseBody
	public Pagination addYimiaoPriceadjplandetail(YimiaoPriceadjplandetailForm yimiaoPriceadjplandetailForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPriceadjplandetail yimiaoPriceadjplandetail = new YimiaoPriceadjplandetail();
		formToModel(yimiaoPriceadjplandetailForm, yimiaoPriceadjplandetail);
		// TODO 其他信息
		
		yimiaoPriceadjplandetailManager.add(yimiaoPriceadjplandetail);
		pagination.setSuccess(true);
		return pagination;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, String priceAdjPalnDetailId) {
		YimiaoPriceadjplandetail yimiaoPriceadjplandetail = yimiaoPriceadjplandetailManager.getById(priceAdjPalnDetailId);
		YimiaoPriceadjplandetailForm yimiaoPriceadjplandetailForm = new YimiaoPriceadjplandetailForm();
		modelToForm(yimiaoPriceadjplandetail, yimiaoPriceadjplandetailForm);
		
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoPriceadjplandetailForm.class));
		model.addAttribute("yimiaoPriceadjplandetailForm", yimiaoPriceadjplandetailForm);
		return MODEL_PATH + "update";
	}
	
	@RequestMapping(value ="/updateYimiaoPriceadjplandetail" )
	@ResponseBody
	public Pagination updateYimiaoPriceadjplandetail(YimiaoPriceadjplandetailForm yimiaoPriceadjplandetailForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoPriceadjplandetail yimiaoPriceadjplandetail = yimiaoPriceadjplandetailManager.getById(yimiaoPriceadjplandetailForm.getPriceAdjPalnDetailId());
		BeanTool.copyProperties(yimiaoPriceadjplandetailForm, yimiaoPriceadjplandetail);// TODO null拷贝问题
		
		yimiaoPriceadjplandetailManager.updateById(yimiaoPriceadjplandetail);
		pagination.setSuccess(true);
		return pagination;
	}
}