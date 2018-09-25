package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdCataProdRelLin;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 *@category 药品目录关联表sevice接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdCataProdRelLinManager extends GenericManager<StdCataProdRelLin, String> {
	
	/**
	 * 获取OK分页数据
	 * @param page
	 * @return
	 */
	Pagination getOKList(Pagination page);
	
	/**
	 * 获取NG分页数据
	 * @param page
	 * @return
	 */
	Pagination getNGList(Pagination page);
	
	Pagination getStdCataProdRelLinNoPage(Pagination page);
	
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);

	void addStdCataProdRelLin(StdCataProdRelLin stdCataProdRelLin);

	void addStdCataProdRelLinS(StdCataProdRelLin stdCataProdRelLin);

	int deleteStdCataProdRelLin(String drugcatalogCode,String stdCataProdRelFileId);

	List<StdCataProdRelLin> getStdCataProdRelLinById(Map<String, Object> map);


}


