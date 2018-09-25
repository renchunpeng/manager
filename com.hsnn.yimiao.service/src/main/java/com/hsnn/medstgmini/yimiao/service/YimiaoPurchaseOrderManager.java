package com.hsnn.medstgmini.yimiao.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseOrder;

import java.util.List;
import java.util.Map;

public interface YimiaoPurchaseOrderManager extends GenericManager<YimiaoPurchaseOrder, String> {
	// 扩展接口
	int updateByOrder(List<Map<String, String>> order);

	int deletePurOrder(List<YimiaoPurchaseOrder> list);

	/**
     * 获取已经提交的订单
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
	Pagination getSubmitOrder(Pagination page);

	int updateOrderStatus(Pagination page);

	boolean starRun(Pagination page);

	int updateOrderByOrder(YimiaoPurchaseOrder yimiaoPurchaseOrder);

	int updateByOrderId(Map<String,Object> params);

	Pagination getOrderList(Pagination page);

	int updateStatusByOrder(Map<String,Object> params);

	int checkPurchaseOrder(String hospitalId);

}