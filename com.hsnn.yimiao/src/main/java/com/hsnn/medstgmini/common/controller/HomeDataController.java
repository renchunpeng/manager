package com.hsnn.medstgmini.common.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.sys.enums.NoticeStatus;
import com.hsnn.medstgmini.base.sys.enums.YesOrNo;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.SysNoticeManager;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.common.service.DatabaseManager;
import com.hsnn.medstgmini.util.Arith;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.ParseDate;
import com.hsnn.medstgmini.util.dict.CacheDict;


@Controller
@RequestMapping(HomeDataController.ACTION_PATH)
public class HomeDataController extends GenericController {
	
	private static final Logger log = Logger.getLogger(HomeDataController.class);
	protected static final String ACTION_PATH="/home";
	
	@Value("${system.province}")
	private String sysProvince;
	
	@Autowired
	private SysNoticeManager sysNoticeManager;
	@Autowired
	private DatabaseManager databaseManager;
	
	/**
	 * 获取对外开放公告列表
	 * @return
	 */
	@RequestMapping("getConnectorSysNoticeData")
	@ResponseBody
	public Pagination getConnectorSysNoticeData() {
		Pagination pagination = new Pagination(this.getRequest());
		Integer userType = getSysUser().getUserType();
		pagination.getConditions().put("userType", userType);
		try {
			pagination.setSidx("datetime");// 排序字段
			pagination.setSord("DESC");// 排序方向
			pagination.setOrderby();
			
			pagination.getConditions().put("status", NoticeStatus.SUBMIT.getKey());
			pagination = sysNoticeManager.getList(pagination);
		} catch (Exception e) {
			log.error("Failed to getStdGmpgspData", e);
		}
		return pagination;
	}
	
	/**@RequestMapping("/getMatterData")
	@ResponseBody
	public Pagination getMatterData(){
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, Object> map = new HashMap<String, Object>();
		SysUser user = this.getSysUser();
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		
		// 配送企业
		if(user.getUserType()==UserType.jy.getKey() || user.getUserType()==UserType.sj.getKey()){
			String pnodeTime = CacheDict.getSdtDictsByTypeWithKey("订单生命周期","配送节点时间");
			String snodeTime = CacheDict.getSdtDictsByTypeWithKey("订单生命周期","入库节点时间");
			
			String deliveryTimeNode = databaseManager.getworkdaybefore(pnodeTime);
			/*		配送时间节点:(字典表 type=’订单生命周期’ and dictionary_key=’配送节点时间’)
			收货时间节点:(字典表 type=’订单生命周期’ and dictionary_key=’入库节点时间’)
			 
			// 待阅读订单
			map.put("orderType", OrderType.ORDER_FIRST_AID_TEMP.getKey());
			map.put("orderState", OrderState.WAIT_SUBMIT.getKey());
			map.put("deliveryTimeNode", deliveryTimeNode );
			map.put("queryToRead", "true");
			map.put("companyIdPs", getSysUser().getOrgId());
			int purchaseOrderCount = drugpurPurchaseOrderManager.getPurchaseOrderCount(map);
			Map<String, Object> notReadOrderCount = new HashMap<String, Object>();
			notReadOrderCount.put("url", "/drugpurPurchaseOrder/toOrderToReadList.html");
			notReadOrderCount.put("sun", purchaseOrderCount);
			notReadOrderCount.put("desc", "未阅读订单");
			mapList.add(notReadOrderCount);
			
			// 待确认订单明细
			map.clear();
            map.put("deliveryTimeNode", deliveryTimeNode);
            map.put("companyIdPs", getSysUser().getOrgId());
            map.put("orderdetailState", OrderdetailState.SUBMITTED_TO_CONFIRMATION.getKey());
            map.put("orderType", OrderType.ORDER_NORMAL.getKey());
            
			int PurchaseOrderdetailRecentCount = drugpurPurchaseOrderdetailRecentManager.getCount(map);
			Map<String, Object>  unackedOrderCount = new HashMap<String, Object>();
			unackedOrderCount.put("url", "/drugpurPurchaseOrderdetailRecent/toOrderToConfirmList.html");
			unackedOrderCount.put("sun", PurchaseOrderdetailRecentCount);
			unackedOrderCount.put("desc", "待确认订单明细");
			mapList.add(unackedOrderCount);
			
//		    // 待配送订单明细
			map.clear();
			int states [] = {OrderdetailState.SUBMITTED_TO_CONFIRMATION.getKey() ,OrderdetailState.CONFIRMED_TO_SHIP.getKey()};
            map.put("deliveryTimeNode", deliveryTimeNode);
            map.put("companyIdPs", getSysUser().getOrgId());
            map.put("orderdetailStates", states);
            map.put("orderType", OrderType.ORDER_NORMAL.getKey());
			int  orderdetailRecentCount = drugpurPurchaseOrderdetailRecentManager.getCount(map);
			Map<String, Object>  orderdetailRecent = new HashMap<String, Object>();
			orderdetailRecent.put("url", "/drugpurPurchaseOrderdetailRecent/toOrderToShipList.html");
			orderdetailRecent.put("sun", orderdetailRecentCount);
			orderdetailRecent.put("desc", "待配送订单明细");
			mapList.add(orderdetailRecent);
			
//		// 待确认退货明细
			
			map.clear();
            map.put("companyIdPs", getSysUser().getOrgId());
            map.put("returnState", ReturnState.SUBMITTED_TO_CONFIRM.getKey());
            int returnLocaleCount = drugpurReturnManager.getCount(map); 
        	Map<String, Object>  returnLocale = new HashMap<String, Object>();
        	returnLocale.put("url", "/drugpurReturn/toReturnToConfirmList.html");
        	returnLocale.put("sun", returnLocaleCount);
			returnLocale.put("desc", "待确认退货明细");
			mapList.add(returnLocale);
//		
//		// 待维护退货发票
            map.clear();
            map.put("companyIdPs", getSysUser().getOrgId());
            map.put("returnState", ReturnState.CONFIRMED_TO_MAINTENANCE_INVOICE.getKey());
            int returnAfterCount = drugpurReturnManager.getCount(map); 
        	Map<String, Object>  returnAfter = new HashMap<String, Object>();
        	returnAfter.put("url", "/drugpurReturn/toReturnInvoiceMaintainList.html");
        	returnAfter.put("sun", returnAfterCount);
        	returnAfter.put("desc", "待维护退货发票");
			mapList.add(returnAfter);
			
		}else if(user.getUserType()==UserType.zx.getKey() ){
			//中心
			  
			//待审核商品
			map.clear();
	        map.put("auditStatus",AuditStatus.WAIT_AUDIT.getKey());
			int waitCount = drugpurProcurecatalogManager.getCount(map);
			Map<String, Object>  waitGood = new HashMap<String, Object>();
			waitGood.put("url", "/drugpurProcurecatalog/dgProcurecatalogAuditList.html");
			waitGood.put("sun", waitCount);
			waitGood.put("desc", "待审核商品");
			mapList.add(waitGood);
			
			
//			//备案采购待初审
			map.clear();
			int currentAuditStatuse[] ={0,1,8}; 
	        map.put("left","true");
	        map.put("nextDealOrgId",user.getOrgId());
	        map.put("submitStatus",SubmitStatus.SUMBIT_WAIT_AUDIT.getKey());
	        map.put("currentAuditStatuses", currentAuditStatuse);
	        int subWaitCount = drugpurFilingApplyManager.getCount(map);
	        Map<String, Object>  subWait = new HashMap<String, Object>();
	        subWait.put("url", "/drugpurFilingApply/toJGCSList.html");
	        subWait.put("sun", subWaitCount);
	        subWait.put("desc", "备案采购待初审");
			mapList.add(subWait);
	        
//			//备案采购待复审
			map.clear();
			int auditStatuse[] ={5,6}; 
	        map.put("left","true");
	        map.put("nextDealOrgId",user.getOrgId());
	        map.put("currentAuditStatuses", auditStatuse);
	        int  recordPendingReviewCount = drugpurFilingApplyManager.getCount(map);
	        Map<String, Object>  recordPendingReview = new HashMap<String, Object>();
	        recordPendingReview.put("url", "/drugpurFilingApply/toJGCSFXList.html");
	        recordPendingReview.put("sun", recordPendingReviewCount);
	        recordPendingReview.put("desc", "备案采购待复审");
			mapList.add(recordPendingReview);
			
//			//待执行调价计划
	        map.clear();
	        map.put("planState",PlanState.WAIT_EXECUTE.getKey());
	        int changePriceplanCount = drugpurAdjustPlanManager.getCount(map);
	        Map<String, Object>  changePriceplan = new HashMap<String, Object>();
	        changePriceplan.put("url", "/drugpurAdjustPlan/toAdjustList.html");
	        changePriceplan.put("sun", changePriceplanCount);
	        changePriceplan.put("desc", "待执行调价计划");
			mapList.add(changePriceplan);
			
		}else if(user.getUserType()==UserType.jg.getKey()){
			//备案采购待初审
			map.clear();
			int currentAuditStatuse[] ={DrugpurFilingApplyCurrentAuditStatus.SUBMIT.getKey()}; 
			int lastAuditStatuses[] = {DrugpurFilingApplyLastAuditStatus.PASSING.getKey()};
	        map.put("left","true");
	        map.put("nextDealOrgId",user.getOrgId());
	        map.put("submitStatus",SubmitStatus.SUMBIT_WAIT_AUDIT.getKey());
	        map.put("currentAuditStatuses", currentAuditStatuse);
	        map.put("lastAuditStatuses", lastAuditStatuses);
	        int subWaitCount = drugpurFilingApplyManager.getCount(map);
	        Map<String, Object>  subWait = new HashMap<String, Object>();
	        subWait.put("url", "/drugpurFilingApply/toJGCSList.html");
	        subWait.put("sun", subWaitCount);
	        subWait.put("desc", "备案采购待初审");
			mapList.add(subWait);
	        
//			//备案采购待复审
			map.clear();
			int auditStatuse[] ={DrugpurFilingApplyCurrentAuditStatus.WSJ_PASS.getKey()}; 
			int lastAuditStatus[] = {DrugpurFilingApplyLastAuditStatus.PASSING.getKey()};
	        map.put("left","true");
	        map.put("submitStatus",SubmitStatus.SUMBIT_WAIT_AUDIT.getKey());
	        map.put("nextDealOrgId",user.getOrgId());
	        map.put("currentAuditStatuses", auditStatuse);
	        map.put("isLongFiling", IsLongFiling.TEMPORARY.getKey());
	        map.put("belongOrgId",user.getOrgId());
	        map.put("lastAuditStatuses", lastAuditStatus);
	        int  recordPendingReviewCount = drugpurFilingApplyManager.getCount(map);
	        Map<String, Object>  recordPendingReview = new HashMap<String, Object>();
	        recordPendingReview.put("url", "/drugpurFilingApply/toJGCSFXList.html");
	        recordPendingReview.put("sun", recordPendingReviewCount);
	        recordPendingReview.put("desc", "备案采购待复审");
			mapList.add(recordPendingReview);
		}else if(user.getUserType()==UserType.yy.getKey() || user.getUserType()==UserType.jcyy.getKey()){
			// 医疗机构   
			map.clear();
			map.put("hospitalDepartmentId", user.getDepartmentId());
			map.put("orderState",OrderState.WAIT_SUBMIT.getKey());
			
			// 待提交订单
			 int purchaseOrderCount = drugpurPurchaseOrderManager.getPurchaseOrderCount(map);
			 Map<String, Object>  purchaseOrder = new HashMap<String, Object>();
			 purchaseOrder.put("url", "/drugpurPurchaseOrder/toOrderToWaitList.html");
			 purchaseOrder.put("sun", purchaseOrderCount);
			 purchaseOrder.put("desc", "待提交订单");
			 mapList.add(purchaseOrder);
			 
			// 待收货配送明细
			 map.clear();
			 map.put("hospitalDepartmentId", user.getDepartmentId());
			 map.put("distributeState",  DistributeState.SHIPPED_WAIT_INSTORAGE.getKey());
			int distributeRecentCount = distributeRecentManager.getCount(map);
			 Map<String, Object>  distributeRecent = new HashMap<String, Object>();
			 distributeRecent.put("url", "/drugpurDistributeRecent/toOrderTakenConfirmList.html");
			 distributeRecent.put("sun", distributeRecentCount);
			 distributeRecent.put("desc", "待收货配送明细");
		     mapList.add(distributeRecent);
				
			// 审批通过待采购的临时备案
		    map.clear();
			map.put("hospitalDepartmentId", user.getDepartmentId());
			map.put("lastAuditStatus", LastAuditStatus.PASS_AUDIT.getKey());
			map.put("isLongFiling", IsLongFiling.TEMPORARY.getKey());
			map.put("isCanPurchase", 1);
			map.put("isUsing", YesOrNo.YES.getKey());
			int filingApplyCount= drugpurFilingApplyManager.getCount(map);
			Map<String, Object>  filingApply = new HashMap<String, Object>();
			 
			 filingApply.put("url", "/drugpurFilingApply/toSetRecordDrugList.html");
			 filingApply.put("sun", filingApplyCount);
			 filingApply.put("desc", "审批通过待采购的临时备案");
			 mapList.add(filingApply);
		}
		pagination.setRows(mapList);
		return pagination;
	}*/
	
	@RequestMapping("getPurchaseSituationData")
	@ResponseBody
	public JSONObject getPurchaseSituationData() {
		Integer userType = getSysUser().getUserType();
		String orgId = getSysUser().getOrgId();
		JSONObject map = new JSONObject();
		
		Pagination pagination = new Pagination(this.getRequest());
		if(userType.equals(UserType.wsj.getKey())){
//		if(userType.equals(UserType.jg.getKey())){ // jg(6, "监管机构")
		    StdManageOrg stdManageOrg = getSysUser().getStdManageOrg();
		    if("330000".equals(stdManageOrg.getAreaId())){
				pagination.getConditions().put("all", "all");
				orgId = "";
			}
		}
		if(userType.equals(UserType.cgzx.getKey())){
		//if(userType.equals(UserType.zx.getKey())){  //zx(5, "药械中心")
			pagination.getConditions().put("all", "all");
			orgId = "";
		}
		
		map.put("userType", userType);
		try {
			pagination.getConditions().put("orgId", orgId);
			pagination.getConditions().put("gatherYear", ParseDate.parseShortYearFormat(new Date()));
//		    List<DrugjgPurchaseGatherMonth> purchaseMonthDataList = drugjgPurchaseGatherMonthManager.getLists(pagination.getConditions());
//		    for (DrugjgPurchaseGatherMonth drugjgPurchaseGatherMonth : purchaseMonthDataList) {
//			   BigDecimal purchase = new BigDecimal(String.valueOf(Arith.div(drugjgPurchaseGatherMonth.getPurchaseAmount().doubleValue(),10000)));
//			   BigDecimal distribute = new BigDecimal(String.valueOf( Arith.div(drugjgPurchaseGatherMonth.getDistributeAmount().doubleValue(),10000)));
//			   BigDecimal warehouse = new BigDecimal(String.valueOf(Arith.div(drugjgPurchaseGatherMonth.getWarehouseAmount().doubleValue(),10000)));
//			   drugjgPurchaseGatherMonth.setPurchaseAmount(purchase);
//			   drugjgPurchaseGatherMonth.setDistributeAmount(distribute);
//			   drugjgPurchaseGatherMonth.setWarehouseAmount(warehouse);
//		   }
		   //map.put("purchaseMonthDataList", purchaseMonthDataList);
		} catch (Exception e) {
			log.error("Failed to getStdGmpgspData", e);
		}
		return map;
	}

	/**@RequestMapping("getJgPayConditionData")
	@ResponseBody
	public JSONObject getJgPayConditionData() {
		Integer userType = getSysUser().getUserType();
		JSONObject map = new JSONObject();
		Pagination pagination = new Pagination(this.getRequest());
		Boolean bool = false;
		if(userType.equals(UserType.jg.getKey())){
		    StdManageOrg stdManageOrg = getSysUser().getStdManageOrg();
		    if("330000".equals(stdManageOrg.getAreaId())){
		    	bool = true;
			}
		}
		if(userType.equals(UserType.zx.getKey())){
			bool = true;
		}
		map.put("userType", userType);
		map.put("showData", false);
		if(bool){
			map.put("showData", true);
			try {
				pagination.getConditions().put("gatherDate", ParseDate.parseShortFormat(new Date()));
				//List<DrugjgPayCondition> payList = drugjgPayConditionManager.getLists(pagination.getConditions());
				DrugjgPayCondition drugjgPayCondition =  new DrugjgPayCondition();
				if(payList.size() > 0){
					drugjgPayCondition =  payList.get(0);
					BigDecimal needPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getNeedPayAmount().doubleValue(), 10000,2)));
					BigDecimal payingAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getPayingAmount().doubleValue(), 10000,2)));
					BigDecimal hasPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getHasPayAmount().doubleValue(), 10000,2)));
					BigDecimal totalPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getTotalPayAmount().doubleValue(), 10000,2)));
					BigDecimal cityNeedPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getCityNeedPayAmount().doubleValue(), 10000,2)));
					BigDecimal cityPayingAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getCityPayingAmount().doubleValue(), 10000,2)));
					BigDecimal cityHasPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getCityHasPayAmount().doubleValue(), 10000,2)));
					BigDecimal cityTotalPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getCityTotalPayAmount().doubleValue(), 10000,2)));
					BigDecimal villageNeedPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getVillageNeedPayAmount().doubleValue(), 10000,2)));
					BigDecimal villagePayingAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getVillagePayingAmount().doubleValue(), 10000,2)));
					BigDecimal villageHasPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getVillageHasPayAmount().doubleValue(), 10000,2)));
					BigDecimal villageTotalPayAmount = new BigDecimal(String.valueOf(Arith.div(drugjgPayCondition.getVillageTotalPayAmount().doubleValue(), 10000,2)));
					drugjgPayCondition.setNeedPayAmount(needPayAmount);
					drugjgPayCondition.setPayingAmount(payingAmount);
					drugjgPayCondition.setHasPayAmount(hasPayAmount);
					drugjgPayCondition.setTotalPayAmount(totalPayAmount);
					drugjgPayCondition.setCityNeedPayAmount(cityNeedPayAmount);
					drugjgPayCondition.setCityPayingAmount(cityPayingAmount);
					drugjgPayCondition.setCityHasPayAmount(cityHasPayAmount);
					drugjgPayCondition.setCityTotalPayAmount(cityTotalPayAmount);
					drugjgPayCondition.setVillageNeedPayAmount(villageNeedPayAmount);
					drugjgPayCondition.setVillagePayingAmount(villagePayingAmount);
					drugjgPayCondition.setVillageHasPayAmount(villageHasPayAmount);
					drugjgPayCondition.setVillageTotalPayAmount(villageTotalPayAmount);
				}
				map.put("drugjgPayCondition",drugjgPayCondition);
			} catch (Exception e) {
				log.error("Failed to getStdGmpgspData", e);
			}
		}
		return map;
	}*/
}