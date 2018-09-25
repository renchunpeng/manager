package com.hsnn.medstgmini.util.enums;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class GDTld {
	public static Object[] getEnumValues(String className) {
		Object[] ts = null;
		try{
			Class<?> enums = Class.forName(className);
			if(enums.isEnum()){
				ts = enums.getEnumConstants();
			}
		} catch (ClassNotFoundException e){			
		}
		return ts;
	}
	
	public static String getEnumJSON(String className) {
		ICommonEnum[] ts = (ICommonEnum[]) getEnumValues(className);
		Map<String, Object> map = new HashMap<String, Object>(); 
		for(ICommonEnum t : ts) {
			map.put(t.getKey()+"", t.getValue());
		}
		return JSON.toJSONString(map);
	}
	
	@SuppressWarnings("rawtypes")
	public static String getEnumKeyJSON(String className) {
		ICommonEnum[] ts = (ICommonEnum[]) getEnumValues(className);
		Map<Object, Object> map = new HashMap<Object, Object>(); 
		for(ICommonEnum t : ts) {
			map.put(((Enum)t).name(), t.getKey());
		}
		return JSON.toJSONString(map);
	}
}
