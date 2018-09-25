package com.hsnn.medstgmini.yimiao.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetail;

import java.util.List;
import java.util.Map;

public interface YimiaoOrderdetailDao extends GenericDao<YimiaoOrderdetail, String> {
	YimiaoOrderdetail getByOrder(String orderId);
	int updateByOrder(List<Map<String, String>> list);
	/**
	 * 生产企业未完成采购订单
	 * @param conditions
	 * @return
	 */
	Page<YimiaoOrderdetail> getAllList(Map<String, Object> conditions);
	/**
	 * 生产企业已完成采购订单
	 * @param conditions
	 * @return
	 */
	Page<YimiaoOrderdetail> getOkList(Map<String, Object> conditions);
	/**
	 * 医疗机构未完成采购订单
	 * @param conditions
	 * @return
	 */
	Page<YimiaoOrderdetail> getYLAllList(Map<String, Object> conditions);
	/**
	 * 医疗机构已完成采购订单
	 * @param conditions
	 * @return
	 */
	Page<YimiaoOrderdetail> getYLOkList(Map<String, Object> conditions);
	/**
	 * 修改生产企业采购订单
	 * @param detail
	 * @return 
	 */
	int updateBySelective(YimiaoOrderdetail detail);
	
	int updateByDetailId(YimiaoOrderdetail detail);
	
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);
	Page<YimiaoOrderdetail> statisticsOne(Map<String, Object> conditions);
	Page<YimiaoOrderdetail> getSupHosp(Map<String, Object> conditions);
	Map<String,String> getHospDayCount(Map<String,Object> conditions);
	Page<YimiaoOrderdetail> statisticsTwo(Map<String, Object> conditions);
	Page<YimiaoOrderdetail> statisticsThree(Map<String, Object> conditions);
	/*Page<YimiaoOrderdetail> getStatisticsOne(Pagination page);*/
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
	
	List<YimiaoOrderdetail> getByOrderId(String orderId);
	List<Map<String,Object>> exportAllSup(Map<String,Object> map);

	Page<YimiaoOrderdetail> getCompanyScStatistics(Map<String,Object> map);
	List<Map<String,Object>> exportDataCompanySc(Map<String,Object> map);
	Map<String,String> getYimiaoCompanyScCount(Map<String,Object> map);

	Page<YimiaoOrderdetail> getCompanyPsStatistics(Map<String,Object> map);
	List<Map<String,Object>> exportDataCompanyPs(Map<String,Object> map);
	Map<String,String> getYimiaoCompanyPsCount(Map<String,Object> map);
	
	Page<YimiaoOrderdetail> getAdminAreaStatistics(Map<String,Object> map);
	List<Map<String,Object>> exportDataAdminArea(Map<String,Object> map);
	Map<String,String> getYimiaoAdminAreaCount(Map<String,Object> map);
	
	Page<YimiaoOrderdetail> getHospitalMonthStatistics(Map<String,Object> map);
	List<Map<String,Object>> exportDataHospitalMonth(Map<String,Object> map);
	Map<String,String> getYimiaoHospitalMonthCount(Map<String,Object> map);
	
	Page<YimiaoOrderdetail> getHospitalStatistics(Map<String,Object> map);
	List<Map<String,Object>> exportDataHospital(Map<String,Object> map);
	Map<String,String> getYimiaoHospitalCount(Map<String,Object> map);
	
	Page<YimiaoOrderdetail> getYimiaoProcurecatalogStatistics(Map<String,Object> map);
	List<Map<String,Object>> exportDataYimiaoProcurecatalog(Map<String,Object> map);
	Map<String,String> getYimiaoProcurecatalogCount(Map<String,Object> map);

    Page<YimiaoOrderdetail> getYimiaoData(Map<String,Object> map);

    //根据产品编号查询订单详情
    YimiaoOrderdetail getYimiaoOrderdetailByProcurecatalogId(Map<String, Object> queryMap);

    // 根据医院编号查询已完成数据
    Page<YimiaoOrderdetail> getYLOkListByHospitalId(Map<String, Object> conditions);

    //
	Page<YimiaoOrderdetail> queryYimiaoOrderDetailNotret(Map<String, Object> conditions);

    void updateOrderStatus();

	int toCheckOrderCount(String hospitalId);

	int updateOrderDetailStatus(Map<String, Object> map);

	void addProtoList(List<YimiaoOrderdetail> addList);

	List<YimiaoOrderdetail> getOrderDetailByOrderId(YimiaoOrderdetail yimiaoOrderdetail);

	int updateByData(Map<String,Object> params);

	int updateByDataForDel(Map<String,Object> params);

	int updateByDataForEdit(Map<String,Object> params);

	Page<YimiaoOrderdetail> getYimiaoPsData(Map<String,Object> map);

    Page<YimiaoOrderdetail> getYimiaoRkData(Map<String,Object> map);

    List<Map<String,Object>> getExportExcelCatalog(Map<String, Object> map);

	List<Map<String,Object>> getExportExcelDispatch(Map<String, Object> map);

	List<Map<String,Object>> getExportExcelPurchase(Map<String, Object> map);

    int saveByMap(Map<String,Object> params);

	int toCheckOrderCreateCount(String hospitalId);

	int updateByRetOrderIdForDel(Map<String,Object> params);

	int updateByOrderDetailIdForStatus(Map<String,Object> params);

	int updateByDetailIdForDH(Map<String,Object> params);

	void updateCancelOrderDetailStatus();

	void updateCancelOrderStatus();

	void updatetoOrderDetailStatus();

	String checkException(Map<String, String> map);

    int toCheckSwitch();

    Page<YimiaoOrderdetail> getDataByAll(Map<String, Object> map);

    Page<YimiaoOrderdetail> getDataByJKCenter(Map<String, Object> conditions);

	Page<YimiaoOrderdetail> getDataBySC(Map<String, Object> conditions);

	Page<YimiaoOrderdetail> getDataByPS(Map<String, Object> conditions);

	Page<YimiaoOrderdetail> getDataBySelf(Map<String, Object> conditions);

    Page<YimiaoOrderdetail> getAnaByAllTz(Map<String, Object> conditions);

    Page<YimiaoOrderdetail> getAnaHospdruginfoTotal(Map<String, Object> conditions);

    Page<YimiaoOrderdetail> getAnaByProdcompTz(Map<String, Object> conditions);

    Page<YimiaoOrderdetail> getAnaDelWithMon(Map<String, Object> conditions);

    Page<YimiaoOrderdetail> getAnaHospTotalMon(Map<String, Object> conditions);

    List<Map<String,Object>> getExportExcelDataBy(Map<String, Object> conditions);

    List<Map<String,Object>> exportExcelByAllTz(Map<String, Object> conditions);
}