package com.hsnn.medstgmini.webbook.controller;

import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.webbook.service.UserBookListManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenChunPeng
 * @date 2018/9/26
 */
@Controller
@RequestMapping("/webbook")
public class UserBookListController extends GenericController {
    @Autowired
    private UserBookListManager userBookListManager;

    private static final Logger log = Logger.getLogger(UserBookListController.class);
//    protected static final String MODEL_PATH="/webbook/userBookList/";

    /**
     * 用户书籍列表页面跳转
     * @return
     */
    @RequestMapping("/toUserBookList")
    public String toUserBookList() {
        return "/webbook/userBookList/list";
    }

    /**
     * 获取用户书籍列表
     * @return
     */
    @RequestMapping("/getUserBookList")
    @ResponseBody
    public Pagination getUserBookList(){
        Pagination pagination = new Pagination(this.getRequest());
        try {
            pagination = userBookListManager.getList(pagination);
        } catch (Exception e) {
            log.error("Failed to getYimiaoCatalogData", e);
        }
        return pagination;
    }

}
