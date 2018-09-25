package com.hsnn.medstgmini.yimiao.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetailRet;

public interface YimiaoOrderdetailRetDao extends GenericDao<YimiaoOrderdetailRet, String> {
	
	void updateByDetailRetId(YimiaoOrderdetailRet detail);
	int updateByOrder(List<Map<String, String>> list);
	YimiaoOrderdetailRet getByOrder(String orderId);
	Page<YimiaoOrderdetailRet> getYLOkList(Map<String, Object> conditions);
	Page<YimiaoOrderdetailRet> getYLAllList(Map<String, Object> conditions);
	Page<YimiaoOrderdetailRet> getRetNoFinishList(Map<String, Object> conditions);
	Page<YimiaoOrderdetailRet> getRetFinishList(Map<String, Object> conditions);
	Page<YimiaoOrderdetailRet> getAllList(Map<String, Object> conditions);//分页查询
	
	List<Map<String, Object>> getExportExcelData(
			Map<String, Object> map);	
	List<Map<String, Object>> getExportExcelDataNo(
			Map<String, Object> map);	
	List<Map<String, Object>> getExportExcelDataWSJ(
			Map<String, Object> map);
	
	Map<String,Object> getRetFinishCountList(Map<String,Object> map);
	Map<String,Object> findCountList(Map<String,Object> map);
	Map<String,Object> getYLAllCountList(Map<String,Object> map);
	Map<String,Object> getYLOkCountList(Map<String,Object> map);
	Map<String,Object> getRetNoFinishCountList(Map<String,Object> map);
	
	List<YimiaoOrderdetailRet> getOrderdetailRetByOrderId(String orderId);

    int toCheckIsWork(String dateNowStr);

	int toCheckDate(String firstDate, String dateNowStr);

	int saveByMap(Map<String,Object> params);

	int deleteByIdList(Map<String,Object> params);

	int updateByIdList(Map<String,Object> params);

	int updateByRetIdForStatus(Map<String,Object> params);

    void updateByOrderCount(Map<String, Object> params);

	int toCheckCount(Map<String, Object> params);

    List<Map<String,Object>> getExportExcelDataNoSc(Map<String, Object> map);

    int deleteByMap(Map<String, Object> params);
}