package com.hsnn.medstgmini.yimiao.controller;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/yimiaoCA")
public class CAController {
    protected static final String MODEL_PATH = "/yimiao/stdProduct/";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private ISysUser sysUser;

    public SysUser getUser() {
        return (SysUser) session.getAttribute(Constants.USERINFO);
    }

    /**
     * CA信息绑定页面
     * @return
     */
    @RequestMapping("/toCAList")
    public String toCompSelfDrugList() {
        return MODEL_PATH + "caList";
    }

    /**
     * 获取企业CA信息
     * @return
     */
    @RequestMapping("/getCAList")
    @ResponseBody
    public Pagination getCAList(){
        Pagination page = new Pagination(request);
        if(page.getConditions().get("IsBindCAInfo")!=null){
            if(page.getConditions().get("IsBindCAInfo").equals("1")){
                page.getConditions().put("isEmpty","0");
            }else if(page.getConditions().get("IsBindCAInfo").equals("0")){
                page.getConditions().put("notIsEmpty","1");
            }
        }
        page = sysUser.getCompanyUserData(page);
        return page;
    }
    @RequestMapping("/Bind")
    public String toBindCA(Model model){
        String userId = request.getParameter("userId");
        SysUser user = sysUser.findSysUserDataById(userId);
        model.addAttribute("user",user);
        return MODEL_PATH+"BindCA";
    }
    /**
     * 绑定企业CA信息
     * @return
     */
    @RequestMapping("/bindCAData")
    @ResponseBody
    public Pagination bindCAData(String id,String serialnumber){
        Pagination page = new Pagination(request);
        page.getConditions().put("id",id);
        page.getConditions().put("base64Value",serialnumber);
        try{
            if(sysUser.toBindCAData(page)==0){
                SysUser user = sysUser.getUserBySerialnumber(serialnumber);
                page.setSuccess(false);
                page.setMsg("绑定失败，已存在相同CA序列号,已绑定的用户名称："+user.getName());
                return page;
            }else{
                page.setSuccess(true);
            }
        }catch (Exception e) {
            e.printStackTrace();
            page.setSuccess(false);
            page.setMsg("操作失败，请联系管理员！");
            return page;
        }

        return page;
    }
    
    /**
     * 清除企业CA信息
     * @return
     */
    @RequestMapping("/EmptyCA")
    @ResponseBody
    public Pagination emptyCA(){
        Pagination page = new Pagination(request);
        try{
            String userId = request.getParameter("userId");
            page.getConditions().put("userId",userId);
            sysUser.toEmptyCA(page);
            page.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
            page.setSuccess(false);
            page.setMsg("操作失败，请联系管理员！");
            return page;
        }

        return page;
    }

}

