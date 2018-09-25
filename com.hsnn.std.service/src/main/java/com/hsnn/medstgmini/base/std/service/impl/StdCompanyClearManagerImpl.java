package com.hsnn.medstgmini.base.std.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdCompanyClearDao;
import com.hsnn.medstgmini.base.std.model.StdCompanyClear;
import com.hsnn.medstgmini.base.std.service.StdCompanyClearManager;
import com.hsnn.medstgmini.base.std.service.StdCompanyManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

import java.util.Map;

@Service
public class StdCompanyClearManagerImpl extends GenericManagerImpl<StdCompanyClear, Integer> implements StdCompanyClearManager {
	// 扩展接口实现
    
	@Autowired
	private StdCompanyClearDao clearDao;
	
	@Autowired
	private StdCompanyManager  stdCompanyManager;
	/*
	 * 获取批次数量
	 * 
	 * */
	@Override
	public Integer getBatchCount(String companyId){
		return clearDao.getBatchCount(companyId);
	}
	
	/*
	 * 更新状态
	 * 
	 * */
	@Override
	public void updateClearStatus(StdCompanyClear stdCompanyClear){
		clearDao.updateClearStatus(stdCompanyClear);
	}
	
	/**
	 * 更新中心处理信息
	 * @param stdCompanyClear
	 * @return
	 */
	@Override
	public int updateHandelById(StdCompanyClear stdCompanyClear) {
		/*if(stdCompanyClear.getClearStatus() == 3) {//审核通过
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("clearColumn", stdCompanyClear.getClearColumn());//要更改的字段
			map.put("uValue", stdCompanyClear.getVafterProcess());//要更改为
			map.put("companyId", stdCompanyClear.getCompanyId());//企业编号
			stdCompanyManager.updateColumnById(map);
		}else if(stdCompanyClear.getClearStatus() == 4){
			//获取产品澄清状态
			StdCompany stdCompany = stdCompanyManager.getById(stdCompanyClear.getCompanyId());
			if(stdCompany.getClearStatus() == 4) {//审核不通过
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("clearColumn", stdCompanyClear.getClearColumn());//要更改的字段
				map.put("uValue", stdCompanyClear.getVbeforeProcess());//要更改为
				map.put("companyId", stdCompanyClear.getCompanyId());//企业编号
				stdCompanyManager.updateColumnById(map);
			}
			
		}*/
		return clearDao.update(stdCompanyClear);
	}

	/**
	 * 根据ID的获取对象
	 * @param clearId
	 * @return
	 */
	@Override
	public StdCompanyClear load(String clearId) {
		return clearDao.load(clearId);
	}

	/**
	 * 根据ID删除对象
	 */
	@Override
	public int deleteById(String clearId) {
		return clearDao.deleteById(clearId);
	}

	@Override
	public void updateScChangeSynchronizing(String companyId, String companyName) {
		clearDao.updateScChangeSynchronizing(companyId,companyName);
		
	}

	@Override
	public void updatePsChangeSynchronizing(String companyId, String companyName) {
		clearDao.updatePsChangeSynchronizing(companyId,companyName);
		
	}

	@Override
	public void insertInfo(Map<String,Object> map) {
		clearDao.insertInfo(map);
	}
}