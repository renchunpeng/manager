package com.hsnn.medstgmini.yimiao.service.impl;

import com.hsnn.medstgmini.yimiao.dao.StdSortDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsnn.medstgmini.yimiao.service.StdSortManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

import com.hsnn.medstgmini.yimiao.model.StdSort;

import java.util.List;

@Service
public class StdSortManagerImpl extends GenericManagerImpl<StdSort, Integer> implements StdSortManager {
    @Autowired
    private StdSortDao dao;
    @Override
    public List<StdSort> getListByName(StdSort stdSort) {
        return dao.getListByName(stdSort);
    }
    // 扩展接口实现
    
}