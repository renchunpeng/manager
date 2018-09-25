package com.hsnn.medstgmini.yimiao.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoPriceadjplandetail;

import java.util.Map;

public interface YimiaoPriceadjplandetailDao extends GenericDao<YimiaoPriceadjplandetail, String> {
    Page<YimiaoPriceadjplandetail> getPlanGoods(Map<String,Object> map);
}