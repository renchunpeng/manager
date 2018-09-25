package com.hsnn.medstgmini.base.std.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdPriceadjplandetailDao;
import com.hsnn.medstgmini.base.std.model.StdPriceadjplandetail;
import com.hsnn.medstgmini.base.std.service.StdPriceadjplandetailManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StdPriceadjplandetailManagerImpl extends GenericManagerImpl<StdPriceadjplandetail, String> implements StdPriceadjplandetailManager {
    @Autowired
    private StdPriceadjplandetailDao stdPriceadjplandetailDao;
    @Override
    public Pagination getPlanGoddsResult(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<StdPriceadjplandetail> models = stdPriceadjplandetailDao.getPlanGoddsResult(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询",page,"分页查询");
        return page;

    }
    
}