package com.hsnn.medstgmini.base.std.dao;

import com.hsnn.medstgmini.base.std.model.StdOaReceived;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdOaReceivedDao extends GenericDao<StdOaReceived, Integer> {
	
	StdOaReceived updateById(String id);
	
	StdOaReceived getById(String id);
	
	int save(StdOaReceived oaReceived);
}