package com.hsnn.medstgmini.base.std.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.model.StdDict;
import com.hsnn.medstgmini.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdDrugcatalogDao;
import com.hsnn.medstgmini.base.std.model.StdDrugcatalog;
import com.hsnn.medstgmini.base.std.service.StdDrugcatalogManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

/**
 * 
 *@category 药品目录管理接口实现类
 *@author 言科
 *@date 2016年6月7日11:23:41
 */
@Service("StdDrugcatalogManager")
public class StdDrugcatalogManagerImpl  extends GenericManagerImpl<StdDrugcatalog, String> implements StdDrugcatalogManager {
	
	@Autowired
	private StdDrugcatalogDao stdDrugcatalogDao;
	
	@Override
	public boolean checkRepeatStdDrugcatalog(StdDrugcatalog sd) {
		return stdDrugcatalogDao.checkRepeat(sd)==0;
	}
	
	@Override
	public boolean addStdDrugcatalog(StdDrugcatalog sd) {
		 return stdDrugcatalogDao.save(sd)==1;
	}
	
	@Override
	public boolean saveStdDrugcatalog(StdDrugcatalog form) {
		 boolean tag;
		 tag = stdDrugcatalogDao.update(form)==1;
		 return tag;
	}

	@Override
	public Pagination getContentsList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdDrugcatalog> stdDrugcatalog =stdDrugcatalogDao.getContentsList(page.getConditions());
		page.setRows(stdDrugcatalog);
		page.setRecords(stdDrugcatalog.getTotal());
		return  page;
	}


}

