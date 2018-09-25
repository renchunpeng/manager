package com.hsnn.medstgmini.yimiao.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.yimiao.model.StdSort;

import java.util.List;

public interface StdSortManager extends GenericManager<StdSort, Integer> {
	// 扩展接口
    List<StdSort> getListByName(StdSort stdSort);
}