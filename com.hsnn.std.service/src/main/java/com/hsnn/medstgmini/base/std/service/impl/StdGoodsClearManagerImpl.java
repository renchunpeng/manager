package com.hsnn.medstgmini.base.std.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdGoodsClearDao;
import com.hsnn.medstgmini.base.std.model.StdGoods;
import com.hsnn.medstgmini.base.std.model.StdGoodsClear;
import com.hsnn.medstgmini.base.std.service.StdGoodsClearManager;
import com.hsnn.medstgmini.base.std.service.StdGoodsManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

@Service
public class StdGoodsClearManagerImpl extends GenericManagerImpl<StdGoodsClear, Integer> implements StdGoodsClearManager {
	@Autowired
	private StdGoodsClearDao stdGoodsClearDao;
	
	@Autowired
	private StdGoodsManager stdGoodsManager;
	// 扩展接口实现
    
	/**
	 * 修改澄清状态
	 * @param form
	 * @return
	 */
	public boolean updateClearStatus(StdGoodsClear stdGoodsClear) {
		
		return stdGoodsClearDao.updateClearStatus(stdGoodsClear)>0;
	}
	
	/**
	 * 获取数据数量
	 * @param map
	 * @return
	 */
	public int getBatchCount(int goodsId) {
		return stdGoodsClearDao.getBatchCount(goodsId);
	}
	
	/**
	 * 更新中心处理信息
	 * @param stdGoodsClear
	 * @return
	 */
	public int updateHandelById(StdGoodsClear stdGoodsClear) {
		/*if(stdGoodsClear.getClearStatus() == 3) {//审核通过
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("clearColumn", stdGoodsClear.getClearColumn());//要更改的字段
			map.put("uValue", stdGoodsClear.getVafterProcess());//要更改为
			map.put("goodsId", stdGoodsClear.getGoodsId());//产品编号
			stdGoodsManager.updateColumnById(map);
		}else if(stdGoodsClear.getClearStatus() == 4){
			//获取产品澄清状态
			StdGoods stdGoods = stdGoodsManager.getById(stdGoodsClear.getGoodsId());
			if(stdGoods.getClearStatus() == 4) {//审核不通过
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("clearColumn", stdGoodsClear.getClearColumn());//要更改的字段
				map.put("uValue", stdGoodsClear.getVbeforeProcess());//要更改为
				map.put("goodsId", stdGoodsClear.getGoodsId());//产品编号
				stdGoodsManager.updateColumnById(map);
			}
			
		}*/
		return stdGoodsClearDao.update(stdGoodsClear);
	}
    @Override
	public String getSequen(){
		return stdGoodsClearDao.getSequen();
	}
	@Override
	public void goodsClear(String goodsId){
		stdGoodsClearDao.goodsClear(goodsId);
	}
}