package com.hsnn.medstgmini.yimiao.dao;

import com.hsnn.medstgmini.common.dao.GenericDao;
import com.hsnn.medstgmini.yimiao.model.StdSort;

import java.util.List;

public interface StdSortDao extends GenericDao<StdSort, Integer> {
    List<StdSort> getListByName(StdSort stdSort);
}