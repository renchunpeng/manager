package com.hsnn.medstgmini.util;

import java.util.HashMap;

public class ConstantsUtil {

	
	public static String companyType(String code) {
		return companyType.get(code);
	}
	public static HashMap<String, String> companyType = new HashMap<String, String>(){{
		put("0", "生产企业"); 
		put("1", "代理企业"); 
		put("2", "配送企业");
		put("3", "生产配送企业");
		put("4", "进口药品国内总代理");
		put("5", "集团子公司生产企业");
		put("6", "集团子公司进口代理企业");
	}};
	
	public static HashMap<String, String> qingSuanType = new HashMap<String, String>(){{
		put("0", "待清算"); 
		put("1", "清算成功"); 
		put("2", "清算失败");
		
	}};
	public static String qingSuanType(String code) {
		return qingSuanType.get(code);
	}
	
	public static HashMap<String, String> isUsing = new HashMap<String, String>(){{
		put("1", "启用");
		put("0", "停用");
	}};
	public static String isUsing(String code) {
		return isUsing.get(code);
	}
	
	public static HashMap<String, String> YesOrNo = new HashMap<String, String>(){{
		put("1", "是");
		put("0", "否");
	}};
	
	public static String YesOrNo(String code) {
		return YesOrNo.get(code);
	}
	
	
	public static HashMap<String, String> auditStatus = new HashMap<String, String>(){{
		put("0", "已保存待提交");
		put("1", "已提交待审核");
		put("2", "审核通过");
		put("3", "审核不通过");
	}};
	
	public static String auditStatus(String code) {
		return auditStatus.get(code);
	}
	
	public static HashMap<String, String> qualificationStatus = new HashMap<String, String>(){{
		put("1", "合格");
		put("0", "不合格");
	}};
	
	public static String qualificationStatus(String code) {
		return qualificationStatus.get(code);
	}
	
	public static HashMap<String, String> initializationState = new HashMap<String, String>(){{
		put("0", "待提交");
		put("1", "待复核");
		put("2", "复核通过");
		put("3", "复核不通过");
		put("4", "审核通过");
		put("5", "审核不通过");
	}};
	
	public static String initializationState(String code) {
		return initializationState.get(code);
	}
	
	public static HashMap<String, String> drugPurchaseProperty = new HashMap<String, String>(){{
		put("1", "基层");
		put("2", "县级"); 
		put("3", "城市");
	}};
	
	public static String drugPurchaseProperty(String code) {
		return drugPurchaseProperty.get(code);
	}
	
	public static HashMap<String, String> initializationStateHosp = new HashMap<String, String>(){{
		put("0", "待提交");
		put("1", "待审核");
		put("2", "审核通过");
		put("3", "审核不通过");
	}};
	
	public static String initializationStateHosp(String code) {
		return initializationStateHosp.get(code);
	}
	
	
	public static HashMap<String, String> isIo = new HashMap<String, String>(){{
		put("1", "标内");
		put("0", "标外");
	}};
	
	public static String isIo(String code) {
		return isIo.get(code);
	}
	
	public static HashMap<String, String> subName = new HashMap<String, String>(){{
		put("1", "自购");
		put("0", "代购");
	}};
	
	public static String subName(String code) {
		return subName.get(code);
	}


	public static HashMap<String, String> orderStatus = new HashMap<String, String>(){{
		put("0", "未提交");
		put("1", "已提交");
		put("2", "已确认");
		put("3", "拒绝配送");
		put("4", "部分配送");
		put("5", "配送完成");
	}};
	
	public static String orderStatus(String code) {
		return orderStatus.get(code);
	}

	
	public static HashMap<String, String> confirmState = new HashMap<String, String>(){{
		put("0", "未提交");
		put("1", "已提交");
		put("2", "已发送");
		put("3", "审核不通过");
		put("4", "同意退货");
		put("5", "不退货");
		put("6", "退货中");
		put("7", "已完成");
	}};
	public static String confirmState(String code) {
		return confirmState.get(code);
	}
	
	public static HashMap<String, String> confirmStateCG = new HashMap<String, String>(){{
		put("0", "待处理");
		put("1", "供货");
		put("2", "不供货");
		put("3", "提交");
		put("4", "审核不通过");
		put("5", "收货中");
		put("6", "已完成");
		put("7", "已取消");
	}};
	public static String confirmStateCG(String code) {
		return confirmStateCG.get(code);
	}
	
	public static String companyTypeYiMiao(String code) {
		return companyTypeYiMiao.get(code);
	}
	public static HashMap<String, String> companyTypeYiMiao = new HashMap<String, String>(){{
		put("0", "生产"); 
		put("1", "配送"); 
	}};

    public static HashMap<String, String> rejectedDetail = new HashMap<String, String>(){{
		put("0001", "未提交");
		put("0002", "已提交");
		put("0003", "审核通过");
		put("0004", "审核不通过");
		put("0005", "企业确认退货");
		put("0006", "医院确认退货");
		
	}};
	public static String rejectedDetail(String code) {
		return rejectedDetail.get(code);
	}
	
	 public static HashMap<String, String> orderDetailStatus = new HashMap<String, String>(){{
			put("0001","未提交");
			put("0002","已提交");
			put("0003","审核通过");
			put("0004","审核不通过");
			put("0005","已加入采购单");
			put("0006","已汇总发送企业");
			put("0007","已分流给配送企业");
			put("0008","已配送");
			put("0009","已入库");
			put("0010","中心已撤废");
			put("0011","已撤单");
			put("0012","异议撤单");
			put("0013","已召回");
			put("0014","召回撤单");
			
		}};
		public static String orderDetailStatus(String code) {
			return orderDetailStatus.get(code);
		}
}
