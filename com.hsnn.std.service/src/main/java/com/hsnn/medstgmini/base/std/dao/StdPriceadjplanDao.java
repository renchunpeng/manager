package com.hsnn.medstgmini.base.std.dao;

import com.hsnn.medstgmini.base.std.model.StdPriceadjplan;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdPriceadjplanDao extends GenericDao<StdPriceadjplan, String> {
    void pricePlanStd();

    int updateStdPriceadjplan(StdPriceadjplan stdPriceadjplan);

    void stdPriceadjplanShoudong(String goodsId);
}