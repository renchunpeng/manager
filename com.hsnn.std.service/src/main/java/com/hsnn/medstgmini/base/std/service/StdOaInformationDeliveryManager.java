package com.hsnn.medstgmini.base.std.service;

import java.util.Map;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.base.std.model.StdOaInformationDelivery;

public interface StdOaInformationDeliveryManager extends GenericManager<StdOaInformationDelivery, String> {
	// 扩展接口
	
	/**
	 * 根据编号修改状态
	 * @param map
	 * @return
	 */
	int updateStatusById(Map<String, Object> map);
}