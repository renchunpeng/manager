package com.hsnn.medstgmini.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.google.gson.Gson;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.util.Pagination;

public class ValidTokenFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(ValidTokenFilter.class);
	private static String ssologinpage = null;
	private static String indexpage = null;
	
	// 无需登录访问的连接
	private String[] exceptURL = new String[] { 
				"toResetPsw.html","sendEmail.html",
				"toForgetPWD.html","resetLink.html","resetPswTimeOut.html"};
	String header = "";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		
		header = httpRequest.getHeader("x-requested-with");
		String reqUri = httpRequest.getRequestURI();
		// 无需登陆访问的连接
		if (exceptURL != null && exceptURL.length > 0) {
			for (String url : exceptURL) {
				if (reqUri.contains(url)) {
					chain.doFilter(request, response);
					return;
				}
			}
		}
		//获取登录令牌
		Cookie[] cookies = httpRequest.getCookies();
		String loginToken = "";
		if(cookies != null){
			for(Cookie c :cookies ){
	        	if("loginToken".equals(c.getName())){
	        		loginToken = c.getValue();
	        		break;
	        	}
	        }
		}
        
        if(StringUtils.isNotBlank(loginToken)){
         	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(httpRequest.getSession().getServletContext());
    		ShardedJedisPool shardedJedisPool = (ShardedJedisPool) wac.getBean("shardedJedisPool");
    		ShardedJedis sharedJedis = shardedJedisPool.getResource();
    		SysUser user = null;
    		if(sharedJedis.exists(loginToken.getBytes())){
    			try {
					user = (SysUser)unserialize(sharedJedis.get(loginToken.getBytes()));
					sharedJedis.expire(loginToken.getBytes(), 30 * 60);//有效期 30 分钟
				} catch (Exception e) {
					log.error("",e);
				}finally {
					shardedJedisPool.returnResourceObject(sharedJedis);
				}
    			session.setAttribute("userinfo", user);
    			chain.doFilter(request, response);
    		}else{
    			PrintWriter pw = httpResponse.getWriter();
            	if (StringUtils.isNotBlank(header)&& "XMLHttpRequest".equalsIgnoreCase(header)){
            		Pagination page = new Pagination();
    				page.setSuccess(false);
    				page.setCode(403);
    				page.setMsg(" 您已超时，请重新登录!");
    				Gson gson = new Gson();
    				String str = gson.toJson(page);
    				pw.write(str);
            	}else{
            		pw.write("<script type='text/javascript'>");
        			pw.write("top.location = '" + ssologinpage + "?service="+indexpage+"';");
        			pw.write("</script>");
            	}
            	pw.flush();
    			pw.close();
    		}
        }else{
        	PrintWriter pw = httpResponse.getWriter();
        	if (StringUtils.isNotBlank(header)&& "XMLHttpRequest".equalsIgnoreCase(header)){
        		Pagination page = new Pagination();
				page.setSuccess(false);
				page.setCode(403);
				page.setMsg(" 您已超时，请重新登录!");
				Gson gson = new Gson();
				String str = gson.toJson(page);
				pw.write(str);
        	}else{
        		pw.write("<script type='text/javascript'>");
    			pw.write("top.location = '" + ssologinpage + "?service="+indexpage+"';");
    			pw.write("</script>");
        	}
        	pw.flush();
			pw.close();
        	
        }
       
	}
	

   
    
    @SuppressWarnings("unchecked")
	public void init(FilterConfig cfg) throws ServletException {
		String parName = null;
		Enumeration<String> names = cfg.getInitParameterNames();
		while (names.hasMoreElements()) {
			parName = names.nextElement();
			if ("indexpage".equals(parName)) {
				indexpage = cfg.getInitParameter(parName);
				continue;
			}

			if ("ssologinpage".equals(parName)) {
				ssologinpage = cfg.getInitParameter(parName);
				continue;
			}

		}
	}
    
    @Override
	public void destroy() {
	}
	
    
    public static byte[] serialize(Object object) {
    	ObjectOutputStream oos = null;
    	ByteArrayOutputStream baos = null;
    	try {
	    	//序列化
	    	baos = new ByteArrayOutputStream();
	    	oos = new ObjectOutputStream(baos);
	    	oos.writeObject(object);
	    	byte[] bytes = baos.toByteArray();
	    	return bytes;
    	} catch (Exception e) {
    		log.error("Failed to serialize object to Redis Server:" + e.getMessage());
    	}
    	return null;
    }
    
    public static Object unserialize(byte[] bytes) {
    	ByteArrayInputStream bais = null;
    	try {
	    	//反序列化
	    	bais = new ByteArrayInputStream(bytes);
	    	ObjectInputStream ois = new ObjectInputStream(bais);
	    	return ois.readObject();
    	} catch (Exception e) {
    		log.error("Failed to unserialize object from Redis Server:" + e.getMessage());
    	}
    	return null;
    }
}
