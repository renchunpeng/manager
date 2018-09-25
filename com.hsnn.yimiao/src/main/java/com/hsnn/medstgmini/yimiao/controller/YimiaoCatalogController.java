package com.hsnn.medstgmini.yimiao.controller;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.util.JudgmentRole;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.service.YimiaoCatalogManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoProcurecatalogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(YimiaoCatalogController.ACTION_PATH)
public class YimiaoCatalogController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoCatalogController.class);
	protected static final String ACTION_PATH="/yimiaoCatalog";
	protected static final String MODEL_PATH="/yimiao/yimiaoCatalog/";// TODO 修改
	@Autowired
	private YimiaoCatalogManager yimiaoCatalogManager;

    @Autowired
    private YimiaoProcurecatalogManager yimiaoProcurecatalogManager;

	/**
     * 采购目录页面跳转
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
	@RequestMapping("toYimiaoCatalogList")
	public ModelAndView toYimiaoCatalogList() {
		return new ModelAndView(MODEL_PATH + "yimiaoCatalogList");
	}

	/**
     * 采购目录数据获取
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
	@RequestMapping("getYimiaoCatalogData")
	@ResponseBody
	public Pagination getYimiaoCatalogData() {
		Pagination pagination = new Pagination(this.getRequest());
		try {
            pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
			pagination = yimiaoCatalogManager.getCatalogList(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoCatalogData", e);
		}
		return pagination;
	}

	/**
     * 新增页面跳转
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
    @RequestMapping("toAddCatalog")
    public ModelAndView toAddCatalog() {
        return new ModelAndView(MODEL_PATH + "addCatalog");
    }

    /**
     * 获取新增页面数据
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("getProCatalogData")
    @ResponseBody
    public Pagination getProCatalogData() {
        Pagination pagination = new Pagination(this.getRequest());
        try {
            pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
            pagination = yimiaoProcurecatalogManager.queryCatalog(pagination);
        } catch (Exception e) {
            log.error("Failed to getProCatalogData", e);
        }
        return pagination;
    }

    /**
	 * 新增采购目录
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("addCatalog")
    @ResponseBody
    public Pagination addCatalog() {
        Pagination pagination = new Pagination(this.getRequest());
        try {
            String data = (String) pagination.getConditions().get("data");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, String>>>() {
            }.getType();
            List<Map<String, String>> list = gson.fromJson(data, type);
            pagination.getConditions().put("list",list);
            pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
            pagination.getConditions().put("hospitalName", JudgmentRole.judgmentRole(getSysUser()));
            pagination.getConditions().remove("data");
            yimiaoCatalogManager.addCatalog(pagination);
            pagination.setSuccess(true);
        } catch (Exception e) {
            pagination.setSuccess(false);
            pagination.setMsg("操作失败");
            log.error("Failed to addCatalog", e);
        }
        return pagination;
    }

    /**
     * 采购目录删除
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("removeCatalog")
    @ResponseBody
    public Pagination removeCatalog() {
        Pagination pagination = new Pagination(this.getRequest());
        try {
            String data = (String) pagination.getConditions().get("data");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, String>>>() {
            }.getType();
            List<Map<String, String>> list = gson.fromJson(data, type);
            pagination.getConditions().put("list",list);
            pagination.getConditions().remove("data");
            yimiaoCatalogManager.removeCatalog(pagination);
            pagination.setSuccess(true);
        } catch (Exception e) {
            pagination.setSuccess(false);
            pagination.setMsg("操作失败");
            log.error("Failed to addCatalog", e);
        }
        return pagination;
    }
}