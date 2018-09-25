package com.hsnn.medstgmini.yimiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.dao.YimiaoPurchaseOrderDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseOrder;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoPurchaseOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class YimiaoPurchaseOrderManagerImpl extends GenericManagerImpl<YimiaoPurchaseOrder, String> implements YimiaoPurchaseOrderManager {
	// 扩展接口实现

	@Autowired
	private YimiaoPurchaseOrderDao dao;

	@Autowired
	private YimiaoOrderdetailManager yimiaoOrderdetailManager;

	@Override
	public int updateByOrder(List<Map<String, String>> list) {
		// TODO Auto-generated method stub
		return dao.updateByOrder(list);
	}

	@Override
	public int deletePurOrder(List<YimiaoPurchaseOrder> list) {
		return dao.deletePurOrder(list);
	}

	@Override
	public Pagination getSubmitOrder(Pagination pagination) {
        PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
        Page<YimiaoPurchaseOrder> models = (Page<YimiaoPurchaseOrder>) dao.getSubmitOrder(pagination.getConditions());
        pagination.setRows(models);
        pagination.setRecords(models.getTotal());
        return pagination;
	}

    @Override
    public int updateOrderStatus(Pagination page) {
        return dao.updateOrderStatus(page.getConditions());
    }

	@Override
	@Transactional
	public boolean starRun(Pagination page) {
		boolean flag = false;
        int i = updateOrderStatus(page);
        if(i > 0){
        	if(page.getConditions().get("status").equals("2")){
        		page.getConditions().put("confirmState",0);
			}else{
				page.getConditions().put("confirmState",4);
			}
            int j = yimiaoOrderdetailManager.updateOrderDetailStatus(page);
            if(j > 0){
                flag = true;
            }
        }
		return flag;
	}

	@Override
	public int updateOrderByOrder(YimiaoPurchaseOrder yimiaoPurchaseOrder) {
		return dao.updateOrderByOrder(yimiaoPurchaseOrder);
	}

	@Override
	public int updateByOrderId(Map<String, Object> params) {
		return dao.updateByOrderId(params);
	}

	@Override
	public Pagination getOrderList(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoPurchaseOrder> models = (Page<YimiaoPurchaseOrder>) dao.getOrderList(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}

	@Override
	public int updateStatusByOrder(Map<String, Object> params) {
		return dao.updateStatusByOrder(params);
	}

	@Override
	public int checkPurchaseOrder(String hospitalId) {
		return dao.checkPurchaseOrder(hospitalId);
	}
}