package com.hsnn.medstgmini.base.std.dao;

import com.hsnn.medstgmini.base.std.model.BidProjectResult;
import com.hsnn.medstgmini.common.dao.GenericDao;

import java.util.Map;

public interface BidProjectResultDao extends GenericDao<BidProjectResult, String> {

	void addProject(Map<String, Object> map);

	void updateProject(Map<String, Object> map);

	void updateProjectName(Map<String, Object> map);
}