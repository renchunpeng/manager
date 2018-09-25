package com.hsnn.medstgmini.yimiao.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseReturn;

import java.util.List;
import java.util.Map;


public interface YimiaoPurchaseReturnManager extends GenericManager<YimiaoPurchaseReturn, String> {
	// 扩展接口
	int updateByOrder(List<Map<String, String>> list);

	// 获取已经提交的退货单
    Pagination getSubmitReturn(Pagination pagination);

    // 审核
	int updateReturnStatus(Pagination pagination);

	//审核订单详情
    int updateReturnDetailStatus(Pagination pagination);

    int updateByOrderId(Map<String,Object> params);

    int updateByIdForAudit(Pagination pagination);

    int updateByOrderAmount(Map<String,Object> params);

    Pagination getReturnOrderData(Pagination pagination);

    int deleteAndUpdateData(List<String> retorderIdList);
}