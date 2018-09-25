package com.hsnn.medstgmini.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsnn.medstgmini.common.service.DynamicSelectManager;
import com.hsnn.medstgmini.util.SelectForm;

/**
 * 联动查询
 * 
 * @author qiulei
 *
 */

@Controller
@RequestMapping("/selectController")
public class DynamicSelectController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private DynamicSelectManager selectManager;
	
	
	@RequestMapping(value = "/getArea")
	@ResponseBody
	public List<SelectForm> getArea() {
		String fatherId = request.getParameter("ID");
		if (null == fatherId || "".equals(fatherId)) {
			fatherId = "000000";
		}
		List<SelectForm> list = selectManager.getArea(fatherId);
		return list;
	}
	@RequestMapping(value = "/getDistrict")
	@ResponseBody
	public List<SelectForm> getDistrict() {
		String fatherId = request.getParameter("ID");
		if (null == fatherId || "".equals(fatherId)) {
			fatherId = "000000";
		}
		List<SelectForm> list = selectManager.getArea(fatherId);
		for(int i=0;i<list.size();i++){
			String area=list.get(i).getText();
			if("市辖区".equals(area))
			{
				list.remove(i);
			}
		}
		return list;
	}
}
