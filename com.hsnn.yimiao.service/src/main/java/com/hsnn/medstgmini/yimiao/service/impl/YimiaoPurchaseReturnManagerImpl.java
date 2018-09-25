package com.hsnn.medstgmini.yimiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailRetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsnn.medstgmini.yimiao.service.YimiaoPurchaseReturnManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.yimiao.dao.YimiaoPurchaseReturnDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseReturn;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YimiaoPurchaseReturnManagerImpl extends GenericManagerImpl<YimiaoPurchaseReturn, String> implements YimiaoPurchaseReturnManager {

	@Autowired
	private YimiaoPurchaseReturnDao dao;
	@Autowired
	private YimiaoOrderdetailManager yimiaoOrderdetailManager;
	@Autowired
	private YimiaoOrderdetailRetManager yimiaoOrderdetailretManager;
	
	@Override
	public int updateByOrder(List<Map<String, String>> list) {
		// TODO Auto-generated method stub
		return dao.updateByOrder(list);
	}

	@Override
	public Pagination getSubmitReturn(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoPurchaseReturn> models = (Page<YimiaoPurchaseReturn>) dao.getSubmitReturn(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}

	@Override
	public int updateReturnStatus(Pagination pagination) {
		return dao.updateReturnStatus(pagination.getConditions());
	}

	@Override
	public int updateReturnDetailStatus(Pagination pagination) {
		return dao.updateReturnDetailStatus(pagination.getConditions());
	}

    @Override
    public int updateByOrderId(Map<String, Object> params) {
        return dao.updateByOrderId(params);
    }

	@Override
	@Transactional
	public int updateByIdForAudit(Pagination pagination) {
		updateReturnStatus(pagination);
		return updateReturnDetailStatus(pagination);
	}

	@Override
	public int updateByOrderAmount(Map<String, Object> params) {
		return dao.updateByOrderAmount(params);
	}

	@Override
	public Pagination getReturnOrderData(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoPurchaseReturn> models = (Page<YimiaoPurchaseReturn>) dao.getReturnOrderData(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}

	@Transactional
	public  int deleteAndUpdateData(List<String> retorderIdList){
		Map<String,Object> params = new HashMap<>();
		params.put("retorderIdList",retorderIdList);
		//1.更新采购明细可退货数量
		yimiaoOrderdetailManager.updateByRetOrderIdForDel(params);
		//2.删除退货明细
		yimiaoOrderdetailretManager.deleteByMap(params);
		//3.删除退货单
		return dao.deleteByMap(params);
	}
}