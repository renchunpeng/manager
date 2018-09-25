package com.hsnn.medstgmini.base.sys.dao;

import com.hsnn.medstgmini.base.sys.model.SysNotice;
import com.hsnn.medstgmini.common.dao.GenericDao;

import java.util.List;
import java.util.Map;

public interface SysNoticeDao extends GenericDao<SysNotice, String> {

    SysNotice getAllById(String sysNoticeId);
    List<SysNotice> getNoticeList(Map<String,Object> map);

}
