package com.hsnn.medstgmini.base.sys.service.impl;

import com.hsnn.medstgmini.base.sys.dao.SysNoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsnn.medstgmini.base.sys.service.SysNoticeManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

import com.hsnn.medstgmini.base.sys.model.SysNotice;

import java.util.List;
import java.util.Map;

@Service
public class SysNoticeManagerImpl extends GenericManagerImpl<SysNotice, String> implements SysNoticeManager {
	// 扩展接口实现
    @Autowired
    private SysNoticeDao sysNoticeDao;

    @Override
    public List<SysNotice> getNoticeList(Map<String,Object> map) {

        List<SysNotice> departments = sysNoticeDao.getNoticeList(map);

        for (int i = 0; i < departments.size(); i++) {
            String content=String.valueOf(departments.get(i).getContent());
            departments.get(i).setContent(content);
        }
        return departments;
    }
}