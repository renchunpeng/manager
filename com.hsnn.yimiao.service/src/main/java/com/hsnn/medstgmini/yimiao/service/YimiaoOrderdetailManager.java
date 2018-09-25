package com.hsnn.medstgmini.yimiao.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetail;

import java.util.List;
import java.util.Map;

public interface YimiaoOrderdetailManager extends GenericManager<YimiaoOrderdetail, String> {
	// 扩展接口
	YimiaoOrderdetail getByOrder(String id);
	int updateByOrder(List<Map<String, String>> order);
	Pagination getAllList(Pagination page);
	Pagination getOkList(Pagination page);
	int updateBySelective(YimiaoOrderdetail detail);
	Pagination getYLAllList(Pagination page);
	Pagination getYLOkList(Pagination page);
	Pagination getStatisticsOne(Pagination page);
	Pagination getSupHosp(Pagination page);
	Map<String,String> getHospDayCount(Pagination pagination);
	Pagination getStatisticsTwo(Pagination page);
	Pagination getStatisticsThree(Pagination page);
	boolean updateByDetailId(YimiaoOrderdetail detail);
	
	List<Map<String, Object>> getExportExcelDataCG(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataNCG(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataWSJ(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataPS(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataPSRET(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataMLTJ(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataMLTJTwo(Map<String, Object> map);
	List<Map<String, Object>> getExportExcelDataMLTJThree(Map<String, Object> map);
	
	Map<String, Object> getCountOkList(Map<String, Object> map);
	
	Map<String, Object> getAllCountList(Map<String, Object> map);
	
	Map<String, Object> findCountList(Map<String, Object> map);
	Map<String, Object> getYLAllCountList(Map<String, Object> map);
	Map<String, Object> getYLOkCountList(Map<String, Object> map);
	
	List<Map<String,Object>> exportAllSup(Pagination page);
	List<YimiaoOrderdetail> getByOrderId(String orderId);
	
	Pagination getCompanyPsStatistics(Pagination page);
	List<Map<String,Object>> exportDataCompanyPs(Pagination page);
	Map<String,String> getYimiaoCompanyPsCount(Pagination page);
	
	Pagination getCompanyScStatistics(Pagination page);
	List<Map<String,Object>> exportDataCompanySc(Pagination page);
	Map<String,String> getYimiaoCompanyScCount(Pagination page);
	
	Pagination getAdminAreaStatistics(Pagination page);
	List<Map<String,Object>> exportDataAdminArea(Pagination page);
	Map<String,String> getYimiaoAdminAreaCount(Pagination page);
	
	Pagination getHospitalMonthStatistics(Pagination page);
	List<Map<String,Object>> exportDataHospitalMonth(Pagination page);
	Map<String,String> getYimiaoHospitalMonthCount(Pagination page);
	
	Pagination getHospitalStatistics(Pagination page);
	List<Map<String,Object>> exportDataHospital(Pagination page);
	Map<String,String> getYimiaoHospitalCount(Pagination page);
	
	Pagination getYimiaoProcurecatalogStatistics(Pagination page);
	List<Map<String,Object>> exportDataYimiaoProcurecatalog(Pagination page);
	Map<String,String> getYimiaoProcurecatalogCount(Pagination page);

	/**
	 * 退货数据来源医疗机构已完成采购订单
	 * @param conditions
	 * @return getYLOkListByHOSPITAL_ID
	 */
	Pagination getYLOkListByHospitalId(Pagination conditions);

	/**
	 * 根据药品编号查询药品信息
	 * @param conditions
	 * @return
	 */
    YimiaoOrderdetail getYimiaoOrderdetailByProcurecatalogId(Pagination conditions);

	Pagination getYimiaoData(Pagination page);

	/**
	 * 新增疫苗数据不在退货详情表中
	 * @param pagination
	 * @return
	 */
	Pagination queryYimiaoOrderDetailNotret(Pagination pagination);

    void updateOrderStatus();


	// 获取当月订单数量
	int toCheckOrderCount(String hospitalId);

    int updateOrderDetailStatus(Pagination page);

	void addProtoList(List<YimiaoOrderdetail> addList);

	List<YimiaoOrderdetail> getOrderDetailByOrderId(YimiaoOrderdetail yimiaoOrderdetail);

	int updateByData(Map<String,Object> params);

	int updateByDataForDel(Map<String,Object> params);

	int updateByDataForEdit(Map<String,Object> params);

	Pagination getYimiaoPsData(Pagination page);

    Pagination getYimiaoRkData(Pagination page);

    List<Map<String,Object>> getExportExcelCatalog(Map<String, Object> conditions);

	List<Map<String,Object>> getExportExcelDispatch(Map<String, Object> conditions);

	List<Map<String,Object>> getExportExcelPurchase(Map<String, Object> conditions);

    int addAndUpdateForDetail(List<Map<String, Object>> list,Pagination pagination);

    int saveByMap(Map<String,Object> params);

	int toCheckOrderCreateCount(String hospitalId);

	int changeStatus(List<Map<String, String>> order);

	int updateByOrderList(List<Map<String, Object>> list);

	int updateByRetOrderIdForDel(Map<String,Object> params);

	int updateByDetailIdForDH(List<Map<String, Object>> list);

	void updateCancelStatus();

	String checkException(Map<String, String> map);

    int toCheckSwitch();

	Pagination getDataByAll(Pagination page);

    Pagination getDataByJKCenter(Pagination pagination);

	Pagination getDataBySC(Pagination pagination);

    Pagination getDataByPS(Pagination pagination);

	Pagination getDataBySelf(Pagination pagination);

    Pagination getAnaByAllTz(Pagination pagination);

    Pagination getAnaHospdruginfoTotal(Pagination page);

    Pagination getAnaByProdcompTz(Pagination page);

    Pagination getAnaDelWithMon(Pagination page);

    Pagination getAnaHospTotalMon(Pagination page);

    List<Map<String,Object>> getExportExcelDataBy(Map<String, Object> conditions);

    List<Map<String,Object>> exportExcelByAllTz(Map<String, Object> conditions);
}