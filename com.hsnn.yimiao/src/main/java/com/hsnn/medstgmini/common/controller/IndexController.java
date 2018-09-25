package com.hsnn.medstgmini.common.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.sys.model.SysResource;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysResource;
import com.hsnn.medstgmini.base.sys.service.ISysRole;
import com.hsnn.medstgmini.util.TreeUtil;

/**
 * @category index页面
 * @author CCL
 */
@Controller
public class IndexController {
	
	@Autowired
	private ISysRole roleManager;

	@Autowired
	private ISysResource resourceManager;

	/*private String gist = "0";

	private String show = "1";*/

	private String systemTitle = "贵州省第二类疫苗集中采购系统";

	private String systemHostUnit = "贵州省政府采购和出让中心";
	
	@Value("${system.stdurl}")
	private String stdurl;//基础库路径
	@Value("${system.tradeurl}")
	private String tradeurl;//交易路径

	/**
	 * @category 查询菜单列表并跳转index页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpSession session, Model model) {
		SysUser user = (SysUser) session.getAttribute(Constants.USERINFO);

		/*boolean showBusiness = true;*/

		// 判断主帐号是否显示业务菜单
		/*if (user.getMain() == 1) {
			if ("0".equals(gist) && "1".equals(show)) {
				showBusiness = true;
			} else if ("1".equals(gist) && "1".equals(user.getBussinessShow())) {
				showBusiness = true;
			} else {
				showBusiness = false;
			}
		}*/

		// 查询用户角色列表
		SysRole sysRole = roleManager.getRoleById(user.getRoleId());
		user.setSysRole(sysRole);
		Set<SysResource> set;
		set = resourceManager.getResourceListByUser(user.getUserId());
		//判断是否存在角色
		if(sysRole != null) {
			//根据角色获取资源
			Set<SysResource> roleList = resourceManager.getResourceListByRoleId(user.getRoleId());
			set.addAll(roleList);
		}
		List<SysResource> list = new ArrayList<SysResource>(set);
		Collections.sort(list, new Comparator<SysResource>() {
			@Override
			public int compare(SysResource o1, SysResource o2) {
				return o1.getSort().compareTo(o2.getSort()) ;
			}
		});
		user.setResourceList(list);

		List<String> btnUrlList = new ArrayList<String>();
		// 权限集合存入session
		if (list != null && !list.isEmpty()) {
			for (SysResource p : list) {
				/*if (!showBusiness && "1".equals(p.getClassify())) {
					continue;
				}*/
				if (p.getResourceType() == Constants.RESOURCE_BUTTON) {
					if (StringUtils.isNotBlank(p.getResourceUrl())) {
						/*String[] urls = p.getResourceUrl().split(";");
						if (urls.length > 1) {
							for (int i = 0; i < urls.length; i++) {
								btnUrlList.add(urls[i]);
							}
						}*/
						btnUrlList.add(p.getResourceUrl());
					}
				}
			}
			
		}
		session.setAttribute(Constants.USER_RESOURCE, btnUrlList);

		// 菜单树
		list = TreeUtil.toMenuTree(list);
		for(int i =0;i<list.size();i++){
			if("门户".equals(list.get(i).getMenuName())&&list.get(i).getParentResourceId()==0){
				list.remove(i);
				break;
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("user", user);

		model.addAttribute("systemHostUnit", systemHostUnit);
		model.addAttribute("systemTitle", systemTitle);
		model.addAttribute("stdurl", stdurl);
		model.addAttribute("tradeurl", tradeurl);
		return "/sysindex";
	}

	@RequestMapping("/home")
	public String home(HttpSession session,Model model) {
		SysUser user = (SysUser) session.getAttribute(Constants.USERINFO);
		model.addAttribute("type", user.getUserType());
		model.addAttribute("acctType",user.getAcctType());
		model.addAttribute("stdurl", stdurl);
		model.addAttribute("tradeurl", tradeurl);
		return "/home";
	}
	
	/**
	 * @category 查询菜单列表并跳转index页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/frameindex")
	public String frameindex(Model model) {
		model.addAttribute("stdurl", stdurl);
		model.addAttribute("tradeurl", tradeurl);
		return "/frameindex";
	}
}
