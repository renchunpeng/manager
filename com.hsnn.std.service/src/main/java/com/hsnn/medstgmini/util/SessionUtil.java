package com.hsnn.medstgmini.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;

/**
 * 一些基于session 的东西
 * @author ZXL
 *
 */
public class SessionUtil {
	private static ServletRequestAttributes getRequestAttr() {
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}

	public static HttpServletRequest getRequest() {
		return getRequestAttr().getRequest();
	}
	
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static SysUser getSysUser() {
		return (SysUser)getSession().getAttribute(Constants.USERINFO);
	}
	
	public static <T> T getOrgInfo() {
		return getSysUser().getInfo();
	}
	
	public static <T> T getBeanOfType(Class<T> clazz) {
		return getApplication().getBean(clazz);
	}
	
	private static WebApplicationContext getApplication() {
		ServletContext servletContext = SessionUtil.getSession().getServletContext();
		return WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		return (T) getApplication().getBean(beanName);
	}
	
}
