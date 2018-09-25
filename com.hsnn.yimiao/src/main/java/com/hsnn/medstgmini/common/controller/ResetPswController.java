package com.hsnn.medstgmini.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.enums.AcctType;
import com.hsnn.medstgmini.base.sys.enums.SysChangelogOperateType;
import com.hsnn.medstgmini.base.sys.enums.SysOprationLogOprateType;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysChangeLog;
import com.hsnn.medstgmini.base.sys.service.ISysDepartmentManager;
import com.hsnn.medstgmini.base.sys.service.ISysOperationLog;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.base.sys.service.ISysUserYimiao;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.GetComputerInfo;
import com.hsnn.medstgmini.util.Pagination;

import nl.captcha.Captcha;

/**
 * 
 *@category 密码重置
 *@author 应晓川
 *@date 2016年2月19日14:10:48
 */
@Controller
@RequestMapping("/resetPsw")
public class ResetPswController extends GenericController{

	private static final Logger log = Logger.getLogger(ResetPswController.class);
	
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private  ISysUser sysUserManager;
	
	@Autowired
	private  ISysUserYimiao sysUserYimiaoManager;
	
	@Autowired
	private ISysDepartmentManager sysDepartmentManager;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ISysOperationLog sysOperationLogManager;
	
	@Autowired
	private ISysChangeLog sysChangeLogManager;
	@Value("${system.sysId}")
	private String sysId;
	
	/**
	 * 获取当前登录人信息
	 * @return
	 */
	public SysUser getUser() {
		return (SysUser) session.getAttribute(Constants.USERINFO);
	}
	
	/**
	 * @category 用户列表
	 * @author 应晓川
	 * @date   2016年2月23日13:03:45
	 * @param  @return
	 */
	@RequestMapping("/toSysUserList")
	public String toSysUserList(Model model){
		SysUser user = (SysUser) request.getSession().getAttribute(Constants.USERINFO);
		model.addAttribute("orgId", user.getOrgId());//机构id
		if("".equals(user.getDepartmentId()+"") || user.getDepartmentId() == null) {
			model.addAttribute("type", 0);//机构
		}else {
			model.addAttribute("departmentId",user.getDepartmentId());//部门id
			model.addAttribute("type", 1);//部门
		}
		
		return "/base/sys/resetPsw/sysUserList";
	}
	@RequestMapping("/getSysUserData" )
	@ResponseBody
	public Pagination getUserData(){
		Pagination page = new Pagination(request);
		try {
			SysUser su = getUser();
			String type = String.valueOf(page.getConditions().get("type"));
			if("0".equals(type)) {//机构
				page.getConditions().put("acctType", AcctType.ADMINISTRATOR_ACCOUNT.getKey());
				page.getConditions().put("bmzh", AcctType.ADMINISTRATOR_ACCOUNT.getKey());
			}else {
				page.getConditions().put("departmentId", su.getDepartmentId());	
				page.getConditions().put("acctType", AcctType.BUSINESS_ACCOUNT.getKey());
			}
			page.getConditions().put("orgId", getUser().getOrgId());//TODO 属于本机构的用户	
			String pageStr = sysUserManager.getSysUserManager(page);
			page = JSONObject.parseObject(pageStr, Pagination.class);
		} catch (Exception e) {
			log.error("Failed to sear area", e);
		}
		return page;
	}
	
	
	/**
	 * 
	 *@category 去重置密码
	 *@author 应晓川
	 *@date 2016年2月19日14:14:32
	 *@return
	 */
	@RequestMapping("/toSendEmail")
	public String toSendEmail(){
		return "/base/sys/resetPsw/sendEmail";
	}
	/**
	 * 
	 *@category 发送邮件
	 *@author 应晓川
	 *@date 2016年2月20日10:04:45
	 *@return
	 */
	@RequestMapping("/sendEmail" )
	@ResponseBody
	public Pagination sendEmail(String username,String answer){
		Pagination page = new Pagination(request);
		
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		if (StringUtils.isBlank(answer)) {
			page.setMsg("请输入验证码！");
			page.setSuccess(false);
			return page;
		} else if (captcha == null) {
			page.setMsg("验证码失效！");
			page.setSuccess(false);
			return page;
		} else if (!captcha.getAnswer().equalsIgnoreCase(answer)) {
			page.setMsg("验证码不正确！");
			page.setSuccess(false);
			return page;
		}
		String email = "";
		SysUser user =null;
		try {
				if(StringUtils.isNotBlank(username)){
					user = sysUserManager.selectSysUserByUsername(username);
					if(null==user){
						page.setSuccess(false);
						page.setMsg("用户名不存在");
						return page;
					}
					if(StringUtils.isBlank(user.getEmail())){
						page.setSuccess(false);
						page.setMsg("用户邮箱不存在");
						return page;
					}
					email = user.getEmail();
				}
			String rootUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			page.getConditions().put("rootUrl",rootUrl);
			page.getConditions().put("webAppName", request.getContextPath());
			sysUserYimiaoManager.sendEmail(user,email,page);
			page.setSuccess(true);
			String emailStrMsg = "";
			if(StringUtils.isNotBlank(email)){
				Integer enumber = email.indexOf("@");
				 emailStrMsg = "重置密码的邮件已经发送至"+email.substring(0,1)+"********"+email.substring(enumber-1, email.length());
			}
			page.setMsg(emailStrMsg);
		} catch (Exception e) {
			log.error("Failed to sendEmail", e);
			page.setSuccess(false);
		}
		return page;
	}
	
	/**
	 * 
	 *@category 验证成功跳转至重置密码
	 *@author 应晓川
	 *@date 2016年2月20日09:53:42
	 *@return
	 * @throws ParseException 
	 */
	@RequestMapping("/toResetPsw")
	public String toResetPsw(String sign,String token) throws ParseException{
		SysUser user = sysUserManager.selectSysUserByResetToken(sign);
		if(null != user){
			String checkToken = DigestUtils.md5Hex(user.getUserName()+user.getResetTime());
			if(checkToken.equals(token) ){
				if((new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(user.getResetTime()).getTime()) <= Constants.TIME_LIMIT){
					request.setAttribute("userId", user.getUserId());
					return "/base/sys/resetPsw/resetPsw";
				}
			}
		}
		return "/base/sys/resetPsw/resetPswTimeOut";
	}

	/**
	 * 
	 *@category 邮件方式重置密码
	 *@author 应晓川
	 *@date 2016年2月19日17:24:20
	 *@return
	 */
	@RequestMapping("/resetLink" )
	@ResponseBody
	public Pagination resetLink(String userId,String newpassword){
		Pagination page = new Pagination(request);
		try {
			if(StringUtils.isBlank(userId)){
				page.setSuccess(false);
				page.setMsg("用户Id不存在");
				return page;
			}
			page.getConditions().put("userId", userId);
			page.getConditions().put("newpassword", DigestUtils.md5Hex(newpassword));
			if(!sysUserManager.restPsw(page)){
				page.setSuccess(false);
				page.setMsg("重置密码时间已超过有效24小时，请联系管理员！");
				return page;
			}
			page.setSuccess(true);
		} catch (Exception e) {
			log.error("Failed to resetLink", e);
		}
		return page;
	}
	/**
	 * 
	 *@category 网页方式重置密码
	 *@author 应晓川
	 *@date 2016年2月23日14:48:08
	 *@return
	 */
	@RequestMapping("/resetByWeb" )
	@ResponseBody
	public Pagination resetByWeb(String userId,String password,String passwordRepeat){
		Pagination page = new Pagination(request);
		try {
			if(StringUtils.isBlank(userId)){
				page.setSuccess(false);
				page.setMsg("您所用的Id不存在");
				return page;
			}
			if(StringUtils.isBlank(password) || StringUtils.isBlank(passwordRepeat)){
				page.setSuccess(false);
				page.setMsg("新密码不能为空");
				return page;
			}
			if(!password.equals(passwordRepeat)){
				page.setSuccess(false);
				page.setMsg("确认密码与密码不一致！请重新输入确认密码");
				return page;
			}
			page.getConditions().put("userId", userId);
			page.getConditions().put("newpassword", DigestUtils.md5Hex(password));
			sysUserManager.restPsw(page);
			
			page.setSuccess(true);
			
			/**********************************插入日志**********************************/
			saveLog(new String[]{String.valueOf(userId)},"用户密码重置",SysOprationLogOprateType.OPERATION_PASSWORD_RESET.getKey(),SysChangelogOperateType.OPERATION_PASSWORD_RESET.getKey());
		} catch (Exception e) {
			log.error("Failed to resetByWeb", e);
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
	private void saveLog(String[] ids,String msg,Object oprateType,Object changeLogType){
		for(String curUserId:ids){
			SysUser sysUser = sysUserManager.getById(curUserId);
			int operationType=Integer.parseInt(String.valueOf(oprateType));//日志枚举
			int operationType2=Integer.parseInt(String.valueOf(changeLogType));//变更日志枚举
			sysOperationLogManager.save(sysUser, getSysUser(), String.valueOf(sysUser.getUserId()), GetComputerInfo.getIP(getRequest()), operationType, msg, sysId);
			sysChangeLogManager.save(sysUser, String.valueOf(sysUser.getUserId()), getSysUser(), operationType2, GetComputerInfo.getIP(getRequest()), sysId);
		}
	}
	
}