
package com.hsnn.medstgmini.base.std.dao;

import com.hsnn.medstgmini.base.std.model.StdGoodsClear;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdGoodsClearDao  extends GenericDao<StdGoodsClear, Integer> {
	// 扩展自定义查询
	
	/**
	 * 修改澄清状态
	 * @param form
	 * @return
	 */
	int updateClearStatus(StdGoodsClear stdGoodsClear);
	
	/**
	 * 获取数据数量
	 * @param goodsId
	 * @return
	 */
	int getBatchCount(int GoodsId);

	String getSequen();

	void goodsClear(String goodsId);
}
