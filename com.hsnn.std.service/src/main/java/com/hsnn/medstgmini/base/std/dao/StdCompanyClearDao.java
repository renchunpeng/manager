
package com.hsnn.medstgmini.base.std.dao;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdCompanyClear;
import com.hsnn.medstgmini.common.dao.GenericDao;

import java.util.Map;

public interface StdCompanyClearDao  extends GenericDao<StdCompanyClear, Integer> {
	// 扩展自定义查询
	/*
	 * 获取批次数量
	 * 
	 * */
	public Integer getBatchCount(String companyId);
	
	/*
	 * 更新状态
	 * 
	 * */
	public void updateClearStatus(StdCompanyClear stdCompanyClear);

	/**
	 * 根据ID获取对象信息
	 */
	public StdCompanyClear load(String clearId);

	/**
	 * 根据ID删除对象
	 */
	public int deleteById(String clearId);
	
	/**
	 * 企业名称变更同步更新
	 */
	void updateScChangeSynchronizing(@Param("companyId") String companyId,@Param("companyName")String companyName);
	void updatePsChangeSynchronizing(@Param("companyId") String companyId,@Param("companyName")String companyName);

    void insertInfo(Map<String,Object> map);
}
