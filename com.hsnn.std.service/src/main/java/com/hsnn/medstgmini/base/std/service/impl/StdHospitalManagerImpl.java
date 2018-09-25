package com.hsnn.medstgmini.base.std.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdHospitalDao;
import com.hsnn.medstgmini.base.std.model.StdHospital;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysDepartmentManager;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.common.model.IUpdateInfo;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;

@Service
public class StdHospitalManagerImpl  extends GenericManagerImpl<StdHospital,String>  implements StdHospitalManager{

	@Autowired
	private ISysUser SysUserManager;
	@Autowired
	private StdHospitalDao stdHospitalDao;
	
	@Autowired
	private ISysUser sysUserManager;
	
	@Autowired
	private ISysDepartmentManager sysDepartmentManager;
	
	@Autowired
	private AttachmentPlug attachmentPlug;
	
	@Override
	public int updateByIdAndAddSysUser(StdHospital stdHospital, SysUser hispSysUser) {
		int count = 0;
		int row = this.updateById(stdHospital);
		if(row>0){
			count = SysUserManager.saveUser(hispSysUser);
		}
		return count;
	}

	@Override
	public List<StdHospital> queryAllHospitalbyHospitalName(
			Map<String, Object> map) {
		return stdHospitalDao.queryAllHospitalbyHospitalName(map);
	}

	@Override
	public int updateHospital(StdHospital stdHospital) {
		if(stdHospital instanceof IUpdateInfo){
			((IUpdateInfo) stdHospital).setLastUpdateUserId(SessionUtil.getSysUser().getUserId());
			((IUpdateInfo) stdHospital).setLastUpdateUserName(SessionUtil.getSysUser().getUserName());
		}
		if(stdHospital instanceof IAttachment<?>){
			attachmentPlug.processAttachment(stdHospital);
		}
		return stdHospitalDao.updateHospital(stdHospital);
	}

	@Override
	public int updateHosp(StdHospital hosp) {
		
		return stdHospitalDao.updateHosp(hosp);
	}

	@Override
	public Pagination getAuditList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdHospital> stdCompany = (Page<StdHospital>) stdHospitalDao.getHospPaymentList(page.getConditions());
		page.setRows(stdCompany);
		page.setRecords(stdCompany.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public int auditPass(StdHospital hosp) {
		
		return stdHospitalDao.auditPass(hosp);
	}

	@Override
	public int auditNoPass(StdHospital hosp) {
		return stdHospitalDao.auditNoPass(hosp);
	}
	
	@Override
	public int payInfoSecondAudit(StdHospital hosp) {
		return stdHospitalDao.payInfoSecondAudit(hosp);
	}

	/**
	 * @category 启用或停用
	 * @author wangbing
	 * @date 2016年6月14日下午5:07:44
	 * @parameter
	 * @return
	 */
	@Override
	public void updateIsUsing(StdHospital hosp){
		int count = stdHospitalDao.updateIsUsing(hosp);
		if(count>0){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("isUsing", hosp.getIsUsing());
			map.put("lastUpdateUserId", hosp.getLastUpdateUserId());
			map.put("lastUpdateUserName", hosp.getLastUpdateUserName());
			map.put("orgId", hosp.getHospitalId());
			if(hosp.getIsUsing()==1){
				map.put("userName", hosp.getUserName());
			}else{
				sysDepartmentManager.updateIsUsingByOrgId(map);
			}
			sysUserManager.updateHospUserIsUsing(map);
		}
	}

	@Override
	public Pagination getYySelectList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdHospital> models = (Page<StdHospital>) ((StdHospitalDao)getDao()).getYySelectList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public Pagination getYySendSelectList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdHospital> models = (Page<StdHospital>) ((StdHospitalDao)getDao()).getYySendSelectList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}
	
	@Override
	public StdHospital getHospInfoByHospId(String id) {
		// TODO Auto-generated method stub
		return stdHospitalDao.getHospInfoByHospId(id);
	}

	@Override
	public void updateHospId(String id, String zhuSequence) {
		stdHospitalDao.updateHospId(id,zhuSequence);
		
	}

	@Override
	public Pagination getCombinaHosp(Pagination page) {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<StdHospital> models = (Page<StdHospital>) ((StdHospitalDao)getDao()).getCombinaHosp(page.getConditions());
			page.setRows(models);
			page.setRecords(models.getTotal());
			printLog("查询",page,"分页查询");
			return page;
		}
	
	
	@Override
	public Pagination getAllList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdHospital> models = ((StdHospitalDao)getDao()).getAllList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}
	
	
	public int OrderStart(String hosp) {
		
		return stdHospitalDao.OrderStart(hosp);
	}
	 
	
	public int OrderDisable(String hosp) {
		
		return stdHospitalDao.OrderDisable(hosp);
	}
	
	public int OrderALL(String hosp) {
		
		return stdHospitalDao.OrderALL(hosp);
	}
	
	public int DisableALL(String hosp) {
		
		return stdHospitalDao.DisableALL(hosp);
	}
	
	public void updateUserName(String hospId, String userName) {
		stdHospitalDao.updateUserName(hospId, userName);
	}

	@Override
	public void updateHos(String orderControl) {
		stdHospitalDao.updateHos(orderControl);
	}
	/****************************************************************************/

	public Pagination getHosPrice(Pagination pagination){
		PageHelper.startPage(pagination.getPage(), pagination.getCount());
		Page<StdHospital> models = (Page<StdHospital>) stdHospitalDao.getHosPrice(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		printLog("查询",pagination,"分页查询");
		return pagination;
	}

	public Pagination getCwByArea(Pagination pagination){
		PageHelper.startPage(pagination.getPage(), pagination.getCount());
		Page<StdHospital> models = (Page<StdHospital>) stdHospitalDao.getCwByArea(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		printLog("查询",pagination,"分页查询");
		return pagination;
	}
	/****************************************************************************/

	/*疫苗新增疾控中心*/
	@Override
	public int getHospitalName(String _parameter) {
		return stdHospitalDao.getHospitalName(_parameter);
	}

	@Override
	public boolean addJKZX(StdHospital StdHospital) {
		
		int count = stdHospitalDao.addJKZX(StdHospital);
		if(count < 1) {
			return false;
		}
		return true;
	}

	@Override
	public StdHospital getByUserName(String s) {
		return stdHospitalDao.getByUserName(s);
	}

	@Override
	public  List<StdHospital> getHospitalInfo() {
		return stdHospitalDao.getHospitalInfo();
	}
	/*疫苗新增疾控中心*/
}
