package com.hsnn.medstgmini.yimiao.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoCatalog;

public interface YimiaoCatalogManager extends GenericManager<YimiaoCatalog, Long> {
	// 扩展接口
    Pagination getCatalogList(Pagination page);

    int addCatalog(Pagination page);

    int removeCatalog(Pagination page);
}