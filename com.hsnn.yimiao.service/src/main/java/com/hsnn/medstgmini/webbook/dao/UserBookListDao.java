package com.hsnn.medstgmini.webbook.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.webbook.model.UserBookList;

import java.util.Map;

public interface UserBookListDao {

    Page<UserBookList> getList(Map<String, Object> conditions);
}