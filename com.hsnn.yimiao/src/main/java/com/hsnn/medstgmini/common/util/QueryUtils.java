package com.hsnn.medstgmini.common.util;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 查询工具类
 *
 * @ClassName: QueryUtils
 * @author zhou.xy
 * @date 2016年3月31日 上午9:48:00
 *
 */
public class QueryUtils {
	/**
	 * 读取request中的参数，添加到model中以供页面调用
	 *
	 * @Title: setQueryParameters
	 * @param model
	 * @param request
	 * @return void
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static void setQueryParameters(Model model, HttpServletRequest request) {
		Map<String, Object> params = request.getParameterMap();
		if (params != null && params.size() > 0) {
			Iterator<String> keys = params.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String[] value = (String[]) params.get(key);
				if (value.length > 1) {
					model.addAttribute(key, JSON.toJSONString(value));
				} else {
					model.addAttribute(key, value[0]);
				}
			}
		}
	}
}
