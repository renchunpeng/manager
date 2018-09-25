package  com.hsnn.medstgmini.yimiao.dao;

import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseOrder;

import java.util.List;
import java.util.Map;

public interface YimiaoPurchaseOrderDao extends GenericDao<YimiaoPurchaseOrder, String> {
	int updateByOrder(List<Map<String, String>> list);

	int deletePurOrder(List<YimiaoPurchaseOrder> list);

	List<YimiaoPurchaseOrder> getSubmitOrder(Map<String, Object> map);

    int updateOrderStatus(Map<String, Object> map);

	int updateOrderByOrder(YimiaoPurchaseOrder yimiaoPurchaseOrder);

	int updateByOrderId(Map<String,Object> params);

	List<YimiaoPurchaseOrder> getOrderList(Map<String, Object> map);

	int updateStatusByOrder(Map<String,Object> params);

	int checkPurchaseOrder(String hospitalId);

}