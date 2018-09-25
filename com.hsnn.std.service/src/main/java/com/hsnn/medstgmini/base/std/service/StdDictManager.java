package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.form.StdDictForm;
import com.hsnn.medstgmini.base.std.model.StdDict;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SelectForm;

public interface StdDictManager extends GenericManager<StdDict, Integer> {
	// 扩展接口
	
	/**
	 * 
	 *@category 获取字典类型
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<StdDict> getType();
	
	/**
	 * 专家类型查看
	 * @author 罗超
	 * @date 2016年5月17日
	 */
	Pagination getDicExperttypeList(Pagination page);

	List<StdDict> getClassify();

	int checkRepeat(StdDict stdDict);

	public List<StdDictForm> checkRepeats(String fatherId,  String dictionaryValue,String Id);

	public void addDicExperttype(Pagination page);

	public List<StdDict> getDicExperttypeBy(String value);

	public List<StdDict> getList(String fatherId, String dictionaryValue);

	public void addDicExperttypeTWO(Pagination page);
	public void addDicExperttypeTHREE(Pagination page);

	public List<StdDictForm> checkRepeatUpdate(StdDictForm stdDictForm);

	/**
	 * 药品目录导入时检查通用名是否重复
	 * @param 
	 * @return
	 */
	public boolean checkRepeatStdCataProdRelLinProdName(StdDict stdDictProdName);
	
	/**
	 * 药品目录导入时检查剂型是否重复
	 * @param 
	 * @return
	 */
	public boolean checkRepeatStdCataProdRelLinProdMed(StdDict stdDictProdMed);
	
	/**
	 * 药品目录导入时检查规格是否重复
	 * @param 
	 * @return
	 */
	public boolean checkRepeatStdCataProdRelLinProdOutlook(StdDict stdDictProdoutlook);

	public List<SelectForm> getDiSys(String type);

	public Object getDicSysByDictionaryKey(String dictionaryKey);

	public void addStdDictProdName(StdDict stdDict);

	public List<StdDict> getylflDate(Map<String, Object> map);

	public List<StdDict> getyydjDate(Map<String, Object> map);

	public Pagination getStgList(Pagination pagination);
	
	public Pagination getDictListByProduct(Pagination page);

/*	public void addStdDictProdName(String str2, String typename, String classify, String classifyName);*/

	int returnLastId();
	
	int batchUpdate(List<StdDict> stdDictList);

	public List<StdDict> getDictList();
	String stdDictUpdateName(Map<String, String> map);

	String getDictionaryKey();
}