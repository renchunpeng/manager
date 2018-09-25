package com.hsnn.medstgmini.yimiao.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoPriceadjplandetail;

public interface YimiaoPriceadjplandetailManager extends GenericManager<YimiaoPriceadjplandetail, String> {
	// 扩展接口
    Pagination getPlanGoods(Pagination page);
}