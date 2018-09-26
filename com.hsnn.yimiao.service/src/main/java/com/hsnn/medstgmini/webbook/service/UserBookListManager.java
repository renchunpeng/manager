package com.hsnn.medstgmini.webbook.service;

import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.webbook.model.UserBookList;
import com.hsnn.medstgmini.yimiao.model.StdSort;

import java.util.List;

public interface UserBookListManager {

    Pagination getList(Pagination page);
}