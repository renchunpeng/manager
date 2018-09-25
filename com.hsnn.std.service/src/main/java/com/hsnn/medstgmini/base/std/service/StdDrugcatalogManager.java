package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdDrugcatalog;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 *@category 药品目录管理接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdDrugcatalogManager extends GenericManager<StdDrugcatalog, String> {
	/**
	 * 检查药品是否重复
	 * @param StdProduct form
	 * @return
	 */
	boolean checkRepeatStdDrugcatalog(StdDrugcatalog sd);
	
	/**
	 * 药品添加
	 * @param form
	 * @return
	 */
	boolean addStdDrugcatalog(StdDrugcatalog sd);
	
	/**
	 * 药品保存
	 * @param form
	 * @return
	 */
	boolean saveStdDrugcatalog(StdDrugcatalog form);


	Pagination getContentsList(Pagination page);
}


