package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdHospital;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

public interface StdHospitalManager extends GenericManager<StdHospital,String>{
	
	/**
	 * 更新医疗机构同时插入医疗机构管理账号
	 * @param stdHospital
	 * @param hispSysUser
	 * @return
	 */
	int updateByIdAndAddSysUser(StdHospital stdHospital,SysUser hispSysUser);
	
	/**
	 * 根据用户名查询医疗机构
	 * @param map
	 * @return
	 */
	List<StdHospital> queryAllHospitalbyHospitalName(Map<String, Object> map);
	/**
	 * @desc   修改医院
	 * @param StdHospital
	 * @return
	 */
	public int updateHospital(StdHospital stdHospital);
	
	int updateHosp(StdHospital hosp);
	/**
	 * 审核医疗机构支付信息列表
	 */
	Pagination getAuditList(Pagination page);
	
	int auditPass(StdHospital hosp);
	int auditNoPass(StdHospital hosp);

	int payInfoSecondAudit(StdHospital hosp);

	void updateIsUsing(StdHospital hosp);
	
	
	Pagination getYySelectList(Pagination page);
	
	Pagination getYySendSelectList(Pagination page);

	StdHospital getHospInfoByHospId(String id);
	
	void updateHospId(String id, String zhuSequence);
	
	Pagination getCombinaHosp(Pagination page);
	
	Pagination getAllList(Pagination page);
	
	int OrderStart(String stdHospital);
	
	int OrderDisable(String stdHospital);
	int OrderALL(String stdHospital);
	int DisableALL(String stdHospital);
	
	void updateUserName(String hospId, String userName);
	
	void updateHos(String orderControl);


	/****************************************************************************/

	Pagination getHosPrice(Pagination pagination);

	Pagination getCwByArea(Pagination pagination);

	/****************************************************************************/
	
	/*疫苗新增疾控中心*/
	
	int getHospitalName(String _parameter);
	
	boolean addJKZX(StdHospital StdHospital);

	StdHospital getByUserName(String s);

	List<StdHospital> getHospitalInfo();

    /*疫苗新增疾控中心*/
}
