package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.util.SelectForm;

import java.util.List;

public interface StdManageOrgManager extends GenericManager<StdManageOrg, String> {
	// 扩展接口
	Pagination getJgSelectList(Pagination page);

	Pagination getJgSendSelectList(Pagination page);

	StdManageOrg queryStdManageOrgById(String id);

	String getAreaIdByOrgId(String orgId);

	Pagination getManageOrgSelectList(Pagination page);

    void updateAccountCode(String id, String zhuSequence);

    //新增疫苗监管机构
    int getManageOrgName(String _parameter);

    boolean addManageOrg(StdManageOrg stdManageOrg);

	StdArea getStdAreaByOrgId(String id);
}