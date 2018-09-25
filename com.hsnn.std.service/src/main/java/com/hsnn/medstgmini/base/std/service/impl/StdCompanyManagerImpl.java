package com.hsnn.medstgmini.base.std.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdCompanyDao;
import com.hsnn.medstgmini.base.std.enums.CompanyTypeEnum;
import com.hsnn.medstgmini.base.std.enums.GmpGspType;
import com.hsnn.medstgmini.base.std.model.ContrastObj;
import com.hsnn.medstgmini.base.std.model.StdCompany;
import com.hsnn.medstgmini.base.std.model.StdCompanyClear;
import com.hsnn.medstgmini.base.std.model.StdGmpgsp;
import com.hsnn.medstgmini.base.std.service.StdCompanyClearManager;
import com.hsnn.medstgmini.base.std.service.StdCompanyManager;
import com.hsnn.medstgmini.base.std.service.StdGmpgspManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.common.model.IUpdateInfo;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;
/**
 *
 *@category 企业接口实现
 *@author wangs
 */
@Service
public class StdCompanyManagerImpl extends GenericManagerImpl<StdCompany, String> implements StdCompanyManager {

	@Autowired
	private StdCompanyDao stdCompanyDao;

	@Autowired
	private StdGmpgspManager  stdGmpgspManager;

	@Autowired
	private StdCompanyClearManager  stdCompanyClearManager;

	@Autowired
	private ISysUser  sysUserManager;

	@Autowired
	private AttachmentPlug attachmentPlug;

	@Override
	public StdCompany getCompanyAccountCode(String CompanyAccountCode) {
		List<StdCompany> companyAccountCode = stdCompanyDao.getCompanyAccountCode(CompanyAccountCode);
		return  companyAccountCode.get(0);
	}

	@Override
	public Pagination getCompanyList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.queryAll(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public StdCompany getCompanyId(String companyId) {
		List<StdCompany> list = stdCompanyDao.getCompanyAccountCode(companyId);
		StdCompany stdCompany = list.get(0);
		return stdCompany;
	}

	@Override
	public Pagination getOverCompanyList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.queryOverAll(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public boolean addData(StdCompany stdCompany) {
		int i = stdCompanyDao.save(stdCompany);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addData(StdCompany stdCompany, StdGmpgsp stdGmpgsp) {
		int i = this.add(stdCompany);
		if(stdCompany.getCompanyType().equals(CompanyTypeEnum.PS.getKey())){
			stdGmpgsp.setType(GmpGspType.GSP.getKey());
			stdGmpgsp.setCompanyId(stdCompany.getCompanyId());
			stdGmpgspManager.add(stdGmpgsp);
			stdCompany.setGspCode(stdGmpgsp.getId().toString());
			stdCompanyDao.updateStdCompany(stdCompany);
		}
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addData(StdCompany stdCompany, SysUser sysUser,StdGmpgsp stdGmpgsp) {
		int i = this.add(stdCompany);
		sysUserManager.saveUser(sysUser);
		if(stdCompany.getCompanyType().equals(CompanyTypeEnum.PS.getKey())){
			stdGmpgsp.setType(GmpGspType.GSP.getKey());
			stdGmpgsp.setCompanyId(stdCompany.getCompanyId());
			stdGmpgspManager.add(stdGmpgsp);
			stdCompany.setGspCode(stdGmpgsp.getId().toString());
			stdCompanyDao.updateStdCompany(stdCompany);
		}
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Pagination getExceptionCompanyList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getExceptionCompanyList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public Pagination getExceptionDrugsList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getExceptionDrugsList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public StdCompany getCompanyById(String companyId) {
		return this.getById(companyId);
	}

	@Override
	public int updateCompany(StdCompany stdCompany) {

		if(stdCompany instanceof IUpdateInfo){
			((IUpdateInfo) stdCompany).setLastUpdateUserId(SessionUtil.getSysUser().getUserId());
			((IUpdateInfo) stdCompany).setLastUpdateUserName(SessionUtil.getSysUser().getName()+"("+SessionUtil.getSysUser().getUserName()+")");
		}
		if(stdCompany instanceof IAttachment<?>){
			attachmentPlug.processAttachment(stdCompany);
		}
		return stdCompanyDao.updateStdCompany(stdCompany);
	}

	@Override
	public int updateCompany(StdCompany stdCompany, StdGmpgsp stdGmpgsp) {
		/*stdCompanyDao.updateStdCompany(stdCompany);*/
		int i=  this.updateById(stdCompany);
		if(stdCompany.getCompanyType().equals(CompanyTypeEnum.PS.getKey())){
			/*stdGmpgspManager.updateStdGmpgsp(stdGmpgsp);*/
			stdGmpgspManager.updateById(stdGmpgsp);
		}
		return i;
	}

	@Override
	public int updateCompany(StdCompany stdCompany, SysUser sysUser,
							 StdGmpgsp stdGmpgsp) {
		int i=  updateCompany(stdCompany);
		sysUserManager.updateUserIsUsing(sysUser);
		if(stdCompany.getCompanyType().equals(CompanyTypeEnum.PS.getKey())){
			stdGmpgspManager.updateStdGmpgsp(stdGmpgsp);
		}
		return i;
	}

	/**
	 * 提交澄清信息
	 * @param stdCompany
	 */
	@Override
	public int updateClarifyById(StdCompany stdCompany) {

//		if(stdCompany.getClearStatus() == 2 || stdCompany.getClearStatus() == 3 || stdCompany.getClearStatus() == 4) {//提交
		StdCompanyClear stdCompanyClear = new StdCompanyClear();
		stdCompanyClear.setCompanyId(stdCompany.getCompanyId());
		stdCompanyClear.setIsOnlineClear(1);//网上交易
		if(stdCompany.getClearStatus() == 2) {
			stdCompanyClear.setOnlineClearStatus(1);
			stdCompanyClear.setBeforOnlineClearStatus("0");
		}else if(stdCompany.getClearStatus() == 3) {
			stdCompanyClear.setOnlineClearStatus(2);
			stdCompanyClear.setBeforOnlineClearStatus("1");
		}else if(stdCompany.getClearStatus() == 4) {
			stdCompanyClear.setOnlineClearStatus(3);
			stdCompanyClear.setBeforOnlineClearStatus("2");
		}

		stdCompanyClear.setLastUpdateUserId(stdCompany.getLastUpdateUserId());
		stdCompanyClear.setLastUpdateUserName(stdCompany.getLastUpdateUserName());
		stdCompanyClearManager.updateClearStatus(stdCompanyClear);
//		}
		return ((StdCompanyDao) getDao()).updateStdCompany(stdCompany);
	}

	/**
	 * 根据修改的内容循环插入澄清记录
	 * @param map
	 * @return
	 */
	@Override
	public int saveGoodsClearByMap(List<ContrastObj> coList, StdCompany stdCompany) {
		List<StdCompanyClear> sccList = new ArrayList<StdCompanyClear>();
		//资质状态
		int qualificationStatus = stdCompany.getQualificationStatus();
		//插入澄清记录信息
		for(int i =0;i<coList.size();i++) {//循环解析更改数据
			StdCompanyClear scc = new StdCompanyClear();//企业澄清表
			ContrastObj co = coList.get(i);//得到对象
			if(qualificationStatus == 1) {//资质状态合格
				scc.setSort(1);//质疑
			}else {
				scc.setSort(2);//澄清
			}
			scc.setCompanyId(stdCompany.getCompanyId());//企业编号
			scc.setClearContent(co.getName());//澄清内容

			scc.setVbeforeProcess(co.getOldValue());//申请处理前值
			scc.setVafterProcess(co.getNewValue());//申请处理后值
			scc.setIsOnlineClear(0);//是否网上澄清0否1是
			scc.setClearStatus(3);//澄清状态1保存2提交3审核通过4审核未通过
			sccList.add(scc);//添加修改内容
		}
		if(sccList.size() > 0){
			stdCompanyClearManager.insertBatch(sccList);//批量插入商品澄清表
		}
		//保存产品修改信息
		return ((StdCompanyDao) getDao()).updateStdCompany(stdCompany);
	}


	/**
	 * 根据提供的企业编号和字段修改具体的值
	 * @param stdGoods
	 */
	@Override
	public int updateColumnById(Map<String, Object> map) {

		return ((StdCompanyDao) getDao()).updateColumnById(map);
	}

	@Override
	public List<StdCompany> getReviewCompNmae(StdCompany stdCompany) {
		return stdCompanyDao.getReviewCompNmae(stdCompany);
	}

	@Override
	public List<StdCompany> queryAllByIds(String[] ids) {
		return stdCompanyDao.queryAllByIds(ids);
	}

	/**
	 * 企业账号发放列表
	 * @param map
	 * @return
	 */
	@Override
	public Pagination getAccountReleaseList(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompany = (Page<StdCompany>) stdCompanyDao.getAccountReleaseList(page.getConditions());
		page.setRows(stdCompany);
		page.setRecords(stdCompany.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	/**
	 * 生成账号
	 * @param stdGoods
	 */
	@Override
	public int addCompAccount(StdCompany stdCompany,String password) {
		Map<String,Object> map = new HashMap<String,Object>();
		stdCompany.setLastUpdateUserId(SessionUtil.getSysUser().getUserId());
		stdCompany.setLastUpdateUserName(SessionUtil.getSysUser().getUserName());
		stdCompanyDao.updateStdCompany(stdCompany);
		map.put("companyId", stdCompany.getCompanyId());
		map.put("password", password);
		return stdCompanyDao.addCompAccount(map);
	}
	@Override
	public int updateComp(StdCompany comp) {

		return stdCompanyDao.updateComp(comp);
	}

	@Override
	public Pagination getAuditList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompany = (Page<StdCompany>) stdCompanyDao.getCompPaymentList(page.getConditions());
		page.setRows(stdCompany);
		page.setRecords(stdCompany.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public int auditPass(StdCompany comp) {

		return stdCompanyDao.auditPass(comp);
	}

	@Override
	public int auditNoPass(StdCompany comp) {
		return stdCompanyDao.auditNoPass(comp);
	}

	@Override
	public int payInfoSecondAudit(StdCompany comp) {
		return stdCompanyDao.payInfoSecondAudit(comp);
	}

	/**
	 * 获取分页数据
	 * 获取配送企业数据
	 * @author lil
	 * @date 2016年3月19日 09:14:02
	 * @param page
	 * @return
	 */
	@Override
	public List<List<Map<String, Object>>> getCompanyData(Map<String, Object> map) {
		return stdCompanyDao.getCompanyData(map);
	}

	@Override
	public List<Integer> getWarnCount() {
		return stdCompanyDao.getWarnCount();
	}

	@Override
	public Pagination getgspWarnData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String,Object>> stdCompany = (Page<Map<String,Object>>) stdCompanyDao.getgspWarnData(page.getConditions());
		page.setRows(stdCompany);
		page.setRecords(stdCompany.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public List<Integer> getgspWarnCount(Map<String, Object> map) {
		return stdCompanyDao.getgspWarnCount(map);
	}
	@Override
	public int callUnIsDispermission(String companyId) {
		return stdCompanyDao.callUnIsDispermission(companyId);
	}

	@Override
	public int callIsDispermission(String companyId) {
		return stdCompanyDao.callIsDispermission(companyId);
	}

	@Override
	public Map<String,Object> findById(String companyId) {
		return stdCompanyDao.findByCompanyAccountCode(companyId);
	}

	@Override
	public Pagination getCompName(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getCompName(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public Pagination getStdCompList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getStdCompList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public int getCompanyName(String _parameter){
		return stdCompanyDao.getCompanyName(_parameter);
	}
	@Override
	public int getBusinessLicense(String businessLicense){
		return stdCompanyDao.getBusinessLicense(businessLicense);
	}
	@Override
	public boolean addCompanyQy(StdCompany stdCompany) {
		int i = stdCompanyDao.insertQy(stdCompany);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Pagination getQySelectList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getQySelectList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public StdCompany queryStdCompInfoByCompId(String id) {
		// TODO Auto-generated method stub
		return stdCompanyDao.queryStdCompInfoByCompId(id);
	}

	@Override
	public void updateCompId(String id, String zhuSequence) {
		stdCompanyDao.updateCompId(id,zhuSequence);

	}

	@Override
	public Pagination getScByCompanyId(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getScByCompanyId(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public Pagination getSelectCompany(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getSelectCompany(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public void updateAccountCode(String companyId, String accountCode) {
		stdCompanyDao.updateAccountCode(companyId, accountCode);
	}

	@Override
	public Pagination getCompanyTb(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getCompanyTb(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}
	@Override
	public Pagination getCompanyLists(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getCompanyLists(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}


	@Override
	public Pagination getQySendSelectList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getQySendSelectList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}
	@Override
	public void updateCompType(String compCode){
		stdCompanyDao.updateCompType(compCode);
	}
	@Override
	public void updateCompName(Map<String,Object> map){
		stdCompanyDao.updateCompName(map);
	}

	@Override
	public List<StdCompany> getCompanyInfo() {
		return stdCompanyDao.getCompanyInfo();
	}

	@Override
	public Pagination getCompTbList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdCompany> stdCompanies = (Page<StdCompany>) stdCompanyDao.getCompTbList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}
	@Override
	public void updateStdCompany(StdCompany stdCompany){
		stdCompanyDao.updateStdCompany(stdCompany);
	}
}