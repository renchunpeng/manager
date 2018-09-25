package com.hsnn.medstgmini.yimiao.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailLogManager;

import com.hsnn.medstgmini.yimiao.form.YimiaoOrderdetailLogForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailLog;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;

@Controller
@RequestMapping(YimiaoOrderdetailLogController.ACTION_PATH)
public class YimiaoOrderdetailLogController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoOrderdetailLogController.class);
	protected static final String ACTION_PATH="/yimiaoOrderdetailLog";
	protected static final String MODEL_PATH="/yimiao/yimiaoOrderdetailLog/";// TODO 修改
	@Autowired
	private YimiaoOrderdetailLogManager yimiaoOrderdetailLogManager;
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("getYimiaoOrderdetailLogData")
	@ResponseBody
	public Pagination getYimiaoOrderdetailLogData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = yimiaoOrderdetailLogManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderdetailLogData", e);
		}
		return pagination;
	}
	
	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoOrderdetailLogForm.class));
		return MODEL_PATH + "add";
	}
	
	@RequestMapping(value ="/addYimiaoOrderdetailLog" )
	@ResponseBody
	public Pagination addYimiaoOrderdetailLog(YimiaoOrderdetailLogForm yimiaoOrderdetailLogForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoOrderdetailLog yimiaoOrderdetailLog = new YimiaoOrderdetailLog();
		formToModel(yimiaoOrderdetailLogForm, yimiaoOrderdetailLog);
		// TODO 其他信息
		
		yimiaoOrderdetailLogManager.add(yimiaoOrderdetailLog);
		pagination.setSuccess(true);
		return pagination;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, java.lang.String orderdetailId) {
		YimiaoOrderdetailLog yimiaoOrderdetailLog = yimiaoOrderdetailLogManager.getById(orderdetailId);
		YimiaoOrderdetailLogForm yimiaoOrderdetailLogForm = new YimiaoOrderdetailLogForm();
		modelToForm(yimiaoOrderdetailLog, yimiaoOrderdetailLogForm);
		
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoOrderdetailLogForm.class));
		model.addAttribute("yimiaoOrderdetailLogForm", yimiaoOrderdetailLogForm);
		return MODEL_PATH + "update";
	}
	
	@RequestMapping(value ="/updateYimiaoOrderdetailLog" )
	@ResponseBody
	public Pagination updateYimiaoOrderdetailLog(YimiaoOrderdetailLogForm yimiaoOrderdetailLogForm){
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoOrderdetailLog yimiaoOrderdetailLog = yimiaoOrderdetailLogManager.getById(yimiaoOrderdetailLogForm.getOrderdetailId());
		BeanTool.copyProperties(yimiaoOrderdetailLogForm, yimiaoOrderdetailLog);// TODO null拷贝问题
		
		yimiaoOrderdetailLogManager.updateById(yimiaoOrderdetailLog);
		pagination.setSuccess(true);
		return pagination;
	}
}