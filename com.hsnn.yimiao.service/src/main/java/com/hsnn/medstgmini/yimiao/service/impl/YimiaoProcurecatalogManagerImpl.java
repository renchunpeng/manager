package com.hsnn.medstgmini.yimiao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.ConstantsUtil;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.dao.YimiaoProcurecatalogDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoProcurecatalog;
import com.hsnn.medstgmini.yimiao.service.YimiaoProcurecatalogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class YimiaoProcurecatalogManagerImpl extends GenericManagerImpl<YimiaoProcurecatalog, Integer> implements YimiaoProcurecatalogManager {
	@Autowired
	YimiaoProcurecatalogDao yimiaoProcurecatalogDao;
	@Override
	public Pagination queryByNot(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoProcurecatalog> models = (Page<YimiaoProcurecatalog>) yimiaoProcurecatalogDao.queryByNot(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}
	// 扩展接口实现
	@Override
	public Pagination getAllList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoProcurecatalog> models = yimiaoProcurecatalogDao.getAllList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public int updateStart(Integer procurecatalogId) {
		return yimiaoProcurecatalogDao.updateStart(procurecatalogId);
	}

	@Override
	public int updateDisable(Integer procurecatalogId) {
		return yimiaoProcurecatalogDao.updateDisable(procurecatalogId);
	}
	
	@Override
	public Pagination queryByNotret(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoProcurecatalog> models = (Page<YimiaoProcurecatalog>) yimiaoProcurecatalogDao.queryByNotret(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}
	
	/**
	 * 导出
	 */
	@Override
	public List<Map<String, Object>> getExportExcelData(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = yimiaoProcurecatalogDao.getExportExcelData(map);		
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("状态",map1.get("状态") ==  null ? "" : ConstantsUtil.isUsing(map1.get("状态").toString()));	
			}
		}
		return list;
	}

	public List<YimiaoProcurecatalog> getProjName() {
		return this.yimiaoProcurecatalogDao.getProjName();
	}
    
	@Override
	public YimiaoProcurecatalog getbygood(String id) {
		printLog("查询",id,"根据ID");
		
		YimiaoProcurecatalog model = yimiaoProcurecatalogDao.getbygood(id);
		return model;
	}

	@Override
	public Pagination getGoodsList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoProcurecatalog> models = (Page<YimiaoProcurecatalog>) yimiaoProcurecatalogDao.getGoodsList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public Pagination getYimiaoProductName(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<YimiaoProcurecatalog> models = (Page<YimiaoProcurecatalog>) yimiaoProcurecatalogDao.getYimiaoProductName(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		return page;
	}

	@Override
	public int updateCompanyNamePsByProcurecatalogId(String companyNamePs,Integer procurecatalogId) {
		YimiaoProcurecatalog yimiaoProcurecatalog = new YimiaoProcurecatalog();
		yimiaoProcurecatalog.setProcurecatalogId(procurecatalogId);
		yimiaoProcurecatalog.setCompanyNamePs(companyNamePs);
		yimiaoProcurecatalogDao.updateCompanyNamePsByYimiaoCatalog(yimiaoProcurecatalog);
		yimiaoProcurecatalogDao.updateCompanyNamePsByYimiaoOrderdetail(yimiaoProcurecatalog);
		return yimiaoProcurecatalogDao.updateCompanyNamePsByProcurecatalogId(yimiaoProcurecatalog);
	}

	@Override
	public Pagination queryCatalog(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount(), pagination.getOrderby());
		Page<YimiaoProcurecatalog> models = (Page<YimiaoProcurecatalog>) yimiaoProcurecatalogDao.queryCatalog(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		return pagination;
	}

	@Override
	public List<Map<String, Object>> getExportExcelRelationData(Map<String, Object> map) {
		List<Map<String,Object>> list = yimiaoProcurecatalogDao.getExportExcelRelationData(map);
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("疫苗状态",map1.get("疫苗状态") ==  null ? "" : ConstantsUtil.isUsing(map1.get("疫苗状态").toString()));
			}
		}
		return list;
	}

	@Override
	public Map<String, String> getSwtichState() {
		return yimiaoProcurecatalogDao.getSwtichState();
	}

    @Override
    @Transactional
    public int changeSwitch(String state) {
        return yimiaoProcurecatalogDao.changeSwitch(state);
    }


}