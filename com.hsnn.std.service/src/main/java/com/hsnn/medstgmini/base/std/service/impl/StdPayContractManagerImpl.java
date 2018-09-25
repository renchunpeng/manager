package com.hsnn.medstgmini.base.std.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdPayContractDao;
import com.hsnn.medstgmini.base.std.model.StdPayContract;
import com.hsnn.medstgmini.base.std.service.StdPayContractManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;

@Service
public class StdPayContractManagerImpl extends GenericManagerImpl<StdPayContract, String> implements StdPayContractManager {
	// 扩展接口实现
	@Autowired
	private StdPayContractDao stdPayContractDao;
	@Override
	public StdPayContract getInfoById(Map<String,Object> map){
		return stdPayContractDao.getInfoById(map);
	}
	
	@Override
	public void updateIsSignYht(Map<String,Object> map){
		stdPayContractDao.updateIsSignYht(map);
	}
	
	/**
	 * 获取所有的支付医疗机构信息
	 * @date 2016年7月27日 16:48:49
	 * lil
	 * @param page
	 * @return
	 */
	public Pagination getPayHospList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(),page.getOrderby());
		List<Map<String, Object>> pagelist = stdPayContractDao.getPayHospList(page.getConditions());
		Page<Map<String, Object>> pages = (Page<Map<String, Object>>) pagelist;
		page.setRows(pages);
		page.setRecords(pages.getTotal());
		return page;
	}
	
	/**
	 * 根据机构编号修改支付方式等信息
	 * @param map
	 * @return
	 */
	public int updateHospPayModeByOrgId(Map<String, Object> map) {
		SysUser sysUser = SessionUtil.getSysUser();//获取当前登陆人信息
		String userId = sysUser.getUserId();//用户id
		String userName = sysUser.getUserName();//用户名称
		map.put("userId", userId);
		map.put("userName", userName);
		return stdPayContractDao.updateHospPayModeByOrgId(map);
	}
}