package com.hsnn.medstgmini.base.sys.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.base.sys.model.SysNotice;

import java.util.List;
import java.util.Map;

public interface SysNoticeManager extends GenericManager<SysNotice, String> {
	// 扩展接口
    List<SysNotice> getNoticeList(Map<String,Object> map);
}