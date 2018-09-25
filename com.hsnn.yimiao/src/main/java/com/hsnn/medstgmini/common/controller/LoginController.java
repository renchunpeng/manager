package com.hsnn.medstgmini.common.controller;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.std.model.StdCompanys;
import com.hsnn.medstgmini.base.std.model.StdHospitals;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.std.service.StdManageOrgManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.common.model.Status;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.common.model.Whether;
import com.hsnn.medstgmini.common.util.gzca.GZCA;
import com.hsnn.medstgmini.yimiao.service.YimiaoCompanyManager;
import nl.captcha.Captcha;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @category 登陆|登出
 * @author 单大伟
 * @date 2015-06-10
 */

@Controller
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);
	

	@Autowired
	private ISysUser userManager;

	@Autowired
	private YimiaoCompanyManager stdCompanyManager;

	@Autowired
	private StdHospitalManager stdHospitalManager;
	
	@Autowired
	private StdManageOrgManager stdManageOrgManager;

	@Autowired
	private HttpSession session;
	
    private String captchaEnable = "true";
    
    private String systemTitle = "贵州省第二类疫苗集中采购系统";
    
    private String systemHostUnit = "贵州省疾病控制和预防中心";

    private String CAURL = "https://58.42.231.108:5001";

    private String CAUSERNAME = "SGGZY_YM";

	/**
	 * @category 跳转登陆页面
	 * @date 2015年6月12日
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		SysUser user = (SysUser) session.getAttribute(Constants.USERINFO);
		if (user != null) {
			return "redirect:index.html";
		}
		request.setAttribute("Data", UUID.randomUUID().toString());
		request.setAttribute("systemHostUnit", systemHostUnit);
		request.setAttribute("systemTitle", systemTitle);
		return "/login";
	}

	/**
	 * @category 用户登录处理
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param request
	 * @param model
	 * @return String 登录验证成功后跳转到的页面
	 */
	@RequestMapping("/loginAuth")
	public String loginAuth(HttpServletRequest request, Model model) {

		// user pass in parameters
		String username = request.getParameter(Constants.USERNAME);
		String password = request.getParameter(Constants.PASSWORD);
		String answer = request.getParameter(Constants.ANSWER);

		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);

		log.info("User [" + username + "] try login!");
		
		request.setAttribute("systemTitle", systemTitle);
		request.setAttribute("systemHostUnit", systemHostUnit);

		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			model.addAttribute("errorMsg", "请输入用户名密码！");
			return "/login";
		}

		if (log.isDebugEnabled()) {
		    log.debug("capt enable = " + captchaEnable);
		}
		
		if (Constants.strTrue.equals(captchaEnable)) {
			if (StringUtils.isBlank(answer)) {
				model.addAttribute("errorMsg", "请输入验证码！");
				return "/login";
			} else if (captcha == null) {
				return "/login";
			} else if (!captcha.getAnswer().equalsIgnoreCase(answer)) {
				model.addAttribute("errorMsg", "验证码不正确！");
				return "/login";
			}
		}

		String encodedPwd = DigestUtils.md5Hex(password);

		HttpSession sessionDemo = request.getSession();
		if (sessionDemo.getAttribute(Constants.USERINFO) != null) {
			log.warn("authentication failed");
			model.addAttribute("errorMsg", "请先退出当前登录用户！");
			return "/login";
		}
		// get user name and pwd from database
		SysUser user = userManager.getUserByUsername(username);
        
		// user pass in empty username and password
		if (user == null) {
			log.warn("empty user");
			model.addAttribute("errorMsg", "用户名或密码不正确！");
			return "/login";
		}
		

		String orgId = user.getOrgId();
		int userType = user.getUserType();
		if(StringUtils.isBlank(orgId)){
			throw new NullArgumentException("orgId can not be found !");
		}
		if ( UserType.jkzx.getKey().equals(userType)) {// 医疗机构
			StdHospitals stdHospitals = new StdHospitals();
			BeanUtils.copyProperties(stdHospitalManager.getById(orgId), stdHospitals);
			user.setStdHospital(stdHospitals);
			if(user.getStdHospital() != null) {
				StdHospitals sh = user.getStdHospital();
				user.setFatherName(sh.getHospitalName());
			}
		} else if (UserType.scqy.getKey().equals(userType)) {// 企业
			StdCompanys stdCompany = new StdCompanys();
			BeanUtils.copyProperties(stdCompanyManager.getById(orgId), stdCompany);
			user.setStdCompany(stdCompany);
			if(user.getStdCompany() != null) {
				StdCompanys sc = user.getStdCompany();
				user.setFatherName(sc.getCompanyName());
			}
		} else if (UserType.cgzx.getKey().equals(userType) || UserType.wsj.getKey().equals(userType)) {
			StdManageOrg smo =  stdManageOrgManager.getById(orgId);
			if (smo != null) {
				user.setStdManageOrg(smo);
				if(user.getStdManageOrg() != null) {
					StdManageOrg sm = (StdManageOrg)user.getStdManageOrg();
					user.setFatherName(sm.getHeaBurName());
				}
			}
		}
		
		if(user.getAcctType() == 1) {//管理帐号
			if(user.getSysDepartment() != null) {
				user.setFatherName(user.getSysDepartment().getGroupName());
			}
		}
		
		if(user.getIsUsing()==Status.invalid.getKey()){
			log.warn(" user status is unenabled ");
			model.addAttribute("errorMsg", "该用户已被停用！");
			return "/login";
		}
		if(user.getLocked()==Whether.yes.getKey()){
			log.warn(" user is locked ");
			model.addAttribute("errorMsg", "该用户已被锁定！");
			return "/login";
		}
		/**
		 * 验证用户类型是否为企业
		 */
		if(UserType.scqy.getKey().equals(userType)){
			log.warn(" key for login ");
			model.addAttribute("errorMsg", "该用户需要CA登录！");
			request.setAttribute("systemHostUnit", systemHostUnit);
			request.setAttribute("systemTitle", systemTitle);
			return "/login";
		}

		if (encodedPwd.equals(user.getUserPassword())) {
			log.info("authentication passed");

			HttpSession session = request.getSession(true);
			session.setAttribute(Constants.USERINFO, user);
      
    		
			user.setLoginIp(request.getLocalAddr());
			userManager.updateLoginInfo(user.getLoginIp(), user.getUserId());

			return "redirect:index.html";
		} else {
			log.warn("authentication failed");
			model.addAttribute("errorMsg", "用户名或密码不正确！");
			return "/login";
		}
	}

	/**
	 * @category 用户退出登录处理
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param request
	 * @param model
	 * @return String 退出登录后跳转到的页面
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.setAttribute(Constants.USERINFO, null);
			session.invalidate();
		}
		return "redirect:login.html";
	}

	/**
     * CA 登录 还需测试，修改调整
	 * @author ZhuMingYuan
	 * @date 2018/5/15
	 * @param
	 * @return
	 */
	@RequestMapping("/CALogin")
	public String CALogin(HttpServletRequest request, Model model,String guid,String signature,String serialnumber){
		//证书B64
		String certb64 = signature;
		//签名原文，随机数，由服务器生成
		String randNum = guid;
		//签名结果，由客户端上传
		//服务器地址，需要配置测试环境
		String url = CAURL;
		//应用名，需要联系CA管理员查询
		String appname = CAUSERNAME;
		//签名证书序列号，从客户端获取
		GZCA ca = new GZCA(url,appname);
		String resultKey = ca.VerifySign(serialnumber,guid,signature);
		//1.验证该证书返回是否是200
		String[] strKey = resultKey.split("\\|");
		if(!strKey[0].equals("200")){
			log.error("CA checked failed");
			request.setAttribute("errorMsg","该Key验证不通过["+strKey[0]+"]");
			request.setAttribute("systemHostUnit", systemHostUnit);
			request.setAttribute("systemTitle", systemTitle);
			return "/login";
		}
		//通过序列号验证该key的用户是否存在
		SysUser user = userManager.getUserBySerialnumber(serialnumber);
		if (user == null) {
			log.warn("empty user");
			request.setAttribute("errorMsg", "该Key用户不存在！");
			request.setAttribute("systemHostUnit", systemHostUnit);
			request.setAttribute("systemTitle", systemTitle);
			return "/login";
		}

		if(user.getIsUsing()==Status.invalid.getKey()){
			log.warn(" user status is unenabled ");
			request.setAttribute("errorMsg", "该Key用户已被停用！");
			request.setAttribute("systemHostUnit", systemHostUnit);
			request.setAttribute("systemTitle", systemTitle);
			return "/login";
		}
		if(user.getLocked()==Whether.yes.getKey()){
			log.warn(" user is locked ");
			request.setAttribute("errorMsg", "该Key用户已被锁定！");
			request.setAttribute("systemHostUnit", systemHostUnit);
			request.setAttribute("systemTitle", systemTitle);
			return "/login";
		}

        String orgId = user.getOrgId();
        int userType = user.getUserType();
        if(StringUtils.isBlank(orgId)){
            throw new NullArgumentException("orgId can not be found !");
        }
        if (UserType.scqy.getKey().equals(userType)) {// 企业
            StdCompanys stdCompany = new StdCompanys();
            BeanUtils.copyProperties(stdCompanyManager.getById(orgId), stdCompany);
            user.setStdCompany(stdCompany);
            if(user.getStdCompany() != null) {
                StdCompanys sc = user.getStdCompany();
                user.setFatherName(sc.getCompanyName());
            }
        }

        if(user.getAcctType() == 1) {//管理帐号
            if(user.getSysDepartment() != null) {
                user.setFatherName(user.getSysDepartment().getGroupName());
            }
        }

		log.info("authentication passed");
		HttpSession session = request.getSession(true);
		session.setAttribute(Constants.USERINFO, user);
		user.setLoginIp(request.getLocalAddr());
        userManager.updateLoginInfo(user.getLoginIp(), user.getUserId());
		return "redirect:index.html";

	}
}
