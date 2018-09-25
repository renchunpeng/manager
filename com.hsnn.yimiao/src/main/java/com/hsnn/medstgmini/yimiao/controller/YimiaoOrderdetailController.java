package com.hsnn.medstgmini.yimiao.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.std.service.StdAreaManager;
import com.hsnn.medstgmini.base.std.service.StdHospitalManager;
import com.hsnn.medstgmini.base.std.service.StdManageOrgManager;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.controller.GenericController;
import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.*;
import com.hsnn.medstgmini.util.enums.ReturnOrderStatus;
import com.hsnn.medstgmini.util.validate.ValidateUtil;
import com.hsnn.medstgmini.yimiao.form.YimiaoOrderdetailForm;
import com.hsnn.medstgmini.yimiao.model.YimiaoOrderdetail;
import com.hsnn.medstgmini.yimiao.model.YimiaoProcurecatalog;
import com.hsnn.medstgmini.yimiao.service.YimiaoDelrelationshipManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoOrderdetailRetManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoProcurecatalogManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(YimiaoOrderdetailController.ACTION_PATH)
public class YimiaoOrderdetailController extends GenericController {
	private static final Logger log = Logger.getLogger(YimiaoOrderdetailController.class);
	protected static final String ACTION_PATH="/yimiaoOrderdetail";
	protected static final String MODEL_PATH="/yimiao/yimiaoOrderdetail/";// TODO 修改
	@Autowired
	private YimiaoOrderdetailManager yimiaoOrderdetailManager;
	@Autowired
	private YimiaoOrderdetailRetManager yimiaoOrderdetailRetManager;
	@Autowired
	private YimiaoDelrelationshipManager yimiaoDelrelationshipManager;
	@Autowired
	private StdHospitalManager stdHospitalManager;
	@Autowired
	private StdManageOrgManager stdManageOrgManager;
	@Autowired
	private StdAreaManager dicAreaManager;
	@Autowired
	private YimiaoProcurecatalogManager yimiaoProcurecatalogManager;
	@Value("${system.province}")
	private String sysProvince;

	/**
	 * 跳转生产企业未完成采购订单页面
	 * 
	 * @return
	 */
	@RequestMapping("toYimiaoOrderList.html")
	public String toYimiaoOrderList(String judgment) {
		this.getRequest().setAttribute("judgment", judgment);
		this.getRequest().setAttribute("companyNamePs",JudgmentRole.judgmentRole(getSysUser()));
		return MODEL_PATH + "yimiaoOrderList";
	}
	
	
	@RequestMapping("tostatisticsList.html")
	public String tostatisticsList(Model model,String judgment) throws UnsupportedEncodingException {
		
		String productNameGet = this.getRequest().getParameter("productName");
		String productName = null;
		if (productNameGet != null) {
			productName = new String(productNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String hospitalNameGet = this.getRequest().getParameter("hospitalName");
		String hospitalName = null;
		if (hospitalNameGet != null) {
			hospitalName = new String(hospitalNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String startTime = this.getRequest().getParameter("startTime");
		String endTime = this.getRequest().getParameter("endTime");
		String area2 = this.getRequest().getParameter("area2");
		String area3 = this.getRequest().getParameter("area3");
		Map<String, String> areaMap = dicAreaManager.getAreaIdNameMap();
		
		SysUser user = this.getSysUser();
		StdManageOrg smo=stdManageOrgManager.getById(user.getOrgId());
		String areaId = smo.getAreaId();
		StdArea stdArea = dicAreaManager.getAreaByAreaId(areaId);
		model.addAttribute("areaId", areaId);
		model.addAttribute("province", sysProvince);
		model.addAttribute("areaIdParent", stdArea.getFatherId());
		if (StringUtils.isNotBlank(areaId)) {
			if (areaId.length() == 6) {
				String sheng = areaId.substring(2, 6);
				String shi = areaId.substring(4, 6);
				if("0000".equals(sheng)){
					model.addAttribute("areaIdpd", 1);
					model.addAttribute("areaId", areaId);
					model.addAttribute("province", sysProvince);
					model.addAttribute("areaIdParent", stdArea.getFatherId());
				}else if("00".equals(shi)) {
					model.addAttribute("areaIdpd", 2);
					model.addAttribute("areaIdParent", areaId);
					model.addAttribute("province", sysProvince);
					area2 = areaId;
				}else{
					model.addAttribute("areaIdpd", 3);
					model.addAttribute("areaId", areaId);
					model.addAttribute("province", sysProvince);
					model.addAttribute("areaIdParent", stdArea.getFatherId());
					area2 = areaId.substring(0,4)+"00";
					area3 = areaId;
				}
			}
		}
		
		model.addAttribute("productName",productName);
	    model.addAttribute("hospitalName",hospitalName);
	    model.addAttribute("startTime",startTime);
	    model.addAttribute("endTime",endTime);
	    model.addAttribute("area2Id",area2);
	    model.addAttribute("area2Name",areaMap.get(area2));
	    model.addAttribute("area3Id",area3);
	    model.addAttribute("area3Name",areaMap.get(area3));
		return MODEL_PATH + "statisticsList";
	}
	
	@RequestMapping("tostatisticsListTwo.html")
	public String statisticsListTwo(Model model,String judgment) throws UnsupportedEncodingException {
		String productNameGet = this.getRequest().getParameter("productName");
		String productName = null;
		if (productNameGet != null) {
			productName = new String(productNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String hospitalNameGet = this.getRequest().getParameter("hospitalName");
		String hospitalName = null;
		if (hospitalNameGet != null) {
			hospitalName = new String(hospitalNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String outlookGet = this.getRequest().getParameter("outlook");
		String outlook = null;
		if (outlookGet != null) {
			outlook = new String(outlookGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String startTime = this.getRequest().getParameter("startTime");
		String endTime = this.getRequest().getParameter("endTime");
		String area1 = this.getRequest().getParameter("area1");
		String area2 = this.getRequest().getParameter("area2");
		String area3 = this.getRequest().getParameter("area3");
		Map<String, String> areaMap = dicAreaManager.getAreaIdNameMap();
		model.addAttribute("productName",productName);
	    model.addAttribute("hospitalName",hospitalName);
	    model.addAttribute("outlook",outlook);
	    model.addAttribute("startTime",startTime);
	    model.addAttribute("endTime",endTime);
	    model.addAttribute("area1Id",area1);
	    model.addAttribute("area1Name",areaMap.get(area1));
	    model.addAttribute("area2Id",area2);
	    model.addAttribute("area2Name",areaMap.get(area2));
	    model.addAttribute("area3Id",area3);
	    model.addAttribute("area3Name",areaMap.get(area3));
		return MODEL_PATH + "statisticsListTwo";
	}
	
	@RequestMapping("tostatisticsListThree.html")
	public String statisticsListThree(Model model,String judgment) throws UnsupportedEncodingException {
		String productNameGet = this.getRequest().getParameter("productName");
		String productName = null;
		if (productNameGet != null) {
			productName = new String(productNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String hospitalNameGet = this.getRequest().getParameter("hospitalName");
		String hospitalName = null;
		if (hospitalNameGet != null) {
			hospitalName = new String(hospitalNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String outlookGet = this.getRequest().getParameter("outlook");
		String outlook = null;
		if (outlookGet != null) {
			outlook = new String(outlookGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String startTime = this.getRequest().getParameter("startTime");
		String endTime = this.getRequest().getParameter("endTime");
		String area1 = this.getRequest().getParameter("area1");
		String area2 = this.getRequest().getParameter("area2");
		String area3 = this.getRequest().getParameter("area3");
		Map<String, String> areaMap = dicAreaManager.getAreaIdNameMap();
		model.addAttribute("productName",productName);
	    model.addAttribute("hospitalName",hospitalName);
	    model.addAttribute("outlook",outlook);
	    model.addAttribute("startTime",startTime);
	    model.addAttribute("endTime",endTime);
	    model.addAttribute("area1Id",area1);
	    model.addAttribute("area1Name",areaMap.get(area1));
	    model.addAttribute("area2Id",area2);
	    model.addAttribute("area2Name",areaMap.get(area2));
	    model.addAttribute("area3Id",area3);
	    model.addAttribute("area3Name",areaMap.get(area3));
		return MODEL_PATH + "statisticsListThree";
	}
	
	@RequestMapping("tostatisticsListProvince.html")
	public String tostatisticsListProvince(Model model,String judgment) throws UnsupportedEncodingException {
		String productNameGet = this.getRequest().getParameter("productName");
		String productName = null;
		if (productNameGet != null) {
			productName = new String(productNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String hospitalNameGet = this.getRequest().getParameter("hospitalName");
		String hospitalName = null;
		if (hospitalNameGet != null) {
			hospitalName = new String(hospitalNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String startTime = this.getRequest().getParameter("startTime");
		String endTime = this.getRequest().getParameter("endTime");
		String area2 = this.getRequest().getParameter("area2");
		String area3 = this.getRequest().getParameter("area3");
		Map<String, String> areaMap = dicAreaManager.getAreaIdNameMap();
		
		SysUser user = this.getSysUser();
		StdManageOrg smo=stdManageOrgManager.getById(user.getOrgId());
		String areaId = smo.getAreaId();
		StdArea stdArea = dicAreaManager.getAreaByAreaId(areaId);
		model.addAttribute("areaId", areaId);
		model.addAttribute("province", sysProvince);
		model.addAttribute("areaIdParent", stdArea.getFatherId());
		if (StringUtils.isNotBlank(areaId)) {
			if (areaId.length() == 6) {
				String sheng = areaId.substring(2, 6);
				String shi = areaId.substring(4, 6);
				if("0000".equals(sheng)){
					model.addAttribute("areaIdpd", 1);
				}else if("00".equals(shi)) {
					model.addAttribute("areaIdpd", 2);
					if ("".equals(area2) || area2 == null) {
						area2 = areaId;
					}
				}else{
					model.addAttribute("areaIdpd", 3);
					if ("".equals(area3) || area3 == null) {
						area3 = areaId;
					}
					if ("".equals(area2) || area2 == null) {
						area2 = areaId.substring(0, 4) + "00";
					}
				}
			}
		}
	
		model.addAttribute("productName",productName);
	    model.addAttribute("hospitalName",hospitalName);
	    model.addAttribute("startTime",startTime);
	    model.addAttribute("endTime",endTime);
	    model.addAttribute("area2Id",area2);
	    model.addAttribute("area2Name",areaMap.get(area2));
	    model.addAttribute("area3Id",area3);
	    model.addAttribute("area3Name",areaMap.get(area3));
		return MODEL_PATH + "statisticsListProvince";
	}
	
	@RequestMapping("tostatisticsListProvinceTwo.html")
	public String tostatisticsListProvinceTwo(Model model,String judgment) throws UnsupportedEncodingException {
		String productNameGet = this.getRequest().getParameter("productName");
		/*String productName = null;
		if (productNameGet != null) {
			productName = new String(productNameGet.getBytes("iso-8859-1"), "UTF-8");
		}*/
		String hospitalNameGet = this.getRequest().getParameter("hospitalName");
		/*String hospitalName = null;
		if (hospitalNameGet != null) {
			hospitalName = new String(hospitalNameGet.getBytes("iso-8859-1"), "UTF-8");
		}*/
		String outlookGet = this.getRequest().getParameter("outlook");
		/*String outlook = null;
		if (outlookGet != null) {
			outlook = new String(outlookGet.getBytes("iso-8859-1"), "UTF-8");
		}*/
		String startTime = this.getRequest().getParameter("startTime");
		String endTime = this.getRequest().getParameter("endTime");
		String area1 = this.getRequest().getParameter("area1");
		String area2 = this.getRequest().getParameter("area2");
		String area3 = this.getRequest().getParameter("area3");
		Map<String, String> areaMap = dicAreaManager.getAreaIdNameMap();
		model.addAttribute("productName",productNameGet);
	    model.addAttribute("hospitalName",hospitalNameGet);
	    model.addAttribute("outlook",outlookGet);
	    model.addAttribute("startTime",startTime);
	    model.addAttribute("endTime",endTime);
	    model.addAttribute("area1Id",area1);
	    model.addAttribute("area1Name",areaMap.get(area1));
	    model.addAttribute("area2Id",area2);
	    model.addAttribute("area2Name",areaMap.get(area2));
	    model.addAttribute("area3Id",area3);
	    model.addAttribute("area3Name",areaMap.get(area3));
		return MODEL_PATH + "statisticsListProvinceTwo";
	}
	
	@RequestMapping("tostatisticsListProvinceThree.html")
	public String tostatisticsListProvinceThree(Model model,String judgment) throws UnsupportedEncodingException {
		String productNameGet = this.getRequest().getParameter("productName");
		String productName = null;
		if (productNameGet != null) {
			productName = new String(productNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String hospitalNameGet = this.getRequest().getParameter("hospitalName");
		String hospitalName = null;
		if (hospitalNameGet != null) {
			hospitalName = new String(hospitalNameGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String outlookGet = this.getRequest().getParameter("outlook");
		String outlook = null;
		if (outlookGet != null) {
			outlook = new String(outlookGet.getBytes("iso-8859-1"), "UTF-8");
		}
		String startTime = this.getRequest().getParameter("startTime");
		String endTime = this.getRequest().getParameter("endTime");
		String area1 = this.getRequest().getParameter("area1");
		String area2 = this.getRequest().getParameter("area2");
		String area3 = this.getRequest().getParameter("area3");
		Map<String, String> areaMap = dicAreaManager.getAreaIdNameMap();
		model.addAttribute("productName",productName);
	    model.addAttribute("hospitalName",hospitalName);
	    model.addAttribute("outlook",outlook);
	    model.addAttribute("startTime",startTime);
	    model.addAttribute("endTime",endTime);
	    model.addAttribute("area1Id",area1);
	    model.addAttribute("area1Name",areaMap.get(area1));
	    model.addAttribute("area2Id",area2);
	    model.addAttribute("area2Name",areaMap.get(area2));
	    model.addAttribute("area3Id",area3);
	    model.addAttribute("area3Name",areaMap.get(area3));
		return MODEL_PATH + "statisticsListProvinceThree";
	}
	
	@RequestMapping("getStatisticsOne.html")
	@ResponseBody
	public Pagination getStatisticsOne() {
		Pagination page = new Pagination(this.getRequest());
		
		String areaId = this.getRequest().getParameter("areaId");
		String areaType = this.getRequest().getParameter("areaType");
		if ("2".equals(areaType) || "1".equals(areaType)) {
			areaId = areaId.replaceAll("0*$", "");
		}
		
		page.getConditions().put("areaId", areaId);
		// TODO 涉及角色区分
		try {
			page = yimiaoOrderdetailManager.getStatisticsOne(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}
	
	
	@RequestMapping("getStatisticsTwo.html")
	@ResponseBody
	public Pagination getStatisticsTwo() {
		Pagination page = new Pagination(this.getRequest());
		
		String provId = this.getRequest().getParameter("area1");
		String cityId = this.getRequest().getParameter("area2");
		String townId = this.getRequest().getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
		} else {
			areaId = "";
		}
		page.getConditions().put("areaId", areaId);
		// TODO 涉及角色区分
		try {
			page = yimiaoOrderdetailManager.getStatisticsTwo(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}
	
	@RequestMapping("getStatisticsThree.html")
	@ResponseBody
	public Pagination getStatisticsThree() {
		Pagination page = new Pagination(this.getRequest());
		
		String provId = this.getRequest().getParameter("area1");
		String cityId = this.getRequest().getParameter("area2");
		String townId = this.getRequest().getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
		} else {
			areaId = "";
		}
		page.getConditions().put("areaId", areaId);
		// TODO 涉及角色区分
		try {
			page = yimiaoOrderdetailManager.getStatisticsThree(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	/**
	 * 获取生产企业未完成采购订单
	 * 
	 * @return
	 */
	@RequestMapping("getYimiaoOrderData")
	@ResponseBody
	public Pagination getYimiaoOrderData() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("companyIdTb", user.getOrgId());
			if(page.getConditions().get("confirmState")!=null){
				String a = (String) page.getConditions().get("confirmState");
				if(a.equals("a")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("bufen", 1);
				}else if(a.equals("b")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("wancheng", 1);
				}else if(a.equals("1")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("Psing", 1);
				}
			}
			page = yimiaoOrderdetailManager.getAllList(page);
			
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailManager.getAllCountList(page.getConditions());
			if(data!=null){			
				String purchaseCount =data.get("purchaseCount").toString();
				String purchaseAmount =data.get("purchaseAmount").toString();
				String totalDistributeCount =data.get("totalwarehouseCount").toString();
				String totalDistributeAmount =data.get("totalwarehouseAmount").toString();
				String compRatio = new BigDecimal(data.get("compRatio").toString()).stripTrailingZeros().toPlainString();
				data.put("purchaseCount", purchaseCount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseCount, 3)));
				data.put("purchaseAmount", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount, 3)));
				data.put("totalDistributeCount",totalDistributeCount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalDistributeCount, 3)));
				data.put("totalDistributeAmount", totalDistributeAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalDistributeAmount, 3)));
				data.put("compRatio", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio, 4)));
				page.setMsg("未完成采购记录  [采购数量:"+data.get("purchaseCount")
						+",采购金额:"+data.get("purchaseAmount")+",到货数量:"
						+data.get("totalwarehouseCount")+",到货金额:"+data.get("totalwarehouseAmount")
						+",平均完成率（%）:"+data.get("compRatio")+"]");							
			}else{
				page.setMsg("未完成采购记录  [采购数量:0,采购金额:0.00,到货数量:0,到货金额:0.00,平均完成率（%）:0.00]");
				
			}
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	/**
     * 打印预览页面
	 * @author ZhuMingYuan
	 * @date 2018/5/16
	 * @param
	 * @return
	 */
    @RequestMapping("toYimiaoOrderPrint")
    public String toYimiaoOrderPrint(Model model) {
        Pagination page = new Pagination(this.getRequest());
        SysUser user = this.getSysUser();
        page.getConditions().put("companyIdTb", user.getOrgId());
        page = yimiaoOrderdetailManager.getAllList(page);
        List<YimiaoOrderdetail> yimiaoOrderdetailList = (List<YimiaoOrderdetail>) page.getRows();
        model.addAttribute("orderDetailList",yimiaoOrderdetailList);
        return MODEL_PATH + "yimiaoOrderPrint";
    }
	
	/**
	 * 跳转医疗机构未完成采购订单页面
	 * 
	 * @return
	 */
	@RequestMapping("toYimiaoHospitalOrderList.html")
	public String toYimiaoHospitalOrderList() {
		return MODEL_PATH + "yimiaoHospitalOrderList";
	}
	@RequestMapping("toYimiaoHospitalOrderListret.html")
	public String toYimiaoHospitalOrderListret() {
		return MODEL_PATH + "yimiaoHospitalOrderListret";
	}

	/**
	 * 获取医疗机构未完成采购订单
	 * 
	 * @return
	 */
	@RequestMapping("getYimiaoHospitalOrderData")
	@ResponseBody
	public Pagination getYimiaoHospitalOrderData() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("hospitalId", user.getOrgId());
			page = yimiaoOrderdetailManager.getYLAllList(page);
			
			
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailManager.getYLAllCountList(page.getConditions());
			if(data!=null){			
				String purchaseAmount =data.get("purchaseAmount").toString();
				String totalWarehouseAmount =data.get("totalWarehouseAmount").toString();
				String compRatio =new BigDecimal(data.get("compRatio").toString()).stripTrailingZeros().toPlainString();
				data.put("purchaseAmount", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount, 2)));
				data.put("totalWarehouseAmount", totalWarehouseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalWarehouseAmount, 2)));
				data.put("compRatio", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio, 2)));
				page.setMsg("未完成采购记录  [采购数量:"+data.get("purchaseCount")
						+",采购金额:"+data.get("purchaseAmount")+",到货数量:"
						+data.get("totalWarehouseCount")+",到货金额:"+data.get("totalWarehouseAmount")
						+",平均完成率（%）:"+data.get("compRatio")+"]");							
			}else{
				page.setMsg("未完成采购记录  [采购数量:0,采购金额:0.00,到货数量:0,到货金额:0.00,平均完成率（%）:0.00]");
				
			}
		} catch (Exception e) {
			log.error("Failed to getYimiaoHospitalOrderData", e);
		}
		return page;
	}
	@RequestMapping("getYimiaoHospitalOrderDataret")
	@ResponseBody
	public Pagination getYimiaoHospitalOrderDataret() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("hospitalId", user.getOrgId());

			page = yimiaoOrderdetailRetManager.getYLAllList(page);
			
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailRetManager.getYLAllCountList(page.getConditions());
			if(data!=null){			
				String amount1 =data.get("amount1").toString();
				String amount2 =data.get("amount2").toString();
				String radio =new BigDecimal(data.get("radio").toString()).stripTrailingZeros().toPlainString();
				data.put("amount1", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1, 2)));
				data.put("amount2", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2, 2)));
				data.put("radio", radio==null?"":new BigDecimal(ParseNumber.stringToFormat(radio, 2)));
				page.setMsg("未完成退货记录  [申请退货数量:"+data.get("count1")
						+",申请退货金额:"+data.get("amount1")+"]");
			}else{
				page.setMsg("未完成退货记录  [申请退货数量:0,申请退货金额:0.00]");
				
			}
			
		} catch (Exception e) {
			log.error("Failed to getYimiaoHospitalOrderData", e);
		}
		return page;
	}
	
	@RequestMapping("toList")
	public String toListJsp() {
		return MODEL_PATH + "list";
	}
	
	@RequestMapping("toWJWList")
	public String toWJWList() {
		return MODEL_PATH + "wjwList";
	}
	
	@RequestMapping("toSJKList")
	public String toSJKList() {
		return MODEL_PATH + "sjkList";
	}

	/**
	 * 跳转生产企业已完成采购订单页面
	 * 
	 * @return
	 */
	@RequestMapping("toYimiaoOrderOkList.html")
	public String toYimiaoOrderOkList() {
		return MODEL_PATH + "yimiaoOrderOkList";
	}

	/**
	 * 获取生产企业已完成采购订单
	 * 
	 * @return
	 */
	@RequestMapping("getYimiaoOrderOkData")
	@ResponseBody
	public Pagination getYimiaoOrderOkData() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("companyIdTb", user.getOrgId());
			if(page.getConditions().get("confirmState")!=null){
				String a = (String) page.getConditions().get("confirmState");
				if(a.equals("a")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("bufen", 1);
				}else if(a.equals("b")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("wancheng", 1);
				}else if(a.equals("1")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("Psing", 1);
				}
			}
			page = yimiaoOrderdetailManager.getOkList(page);
			
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailManager.getCountOkList(page.getConditions());
			if(data!=null){			
				String purchaseAmount =data.get("purchaseAmount").toString();
				String totalDistributeAmount =data.get("totalwarehouseAmount").toString();
				String compRatio = new BigDecimal(data.get("compRatio").toString()).stripTrailingZeros().toPlainString();
				data.put("purchaseAmount", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount, 2)));
				data.put("totalDistributeAmount", totalDistributeAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalDistributeAmount, 2)));
				data.put("compRatio", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio, 2)));
				page.setMsg("已完成采购记录  [采购数量:"+data.get("purchaseCount")
						+",采购金额:"+data.get("purchaseAmount")+",到货数量:"
						+data.get("totalwarehouseCount")+",到货金额:"+data.get("totalwarehouseAmount")
						+",平均完成率（%）:"+data.get("compRatio")+"]");							
			}else{
				page.setMsg("已完成采购记录  [采购数量:0,采购金额:0.00,到货数量:0,到货金额:0,平均完成率（%）:0.00]");
				
			}
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderOkData", e);
		}
		return page;
	}
	
	/**
	 * 跳转医疗机构已完成采购订单页面
	 * 
	 * @return
	 */
	@RequestMapping("toYimiaoHospitalOrderOkList.html")
	public String toYimiaoHospitalOrderOkList() {
		return MODEL_PATH + "yimiaoHospitalOrderOkList";
	}
	
	@RequestMapping("toYimiaoHospitalOrderOkListret.html")
	public String toYimiaoHospitalOrderOkListret() {
		return MODEL_PATH + "yimiaoHospitalOrderOkListret";
	}
	/**
	 * 获取医疗机构已完成采购订单
	 * 
	 * @return
	 */
	@RequestMapping("getYimiaoHospitalOrderOkData")
	@ResponseBody
	public Pagination getYimiaoHospitalOrderOkData() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("hospitalId", user.getOrgId());
			if(page.getConditions().get("confirmState")!=null){
				String a = (String) page.getConditions().get("confirmState");
				if(a.equals("a")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("bufen", 1);
				}else if(a.equals("b")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("wancheng", 1);
				}else if(a.equals("1")){
					page.getConditions().put("confirmState", 1);
					page.getConditions().put("Psing", 1);
				}
			}
			page = yimiaoOrderdetailManager.getYLOkList(page);
			
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailManager.getYLOkCountList(page.getConditions());
			if(data!=null){			
				String purchaseAmount =data.get("purchaseAmount").toString();
				String totalWarehouseAmount =data.get("totalWarehouseAmount").toString();
				String compRatio = new BigDecimal(data.get("compRatio").toString()).stripTrailingZeros().toPlainString();
				data.put("purchaseAmount", purchaseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(purchaseAmount, 2)));
				data.put("totalWarehouseAmount", totalWarehouseAmount==null?"":new BigDecimal(ParseNumber.stringToFormat(totalWarehouseAmount, 2)));
				data.put("compRatio", compRatio==null?"":new BigDecimal(ParseNumber.stringToFormat(compRatio, 2)));
				page.setMsg("已完成采购记录  [采购数量:"+data.get("purchaseCount")
						+",采购金额:"+data.get("purchaseAmount")+",到货数量:"
						+data.get("totalWarehouseCount")+",到货金额:"+data.get("totalWarehouseAmount")
						+",平均完成率（%）:"+data.get("compRatio")+"]");							
			}else{
				page.setMsg("已完成采购记录  [采购数量:0,采购金额:0.00,到货数量:,到货金额:0.00,平均完成率（%）:0.00]");
				
			}
		} catch (Exception e) {
			log.error("Failed to getYimiaoHospitalOrderOkData", e);
		}
		return page;
	}
	@RequestMapping("getYimiaoHospitalOrderOkDataret")
	@ResponseBody
	public Pagination getYimiaoHospitalOrderOkDataret() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("hospitalId", user.getOrgId());
			page = yimiaoOrderdetailRetManager.getYLOkList(page);
			
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailRetManager.getYLOkCountList(page.getConditions());
			if(data!=null){			
				String amount1 =data.get("amount1").toString();
				String amount2 =data.get("amount2").toString();
				String radio = new BigDecimal(data.get("radio").toString()).stripTrailingZeros().toPlainString();
				data.put("amount1", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1, 2)));
				data.put("amount2", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2, 2)));
				data.put("radio", radio==null?"":new BigDecimal(ParseNumber.stringToFormat(radio, 2)));
				page.setMsg("已完成退货记录  [申请退货数量:"+data.get("count1")
						+",申请退货金额:"+data.get("amount1")+",已完成退货数量:"
						+data.get("count2")+",已完成退货金额:"+data.get("amount2")
						+",平均完成率（%）:"+data.get("radio")+"]");							
			}else{
				page.setMsg("已完成退货记录  [申请退货数量:0,申请退货金额:0.00,已完成退货数量:0,已完成退货金额:0.00,平均完成率（%）:0.00]");
				
			}
			
		} catch (Exception e) {
			log.error("Failed to getYimiaoHospitalOrderOkData", e);
		}
		return page;
	}
	
	/**
	 * 跳转配送企业页面
	 * 
	 * @return
	 */
	@RequestMapping("toYimiaoPSList.html")
	public String toYimiaoPSList() {
		return MODEL_PATH + "yimiaoPSList";
	}

	/**
	 * 获取配送企业
	 * 
	 * @return
	 */
	@RequestMapping("getYimiaoPSData")
	@ResponseBody
	public Pagination getYimiaoPSData() {
		Pagination page = new Pagination(this.getRequest());
		SysUser user = this.getSysUser();
		// TODO 涉及角色区分
		try {
			page.getConditions().put("prodCompCode", user.getOrgId());
			page = yimiaoDelrelationshipManager.getYimiaoDelrelationshipList(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoPSData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoOrderdetailData")
	@ResponseBody
	public Pagination getYimiaoOrderdetailData() {
		Pagination pagination = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			SysUser user = this.getSysUser();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Object sdate = pagination.getConditions().get("starttime");
			Object edate = pagination.getConditions().get("endtime");
			if (sdate != null) {
				pagination.getConditions().put("starttime", formatter.parse(sdate.toString()));
				if (edate != null)
					pagination.getConditions().put("endtime", edate.toString());
			}
			if (UserType.scqy.getKey().equals(user.getUserType())) {
				pagination.getConditions().put("companyIdPs", user.getOrgId());
				pagination = yimiaoOrderdetailManager.getList(pagination);
			} else if (UserType.jkzx.getKey().equals(user.getUserType())) {
				//医疗机构
				pagination = yimiaoOrderdetailManager.getList(pagination);
			}else if (UserType.wsj.getKey().equals(user.getUserType())) {
				//卫计委
				StdManageOrg smo=stdManageOrgManager.getById(user.getOrgId());
				String areaId = smo.getAreaId();
				pagination.getConditions().put("areaId", areaId.replaceAll("0*$", ""));
				if(pagination.getConditions().get("confirmState")!=null){
					String a = (String) pagination.getConditions().get("confirmState");
					if(a.equals("a")){
						pagination.getConditions().put("confirmState", 1);
						pagination.getConditions().put("bufen", 1);
					}else if(a.equals("b")){
						pagination.getConditions().put("confirmState", 1);
						pagination.getConditions().put("wancheng", 1);
					}else if(a.equals("1")){
						pagination.getConditions().put("confirmState", 1);
						pagination.getConditions().put("Psing", 1);
					}
				}
				pagination = yimiaoOrderdetailManager.getList(pagination);
			}else{
				pagination = yimiaoOrderdetailManager.getList(pagination);
			}
			//caption取值
			Map<String, Object> data = yimiaoOrderdetailManager.findCountList(pagination.getConditions());
			if(data!=null){			
				String amount1 =data.get("amount1").toString();
				String amount2 =data.get("amount2").toString();
				String radio =new BigDecimal(data.get("radio").toString()).stripTrailingZeros().toPlainString();
				data.put("amount1", amount1==null?"":new BigDecimal(ParseNumber.stringToFormat(amount1, 2)));
				data.put("amount2", amount2==null?"":new BigDecimal(ParseNumber.stringToFormat(amount2, 2)));
				data.put("radio", radio==null?"":new BigDecimal(ParseNumber.stringToFormat(radio, 2)));
				pagination.setMsg("采购记录  [采购数量:"+data.get("count1")
						+",采购金额:"+data.get("amount1")+",到货数量:"
						+data.get("count2")+",到货金额:"+data.get("amount2")
						+",平均完成率（%）:"+data.get("radio")+"]");							
			}else{
				pagination.setMsg("采购记录  [采购数量:0,采购金额:0.00,到货数量:0,到货金额:0.00,平均完成率（%）:0.00]");
				
			}
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderdetailData", e);
		}
		return pagination;
	}

	
	/**
	 * 修改采购订单
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("/updateOrderdetail")
	@ResponseBody
	public Pagination updateOrderdetail() {
		Pagination page = new Pagination(this.getRequest());
		YimiaoOrderdetail detail = new YimiaoOrderdetail();
		detail.setOrderdetailId((String) page.getConditions().get("orderdetailId"));
		detail.setConfirmState(Integer.parseInt((String) page.getConditions().get("confirmState")));
		detail.setRefuseReason((String) page.getConditions().get("refuseReason"));
		detail.setCompanyIdPs((String) page.getConditions().get("companyIdPs"));
		detail.setCompanyNamePs((String) page.getConditions().get("companyNamePs"));
		int count = yimiaoOrderdetailManager.updateBySelective(detail);
		if (count == 1) {
			page.setSuccess(true);
		} else {
			page.setSuccess(false);
			page.setMsg("操作失败！");
		}
		return page;
	}

	/**
	 * 批量修改采购订单
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping("/updateAllOrderdetail")
	@ResponseBody
	public Pagination updateAllOrderdetail(String str) {
		Pagination page = new Pagination(this.getRequest());
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Map<String, Object>>>() {
            }.getType();
            List<Map<String, Object>> list = gson.fromJson(str, type);
            yimiaoOrderdetailManager.updateByOrderList(list);
            page.setSuccess(true);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            page.setSuccess(false);
            page.setMsg("操作失败！");
        }
        return page;
	}

	@RequestMapping("toAdd")
	public String toAddJsp(Model model) {
		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoOrderdetailForm.class));
		return MODEL_PATH + "add";
	}

	@RequestMapping(value = "/addYimiaoOrderdetail")
	@ResponseBody
	public Pagination addYimiaoOrderdetail(YimiaoOrderdetailForm yimiaoOrderdetailForm) {
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoOrderdetail yimiaoOrderdetail = new YimiaoOrderdetail();
		formToModel(yimiaoOrderdetailForm, yimiaoOrderdetail);
		// TODO 其他信息

		yimiaoOrderdetailManager.add(yimiaoOrderdetail);
		pagination.setSuccess(true);
		return pagination;
	}

	@RequestMapping("toUpdate")
	public String toUpdateJsp(Model model, java.lang.String orderdetailId) {
		YimiaoOrderdetail yimiaoOrderdetail = yimiaoOrderdetailManager.getById(orderdetailId);
		YimiaoOrderdetailForm yimiaoOrderdetailForm = new YimiaoOrderdetailForm();
		modelToForm(yimiaoOrderdetail, yimiaoOrderdetailForm);

		model.addAttribute("validate", ValidateUtil.getValidate(YimiaoOrderdetailForm.class));
		model.addAttribute("yimiaoOrderdetailForm", yimiaoOrderdetailForm);
		return MODEL_PATH + "update";
	}

	@RequestMapping(value = "/updateYimiaoOrderdetail")
	@ResponseBody
	public Pagination updateYimiaoOrderdetail(YimiaoOrderdetailForm yimiaoOrderdetailForm) {
		Pagination pagination = new Pagination(this.getRequest());
		YimiaoOrderdetail yimiaoOrderdetail = yimiaoOrderdetailManager
				.getById(yimiaoOrderdetailForm.getOrderdetailId());
		BeanTool.copyProperties(yimiaoOrderdetailForm, yimiaoOrderdetail);// TODO
																			// null拷贝问题

		yimiaoOrderdetailManager.updateById(yimiaoOrderdetail);
		pagination.setSuccess(true);
		return pagination;
	}
	
	
	/**
	 * 到货
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping("/updateOrderdetailsx")
	@ResponseBody
	public Pagination updateOrderdetailsx(String str) {
		Pagination page = new Pagination(this.getRequest());
		try {
			Gson gson = new Gson();
			Type type = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, Object>> list = gson.fromJson(str, type);
			yimiaoOrderdetailManager.updateByDetailIdForDH(list);
			page.setSuccess(true);
		}catch (Exception e){
			log.error("Failed to updateOrderdetailsx", e);
			page.setMsg("到货操作异常，请联系管理员！");
			page.setSuccess(false);
		}
		return page;
	}
	/**
	 * 已完成退货列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcel")
	public void exportDataToExcel(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("hospitalId", user.getOrgId());
		List<String> titles = Arrays.asList(
				"订单执行状态",
				"申请单日期",
				"退货单位",
				"申请单名称",
				"疫苗编号",
			    "疫苗名称",
			    "疫苗通用名",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"配送企业",
				"最小制剂单位",
				"申请退货数量",
				"退货单价",
				"申请退货金额",
				"备注",
				"未退货原因",
				"已退货数量",
				"已退货金额",
				"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		pagination.getConditions().put("hospitalId", user.getOrgId());
		if(pagination.getConditions().get("confirmState")!=null){
			String a = (String) pagination.getConditions().get("confirmState");
			if(a.equals("a")){
				pagination.getConditions().put("confirmState", 1);
				pagination.getConditions().put("bufen", 1);
			}else if(a.equals("b")){
				pagination.getConditions().put("confirmState", 1);
				pagination.getConditions().put("wancheng", 1);
			}else if(a.equals("1")){
				pagination.getConditions().put("confirmState", 1);
				pagination.getConditions().put("Psing", 1);
			}
		}
		List<Map<String,Object>> list = yimiaoOrderdetailRetManager.getExportExcelData(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("已完成退货记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"已完成退货记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	/**
	 * 未完成退货列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelNo")
	public void exportDataToExcelNo(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("hospitalId", user.getOrgId());
		List<String> titles = Arrays.asList(
				"订单执行状态",
				"已退货数量",
				"已退货金额",
				"订单日期",
				"退货单位",
				"疫苗编号",
			    "疫苗名称",
			    "疫苗通用名",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"配送企业",
				"最小制剂单位",
				"申请退货数量",
				"退货单价",
				"申请退货金额",
				"备注",
				"未退货原因"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailRetManager.getExportExcelDataNo(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("未完成退货记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"未完成退货记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	/**
	 * 已完成采购列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelCG")
	public void exportDataToExcelCG(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("hospitalId", user.getOrgId());
		List<String> titles = Arrays.asList(
				    "订单名称",
				    "采购单位",
					"疫苗编号",
					"疫苗名称",
					"疫苗通用名",
                    "制剂规格（申报剂型）",
					"最小制剂单位",
                    "生产企业（投标企业）",
					"配送企业",
					"采购数量",
					"最小制剂单位中标价格（元）",
					"采购金额",
					"到货数量",
					"到货金额",
				 	"订单执行状态",
				    "订单提交日期",
				    "未供货原因",
					"要求备注",
					"完成率（%）"
				);
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataCG(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("已完成采购记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"已完成采购记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	/**
	 * 未完成采购列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelNCG")
	public void exportDataToExcelNCG(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("hospitalId", user.getOrgId());
		List<String> titles = Arrays.asList(
					"订单名称",
					"疫苗编号",
					"疫苗名称",
					"疫苗通用名",
					"制剂规格（申报剂型）",
					"最小制剂单位",
					"采购数量",
				 	"到货数量",
					"到货金额",
					"采购金额",
					"最小制剂单位中标价格（元）",
					"生产企业（投标企业）",
					"配送企业",
					"订单提交日期",
				 	"订单执行状态",
					"要求备注",
					"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		pagination.getConditions().put("hospitalId", user.getOrgId());
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataNCG(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("未完成采购记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"未完成采购记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	/**
	 * 采购列表导出 方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelWSJ")
	public void exportDataToExcelWSJ(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList(
				"订单日期",
				"订单名称",
				"采购单位",
				"疫苗编号",
				"疫苗名称",
                "制剂规格（申报剂型）",
                "生产企业（投标企业）",
				"配送企业",
				"最小制剂单位",
				"采购数量",
				"最小制剂单位中标价格（元）",
				"采购金额",
				"要求备注",
				"订单执行状态",
				"未供货原因",
				"到货数量",
				"到货金额",
				"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();

		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataWSJ(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("采购记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"采购记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	
	/**
	 * 配送采购记录导出  方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelPS")
	public void exportDataToExcelPS(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("companyIdTb", user.getOrgId());
		List<String> titles = Arrays.asList(
				"订单日期",   
				"订单名称",   
				"采购单位",
				"疫苗编号",
				"疫苗名称",   
				"规格",     
				"生产企业",   
				"最小制剂单位",
				"采购数量",   
				"最小制剂单位中标价格（元）",
				"采购金额",   
				"要求备注",   
				"是否供货",   
				"未供货原因",  
				"配送企业",   
				"到货数量",   
				"到货金额",   
				"完成率(%)"  
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataPS(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("采购记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"采购记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	/**
	 * 配送采购记录导出  方法
	 *
	 * @Title: exportData 
	 * @param response
	 * @throws Exception 
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelPSRET")
	public void exportDataToExcelPSRET(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("companyIdTb", user.getOrgId());
		List<String> titles = Arrays.asList(
				"申请单日期",   
				"申请单名称",   
				"采购单位",   
				"疫苗名称",   
				"规格",     
				"生产企业",   
				"最小制剂单位",
				"采购数量",   
				"最小制剂单位中标价格（元）",
				"采购金额",   
				"要求备注",   
				"是否供货",   
				"未供货原因",  
				"配送企业",   
				"到货数量",   
				"到货金额",   
				"完成率（%）"  
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataPSRET(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("退货记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"退货记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	
	
	@RequestMapping("exportDataToExcelNCGSC")
	public void exportDataToExcelNCGSC(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("companyIdTb", user.getOrgId());
		List<String> titles = Arrays.asList(
				 	"订单执行状态",
				    "未供货原因",
					"订单提交日期",
					"订单名称",
					"采购单位",
					"疫苗编号",
					"疫苗名称",
					"制剂规格（申报剂型）",
					"生产企业（投标企业）",
					"配送企业",
					"最小制剂单位",
					"采购数量",
					"最小制剂单位中标价格（元）",
					"采购金额",
					"要求备注",
					"到货数量",
					"到货金额",
					"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataNCG(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("未完成采购记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"未完成采购记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	@RequestMapping("exportDataToExcelCGSC")
	public void exportDataToExcelCGSC(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("companyIdTb", user.getOrgId());

		List<String> titles = Arrays.asList(
				 	"订单执行状态",
				    "未供货原因",
					"配送企业",
					"订单提交日期",
					"订单名称",
					"采购单位",
					"疫苗编号",
					"疫苗名称",
                    "制剂规格（申报剂型）",
                    "生产企业（投标企业）",
					"最小制剂单位",
					"采购数量",
					"最小制剂单位中标价格（元）",
					"采购金额",
					"要求备注",
					"到货数量",
					"到货金额",
					"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataCG(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("已完成采购记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"已完成采购记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	@RequestMapping("exportDataToExcelNoSC")
	public void exportDataToExcelNoSC(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("companyIdTb", user.getOrgId());
//		if(pagination.getConditions().get("confirmState")!=null){
//			String a = (String) pagination.getConditions().get("confirmState");
//			if(a.equals("a")){
//				pagination.getConditions().put("confirmState", 1);
//				pagination.getConditions().put("bufen", 1);
//			}else if(a.equals("b")){
//				pagination.getConditions().put("confirmState", 1);
//				pagination.getConditions().put("wancheng", 1);
//			}else if(a.equals("1")){
//				pagination.getConditions().put("confirmState", 1);
//				pagination.getConditions().put("Psing", 1);
//			}
//		}
		if(user.getUserType().equals(UserType.scqy.getKey())) {
			pagination.getConditions().put("companyIdTb", user.getOrgId());
			List<Integer> list = new ArrayList<Integer>();
			list.add(ReturnOrderStatus.PASS.getKey());
			pagination.getConditions().put("orderdetailStateList", list);
		}
		List<String> titles = Arrays.asList(
				"订单执行状态",
				"未退货原因",
				"配送企业",
				"已退货数量",
				"申请单日期",
				"申请单名称",
				"退货单位",
				"疫苗编号",
			    "疫苗名称",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"最小制剂单位",
				"备注",
				"申请退货数量",
				"申请退货原因",
				"退货单价",
				"申请退货金额",
				"已退货金额"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailRetManager.getExportExcelDataNoSc(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("未完成退货记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"未完成退货记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	@RequestMapping("exportDataToExcelSC")
	public void exportDataToExcelSC(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		pagination.getConditions().put("companyIdTb", user.getOrgId());
		List<String> titles = Arrays.asList(
				"申请单日期",
				"申请单名称",
				"退货单位",
				"疫苗编号",
			    "疫苗名称",
		        "制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"最小制剂单位",
				"备注",
				"申请退货数量",
				"退货原因",
				"退货单价",
				"申请退货金额",
				"订单执行状态",
				"未退货原因",
				"配送企业",
				"已退货数量",
				"已退货金额",
				"完成率（%）"
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailRetManager.getExportExcelData(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
				
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("已完成退货记录列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"已完成退货记录列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	
	/**
	 * 目录统计--导出
	 */
	@RequestMapping("exportDataToExcelMLTJ")
	public void exportDataToExcelMLTJ(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		String provId = this.getRequest().getParameter("area1");
		String cityId = this.getRequest().getParameter("area2");
		String townId = this.getRequest().getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
		} else {
			areaId = "";
		}
		pagination.getConditions().put("areaId", areaId);
		List<String> titles = Arrays.asList(
				"疫苗名称",
				"采购数量",
				"采购金额",
			 	"到货数量",
				"到货金额",
				"到货平均完成率（%）",
				"退货数量",
				"退货金额",
				"退货到货数量",
				"退货到货金额",
				"退货平均完成率（%）" 
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataMLTJ(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("目录统计.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"目录统计");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	@RequestMapping("exportDataToExcelMLTJTwo")
	public void exportDataToExcelMLTJTwo(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		String provId = this.getRequest().getParameter("area1");
		String cityId = this.getRequest().getParameter("area2");
		String townId = this.getRequest().getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
		} else {
			areaId = "";
		}
		pagination.getConditions().put("areaId", areaId);
		List<String> titles = Arrays.asList(
				"疫苗名称",
				"规格",
				"采购数量",
				"采购金额",
			 	"到货数量",
				"到货金额",
				"到货平均完成率（%）",
				"退货数量",
				"退货金额",
				"退货到货数量",
				"退货到货金额",
				"退货平均完成率（%）" 
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();		
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDataMLTJTwo(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("目录统计.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"目录统计");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}
	
	@RequestMapping("exportDataToExcelMLTJThree")
	public void exportDataToExcelMLTJThree(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		String provId = this.getRequest().getParameter("area1");
		String cityId = this.getRequest().getParameter("area2");
		String townId = this.getRequest().getParameter("area3");
		String areaId = provId;
		if (StringUtils.isNotBlank(townId)) {
			areaId = townId;
		} else if (StringUtils.isNotBlank(cityId)) {
			areaId = cityId.replaceAll("0*$", "");
		} else if (StringUtils.isNotBlank(provId)) {
			areaId = provId.replaceAll("0*$", "");
		} else {
			areaId = "";
		}
		pagination.getConditions().put("areaId", areaId);
		List<String> titles = Arrays.asList(
				"疫苗编号",
				"疫苗名称",
				"规格",
				"生产企业",
				"最小制剂单位中标价格（元）",
				"最小制剂单位",
				"采购数量",
				"采购金额",
			 	"到货数量",
				"到货金额",
				"到货平均完成率（%）",
				"退货数量",
				"退货金额",
				"退货到货数量",
				"退货到货金额",
				"退货平均完成率（%）" 
				);
		
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String, Object>> list = yimiaoOrderdetailManager.getExportExcelDataMLTJThree(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream"); 
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("目录统计.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"目录统计");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}

    /**
     * 汇总统计-采购统计列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportDataToExcelPurchase")
    public void exportDataToExcelPurchase(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        SysUser user = getSysUser();
        if(user.getUserType()==4){
            pagination.getConditions().put("hospitalId", user.getOrgId());
        }
        else if(user.getUserType()==1){
            pagination.getConditions().put("companyIdTb", user.getOrgId());
        }
        List<String> titles = Arrays.asList(
                "订单名称",
                "采购单位",
                "疫苗编号",
                "疫苗名称",
                "疫苗通用名",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
                "最小制剂单位",
                "采购数量",
                "最小制剂单位中标价格（元）",
                "采购金额",
                "备注"
        );
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelPurchase(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("采购统计列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"采购统计列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

    /**
     * 汇总统计-配送统计列表导出 方法
     *
     * @Title: exportData
     * @param response
     * @throws Exception
     * @return void
     * @throws
     */
    @RequestMapping("exportDataToExcelDispatch")
    public void exportDataToExcelDispatch(HttpServletResponse response) throws Exception {
        Pagination pagination = new Pagination(this.getRequest());
        SysUser user = getSysUser();
        if(user.getUserType()==4){
            pagination.getConditions().put("hospitalId", user.getOrgId());
        }
        else if(user.getUserType()==1){
            pagination.getConditions().put("companyIdTb", user.getOrgId());
        }
        List<String> titles = Arrays.asList(
                "订单名称",
                "采购单位",
                "疫苗编号",
                "疫苗名称",
                "疫苗通用名",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
                "最小制剂单位",
                "采购数量",
                "最小制剂单位中标价格（元）",
                "采购金额",
                "备注"
        );
        ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
        List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelDispatch(pagination.getConditions());
        dataInfos.setTitles(titles);
        dataInfos.setExcelExportDatas(list);

        try {
            response.setContentType("text/html; charset=utf-8");
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String("配送统计列表.xls".getBytes("GB2312"), "ISO-8859-1"));
            ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"配送统计列表");
            pagination.setSuccess(true);
        }catch (Exception e) {
            log.error("",e);
            pagination.setSuccess(false);
        }
    }

	/**
	 * 汇总统计-入库统计列表导出 方法
	 *
	 * @Title: exportData
	 * @param response
	 * @throws Exception
	 * @return void
	 * @throws
	 */
	@RequestMapping("exportDataToExcelCatalog")
	public void exportDataToExcelCatalog(HttpServletResponse response) throws Exception {
		Pagination pagination = new Pagination(this.getRequest());
		SysUser user = getSysUser();
		if(user.getUserType()==4){
			pagination.getConditions().put("hospitalId", user.getOrgId());
		}
        else if(user.getUserType()==1){
            pagination.getConditions().put("companyIdTb", user.getOrgId());
        }
		List<String> titles = Arrays.asList(
				"订单名称",
				"采购单位",
				"疫苗编号",
				"疫苗名称",
				"疫苗通用名",
				"制剂规格（申报剂型）",
				"生产企业（投标企业）",
				"配送企业",
				"最小制剂单位",
				"采购数量",
				"最小制剂单位中标价格（元）",
				"采购金额",
				"到货数量",
				"到货金额",
				"完成率（%）"
		);
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.getExportExcelCatalog(pagination.getConditions());
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);

		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("入库统计列表.xls".getBytes("GB2312"), "ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos, response.getOutputStream(),"入库统计列表");
			pagination.setSuccess(true);
		}catch (Exception e) {
			log.error("",e);
			pagination.setSuccess(false);
		}
	}

	/*****************************医院统计分析**************************************/
	@RequestMapping("toSupHosp")
	public String toSupHosp(Model model) throws UnsupportedEncodingException{

		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supHosp";
	}
	@RequestMapping("getSupHosp")
	@ResponseBody
	public Pagination getSupHosp() {
		Pagination page = new Pagination(this.getRequest());
		// TODO 涉及角色区分
		try {
			page = yimiaoOrderdetailManager.getSupHosp(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("supComppsDayList")
	public String supComppsDayList(Model model){
		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supComppsDayList";
	}
	@RequestMapping("supCompscDayList")
	public String supCompscDayList(Model model){
		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supCompscDayList";
	}
	@RequestMapping("supOrderAll")
	public String supOrderAllList(Model model){
		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supOrderAll";
	}
	@RequestMapping("getSupCompany")
	@ResponseBody
	public Pagination getSupCompany(Model model) {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getSupHosp(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}
	@RequestMapping("supGoodsList")
	public String supGoodsList(Model model){
		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supGoodsList";
	}
	@RequestMapping("getSupGoods")
	@ResponseBody
	public Pagination getSupGoods(Model model) {

		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getSupHosp(page);
		} catch (Exception e) {
			log.error("Failed to getSupGoods", e);
		}
		return page;
	}
	@RequestMapping("supOrderList")
	public String supOrderList(Model model){
		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supOrderList";
	}
	@RequestMapping("getSupOrder")
	@ResponseBody
	public Pagination getSupOrder(Model model) {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getSupHosp(page);
		} catch (Exception e) {
			log.error("Failed to getSupGoods", e);
		}
		return page;
	}
	@RequestMapping("getHospDayCount")
	@ResponseBody
	public Map<String,String> getAnaAreaHospDayCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getHospDayCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaAreaHospDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("supOrderDetailList")
	public String supOrderDetailList(Model model){
		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supOrderDetailList";
	}
	@RequestMapping("exportAllSup")
	public void exportAllSup(HttpServletResponse response,YimiaoOrderdetail yimiaoOrderdetail) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = null;
		if(pagination.getConditions().get("hosp")!=null){
		 titles = Arrays.asList("地区","医疗机构","采购金额(元)","撤废金额(元)","退货金额(元)","退货率","入库金额(元)","入库率");
		}
		if(pagination.getConditions().get("companyps")!=null){
			titles = Arrays.asList("配送企业","采购金额(元)","撤废金额(元)","退货金额(元)","退货率","入库金额(元)","入库率");
		}
		if(pagination.getConditions().get("companysc")!=null){
			titles = Arrays.asList("生产企业","采购金额(元)","撤废金额(元)","退货金额(元)","退货率","入库金额(元)","入库率");
		}
		if(pagination.getConditions().get("goods")!=null){
			titles = Arrays.asList("通用名","剂型","规格","包装","单位","生产企业","采购价格(元)","采购金额(元)","撤废金额(元)","退货金额(元)","退货率","入库金额(元)","入库率");
		}
		if(pagination.getConditions().get("order")!=null&&pagination.getConditions().get("orderD")==null){
			titles = Arrays.asList("通用名","剂型","规格","包装","单位","生产企业","配送企业","医疗机构","采购价格(元)","采购金额(元)","撤废金额(元)","退货金额(元)","退货率","入库金额(元)","入库率");
		}

		if(pagination.getConditions().get("orderD")!=null&&pagination.getConditions().get("orderAll")==null){
			titles = Arrays.asList("采购数量","入库数量","采购金额(元)","入库金额(元)","订单名称","提交时间","通用名","剂型","规格","包装","单位","生产企业","配送企业","医疗机构","订单状态");
		}
		if(pagination.getConditions().get("orderAll")!=null){
			titles = Arrays.asList("订单名称","提交时间","医疗机构","采购金额(元)","撤废金额(元)");
		}
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportAllSup(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("医院汇总统计.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"医院汇总统计");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	@RequestMapping("toSupHospMon")
	public String toSupHospMon(Model model) throws UnsupportedEncodingException{

		SysUser user = this.getSysUser();
		if(!user.getStdManageOrg().getAreaId().equals("530000")){
			String adminAreaId = user.getStdManageOrg().getAreaId();
			model.addAttribute("areaIds",adminAreaId.substring(0,4));
		}
		Map<String, Object> map = DbUtil.jsonToMap(this.getRequest());
		List<YimiaoProcurecatalog> bidList = yimiaoProcurecatalogManager.getProjName();
		model.addAttribute("bidList", JSON.toJSON(bidList));
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "supHospMon";
	}
	/****************************配送企业汇总统计**************************************/
	@RequestMapping("toCompanyPsStatistics")
	public String toCompanyPsStatistics(Model model) {
		Map<String,Object> map = DbUtil.jsonToMap(this.getRequest());
		SysUser user = this.getSysUser();
		String adminAreaId = user.getStdManageOrg().getAreaId();
		String shi = adminAreaId.substring(2,4);
		if(!shi.equals("00")) {
			map.put("adminAreaId", adminAreaId);
		}
		model.addAttribute("queryMap",map);
		return MODEL_PATH + "companyPsStatistics";
	}

	@RequestMapping("getCompanyPsStatistics")
	@ResponseBody
	public Pagination getCompanyPsStatistics() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getCompanyPsStatistics(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoCompanyPsCount")
	@ResponseBody
	public Map<String,String> getYimiaoCompanyPsCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getYimiaoCompanyPsCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaComppsDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("exportDataCompanyPs")
	public void exportDataCompanyPs(HttpServletResponse response) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList("配送企业","采购数量","采购金额","到货数量","到货金额","到货平均完成率（%）","退货数量","退货金额","退货平均完成率（%）" );
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportDataCompanyPs(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("配送企业汇总分析.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"配送企业汇总分析");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	/****************************配送企业汇总统计**************************************/
	/****************************生产企业汇总统计**************************************/
	@RequestMapping("toCompanyScStatistics")
	public String toCompanyScStatistics(Model model) {
		Map<String,Object> map = DbUtil.jsonToMap(this.getRequest());

		SysUser user = this.getSysUser();
		String adminAreaId = user.getStdManageOrg().getAreaId();
		String shi = adminAreaId.substring(2,4);
		if(!shi.equals("00")) {
			map.put("adminAreaId", adminAreaId);
		}

		model.addAttribute("queryMap",map);

		return MODEL_PATH + "companyScStatistics";
	}

	@RequestMapping("getCompanyScStatistics")
	@ResponseBody
	public Pagination getCompanyScStatistics() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getCompanyScStatistics(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoCompanyScCount")
	@ResponseBody
	public Map<String,String> getYimiaoCompanyScCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getYimiaoCompanyScCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaComppsDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("exportDataCompanySc")
	public void exportDataCompanySc(HttpServletResponse response) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList("生产企业","采购数量","采购金额","到货数量","到货金额","到货平均完成率（%）","退货数量","退货金额","退货平均完成率（%）" );
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportDataCompanySc(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("生产企业汇总分析.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"生产企业汇总分析");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	/****************************生产企业汇总统计**************************************/
	/****************************地区汇总统计*****************************************/
	@RequestMapping("toAdminAreaStatistics")
	public String toAdminAreaStatistics(Model model) {
		Map<String,Object> map = DbUtil.jsonToMap(this.getRequest());
		SysUser user = this.getSysUser();
		String adminAreaId = user.getStdManageOrg().getAreaId();
		String shi = adminAreaId.substring(2,4);
		if(!shi.equals("00")) {
			map.put("adminAreaId", adminAreaId);
		}
		model.addAttribute("queryMap",map);

		return MODEL_PATH + "adminAreaStatistics";
	}

	@RequestMapping("getAdminAreaStatistics")
	@ResponseBody
	public Pagination getAdminAreaStatistics() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getAdminAreaStatistics(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoAdminAreaCount")
	@ResponseBody
	public Map<String,String> getYimiaoAdminAreaCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getYimiaoAdminAreaCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaComppsDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("exportDataAdminArea")
	public void exportDataAdminArea(HttpServletResponse response) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList("所属地区","采购数量","采购金额","到货数量","到货金额","到货平均完成率（%）","退货数量","退货金额","退货平均完成率（%）" );
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportDataAdminArea(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("地区汇总分析.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"地区汇总分析");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	/****************************地区汇总统计********************************************/
	/****************************医院月汇总统计********************************************/
	@RequestMapping("toHospitalMonthStatistics")
	public String toHospitalMonthStatistics(Model model) {
		Map<String,Object> map = DbUtil.jsonToMap(this.getRequest());
		SysUser user = this.getSysUser();
		String adminAreaId = user.getStdManageOrg().getAreaId();
		String shi = adminAreaId.substring(2,4);
		if(!shi.equals("00")) {
			map.put("adminAreaId", adminAreaId);
		}
		model.addAttribute("queryMap",map);

		return MODEL_PATH + "hospitalMonthStatistics";
	}

	@RequestMapping("getHospitalMonthStatistics")
	@ResponseBody
	public Pagination getHospitalMonthStatistics() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getHospitalMonthStatistics(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoHospitalMonthCount")
	@ResponseBody
	public Map<String,String> getYimiaoHospitalMonthCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getYimiaoHospitalMonthCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaComppsDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("exportDataHospitalMonth")
	public void exportDataHospitalMonth(HttpServletResponse response) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList("采购月份","采购数量","采购金额","到货数量","到货金额","到货平均完成率（%）","退货数量","退货金额","退货平均完成率（%）" );
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportDataHospitalMonth(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("医院月汇总分析.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"医院月汇总分析");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	/****************************医院月汇总统计********************************************/
	
	/****************************医院汇总统计********************************************/
	@RequestMapping("toHospitalStatistics")
	public String toHospitalStatistics(Model model) {
		Map<String,Object> map = DbUtil.jsonToMap(this.getRequest());
		SysUser user = this.getSysUser();
		String adminAreaId = user.getStdManageOrg().getAreaId();
		String shi = adminAreaId.substring(2,4);
		if(!shi.equals("00")) {
			map.put("adminAreaId", adminAreaId);
		}
		model.addAttribute("queryMap",map);

		return MODEL_PATH + "hospitalStatistics";
	}

	@RequestMapping("getHospitalStatistics")
	@ResponseBody
	public Pagination getHospitalStatistics() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getHospitalStatistics(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoHospitalCount")
	@ResponseBody
	public Map<String,String> getYimiaoHospitalCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getYimiaoHospitalCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaComppsDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("exportDataHospital")
	public void exportDataHospital(HttpServletResponse response) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList("医疗机构","所属地区","采购数量","采购金额","到货数量","到货金额","到货平均完成率（%）","退货数量","退货金额","退货平均完成率（%）" );
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportDataHospital(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("医院汇总分析.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"医院汇总分析");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	/****************************医院月汇总统计********************************************/
	/****************************疫苗汇总统计********************************************/
	@RequestMapping("toYimiaoProcurecatalogStatistics")
	public String toYimiaoStatistics(Model model) {
		Map<String,Object> map = DbUtil.jsonToMap(this.getRequest());
		SysUser user = this.getSysUser();
		String adminAreaId = user.getStdManageOrg().getAreaId();
		String shi = adminAreaId.substring(2,4);
		if(!shi.equals("00")) {
			map.put("adminAreaId", adminAreaId);
		}
		model.addAttribute("queryMap",map);

		return MODEL_PATH + "yimiaoProcurecatalogStatistics";
	}

	@RequestMapping("getYimiaoProcurecatalogStatistics")
	@ResponseBody
	public Pagination getYimiaoProcurecatalogStatistics() {
		Pagination page = new Pagination(this.getRequest());
		try {
			page = yimiaoOrderdetailManager.getYimiaoProcurecatalogStatistics(page);
		} catch (Exception e) {
			log.error("Failed to getYimiaoOrderData", e);
		}
		return page;
	}

	@RequestMapping("getYimiaoProcurecatalogCount")
	@ResponseBody
	public Map<String,String> getYimiaoProcurecatalogCount(Model model) {
		Pagination pagination = new Pagination(this.getRequest());
		Map<String, String> countMap = new HashMap<String, String>();
		try {
			countMap = yimiaoOrderdetailManager.getYimiaoProcurecatalogCount(pagination);
		} catch (Exception e) {
			log.error("Failed to getAnaComppsDayCount", e);
		}
		return countMap;
	}

	@RequestMapping("exportDataYimiaoProcurecatalog")
	public void exportDataYimiaoProcurecatalog(HttpServletResponse response) throws Exception{
		Pagination pagination = new Pagination(this.getRequest());
		List<String> titles = Arrays.asList("疫苗编号","通用名","规格","最小制剂单位","采购数量","采购金额","到货数量","到货金额","到货平均完成率（%）","退货数量","退货金额","退货平均完成率（%）" );
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		List<Map<String,Object>> list = yimiaoOrderdetailManager.exportDataYimiaoProcurecatalog(pagination);
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String("疫苗汇总分析.xls".getBytes("GB2312"),"ISO-8859-1"));
			ExportUtil.exportExcelDataInfo(dataInfos,response.getOutputStream(),"疫苗汇总分析");
			pagination.setSuccess(true);
		} catch (Exception e) {
			log.error("", e);
			pagination.setSuccess(false);
		}
	}
	/****************************医院月汇总统计********************************************/
	
}
