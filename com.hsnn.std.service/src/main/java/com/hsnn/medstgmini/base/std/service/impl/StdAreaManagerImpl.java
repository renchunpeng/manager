package com.hsnn.medstgmini.base.std.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsnn.medstgmini.base.std.dao.StdAreaDao;
import com.hsnn.medstgmini.base.std.form.StdAreaForm;
import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.util.FormatDate;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.ParseDate;
import com.hsnn.medstgmini.util.ParseNumber;
/**
 * 
 *@category 地区字典管理实现类
 *@author 邱磊
 *@date 2015年6月10日 下午4:11:36
 */
@Service("dicAreaManager")
public class StdAreaManagerImpl implements StdAreaManager {
	
	
	@Autowired
	private StdAreaDao dicAreaDao;
	
	
	/**
	 * 获取地区查看列表数据
	 * @param page
	 * @return
	 */
	@Override
	public Pagination getdicAreaList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<StdArea> dicAreas = dicAreaDao.queryAll(page.getConditions());
		page.setRows(dicAreas);
		page.setRecords(dicAreas.getTotal());
		return page;
	}
	
	/**
	 * 添加地区信息
	 */
	public boolean addData(StdAreaForm form) {
		
		StdArea dicArea = new StdArea();
		BeanUtils.copyProperties(form, dicArea);
		int isSu = dicAreaDao.add(dicArea);
		if(isSu > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 *@category 根据地区编码查询地区信息
	 *@author 邱磊
	 *@date 2015年6月10日 下午4:14:18
	 *@param areaid 地区编码
	 *@return
		 */
	public StdAreaForm getDicAreaById(String areaid){
		Map<String, Object> data = dicAreaDao.getSqlDicAreaById(areaid);
		return this.formartForm(data);
	}
	
	private StdAreaForm formartForm(Map<String, Object> data){
		if (null == data){
			return null;
		}
		StdAreaForm form = new StdAreaForm();
		form.setAreaId(data.get("area_id")==null?null:data.get("area_id").toString());
		form.setAreaName(data.get("area_name")==null?null:data.get("area_name").toString());
		form.setArFullname(data.get("ar_fullname")==null?null:data.get("ar_fullname").toString());
		form.setArShortname(data.get("ar_shortname")==null?null:data.get("ar_shortname").toString());
		form.setFatherAreaCode(data.get("father_id")==null?null:data.get("father_id").toString());
		form.setSortId(data.get("area_id")==null?null:ParseNumber.toInteger(data.get("sort_id").toString()));
		form.setStatus(data.get("status")==null?null:ParseNumber.toInteger(data.get("status").toString()));
		/*SysUser user = sysUserdao.getUserById(data.get("upd_user")==null?"":data.get("upd_user").toString());
		if (null != user){
			form.setUpdUser(user.getName());
		}*/
		form.setUpdDatetime(data.get("upd_datetime") == null ? "" : FormatDate.toShortFormat(ParseDate.fromFullFormat(data.get("upd_datetime").toString())));
		return form;
	}
	
	/**
	 * 根据地区编号获取地区信息
	 * @param areaId 地区编号
	 * @author lil
	 * @return
	 */
	public StdArea getAreaByAreaId(String areaId){
		return dicAreaDao.getAreaByAreaId(areaId);
	}

	@Override
	public StdArea getAreaById(String areaId) {
		StdArea stdArea = dicAreaDao.getAreaByAreaId(areaId);
		StdArea stdAreas = new StdArea();
		return area(stdAreas,stdArea);
	}
	
	public StdArea area(StdArea stdAreas,StdArea stdArea){
		StdArea area = new StdArea();
		if(stdArea == null||StringUtils.isEmpty(stdArea.getFatherId()) ||stdArea.getFatherId().equals("000000")){
			stdAreas = stdArea;
		}else{
			area = dicAreaDao.getAreaByAreaId(stdArea.getFatherId());
			area.getAreaList().add(stdArea);	
			stdAreas = area(stdAreas,area);
		}
		return stdAreas;
	}

	@Override
	public List<StdArea> getAreaByCity(String fatherIdParent) {
		return dicAreaDao.getAreaByCity(fatherIdParent);
	}

	@Override
	public List<StdArea> getAreaByCityId(String fatherId) {
		return dicAreaDao.getAreaByCityId(fatherId);
	}

	@Override
	public StdArea getByAreaId(String areaId) {
		// TODO Auto-generated method stub
		return dicAreaDao.getByAreaId(areaId);
	}
	
	public Map<String, String> getAreaIdNameMap() {
		Map<String, String> result = null;
		List<StdArea> areaList = dicAreaDao.getAllList();
		if (areaList != null) {
			result = new HashMap<String, String>();
			for (StdArea entity : areaList) {
				result.put(entity.getAreaId(), entity.getAreaName());
			}
		}
		return result;
	}

	@Override
	public Pagination selectAreaList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> rows = (Page<Map<String, Object>>) dicAreaDao.selectAreaList(page.getConditions());
		page.setRows(rows);
		page.setRecords(rows.getTotal());
	return page;
	}
	
	public List<StdArea> getFatherAreas(String areaId) {
		return dicAreaDao.getFatherAreas(areaId);
	}

	@Override
	public List<StdArea> getAreaNameCity() {
		return dicAreaDao.getAreaNameCity();
	}

	@Override
	public List<StdArea> getGoodsAreaPrice(String projId) {
		return dicAreaDao.getGoodsAreaPrice(projId);
	}

}