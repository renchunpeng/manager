package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdAreaDao extends GenericDao<StdArea, String> {

	/**
	 * 获取地区查看列表数据
	 * @param page
	 * @return
	 */
	Page<StdArea> queryAll(Map<String, Object> map);

	List<StdArea> getGoodsAreaPrice(String projId);


	/**
	 * 获取地区查看列表数据
	 * @param page
	 * @return
	 */
	int add(StdArea dicarea);
	
	Map<String, Object> getSqlDicAreaById(String areaid);
	
	/**
	 * 根据地区编号获取地区信息
	 * @param areaId 地区编号
	 * @author lil
	 * @return
	 */
	StdArea getAreaByAreaId(String areaId);
	
	/**
	 * 根据地区父类id获取地区信息
	 * @param faterId 地区编号
	 * @author lil
	 * @return
	 */
	List<StdArea> getAreaByFaterId(String faterId);
	
	List<StdArea> getAreaByCity(String fatherIdParent);
	
	List<StdArea> getAreaByCityId(String fatherId);
	
	/**
	 * @category 根据地区父级id与企业id获取可选地区信息
	 * @author 韩守松
	 * @date   2016年8月24日
	 * @param  @param map
	 * @param  @return
	 */
	List<StdArea> getAreaByCompanyId(Map<String,String> map);
	StdArea getByAreaId(String areaId);
	StdArea getByAreaName(String areaName);
	/**
	 * 获得所有区域列表
	 * @return
	 */
	List<StdArea> getAllList();
	
	List<Map<String, Object>> selectAreaList(Map<String, Object> params);

	List<StdArea> countyList();

	List<StdArea> getCountyList();

	List<StdArea> getCityList();
	
	/**
	 * 根据areaId，获得所有父对象
	 * @param areaId
	 * @return
	 */
	List<StdArea> getFatherAreas(String areaId);

	/**
	 * 获取州市信息
	 * @param areaId
	 * @return
	 */
	List<StdArea> getAreaNameCity();
	
}