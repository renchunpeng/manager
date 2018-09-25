package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdCataProdRel;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 *@category 药品目录关联表sevice接口
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
public interface StdCataProdRelManager extends GenericManager<StdCataProdRel, String> {
	/**
	 * 检查药品是否重复
	 * @param StdProduct form
	 * @return
	 */
	//boolean checkRepeat(StdDrugcatalog sd);
	/**
	 * 获取申报目录下的剂型规格
	 * @param page
	 * @return
	 */
	Pagination queryDrug(Pagination page);
	/**
	 * 药品添加
	 * @param form
	 * @return
	 */
	boolean addStdCataProdRel(StdCataProdRel sd);
	
	/**
	 * 药品保存
	 * @param form
	 * @return
	 */
	boolean saveStdCataProdRel(StdCataProdRel form);
	/**
	 * 获取资审采购目录药品 不包含已经勾选的（除去 drugpur_comp_apply 中的数据）
	 * @param page
	 * @return
	 */
	Pagination getGoodsList(Pagination page);
	/**
	 * 批量更新字段
	 * @param ids form
	 * @return
	 */
	boolean batchUpdate(String[] ids,StdCataProdRel form);

	
	boolean checkRepeatStdCataProdRelLin(StdCataProdRel stdCheck);



	boolean addStdCataProdRelImport(StdCataProdRel stdCataProdRel);
	
	/**
	 * excel数据入库
	 */
	int saveExcelDate(Map<String, Object> map);

	List<StdCataProdRel> getByProdId(Map<String,String> val);

	List<StdCataProdRel> getCodeId(String drugcatalogCode);

	void batchSave(String drugcatalogCode, String drugcatalogCodes);

	Map<String ,Object> getCatalogDetails(Map<String ,Object> map);
	int updateGoodsApp(String id);
}


