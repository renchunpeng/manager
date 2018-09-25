package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdCataProdRelLin;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 *@category 药品目录关联表dao接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdCataProdRelLinDao  extends GenericDao<StdCataProdRelLin, String> {

	List<StdCataProdRelLin> getOKList(Map<String, Object> map);
	
	List<StdCataProdRelLin> getNGList(Map<String, Object> map);
	
	List<StdCataProdRelLin> queryStdCataProdRelLinNoPage(Pagination page);
	
	List<Map<String,Object>> getExportExcelData(Map<String,Object> map);

	void addStdCataProdRelLin(StdCataProdRelLin stdCataProdRelLin);

	void addStdCataProdRelLinS(StdCataProdRelLin stdCataProdRelLin);

	int deleteStdCataProdRelLin(@Param("drugcatalogCode")String drugcatalogCode,@Param("stdCataProdRelFileId")String stdCataProdRelFileId);

	List<StdCataProdRelLin> getStdCataProdRelLinById(Map<String, Object> map);


	
}