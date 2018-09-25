package com.hsnn.medstgmini.base.std.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdCataProdRelDao;
import com.hsnn.medstgmini.base.std.model.StdCataProdRel;
import com.hsnn.medstgmini.base.std.service.StdCataProdRelManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

/**
 * 
 *@category 药品目录管理接口实现类
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
@Service("StdCataProdRelManager")
public class StdCataProdRelManagerImpl  extends GenericManagerImpl<StdCataProdRel, String> implements StdCataProdRelManager {
	
	@Autowired
	private StdCataProdRelDao stdCataProdRelDao;

	/*	
	@Override
	public boolean checkRepeat(StdCataProdRel sd) {
		return stdCataProdRelDao.checkRepeat(sd)==0;
	}
	 */
	/**
	 * 查询药品的剂型
	 * @param page
	 * @return
	 */
	@Override
	public Pagination queryDrug(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCataProdRel> models = stdCataProdRelDao.queryDrug(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}
	@Override
	public boolean addStdCataProdRel(StdCataProdRel sd) {
		 return stdCataProdRelDao.save(sd)==1;
	}
	
	@Override
	public boolean saveStdCataProdRel(StdCataProdRel form) {
		 boolean tag;
		 tag = stdCataProdRelDao.update(form)==1;
		 return tag;
	}
	
	@Override
	public boolean batchUpdate(String[] ids, StdCataProdRel stdCataProdRel) {
		return stdCataProdRelDao.batchUpdate(ids, stdCataProdRel)>0;
	}

	@Override
	public boolean checkRepeatStdCataProdRelLin(StdCataProdRel stdCheck) {
		return stdCataProdRelDao.checkRepeatStdCataProdRelLin( stdCheck)==0;
	}

	@Override
	public boolean addStdCataProdRelImport(StdCataProdRel stdCataProdRel) {
		return stdCataProdRelDao.addStdCataProdRelImport(stdCataProdRel)==1;
	}
   
	/**
	 * excel数据入库
	 */
	public int saveExcelDate(Map<String, Object> map){
		return stdCataProdRelDao.saveExcelDate(map);
	}

    @Override
	public List<StdCataProdRel> getByProdId(Map<String,String> val) {
		// TODO Auto-generated method stub
		return stdCataProdRelDao.getByProdId(val);
	}

	@Override
	public List<StdCataProdRel> getCodeId(String drugcatalogCode) {
		// TODO Auto-generated method stub
		return stdCataProdRelDao.getCodeId(drugcatalogCode);
	}

	@Override
	public void batchSave(String drugcatalogCode, String drugcatalogCodes) {
		stdCataProdRelDao.batchSave(drugcatalogCode,drugcatalogCodes);
	}

	@Override
	public Map<String, Object> getCatalogDetails(Map<String, Object> map) {
		return  stdCataProdRelDao.getCatalogDetails(map);
	}

	@Override
	public int updateGoodsApp(String id) {
		stdCataProdRelDao.updateGoodsApp(id);
		stdCataProdRelDao.updateStdCataProdRel(id);
		stdCataProdRelDao.saveLog(id);
		stdCataProdRelDao.deletePackageSplit(id);
		return 0;
	}

	@Override
	public Pagination getGoodsList(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCataProdRel> models = stdCataProdRelDao.getGoodsList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

}

