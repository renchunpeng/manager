package com.hsnn.medstgmini.base.std.service;


import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdProduct;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
/**
 * 
 *@category 药品管理接口
 *@author 应晓川
 *@date 2016年2月25日11:23:41
 */
public interface StdProductManager extends GenericManager<StdProduct, Integer>{
	
	
	/**
	 * 
	 *@category 药品信息查看
	 *@author 应晓川
	 *@date 2016年2月25日11:27:51
	 *@return
	 */
	Pagination getInfoList(Pagination page);
	
	/**
	 * 药品添加
	 * @param form
	 * @return
	 */
	boolean addData(StdProduct form);
	
	/**
	 * 药品保存
	 * @param form
	 * @return
	 */
	boolean saveData(StdProduct form);
	
	/**
	 * 获取单个药品
	 * @param form
	 * @return
	 */
	StdProduct getStdProductById(Integer id);
	
	/**
	 * 批量更新字段
	 * @param ids form
	 * @return
	 */
	boolean batchUpdate(String[] ids,StdProduct form);
	boolean batchUpdate(Pagination page,StdProduct form);
	
	/**
	 * 检查药品是否重复
	 * @param StdProduct form
	 * @return
	 */
	boolean checkRepeat(StdProduct form);
	/**
	 * 返回新增、更新后的对象id
	 * @param 
	 * @return int
	 */
	int returnLastId();

	
	/**
	 * 药品目录导入时检查药品是否重复
	 * @param 
	 * @return
	 */
	boolean checkRepeatStdCataProdRelLinProd(StdProduct stdCheckProd);
	
	StdProduct getByName(StdProduct stdCheckProd);
	
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);

	void addStdProductProdName(StdProduct stdProduct);
	
	/**
	 * 根据提供的产品编号和字段修改具体的值
	 * @param stdGoods
	 */
	int updateColumnById(Map<String, Object> map);

	Map<String, Object> findGoodsId(String productId);
	
	/**
	 * 日志插入
	 * Sun
	 * @param ids
	 * @return
	 */
	List<StdProduct> getStdProductIds(String[] ids);

	void save(StdProduct stdProduct);

	void saveStdProduct(StdProduct stdProduct);

	void saveStdPro(StdProduct stdProduct);

	List<StdProduct> getListByName(String name);

	Pagination getDataList(Pagination page);

}