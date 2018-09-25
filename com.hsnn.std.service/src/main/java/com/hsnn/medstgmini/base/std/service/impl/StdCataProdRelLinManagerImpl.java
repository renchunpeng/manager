package com.hsnn.medstgmini.base.std.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdCataProdRelLinDao;
import com.hsnn.medstgmini.base.std.model.StdCataProdRelLin;
import com.hsnn.medstgmini.base.std.service.StdCataProdRelLinManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 *@category 药品目录管理接口实现类
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
@Service("StdCataProdRelLinManager")
public class StdCataProdRelLinManagerImpl  extends GenericManagerImpl<StdCataProdRelLin, String> implements StdCataProdRelLinManager {
	@Autowired
	private StdCataProdRelLinDao stdCataProdRelLinDao;
	
	@Override
	public Pagination getOKList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCataProdRelLin> models = (Page<StdCataProdRelLin>) stdCataProdRelLinDao.getOKList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}
	
	@Override
	public Pagination getNGList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCataProdRelLin> models = (Page<StdCataProdRelLin>) stdCataProdRelLinDao.getNGList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	public Pagination getStdCataProdRelLinNoPage(Pagination page){
		List<StdCataProdRelLin> list = stdCataProdRelLinDao.queryStdCataProdRelLinNoPage(page);
	
		return page;
	}
	
	
	@Override
	public List<Map<String,Object>> getExportExcelData(Map<String,Object> map){
		return stdCataProdRelLinDao.getExportExcelData(map);
	}

	@Override
	public void addStdCataProdRelLin(StdCataProdRelLin stdCataProdRelLin) {
		stdCataProdRelLinDao.addStdCataProdRelLin(stdCataProdRelLin);
		
	}

	@Override
	public void addStdCataProdRelLinS(StdCataProdRelLin stdCataProdRelLin) {
		stdCataProdRelLinDao.addStdCataProdRelLinS(stdCataProdRelLin);
		
	}

	@Override
	public int deleteStdCataProdRelLin(String drugcatalogCode,String stdCataProdRelFileId) {
		return stdCataProdRelLinDao.deleteStdCataProdRelLin(drugcatalogCode,stdCataProdRelFileId);
	}

	@Override
	public List<StdCataProdRelLin> getStdCataProdRelLinById(Map<String, Object> map) {
		return stdCataProdRelLinDao.getStdCataProdRelLinById(map);
	}




	

	
   
}

