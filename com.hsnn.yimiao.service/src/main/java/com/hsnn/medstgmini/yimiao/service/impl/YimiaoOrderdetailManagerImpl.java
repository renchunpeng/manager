package com.hsnn.medstgmini.yimiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.BeanCopierUtils;
import com.hsnn.medstgmini.util.ConstantsUtil;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.ParseNumber;
import com.hsnn.medstgmini.yimiao.dao.YimiaoOrderdetailDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetail;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailLog;
import com.hsnn.medstgmini.yimiao.model.YimiaoPurchaseOrder;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailLogManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoPurchaseOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class YimiaoOrderdetailManagerImpl extends GenericManagerImpl<YimiaoOrderdetail, String> implements YimiaoOrderdetailManager {
	@Autowired
	private YimiaoOrderdetailDao yimiaoOrderdetailDao;
	@Autowired
	private YimiaoOrderdetailLogManager yimiaoOrderdetailLogManager;

	@Autowired
	private YimiaoPurchaseOrderManager yimiaoPurchaseOrderManager;

	@Override
	public YimiaoOrderdetail getByOrder(String orderId) {
		printLog("查询",orderId,"根据orderId");
		
		YimiaoOrderdetail model = yimiaoOrderdetailDao.getByOrder(orderId);
		return model;
	}
	// 扩展接口实现

	@Override
	public int updateByOrder(List<Map<String, String>> list) {
		return yimiaoOrderdetailDao.updateByOrder(list);
	}
	
	// 扩展接口实现
		@Override
		public Pagination getAllList(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getAllList(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		}

		@Override
		public Pagination getOkList(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getOkList(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		}

		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		public int updateBySelective(YimiaoOrderdetail detail){
			int count=0;
			try {
				yimiaoOrderdetailDao.updateBySelective(detail);
				detail=this.getById(detail.getOrderdetailId());
				YimiaoOrderdetailLog detaillog=new YimiaoOrderdetailLog();
				BeanCopierUtils.copyProperties(detail, detaillog);
				detaillog.setLogId(UUID.randomUUID().toString());
				yimiaoOrderdetailLogManager.add(detaillog);
				count=1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				count=-1;
			}
			return count;
		}
		
		@Override
		public Pagination getYLAllList(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getYLAllList(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		}
		
		@Override
		public Pagination getYLOkList(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getYLOkList(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		}
		
		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		public boolean updateByDetailId(YimiaoOrderdetail detail) {
			int row=0;
			boolean result=false;
			try {
				row+=yimiaoOrderdetailDao.updateByDetailId(detail);

				List<YimiaoOrderdetail> orderdetailList = getOrderDetailByOrderId(detail);
                YimiaoPurchaseOrder yimiaoPurchaseOrder = new YimiaoPurchaseOrder();
                yimiaoPurchaseOrder.setOrderId(detail.getOrderId());
                for(YimiaoOrderdetail yimiaoOrderdetail : orderdetailList){
                    Integer confirmState = yimiaoOrderdetail.getConfirmState();
                    if(confirmState.equals(1) || confirmState.equals(5)){
                        yimiaoPurchaseOrder.setOrderState(new BigDecimal(4));
                    }else{
                        yimiaoPurchaseOrder.setOrderState(new BigDecimal(5));
                    }
                }
                yimiaoPurchaseOrderManager.updateOrderByOrder(yimiaoPurchaseOrder);
                detail=this.getById(detail.getOrderdetailId());
				YimiaoOrderdetailLog detaillog=new YimiaoOrderdetailLog();
				BeanCopierUtils.copyProperties(detail, detaillog);
				detaillog.setLogId(UUID.randomUUID().toString());
				row+=yimiaoOrderdetailLogManager.add(detaillog);
				if(row>1) {
                    result = true;
                }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

	@Override
	public Pagination getSupHosp(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getSupHosp(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public Map<String, String> getHospDayCount(Pagination pagination) {
		Map<String,Object> queryMap = pagination.getConditions();
		Map<String,String> anaAreaHospDayCount = new HashMap<String,String>();
		if(queryMap.size()==5){
			anaAreaHospDayCount = yimiaoOrderdetailDao.getHospDayCount(queryMap);
		}else{
			anaAreaHospDayCount = yimiaoOrderdetailDao.getHospDayCount(queryMap);
		}
		return anaAreaHospDayCount;
	}

	@Override
		public Pagination getStatisticsOne(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.statisticsOne(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		} 
		@Override
		public Pagination getStatisticsTwo(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.statisticsTwo(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		} 
		@Override
		public Pagination getStatisticsThree(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.statisticsThree(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询", page, "分页查询");
			return page;
		} 
		
		/**
		 * 已完成采购记录--导出
		 */
		@Override
		public List<Map<String, Object>> getExportExcelDataCG(
				Map<String, Object> map) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataCG(map);
			for(Map<String,Object> data : list){
				Object purchasePrice = data.get("最小制剂单位中标价格（元）");
				Object purchaseAmount = data.get("采购金额");
				Object totalReturnAmount = data.get("到货金额");
				Object compRatio = data.get("完成率（%）");
				data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(),2)));
				data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
				data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
			}
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map1 = list.get(i);
					map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("订单执行状态").toString()));
				}
			}
			return list;
		}
		/**
		 * 未完成采购记录--导出
		 */
		@Override
		public List<Map<String, Object>> getExportExcelDataNCG(
				Map<String, Object> map) {
			// TODO Auto-generated method stub
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataNCG(map);
			for(Map<String,Object> data : list){
				Object purchasePrice = data.get("最小制剂单位中标价格（元）");
				Object purchaseAmount = data.get("采购金额");
				Object totalReturnAmount = data.get("到货金额");
				Object compRatio = data.get("完成率（%）");
				data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 2)));
				data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(),2)));
				data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
			}
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map1 = list.get(i);
					map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("订单执行状态").toString()));	
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
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataWSJ(map);
			for(Map<String,Object> data : list){
				Object purchasePrice = data.get("最小制剂单位中标价格（元）");
				Object purchaseAmount = data.get("采购金额");
				Object totalReturnAmount = data.get("到货金额");
				Object compRatio = data.get("完成率（%）");
				data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 2)));
				data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
				data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
			}
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map1 = list.get(i);
					map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("订单执行状态").toString()));	
				}
			}
			return list;
		}

		@Override
		public List<Map<String, Object>> getExportExcelDataPS(Map<String, Object> map) {
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataPS(map);
			for(Map<String,Object> data : list){
				Object purchasePrice = data.get("最小制剂单位中标价格（元）");
				Object purchaseAmount = data.get("采购金额");
				Object totalReturnAmount = data.get("到货金额");
				Object compRatio = data.get("完成率（%）");
				data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 3)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 3)));
				data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 3)));
				data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 4)));
			}
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map1 = list.get(i);
					map1.put("是否供货",map1.get("是否供货") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("是否供货").toString()));	
				}
			}
			return list;
		}
		@Override
		public List<Map<String, Object>> getExportExcelDataPSRET(Map<String, Object> map) {
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataPSRET(map);
			for(Map<String,Object> data : list){
				Object purchasePrice = data.get("最小制剂单位中标价格（元）");
				Object purchaseAmount = data.get("采购金额");
				Object totalReturnAmount = data.get("到货金额");
				Object compRatio = data.get("完成率（%）");
				data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 3)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 3)));
				data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 3)));
				data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 4)));
			}
			if (null != list && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map1 = list.get(i);
					map1.put("是否退货",map1.get("是否退货") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("是否退货").toString()));	
				}
			}
			return list;
		}

		@Override
		public List<Map<String, Object>> getExportExcelDataMLTJ(Map<String, Object> map) {
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataMLTJ(map);
			for(Map<String,Object> data : list){
				Object purchaseAmount = data.get("采购金额");
				Object amount1 = data.get("到货金额");
				Object amount2 = data.get("退货金额");
				Object compRatio1 = data.get("到货平均完成率（%）");
				Object compRatio2 = data.get("退货平均完成率（%）");
				//Object retArrCount = data.get("退货到货数量");
				Object retArrAmount = data.get("退货到货金额");
				data.put("到货金额", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1.toString(), 3)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 3)));
				data.put("退货金额", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2.toString(), 3)));
				data.put("到货平均完成率（%）", compRatio1==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio1.toString(), 4)));
				data.put("退货平均完成率（%）", compRatio2==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio2.toString(), 4)));
				//data.put("退货到货数量", retArrCount==null?"":new BigDecimal(ParseNumber.stringToFormat(retArrCount.toString(), 4)));
				data.put("退货到货金额", retArrAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(retArrAmount.toString(), 3)));
			}
			
			return list;
		}
		
		@Override
		public List<Map<String, Object>> getExportExcelDataMLTJTwo(Map<String, Object> map) {
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataMLTJTwo(map);
			for(Map<String,Object> data : list){
				Object purchaseAmount = data.get("采购金额");
				Object amount1 = data.get("到货金额");
				Object amount2 = data.get("退货金额");
				Object compRatio1 = data.get("到货平均完成率（%）");
				Object compRatio2 = data.get("退货平均完成率（%）");
				Object retArrAmount = data.get("退货到货金额");
				data.put("到货金额", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1.toString(), 3)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 3)));
				data.put("退货金额", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2.toString(), 3)));
				data.put("到货平均完成率（%）", compRatio1==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio1.toString(), 4)));
				data.put("退货平均完成率（%）", compRatio2==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio2.toString(), 4)));
				data.put("退货到货金额", retArrAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(retArrAmount.toString(), 3)));
			}
			
			return list;
		}
		
		@Override
		public List<Map<String, Object>> getExportExcelDataMLTJThree(Map<String, Object> map) {
			List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataMLTJThree(map);
			for(Map<String,Object> data : list){
				Object purchaseAmount = data.get("采购金额");
				Object amount1 = data.get("到货金额");
				Object amount2 = data.get("退货金额");
				Object compRatio1 = data.get("到货平均完成率（%）");
				Object compRatio2 = data.get("退货平均完成率（%）");
				Object retArrAmount = data.get("退货到货金额");
				data.put("到货金额", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1.toString(), 3)));
				data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(), 3)));
				data.put("退货金额", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2.toString(), 3)));
				data.put("到货平均完成率（%）", compRatio1==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio1.toString(), 4)));
				data.put("退货平均完成率（%）", compRatio2==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio2.toString(), 4)));
				data.put("退货到货金额", retArrAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(retArrAmount.toString(), 3)));
			}
			
			return list;
		}

		@Override
		public Map<String, Object> getCountOkList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return yimiaoOrderdetailDao.getCountOkList(map);
		}

		@Override
		public Map<String, Object> getAllCountList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return yimiaoOrderdetailDao.getAllCountList(map);
		}

		@Override
		public Map<String, Object> findCountList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return yimiaoOrderdetailDao.findCountList(map);
		}

		@Override
		public Map<String, Object> getYLAllCountList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return yimiaoOrderdetailDao.getYLAllCountList(map);
		}

		@Override
		public Map<String, Object> getYLOkCountList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return yimiaoOrderdetailDao.getYLOkCountList(map);
		}

		@Override
		public List<YimiaoOrderdetail> getByOrderId(String orderId) {
			return yimiaoOrderdetailDao.getByOrderId(orderId);
		}
		
		@Override
		public List<Map<String, Object>> exportAllSup(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportAllSup(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}
		@Override
		public Pagination getCompanyPsStatistics(Pagination page) {
			PageHelper.startPage(page.getPage(),page.getCount());
			Map<String,Object> queryMap = page.getConditions();
			Page<YimiaoOrderdetail> yimiaoOrderdetailList = new Page<YimiaoOrderdetail>();
			yimiaoOrderdetailList = yimiaoOrderdetailDao.getCompanyPsStatistics(queryMap);
			page.setRows(yimiaoOrderdetailList);
			page.setRecords(yimiaoOrderdetailList.getTotal());
			return page;
		}

		@Override
		public Pagination getCompanyScStatistics(Pagination page) {
			PageHelper.startPage(page.getPage(),page.getCount());
			Map<String,Object> queryMap = page.getConditions();
			Page<YimiaoOrderdetail> yimiaoOrderdetailList = new Page<YimiaoOrderdetail>();
			yimiaoOrderdetailList = yimiaoOrderdetailDao.getCompanyScStatistics(queryMap);
			page.setRows(yimiaoOrderdetailList);
			page.setRecords(yimiaoOrderdetailList.getTotal());
			return page;
		}

		@Override
		public List<Map<String, Object>> exportDataCompanyPs(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportDataCompanyPs(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}

		@Override
		public List<Map<String, Object>> exportDataCompanySc(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportDataCompanySc(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}

		@Override
		public Map<String,String> getYimiaoCompanyPsCount(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			Map<String,String> companyPsCount = new HashMap<String, String>();
			companyPsCount = yimiaoOrderdetailDao.getYimiaoCompanyPsCount(queryMap);
			return companyPsCount;
		}

		@Override
		public Map<String,String> getYimiaoCompanyScCount(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			Map<String,String> companyScCount = new HashMap<String, String>();
			companyScCount = yimiaoOrderdetailDao.getYimiaoCompanyScCount(queryMap);
			return companyScCount;
		}

		@Override
		public Pagination getAdminAreaStatistics(Pagination page) {
			PageHelper.startPage(page.getPage(),page.getCount());
			Map<String,Object> queryMap = page.getConditions();
			Page<YimiaoOrderdetail> yimiaoOrderdetailList = new Page<YimiaoOrderdetail>();
			yimiaoOrderdetailList = yimiaoOrderdetailDao.getAdminAreaStatistics(queryMap);
			page.setRows(yimiaoOrderdetailList);
			page.setRecords(yimiaoOrderdetailList.getTotal());
			return page;
		}

		@Override
		public List<Map<String, Object>> exportDataAdminArea(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportDataAdminArea(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}

		@Override
		public Map<String, String> getYimiaoAdminAreaCount(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			Map<String,String> companyScCount = new HashMap<String, String>();
			companyScCount = yimiaoOrderdetailDao.getYimiaoAdminAreaCount(queryMap);
			return companyScCount;
		}

		@Override
		public Pagination getHospitalMonthStatistics(Pagination page) {
			PageHelper.startPage(page.getPage(),page.getCount());
			Map<String,Object> queryMap = page.getConditions();
			Page<YimiaoOrderdetail> yimiaoOrderdetailList = new Page<YimiaoOrderdetail>();
			yimiaoOrderdetailList = yimiaoOrderdetailDao.getHospitalMonthStatistics(queryMap);
			page.setRows(yimiaoOrderdetailList);
			page.setRecords(yimiaoOrderdetailList.getTotal());
			return page;
		}

		@Override
		public List<Map<String, Object>> exportDataHospitalMonth(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportDataHospitalMonth(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}

		@Override
		public Map<String, String> getYimiaoHospitalMonthCount(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			Map<String,String> companyScCount = new HashMap<String, String>();
			companyScCount = yimiaoOrderdetailDao.getYimiaoHospitalMonthCount(queryMap);
			return companyScCount;
		}

		@Override
		public Pagination getHospitalStatistics(Pagination page) {
			PageHelper.startPage(page.getPage(),page.getCount());
			Map<String,Object> queryMap = page.getConditions();
			Page<YimiaoOrderdetail> yimiaoOrderdetailList = new Page<YimiaoOrderdetail>();
			yimiaoOrderdetailList = yimiaoOrderdetailDao.getHospitalStatistics(queryMap);
			page.setRows(yimiaoOrderdetailList);
			page.setRecords(yimiaoOrderdetailList.getTotal());
			return page;
		}

		@Override
		public List<Map<String, Object>> exportDataHospital(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportDataHospital(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}

		@Override
		public Map<String, String> getYimiaoHospitalCount(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			Map<String,String> companyScCount = new HashMap<String, String>();
			companyScCount = yimiaoOrderdetailDao.getYimiaoHospitalCount(queryMap);
			return companyScCount;
		}

		@Override
		public Pagination getYimiaoProcurecatalogStatistics(Pagination page) {
			PageHelper.startPage(page.getPage(),page.getCount());
			Map<String,Object> queryMap = page.getConditions();
			Page<YimiaoOrderdetail> yimiaoOrderdetailList = new Page<YimiaoOrderdetail>();
			yimiaoOrderdetailList = yimiaoOrderdetailDao.getYimiaoProcurecatalogStatistics(queryMap);
			page.setRows(yimiaoOrderdetailList);
			page.setRecords(yimiaoOrderdetailList.getTotal());
			return page;
		}

		@Override
		public List<Map<String, Object>> exportDataYimiaoProcurecatalog(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			List<Map<String,Object>> list;
			list = yimiaoOrderdetailDao.exportDataYimiaoProcurecatalog(queryMap);
			int i=1;
			for(Map<String,Object> data : list){
				data.put("序号",i++);
			}
			return list;
		}

		@Override
		public Map<String, String> getYimiaoProcurecatalogCount(Pagination page) {
			Map<String,Object> queryMap = page.getConditions();
			Map<String,String> companyScCount = new HashMap<String, String>();
			companyScCount = yimiaoOrderdetailDao.getYimiaoProcurecatalogCount(queryMap);
			return companyScCount;
		}

	/**
	 * 退货数据来源医疗机构已完成采购订单
	 * @param page
	 * @return getYLOkListByHOSPITAL_ID
	 */
	@Override
	public Pagination getYLOkListByHospitalId(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getYLOkListByHospitalId(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public YimiaoOrderdetail getYimiaoOrderdetailByProcurecatalogId(Pagination conditions) {
		Map<String,Object> queryMap = conditions.getConditions();
		return yimiaoOrderdetailDao.getYimiaoOrderdetailByProcurecatalogId(queryMap);
	}

	@Override
	public Pagination getYimiaoData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getYimiaoData(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public Pagination queryYimiaoOrderDetailNotret(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoOrderdetail> models = (Page<YimiaoOrderdetail>) yimiaoOrderdetailDao.queryYimiaoOrderDetailNotret(pagination.getConditions());
		//Page<YimiaoProcurecatalog> models = (Page<YimiaoProcurecatalog>) yimiaoProcurecataLogDao.queryByNotret(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}

	@Override
	@Transactional
	public void updateOrderStatus() {
		//修改订单状态
		yimiaoOrderdetailDao.updateOrderStatus();
		//修改订单明细状态
		yimiaoOrderdetailDao.updatetoOrderDetailStatus();
	}

	@Override
	public int toCheckOrderCount(String hospitalId) {

		int result = yimiaoOrderdetailDao.toCheckOrderCount(hospitalId);

		return result;
	}

	@Override
	public int updateOrderDetailStatus(Pagination page) {
		return yimiaoOrderdetailDao.updateOrderDetailStatus(page.getConditions());
	}

	@Override
	public void addProtoList(List<YimiaoOrderdetail> addList) {
		yimiaoOrderdetailDao.addProtoList(addList);
	}

	@Override
	public List<YimiaoOrderdetail> getOrderDetailByOrderId(YimiaoOrderdetail yimiaoOrderdetail) {
		return yimiaoOrderdetailDao.getOrderDetailByOrderId(yimiaoOrderdetail);
	}

	@Override
	public int updateByData(Map<String, Object> params) {
		return yimiaoOrderdetailDao.updateByData(params);
	}

	@Override
	public int updateByDataForDel(Map<String, Object> params) {
		return yimiaoOrderdetailDao.updateByDataForDel(params);
	}

	@Override
	public int updateByDataForEdit(Map<String, Object> params) {
		return yimiaoOrderdetailDao.updateByDataForEdit(params);
	}

	@Override
	public Pagination getYimiaoPsData(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getYimiaoPsData(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询",page,"分页查询");
        return page;
	}

    @Override
    public Pagination getYimiaoRkData(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getYimiaoRkData(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询",page,"分页查询");
        return page;
    }

	@Override
	public List<Map<String, Object>> getExportExcelCatalog(Map<String, Object> map) {
		List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelCatalog(map);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("最小制剂单位中标价格（元）");
			Object purchaseAmount = data.get("采购金额");
			Object totalReturnAmount = data.get("到货金额");
			Object compRatio = data.get("完成率（%）");
			data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(),2)));
			data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
			data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("订单执行状态").toString()));
			}
		}
		return list;
	}

    @Override
    public List<Map<String, Object>> getExportExcelDispatch(Map<String, Object> map) {
        List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDispatch(map);
        for(Map<String,Object> data : list){
            Object purchasePrice = data.get("最小制剂单位中标价格（元）");
            Object purchaseAmount = data.get("采购金额");
            Object totalReturnAmount = data.get("到货金额");
            Object compRatio = data.get("完成率（%）");
            data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
            data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(),2)));
            data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
            data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
        }
        if (null != list && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map1 = list.get(i);
                map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("订单执行状态").toString()));
            }
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getExportExcelPurchase(Map<String, Object> map) {
        List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelPurchase(map);
        for(Map<String,Object> data : list){
            Object purchasePrice = data.get("最小制剂单位中标价格（元）");
            Object purchaseAmount = data.get("采购金额");
            Object totalReturnAmount = data.get("到货金额");
            Object compRatio = data.get("完成率（%）");
            data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
            data.put("采购金额", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(),2)));
            data.put("到货金额", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
            data.put("完成率（%）", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio.toString(), 2)));
        }
        if (null != list && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map1 = list.get(i);
                map1.put("订单执行状态",map1.get("订单执行状态") == null ? "" : ConstantsUtil.confirmStateCG(map1.get("订单执行状态").toString()));
            }
        }
        return list;
    }

    @Override
	@Transactional
    public int addAndUpdateForDetail(List<Map<String, Object>> list, Pagination pagination) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("list",list);
        params.putAll(pagination.getConditions());
        // 新增采购明细
        int i = saveByMap(params);
        // 更新采购单总金额
        yimiaoPurchaseOrderManager.updateByOrderId(params);
        return i;
    }

    @Override
    public int saveByMap(Map<String, Object> params) {
        return yimiaoOrderdetailDao.saveByMap(params);
    }

	@Override
	public int toCheckOrderCreateCount(String hospitalId) {
		return yimiaoOrderdetailDao.toCheckOrderCreateCount(hospitalId);
	}

	@Override
	@Transactional
	public int changeStatus(List<Map<String, String>> order) {
		int i = updateByOrder(order);
		if(i > 0){
            i = yimiaoPurchaseOrderManager.updateByOrder(order);
        }
		return i;
	}

	public int updateByRetOrderIdForDel(Map<String,Object> params){
		return yimiaoOrderdetailDao.updateByRetOrderIdForDel(params);
	}

	@Override
    @Transactional
	public int updateByOrderList(List<Map<String, Object>> list) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		// 更新订单明细状态
        int i = yimiaoOrderdetailDao.updateByOrderDetailIdForStatus(params);
        // 更新订单状态
        if(i > 0){
            yimiaoPurchaseOrderManager.updateStatusByOrder(params);
        }
		return i;
	}

	@Transactional
	public int updateByDetailIdForDH(List<Map<String, Object>> list){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list",list);
		//1.更新采购单明细
		yimiaoOrderdetailDao.updateByDetailIdForDH(params);
		return yimiaoPurchaseOrderManager.updateStatusByOrder(params);
	}

	@Override
	@Transactional
	public void updateCancelStatus() {
		//修改订单状态
		yimiaoOrderdetailDao.updateCancelOrderStatus();
		//修改订单明细状态
		yimiaoOrderdetailDao.updateCancelOrderDetailStatus();
	}

	@Override
	@Transactional
	public String checkException(Map<String, String> map) {
		return yimiaoOrderdetailDao.checkException(map);
	}

	@Override
	public int toCheckSwitch() {
		return yimiaoOrderdetailDao.toCheckSwitch();
	}

	@Override
	public Pagination getDataByAll(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getDataByAll(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public Pagination getDataByJKCenter(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getDataByJKCenter(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

    @Override
    public Pagination getDataBySC(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getDataBySC(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询", page, "分页查询");
        return page;
    }

	@Override
	public Pagination getDataByPS(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getDataByPS(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public Pagination getDataBySelf(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getDataBySelf(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public Pagination getAnaByAllTz(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getAnaByAllTz(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public Pagination getAnaHospdruginfoTotal(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getAnaHospdruginfoTotal(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public Pagination getAnaByProdcompTz(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getAnaByProdcompTz(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

    @Override
    public Pagination getAnaDelWithMon(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getAnaDelWithMon(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        printLog("查询", page, "分页查询");
        return page;
    }

	@Override
	public Pagination getAnaHospTotalMon(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoOrderdetail> models = yimiaoOrderdetailDao.getAnaHospTotalMon(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询", page, "分页查询");
		return page;
	}

	@Override
	public List<Map<String, Object>> getExportExcelDataBy(Map<String, Object> conditions) {
		List<Map<String,Object>> list = yimiaoOrderdetailDao.getExportExcelDataBy(conditions);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("最小制剂单位中标价格（元）");
			Object purchaseAmount = data.get("采购金额(元)");
			Object totalReturnAmount = data.get("入库金额(元)");
//			Object compRatio = data.get("入库率(%)");
			data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("采购金额(元)", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(),2)));
			data.put("入库金额(元)", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
//			data.put("入库率(%)", compRatio==null?"":compRatio.toString().substring(0,5));
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> exportExcelByAllTz(Map<String, Object> conditions) {
		List<Map<String,Object>> list = yimiaoOrderdetailDao.exportExcelByAllTz(conditions);
		for(Map<String,Object> data : list){
			Object purchasePrice = data.get("最小制剂单位中标价格（元）");
			Object purchaseAmount = data.get("采购金额(元)");
			Object totalReturnAmount = data.get("入库金额(元)");
//			Object compRatio = data.get("入库率(%)");
			data.put("最小制剂单位中标价格（元）", purchasePrice==null?"":new BigDecimal(ParseNumber.stringToFormat(purchasePrice.toString(), 2)));
			data.put("采购金额(元)", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount.toString(),2)));
			data.put("入库金额(元)", totalReturnAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalReturnAmount.toString(), 2)));
//			data.put("入库率(%)", compRatio==null?"":compRatio.toString().substring(0,5));
		}
		return list;
	}
}