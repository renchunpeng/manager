package com.hsnn.medstgmini.base.std.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdPriceDao;
import com.hsnn.medstgmini.base.std.model.StdPrice;
import com.hsnn.medstgmini.base.std.service.StdPriceManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;


@Service
public class StdPriceManagerImpl extends GenericManagerImpl<StdPrice, String> implements StdPriceManager {
	@Autowired
	private StdPriceDao stdPriceDao;
	@Override
	public int returnLastId() {
		return stdPriceDao.returnLastId();
	}
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
	public boolean checkRepeat(StdPrice stdPrice) {
		List<StdPrice> list= ((StdPriceDao)getDao()).checkRepeat(stdPrice);
		if(list.size()>0){
			if(null != stdPrice.getGoodsId()&& list.size()==1){
				StdPrice sg= list.get(0);
				boolean temp = sg.getGoodsId().equals(stdPrice.getGoodsId()); 
				return !temp;
			}
			return true;
		}
		return false;
	}

	@Override
	public StdPrice getById(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
	// 扩展接口实现
	@Override
	public int updateAdjustPlan(StdPrice stdPrice) {
		return stdPriceDao.updateAdjustPlan(stdPrice);
	}
    
}