package com.hsnn.medstgmini.common.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.dao.SysSequenceDao;
import com.hsnn.medstgmini.base.sys.model.SysSequence;
import com.hsnn.medstgmini.common.service.CommonService;

@Service
@Scope("singleton")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SysSequenceDao dao;

	
	@Override
	public String getSequence(Integer userType) {
		String sequence = null;
		
			 SysSequence ss=dao.getSequence(userType);
			if (ss != null) {
				String seq = ss.getSequenceNum();
				if (StringUtils.isNotBlank(seq)) {
					sequence = seq;
					Integer sequence2 = Integer.valueOf(sequence) + 1;
					// 0 代表前面补充0      
					// 4 代表长度为4      
					// d 代表参数为正数型      
					sequence = String.format("%03d", Integer.valueOf(sequence2)); 
					ss.setSequenceNum(sequence);
					dao.UpdateSequence(userType,sequence);
				}
			}
		return sequence;
	}
}