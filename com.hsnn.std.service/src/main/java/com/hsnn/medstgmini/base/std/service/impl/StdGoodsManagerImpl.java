package com.hsnn.medstgmini.base.std.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdGoodsDao;
import com.hsnn.medstgmini.base.std.enums.InitializationStateEnum;
import com.hsnn.medstgmini.base.std.model.ContrastObj;
import com.hsnn.medstgmini.base.std.model.StdGoods;
import com.hsnn.medstgmini.base.std.model.StdGoodsClear;
import com.hsnn.medstgmini.base.std.service.StdGoodsClearManager;
import com.hsnn.medstgmini.base.std.service.StdGoodsManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 * 产品接口实现
 *
 * @ClassName: StdGoodsManagerImpl
 * @author zhou.xy
 * @date 2016年2月26日 上午9:29:25
 *
 */
@Service
public class StdGoodsManagerImpl extends GenericManagerImpl<StdGoods, Integer> implements StdGoodsManager {
	@Autowired
	private StdGoodsClearManager stdGoodsClearManager;
	
	@Autowired
	private StdGoodsDao dao;
	/**
	 * 批量更新字段
	 * @param ids 
	 * @param stdGoods
	 * @author lil
	 * @return
	 */
	@Override
	public boolean batchUpdate(String[] ids,StdGoods stdGoods) {
		boolean b =((StdGoodsDao) getDao()).batchUpdate(ids, stdGoods) > 0;
		if(b == true){
			for(String goods : ids){
				dao.stdGoodsListNoUsing(goods);
			}
			
		}
		
		return b;
	}

	/**
	 * 批量启用
	 * @param ids
	 * @param stdGoods
	 * @author lil
	 * @return
	 */
	@Override
	public boolean batchUpdateForEnabled(String[] ids,StdGoods stdGoods) {
		boolean b =((StdGoodsDao) getDao()).batchUpdate(ids, stdGoods) > 0;
		return b;
	}

	
	/**
	 * 
	 *@category 获取待审核(或复核)产品信息
	 *@author wangbing
	 *@date 2016-2-26 16:05:20
	 *@return
	 */
	@Override
	public Map<String,Object> getGoodsAuditInfo(Map<String,Object> map){
		return ((StdGoodsDao)getDao()).getGoodsAuditInfo(map);
	}
	
	/**
	 * 
	 *@category 更新审核(或复核)
	 *@author wangbing
	 *@date 2016-2-26 16:05:26
	 *@return
	 */
	@Override
	public void updateAudit(Map<String,Object> map){
		int initializationState = Integer.parseInt(map.get("initializationState")+"");
		if(initializationState == InitializationStateEnum.auditAdopt.getKey()) {//审核通过
			map.put("auditRemark", "");//清空审核备注
		}
		((StdGoodsDao)getDao()).updateAudit(map);
	}
	
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
	public boolean checkRepeat(StdGoods stdGoods) {
		List<StdGoods> list= ((StdGoodsDao)getDao()).checkRepeat(stdGoods);
		if(list.size()>0){
			if(null != stdGoods.getGoodsId()&& list.size()==1){
				StdGoods sg= list.get(0);
				boolean temp = sg.getGoodsId().equals(stdGoods.getGoodsId()); 
				return !temp;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 *@category 提交澄清信息
	 *@author lilong
	 *@date 2016-2-26 16:05:26
	 *@return
	 */
	@Override
	public int updateClarifyById(StdGoods stdGoods){
//		if(stdGoods.getClearStatus() == 2 || stdGoods.getClearStatus() == 3 || stdGoods.getClearStatus() == 4) {//提交
			StdGoodsClear stdGoodsClear = new StdGoodsClear();
			stdGoodsClear.setGoodsId(stdGoods.getGoodsId());
			stdGoodsClear.setIsOnlineClear(1);//网上交易
			if(stdGoods.getClearStatus() == 2) {
				stdGoodsClear.setOnlineClearStatus(1);
				stdGoodsClear.setBeforOnlineClearStatus("0");
			}else if(stdGoods.getClearStatus() == 3) {
				stdGoodsClear.setOnlineClearStatus(2);
				stdGoodsClear.setBeforOnlineClearStatus("1");
			}else if(stdGoods.getClearStatus() == 4) {
				stdGoodsClear.setOnlineClearStatus(3);
				stdGoodsClear.setBeforOnlineClearStatus("2");
			}
			
			stdGoodsClear.setLastUpdateUserId(stdGoods.getLastUpdateUserId());
			stdGoodsClear.setLastUpdateUserName(stdGoods.getLastUpdateUserName());
			stdGoodsClearManager.updateClearStatus(stdGoodsClear);
//		}
		return ((StdGoodsDao) getDao()).update(stdGoods);
	}
	
	/**
	 * 根据提供的产品编号和字段修改具体的值
	 * @param map
	 */
	public int updateColumnById(Map<String, Object> map) {
		
		return ((StdGoodsDao) getDao()).updateColumnById(map);
	}
	
	/**
	 * 根据修改的内容循环插入澄清记录
	 * @param stdGoods
	 * @return
	 */
	public int saveGoodsClearByMap(List<ContrastObj> coList, StdGoods stdGoods) {
		List<StdGoodsClear> sgcList = new ArrayList<StdGoodsClear>();
		//资质状态
		int qualificationStatus = stdGoods.getQualificationStatus();
		//插入澄清记录信息
		for(int i =0;i<coList.size();i++) {//循环解析更改数据
			StdGoodsClear sgc = new StdGoodsClear();//企业澄清表
			ContrastObj co = coList.get(i);//得到对象
			if(qualificationStatus == 1) {//资质状态合格
				sgc.setSort(1);//质疑
			}else {
				sgc.setSort(2);//澄清
			}
			sgc.setGoodsId(stdGoods.getGoodsId());//产品编号
			sgc.setClearContent(co.getName());//澄清内容
			sgc.setVbeforeProcess(co.getOldValue());//申请处理前值
			sgc.setVafterProcess(co.getNewValue());//申请处理后值
			sgc.setIsOnlineClear(0);//是否网上澄清0否1是
			sgc.setClearStatus(3);//澄清状态1保存2提交3审核通过4审核未通过
			sgcList.add(sgc);//添加修改内容
		}
		stdGoodsClearManager.insertBatch(sgcList);//批量插入商品澄清表
		//保存产品修改信息
		return ((StdGoodsDao) getDao()).update(stdGoods);
	}

	@Override
	public Pagination getListForJG(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdGoods> models = (Page<StdGoods>) dao.queryAllForJG(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}
	
	@Override
	public Map<String, Object> getByGoodsId(Integer goodsId) {
		return dao.getByGoodsId(goodsId);
	}

	@Override
	public Pagination queryExist(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<StdGoods> models = dao.queryExist(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		printLog("查询",pagination,"分页查询");
		return pagination;
	}

	

	@Override
	public Integer returnLastId() {
		// TODO Auto-generated method stub
		return dao.returnLastId();
	}

	@Override
	public <StdGoodsResult> StdGoods getScreen(StdGoodsResult stdGoodsResult) {
		// TODO Auto-generated method stub
		return dao.getScreen(stdGoodsResult);
	}

	@Override
	public String UpdateGoogsCompanyById(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.ModifyGoodsCompany(map);
	}

	@Override
	public Pagination getGoodsForCompApply(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdGoods> model = dao.getGoodsForCompApply(page.getConditions());
		page.setRows(model);
		page.setRecords(model.getTotal());
		return page;	}

	@Override
	public Pagination getGoodsCf(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdGoods> model = dao.getGoodsCf(page.getConditions());
		page.setRows(model);
		page.setRecords(model.getTotal());
		return page;
	}

	@Override
	public int updateYp(StdGoods model) {
		return dao.updateYp(model);
	}

	@Override
	public StdGoods getDataById(Integer goodsId) {
		return dao.getDataById(goodsId);
	}

	@Override
	public void updateCompTb(Map<String, Object> map) {
		dao.updateCompTb(map);
	}

	@Override
	public Pagination getAllStdGoodsData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdGoods> model = dao.getAllStdGoodsData(page.getConditions());
		page.setRows(model);
		page.setRecords(model.getTotal());
		return page;
	}

	@Override
	public void BacthIsUsingUpdate(List<Map<String, Object>> insertMap,String isUsing) {
		dao.BacthIsUsingUpdate(insertMap,isUsing);
	}

	@Override
	public void updateCompSc(Map<String, Object> map) {
		dao.updateCompSc(map);
	}

	@Override
	public void updateCompTbAndSc(Map<String, Object> map) {
		dao.updateCompTbAndSc(map);
	}

}
