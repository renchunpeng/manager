package com.hsnn.medstgmini.base.std.service.impl;

import com.hsnn.medstgmini.base.std.dao.BidProjectResultDao;
import com.hsnn.medstgmini.base.std.model.BidProjectResult;
import com.hsnn.medstgmini.base.std.service.BidProjectResultManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BidProjectResultManagerImpl extends GenericManagerImpl<BidProjectResult, String> implements BidProjectResultManager {
	// 扩展接口实现
	@Autowired
	private BidProjectResultDao bidProjectResultDao;
	
	@Override
	public void addProject(Map<String,Object> map) {
		bidProjectResultDao.addProject(map);
	}

	@Override
	public void updateProject(Map<String,Object> map) {
		bidProjectResultDao.updateProject(map);
	}

	@Override
	public void updateProjectName(Map<String, Object> map) {
		bidProjectResultDao.updateProjectName(map);
		
	}
	
}