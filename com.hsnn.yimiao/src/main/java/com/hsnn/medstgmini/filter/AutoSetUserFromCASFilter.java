package com.hsnn.medstgmini.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

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

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;

public class AutoSetUserFromCASFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(AutoSetUserFromCASFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		
		// 从CAS中获取登录用户名
		String userName = AssertionHolder.getAssertion().getPrincipal().getName();
		log.info("userName for CAS context:" + userName);
		
		// 如session中已经存在用户信息，则不再从Redis Server中加载
		if (session.getAttribute(Constants.USERINFO) != null) {
			chain.doFilter(request, response);
			return;
		}
		
		// 根据userName从redis服务器中取出SysUser对象，并放入Session。
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(httpRequest.getSession().getServletContext());
		ShardedJedisPool shardedJedisPool = (ShardedJedisPool) wac.getBean("shardedJedisPool");;
		ShardedJedis sharedJedis = null;
		SysUser user = null;
        try {
        	sharedJedis = shardedJedisPool.getResource();
        	user = (SysUser)unserialize(sharedJedis.get(userName.getBytes()));
        	if (user != null) {
        		log.info("It's ok to get 'SysUser Object' from 'Redis Server':" + user.getUserName());
        	} else {
        		log.error("It's failed to get 'SysUser Object' from 'Redis Server'");
        	}
        	log.info("SysUser properties: username=" + user.getUserName());
        } catch (Exception e) {
        	log.error("It's failed to get 'SysUser Object' from 'Redis Server':" + e.getMessage());
        	return;
        } finally {
        	shardedJedisPool.returnResourceObject(sharedJedis);
        }
        session.setAttribute(Constants.USERINFO, user);
		
		
		/*
		if (session.getAttribute(Constants.USERINFO) == null) { // 本地认证未曾通过
			
			// 从CAS中获取登录用户名
			String userName = AssertionHolder.getAssertion().getPrincipal().getName();
			
			if (userName == null) {  // 未曾通过CAS认证；正常不会出现这种情况，可能是CAS TGT已过期
				
				log.info("CAS auth has not passed! userName:" + userName);
				// Do nothing
				
			} else {  // 已通过CAS认证;需要对session进行赋值
				
				// CAS认证已通过的情况; 需要给session设置用户的值 
				log.info("CAS auth has passed! userName:" + userName);
				
				// 用户的其它信息通过以下方式获取  
				Map userInfoMap = AssertionHolder.getAssertion().getPrincipal().getAttributes();
				String name = (String)userInfoMap.get("name");
				log.info("CAS attr name:" + name);
				
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(httpRequest.getSession().getServletContext());
				SysUserManager userManager = (SysUserManager) wac.getBean("sysUserManagerImpl");
				SysUser user = userManager.getUserByUsername(userName);
				
				if (user == null) {
					log.info("empty user");
					outputErrorInfo(httpRequest, httpResponse, "用户名不存在！");
					return;
				}
				
				if(user.getIsUsing() == Status.invalid.getKey()){
					log.info(" user status is unenabled ");
					outputErrorInfo(httpRequest, httpResponse, "该用户已被停用！");
					return;
				}
				
				if(user.getLocked() == Whether.yes.getKey()){
					log.info(" user is locked ");
					outputErrorInfo(httpRequest, httpResponse, "该用户已被锁定！");
					return;
				}
				
				session.setAttribute(Constants.USERINFO, user);
			}
				
			
		} else { // 本地认证已通过
			
			//什么都不做
		}
		*/
		
		chain.doFilter(request, response);
	}
	
	private void outputErrorInfo(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String errorMsg) throws IOException {
		
		HttpSession session = httpRequest.getSession(true);
		String header = httpRequest.getHeader("x-requested-with");
		String ctx = session.getServletContext().getContextPath();
		
		PrintWriter pw = httpResponse.getWriter();
		pw.write(errorMsg);
		pw.flush();
		pw.close();
		return;
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
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
