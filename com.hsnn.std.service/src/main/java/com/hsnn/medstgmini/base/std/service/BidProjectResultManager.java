package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.BidProjectResult;
import com.hsnn.medstgmini.common.service.GenericManager;

import java.util.Map;

public interface BidProjectResultManager extends GenericManager<BidProjectResult, String> {
	// 扩展接口
	void addProject(Map<String, Object> map);

	void updateProject(Map<String, Object> map);
	
	void updateProjectName(Map<String, Object> map);
}