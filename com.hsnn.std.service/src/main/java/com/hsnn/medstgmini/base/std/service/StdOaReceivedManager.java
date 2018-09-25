package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdOaReceived;
import com.hsnn.medstgmini.common.service.GenericManager;

public interface StdOaReceivedManager extends GenericManager<StdOaReceived, Integer> {
	// 扩展接口
	//修改
	StdOaReceived updateById(String id);
	//查看
	StdOaReceived getById(String id);
	//新增
	int save(StdOaReceived oaReceived);
	
}