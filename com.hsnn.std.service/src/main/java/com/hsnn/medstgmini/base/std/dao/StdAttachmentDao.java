package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdAttachment;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdAttachmentDao extends GenericDao<StdAttachment,String> {
	void deleteAll(String bidAttrId);
	
	List<StdAttachment> getByCodeAndId(Map<String, String> map);

	List<StdAttachment> getAttrId(Map<String, Object> paraMap);

	List<StdAttachment> getAttrByTargetId(String targetId);

	List<StdAttachment> getSignId(Map<String, Object> paraMap);

	void deleteByCodeAndId(Map<String, String> map);

	int updateByTargetId(StdAttachment attachment);
}