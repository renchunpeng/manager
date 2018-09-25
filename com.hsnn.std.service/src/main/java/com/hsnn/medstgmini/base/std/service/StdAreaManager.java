package com.hsnn.medstgmini.base.std.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.form.StdAreaForm;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.Pagination;
/**
 * 
 *@category 地区字典管理接口
 *@author 邱磊
 *@date 2015年6月10日 下午4:10:58
 */
public interface StdAreaManager  {
	
	
	/**
	 * 获取地区查看列表数据
	 * @param page
	 * @return
	 */
	Pagination getdicAreaList(Pagination page);
	
	/**
	 * 添加地区信息
	 * @param form
	 * @return
	 */
	boolean addData(StdAreaForm form);
	
	
	/**
	 * 
	 *@category 根据地区编码查询地区信息
	 *@author 邱磊
	 *@date 2015年6月10日 下午4:06:18
	 *@param areaid 地区编码
	 *@return
	 */
	public StdAreaForm getDicAreaById(String areaid);	
	
	/**
	 * 根据地区编号获取地区信息
	 * @param areaId 地区编号
	 * @author lil
	 * @return
	 */
	public StdArea getAreaByAreaId(String areaId);
	
	/**
	 * 根据区编号获取父级信息
	 * @param areaId 地区编号
	 * @author wangs
	 * @return
	 */
	public StdArea getAreaById(String areaId);
	
	/*************************************************************** ***************************************************************/
	/**
	 * 查询所有地市信息
	 * @return
	 */
	public List<StdArea> getAreaByCity(String fatherIdParent);
	
	/**
	 * 根据地市查询地市下的所有区县,用户地市和区县联动
	 * @return
	 */
	public List<StdArea> getAreaByCityId(String fatherId);
	
	StdArea getByAreaId(String string);
	
	/**
	 * 获得区域id和名称映射
	 * @return
	 */
	Map<String, String> getAreaIdNameMap();
	
	Pagination selectAreaList(Pagination page);
	
	List<StdArea> getFatherAreas(String areaId);

	/**
	 * 获取州市信息
	 * @param areaId
	 * @return
	 */
	List<StdArea> getAreaNameCity();

	List<StdArea> getGoodsAreaPrice(String projId);
	
}