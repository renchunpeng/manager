package com.hsnn.medstgmini.yimiao.service;


import java.util.Map;

import com.hsnn.medstgmini.util.Pagination;

public interface YimiaoDelrelationshipManager {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	Pagination getYimiaoDelrelationshipList(Pagination page);
	
	/**
	 * 添加
	 * @param map
	 * @return
	 */
	boolean addYimiaoDelrelationship(Map<String,Object> map);
	
	/**
	 * 删除
	 * @param map
	 * @return
	 */
	boolean delYimiaoDelrelationship(Map<String,Object> map);


	/**
	 * 获取配送企业
	 * @param page
	 * @return
	 */
    Pagination yimiaoCompanyPs(Pagination page);
}
