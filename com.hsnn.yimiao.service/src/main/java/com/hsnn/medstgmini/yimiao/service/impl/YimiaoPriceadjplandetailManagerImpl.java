package com.hsnn.medstgmini.yimiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.dao.YimiaoPriceadjplandetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsnn.medstgmini.yimiao.service.YimiaoPriceadjplandetailManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

import com.hsnn.medstgmini.yimiao.model.YimiaoPriceadjplandetail;

@Service
public class YimiaoPriceadjplandetailManagerImpl extends GenericManagerImpl<YimiaoPriceadjplandetail, String> implements YimiaoPriceadjplandetailManager {
	// 扩展接口实现
    @Autowired
    private YimiaoPriceadjplandetailDao detailDao;
    @Override
    public Pagination getPlanGoods(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<YimiaoPriceadjplandetail> models = detailDao.getPlanGoods(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询",page,"分页查询");
        return page;
    }
}