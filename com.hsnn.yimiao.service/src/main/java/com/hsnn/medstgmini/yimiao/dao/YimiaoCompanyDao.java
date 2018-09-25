package com.hsnn.medstgmini.yimiao.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdCompany;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompany;

public interface YimiaoCompanyDao extends GenericDao<YimiaoCompany, String> {
	
	/**
	 * 查询没有绑定的配送企业
	 * @param map
	 * @return
	 */
	Page<YimiaoCompany> getYimiaoComp(Map<String,Object> map);
	
	/**
	 * 根据当前登录的用户名查询对应得企业id
	 * @param uname
	 * @return
	 */
	String getCompIdByUName(String uname);
	
	/**
	 * 根据companyId获取企业对象
	 * @param companyId
	 * @return
	 */
	YimiaoCompany getYimiaoCompanyById(String companyId);
	/**
	 * 企业列表
	 * @param conditions
	 * @return
	 */
	Page<YimiaoCompany> getAllList(Map<String, Object> conditions);
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
	
	int getCompanyName(String _parameter);
	
	int insertQy(YimiaoCompany yimiaoCompany);
	
	void updateAccountCode(@Param("companyId")String companyId,@Param("accountCode")String accountCode);


}