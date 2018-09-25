package com.hsnn.medstgmini.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;

public class NoNeedToLoginFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(NoNeedToLoginFilter.class);
	
	private static String[] excludesURL = new String[] {"caCertification.html","getNotice.html","getUser.html","backInterface.html"};

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		
		String requestUri = httpRequest.getRequestURI();
		if (excludesURL != null && excludesURL.length > 0) {
			for (String url : excludesURL) {
				if (requestUri.endsWith("/" + url) || requestUri.endsWith("\\" + url)) {
					String servletPath = httpRequest.getServletPath();
					request.getRequestDispatcher(servletPath).forward(request, response);
					
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
