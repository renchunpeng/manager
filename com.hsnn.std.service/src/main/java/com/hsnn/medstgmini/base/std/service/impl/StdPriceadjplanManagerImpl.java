package com.hsnn.medstgmini.base.std.service.impl;

import com.hsnn.medstgmini.base.std.dao.StdPriceadjplanDao;
import com.hsnn.medstgmini.base.std.model.StdPriceadjplan;
import com.hsnn.medstgmini.base.std.service.StdPriceadjplanManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StdPriceadjplanManagerImpl extends GenericManagerImpl<StdPriceadjplan, String> implements StdPriceadjplanManager {
    @Autowired
    private StdPriceadjplanDao dao;
    @Override
    public void pricePlanStd() {
        dao.pricePlanStd();
    }

    @Override
    public int updateStdPriceadjPlanShoudong(String priceAdjPlanId,String userName) {
        StdPriceadjplan stdPriceadjplan = dao.get(priceAdjPlanId);
        stdPriceadjplan.setStatus(1);
        stdPriceadjplan.setUpdUser(userName);
        stdPriceadjplan.setExecuteDatetime(new Date());
        int count = dao.updateStdPriceadjplan(stdPriceadjplan);
        dao.stdPriceadjplanShoudong(priceAdjPlanId);
        return count;
    }
    // 扩展接口实现
    
}