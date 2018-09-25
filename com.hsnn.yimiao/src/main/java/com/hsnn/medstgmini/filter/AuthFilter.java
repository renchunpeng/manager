package com.hsnn.medstgmini.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.util.Pagination;

/**
 * @category 常量类
 * @author 单大伟123
 * @date 2015-06-10
 */
public class AuthFilter implements Filter {

	private static final Logger log = Logger.getLogger(AuthFilter.class);
	private static String homepage = null;
	private static String loginpage = null;
	private static String cssfolder = null;
	private static String jsfolder = null;

	// 无需登录访问的连接
	private String[] exceptURL = new String[] { "loginAuth.html", "login.html",
			"logout.html", "toUserRegister.html", "toRegisterHospital.html","toRegHealthbureau.html",
			"toRegisterCompany.html", "getHospType.html", "getArea.html",
			"saveRegHospInfo.html", "saveRegCompInfo.html", "saveRegComp.html","saveRegheaBurInfo.html",
			"getDicCompType.html", "getStdCompGroup.html", "403.jsp",
			"404.jsp", "405.jsp", "500.jsp", 
			"toResetPsw.html","resetLink.html","sendEmail.html","backInterface.html","CALogin.html"
	};

	String ctx = "";
	String header = "";

	/**
	 * @category 判断用户是否已登陆
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param request
	 *            ServletRequest http请求
	 * @param response
	 *            ServletResponse http回应
	 * @param chian
	 *            FilterChain 过滤器链
	 * @return true 访问登录页面 false 访问其他功能页面
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		String reqUri = httpRequest.getRequestURI();
		ctx = session.getServletContext().getContextPath();
		header = httpRequest.getHeader("x-requested-with");

		if ((ctx + "/").equals(reqUri)) {
			reqUri += "index.html";
		}

		// css目录|js目录|验证码直接访问
		if (reqUri.contains(cssfolder) || reqUri.contains(jsfolder)
				|| reqUri.contains("/captchaImg")) {
			if (log.isDebugEnabled()) {
				// log.debug("ignore request for css and javascript.");
			}
			chain.doFilter(request, response);
			return;
		}

		// 无需登陆访问的连接
		if (exceptURL != null && exceptURL.length > 0) {
			for (String url : exceptURL) {
				if (reqUri.contains(url)) {
					chain.doFilter(request, response);
					return;
				}
			}
		}

		if (isLoginUser(session)) { // 已登入
			int start = reqUri.indexOf(ctx) + ctx.length();
			int end = reqUri.indexOf("?");
			String subUrl = "";
			if (start >= 0) {
				subUrl = reqUri.substring(start);
			} else if (start >= 0 && start < end) {
				subUrl = reqUri.substring(start, end);
			}

			// 校验是否拥有此权限
			boolean hasPriv = false;
			Object obj = session.getAttribute(Constants.USER_RESOURCE);
			List<String> privList = (List<String>) obj;
			if (privList != null && !privList.isEmpty()) {
				for (String priv : privList) {
					if (priv.indexOf(subUrl) >= 0) {
						hasPriv = true;
						break;
					}
				}
			}

			// 登入后即有主页访问权限
			if ("/index.html".indexOf(subUrl) >= 0
					|| "/home.jsp".indexOf(subUrl) >= 0) {
				hasPriv = true;
			}

			/* -------------------- */
			/* 权限不校验(发布时删除) start */
			hasPriv = true;
			/* 权限不校验(发布时删除) end */
			/* -------------------- */

			if (hasPriv) { // 有权限访问
				chain.doFilter(httpRequest, httpResponse);
			} else { // 无权限访问
				PrintWriter pw = httpResponse.getWriter();
				if (StringUtils.isNotBlank(header)
						&& "XMLHttpRequest".equalsIgnoreCase(header)) { // ajax请求
					Pagination page = new Pagination();
					page.setSuccess(false);
					page.setCode(403);
					page.setMsg(" 您没有权限访问此页面，请与管理员联系以查明您是否有访问权限!");
					Gson gson = new Gson();
					String str = gson.toJson(page);
					pw.write(str);
				} else { // jsp请求
					pw.write("<script type='text/javascript'>");
					pw.write("location = '" + ctx + "/403.jsp';");
					pw.write("</script>");
				}
				pw.flush();
				pw.close();
			}
			return;
		} else { // 未登入
			PrintWriter pw = httpResponse.getWriter();
			if (StringUtils.isNotBlank(header)
					&& "XMLHttpRequest".equalsIgnoreCase(header)) { // ajax请求
				Pagination page = new Pagination();
				page.setSuccess(false);
				page.setCode(403);
				page.setMsg(" 您没有权限访问此页面，请与管理员联系以查明您是否有访问权限!");
				Gson gson = new Gson();
				String str = gson.toJson(page);
				pw.write(str);
			} else { // jsp请求
				pw.write("<script type='text/javascript'>");
				pw.write("top.location = '" + ctx + "/" + loginpage + "';");
				pw.write("</script>");
			}
			pw.flush();
			pw.close();
			return;
		}

	}

	/**
	 * @category 是否是登录用户
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param session
	 *            HttpSession http会话
	 * @return true 访问登录页面 false 访问其他功能页面
	 */
	protected boolean isLoginUser(HttpSession session) {
		// login user must have the username in session
		SysUser sysUser = (SysUser) session.getAttribute(Constants.USERINFO);
		return sysUser != null;
	}

	/**
	 * @category 是否访问登录页面
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param sevReq
	 *            HttpServletRequest
	 * @param reqUri
	 *            请求路径
	 * @return true 访问登录页面 false 访问其他功能页面
	 */
	protected boolean isLoginPage(HttpServletRequest sevReq, String reqUri) {
		return reqUri.contains(loginpage) || reqUri.contains("login.html")
				|| reqUri.contains("loginAuth.html")
				|| reqUri.contains("toUserRegister.html")
				|| reqUri.contains("toRegisterHospital.html")
				|| reqUri.contains("toRegisterCompany.html")
				|| reqUri.contains("getHospType.html")
				|| reqUri.contains("getArea.html")
				|| reqUri.contains("saveRegHospInfo.html")
				|| reqUri.equals(sevReq.getContextPath() + "/");
	}

	/**
	 * @category 过滤器初始化
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param cfg
	 *            过滤器配置
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	public void init(FilterConfig cfg) throws ServletException {
		// get the login page and homepage
		String parName = null;
		Enumeration<String> names = cfg.getInitParameterNames();
		while (names.hasMoreElements()) {
			parName = names.nextElement();
			if (Constants.HOMEPAGE.equals(parName)) {
				homepage = cfg.getInitParameter(parName);
				continue;
			}

			if (Constants.LOGINPAGE.equals(parName)) {
				loginpage = cfg.getInitParameter(parName);
				continue;
			}

			if (Constants.CSS_FOLDER.equals(parName)) {
				cssfolder = cfg.getInitParameter(parName);
				continue;
			}

			if (Constants.JS_FOLDER.equals(parName)) {
				jsfolder = cfg.getInitParameter(parName);
				continue;
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("homepage=" + homepage + ", loginpage=" + loginpage
					+ ", cssfolder=" + cssfolder + ", jsfolder=" + jsfolder);
		}
	}

	public void destroy() {
	}
}