package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.ContrastObj;
import com.hsnn.medstgmini.base.std.model.StdCompany;
import com.hsnn.medstgmini.base.std.model.StdGmpgsp;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
/**
 * 
 *@category 企业service 接口
 *@author wangs
 */
public interface StdCompanyManager extends GenericManager<StdCompany, String> {

	/**
	 * 根据company_account_code进行查询
	 */
	StdCompany getCompanyAccountCode(String CompanyAccountCode);
	/**
	 * 获取企业查看列表数据
	 * @param page
	 * @return
	 */
	Pagination getCompanyList(Pagination page);

	StdCompany getCompanyId(String companyId);
	/**
	 * 获得过期企业
	 * @param page
	 * @return
	 */
	Pagination getOverCompanyList(Pagination page);
	
	/**
	 * @desc 添加企业信息
	 * @param form
	 * @return
	 */
	boolean addData(StdCompany stdCompany);
	/**
	 * 获取所有 例外企业列表
	 * 资审 采购项目企业管理 添加企业
	 * 获取企业信息 去除 已经 提交企业信息 和 例外的企业
	 *
	 * @param page
	 * @return
	 */
	Pagination getExceptionCompanyList(Pagination page);

	/**
	 * 获取所有 例外企业列表
	 * 资审 采购项目企业管理 添加企业
	 * 获取企业信息 去除 已经 提交药品信息的 和 例外的企业
	 *
	 * @param page
	 * @return
	 */
	Pagination getExceptionDrugsList(Pagination page);
	/**
	 * @desc 添加企业信息同时添加gsp 信息
	 * @param form
	 * @return
	 */
	boolean addData(StdCompany stdCompany,StdGmpgsp stdGmpgsp);
	
	/**
	 * @desc 添加企业信息同时添加gsp 信息
	 * @param form
	 * @return
	 */
	boolean addData(StdCompany stdCompany,SysUser sysUser,StdGmpgsp stdGmpgsp);
	/**
	 * @ desc 根据id 得到企业信息
	 * @param companyId
	 * @return
	 */
	public StdCompany getCompanyById(String companyId);	
	
	/**
	 * @desc修改企业
	 * @param stdCompany
	 * @return
	 */
	public int updateCompany(StdCompany stdCompany);
	
	/**
	 * @desc修改企业同时修改gsp的信息
	 * @param stdCompany
	 * @return
	 */
	public int updateCompany(StdCompany stdCompany,StdGmpgsp stdGmpgsp);
	
	/**
	 * @desc修改企业同时修改sysUser ,stdGsp 的信息
	 * @param stdCompany
	 * @return
	 */
	public int updateCompany(StdCompany stdCompany,SysUser sysUser,StdGmpgsp stdGmpgsp);
	
	
	/**
	 * 提交澄清信息
	 * @param stdCompany
	 */
	int updateClarifyById(StdCompany stdCompany);
	
	/**
	 * 根据修改的内容循环插入澄清记录
	 * @param map
	 * @return
	 */
	int saveGoodsClearByMap(List<ContrastObj> coList, StdCompany stdCompany);
	

	/**
	 * 根据提供的企业编号和字段修改具体的值
	 * @param stdGoods
	 */
	int updateColumnById(Map<String, Object> map);
	
	//根据企业名称验证是否存在
	List<StdCompany> getReviewCompNmae(StdCompany stdCompany);
	
	Pagination getScByCompanyId(Pagination page);
	
	List<StdCompany> queryAllByIds(String[] ids);

	
	int updateComp(StdCompany comp);


	Pagination getAccountReleaseList(Pagination page);

	int addCompAccount(StdCompany stdCompany,String password);
	
	/**
	 * 审核企业支付信息列表
	 */
	Pagination getAuditList(Pagination page);
	
	int auditPass(StdCompany comp);
	int auditNoPass(StdCompany comp);

	int payInfoSecondAudit(StdCompany comp);
	
	/**
	 * 获取分页数据
	 * 获取配送企业数据
	 * @author lil
	 * @date 2016年3月19日 09:14:02
	 * @param page
	 * @return
	 */
	List<List<Map<String, Object>>> getCompanyData(Map<String, Object> map);
	
	/**
	 * @category 暂停配送权限
	 * @author 韩守松
	 * @date   2016年8月15日
	 * @param  @return
	 */
	int callUnIsDispermission(String companyId);
	
	/**
	 * @category 恢复配送权限
	 * @author 韩守松
	 * @date   2016年8月15日
	 * @param  @return
	 */
	int callIsDispermission(String companyId);


	List<Integer> getWarnCount();

	Pagination getgspWarnData(Pagination page);

	List<Integer> getgspWarnCount(Map<String, Object> map);
	
	Map<String,Object> findById(String companyId);

	Pagination getCompName(Pagination page);

	Pagination getStdCompList(Pagination page);

	int getCompanyName(String companyName);

	int getBusinessLicense(String businessLicense);
	//生成账号新增企业
	boolean addCompanyQy(StdCompany stdCompany);
	
	Pagination getQySelectList(Pagination page);
	
	Pagination getQySendSelectList(Pagination page);
	
	StdCompany queryStdCompInfoByCompId(String id);
	
	void updateCompId(String id, String zhuSequence);

	Pagination getSelectCompany(Pagination page);
	
	void updateAccountCode(String companyId, String accountCode);

	Pagination getCompanyTb(Pagination page);
	//获取所有配送企业
	Pagination getCompanyLists(Pagination page);

	void updateCompType(String compCode);

	void updateCompName(Map<String,Object> map);

    List<StdCompany> getCompanyInfo();

	Pagination getCompTbList(Pagination page);

	void updateStdCompany(StdCompany stdCompany);
}