package com.hsnn.medstgmini.yimiao.service;


import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoProcurecatalog;

import java.util.List;
import java.util.Map;

public interface YimiaoProcurecatalogManager extends GenericManager<YimiaoProcurecatalog, Integer> {
	// 扩展接口
	Pagination queryByNot(Pagination pagination);
	Pagination queryByNotret(Pagination pagination);
	Pagination getAllList(Pagination page);
	int updateStart(Integer procurecatalogId);
	int updateDisable(Integer procurecatalogId);
	YimiaoProcurecatalog getbygood(String id);
	//导出
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);

	Pagination getGoodsList(Pagination page);
	List<YimiaoProcurecatalog> getProjName();

	Pagination getYimiaoProductName(Pagination page);

	// 根据疫苗编号修改配送企业
    int updateCompanyNamePsByProcurecatalogId(String companyNamePs,Integer procurecatalogId);

	Pagination queryCatalog(Pagination pagination);


    List<Map<String,Object>> getExportExcelRelationData(Map<String, Object> conditions);

    Map<String,String> getSwtichState();

	int changeSwitch(String state);
}