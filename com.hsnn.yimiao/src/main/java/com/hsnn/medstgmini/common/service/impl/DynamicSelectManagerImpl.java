package com.hsnn.medstgmini.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.std.dao.StdAreaDao;
import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.common.service.DynamicSelectManager;
import com.hsnn.medstgmini.util.SelectForm;

@Service("selecManager")
public class DynamicSelectManagerImpl implements DynamicSelectManager {

	@Autowired
	private StdAreaDao stdAreaDao;

	/**
	 * 根据地区父类id获取地区信息
	 * @param fatherId 地区编号
	 * @return
	 */
	public List<SelectForm> getArea(String fatherId) {
		List<StdArea> list = stdAreaDao.getAreaByFaterId(fatherId);
		List<SelectForm> slist = new ArrayList<SelectForm>();
		for (int i = 0; i < list.size(); i++) {
			StdArea data = list.get(i);
			SelectForm form = new SelectForm();
			form.setValue(data.getAreaId());
			form.setText(data.getAreaName());
			slist.add(form);
		}
		return slist;
	}
	
	@Override
	public List<SelectForm> getAreaByCompanyId(Map<String, String> map) {
		List<StdArea> list = stdAreaDao.getAreaByCompanyId(map);
		List<SelectForm> slist = new ArrayList<SelectForm>();
		for (int i = 0; i < list.size(); i++) {
			StdArea data = list.get(i);
			SelectForm form = new SelectForm();
			form.setValue(data.getAreaId());
			form.setText(data.getAreaName());
			slist.add(form);
		}
		return slist;
	}
}
