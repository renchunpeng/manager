package com.hsnn.medstgmini.webbook.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.webbook.dao.UserBookListDao;
import com.hsnn.medstgmini.webbook.model.UserBookList;
import com.hsnn.medstgmini.webbook.service.UserBookListManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookListManagerImpl implements UserBookListManager {

    @Autowired
    private UserBookListDao userBookListDao;

    @Override
    public Pagination getList(Pagination page) {
        PageHelper.startPage(page.getPage(), page.getCount());
        Page<UserBookList> models = userBookListDao.getList(page.getConditions());
        page.setRows(models);
        page.setRecords(models.getTotal());
        return page;
    }
}