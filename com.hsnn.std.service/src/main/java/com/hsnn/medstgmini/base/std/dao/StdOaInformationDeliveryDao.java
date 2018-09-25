package com.hsnn.medstgmini.base.std.dao;

import java.util.Map;

import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.base.std.model.StdOaInformationDelivery;

public interface StdOaInformationDeliveryDao extends GenericDao<StdOaInformationDelivery, String> {

	/**
	 * 根据编号修改状态
	 * @param map
	 * @return
	 */
	int updateStatusById(Map<String, Object> map);
}