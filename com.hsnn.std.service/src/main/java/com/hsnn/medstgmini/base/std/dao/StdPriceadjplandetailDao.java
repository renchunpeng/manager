package com.hsnn.medstgmini.base.std.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.std.model.StdPriceadjplandetail;
import com.hsnn.medstgmini.common.dao.GenericDao;

import java.util.Map;

public interface StdPriceadjplandetailDao extends GenericDao<StdPriceadjplandetail, String> {
    //产品调价
    Page<StdPriceadjplandetail> getPlanGoddsResult(Map<String, Object> map);
}