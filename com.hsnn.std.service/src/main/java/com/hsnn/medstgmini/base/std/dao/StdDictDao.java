package com.hsnn.medstgmini.base.std.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.form.StdDictForm;
import com.hsnn.medstgmini.base.std.model.StdDict;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.SelectForm;

public interface StdDictDao extends GenericDao<StdDict, java.lang.Integer> {
	/**
	 * 
	 *@category 获取字典类型
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<StdDict> getType();

	List<StdDict> getAptitudeByFaterId(String fatherId);

	List<StdDict> getDicExperttypeList(Map<String, Object> map);
	/**
	 * 
	 *@category 获取字典大类
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<StdDict> getClassify();
	
	/**
	 * 
	 *@category 验证重复
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public int checkRepeat(StdDict stdDict);

	public List<StdDictForm> checkRepeats(@Param("fatherId")String fatherId,  @Param("dictionaryValue")String dictionaryValue,@Param("Id")String Id);

	public void saveValue(@Param("dictionaryValue")String dictionaryValue, @Param("type")String type , @Param("fatherId")Integer fatherId, @Param("addUserId")String addUserId, @Param("addUserName")String addUserName);
	public void saveDict(@Param("dictionaryValue")String dictionaryValue, @Param("type")String type , @Param("fatherId")Integer fatherId, @Param("addUserId")String addUserId, @Param("addUserName")String addUserName);

	public List<StdDict> getDicExperttypeBy( String value);

	public List<StdDict> getList(@Param("fatherId")String fatherId, @Param("dictionaryValue")String dictionaryValue);

	public List<StdDictForm> checkRepeatUpdate(StdDictForm stdDictForm);

	public int checkRepeatStdCataProdRelLinProdName(StdDict stdDictProdName);

	List<StdDict> queryListId(Integer ID);

	public List<StdDict> getdicttonary(Map<String,Object> map);

	public int checkRepeatStdCataProdRelLinProdMed(StdDict stdDictProdMed);

	public int checkRepeatStdCataProdRelLinProdOutlook(StdDict stdDictProdoutlook);

	public List<SelectForm> getDiSys(String type);

	public Object getDicSysByDictionaryKey(String dictionaryKey);
/*
	public void addStdDictProdName(@Param("str2")String str2, @Param("typename")String typename,  @Param("classify")String classify,  @Param("classifyName")String classifyName);
*/

	public void addStdDictProdName(StdDict stdDict);

	public List<StdDict> getylflDate(Map<String, Object> map);

	public List<StdDict> getyydjDate(Map<String, Object> map);

	public Page<StdDict> getStgList(Map<String, Object> conditions);
	
	public Page<StdDict> getDictListByProduct(Map<String, Object> conditions);
	

	int returnLastId();

	int batchUpdate(List<StdDict> stdDictList);


	public List<StdDict> getDictList();
	String stdDictUpdateName(Map<String, String> map);

	String getDictionaryKey();
}