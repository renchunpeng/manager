package com.hsnn.medstgmini.base.std.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdDictDao;
import com.hsnn.medstgmini.base.std.form.StdDictForm;
import com.hsnn.medstgmini.base.std.model.StdDict;
import com.hsnn.medstgmini.base.std.service.StdDictManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SelectForm;

@Service
public class StdDictManagerImpl extends GenericManagerImpl<StdDict, Integer> implements StdDictManager {
	
	@Autowired
	private StdDictDao stdDictDao;
	// 扩展接口实现
	 
	
	/**
	 * 专家类型查看
	 * @author 罗超
	 * @date 2016年5月17日
	 */
	@Override
	public Pagination getDicExperttypeList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdDict> stdDict = (Page<StdDict>) stdDictDao.getDicExperttypeList(page.getConditions());
		page.setRows(stdDict);
		page.setRecords(stdDict.getTotal());
		return page;
	}
	/**
	 * 
	 *@category 获取字典类型
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public List<StdDict> getType(){
		return stdDictDao.getType();
	}
	
	/**
	 * 
	 *@category 获取字典大类
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public List<StdDict> getClassify(){
		return stdDictDao.getClassify();
	}
	
	/**
	 * 
	 *@category 验证重复
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public int checkRepeat(StdDict stdDict){
		return stdDictDao.checkRepeat(stdDict);
	}
	@Override
	public List<StdDictForm> checkRepeats(String fatherId,String dictionaryValue,String Id) {
		return stdDictDao.checkRepeats(fatherId,dictionaryValue,Id);
	}
	@Override
	public void addDicExperttype(Pagination page) {
		// TODO Auto-generated method stub
		String dictionaryValue = (String) page.getConditions().get("dictionaryValue");
		String type = (String) page.getConditions().get("type");
		String addUserName = (String) page.getConditions().get("addUserName");
		String addUserId = (String) page.getConditions().get("addUserId");
		String Id =  (String) page.getConditions().get("fatherId");
		Integer fatherId =java.lang.Integer.valueOf(Id);
		stdDictDao.saveDict(dictionaryValue,type,fatherId,addUserId,addUserName);
		
	}
	@Override
	public List<StdDict> getDicExperttypeBy( String value) {
		// TODO Auto-generated method stub
		return stdDictDao.getDicExperttypeBy( value);
	}
	@Override
	public List<StdDict> getList(String fatherId, String value) {
		// TODO Auto-generated method stub
		return stdDictDao.getList(fatherId, value);
	}
	@Override
	public void addDicExperttypeTWO(Pagination page) {
		// TODO Auto-generated method stub
		String dictionaryValue = (String) page.getConditions().get("dictionaryValue");
		String type = (String) page.getConditions().get("type");
		String addUserName = (String) page.getConditions().get("addUserName");
		String addUserId = (String) page.getConditions().get("addUserId");
		Integer fatherId =  (Integer) page.getConditions().get("fatherId");
		stdDictDao.saveDict(dictionaryValue,type,fatherId,addUserId,addUserName);
	}
	@Override
	public void addDicExperttypeTHREE(Pagination page) {
		// TODO Auto-generated method stub
		String dictionaryValue = (String) page.getConditions().get("dictionaryValue");
		String type = (String) page.getConditions().get("type");
		String addUserName = (String) page.getConditions().get("addUserName");
		String addUserId = (String) page.getConditions().get("addUserId");
		Integer fatherId =  (Integer) page.getConditions().get("fatherId");
		stdDictDao.saveDict(dictionaryValue,type,fatherId,addUserId,addUserName);
		
	}
	@Override
	public List<StdDictForm> checkRepeatUpdate(StdDictForm stdDictForm) {
		// TODO Auto-generated method stub
		return stdDictDao.checkRepeatUpdate(stdDictForm);
	}
	
	
	@Override
	public boolean checkRepeatStdCataProdRelLinProdName(StdDict stdDictProdName) {
		return stdDictDao.checkRepeatStdCataProdRelLinProdName(stdDictProdName)==0;
	}
	@Override
	public boolean checkRepeatStdCataProdRelLinProdMed(StdDict stdDictProdMed) {
		return stdDictDao.checkRepeatStdCataProdRelLinProdMed(stdDictProdMed)==0;
	}
	@Override
	public boolean checkRepeatStdCataProdRelLinProdOutlook(StdDict stdDictProdoutlook) {
		return stdDictDao.checkRepeatStdCataProdRelLinProdOutlook(stdDictProdoutlook)==0;
	}
	@Override
	public List<SelectForm> getDiSys(String type) {
		// TODO Auto-generated method stub
		return stdDictDao.getDiSys(type);
	}
	@Override
	public Object getDicSysByDictionaryKey(String dictionaryKey) {
		// TODO Auto-generated method stub
		return stdDictDao.getDicSysByDictionaryKey(dictionaryKey);
	}
	@Override
	public void addStdDictProdName(StdDict stdDict) {
		stdDictDao.addStdDictProdName(stdDict);
		
	}
	@Override
	public List<StdDict> getylflDate(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return stdDictDao.getylflDate(map);
	}
	@Override
	public List<StdDict> getyydjDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return  stdDictDao.getyydjDate(map);
	}
	@Override
	public Pagination getStgList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdDict> stdDict = (Page<StdDict>) stdDictDao.getStgList(page.getConditions());
		page.setRows(stdDict);
		page.setRecords(stdDict.getTotal());
		return page;
	}
	
	@Override
	public Pagination getDictListByProduct(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdDict> stdDict = (Page<StdDict>) stdDictDao.getDictListByProduct(page.getConditions());
		page.setRows(stdDict);
		page.setRecords(stdDict.getTotal());
		return page;
	}
	@Override
	public int returnLastId() {
		return stdDictDao.returnLastId();
	}
	
/*	@Override
	public void addStdDictProdName(String str2, String typename,String classify, String classifyName) {
		stdDictDao.addStdDictProdName(str2,typename,classify,classifyName);
	}
    */
    
	@Override
	public int batchUpdate(List<StdDict> stdDictList) {
		return stdDictDao.batchUpdate(stdDictList);
	}
	@Override
	public List<StdDict> getDictList() {
		return stdDictDao.getDictList();
	}

	@Override
	public String stdDictUpdateName(Map<String, String> map) {
		stdDictDao.stdDictUpdateName(map);
		return null;
	}

	@Override
	public String getDictionaryKey() {
		return stdDictDao.getDictionaryKey();
	}
}