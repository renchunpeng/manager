package com.hsnn.medstgmini.webbook.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsnn.medstgmini.webbook.service.UserBookListManager;

import com.hsnn.medstgmini.webbook.form.UserBookListForm;
import com.hsnn.medstgmini.webbook.model.UserBookList;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.validate.ValidateUtil;

@Controller
@RequestMapping(UserBookListController.ACTION_PATH)
public class UserBookListController extends GenericController {
	private static final Logger log = Logger.getLogger(UserBookListController.class);
	protected static final String ACTION_PATH="/userBookList";
	protected static final String MODEL_PATH="/webbook/userBookList/";// TODO 修改
	@Autowired
	private UserBookListManager userBookListManager;
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("getUserBookListData")
	@ResponseBody
	public Pagination getUserBookListData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = userBookListManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getUserBookListData", e);
		}
		return pagination;
	}
	
	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(UserBookListForm.class));
		return MODEL_PATH + "add";
	}
	
	@RequestMapping(value ="/addUserBookList" )
	@ResponseBody
	public Pagination addUserBookList(UserBookListForm userBookListForm){
		Pagination pagination = new Pagination(this.getRequest());
		UserBookList userBookList = new UserBookList();
		formToModel(userBookListForm, userBookList);
		// TODO 其他信息
		
		userBookListManager.add(userBookList);
		pagination.setSuccess(true);
		return pagination;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, java.lang.String id) {
		UserBookList userBookList = userBookListManager.getById(id);
		UserBookListForm userBookListForm = new UserBookListForm();
		modelToForm(userBookList, userBookListForm);
		
		model.addAttribute("validate", ValidateUtil.getValidate(UserBookListForm.class));
		model.addAttribute("userBookListForm", userBookListForm);
		return MODEL_PATH + "update";
	}
	
	@RequestMapping(value ="/updateUserBookList" )
	@ResponseBody
	public Pagination updateUserBookList(UserBookListForm userBookListForm){
		Pagination pagination = new Pagination(this.getRequest());
		UserBookList userBookList = userBookListManager.getById(userBookListForm.getId());
		BeanTool.copyProperties(userBookListForm, userBookList);// TODO null拷贝问题
		
		userBookListManager.updateById(userBookList);
		pagination.setSuccess(true);
		return pagination;
	}
}