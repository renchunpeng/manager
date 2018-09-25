package com.hsnn.medstgmini.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hsnn.medstgmini.base.sys.model.SysReqRecord;
import com.hsnn.medstgmini.base.sys.service.SysReqRecordManager;

public class TimeInteceptor implements HandlerInterceptor {
	private static final Logger log = Logger.getLogger(TimeInteceptor.class);
	@Autowired
	private SysReqRecordManager sysReqRecordManager;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("拦截器开启。。。。");    
		long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("拦截器工作。。。。");   
		long startTime = (Long)request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        long executeTime = endTime - startTime;

        /*//modified the exisitng modelAndView
        modelAndView.addObject("executeTime",executeTime);*/

        //log it
        if(log.isDebugEnabled()){
        	log.debug("[" + handler + "] executeTime : " + executeTime + "ms");
        	SysReqRecord sysReqRecord = new SysReqRecord();
        	sysReqRecord.setExecuteContent(handler+"");
        	sysReqRecord.setExecuteTime(executeTime+"ms");
        	sysReqRecordManager.add(sysReqRecord);
        }
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("拦截器结束。。。。");  
	}

}
