package com.hsnn.medstgmini.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

/**
 * 
 * Bean拷贝（排除null）  
 *
 * @ClassName: BeanTool  
 * @author zhou.xy
 * @date 2016年2月25日 下午1:58:23  
 *
 */
public class BeanTool extends BeanUtils {
	public static void copyProperties(Object source, Object target) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}
	
	/**
	 * 遍历对象的属性，将非空属性的名称和值加入map中
	 * 
	 * @param object
	 * @param map
	 */
	public static Map<String, Object> pojoToMap(Object object) {
		Map<String, Object> tmp = new HashMap<String, Object>();
		if (object == null) {
			return tmp;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] flds = object.getClass().getDeclaredFields();
		for (Field f : flds) {
			map.put(f.getName(), null);
		}
		Class<?> cls = object.getClass().getSuperclass();
		while (cls != Object.class) {
			Field[] fldz = cls.getDeclaredFields();
			for (Field f : fldz) {
				if (!map.containsKey(f.getName())) {
					map.put(f.getName(), null);
				}
			}
			cls = cls.getSuperclass();
		}
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String methodName = "get" + StringTool.toUpperCaseFirstOne(key);
			try {
				Method m = object.getClass().getMethod(methodName);
				// 调用getter方法获取属性值
				Object value = (Object) m.invoke(object);
				if (value != null) {
					tmp.put(key, value);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return tmp;
	}
	
	/**
	 * 获取对象属性值为null的属性 
	 *
	 * @Title: getNullPropertyNames 
	 * @param source
	 * @return 
	 * @return String[]
	 * @throws
	 */
	public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
