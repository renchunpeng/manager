package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdGoodsClear;
import com.hsnn.medstgmini.common.service.GenericManager;

public interface StdGoodsClearManager extends GenericManager<StdGoodsClear, Integer> {
	// 扩展接口
	
	
	/**
	 * 修改澄清状态
	 * @param form
	 * @return
	 */
	boolean updateClearStatus(StdGoodsClear stdGoodsClear);
	
	/**
	 * 获取数据数量
	 * @param map
	 * @return
	 */
	int getBatchCount(int goodsId);
	
	/**
	 * 更新中心处理信息
	 * @param stdGoodsClear
	 * @return
	 */
	int updateHandelById(StdGoodsClear stdGoodsClear);

	String getSequen();

	void goodsClear(String goodsId);
}