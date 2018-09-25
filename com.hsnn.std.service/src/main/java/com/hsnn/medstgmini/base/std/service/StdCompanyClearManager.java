package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdCompanyClear;
import com.hsnn.medstgmini.common.service.GenericManager;

import java.util.Map;

public interface StdCompanyClearManager extends GenericManager<StdCompanyClear, Integer> {

	Integer getBatchCount(String companyId);
	// 扩展接口

	void updateClearStatus(StdCompanyClear stdCompanyClear);
	
	/**
	 * 更新中心处理信息
	 * @param stdCompanyClear
	 * @return
	 */
	int updateHandelById(StdCompanyClear stdCompanyClear);

	/**
	 * 根据ID获取对象
	 */
	StdCompanyClear load(String clearId);

	/**
	 * 根据ID删除数据
	 */
	int deleteById(String clearId);
	
	/**
	 * 企业名称变更同步更新
	 */
	void updateScChangeSynchronizing(String companyId,String companyName);
	void updatePsChangeSynchronizing(String companyId,String companyName);

    void insertInfo(Map<String,Object> map);
}