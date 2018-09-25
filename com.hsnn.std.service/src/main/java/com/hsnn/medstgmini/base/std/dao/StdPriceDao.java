package com.hsnn.medstgmini.base.std.dao;



import java.util.List;

import com.hsnn.medstgmini.base.std.model.StdGoods;
import com.hsnn.medstgmini.base.std.model.StdPrice;
import com.hsnn.medstgmini.common.dao.GenericDao;


public interface StdPriceDao extends GenericDao<StdPrice, String> {
	
	/**
	 * 验证产品是否重复：
	 * 判断归档号是否重否；通用名、剂型、规格、转换系数；包装材质；包装单位；生产企业；分包装企业重复
	 *
	 * @Title: checkRepeat 
	 * @param stdGoods
	 * @return 
	 * @return int
	 * @throws
	 */
	public List<StdPrice> checkRepeat(StdPrice stdPrice);
	
	int returnLastId();

	public int updateAdjustPlan(StdPrice stdPrice);
}