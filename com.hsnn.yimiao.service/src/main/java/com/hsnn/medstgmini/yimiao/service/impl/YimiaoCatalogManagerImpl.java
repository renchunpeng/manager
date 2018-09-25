package com.hsnn.medstgmini.yimiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.dao.YimiaoCatalogDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoCatalog;
import com.hsnn.medstgmini.yimiao.service.YimiaoCatalogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YimiaoCatalogManagerImpl extends GenericManagerImpl<YimiaoCatalog, Long> implements YimiaoCatalogManager {
    // 扩展接口实现
    @Autowired
    YimiaoCatalogDao yimiaoCatalogDao;

    @Override
    public Pagination getCatalogList(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<YimiaoCatalog> models = yimiaoCatalogDao.getAllList(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询",page,"分页查询");
        return page;
    }

    @Override
    public int addCatalog(Pagination page) {
        return yimiaoCatalogDao.addCatalog(page.getConditions());
    }

    @Override
    public int removeCatalog(Pagination page) {
        return yimiaoCatalogDao.removeCatalog(page.getConditions());
    }

}