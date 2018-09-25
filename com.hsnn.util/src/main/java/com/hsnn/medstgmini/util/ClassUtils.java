package com.hsnn.medstgmini.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 实体类工具类
 * @author he.fan
 *
 */
public class ClassUtils {
	
	/**
	 * 将要插入的类转换成表名
	 * @param clazz 转换类
	 * @return
	 */
	public static String getClazzToTable(Object clazz){
		StringBuffer tableName=new StringBuffer();
		String clazzName=clazz.getClass().getSimpleName();
		char[] charArr = clazzName.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			//如果是大写
			if(Character.isUpperCase(charArr[i])){
				if(i==0){
					if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
						charArr[i] += 32;
					}
				}else{
					if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
						charArr[i] += 32;
					}
				}
				if(i!=0){
					tableName.append("_");
				}
			}
			tableName.append(charArr[i]);
		}
		
		return tableName.toString();
	}
	
	/**
	 * 从字节数组获取对象
	 * @param objBytes
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws Exception
	 */
	 public static Object getObjectFromBytes(byte[] objBytes) throws IOException, ClassNotFoundException{
        if (objBytes == null || objBytes.length == 0){
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
     }
	 
	/**
	  * 删除重复元素，并保持顺序
	  *
	  * @Title: removeDuplicateWithOrder 
	  * @param list 
	  * @return void
	  * @throws
	  */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void removeDuplicateWithOrder(List list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		if(list != null && list.size() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Object element = iter.next();
				if (set.add(element))
					newList.add(element);
			}
			list.clear();
			list.addAll(newList);
		}
	 }
	 
	/**
	 * 获取集合中重复的元素 
	 *
	 * @Title: getRepeatElements 
	 * @param list 要操作的集合
	 * @param repeatList 重复元素集合 
	 * @return void
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getRepeatElements(List list, List repeatList) {
		if(list != null && list.size() > 0) {
			Map<Object, Object> map = new HashMap<Object, Object>();
			for (Object s : list) {
				if (map.containsKey(s)) {
					repeatList.clear();
					repeatList.add(s);
				} else {
					map.put(s, s);
				}
			}
		}
	}

}
