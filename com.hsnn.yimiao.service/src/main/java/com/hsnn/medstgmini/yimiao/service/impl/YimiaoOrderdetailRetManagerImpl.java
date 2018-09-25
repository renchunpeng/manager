package com.hsnn.medstgmini.yimiao.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hsnn.medstgmini.yimiao.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.BeanCopierUtils;
import com.hsnn.medstgmini.util.ConstantsUtil;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.ParseNumber;
import com.hsnn.medstgmini.yimiao.dao.YimiaoOrderdetailRetDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailRet;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailRetLog;

@Service
public class YimiaoOrderdetailRetManagerImpl extends GenericManagerImpl<YimiaoOrderdetailRet, String> implements YimiaoOrderdetailRetManager {

	@Autowired
	private YimiaoOrderdetailRetDao dao;
	
	@Autowired
	private YimiaoOrderdetailRetlogManager yimiaoOrderdetailRetlogManager;

	@Autowired
	private YimiaoOrderdetailRetlogManager yimiaoOrderdetailretLogManager;

	@Autowired
	private YimiaoPurchaseReturnManager yimiaoPurchaseReturnManager;
	@Autowired
	private  YimiaoOrderdetailManager yimiaoOrderdetailManager;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean updateByDetailRetId(YimiaoOrderdetailRet detail) {
		boolean result=false;
		try {
			dao.updateByDetailRetId(detail);
			detail=this.getById(detail.getOrderdetailRetId());
			YimiaoOrderdetailRetLog detaillog=new YimiaoOrderdetailRetLog();
			BeanCopierUtils.copyProperties(detail, detaillog);
			detaillog.setLogId(UUID.randomUUID().toString());
			yimiaoOrderdetailRetlogManager.add(detaillog);
			result=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 扩展接口实现

	@Override
	public int updateByOrder(List<Map<String, String>> list) {
		// TODO Auto-generated method stub
		return dao.updateByOrder(list);
	}

	@Override
	public YimiaoOrderdetailRet getByOrder(String orderId) {
		printLog("查询",orderId,"根据orderId");
		YimiaoOrderdetailRet model = dao.getByOrder(orderId);
		return model;
	}
	@Override
	public Pagination getYLOkList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetailRet> models = dao.getYLOkList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}
	@Override
	public Pagination getYLAllList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetailRet> models = dao.getYLAllList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}
	@Override
	public Pagination getRetNoFinishList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetailRet> models = dao.getRetNoFinishList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}
	@Override
	public Pagination getRetFinishList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetailRet> models = dao.getRetFinishList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	/**
	 * 导出
	 */
	@Override
	public List<Map<String, Object>> getExportExcelData(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = dao.getExportExcelData(map);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("退货单价");
			Object purchaseAmount = data.get("申请退货金额");
			Object totalReturnAmount = data.get("已退货金额");
			Object compRatio = data.get("完成率（%）");
			data.put("退货单价", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("申请退货金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 2)));
			data.put("已退货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
			data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmState(map1.get("订单执行状态").toString()));
			}
		}
		return list;
	}
	
	/**
	 * 导出
	 */
	@Override
	public List<Map<String, Object>> getExportExcelDataNo(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = dao.getExportExcelDataNo(map);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("退货单价");
			Object purchaseAmount = data.get("申请退货金额");
			Object totalReturnAmount = data.get("已退货金额");
			Object compRatio = data.get("完成率（%）");
			data.put("退货单价", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("申请退货金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 2)));
			data.put("已退货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
			data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmState(map1.get("订单执行状态").toString()));	
			}
		}
		return list;
	}
	
	/**
	 * 采购记录-卫生局导出
	 */
	@Override
	public List<Map<String, Object>> getExportExcelDataWSJ(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = dao.getExportExcelDataWSJ(map);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("最小制剂单位中标价格（元）");
			Object purchaseAmount = data.get("申请退货金额");
			Object totalReturnAmount = data.get("退货金额");
			Object compRatio = data.get("完成率（%）");
			
			data.put("退货单价", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("申请退货金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 2)));
			data.put("退货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
			data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmState(map1.get("订单执行状态").toString()));	
			}
		}
		return list;
	}

	@Override
	public Map<String, Object> getRetFinishCountList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getRetFinishCountList(map);
	}

	@Override
	public Map<String, Object> findCountList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findCountList(map);
	}

	@Override
	public Map<String, Object> getYLAllCountList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getYLAllCountList(map);
	}

	@Override
	public Map<String, Object> getYLOkCountList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getYLOkCountList(map);
	}

	@Override
	public Map<String, Object> getRetNoFinishCountList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getRetNoFinishCountList(map);
	}

	@Override
	public List<YimiaoOrderdetailRet> getOrderdetailRetByOrderId(String orderId) {
		return dao.getOrderdetailRetByOrderId(orderId);
	}

	@Override
	public int toCheckDate() {
		Calendar now = Calendar.getInstance();
		int result = 0;
		String firstDate = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-1";
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(d);
		result = dao.toCheckIsWork(dateNowStr);
		if(result == 1){
			result = dao.toCheckDate(firstDate,dateNowStr);
		}
		return result;
	}

	@Override
	@Transactional
	public int addAndUpdateForDetail(List<Map<String, Object>> list, Pagination pagination) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		params.putAll(pagination.getConditions());
		//1.新增退货明细
		int i= saveByMap(params);
		//2.新增退货明细日志
		//3.更新退货单总金额
		yimiaoPurchaseReturnManager.updateByOrderId(params);
		//4.更新采购单明细总退货数量
		yimiaoOrderdetailManager.updateByData(params);
		return i;
	}

	@Override
	public int saveByMap(Map<String, Object> params) {
		return dao.saveByMap(params);
	}

	@Override
	@Transactional
	public int deleteAndUpdateByRetDetailId(List<Map<String, Object>> list) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		//1.更新采购明细
		int i =yimiaoOrderdetailManager.updateByDataForDel(params);
		//2.删除退货明细
		dao.deleteByIdList(params);
		//3.更新退货单金额
		params.put("orderId",list.get(0).get("orderId"));
		yimiaoPurchaseReturnManager.updateByOrderId(params);
		return i;
	}

	@Override
	@Transactional
	public int updateByDataList(List<Map<String, Object>> list) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		//1.更新退货明细
		int i = dao.updateByIdList(params);
		//2.更新采购明细
		yimiaoOrderdetailManager.updateByDataForEdit(params);
		//3.更新退货单金额
		params.put("orderId",list.get(0).get("orderId"));
		yimiaoPurchaseReturnManager.updateByOrderId(params);
		return i;
	}

	@Override
	@Transactional
	public int updataByListForSubmit(List<Map<String, String>> list) {
		this.updateByOrder(list);
		return yimiaoPurchaseReturnManager.updateByOrder(list);
	}

	@Override
	@Transactional
	public int updateByRetList(List<Map<String, Object>> list) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		//1.更新退货明细状态
		int  i = dao.updateByRetIdForStatus(params);
		//2.更新退货单状态
		yimiaoPurchaseReturnManager.updateByOrderAmount(params);
		//3.重新计算退货数量
		dao.updateByOrderCount(params);
		return  i;
	}

	@Override
	public int toCheckCount(List<Map<String, Object>> list) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		return dao.toCheckCount(params);
	}

	@Override
	public List<Map<String, Object>> getExportExcelDataNoSc(Map<String, Object> map) {
		List<Map<String,Object>> list = dao.getExportExcelDataNoSc(map);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("退货单价");
			Object purchaseAmount = data.get("申请退货金额");
			Object totalReturnAmount = data.get("已退货金额");
			Object compRatio = data.get("完成率（%）");
			data.put("退货单价", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("申请退货金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 2)));
			data.put("已退货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
			data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : "待处理");
			}
		}
		return list;
	}

	public int deleteByMap(Map<String,Object> params){
		return dao.deleteByMap(params);
	}
}