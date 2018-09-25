package com.hsnn.medstgmini.common.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.util.SelectForm;

public interface DynamicSelectManager {
	
	/**
	 * 根据地区父类id获取地区信息
	 * @param fatherId 地区编号
	 * @return
	 */
	public List<SelectForm> getArea(String fatherId);
	
	/**
	 * @category 根据地区父级id与企业id获取可选地区信息
	 * @author 韩守松
	 * @date   2016年8月24日
	 * @param  @param map
	 * @param  @return
	 */
	public List<SelectForm> getAreaByCompanyId(Map<String,String> map);
}
