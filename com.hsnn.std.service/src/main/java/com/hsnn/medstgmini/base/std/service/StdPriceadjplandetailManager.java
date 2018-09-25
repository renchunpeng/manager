package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdPriceadjplandetail;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

public interface StdPriceadjplandetailManager extends GenericManager<StdPriceadjplandetail, String> {
	// 扩展接口
    //产品调价
    Pagination getPlanGoddsResult(Pagination page);
}