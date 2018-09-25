package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdGoods;
import com.hsnn.medstgmini.common.dao.GenericDao;

/**
 * 
 * 产品管理DAO  
 *
 * @ClassName: StdGoodsDao  
 * @author zhou.xy
 * @date 2016年2月26日 上午9:19:26  
 *
 */
public interface StdGoodsDao extends GenericDao<StdGoods, java.lang.Integer>{
	/**
	 * 
	 *@category 获取待审核(或复核)产品信息
	 *@author wangbing
	 *@date 2016-2-26 16:05:20
	 *@return
	 */
	public Map<String,Object> getGoodsAuditInfo(Map<String,Object> map);
	/**
	 * 
	 *@category 更新审核(或复核)
	 *@author wangbing
	 *@date 2016-2-26 16:05:26
	 *@return
	 */
	public void updateAudit(Map<String,Object> map);
	
	int batchUpdate(@Param("ids")  String[] ids, @Param("stdGoods") StdGoods stdGoods );
	
	/**
	 * 验证产品是否重复：
	 * 判断归档号是否重否；通用名、剂型、规格、转换比；包装材质；包装单位；生产企业；分包装企业重复
	 *
	 * @Title: checkRepeat 
	 * @param stdGoods
	 * @return 
	 * @return int
	 * @throws
	 */
	public List<StdGoods> checkRepeat(StdGoods stdGoods);
	
	/**
	 * 根据提供的产品编号和字段修改具体的值
	 * @param stdGoods
	 */
	int updateColumnById(Map<String, Object> map);
	
	List<StdGoods> queryAllForJG(Map<String, Object> map);
	public Map<String, Object> getByGoodsId(Integer goodsId);
	public Page<StdGoods> queryExist(Map<String, Object> conditions);
	public Page<StdGoods> getGoodsList(Map<String, Object> conditions);
	public <StdGoodsResult> StdGoods getScreen(StdGoodsResult stdGoodsResult);
	public Integer returnLastId();
	public String ModifyGoodsCompany(Map<String, String> map);
	
	public void stdGoodsNoUsing(@Param("goods")String goods);
	public void baseGoodsNoUsing(@Param("goods")String goods);

	Page<StdGoods> getGoodsForCompApply(Map<String, Object> map);
	Page<StdGoods> getGoodsCf(Map<String, Object> map);
	int updateYp(StdGoods entity);

	StdGoods getDataById(Integer goodsId);

	void updateCompTb(Map<String,Object> map);

	Page<StdGoods> getAllStdGoodsData(Map<String,Object> map);

    void BacthIsUsingUpdate(@Param("insertMap")List<Map<String, Object>> insertMap,@Param("isUsing")String isUsing);

	void updateCompSc(Map<String,Object> map);
	void updateCompTbAndSc(Map<String,Object> map);
	void updateCompOnlyTb(Map<String,Object> map);

	public void stdGoodsListNoUsing(String goodsId);
}
