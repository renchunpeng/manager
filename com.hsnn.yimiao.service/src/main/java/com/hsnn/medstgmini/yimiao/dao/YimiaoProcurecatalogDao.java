package com.hsnn.medstgmini.yimiao.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoProcurecatalog;

import java.util.List;
import java.util.Map;

public interface YimiaoProcurecatalogDao extends GenericDao<YimiaoProcurecatalog, Integer> {
	List<YimiaoProcurecatalog> queryByNot(Map<String, Object> map);
	List<YimiaoProcurecatalog> queryByNotret(Map<String, Object> map);
	/**
	 * 疫苗列表
	 * @param conditions
	 * @return
	 */
	Page<YimiaoProcurecatalog> getAllList(Map<String, Object> conditions);
	/**
	 * 状态启用
	 * @param procurecatalogId
	 * @return
	 */
	int updateStart(Integer procurecatalogId);
	/**
	 * 状态停用
	 * @param procurecatalogId
	 * @return
	 */
	int updateDisable(Integer procurecatalogId);
	
	YimiaoProcurecatalog getbygood(String goodsId);
	
	/**
	 * 导出
	 */
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);

	List<YimiaoProcurecatalog> getGoodsList(Map<String, Object> map);

	List<YimiaoProcurecatalog> getProjName();

	Page<YimiaoProcurecatalog> getYimiaoProductName(Map<String,Object> map);

    int updateCompanyNamePsByProcurecatalogId(YimiaoProcurecatalog yimiaoProcurecatalog);

    List<YimiaoProcurecatalog> queryCatalog(Map<String, Object> map);

    List<Map<String,Object>> getExportExcelRelationData(Map<String, Object> map);

	int updateCompanyNamePsByYimiaoCatalog(YimiaoProcurecatalog yimiaoProcurecatalog);

	int updateCompanyNamePsByYimiaoOrderdetail(YimiaoProcurecatalog yimiaoProcurecatalog);

    Map<String,String> getSwtichState();

	int changeSwitch(String state);
}