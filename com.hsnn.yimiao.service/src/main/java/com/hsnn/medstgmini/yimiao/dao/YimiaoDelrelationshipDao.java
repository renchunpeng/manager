package com.hsnn.medstgmini.yimiao.dao;

import java.util.Map;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoDelrelationship;

public interface YimiaoDelrelationshipDao extends GenericDao<YimiaoDelrelationship, java.lang.String>{

	
	void deleteRelation(Map<String, Object> map);
	
	void insertRelation(YimiaoDelrelationship relation);
	
	Page<YimiaoDelrelationship> findRelation(Map<String, Object> map);
}
