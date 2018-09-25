package com.hsnn.medstgmini.common.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.std.enums.BankAuditFirstState;
import com.hsnn.medstgmini.base.std.enums.BankAuditSecondState;
import com.hsnn.medstgmini.base.std.form.StdDictForm.First;
import com.hsnn.medstgmini.base.std.form.StdPayContractForm;
import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.model.StdCompany;
import com.hsnn.medstgmini.base.std.model.StdCompanys;
import com.hsnn.medstgmini.base.std.model.StdHospital;
import com.hsnn.medstgmini.base.std.model.StdHospitals;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.std.model.StdPayContract;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.base.std.service.StdCompanyManager;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.std.service.StdManageOrgManager;
import com.hsnn.medstgmini.base.std.service.StdPayContractManager;
import com.hsnn.medstgmini.base.sys.dao.SysRoleDao;
import com.hsnn.medstgmini.base.sys.dao.SysRoleResourceDao;
import com.hsnn.medstgmini.base.sys.enums.AcctType;
import com.hsnn.medstgmini.base.sys.enums.HospLevelEnum;
import com.hsnn.medstgmini.base.sys.enums.SysChangelogOperateType;
import com.hsnn.medstgmini.base.sys.enums.SysOprationLogOprateType;
import com.hsnn.medstgmini.base.sys.enums.YesOrNo;
import com.hsnn.medstgmini.base.sys.form.SysUserDePostForm;
import com.hsnn.medstgmini.base.sys.form.SysUserForm;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysPost;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.model.SysUserDepartPost;
import com.hsnn.medstgmini.base.sys.service.ISysChangeLog;
import com.hsnn.medstgmini.base.sys.service.ISysDepartmentManager;
import com.hsnn.medstgmini.base.sys.service.ISysOperationLog;
import com.hsnn.medstgmini.base.sys.service.ISysPostManager;
import com.hsnn.medstgmini.base.sys.service.ISysRole;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.base.sys.service.SysDateManager;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.AccountUtil;
import com.hsnn.medstgmini.util.AreaUtil;
import com.hsnn.medstgmini.util.BeanTool;
import com.hsnn.medstgmini.util.DbUtil;
import com.hsnn.medstgmini.util.GetComputerInfo;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;
import com.hsnn.medstgmini.util.form.SelectForm;
import com.hsnn.medstgmini.util.validate.ValidateUtil;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompany;
import com.hsnn.medstgmini.yimiao.service.YimiaoCompanyManager;

/**
 * @category 用户控制层
 * @author 韩守松
 * @date 2016年2月19日
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends GenericController{

	private static final Logger log = Logger.getLogger(SysUserController.class);
	
	@Autowired
	private StdManageOrgManager stdManageOrgManager;
	@Autowired
	private YimiaoCompanyManager yimiaoCompanyManager;
	@Autowired
	private ISysUser sysUserManager;
	@Autowired
	private StdCompanyManager stdCompanyManager;
	@Autowired
	private StdHospitalManager 	stdHospitalManager;
	@Autowired
	private ISysPostManager zxMinSysPostManager;
	@Autowired
	private ISysRole sysRoleManager;
	@Autowired
	private ISysDepartmentManager sysDepartmentManager;
	@Autowired
	private StdPayContractManager stdPayContractManager;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private StdAreaManager stdAreaManger;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleResourceDao  sysRoleResourceDao;
	/*@Value("${system.province}")*/
    private String sysProvince  = "530000";
    @Autowired
	private ISysOperationLog sysOperationLogManager;
	@Autowired
	private ISysChangeLog sysChangeLogManager;
	@Autowired
	private SysDateManager sysDateManager;
	@Value("${system.sysId}")
	private String sysId;
	@Value("${username.login.address}")
	private String url;
    
	/**
	 * @category 跳转到基础库部门用户信息列表页面
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @return
	 */
	@RequestMapping("/toSysUserJsp")
	public String toSysDepartmentJsp(Model model){
		model.addAttribute("validate", ValidateUtil.getValidate(SysUserDepartPost.class));
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		model.addAttribute("orgId", user.getOrgId());//机构id
		model.addAttribute("departmentId",user.getDepartmentId());//部门id
		return "/base/sys/sysUser/sysUser";
	}
	
	/**
	 * @category 用户信息查看页面
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @return
	 */
	@RequestMapping("/toSysUserListJsp")
	public String toSysUserListJsp(Model model){
		model.addAttribute("validate", ValidateUtil.getValidate(SysUserDepartPost.class));
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		model.addAttribute("orgId", user.getOrgId());//机构id
		model.addAttribute("departmentId",user.getDepartmentId());//部门id
		return "/base/sys/sysUser/sysUserList";
	}
	/**
	 * @category 获取部门用户表中数据
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @return
	 */
	@RequestMapping("/getSysUserData" )
	@ResponseBody
	public Pagination getUserData(){
		Pagination page = new Pagination(request);
		
		try {
			String name = request.getParameter("name");
			if(StringUtils.isNotBlank(name)){
				page.getConditions().put("name",name);
			}
			String groupName = request.getParameter("groupName");
			if(StringUtils.isNotBlank(groupName)){
				page.getConditions().put("departmentName",groupName);
			}
			String postName = request.getParameter("postName");
			if(StringUtils.isNotBlank(postName)){
				page.getConditions().put("postName",postName);
			}
			
			page.getConditions().put("acctType", AcctType.BUSINESS_ACCOUNT.getKey());
			String pageStr = sysUserManager.getSysUserManager(page);
			page = JSONObject.parseObject(pageStr, Pagination.class);
		} catch (Exception e) {
			log.error("Failed to sear area", e);
		}
		return page;
	}
	
	/**
	 * @category 部门数据拉取
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @return
	 */
	@RequestMapping(value = "/getDepartment")
	@ResponseBody
	public List<SelectForm> getdepartment() {
		String departmentId = request.getParameter("ID");
		SysDepartment department = new SysDepartment();
		if(StringUtils.isNotBlank(departmentId)){
			department.setDepartmentId(Integer.valueOf(departmentId));
		}
		List<SysDepartment> list = sysUserManager.findDepartmentIdAndName(department);
		
		List<SelectForm> slist = new ArrayList<SelectForm>();
		for (int i = 0; i < list.size(); i++) {
			SysDepartment data = list.get(i);
			SelectForm form = new SelectForm();
			form.setValue(data.getDepartmentId().toString());
			form.setText(data.getGroupName());
			slist.add(form);
		}
		return slist;
	}
	
	/**
	 * @category 岗位拉取
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @return
	 */
	@RequestMapping(value = "/getPost")
	@ResponseBody
	public List<SelectForm> getPost() {
		String postId = request.getParameter("ID");
		SysPost post = new SysPost();
		if(StringUtils.isNotBlank(postId)){
			post.setDepartmentId(Integer.valueOf(postId));
		}
		List<SysPost> list = zxMinSysPostManager.findAllPostIdAndName(post);
		
		List<SelectForm> slist = new ArrayList<SelectForm>();
		for (int i = 0; i < list.size(); i++) {
			SysPost data = list.get(i);
			SelectForm form = new SelectForm();
			form.setValue(data.getPostId().toString());
			form.setText(data.getPostName());
			slist.add(form);
		}
		return slist;
	}
	
	
	
	/**
	 * @category 校验用户名是否存在
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param userName
	 * @param  @return
	 */
	@RequestMapping("/testSysUserName")
	@ResponseBody
	public Pagination testSysUserName(String userName){
		Pagination page = new Pagination();
		page.setSuccess(sysUserManager.testSysUserName(userName));
		return page;
	}
	

	/**
	 * @category 跳转到启用/停用页面 
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @return
	 */
	@RequestMapping("/toUserStartOrStop")
	public String toStartJsp(Integer num,Model model){
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		model.addAttribute("orgId", user.getOrgId());//机构id
		model.addAttribute("departmentId",user.getDepartmentId());//部门id
		if(num == 1){
			return "/base/sys/sysUser/userStart";
		}else{
			return "/base/sys/sysUser/userStop";
		}
	}
	
	/**
	 * @category 获取启用用户的数据
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @return
	 */
	@RequestMapping("/getStartData")
	@ResponseBody
	public Pagination getStartData(){
		Pagination page = new Pagination(request);
		try {
			String name = request.getParameter("name");
			if(StringUtils.isNotBlank(name)){
				page.getConditions().put("name",name);
			}
			String groupName = request.getParameter("groupName");
			if(StringUtils.isNotBlank(groupName)){
				page.getConditions().put("departmentName",groupName);
			}
			String postName = request.getParameter("postName");
			if(StringUtils.isNotBlank(postName)){
				page.getConditions().put("postName",postName);
			}
			page.getConditions().put("acctType", AcctType.BUSINESS_ACCOUNT.getKey());
			String pageStr = sysUserManager.getSysUserStartData(page);
			page = JSONObject.parseObject(pageStr, Pagination.class);
		} catch (Exception e) {
			log.error("Failed to sear area", e);
		}
		return page;
	}
	
	/**
	 * @category 获取停用用用户的数据
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @return
	 */
	@RequestMapping("/getStopData")
	@ResponseBody
	public Pagination getStopData(){
		Pagination page = new Pagination(request);
		try {
			String name = request.getParameter("name");
			if(StringUtils.isNotBlank(name)){
				page.getConditions().put("name",name);
			}
			String groupName = request.getParameter("groupName");
			if(StringUtils.isNotBlank(groupName)){
				page.getConditions().put("departmentName",groupName);
			}
			String postName = request.getParameter("postName");
			if(StringUtils.isNotBlank(postName)){
				page.getConditions().put("postName",postName);
			}
			/*//判断是部门管理员账号还是机构 TODO
			SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
			if(isAdministratorAccount(user)){	//是部门管理员账号
				page.getConditions().put("departmentId",user.getDepartmentId());
				page.getConditions().put("acctType",user.getAcctType());
			}else if(null==user.getDepartmentId() && !StringTool.isEmpty(user.getOrgId())){
				page.getConditions().put("orgId",user.getOrgId());//机构
			}*/
			page.getConditions().put("acctType", AcctType.BUSINESS_ACCOUNT.getKey());
			String pageStr = sysUserManager.getSysUserStopData(page);
			page = JSONObject.parseObject(pageStr, Pagination.class);
		} catch (Exception e) {
			log.error("Failed to sear area", e);
		}
		return page;
	}
	
	/**
	 * 判断是用户是否是部门管理员账号
	 * @param user
	 * */
	protected boolean isAdministratorAccount(SysUser user){
		if(null!=user.getDepartmentId() && user.getAcctType().equals(AcctType.ADMINISTRATOR_ACCOUNT.getKey())){
			return true;
		}
		return false;
	}
	
	/**
	 * @category 更新用户表中状态（批量）
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param state
	 * @param  @param param
	 * @param  @return
	 */
	@RequestMapping(value={"/updateSysUserIsUsingStart","/updateSysUserIsUsingStop"})
	@ResponseBody
	public Pagination updateSysUserIsUsing(Integer state,String param){
		Pagination page = new Pagination(request);
		log.info("params = " + param + ", state=" + state);
		try {
			SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
			if(user != null){
				String[] ids = param.split(",");
				int operCount = 0;
				for(int i = 0; i < ids.length; i++){
					SysUser sysUser = new SysUser();
					sysUser.setUserId(ids[i]);
					sysUser.setIsUsing(state);
					sysUser.setLastUpdateUserId(user.getUserId());
					sysUser.setLastUpdateUserName(user.getUserName());
					operCount += sysUserManager.updateSysUserIsUsing(sysUser);
				}
				
				if(state == 0) {
					/**********************************插入日志**********************************/
					saveLog(ids,"用户停用",SysOprationLogOprateType.OPERATION_FORBIDDEN.getKey(),SysChangelogOperateType.OPERATION_FORBIDDEN.getKey());
				}else {
					/**********************************插入日志**********************************/
					saveLog(ids,"用户启用",SysOprationLogOprateType.OPERATION_STARTUSE.getKey(),SysChangelogOperateType.OPERATION_STARTUSE.getKey());
				}
				
				page.setOperCount(operCount);
				page.setSuccess(true);
			}
		} catch (NumberFormatException e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		
		return page;
	}
	
	
	
	/**
	 * @category 跳转到支付信息页面
	 * @author 林洋
	 * @date   2016年4月26日
	 * @param  @param userId
	 * @param  @return
	 */
	@RequestMapping("/toSysUserPaymentData")
	public String toSysUserPaymentData(Model model){
		SysUser user = (SysUser) this.getSysUser();
		int userType = user.getUserType();
		SysUserDepartPost userMap = new SysUserDepartPost();	
		if (userType == UserType.scqy.getKey()) {// 企业
			StdCompany org = stdCompanyManager.getById(user.getOrgId()); 
			userMap.setOrgName(org.getCompanyName());
			userMap.setOrgAreaName(org.getAreaName());
			userMap.setOrgAddress(org.getAddress());
			model.addAttribute("org",org);
		}else {// 医疗机构
			StdHospital org = stdHospitalManager.getById(user.getOrgId());
			userMap.setOrgName(org.getHospitalName());
			userMap.setOrgAreaName(org.getAreaName());
			userMap.setOrgAddress(org.getHospitalAddress());
			model.addAttribute("org",org);
		}
		StdPayContract stdPay = stdPayContractManager.getById(user.getOrgId());
		if(stdPay == null){
			stdPay = new StdPayContract();
		}
		model.addAttribute("stdPay",stdPay);
		userMap.setUserName(user.getUserName());
		userMap.setName(user.getName());
		model.addAttribute("userMap",userMap);
		model.addAttribute("userType",userType);
		model.addAttribute("validate", ValidateUtil.getValidate(StdPayContractForm.class));
		return "/base/sys/sysUser/userPayment";
	}
	
	/**
	 * @category 跳转到用户详情页面
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param userId
	 * @param  @return
	 */
	@RequestMapping("/toSysUserInfo")
	public String toSysUserInfo(String userId){
		SysUserDepartPost userMap = sysUserManager.querySysUserDataById(userId);
		Map<String,Object> map = new HashMap<String, Object>();
		String orgName = "";
		String orgAddress = "";
		String orgAreaName = "";
		if(userMap != null){
			if(null != userMap.getDepartmentId()){
				SysDepartment Department = sysDepartmentManager.getDepartmentById(userMap.getDepartmentId());
				if(Department != null){
					if(Department.getDepartmentType() == 1 || Department.getDepartmentType() == 2 || Department.getDepartmentType() == 3 ){
						map =sysRoleManager.getOrgCompDataById(Department.getOrgId());
						orgName = map.get("org_name").toString();
						if(map.get("org_address")!=null&&!map.get("org_address").equals("")){
							orgAddress = map.get("org_address").toString();
						}
						orgAreaName = map.get("org_area_name").toString();
					}else if(Department.getDepartmentType() == 4){
						map =sysRoleManager.getOrgHospDataById(Department.getOrgId());
						orgName = map.get("org_name").toString();
						if(map.get("org_address")!=null&&!map.get("org_address").equals("")){
							orgAddress = map.get("org_address").toString();
						}
						orgAreaName = map.get("org_area_name").toString();
					}else if(Department.getDepartmentType() == 5 || Department.getDepartmentType() == 6){
						StdManageOrg stdManageOrg  = SessionUtil.getSysUser().getStdManageOrg();
						orgName =stdManageOrg.getHeaBurName();
						orgAddress = stdManageOrg.getOrgAddress();
						StdArea stdArea = stdAreaManger.getAreaById(stdManageOrg.getAreaId());
						orgAreaName = stdArea.getAreaName();
					}
				}
			}
		}
		userMap.setOrgName(orgName);
		userMap.setOrgAddress(orgAddress);
		userMap.setOrgAreaName(orgAreaName);
		request.setAttribute("userMap",userMap);
		return "/base/sys/sysUser/userInfo";
	}
	
	@RequestMapping("/updateSysUserDate")
	@ResponseBody
	public Pagination updateSysUserDate(@Valid SysUserDePostForm form,BindingResult result){
		Pagination page = new Pagination();
		log.info("SysUserForm = " + form);
		try {
			SysUser user =  sysUserManager.findSysUserDataById(form.getUserId());
			user.setLastUpdateUserId(SessionUtil.getSysUser().getUserId());
			user.setLastUpdateUserName(new StringBuffer(SessionUtil.getSysUser().getName()).append("(").append(SessionUtil.getSysUser().getUserName()).append(")").toString());
			user.setName(form.getName());
			user.setEmail(form.getEmail());
			user.setPhone(form.getPhone());
			user.setIsBalance(form.getIsBalance());
			if(result.hasErrors()) {
				page.setMsg("验证不通过!");
				page.setSuccess(false);
				return page;
			}
			sysUserManager.updateSysUserDepartPost(user,page);
			page.setSuccess(true);
			/**********************************插入日志**********************************/
			saveLog(new String[]{user.getUserId()},"用户信息修改",SysOprationLogOprateType.OPERATION_MODIFY.getKey(),SysChangelogOperateType.OPERATION_MODIFY.getKey());
			
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
	}
    /**
	 * 
	 *@category 中心查看医院用户
	 *@author 应晓川
	 *@date 2016年2月19日16:37:41
	 *@return
	 */
	@RequestMapping("/toUserListByHosp")
	public String toUserListByHosp(Model model){
		model.addAttribute("sysProvince", "530000");
		model.addAttribute("sysProvinceName", "云南");
		request.setAttribute("level", HospLevelEnum.values());
		return "/base/sys/sysUser/userListByHosp";
	}
	@RequestMapping("/getUserListByHosp" )
	@ResponseBody
	public Pagination getUserListByHosp(){
		Pagination page = new Pagination(request);
		try {
			DbUtil.jsonToMap(request, page);
			Object area2 = page.getConditions().get("area2");
			Object area3 = page.getConditions().get("area3");
			page.getConditions().put("areaId", AreaUtil.getAreaStartCode("33",area2==null?"":area2.toString(), area3==null?"":area3.toString()));
			sysUserManager.getUserListByHosp(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	
	/**
	 * 
	 *@category 中心查看企业用户
	 *@author 应晓川
	 *@date 2016年2月19日16:41:19
	 *@return
	 */
	@RequestMapping("/toUserListByComp")
	public String toUserListByComp(){
		return "/base/sys/sysUser/userListByComp";
	}
	@RequestMapping("/getUserListByComp" )
	@ResponseBody
	public Pagination getUserListByComp(){
		Pagination page = new Pagination(request);
		try {
			DbUtil.jsonToMap(request, page);
			String areaId = AreaUtil.escapeAreaId(page.getConditions().get("areaId")==null?"":page.getConditions().get("areaId").toString());
			page.getConditions().put("areaId", areaId);
			sysUserManager.getUserListByComp(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	
	/**
	 * 
	 *@category 中心查看监管用户
	 *@author 应晓川
	 *@date 2016年2月19日16:41:39
	 *@return
	 */
	@RequestMapping("/toUserListBySupervision")
	public String toUserListBySupervision(Model model){
		StdArea dicArea = stdAreaManger.getAreaByAreaId(sysProvince);
		model.addAttribute("sysProvinceName", dicArea.getAreaName());
		model.addAttribute("sysProvince", sysProvince);
		return "/base/sys/sysUser/userListBySupervision";
	}
	@RequestMapping("/getUserListBySupervision" )
	@ResponseBody
	public Pagination getUserListBySupervision(){
		Pagination page = new Pagination(request);
		try {
			String provId = request.getParameter("area1");
			String cityId = request.getParameter("area2");
			String townId = request.getParameter("area3");
			String areaId = provId;
			if (StringUtils.isNotBlank(townId)) {
				areaId = townId;
			} else if (StringUtils.isNotBlank(cityId)) {
				areaId = cityId.replaceAll("0*$", "");
			} else if (StringUtils.isNotBlank(provId)) {
				areaId = provId.replaceAll("0*$", "");
			} else {
				areaId = "";
			}
			page.getConditions().put("areaId", areaId+"%");
			//DbUtil.jsonToMap(request, page);
			//page.getConditions().put("areaId", AreaUtil.getAreaStartCode(page.getConditions().get("area1").toString(), page.getConditions().get("area2").toString(), page.getConditions().get("area3").toString()));
			sysUserManager.getUserListBySupervision(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	/**
	 * @category 跳转到密码修改页面
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @return
	 */
	@RequestMapping("/toUpdateUserPassWordJsp")
	public String toUpdateUserPassWordJsp(){
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		request.setAttribute("userId", user.getUserId());
		return "/base/sys/sysUser/userResetPsw";
	}
	/**
	 * @category 修改用户密码
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @return
	 */
	@RequestMapping("/updateSysUserPassword")
	@ResponseBody
	public Pagination updateSysUserPassword(SysUserForm form){
		Pagination page = new Pagination(request);
		try {
			SysUser user = this.getSysUser();//当前用户
				if(user != null){
					if(form != null){
						if(StringUtils.isBlank(form.getUserId())){
							page.setSuccess(false);
							page.setMsg("您所用的Id不存在");
							return page;
						}
						String encodedPwd = DigestUtils.md5Hex(request.getParameter("oldPassword"));
						if(!encodedPwd.equals(user.getUserPassword())){
							page.setSuccess(false);
							page.setMsg("旧密码不正确！");
							return page;
						}
						form.setUserType(user.getUserType());
						form.setUserPassword(DigestUtils.md5Hex(form.getUserPassword()));
						form.setLastUpdateUserId(user.getUserId());
						form.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
					}
				sysUserManager.updateSysUserPassWordById(form);
				page.setSuccess(true);
			}
		} catch (Exception e) {
			log.error("",e);
		}
		return page;
	}
	
	
	/**
	 * @category 去用户权限树列表
	 * @author 应晓川
	 * @date   2016年2月23日18:39:47
	 * @param  @return
	 */
	@RequestMapping(value={"/toResource","/toResourceOne","/toResourceTwo"})
	public String toJgDepartmentResource(){
		try {
			request.setAttribute("userId", request.getParameter("userId"));
			request.setAttribute("postId", request.getParameter("postId"));
		} catch (NumberFormatException e) {
			log.error("", e);
		}
		return "/base/sys/sysUser/userResourceTree";
	}
	
	
	/**
	 * @category 跳转用户权限管理页面
	 * @author wangbing
	 * @date   2016年2月19日
	 * @param  @return
	 */
	@RequestMapping("/toUserResourceEdit")
	public String toUserResourceEdit(Model model){
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		model.addAttribute("orgId", user.getOrgId());//机构id
		model.addAttribute("departmentId",user.getDepartmentId());//部门id
		return "/base/sys/sysUser/userResourceEdit";
	}
	
	/**
	 * 
	 *@category 获取用户列表
	 *@author wangbing
	 *@date 2016年2月23日18:44:22
	 *@return
	 */
	@RequestMapping("/getUserList")
	@ResponseBody
	public Pagination getUserList(){
		Pagination page = new Pagination(request);
		try {
			SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
			page.getConditions().put("departmentId", user.getDepartmentId()+"");
			page.getConditions().put("acctType", AcctType.BUSINESS_ACCOUNT.getKey());
			String pageStr = sysUserManager.getUserList(page);
			page = JSONObject.parseObject(pageStr, Pagination.class);
		} catch (Exception e) {
			log.error("", e);
		}
		return page;
	}
	
	/**
	 * @category 跳转用户权限集合页面
	 * @author wangbing
	 * @date   2016年2月19日
	 * @param  @return
	 */
	@RequestMapping("/toUserResource")
	public String toUserResource(Model model){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("userId", request.getParameter("userId"));
		data.put("departmentId", request.getParameter("departmentId"));
		String postId = request.getParameter("postId");
		if (postId.equals("undefined")) {
			postId = "";
		}
		data.put("postId", postId);
		data.put("saveUrl", "/sysUser/saveUserResource.html");
		data.put("getUrl", "/sysUser/getUserResource.html");
		Object jsonObj = JSONObject.toJSON(data);
		SysPost post = new SysPost();
		post.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
		List<SysPost> listPost = zxMinSysPostManager.findAllPostIdAndName(post);
		model.addAttribute("list", listPost);
		model.addAttribute("jsonObj", jsonObj);
		model.addAttribute("postId", data.get("postId"));
		model.addAttribute("userId", data.get("userId"));
		return "/base/sys/sysUser/userResource";
	}
	
	/**
	 * 
	 *@category 保存用户权限编辑
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@RequestMapping("/saveUserResource")
	@ResponseBody
	public Pagination saveUserResource(){
		Pagination page = new Pagination();
		String adds = request.getParameter("adds");
		String dels = request.getParameter("dels");
		String userId = request.getParameter("userId");
		String postId = request.getParameter("postId");
		page.getConditions().put("adds", adds);
		page.getConditions().put("dels", dels);
		page.getConditions().put("userId", userId);
		page.getConditions().put("postId", postId);
		SysUser user = SessionUtil.getSysUser();
		page.getConditions().put("updUserId",user.getUserId());
		page.getConditions().put("userName",user.getUserName());
		page.getConditions().put("orgId",user.getOrgId());
		page.getConditions().put("departmentId",user.getDepartmentId());
		page.getConditions().put("userType",user.getUserType());
		try {
			sysUserManager.saveUserResource(page);
			page.setSuccess(true);
		} catch (Exception e) {
			page.setSuccess(false);
			log.error("", e);
		}
		return page;
	}
	
	@RequestMapping("/updateSysUser")
	@ResponseBody
	public Pagination updateSysUser(@Validated({First.class}) SysUserDePostForm form,BindingResult result){
		Pagination page = new Pagination();
		log.info("SysUserForm = " + form);
		try {
			SysUser user = this.getSysUser();
			user.setName(form.getName());
			user.setEmail(form.getEmail());
			user.setPhone(form.getPhone());
			if(result.hasErrors()) {
				page.setMsg("验证不通过!");
				page.setSuccess(false);
			}else {
				sysUserManager.updateSysUser(user);
				page.setSuccess(true);
				/**********************************插入日志**********************************/
				saveLog(new String[]{String.valueOf(user.getUserId())},"用户信息修改",SysOprationLogOprateType.OPERATION_MODIFY.getKey(),SysChangelogOperateType.OPERATION_MODIFY.getKey());
			}
			
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
	}

	/*
	 * 中心支付信息审核-默认企业审核页面
	 */
	@RequestMapping("toCenterAudit")
	public String toCenterAudit(){
	
		return "/base/sys/sysUser/compAudit";
	}
	
	@RequestMapping("getCompAuditList")
	@ResponseBody
	public Pagination getCompAuditList(){
		Pagination page = new Pagination(this.getRequest());
		/*Integer ids[]={BankAuditFirstState.WAITAUDIT.getKey(),BankAuditFirstState.PASS.getKey(),BankAuditFirstState.NOPASS.getKey()};
		page.getConditions().put("bankAuditFirstStates", ids);*/
		page.getConditions().put("isCompany", "1");
		page=stdPayContractManager.getList(page);
		return page;
	}
	
	/**
	 * 企业审核/详情表单
	 */
	@RequestMapping("/toCompAuditDetail")
	public String toCompAuditDetail(Model model,String id,int type){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("isCompany", "1");
		map.put("orgId", id);
		StdPayContract comp=stdPayContractManager.getInfoById(map);
		model.addAttribute("comp", comp);
		model.addAttribute("type", type);

		return "/base/sys/sysUser/compAuditDetail";
	}

	/**
	 * 企业--审核通过
	 */
	@RequestMapping("toCompPass")
	@ResponseBody
	public Pagination toCompPass(String id){
		Pagination page = new Pagination(this.getRequest());
		try{
			SysUser user = this.getSysUser();
			StdCompany comp = new StdCompany();
			comp.setCompanyId(id);
			comp.setBankAuditUserId(user.getUserId());
			comp.setBankAuditUserName(user.getName()+"("+user.getUserName()+")");
			comp.setLastUpdateUserId(user.getUserId());
			comp.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			/*comp.setBankAuditState(BankAuditState.PASS.getKey());*/
			/*comp.setBankAuditSecondState(BankAuditSecondState.SUBMIT.getKey());*/
			stdCompanyManager.auditPass(comp);
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
		}
	
	/**
	 * 企业--审核不通过
	 */
	@RequestMapping("toCompNoPass")
	@ResponseBody
	public Pagination toCompNoPass(String id){
		Pagination page = new Pagination(this.getRequest());
		try{
			
			SysUser user = this.getSysUser();
			StdCompany comp = new StdCompany();
			comp.setCompanyId(id);
			comp.setBankAuditUserId(user.getUserId());
			comp.setBankAuditUserName(user.getName()+"("+user.getUserName()+")");
			comp.setLastUpdateUserId(user.getUserId());
			comp.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			/*comp.setBankAuditState(BankAuditState.NOPASS.getKey());*/
			stdCompanyManager.auditNoPass(comp);
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
		}
	
	/*
	 * 中心支付信息审核-医疗机构审核页面
	 */
	@RequestMapping("toHospAudit")
	public String toHospAudit(){
		return "/base/sys/sysUser/hospAudit";
	}
	
	@RequestMapping("getHospAuditList")
	@ResponseBody
	public Pagination getHospAuditList(){
		Pagination page = new Pagination(this.getRequest());
		/*Integer ids[]={BankAuditFirstState.WAITAUDIT.getKey(),BankAuditFirstState.PASS.getKey(),BankAuditFirstState.NOPASS.getKey()};
		page.getConditions().put("bankAuditFirstStates", ids);*/
		page.getConditions().put("isHospital", "1");
		page=stdPayContractManager.getList(page);
		return page;
	}
	
	/**
	 * 医院审核/详情表单
	 */
	@RequestMapping("/toHospAuditDetail")
	public String toHospAuditDetail(Model model,String id,int type){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("isHospital", "1");
		map.put("orgId", id);
		StdPayContract hosp = stdPayContractManager.getInfoById(map);
		model.addAttribute("hosp", hosp);
		model.addAttribute("type", type);

		return "/base/sys/sysUser/hospAuditDetail";
	}
	/**
	 * 医院--审核通过
	 */
	@RequestMapping("toHospPass")
	@ResponseBody
	public Pagination toHospPass(String id){
		Pagination page = new Pagination(this.getRequest());
		try{
			SysUser user = this.getSysUser();
			StdHospital hosp = new StdHospital();
			hosp.setHospitalId(id);
			hosp.setBankAuditUserId(user.getUserId());
			hosp.setBankAuditUserName(user.getName()+"("+user.getUserName()+")");
			hosp.setLastUpdateUserId(user.getUserId());
			hosp.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			/*hosp.setBankAuditState(BankAuditState.PASS.getKey());*/
			/*hosp.setBankAuditSecondState(BankAuditSecondState.SUBMIT.getKey());*/
			stdHospitalManager.auditPass(hosp);
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
		}
	
	/**
	 * 医院--审核不通过
	 */
	@RequestMapping("toHospNoPass")
	@ResponseBody
	public Pagination toHospNoPass(String id){
		Pagination page = new Pagination(this.getRequest());
		try{
			SysUser user = this.getSysUser();
			StdHospital hosp = new StdHospital();
			hosp.setHospitalId(id);
			hosp.setBankAuditUserId(user.getUserId());
			hosp.setBankAuditUserName(user.getName()+"("+user.getUserName()+")");
			hosp.setLastUpdateUserId(user.getUserId());
			hosp.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			/*hosp.setBankAuditState(BankAuditState.NOPASS.getKey());*/
			stdHospitalManager.auditNoPass(hosp);
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
		}
	
	/**
	 * 查询用户是否存在,如果存在,返回true,如果不存在返回false
	 * @param userName
	 * @return
	 */
	@RequestMapping("/getRepeatUserName")
	@ResponseBody
	public boolean getRepeatUserName(String userId,String userName){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		List<SysUser> sysUserList = sysUserManager.queryRepeatUserName(params);
		if(sysUserList != null && sysUserList.size()>0){
			if(sysUserList.get(0).getUserId().equals(userId)){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}
	
	/***
	 * 日志插入
	 * @param ids 目标ids
	 * @param msg 日志描述说明
	 * @param oprateType 系统日志类型
	 * @param changeLogType  变更日记类型
	 * */
	private void saveLog(String[] ids,String msg,Object oprateType,Object changeLogType){		
			int operationType=Integer.parseInt(String.valueOf(oprateType));//日志枚举
			int operationType2=Integer.parseInt(String.valueOf(changeLogType));//变更日志枚举
			List<SysUser> list=sysUserManager.getSysUserListById(ids);
			List<String> userIds=new ArrayList<String>();
			for(int i=0;i<list.size();i++){
				userIds.add(list.get(i).getUserId());
			}
			sysOperationLogManager.insertBatch(list, getSysUser(), userIds, GetComputerInfo.getIP(getRequest()), operationType, msg, sysId);
			sysChangeLogManager.insertBatch(list, userIds, getSysUser(), operationType2, GetComputerInfo.getIP(getRequest()), sysId);			
	}
	
	
	/**
	 * 支付页面保存或提交
	 */
	@RequestMapping("updatePayment")
	@ResponseBody
	public Pagination updatePayment(@Validated({First.class}) StdPayContractForm stdPayContractForm,BindingResult result){
		Pagination page = new Pagination();
		SysUser user = getSysUser();
		try {
			if(result.hasErrors()) {
				page.setMsg("验证不通过!");
				page.setSuccess(false);
			}else{
				stdPayContractForm.setBankSubmitUserId(user.getUserId());
				stdPayContractForm.setBankSubmitUserName(user.getName()+"("+user.getUserName()+")");
				StdPayContract stdPayContract = stdPayContractManager.getById(user.getOrgId());
				if(stdPayContract == null){
					stdPayContract = new StdPayContract();
					stdPayContract.setOrgId(user.getOrgId());
					stdPayContract.setOrgType(user.getUserType());
					stdPayContract.setIsBalance(0);
					stdPayContract.setGatherTag(0);
					if(user.getUserType()==UserType.jkzx.getKey() || user.getUserType()==UserType.jkzx.getKey()){
						stdPayContract.setOrgName(((StdHospitals)user.getStdHospital()).getHospitalName());
					}else{
						stdPayContract.setOrgName(((StdCompanys)user.getStdCompany()).getCompanyName());
					}
					BeanTool.copyProperties(stdPayContractForm, stdPayContract);
					stdPayContract.setLastUpdateUserId(user.getUserId());
					stdPayContract.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
					stdPayContractManager.add(stdPayContract);
				}else{
					BeanTool.copyProperties(stdPayContractForm, stdPayContract);
					stdPayContractManager.updateById(stdPayContract);
				}
				page.setSuccess(true);
			}
			
		} catch (Exception e) {
			page.setSuccess(false);
			log.error("",e);
		}
		return page;
	}
	
	/**
	 * @category 跳转支付信息复核页面
	 * @author wangbing
	 * @date 2016年5月25日下午1:23:54
	 * @parameter
	 * @return
	 */
	@RequestMapping("toPayInfoSecondAudit")
	public String toPayInfoSecondAudit(Model model,Integer type){
		Map<String,Object> map = sysDateManager.getWorkDayAndNow();
		model.addAttribute("auditTime",((Timestamp)map.get("NOW")).getTime());
		model.addAttribute("isWorkDay",map.get("ISWORKDAY"));
		if(type!=null&&type==1){
			return "/base/sys/sysUser/hospSecondAudit";
		}
		return "/base/sys/sysUser/compSecondAudit";
	}
	
	/**
	 * @category 获取支付信息企业复核数据
	 * @author wangbing
	 * @date 2016年5月25日下午1:24:23
	 * @parameter
	 * @return
	 */
	@RequestMapping("getCompSecondAuditList")
	@ResponseBody
	public Pagination getCompSecondAuditList(){
		Pagination page = new Pagination(this.getRequest());
		Integer ids[]={BankAuditSecondState.WAITAUDIT.getKey(),BankAuditSecondState.PASS.getKey(),BankAuditSecondState.NOPASS.getKey()};
		page.getConditions().put("bankAuditSecondStates", ids);
		page.getConditions().put("isCompany", "1");
		page=stdPayContractManager.getList(page);
		return page;
	}
	
	/**
	 * @category 获取支付信息医院复核数据
	 * @author wangbing
	 * @date 2016年5月25日下午1:24:23
	 * @parameter
	 * @return
	 */
	@RequestMapping("getHospSecondAuditList")
	@ResponseBody
	public Pagination getHospSecondAuditList(){
		Pagination page = new Pagination(this.getRequest());
		Integer ids[]={BankAuditSecondState.WAITAUDIT.getKey(),BankAuditSecondState.PASS.getKey(),BankAuditSecondState.NOPASS.getKey()};
		page.getConditions().put("bankAuditSecondStates", ids);
		page.getConditions().put("isHospital", "1");
		page=stdPayContractManager.getList(page);
		return page;
	}
	
	/**
	 * @category 企业复核/详情表单
	 * @author wangbing
	 * @date 2016年5月25日下午2:26:54
	 * @parameter
	 * @return
	 */
	@RequestMapping("/toCompSecondAuditDetail")
	public String toCompSecondAuditDetail(Model model,String id,int type){

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("isCompany", "1");
		map.put("orgId", id);
		StdPayContract comp=stdPayContractManager.getInfoById(map);
		model.addAttribute("comp", comp);
		model.addAttribute("type", type);

		return "/base/sys/sysUser/compSecondAuditDetail";
	}
	
	/**
	 * @category 医院复核/详情表单
	 * @author wangbing
	 * @date 2016年5月25日下午2:26:54
	 * @parameter
	 * @return
	 */
	@RequestMapping("/toHospSecondAuditDetail")
	public String toHospSecondAuditDetail(Model model,String id,int type){

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("isHospital", "1");
		map.put("orgId", id);
		StdPayContract hosp = stdPayContractManager.getInfoById(map);
		model.addAttribute("hosp", hosp);
		model.addAttribute("type", type);

		return "/base/sys/sysUser/hospSecondAuditDetail";
	}
	
	/**
	 * @category 支付信息-企业复核
	 * @author wangbing
	 * @date 2016年5月25日下午3:15:21
	 * @parameter
	 * @return
	 */
	@RequestMapping("toCompPayInfoSecondAudit")
	@ResponseBody
	public Pagination toCompPayInfoSecondAudit(String id,Integer bankAuditSecondState){
		Pagination page = new Pagination(this.getRequest());
		try{
			
			SysUser user = this.getSysUser();
			StdCompany comp = new StdCompany();
			comp.setCompanyId(id);
			comp.setBankAuditSecondUserId(user.getUserId());
			comp.setBankAuditSecondUserName(user.getName()+"("+user.getUserName()+")");
			comp.setLastUpdateUserId(user.getUserId());
			comp.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			comp.setBankAuditSecondState(bankAuditSecondState);
			stdCompanyManager.payInfoSecondAudit(comp);
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
		}
	
	/**
	 * @category 支付信息-医院复核
	 * @author wangbing
	 * @date 2016年5月25日下午3:15:21
	 * @parameter
	 * @return
	 */
	@RequestMapping("toHospPayInfoSecondAudit")
	@ResponseBody
	public Pagination toHospPayInfoSecondAudit(String id,Integer bankAuditSecondState){
		Pagination page = new Pagination(this.getRequest());
		try{
			SysUser user = this.getSysUser();
			StdHospital hosp = new StdHospital();
			hosp.setHospitalId(id);
			hosp.setBankAuditSecondUserId(user.getUserId());
			hosp.setBankAuditSecondUserName(user.getName()+"("+user.getUserName()+")");
			hosp.setLastUpdateUserId(user.getUserId());
			hosp.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			hosp.setBankAuditSecondState(bankAuditSecondState);
			stdHospitalManager.payInfoSecondAudit(hosp);
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to do batch oper", e);
			page.setSuccess(false);
		}
		return page;
		}
	
	/**
	 * @category 支付信息-初审/复审
	 * @author wangbing
	 * @date 2016年5月25日下午3:15:21
	 * @parameter
	 * @return
	 */
	@RequestMapping("payInfoAuditFirstOrSecond")
	@ResponseBody
	public Pagination payInfoAuditFirstOrSecond(StdPayContract pay){
		Pagination page = new Pagination(this.getRequest());
		Integer firstState = pay.getBankAuditFirstState();
		Integer secondState = pay.getBankAuditSecondState();
		try {
			SysUser user = getSysUser();
			Date date = new Date();
			pay.setLastUpdateUserId(user.getUserId());
			pay.setLastUpdateUserName(user.getName()+"("+user.getUserName()+")");
			pay.setLastUpdateTime(date);
			if(firstState!=null){
				pay.setBankAuditFirstUserId(user.getUserId());
				pay.setBankAuditFirstUserName(user.getName()+"("+user.getUserName()+")");
				pay.setBankAuditFirstTime(date);
				if(firstState==BankAuditFirstState.PASS.getKey()){
					pay.setBankAuditSecondState(BankAuditSecondState.WAITAUDIT.getKey());
				}
			}
			if(secondState!=null){
				pay.setBankAuditSecondUserId(user.getUserId());
				pay.setBankAuditSecondUserName(user.getName()+"("+user.getUserName()+")");
				pay.setBankAuditSecondTime(date);
				if(secondState==BankAuditSecondState.PASS.getKey()){
					StdPayContract oldPay = stdPayContractManager.getById(pay.getOrgId());
					pay.setGatherTag(oldPay.getGatherTagAudit());
					pay.setBankBasicAccount(oldPay.getBankBasicAccountAudit());
					pay.setBankBasicName(oldPay.getBankBasicNameAudit());
					pay.setBankBasicBankname(oldPay.getBankBasicBanknameAudit());
					pay.setBankLoanAccount(oldPay.getBankLoanAccountAudit());
					pay.setBankLoanName(oldPay.getBankLoanNameAudit());
					pay.setBankLoanBankname(oldPay.getBankLoanBanknameAudit());
					pay.setFinanceContactPerson(oldPay.getFinanceContactPersonAudit());
					pay.setFinanceContactTel(oldPay.getFinanceContactTelAudit());
					pay.setIsNeedSync(1);
				}
			}
			Integer count = stdPayContractManager.updateBySelective(pay);
			if(count>0){
				page.setSuccess(true);
			}else{
				page.setSuccess(false);
			}
		} catch (Exception e) {
			page.setSuccess(false);
			log.error("",e);
		}
		return page;
		}

	
	/***
	 * 日志插入
	 * @param ids 目标ids
	 * @param msg 日志描述说明
	 * @param oprateType 系统日志类型
	 * @param changeLogType  变更日记类型
	 * */
	private void saveLogByPostAdd(String[] ids,String msg,Object oprateType,Object changeLogType,String postId){		
			int operationType=Integer.parseInt(String.valueOf(oprateType));//日志枚举
			int operationType2=Integer.parseInt(String.valueOf(changeLogType));//变更日志枚举
			String jobName = "";
			if(StringUtils.isNotBlank(postId)){
				SysPost sysPost = zxMinSysPostManager.getById(Integer.parseInt(postId));
				jobName = sysPost.getPostName();
			}
			List<SysUser> list=sysUserManager.getSysUserListById(ids);
			List<String> userIds=new ArrayList<String>();
			for(int i=0;i<list.size();i++){
				userIds.add(list.get(i).getUserId());
			}
			sysOperationLogManager.insertBatchByPostAdd(list, getSysUser(), userIds, GetComputerInfo.getIP(getRequest()), operationType, msg, sysId,jobName);
			sysChangeLogManager.insertBatchByPostAdd(list, userIds, getSysUser(), operationType2, GetComputerInfo.getIP(getRequest()), sysId,jobName);			
	}
	
	
	/**
	 * @category 修改医院是否结算机构信息
	 * @author lil
	 * @date 2016年7月27日 19:00:38
	 * @parameter
	 * @return
	 */
	@RequestMapping("/toUpdateBalanceInfos")
	public String toUpdateBalanceInfos(Model model){
		return "/base/sys/sysUser/updateBalanceInfos";
	}
	
	/**
	 * 获取所有的支付医疗机构信息
	 * @return
	 */
	@RequestMapping("getPayHospList")
	@ResponseBody
	public Pagination getPayHospList() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			pagination = stdPayContractManager.getPayHospList(pagination);
		} catch (Exception e) {
			log.error("Failed to queryAllPayDetail", e);
		}
		return pagination;
	}
	
	
	/**
	 * @category 根据医疗机构编号修改结算信息
	 * @author lil
	 * @date   2016年7月28日 10:48:49
	 * @param  @return
	 */
	@RequestMapping("/updateHospPayModeByOrgId" )
	@ResponseBody
	public Pagination updateHospPayModeByOrgId(){
		Pagination page = new Pagination(request);
		
		try {
			int i = stdPayContractManager.updateHospPayModeByOrgId(page.getConditions());
			if(i > 0) {
				page.setSuccess(true);
			}else{
				page.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("Failed to sear area", e);
			page.setSuccess(false);
			page.setMsg("更新出错！");
		}
		return page;
	}
	
	/************************************************疫苗账号发放BEGIN*********************************************/
	//账号生成弹窗
	@RequestMapping("/toCreateUser")
	public String toCreateUser() {

		return "/base/sys/sysUser/createUser";
	}

	// 为生成账号列表
	@RequestMapping("/toCreateUserList")
	public String toCreateUserList(Model model, String userType) {
		model.addAttribute("userType", userType);
		if (userType.equals("4")) {//疾控中心
			StdArea dicArea = stdAreaManger.getAreaByAreaId(sysProvince);
			request.setAttribute("provinceName", dicArea.getAreaName());
			request.setAttribute("province", sysProvince);
			return "/base/sys/sysUser/yySelect";
		}
		
		if (userType.equals("1") || userType.equals("2")) {//企业	
			return "/base/sys/sysUser/qySelect";
		}
		
		if (userType.equals("6")) {//监管机构
			return "/base/sys/sysUser/jgSelect";
		} 
		
		return "/404";
	}

	//未生成账号企业
	@RequestMapping("/qySelect")
	public String toQySelect(){
		
		return "/base/sys/sysUser/qySelect";
	}
	
	//未生成账号企业
	@RequestMapping("/getQySelectList")
	@ResponseBody
	public Pagination getQySelectList() {
		Pagination page = new Pagination(request);
		try {
			stdCompanyManager.getQySelectList(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	//已生成账号企业
	@RequestMapping("/qySendSelect")
	public String qySendSelect(){
			
		return "/base/sys/sysUser/qySendSelect";
	}
		
	//已生成账号企业
	@RequestMapping("/getQySendSelectList")
	@ResponseBody
	public Pagination getQySendSelectList() {
		Pagination page = new Pagination(request);
		try {
			stdCompanyManager.getQySendSelectList(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	
	// 新增企业
	@RequestMapping("/toInsert")
	public String toInsertUser() {
		return "/base/sys/sysUser/addUser";
	}

	@RequestMapping("/addCompany")
	@ResponseBody
	public Pagination addCompany(@ModelAttribute StdCompany stdCompany ,Integer companyType) {
		Pagination page = new Pagination(request);
		try {
			SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
			stdCompany.setCompanyId(UUID.randomUUID().toString());
			stdCompany.setAddUserId(user.getUserId());
			stdCompany.setAddUserName(user.getUserName());
			stdCompany.setCompanyType(companyType);
			int count1 = stdCompanyManager.getCompanyName(stdCompany.getCompanyName());
			int count2 = yimiaoCompanyManager.getCompanyName(stdCompany.getCompanyName());
			if(count1 > 0 || count2 > 0){
				page.setMsg("该企业名称已存在！");
				page.setSuccess(false);
				return page;
			}
			boolean result1 = stdCompanyManager.addCompanyQy(stdCompany);
			YimiaoCompany yimiaoCompany = new YimiaoCompany();
			yimiaoCompany.setCompanyId(stdCompany.getCompanyId());
			yimiaoCompany.setAddUserId(user.getUserId());
			yimiaoCompany.setAddUserName(user.getUserName());
			yimiaoCompany.setCompanyType(companyType);
			yimiaoCompany.setCompanyName(stdCompany.getCompanyName());
			yimiaoCompany.setAreaId(stdCompany.getAreaId());
			boolean result2 = yimiaoCompanyManager.addCompanyQy(yimiaoCompany);
			if(result1 && result2){
				page.setSuccess(true);
			}else{
				page.setSuccess(false);
			}
		} catch (Exception e) {
			log.error("",e);
			page.setSuccess(false);
		}
		return page;
	}

	//未生成账号的疾控中心
	@RequestMapping("/toYYSelectList")
	public String toYYSelectList(Model model) {
		StdArea dicArea = stdAreaManger.getAreaByAreaId(sysProvince);
		model.addAttribute("provinceName", dicArea.getAreaName());
		model.addAttribute("province", sysProvince);
		return "/base/sys/sysUser/yySelect";
	}
	
	@RequestMapping("/getYySelectList")
	@ResponseBody
	public Pagination getYySelectList(Integer userType) {
		Pagination page = new Pagination(this.getRequest());
		if (request.getParameter("hospitalName") != null)
			page.getConditions().put("hospitalName", request.getParameter("hospitalName"));
		if (request.getParameter("hospitalLevel") != null)
			page.getConditions().put("hospitalLevel", request.getParameter("hospitalLevel"));
		if (request.getParameter("drugPurchaseProperty") != null)
			page.getConditions().put("drugPurchaseProperty", request.getParameter("drugPurchaseProperty"));

		String provId = request.getParameter("area1");
		String cityId = request.getParameter("area2");
		String townId = request.getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
			page.getConditions().put("areaId", areaId + "%");
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
			page.getConditions().put("areaId", areaId + "%");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
			page.getConditions().put("areaId", areaId + "%");
		} else {
			areaId = "";
		}
		try {
			page.getConditions().put("userType", 4);//疾控中心
			stdHospitalManager.getYySelectList(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}

	//已生成账号的疾控中心
	@RequestMapping("/toYYSendSelectList")
	public String toYYSendSelectList(Model model) {
		StdArea dicArea = stdAreaManger.getAreaByAreaId(sysProvince);
		model.addAttribute("provinceName", dicArea.getAreaName());
		model.addAttribute("province", sysProvince);
		return "/base/sys/sysUser/yySendSelect";
	}
		
	@RequestMapping("/getYySendSelectList")
	@ResponseBody
	public Pagination getYySendSelectList(Integer userType) {
		Pagination page = new Pagination(this.getRequest());
		if (request.getParameter("hospitalName") != null)
			page.getConditions().put("hospitalName", request.getParameter("hospitalName"));
		if (request.getParameter("hospitalLevel") != null)
			page.getConditions().put("hospitalLevel", request.getParameter("hospitalLevel"));
		if (request.getParameter("drugPurchaseProperty") != null)
			page.getConditions().put("drugPurchaseProperty", request.getParameter("drugPurchaseProperty"));

		String provId = request.getParameter("area1");
		String cityId = request.getParameter("area2");
		String townId = request.getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
			page.getConditions().put("areaId", areaId + "%");
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
			page.getConditions().put("areaId", areaId + "%");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
			page.getConditions().put("areaId", areaId + "%");
		} else {
			areaId = "";
		}
		try {
			page.getConditions().put("userType", 4);//疾控中心
			stdHospitalManager.getYySendSelectList(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	//新增疾控中心
	@RequestMapping("/toAddJKZX")
	public String toAddJKZX() {
		
		return "/base/sys/sysUser/addJKZX";
	}
	
	@RequestMapping("/addJKZX")
	@ResponseBody
	public Pagination addJKZX(@ModelAttribute StdHospital stdHospital) {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		stdHospital.setHospitalId(UUID.randomUUID().toString());
		stdHospital.setAddUserId(user.getUserId());
		stdHospital.setAddUserName(user.getUserName());
		try {
			int count = stdHospitalManager.getHospitalName(stdHospital.getHospitalName());
			if(count > 0) {
				page.setSuccess(false);
				page.setMsg("该疾控中心已存在！");
				return page;
			}
			boolean result = stdHospitalManager.addJKZX(stdHospital);
			if(!result) {
				page.setSuccess(false);
			}
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("",e);
			e.printStackTrace();
			page.setSuccess(false);
		}
		return page;
	}
	
	//未生成账号的监管机构
	@RequestMapping("/jgSelect")
	public String toJgSelectList() {
		
		return "/base/sys/sysUser/jgSelect";
	}
	
	@RequestMapping("/getJgSelectList")
	@ResponseBody
	public Pagination getJgSelectList() {
		Pagination page = new Pagination(request);
		try {
			page.getConditions().put("userType", 6);//监管机构
			stdManageOrgManager.getJgSelectList(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	//已生成账号的监管机构
	@RequestMapping("/jgSendSelect")
	public String toJgSendSelectList() {
			
		return "/base/sys/sysUser/jgSendSelect";
	}
		
	@RequestMapping("/getJgSendSelectList")
	@ResponseBody
	public Pagination getJgSendSelectList() {
		Pagination page = new Pagination(request);
		try {
			page.getConditions().put("userType", 6);//监管机构
			stdManageOrgManager.getJgSendSelectList(page);
		} catch (Exception e) {
			log.error(e);
		}
		return page;
	}
	//新增疫苗监管
	@RequestMapping("/toAddYMJG")
	public String toAddYMJG() {
		
		return "/base/sys/sysUser/addYMJG";
	}
	
	@RequestMapping("/addYMJG")
	@ResponseBody
	public Pagination addYMJG(@ModelAttribute StdManageOrg stdManageOrg) {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		stdManageOrg.setAddUserId(user.getUserId());
		stdManageOrg.setAddUserName(user.getUserName());
		try {
			int count = stdManageOrgManager.getManageOrgName(stdManageOrg.getHeaBurName());
			if(count > 0) {
				page.setSuccess(false);
				page.setMsg("该机构名称已存在！");
				return page;
			}
			boolean result = stdManageOrgManager.addManageOrg(stdManageOrg);
			if(!result) {
				page.setSuccess(false);
			}
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("",e);
			page.setSuccess(true);
			e.printStackTrace();
		}
		return page;
	}

	// 医疗机构、生产企业、配送企业、监管机构生成账号弹窗
	@RequestMapping("/toGenerateAccount")
	public String toGenerateAccount(Model model,String id,Integer userType,Integer areaId,String heaBurType,Integer companyType, String name)
			throws UnsupportedEncodingException {
		int checkGenerateSubAccount = YesOrNo.NO.getKey();
		
		model.addAttribute("checkGenerateSubAccount", checkGenerateSubAccount);
		model.addAttribute("id", id);
		model.addAttribute("name",new String(name.getBytes("iso-8859-1"),"utf-8"));
		model.addAttribute("areaId", areaId);
		model.addAttribute("companyType", companyType);
		model.addAttribute("userType", userType);
		model.addAttribute("heaBurType", heaBurType);
		
		return "/base/sys/sysUser/generateAccount";
	}
	
	//生成账号
	@RequestMapping("generateSubAccount")
	@ResponseBody
	public Pagination generateSubAccount(String id, Integer userType,Integer areaId,String heaBurType,
			Integer companyType,String bussinessShow, Integer generateSubAccount, String name) {
		Pagination page = new Pagination();
		String areaId2 = String.valueOf(areaId);
		String companyType2 = String.valueOf(companyType);
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		SysUser su = new SysUser();//新增用户
		SysDepartment sysDepartment = new SysDepartment();//新增部门
		String zhuId = UUID.randomUUID().toString();
		String zhuSequence = AccountUtil.getSequence(userType, areaId2,companyType2, heaBurType);// 主用户账号
		String password = AccountUtil.getPassword(6);// 主用户密码
		String createUserId = user.getUserId();
		try {
			// bussinessShow:0机构用户 1业务用户 2业务审核用户
			if (Integer.valueOf(bussinessShow) != 0) {
				
				if (userType == 1) {// 投标企业
					StdCompany comp = stdCompanyManager.getById(id);
					stdCompanyManager.updateAccountCode(id, zhuSequence);
					yimiaoCompanyManager.updateAccountCode(id,zhuSequence);
					su.setName(comp.getCompanyName());
					su.setRoleId(2);
					sysDepartment.setOrgId(comp.getCompanyId());
					sysDepartment.setOrgName(comp.getCompanyName());
					sysDepartment.setAreaId("0");
					sysDepartment.setAreaName("");
					sysDepartment.setDepartmentType(1);//生产部门
					sysDepartment.setGroupName("生产部门");
				}
				if (userType == 2) {// 配送企业
					StdCompany comp = stdCompanyManager.getById(id);
					stdCompanyManager.updateAccountCode(id, zhuSequence);
					yimiaoCompanyManager.updateAccountCode(id,zhuSequence);
					su.setName(comp.getCompanyName());
					su.setRoleId(3);
					sysDepartment.setOrgId(comp.getCompanyId());
					sysDepartment.setOrgName(comp.getCompanyName());
					sysDepartment.setAreaId("0");
					sysDepartment.setAreaName("");
					sysDepartment.setDepartmentType(2);//配送部门
					sysDepartment.setGroupName("配送部门");
				}
				if (userType == 4) {// 医院
					//su.setRoleId(1);
					StdHospital hosp = stdHospitalManager.getById(id);
					stdHospitalManager.updateUserName(id, zhuSequence);
					su.setName(hosp.getHospitalName());
					sysDepartment.setOrgId(hosp.getHospitalId());
					sysDepartment.setOrgName(hosp.getHospitalName());
					sysDepartment.setAreaId(hosp.getAreaId().toString());
					sysDepartment.setAreaName(hosp.getAreaName());
					if(Integer.valueOf(bussinessShow) == 2){
						su.setRoleId(6);
						sysDepartment.setDepartmentType(5);//采购审核部门
						sysDepartment.setGroupName("采购审核部门");
					}else {
						su.setRoleId(1);
						sysDepartment.setDepartmentType(4);//采购部门
						sysDepartment.setGroupName("采购部门");
					}

				}
				if (userType == 6) {// 监管机构
					StdManageOrg stdManageOrg = stdManageOrgManager.getById(id);
					su.setName(stdManageOrg.getHeaBurName());
					if(heaBurType.equals("4")) {
						su.setRoleId(4);
					}else {
						su.setRoleId(5);
					}
					sysDepartment.setOrgId(stdManageOrg.getId());
					sysDepartment.setOrgName(stdManageOrg.getHeaBurName());
					sysDepartment.setAreaId(stdManageOrg.getAreaId().toString());
					sysDepartment.setAreaName(stdManageOrg.getAreaName());
					sysDepartment.setDepartmentType(6);//监管部门
					sysDepartment.setGroupName("监管部门");
				}
				su.setUserId(zhuId);
				su.setUserName(zhuSequence);
				su.setUserPassword(DigestUtils.md5Hex(password));
				su.setLocked(YesOrNo.NO.getKey());// 不锁定账号
				su.setIsUsing(1);// 启用
				su.setAcctType(1);//业务用户
				su.setAddUserId(createUserId);
				su.setAddUserName(user.getUserName());
				su.setAddTime(new Timestamp(new Date().getTime()));
				su.setIsBalance(0);
				su.setUserType(userType);
				su.setLastUpdateUserId(user.getUserId());
				su.setLastUpdateUserName(user.getUserName());
				su.setLastUpdateTime(new Timestamp(new Date().getTime()));
				su.setOrgId(id);
				su.setIsBalance(0);
				su.setIsCaUsing(0);
				sysDepartment.setAddUserId(createUserId);
				sysDepartment.setAddUserName(user.getUserName());
				if(sysDepartmentManager.addDepartment(sysDepartment)) {
					su.setDepartmentId(sysDepartment.getDepartmentId());//部门ID
				}
				if (sysUserManager.addSysUser(su)) {// 保存主账号成功
					page.getConditions().put("zhuUserName", su.getUserName());
					page.getConditions().put("zhuPassword", password);
					page.getConditions().put("bussinessShow", bussinessShow);
					page.getConditions().put("url", url);
					page.setSuccess(true);
				} else {
					page.setMsg("生成账号失败！");
					page.setSuccess(false);
					return page;
				}
			}
		} catch (Exception e) {
			log.error("", e);
			page.setSuccess(false);
			return page;
		}
		return page;
	}
	
	/***************************************疫苗账号发放END*********************************************************/
	/***************************************疫苗密码找回Begin*********************************************************/
	
	@RequestMapping("/toSearchPwd")
	public String toSearchPwd() {
		
		return "/base/sys/sysUser/searchPwd";
	}
	
	@RequestMapping("/getSearchPwdData")
	@ResponseBody
	public Pagination getSearchPwdData() {
		Pagination page = new Pagination(this.getRequest());
		page = sysUserManager.getSearchPwdData(page);
		return page;
	}
	
	@RequestMapping("/toUpdatePwdDialog")
	public String toUpdatePwdDialog(Model model,String id) {
		SysUser user = sysUserManager.getById(id);
		model.addAttribute("userId", id);
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("name", user.getName());
		return "/base/sys/sysUser/updatePwdDialog";
	}
	
	@RequestMapping("/submitUpdate")
	@ResponseBody
	public Pagination submitUpdate(SysUser sysUser) {
		Pagination page = new Pagination(this.getRequest());
		try {
			sysUser.setUserPassword(DigestUtils.md5Hex(sysUser.getUserPassword()));
			sysUserManager.updateSysUser(sysUser);
			page.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			page.setSuccess(false);
		}
		return page;
	}
	/***************************************疫苗密码找回END*********************************************************/
	public int addRoleResourceList(SysRole sysRole,
			List<SysRoleResource> roleResourceList) {
		
		int i = sysRoleDao.save(sysRole);
		for (SysRoleResource sysRoleResource : roleResourceList) {
			sysRoleResource.setRoleId(sysRole.getRoleId());
		}
		if(i > 0) {
			if(roleResourceList.size() > 0)
				sysRoleResourceDao.insertBatch(roleResourceList);
			return sysRole.getRoleId();
		}else {
			return 0;
		}
	}
	//信息维护
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(Model model) {
		SysUser user = this.getSysUser();
		SysUser sysUser = sysUserManager.getById(user.getUserId());
		SysUserForm sysUserForm = new SysUserForm();
		modelToForm(sysUser, sysUserForm);
		model.addAttribute("validate", ValidateUtil.getValidate(SysUserForm.class));
		model.addAttribute("sysUserForm", sysUserForm);
		return "/base/sys/sysUser/updateUser";
	}
	//信息维护编辑
	@RequestMapping("/changeUser")
	@ResponseBody
	public Pagination changeUser() {
		Pagination page = new Pagination(request);
		try {
			String phone = (String) page.getConditions().get("phone");
			String email = (String) page.getConditions().get("email");
			SysUser user = this.getSysUser();
			SysUser sysUser = sysUserManager.getById(user.getUserId());
			sysUser.setPhone(phone);
			sysUser.setEmail(email);
			sysUserManager.updateSysUser(sysUser);
			page.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			page.setSuccess(false);
		}
		return page;
	}

}
