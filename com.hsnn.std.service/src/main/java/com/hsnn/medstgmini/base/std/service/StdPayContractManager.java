package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdPayContract;

public interface StdPayContractManager extends GenericManager<StdPayContract, String> {

	StdPayContract getInfoById(Map<String, Object> map);
	// 扩展接口

	void updateIsSignYht(Map<String, Object> map);
	
	/**
	 * 获取所有的支付医疗机构信息
	 * @date 2016年7月27日 16:48:49
	 * lil
	 * @param page
	 * @return
	 */
	Pagination getPayHospList(Pagination page);
	
	/**
	 * 根据机构编号修改支付方式等信息
	 * @param map
	 * @return
	 */
	int updateHospPayModeByOrgId(Map<String, Object> map);
}