package com.hsnn.medstgmini.yimiao.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailRet;

public interface YimiaoOrderdetailRetManager extends GenericManager<YimiaoOrderdetailRet, String> {
	// 扩展接口
	
	/**
	 * 修改生产企业退货记录
	 * @param detail
	 * @return
	 */
	boolean updateByDetailRetId(YimiaoOrderdetailRet detail);
	int updateByOrder(List<Map<String, String>> list);
	YimiaoOrderdetailRet getByOrder(String id);
	Pagination getYLOkList(Pagination page);
	Pagination getYLAllList(Pagination page);
	Pagination getRetNoFinishList(Pagination page);
	Pagination getRetFinishList(Pagination page);
	
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataNo(Map<String, Object> map);
	
	List<Map<String, Object>> getExportExcelDataWSJ(Map<String, Object> map);
	Map<String,Object> getRetFinishCountList(Map<String,Object> map);
	Map<String,Object> findCountList(Map<String,Object> map);
	Map<String,Object> getYLAllCountList(Map<String,Object> map);
	Map<String,Object> getYLOkCountList(Map<String,Object> map);
	Map<String,Object> getRetNoFinishCountList(Map<String,Object> map);
	List<YimiaoOrderdetailRet> getOrderdetailRetByOrderId(String orderId);

    int toCheckDate();

	int addAndUpdateForDetail(List<Map<String, Object>> list,Pagination pagination);

	int saveByMap(Map<String,Object> params);

	int deleteAndUpdateByRetDetailId(List<Map<String, Object>> list);

	int updateByDataList(List<Map<String, Object>> list);

	int updataByListForSubmit(List<Map<String, String>> list);

	int updateByRetList(List<Map<String, Object>> list);

	int toCheckCount(List<Map<String, Object>> list);

    List<Map<String,Object>> getExportExcelDataNoSc(Map<String, Object> conditions);

    int deleteByMap(Map<String,Object> params);
}