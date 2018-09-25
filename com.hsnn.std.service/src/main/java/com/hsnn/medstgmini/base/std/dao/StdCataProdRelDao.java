package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdCataProdRel;
import com.hsnn.medstgmini.common.dao.GenericDao;

/**
 * 
 *@category 药品目录关联表dao接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdCataProdRelDao  extends GenericDao<StdCataProdRel, String> {

/*	int checkRepeat(StdDrugcatalog sd);*/
	Page<StdCataProdRel> queryDrug(Map<String,Object> map);

	int batchUpdate(@Param("ids")  String[] ids, @Param("stdCataProdRel") StdCataProdRel record );

	int checkRepeatStdCataProdRelLin(String str2, String str3, String str4,
			String drugcatalogCode);

	int checkRepeatStdCataProdRelLin(StdCataProdRel stdCheck);

	int addStdCataProdRelImport(StdCataProdRel stdCataProdRel);
	
	int saveExcelDate(Map<String, Object> map);

	List<StdCataProdRel> getByProdId(Map<String,String> val);

	List<StdCataProdRel> getCodeId(String drugcatalogCode);

	Map<String,Object> getCatalogDetails(Map<String,Object> map);

	Page<StdCataProdRel> getGoodsList(Map<String, Object> map);
	int updateGoodsApp(String id);
	int updateStdCataProdRel(String id);
	int saveLog(String id);
	int deletePackageSplit(String id);
	void batchSave(@Param("drugcatalogCode") String  drugcatalogCode,@Param("drugcatalogCodes") String drugcatalogCodes);
}