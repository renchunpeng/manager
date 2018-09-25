package com.hsnn.medstgmini.enums;

import com.alibaba.fastjson.JSON;
import com.hsnn.medstgmini.util.enums.ICommonEnum;

import java.util.HashMap;
import java.util.Map;

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
		Map<Object, Object> map = new HashMap<Object, Object>(); 
		for(ICommonEnum t : ts) {
			map.put(t.getKey(), t.getValue());
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
