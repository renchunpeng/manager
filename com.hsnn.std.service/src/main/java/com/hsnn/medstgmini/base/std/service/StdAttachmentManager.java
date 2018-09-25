package com.hsnn.medstgmini.base.std.service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdAttachment;
import com.hsnn.medstgmini.common.service.GenericManager;

/**
 * 
 * @author ZXL
 *
 */
public interface StdAttachmentManager extends GenericManager<StdAttachment, String> {
	int addAttachmentByStream(StdAttachment baseInfo,OutputStream os);
	void deleteAll(String bidAttrId);

	List<StdAttachment> getByCodeAndId(Map<String, String> map);
	
	List<StdAttachment> getAttrId(Map<String, Object> paraMap);

	List<StdAttachment> getAttrByTargetId(String targetId);

	List<StdAttachment> getSignId(Map<String, Object> paraMap);

	void deleteByCodeAndId(Map<String, String> map);
	
	int updateByTargetId(StdAttachment attachment);
}