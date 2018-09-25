package com.hsnn.medstgmini.yimiao.dao;

import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseReturn;

import java.util.List;
import java.util.Map;

public interface YimiaoPurchaseReturnDao extends GenericDao<YimiaoPurchaseReturn, String> {
	int updateByOrder(List<Map<String, String>> list);

    int updateReturnStatus(Map<String, Object> conditions);

    List<YimiaoPurchaseReturn> getSubmitReturn(Map<String, Object> conditions);

    // 审核订单详情
    int updateReturnDetailStatus(Map<String, Object> conditions);

    int updateByOrderId(Map<String,Object> params);

    int updateByOrderAmount(Map<String,Object> params);

    List<YimiaoPurchaseReturn> getReturnOrderData(Map<String, Object> conditions);

    int deleteByMap(Map<String,Object> params);
}