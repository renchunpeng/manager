package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdPriceadjplan;
import com.hsnn.medstgmini.common.service.GenericManager;

public interface StdPriceadjplanManager extends GenericManager<StdPriceadjplan, String> {
	// 扩展接口

    void pricePlanStd();

    int updateStdPriceadjPlanShoudong(String priceAdjPlanId,String userName);
}