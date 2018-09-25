package com.hsnn.medstgmini.base.std.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdGmpgspDao;
import com.hsnn.medstgmini.base.std.model.StdGmpgsp;
import com.hsnn.medstgmini.base.std.service.StdGmpgspManager;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.common.model.IUpdateInfo;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.SessionUtil;

@Service
public class StdGmpgspManagerImpl extends GenericManagerImpl<StdGmpgsp, Integer> implements StdGmpgspManager {
	// 扩展接口实现
	@Autowired
	private AttachmentPlug attachmentPlug;
	/**
	 * 批量更新GMPGSP状态 
	 *
	 * @Title: batchUpdate 
	 * @param ids
	 * @param stdGmpgsp
	 * @return 
	 * @return boolean
	 * @throws
	 */
	@Override
	public boolean batchUpdate(String[] ids, StdGmpgsp stdGmpgsp) {
		return ((StdGmpgspDao) getDao()).batchUpdate(ids, stdGmpgsp) > 0;
	}

	@Override
	public int updateStdGmpgsp(StdGmpgsp stdGmpgsp) {
		if(stdGmpgsp instanceof IUpdateInfo){
			((IUpdateInfo) stdGmpgsp).setLastUpdateUserId(SessionUtil.getSysUser().getUserId());
			((IUpdateInfo) stdGmpgsp).setLastUpdateUserName(SessionUtil.getSysUser().getUserName());
		}
		if(stdGmpgsp instanceof IAttachment<?>){
			attachmentPlug.processAttachment(stdGmpgsp);
		}
		return ((StdGmpgspDao) getDao()).updateStdGmpgsp(stdGmpgsp);
	}
    
}