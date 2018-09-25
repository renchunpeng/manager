package com.hsnn.medstgmini.base.std.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdOaReceivedDao;
import com.hsnn.medstgmini.base.std.model.StdOaReceived;
import com.hsnn.medstgmini.base.std.service.StdOaReceivedManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

@Service
public class StdOaReceivedManagerImpl extends GenericManagerImpl<StdOaReceived, Integer> implements StdOaReceivedManager {

	@Autowired
	private StdOaReceivedDao stdOaReceivedDao;

	@Override
	public StdOaReceived getById(String id) {
		return stdOaReceivedDao.getById(id);
	}

	@Override
	public StdOaReceived updateById(String id) {
		return stdOaReceivedDao.updateById(id);
	}

	@Override
	public int save(StdOaReceived oaReceived) {
		return stdOaReceivedDao.save(oaReceived);
	}

	
    
}