package com.hsnn.medstgmini.webbook.controller;

import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.service.DynamicSelectManager;
import com.hsnn.medstgmini.util.*;
import com.hsnn.medstgmini.webbook.form.UserBookList;
import com.hsnn.medstgmini.webbook.service.UserBookListManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

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

    /**
     * 用户书籍列表页面跳转
     * @return
     */
    @RequestMapping("/toUserBookList")
    public String toUserBookList() {
        return "webbook/userBookList/list";
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
