package com.hsnn.medstgmini.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysResource;
import com.hsnn.medstgmini.common.model.ResourceType;

/**
 * @category 树工具
 * @author 蔡春龙
 * @date 2015年6月12日
 */
public class TreeUtil {

	private static boolean isMenu(Integer type) {
		if (type != null) {
			if (ResourceType.system.getKey() == type
					|| ResourceType.module.getKey() == type
					|| ResourceType.menu.getKey() == type) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @category 列表转树型结构
	 * @return
	 */
	public static List<SysResource> toPrivilegeTree(List<SysResource> list) {
		List<SysResource> result = new LinkedList<SysResource>();
		if (list != null) {
			Map<Integer, SysResource> map = new HashMap<Integer, SysResource>();
			for (SysResource resource : list) {
				map.put(resource.getResourceId(), resource);
			}
			for (SysResource resource : list) {
				SysResource father = map.get(resource.getParentResourceId());
				if (father != null) {
					father.addChild(resource);
				} else {
					result.add(resource);
				}
			}
		}
		return result;
	}

	/**
	 * @category 列表转树型结构
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> toPrivTree(
			List<Map> list) {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		if (list != null) {
			Map<Object, Map<String, Object>> map = new HashMap<Object, Map<String, Object>>();
			for (Map<String, Object> priv : list) {
				map.put(priv.get("id"), priv);
			}
			for (Map<String, Object> priv : list) {
				Map<String, Object> father = map.get(priv.get("pid"));
				if (father != null) {
					List<Map<String, Object>> children = (List<Map<String, Object>>) father
							.get("children");
					if (children == null) {
						children = new LinkedList<Map<String, Object>>();
						father.put("children", children);
					}
					children.add(priv);
				} else {
					result.add(priv);
				}
			}
		}
		return result;
	}

	/**
	 * @category 列表转树型结构
	 * @return
	 */
	public static List<SysResource> toMenuTree(List<SysResource> list) {
		List<SysResource> result = new LinkedList<SysResource>();
		if (list != null) {
			Map<String, SysResource> map = new HashMap<String, SysResource>();
			for (SysResource resource : list) {
				if (isMenu(resource.getResourceType())) {
					map.put(resource.getResourceId()+"", resource);
				}
			}
			for (SysResource resource : list) {
				if (isMenu(resource.getResourceType())) {
					SysResource father = map.get(resource.getParentResourceId()+"");
					if (father != null) {
						father.addChild(resource);
					} else {
						result.add(resource);
					}
				}
			}
		}
		return result;
	}

}
