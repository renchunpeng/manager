package com.hsnn.medstgmini.base.std.dao;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.util.Pagination;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdCompany;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdCompanyDao extends GenericDao<StdCompany, java.lang.String> {

	List<StdCompany> getExceptionCompanyList(Map<String, Object> map);

	List<StdCompany> getExceptionDrugsList(Map<String, Object> map);

	List<StdCompany> queryStdCompinfoById(String orgId);
	int updateStdCompany(StdCompany stdCompany);
	
	/**
	 * 过期企业
	 * @param map
	 * @return
	 */
	List<StdCompany> queryOverAll(Map<String, Object> map);

	void updateNextFlow(Map<String, Object> compMap);

	List<StdCompany> getCompanyAccountCode(String CompanyAccountCode);

	List<StdCompany> getCompanyId(String companyId);

	/**
	 * 根据提供的企业编号和字段修改具体的值
	 * @param stdGoods
	 */
	int updateColumnById(Map<String, Object> map);
	
	void updateAccountCode(@Param("companyId")String companyId, @Param("accountCode")String accountCode);
	
	
	List<StdCompany> getReviewCompNmae(StdCompany stdCompany);
	
	List<StdCompany> queryAllByIds(@Param("ids") String[] ids);

	/**
	 * 支付页面
	 */
	int updateComp(StdCompany comp);

	
	/**
	 * 企业账号发放列表
	 * @param map
	 * @return
	 */
	List<StdCompany> getAccountReleaseList(Map<String, Object> map);
	
	/**
	 * 生成账号
	 * @param stdGoods
	 */
	int addCompAccount(Map<String, Object> map);
	Page<StdCompany> getCompPaymentList(Map<String, Object> map);
	
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
	
	Page<Map<String, Object>> getgspWarnData(Map<String, Object> map);
	
	List<Integer> getgspWarnCount(Map<String, Object> map);

	Map<String,Object> findByCompanyAccountCode(String companyAccountCode);

	Map<String, Object> findById(String companyId);
	Page<StdCompany> getCompName(Map<String, Object> conditions);
	List<StdCompany>  getStdCompList(Map<String, Object> map);
	int getCompanyName(String _parameter);
	int getBusinessLicense(String _parameter);
	int insertQy(StdCompany stdCompany);
	
	List<StdCompany>  getQySelectList(Map<String, Object> map);
	
	List<StdCompany>  getQySendSelectList(Map<String, Object> map);
	
	StdCompany queryStdCompInfoByCompId(String id);
	
	void updateCompId(@Param("id")String id, @Param("zhuSequence")String zhuSequence);
	
	List<StdCompany> getScByCompanyId(Map <String, Object> map);
	
	List<StdCompany> getSelectCompany(Map<String, Object> map);
	Page<StdCompany> getCompanyAddData(Map<String, Object> conditions);
	
	List<StdCompany> getCompList(Map<String, Object> map);
	
	List<StdCompany> getCompSendMsg(Map<String, Object> map);

	Page<StdCompany> getCompanyTb(Map<String, Object> conditions);

	Page<StdCompany> getCompanyLists(Map<String, Object> conditions);
	
	List<StdCompany> getCompanyList(Map<String, Object> map);

	void updateCompType(String compCode);
	void updateCompName(Map<String, Object> map);

    List<StdCompany> getCompanyInfo();

	List<StdCompany> getCompTbList(Map<String, Object> map);
}