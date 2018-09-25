package com.hsnn.medstgmini.base.std.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdHospital;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdHospitalDao extends GenericDao<StdHospital, java.lang.String> {
	
	/**
	 * 根据机构查询医院
	 * @param orgId
	 * @return
	 */
	StdHospital getHospInfoById(String orgId);
	/**
	 * 验证医院是否存在
	 * @param map
	 * @return
	 */
	List<StdHospital> queryAllHospitalbyHospitalName(Map<String, Object> map);
	int updateHospital(StdHospital stdHospital);
	int updateHosp(StdHospital stdHospital);
	
	Page<StdHospital> getHospPaymentList(Map<String, Object> map);
	int auditPass(StdHospital hosp);
	int auditNoPass(StdHospital hosp);
	int payInfoSecondAudit(StdHospital hosp);
	
	int updateIsUsing(StdHospital stdHospital);
	
	Page<StdHospital> getYySelectList(Map<String, Object> map);
	
	Page<StdHospital> getYySendSelectList(Map<String, Object> map);
	
	StdHospital getHospInfoByHospId(String id);
	
	void updateHospId(@Param("id")String id, @Param("zhuSequence")String zhuSequence);
	
	List<StdHospital> getCombinaHosp(Map<String, Object> map);
	
	Page<StdHospital> getAllList(Map<String, Object> conditions);
	
	int OrderStart(String stdHospital);
	
	int OrderDisable(String stdHospital);
	int OrderALL(String stdHospital);
	int DisableALL(String stdHospital);
	
	void updateUserName(@Param("hospId")String hospId, @Param("userName")String userName);
	void updateHos(String orderControl);
	
	List<StdHospital> getBaseHosp(Map<String,Object> map);
	/****************************************************************************/

	List<StdHospital> getHosPrice(Map<String, Object> map);

	List<StdHospital> getCwByArea(Map<String, Object> map);

	/****************************************************************************/
	
	/*疫苗新增疾控中心*/
	int getHospitalName(String _parameter);
	
	int addJKZX(StdHospital stdHospital);

	StdHospital getByUserName(String s);

	List<StdHospital> getHospitalInfo();
    /*疫苗新增疾控中心*/
}