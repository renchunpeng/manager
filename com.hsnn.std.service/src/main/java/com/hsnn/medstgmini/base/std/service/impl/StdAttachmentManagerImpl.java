package com.hsnn.medstgmini.base.std.service.impl;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdAttachmentDao;
import com.hsnn.medstgmini.base.std.model.StdAttachment;
import com.hsnn.medstgmini.base.std.service.StdAttachmentManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
/**
 * 
 * @author ZXL
 *
 */
@Service
public class StdAttachmentManagerImpl extends GenericManagerImpl<StdAttachment, String> implements StdAttachmentManager {
	@Autowired
	private StdAttachmentDao stdAttachmentDao;
	
	@Value("${system.uploadPath}")
	private String uploadPath;
	
	@Value("${system.sysId}")
	private String sysId;
	
	@Override
	public int addAttachmentByStream(StdAttachment baseInfo,OutputStream os) {
		return add(baseInfo);
	}

	@Override
	public void deleteAll(String bidAttrId) {
		stdAttachmentDao.deleteAll(bidAttrId);
	}

	@Override
	public List<StdAttachment> getByCodeAndId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return stdAttachmentDao.getByCodeAndId(map);
	}
	
	@Override
	public List<StdAttachment> getAttrId(Map<String, Object> paraMap) {
		return stdAttachmentDao.getAttrId(paraMap);
	}

	@Override
	public List<StdAttachment> getAttrByTargetId(String targetId) {
		return stdAttachmentDao.getAttrByTargetId(targetId);
	}

	@Override
	public List<StdAttachment> getSignId(Map<String, Object> paraMap) {
		return stdAttachmentDao.getSignId(paraMap);
	}

	@Override
	public void deleteByCodeAndId(Map<String, String> map) {
		stdAttachmentDao.deleteByCodeAndId(map);
	}

	@Override
	public int updateByTargetId(StdAttachment attachment) {
		return this.stdAttachmentDao.updateByTargetId(attachment);
	}
   
}