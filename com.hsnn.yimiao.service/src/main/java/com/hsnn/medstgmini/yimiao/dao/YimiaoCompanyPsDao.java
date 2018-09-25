package com.hsnn.medstgmini.yimiao.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompanyPs;

import java.util.Map;


public interface YimiaoCompanyPsDao {

	Page<YimiaoCompanyPs> getYimiaoCompanyPsList(Map<String, Object> map);

    //保存
    void saveYimiaoCompanyPs(String yimiaoCompanyPs);
}