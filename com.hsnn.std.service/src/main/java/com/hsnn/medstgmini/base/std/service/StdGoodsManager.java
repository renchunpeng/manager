package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.ContrastObj;
import com.hsnn.medstgmini.base.std.model.StdGoods;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 * 产品接口  
 *
 * @ClassName: StdGoodsManager  
 * @author zhou.xy
 * @date 2016年2月26日 上午9:29:39  
 *
 */
public interface StdGoodsManager extends GenericManager<StdGoods, Integer> {
	
	/**
	 * 批量更新字段
	 * @param ids 
	 * @param form
	 * @author lil
	 * @return
	 */
	boolean batchUpdate(String[] ids,StdGoods stdGoods);
	boolean batchUpdateForEnabled(String[] ids,StdGoods stdGoods);
	Map<String, Object> getGoodsAuditInfo(Map<String, Object> map);

	void updateAudit(Map<String, Object> map);

	/**
	 * 验证产品是否重复：
	 * 判断归档号是否重否；通用名、剂型、规格、转换比；包装材质；包装单位；生产企业；分包装企业重复 
	 *
	 * @Title: checkRepeat 
	 * @param stdGoods
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean checkRepeat(StdGoods stdGoods);
	
	/**
	 * 提交澄清信息
	 * @param stdGoods
	 */
	int updateClarifyById(StdGoods stdGoods);
	
	/**
	 * 根据提供的产品编号和字段修改具体的值
	 * @param stdGoods
	 */
	int updateColumnById(Map<String, Object> map);
	
	/**
	 * 根据修改的内容循环插入澄清记录
	 * @param map
	 * @return
	 */
	int saveGoodsClearByMap(List<ContrastObj> coList, StdGoods stdGoods);
	
	/**
	 * 获取产品信息
	 */
	Pagination getListForJG(Pagination page);
	
	Map<String,Object> getByGoodsId(Integer goodsId);
	
	Pagination queryExist(Pagination pagination);
	Integer returnLastId();
	<StdGoodsResult> StdGoods getScreen(StdGoodsResult stdGoodsResult);
	
	String UpdateGoogsCompanyById(Map<String, String> map);

	Pagination getGoodsForCompApply(Pagination pagination);
	Pagination getGoodsCf(Pagination pagination);
	int updateYp(StdGoods model);

	StdGoods getDataById(Integer goodsId);

	void updateCompTb(Map<String,Object> map);

	Pagination getAllStdGoodsData(Pagination page);

    void BacthIsUsingUpdate(List<Map<String, Object>> insertMap,String isUsing);

	void updateCompSc(Map<String,Object> map);
	void updateCompTbAndSc(Map<String,Object> map);
}
