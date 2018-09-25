package com.hsnn.medstgmini.yimiao.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoCatalog;

import java.util.Map;


public interface YimiaoCatalogDao extends GenericDao<YimiaoCatalog, Long> {

    Page<YimiaoCatalog> getAllList(Map<String, Object> conditions);

    int addCatalog(Map<String, Object> conditions);

    int removeCatalog(Map<String, Object> conditions);

}