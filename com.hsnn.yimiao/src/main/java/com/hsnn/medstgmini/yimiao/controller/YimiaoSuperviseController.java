package com.hsnn.medstgmini.yimiao.controller;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.service.DynamicSelectManager;
import com.hsnn.medstgmini.util.*;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import org.apache.commons.lang.StringUtils;
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
import java.net.URLDecoder;
import java.util.*;

/**
 * @author ZhuMingYuan
 * @date 2018/6/26
 */
@Controller
@RequestMapping(YimiaoSuperviseController.ACTION_PATH)
@PropertySource("classpath:system.properties")
public class YimiaoSuperviseController extends GenericController {

    private static final Logger log = Logger.getLogger(YimiaoSuperviseController.class);

    protected static final String ACTION_PATH="/yimiaoSupervise";

    protected static final String MODEL_PATH="/yimiao/yimiaoSupervise/";// TODO 修改

    @Autowired
    private YimiaoOrderdetailManager yimiaoOrderdetailManager;

    @Autowired
    private HttpServletRequest request;

    @Value("${system.province}")
    private String sysProvince;

    @Autowired
    private DynamicSelectManager selectManager;

    @Autowired
    private StdAreaManager dicAreaManager;
    /**
     * 总体采购情况页面跳转
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping("toYimiaoByAll")
    public String toYimiaoByAllJsp(Model model) {
        request.setAttribute("lastMonth", ParseDate.addMonth(new Date(), -7));
        request.setAttribute("lastMonth2", ParseDate.addMonth(new Date(), -1));
        return MODEL_PATH + "yimiaoByAll";
    }

    /**
     * 获取总体采购情况数据
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping(value ="/getDataByAll" )
    @ResponseBody
    public Pagination getDataByAll() {
        Pagination pagination = new Pagination(request);
        DbUtil.jsonToMap(request, pagination);

        pagination = yimiaoOrderdetailManager.getDataByAll(pagination);
        return pagination;
    }

    /**
     * 疾控中心采购情况页面跳转
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping("toYimiaoByJKCenter")
    public String toYimiaoByJKCenterJsp() {
        request.setAttribute("lastMonth", ParseDate.addMonth(new Date(), -7));
        request.setAttribute("lastMonth2", ParseDate.addMonth(new Date(), -1));
        return MODEL_PATH + "yimiaoByJKCenter";
    }

    /**
     * 获取疾控中心采购情况数据
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping(value ="/getDataByJKCenter" )
    @ResponseBody
    public Pagination getDataByJKCenter() {
        Pagination pagination = new Pagination(this.getRequest());
        DbUtil.jsonToMap(request, pagination);
        pagination = yimiaoOrderdetailManager.getDataByJKCenter(pagination);
        return pagination;
    }

    /**
     * 生产企业采购情况页面跳转
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping("toYimiaoBySC")
    public String toYimiaoBySCJsp() {
        request.setAttribute("lastMonth", ParseDate.addMonth(new Date(), -7));
        request.setAttribute("lastMonth2", ParseDate.addMonth(new Date(), -1));
        return MODEL_PATH + "yimiaoBySC";
    }

    /**
     * 获取生产企业采购情况数据
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping(value ="/getDataBySC" )
    @ResponseBody
    public Pagination getDataBySC() {
        Pagination pagination = new Pagination(this.getRequest());
        DbUtil.jsonToMap(request, pagination);
        pagination = yimiaoOrderdetailManager.getDataBySC(pagination);
        return pagination;
    }

    /**
     * 配送企业采购情况页面跳转
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping("toYimiaoByPS")
    public String toYimiaoByPSJsp() {
        request.setAttribute("lastMonth", ParseDate.addMonth(new Date(), -7));
        request.setAttribute("lastMonth2", ParseDate.addMonth(new Date(), -1));
        return MODEL_PATH + "yimiaoByPS";
    }

    /**
     * 获取配送企业采购情况数据
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping(value ="/getDataByPS" )
    @ResponseBody
    public Pagination getDataByPS() {
        Pagination pagination = new Pagination(this.getRequest());
        DbUtil.jsonToMap(request, pagination);
        pagination = yimiaoOrderdetailManager.getDataByPS(pagination);
        return pagination;
    }

    /**
     * 疫苗采购情况页面跳转
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping("toYimiaoBySelf")
    public String toYimiaoBySelfJsp() {
        request.setAttribute("lastMonth", ParseDate.addMonth(new Date(), -7));
        request.setAttribute("lastMonth2", ParseDate.addMonth(new Date(), -1));
        return MODEL_PATH + "yimiaoBySelf";
    }

    /**
     * 获取疫苗采购情况数据
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping(value ="/getDataBySelf" )
    @ResponseBody
    public Pagination getDataBySelf() {
        Pagination pagination = new Pagination(this.getRequest());
        DbUtil.jsonToMap(request, pagination);
        pagination = yimiaoOrderdetailManager.getDataBySelf(pagination);
        return pagination;
    }

    /**
     * @category 总体采购情况跳转
     * @date 2015年12月1日10:18:44
     * @return
     */
    @RequestMapping("/toAnaByAllTz")
    public String toAnaByAllTz() {
        String type = request.getParameter("type");
        request.setAttribute("sysAreaId", sysProvince);
        request.setAttribute("province", sysProvince);
        StdArea area = dicAreaManager.getAreaByAreaId(sysProvince);
        request.setAttribute("provinceName", area.getAreaName());
        request.setAttribute("dateType", request.getParameter("dateType"));
        request.setAttribute("date", request.getParameter("date"));
        request.setAttribute("total", request.getParameter("total"));
        request.setAttribute("del", request.getParameter("del"));
        request.setAttribute("recp", request.getParameter("recp"));
        request.setAttribute("type", type);
        String url = "";
        //type 1医疗机构2药品3配送企业4生产企业
        if("1".equals(type)) {
            url = MODEL_PATH + "anaByAllTzHosp";
        }else if("2".equals(type)) {
            url = MODEL_PATH + "anaByAllTzDrug";
        }else if("3".equals(type)) {
            url = MODEL_PATH + "anaByAllTzDel";
        }else if("4".equals(type)) {
            url = MODEL_PATH + "anaByAllTzProd";
        }
        return url;
    }

    /**
     * 获取详情数据
     * @author ZhuMingYuan
     * @date 2018/6/26
     * @param
     * @return
     */
    @RequestMapping(value ="/getAnaByAllTz" )
    @ResponseBody
    public Pagination getAnaByAllTz() {
        Pagination pagination = new Pagination(request);
        DbUtil.jsonToMap(request, pagination);

        String type = request.getParameter("type");
        pagination.getConditions().put("type",Integer.valueOf(type));
        pagination = yimiaoOrderdetailManager.getAnaByAllTz(pagination);
        return pagination;
    }
    /**
     * @category 疾控中心采购情况跳转
     * @return
     */
    @RequestMapping("/toAnaByAreaTzs")
    public String toAnaByAreaTzs(String hospCode) throws UnsupportedEncodingException {
        String type = request.getParameter("type");
        request.setAttribute("dateType", request.getParameter("dateType"));
        request.setAttribute("date", request.getParameter("date"));
        String hospName = new String(request.getParameter("hospName"));
        request.setAttribute("hospName",hospName);
        request.setAttribute("hospCode", hospCode);
        request.setAttribute("totalamount", request.getParameter("totalamount"));
        request.setAttribute("delamount", request.getParameter("delamount"));
        request.setAttribute("recpamount", request.getParameter("recpamount"));
        request.setAttribute("type", type);
        String url = "";
        //type 1医疗机构2药品3配送企业4生产企业
        if("2".equals(type)) {
            url = MODEL_PATH + "anaByAreaTzDrugs";
        }else if("3".equals(type)) {
            url = MODEL_PATH + "anaByAreaTzDels";
        }else if("4".equals(type)) {
            url = MODEL_PATH + "anaByAreaTzProds";
        }
        return url;
    }

    @RequestMapping("getAnaHospTotal")
    @ResponseBody
    public Pagination getAnaHospTotal(){
        Pagination page = new Pagination(request);
        DbUtil.jsonToMap(request, page);
        try {
            page = yimiaoOrderdetailManager.getAnaHospdruginfoTotal(page);
            page.setSuccess(true);
        } catch (Exception e) {
            page.setSuccess(false);
            e.printStackTrace();
        }
        return page;
    }

    /**
     * @category 生产企业采购情况跳转
     * @date 2015年12月1日10:18:44
     * @return
     */
    @RequestMapping("/toAnaByProdcompTz")
    public String toAnaByProdcompTz() {
        String type = request.getParameter("type");
        request.setAttribute("dateType", request.getParameter("dateType"));
        request.setAttribute("date", request.getParameter("date"));
        request.setAttribute("total", request.getParameter("total"));
        request.setAttribute("delA", request.getParameter("delA"));
        request.setAttribute("recpA", request.getParameter("recpA"));
        request.setAttribute("prodName", request.getParameter("prodName"));
        request.setAttribute("prodCode", request.getParameter("prodCode"));
        request.setAttribute("type", type);
        String url = "";
        //type 1医疗机构2药品3配送企业4地区
        if("1".equals(type)) {
            url = MODEL_PATH + "anaByProdcompTzHosp";
        }else if("2".equals(type)) {
            url = MODEL_PATH + "anaByProdcompTzDrug";
        }else if("3".equals(type)) {
            url = MODEL_PATH + "anaByProdcompTzDel";
        }
        return url;
    }

    /**
     * @category 生产企业采购情况跳转
     * @return Pagination
     */
    @ResponseBody
    @RequestMapping("/getAnaByProdcompTz")
    public Pagination getAnaByProdcompTz() {
        Pagination page = new Pagination(request);
        try {
            DbUtil.jsonToMap(request, page);
            page = yimiaoOrderdetailManager.getAnaByProdcompTz(page);
            page.setSuccess(true);
        } catch (Exception e) {
            log.error("",e);
            page.setSuccess(false);
        }
        return page;
    }

    /**
     * @category 配送企业统计二级跳转
     * @date 2015年12月1日10:55:55
     * @author wangbing
     * @return
     */
    @RequestMapping("/toAnaByCompTz")
    public String toAnaByCompTz() {
        String type = request.getParameter("type");
        request.setAttribute("prodCode", request.getParameter("delCompCode"));
        request.setAttribute("dateType", request.getParameter("dateType"));
        request.setAttribute("date", request.getParameter("date"));
        request.setAttribute("delCompName", request.getParameter("delCompName"));
        request.setAttribute("total", request.getParameter("total"));
        request.setAttribute("del", request.getParameter("del"));
        request.setAttribute("recp", request.getParameter("recp"));
        request.setAttribute("type", type);
        String url = "";
        //type 1医疗机构2药品3地区4生产企业
        if("1".equals(type)) {
            url = MODEL_PATH + "anaDelByHospWithMon";
        }else if("2".equals(type)) {
            url = MODEL_PATH + "anaDelByDrugWithMon";
        }else if("4".equals(type)) {
            url = MODEL_PATH + "anaDelByProdCompWithMon";
        }
        return url;
    }

    /**
     * @category 配送企业采购情况跳转
     * @return Pagination
     */
    @ResponseBody
    @RequestMapping("/getAnaDelWithMon")
    public Pagination getAnaDelWithMon() {
        Pagination page = new Pagination(request);
        try {
            DbUtil.jsonToMap(request, page);
            page = yimiaoOrderdetailManager.getAnaDelWithMon(page);
            page.setSuccess(true);
        } catch (Exception e) {
            log.error("",e);
            page.setSuccess(false);
        }
        return page;
    }

    /**
     *
     *@category 药品采购情况->跳转配送企业采购情况
     *@param
     *@return String
     */
    @RequestMapping("/toAnaDruginfoTotal")
    public String toAnaDeldruginfoTotal(String totalAmount,String drugCode,String drugName,String date,String time){
        request.setAttribute("totalAmount", totalAmount );
        request.setAttribute("drugCode", drugCode );
        request.setAttribute("drugName",drugName);
        request.setAttribute("date",date);
        request.setAttribute("time",time);
        String timeName = time.equals("mon")?"月度":(time.equals("sea")?"季度":(time.equals("year")?"年度":""));
        request.setAttribute("timeName",timeName);
        request.setAttribute("delAmount", request.getParameter("delAmount"));
        request.setAttribute("recpAmount", request.getParameter("recpAmount"));
        String type = request.getParameter("type");
        request.setAttribute("type",type);
        String url = "";
        //type 1医疗机构2药品3地区4生产企业
        if("1".equals(type)) {
            url = MODEL_PATH + "anaHospdruginfoTotalMon";
        }else if("3".equals(type)) {
            url = MODEL_PATH + "anaDeldruginfoTotal";
        }
        return url;
    }

    @RequestMapping("getAnaHospTotalMon")
    @ResponseBody
    public Pagination getAnaHospTotalMon(){
        Pagination page = new Pagination(request);
        DbUtil.jsonToMap(request, page);
        try {
            page = yimiaoOrderdetailManager.getAnaHospTotalMon(page);
            page.setSuccess(true);
        } catch (Exception e) {
            page.setSuccess(false);
            e.printStackTrace();
        }
        return page;
    }

    /**
     * 月度采购汇总列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportExcelWithAllMon")
    public void exportExcelWithAllMon(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        List<String> titles = Arrays.asList(
                "月度",
                "采购金额(元)",
                "入库金额(元)",
                "入库率(%)"
        );
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataBy(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("月度采购汇总列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"月度采购汇总列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

    /**
     * 疾控中心月度采购汇总列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportExcelWithJK")
    public void exportExcelWithJK(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        List<String> titles = Arrays.asList(
                "月度",
                "疾控中心",
                "采购金额(元)",
                "入库金额(元)",
                "入库率(%)"
        );
        pagination.getConditions().put("type",1);//0.按医院分类
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataBy(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("疾控中心月度采购汇总列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"疾控中心月度采购汇总列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

    /**
     * 生产企业月度采购汇总列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportExcelWithSC")
    public void exportExcelWithSC(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        List<String> titles = Arrays.asList(
                "月度",
                "生产企业",
                "采购金额(元)",
                "入库金额(元)",
                "入库率(%)"
        );
        pagination.getConditions().put("type",2);//0.按生产企业分类
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataBy(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("生产企业月度采购汇总列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"生产企业月度采购汇总列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

    /**
     * 配送企业月度采购汇总列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportExcelWithPS")
    public void exportExcelWithPS(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        List<String> titles = Arrays.asList(
                "月度",
                "配送企业",
                "采购金额(元)",
                "入库金额(元)",
                "入库率(%)"
        );
        pagination.getConditions().put("type",3);//0.按配送企业分类
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataBy(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("配送企业月度采购汇总列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"配送企业月度采购汇总列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

    /**
     * 疫苗月度采购汇总列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportExcelWithSelf")
    public void exportExcelWithSelf(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        List<String> titles = Arrays.asList(
                "月度",
                "产品编号",
                "疫苗通用名",
                "产品名称",
                "制剂规格（申报剂型）",
                "生产企业（投标企业）",
                "采购金额(元)",
                "入库金额(元)",
                "入库率(%)"
        );
        pagination.getConditions().put("type",4);//0.按疫苗分类
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataBy(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("疫苗月度采购汇总列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"疫苗月度采购汇总列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

    /**
     * 总体疫苗采购汇总列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportExcelByAllTz")
    public void exportExcelByAllTz(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        String type = pagination.getConditions().get("type").toString();
        List<String> titles = new ArrayList<>();
        if("1".equals(type)){ //医院
            titles = Arrays.asList(
                    "疾控中心",
                    "所属地区",
                    "采购金额(元)",
                    "入库金额(元)",
                    "入库率(%)"
            );
        }else if("2".equals(type)){ //药品
            titles = Arrays.asList(
                    "产品编号",
                    "疫苗通用名",
                    "产品名称",
                    "制剂规格（申报剂型）",
                    "生产企业（投标企业）",
                    "采购金额(元)",
                    "入库金额(元)",
                    "入库率(%)"
            );
        }else if("3".equals(type)){
            titles = Arrays.asList(
                    "配送企业",
                    "采购金额(元)",
                    "入库金额(元)",
                    "入库率(%)"
            );
        }else{
            titles = Arrays.asList(
                    "生产企业",
                    "采购金额(元)",
                    "入库金额(元)",
                    "入库率(%)"
            );
        }

        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.exportExcelByAllTz(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            String name = pagination.getConditions().get("date").toString() + "总体采购汇总列表.xls";
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"总体采购汇总列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

}
