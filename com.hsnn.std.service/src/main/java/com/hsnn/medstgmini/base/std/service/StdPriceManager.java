package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdPrice;
import com.hsnn.medstgmini.common.service.GenericManager;


public interface StdPriceManager extends GenericManager<StdPrice, String> {
	// 扩展接口
	/**
	 * 验证产品是否重复：
	 * 判断归档号是否重否；通用名、剂型、规格、转换系数；包装材质；包装单位；生产企业；分包装企业重复 
	 *
	 * @Title: checkRepeat 
	 * @param stdGoods
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean checkRepeat(StdPrice stdPrice);

	StdPrice getById(int parseInt);
	
	int returnLastId();

	int updateAdjustPlan(StdPrice stdPrice);
}