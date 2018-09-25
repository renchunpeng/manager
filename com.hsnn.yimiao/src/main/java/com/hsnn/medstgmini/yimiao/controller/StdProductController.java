package com.hsnn.medstgmini.yimiao.controller;

import com.hsnn.medstgmini.base.std.model.StdProduct;
import com.hsnn.medstgmini.base.std.service.StdProductManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.hsnn.medstgmini.yimiao.form.StdProductForm;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(StdProductController.ACTION_PATH)
public class StdProductController extends GenericController {
	private static final Logger log = Logger.getLogger(StdProductController.class);
	protected static final String ACTION_PATH="/stdProduct";
	protected static final String MODEL_PATH="/yimiao/stdProduct/";// TODO 修改
	@Autowired
	private StdProductManager stdProductManager;
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("getStdProductData")
	@ResponseBody
	public Pagination getStdProductData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = stdProductManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getStdProductData", e);
		}
		return pagination;
	}
	
	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(StdProductForm.class));
		return MODEL_PATH + "add";
	}
	
	@RequestMapping(value ="/addStdProduct" )
	@ResponseBody
	public Pagination addStdProduct(StdProductForm stdProductForm){
		Pagination pagination = new Pagination(this.getRequest());
		StdProduct stdProduct = new StdProduct();
		formToModel(stdProductForm, stdProduct);
		// TODO 其他信息
		
		stdProductManager.add(stdProduct);
		pagination.setSuccess(true);
		return pagination;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, Integer productId) {
		StdProduct stdProduct = stdProductManager.getById(productId);
		StdProductForm stdProductForm = new StdProductForm();
		modelToForm(stdProduct, stdProductForm);
		
		model.addAttribute("validate", ValidateUtil.getValidate(StdProductForm.class));
		model.addAttribute("stdProductForm", stdProductForm);
		return MODEL_PATH + "update";
	}
	
	@RequestMapping(value ="/updateStdProduct" )
	@ResponseBody
	public Pagination updateStdProduct(StdProductForm stdProductForm){
		Pagination pagination = new Pagination(this.getRequest());
		StdProduct stdProduct = stdProductManager.getById(stdProductForm.getProductId());
		BeanTool.copyProperties(stdProductForm, stdProduct);// TODO null拷贝问题
		
		stdProductManager.updateById(stdProduct);
		pagination.setSuccess(true);
		return pagination;
	}

	@RequestMapping("addFirstPro")
	public String addFirstPro() {
		return MODEL_PATH + "firstPro";
	}

	@RequestMapping(value ="/addProduct" )
	@ResponseBody
	public Pagination addProduct(StdProductForm stdProductForm){
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user=getSysUser();
		List<StdProduct> listOne = stdProductManager.getListByName(stdProductForm.getProductName());
		StdProduct stdProduct = new StdProduct();
		formToModel(stdProductForm, stdProduct);

		if(null != listOne&&listOne.size()>0) {
			pagination.setSuccess(false);
			pagination.setMsg("该一级目录已存在！请重新填写一级目录！");
			return pagination;
		}
		// TODO 其他信息
		stdProduct.setAddTime(new Date());
		stdProduct.setAddUserId(user.getOrgId());
		stdProduct.setAddUserName(user.getName());
		stdProductManager.saveStdPro(stdProduct);
		pagination.setSuccess(true);
		return pagination;
	}

}