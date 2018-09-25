/**
 * 下午1:01:03
 */
package com.hsnn.medstgmini.base.std.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdProductDao;
import com.hsnn.medstgmini.base.std.model.StdProduct;
import com.hsnn.medstgmini.base.std.service.StdProductManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.BeanCopierUtils;
import com.hsnn.medstgmini.util.ConstantsUtil;
import com.hsnn.medstgmini.util.Pagination;

/**
 * @author hsnn
 *
 */
@Service("StdProductManager")
public class StdProductManagerImpl  extends GenericManagerImpl<StdProduct, Integer> implements StdProductManager{

	@Autowired
	private StdProductDao stdProductDao;
	
	@Override
	public Pagination getInfoList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdProduct> dicAreas = (Page<StdProduct>) stdProductDao.queryAll(page.getConditions());
		page.setRows(dicAreas);
		page.setRecords(dicAreas.getTotal());
		return page;
	
	}

	@Override
	public boolean addData(StdProduct form) {
		 return stdProductDao.save(form)==1;
	}

	@Override
	public boolean saveData(StdProduct form) {
		 boolean tag;
		 tag = stdProductDao.update(form)==1;
		 return tag;
	}

	@Override
	public StdProduct getStdProductById(Integer id) {
		return stdProductDao.get(id);
	}

	@Override
	public boolean batchUpdate(String[] ids, StdProduct spf) {
		return stdProductDao.batchUpdate(ids, spf)>0;
	}

	@Override
	public boolean checkRepeat(StdProduct form) {
		return stdProductDao.checkRepeat(form)==0;
	}

	@Override
	public boolean batchUpdate(Pagination page, StdProduct form) {
		String[] ids = (String[]) page.getConditions().get("productIds");
		String[] remarks = (String[]) page.getConditions().get("remarks");
		for(int i=0;i<ids.length && i<remarks.length ;i++){
			 StdProduct formTemp = new StdProduct();
			 BeanCopierUtils.copyProperties(form, formTemp);
			 formTemp.setProductId(Integer.parseInt(ids[i]));
			 formTemp.setAuditRemark(remarks[i]);
			 if(stdProductDao.update(formTemp)!=1){
				 return false;
			 }
		}
		return true;
	}

	@Override
	public int returnLastId() {
		return stdProductDao.returnLastId();
	}

	
	@Override
	public boolean checkRepeatStdCataProdRelLinProd(StdProduct stdCheckProd) {
		return stdProductDao.checkRepeatStdCataProdRelLinProd(stdCheckProd)==0;
	}
	
	@Override
	public StdProduct getByName(StdProduct stdCheckProd) {
		return stdProductDao.getByNameo(stdCheckProd);
	}

	@Override
	public List<Map<String,Object>> getExportExcelData(Map<String,Object> map){
		List<Map<String,Object>> list = stdProductDao.getExportExcelData(map);
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map1 = list.get(i);
				map1.put("是否启用",map1.get("是否启用") == null ? "" : ConstantsUtil.isUsing(map1.get("是否启用").toString()));	
				map1.put("审核状态",map1.get("审核状态") == null ? "" : ConstantsUtil.auditStatus(map1.get("审核状态").toString()));	
			}
		}
		 return list;
	}

	@Override
	public void addStdProductProdName(StdProduct stdProduct) {
		stdProductDao.addStdProductProdName(stdProduct);
	}
	
	
	/**
	 * 根据提供的产品编号和字段修改具体的值
	 * @param stdGoods
	 */
	public int updateColumnById(Map<String, Object> map) {
		
		return stdProductDao.updateColumnById(map);
	}

	@Override
	public Map<String, Object> findGoodsId(String productId) {
		return stdProductDao.findGoodsId(productId);
	}
	
	@Override
	public List<StdProduct> getStdProductIds(String[] ids) {
		return stdProductDao.getStdProductIds(ids);
	}

	@Override
	public void save(StdProduct stdProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStdProduct(StdProduct stdProduct) {
		stdProductDao.saveStdProduct(stdProduct);
	}

	@Override
	public void saveStdPro(StdProduct stdProduct) {
		stdProductDao.saveStdPro(stdProduct);
	}

	public List<StdProduct> getListByName(String name) {
		return stdProductDao.getListByName(name);
	}


	@Override
	public Pagination getDataList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdProduct> dicAreas = (Page<StdProduct>) stdProductDao.getDataList(page.getConditions());
		page.setRows(dicAreas);
		page.setRecords(dicAreas.getTotal());
		return page;
	}
}
