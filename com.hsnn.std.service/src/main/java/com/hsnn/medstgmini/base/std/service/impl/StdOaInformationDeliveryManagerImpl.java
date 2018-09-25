package com.hsnn.medstgmini.base.std.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdOaInformationDeliveryDao;
import com.hsnn.medstgmini.base.std.model.StdOaInformationDelivery;
import com.hsnn.medstgmini.base.std.service.StdOaInformationDeliveryManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.SessionUtil;

@Service
public class StdOaInformationDeliveryManagerImpl extends GenericManagerImpl<StdOaInformationDelivery, String> implements StdOaInformationDeliveryManager {
	// 扩展接口实现
	@Autowired
	private StdOaInformationDeliveryDao stdOaInformationDeliveryDao;
	
	/**
	 * 根据编号修改状态
	 * @param map
	 * @return
	 */
	public int updateStatusById(Map<String, Object> map) {
		SysUser sysUser = SessionUtil.getSysUser();
		map.put("userId", sysUser.getUserId());//用户id
		map.put("userName", new StringBuffer(sysUser.getName()).append("(").append(sysUser.getUserName()).append(")").toString());//用户id
		return stdOaInformationDeliveryDao.updateStatusById(map);
	}
}