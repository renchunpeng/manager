/**
 * 下午7:23:44
 */
package com.hsnn.medstgmini.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.beans.BeanCopier;


/**
 * 复制bean对象 可替代beanUtil 
 * 无需考虑Date类型字段为空时 转换抛异常
 * @author yxc
 *
 */
public class BeanCopierUtils {

	//静态hashMap用于保存BeanCopier对象
	 public static Map<String,BeanCopier> beanCopierMap = new HashMap<String,BeanCopier>();
	 
     public static void copyProperties(Object source, Object target){
         String beanKey =  generateKey(source.getClass(), target.getClass());
         BeanCopier copier =  null;
         if(!beanCopierMap.containsKey(beanKey)){//不存在则添加到map中
              copier = BeanCopier.create(source.getClass(), target.getClass(), false);
              beanCopierMap.put(beanKey, copier);
         }else{//已存在则直接从map中获取BeanCopier对象
              copier = beanCopierMap.get(beanKey);
         }
         copier.copy(source, target, null);
     }
     private static String generateKey(Class<?> source,Class<?>target){
         return source.toString() + target.toString();
     }
}
