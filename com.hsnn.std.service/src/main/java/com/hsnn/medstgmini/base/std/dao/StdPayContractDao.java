package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdPayContract;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdPayContractDao extends GenericDao<StdPayContract, String> {
	public StdPayContract getInfoById(Map<String,Object> map);
	public void updateIsSignYht(Map<String,Object> map);
	
	/**
	 * 获取所有的支付医疗机构信息
	 * @date 2016年7月27日 16:48:49
	 * lil
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getPayHospList(Map<String, Object> map);
	
	/**
	 * 根据机构编号修改支付方式等信息
	 * @param map
	 * @return
	 */
	int updateHospPayModeByOrgId(Map<String, Object> map);
}