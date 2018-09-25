package com.hsnn.medstgmini.yimiao.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdCompany;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompany;

public interface YimiaoCompanyManager extends GenericManager<YimiaoCompany, String> {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	Pagination getYimiaoCompList(Pagination page);
	
	/**
	 * 根据id查询企业
	 * @param companyId
	 * @return
	 */
	YimiaoCompany getYimiaoCompanyById(String companyId);
	
	/**
	 * 根据当前登录的用户名查询对应得企业id
	 * @param uname
	 * @return
	 */
	String getCompIdByUName(String uname);
	/**
	 * 企业列表
	 * @param page
	 * @return
	 */
	Pagination getAllList(Pagination page);
	/**
	 * 状态启用
	 * @param companyId
	 * @return
	 */
	int updateStart(String companyId);
	int updateStartsc(String companyId);
	/**
	 * 状态停用
	 * @param companyId
	 * @return
	 */
	int updateDisable(String companyId);
	int updateDisablesc(String companyId);
	
	List<Map<String, Object>> getExportExcelData(Map<String, Object> map);
	
	int getCompanyName(String companyName);
	
	boolean addCompanyQy(YimiaoCompany yimiaoCompany);
	
	void updateAccountCode(String companyId,String accountCode);


    boolean addYimiaoCompanyPs(String yimiaoCompanyPs);
}
