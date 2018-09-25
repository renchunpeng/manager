package com.hsnn.medstgmini.base.std.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdDrugcatalog;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.Pagination;

import java.util.List;
import java.util.Map;

/**
 * 
 *@category 药品目录管理dao接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdDrugcatalogDao  extends GenericDao<StdDrugcatalog, String> {

	int checkRepeat(StdDrugcatalog sd);

	Page<StdDrugcatalog> getContentsList(Map<String, Object> conditions);

	List<StdDrugcatalog> removalqueryAll(Map<String, Object> map);

}