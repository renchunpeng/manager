/**
 * 上午9:52:38
 */
package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdProduct;
import com.hsnn.medstgmini.common.dao.GenericDao;

/**
 * @author hsnn
 *
 */
public interface StdProductDao extends GenericDao<StdProduct, java.lang.Integer>{
int batchUpdate(@Param("ids")  String[] ids, @Param("sp") StdProduct record );
	
	int checkRepeat(StdProduct spf);
	
	int returnLastId();
	
	int checkRepeatStdCataProdRelLinProd(StdProduct stdCheckProd);
	
	StdProduct getByNameo(StdProduct stdCheckProd);
	
	List<Map<String,Object>> getExportExcelData(Map<String,Object> map);

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
	List<StdProduct> getStdProductIds(@Param("ids") String[] ids);

	void saveStdProduct(StdProduct stdProduct);

	void saveStdPro(StdProduct stdProduct);

	List<StdProduct> getListByName(String name);

	List<StdProduct> getDataList(Map<String,Object> map);
}
