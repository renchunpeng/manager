package com.hsnn.medstgmini.yimiao.controller;


import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.JudgmentRole;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(YimiaoSummaryController.ACTION_PATH)
public class YimiaoSummaryController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoSummaryController.class);
	protected static final String ACTION_PATH="/yimiaoSummary";
	protected static final String MODEL_PATH="/yimiao/yimiaoSummary/";// TODO 修改

    @Autowired
    private YimiaoOrderdetailManager yimiaoOrderdetailManager;

	/**
     * 采购汇总页面跳转
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
	@RequestMapping("toYimiaoCatalogList")
	public ModelAndView toYimiaoCatalogList() {
		return new ModelAndView(MODEL_PATH + "yimiaoPurchaseList");
	}

	/**
     * 采购汇总页面数据获取
	 * @author ZhuMingYuan
	 * @date 2018/5/10
	 * @param
	 * @return
	 */
	@RequestMapping("getYimiaoPurchaseData")
	@ResponseBody
	public Pagination getYimiaoPurchaseData() {
		Pagination pagination = new Pagination(this.getRequest());
		try {
		    if(getSysUser().getUserType().equals(UserType.scqy.getKey())){
                pagination.getConditions().put("companyIdTb", JudgmentRole.judgmentRoleId(getSysUser()));
            }else if(getSysUser().getUserType().equals(UserType.jkzx.getKey())){
                pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
            }else if(getSysUser().getUserType().equals(UserType.cgzx.getKey())){
                pagination.getConditions().put("center", JudgmentRole.judgmentRoleId(getSysUser()));
            }
			pagination = yimiaoOrderdetailManager.getYimiaoData(pagination);
		} catch (Exception e) {
			log.error("Failed to getYimiaoPurchaseData", e);
		}
		return pagination;
	}

    /**
     * 配送汇总页面跳转
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("toYimiaoDispatchList")
    public ModelAndView toYimiaoDispatchList() {
        return new ModelAndView(MODEL_PATH + "yimiaoDispatchList");
    }

    /**
     * 配送汇总页面数据获取
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("getYimiaoDispatchData")
    @ResponseBody
    public Pagination getYimiaoDispatchData() {
        Pagination pagination = new Pagination(this.getRequest());
        try {
            if(getSysUser().getUserType().equals(UserType.scqy.getKey())){
                pagination.getConditions().put("companyIdTb", JudgmentRole.judgmentRoleId(getSysUser()));
            }else if(getSysUser().getUserType().equals(UserType.jkzx.getKey())){
                pagination.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
            }
            pagination = yimiaoOrderdetailManager.getYimiaoPsData(pagination);
        } catch (Exception e) {
            log.error("Failed to getYimiaoCatalogData", e);
        }
        return pagination;
    }

    /**
     * 入库汇总页面跳转
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("toYimiaoStorageList")
    public ModelAndView toYimiaoStorageList() {
        return new ModelAndView(MODEL_PATH + "yimiaoStorageList");
    }

    /**
     * 入库汇总页面数据获取
     * @author ZhuMingYuan
     * @date 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("getYimiaoStorageData")
    @ResponseBody
    public Pagination getYimiaoStorageData() {
        Pagination page = new Pagination(this.getRequest());
        SysUser user = this.getSysUser();
        // TODO 涉及角色区分
        try {
            if(getSysUser().getUserType().equals(UserType.scqy.getKey())){
                page.getConditions().put("companyIdTb", JudgmentRole.judgmentRoleId(getSysUser()));
            }else if(getSysUser().getUserType().equals(UserType.jkzx.getKey())){
                page.getConditions().put("hospitalId", JudgmentRole.judgmentRoleId(getSysUser()));
            }
            page = yimiaoOrderdetailManager.getYimiaoRkData(page);
        } catch (Exception e) {
            log.error("Failed to getYimiaoStorageData", e);
        }
        return page;
    }
}