package com.hsnn.medstgmini.base.std.dao;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.util.Pagination;

public interface StdManageOrgDao extends GenericDao<StdManageOrg, java.lang.String> {
	
	List<StdManageOrg> getJgSelectList(Map<String, Object> map);
	
	List<StdManageOrg> getJgSendSelectList(Map<String, Object> map);

	StdManageOrg queryStdManageOrgById(String id);

	String getAreaIdByOrgId(String orgId);

	List<StdManageOrg> getManageOrgSelectList(Map<String, Object> conditions);

    void updateAccountCode(String id, String zhuSequence);
    
    //新增疫苗监管
    int getManageOrgName(String _parameter);
    
    int addManageOrg(StdManageOrg stdManageOrg);

	StdArea getStdAreaByOrgId(String id);
}