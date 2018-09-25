package com.hsnn.medstgmini.util.compile;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;
import com.hsnn.medstgmini.base.std.model.ContrastObj;
import com.hsnn.medstgmini.util.StringTool;
import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 比较对象数据是否相等,加以修饰工具类
 * @author he.fan
 *
 */
public class BeanCompileUtil {
	
	
	
	/**
	 * 
	 * 修饰两个对象不相同的属性
	 *  返回修饰后结果如：
	 *  [
	 *  	{基药配送区域=111, 部门联系方式=, 采购属性=111, 耗材配送区域=111, 记录添加人=名字, 地区简称=2222, 最后一次更新记录人=111, 状态=111, 机构编号=001, 地区名称=<span color='red'>好地方</span>, orgName=1111, 记录添加人id=111, 最后一次更新记录时间=<span color='red'>Tue Feb 23 22:57:26 CST 2016</span>, 最后一次更新记录人id=111, 部门负责人=222, 部门类型=111, 部门编号=1, 记录添加时间=<span color='red'>Tue Feb 23 22:57:26 CST 2016</span>, burSpelCode=1111, 部门名称=德玛西亚, 非基药配送区域=222, 排序=备注, 所属地区=11111}, 
	 *  	{基药配送区域=111, 部门联系方式=, 采购属性=111, 耗材配送区域=111, 记录添加人=名字, 地区简称=2222, 最后一次更新记录人=111, 状态=111, 机构编号=001, 地区名称=<span color='red'>坏地方</span>, orgName=1111, 记录添加人id=111, 最后一次更新记录时间=<span color='red'>Tue Feb 23 22:58:14 CST 2016</span>, 最后一次更新记录人id=111, 部门负责人=222, 部门类型=111, 部门编号=1, 记录添加时间=<span color='red'>Tue Feb 23 22:58:14 CST 2016</span>, burSpelCode=1111, 部门名称=德玛西亚, 非基药配送区域=222, 排序=备注, 所属地区=11111}
	 *  ]
	 * @Title: compile 
	 * @param  List<Map<String, String>> 比较数据
	 * @return 
	 * @throws
	 */
	public static List<LinkedHashMap<String, String>> compile(List<Object> listObj) {
		List<LinkedHashMap<String, String>> list =  new ArrayList<LinkedHashMap<String,String>>();
		//保存循环次数
		int index=listObj.size()-1;
		for (int i = 0; i < index; i++) {
			LinkedHashMap<String, String> valMapNew = new LinkedHashMap<String,String>();
			//首先拿到最近的一条数据,和上一条数据做对比,如果最新的数据和之前的数据不一样,那么把最新的一条记录标红,其他数据雷同
			valMapNew=contrastObj(listObj.get(i),listObj.get(i+1),true);
			
			//保存修饰结果
			list.add(valMapNew);
		}
		//比较结束后将最后一条数据也反序列化一次
		LinkedHashMap<String, String> valMapButtom = new LinkedHashMap<String,String>();
		valMapButtom=contrast(listObj.get(listObj.size()-1));
		list.add(valMapButtom);
		return list;
	}
	
	/**
	 * 返回序列化结果
	 * @param listObj
	 * @return
	 */
	public static List<LinkedHashMap<String, String>> returnContext(List<Object> listObj) {
		List<LinkedHashMap<String, String>> list =  new ArrayList<LinkedHashMap<String,String>>();
		//保存循环次数
		int index=listObj.size()-1;
		for (int i = 0; i < index; i++) {
			LinkedHashMap<String, String> valMapNew = new LinkedHashMap<String,String>();
			//直接返回结果
			valMapNew=contrastObj(listObj.get(i),listObj.get(i+1),false);
			
			//保存修饰结果
			list.add(valMapNew);
		}
		//比较结束后将最后一条数据也反序列化一次
		LinkedHashMap<String, String> valMapButtom = new LinkedHashMap<String,String>();
		valMapButtom=contrast(listObj.get(listObj.size()-1));
		list.add(valMapButtom);
		return list;
	}
	
	/**
	 * 判断某个类是否实现了指定的接口
	 * @param implementClass 实现类
	 * @param interfaceClass 接口
	 * @return boolean
	 * */
	static boolean isImplement(Class<?> implementClass, Class<?> interfaceClass){
		Class<?>[] clazzs = implementClass.getInterfaces();
		for (Class<?> clazz : clazzs) {
			if(clazz ==interfaceClass ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取类的信息
	 * @param object
	 * @return
	 */
	@SuppressWarnings({"unchecked" })
	public static List<LinkedHashMap<String, String>> getDetial(Object object) {
		List<LinkedHashMap<String, String>> list =  new ArrayList<LinkedHashMap<String,String>>();
		LinkedHashMap<String, String> valMap = new LinkedHashMap<String,String>();
		Class<Object> clazz = (Class<Object>) object.getClass();
		Field[] fields = object.getClass().getDeclaredFields();
		for(Field field : fields) {
			try {
				// 自定义注解类
				PropertyNameAnnotation meta = field.getAnnotation(PropertyNameAnnotation.class);
				Enums ems=field.getAnnotation(Enums.class);
				if(null!=ems){
					Class<?> enumClz=ems.enumClz();
					boolean implement=isImplement(enumClz, ICommonEnum.class);
					if(implement){
						String getMethodName = "get" + StringTool.toUpperCaseFirstOne(field.getName());
						Method method = clazz.getMethod(getMethodName);
						Object value = method.invoke(object);
						if(null==value){
							valMap.put(ems.name(),"");
						}else{
							for(Object enumObj:enumClz.getEnumConstants()){
								ICommonEnum<Object> icomEnum=(ICommonEnum<Object>)enumObj;
								if(value.equals(icomEnum.getKey())){
									valMap.put(ems.name(),Objects.toString(icomEnum.getValue(), ""));
									break;
								}
							}
						}
					}
				}
				if(meta != null) {
					String getMethodName = "get" + StringTool.toUpperCaseFirstOne(field.getName());
					Method method = clazz.getMethod(getMethodName);
					Object val = method.invoke(object);
					if(val instanceof Date) {
						DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
						if(format != null) {
							val = DateFormatUtils.format((Date) val, format.pattern());
						}
					}
					valMap.put(meta.annotation(), Objects.toString(val, ""));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		list.add(valMap);
		return list;
	}
	
	/**
	 * 比较两个Obj对象
	 * @param beginObj 前一个比较对象
	 * @param endObj  后个被比较对象
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private static LinkedHashMap<String, String> contrastObj(Object beginObj,Object endObj,boolean flag){
		LinkedHashMap<String, String> valMapNew =  new LinkedHashMap<String,String>();
		Class<Object> clazzNew = (Class<Object>) beginObj.getClass();
		Field[] fieldsNew = clazzNew.getDeclaredFields();
		
		Class<Object> clazzOld = (Class<Object>) endObj.getClass();
		Field[] fieldsOld = clazzOld.getDeclaredFields();
		for(Field field : fieldsNew) {
			// 自定义注解类
			PropertyNameAnnotation meta = field.getAnnotation(PropertyNameAnnotation.class);
			if(meta != null) {
				
				try {
					String getMethodName = "get" + StringTool.toUpperCaseFirstOne(field.getName());
					Method methodNew = clazzNew.getMethod(getMethodName);
					Method methodOld = clazzOld.getMethod(getMethodName);
					
					Object valNew = methodNew.invoke(beginObj);
					Object valOld = methodOld.invoke(endObj);
					if(flag){
						//判断是否一样
						if (!Objects.equals(valNew,valOld)) {
							if(valNew instanceof Date) {
								DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
								if(format != null) {
									valNew = DateFormatUtils.format((Date) valNew, format.pattern());
								}
							}
							String colorLeft="<span style='color:red;'>";
							String colorRight="</span>";
							//修饰内容
							valMapNew.put(meta.annotation(), colorLeft+Objects.toString(valNew, "")+colorRight);
						}else{
							if(valNew instanceof Date) {
								DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
								if(format != null) {
									valNew = DateFormatUtils.format((Date) valNew, format.pattern());
								}
							}
							//原封不动
							valMapNew.put(meta.annotation(), Objects.toString(valNew, ""));
						}
					}else{
						if(valNew instanceof Date) {
							DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
							if(format != null) {
								valNew = DateFormatUtils.format((Date) valNew, format.pattern());
							}
						}
						//修饰内容
						valMapNew.put(meta.annotation(), BeanCompileUtil.guoHtml(Objects.toString(valNew, "")));
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return valMapNew;
	}
	
	@SuppressWarnings("unused")
	public static String guoHtml(String html){
		if(!html.equals("")||html!=null){
			String str=html.replaceAll("<[.[^<]]*>","");
				   str=str.replaceAll("&nbsp;", "");
				   str=str.replaceAll("\t", "");
				   str=str.replaceAll(" ", "");
			return str;
		}else{
			return html;
		}
	}
	
	/**
	 * 将Object 转换成 Map<String, String>
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static LinkedHashMap<String, String> contrast(Object obj){
		LinkedHashMap<String, String> valMapNew =  new LinkedHashMap<String,String>();
		Class<Object> clazzButtom = (Class<Object>) obj.getClass();
		Field[] fieldsButtom = clazzButtom.getDeclaredFields();
		for(Field field : fieldsButtom) {
			// 自定义注解类
			PropertyNameAnnotation meta = field.getAnnotation(PropertyNameAnnotation.class);
			if(meta != null) {
				
				try {
					String getMethodName = "get" + StringTool.toUpperCaseFirstOne(field.getName());
					Method methodNew = clazzButtom.getMethod(getMethodName);
					
					Object valNew = methodNew.invoke(obj);
					if(valNew instanceof Date) {
						DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
						if(format != null) {
							valNew = DateFormatUtils.format((Date) valNew, format.pattern());
						}
					}
					//原封不动
					
					valMapNew.put(meta.annotation(), guoHtml(Objects.toString(valNew, "")));
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return valMapNew;
	}
	
	
	/**
	 * 比较两个Obj对象
	 * @param beginObj 前一个比较对象
	 * @param endObj  后个被比较对象
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static List<ContrastObj> contrastObj2(Object beginObj,Object endObj){
		List<ContrastObj> coList = new ArrayList<ContrastObj>();//存放修饰后的数据
		Class<Object> clazzNew = (Class<Object>) beginObj.getClass();
		Field[] fieldsNew = clazzNew.getDeclaredFields();
		
		Class<Object> clazzOld = (Class<Object>) endObj.getClass();
		Field[] fieldsOld = clazzOld.getDeclaredFields();
		for(Field field : fieldsNew) {
			// 自定义注解类
			PropertyNameAnnotation meta = field.getAnnotation(PropertyNameAnnotation.class);
			if(meta != null) {
				
				try {
					String getMethodName = "get" + StringTool.toUpperCaseFirstOne(field.getName());
					Method methodNew = clazzNew.getMethod(getMethodName);
					Method methodOld = clazzOld.getMethod(getMethodName);
					
					Object valNew = methodNew.invoke(beginObj);
					Object valOld = methodOld.invoke(endObj);
					//判断是否一样
					if (!Objects.equals(valNew,valOld)) {
						if(valNew instanceof Date || valOld instanceof Date) {
							DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
							if(format != null) {
								if(valNew!=null) {
									valNew = DateFormatUtils.format((Date) valNew, format.pattern());
								}
								if(valOld!=null) {
									valOld = DateFormatUtils.format((Date) valOld, format.pattern());
								}
							}
						}
						//修饰内容
						ContrastObj co = new ContrastObj();//修改内容
						co.setName(meta.annotation());//名称
						co.setNewValue(Objects.toString(valNew, ""));//新值
						co.setOldValue(Objects.toString(valOld, ""));//旧值
						if(!co.getNewValue().equals(co.getOldValue())) {
							coList.add(co);	
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return coList;
	}
	
	/**
	 * 获取对象的关键字信息
	 * @param obj
	 * @return json 
	 */
	@SuppressWarnings("unchecked")
	public static String getKey(Object obj){
		Map<String, String> valMap = new HashMap<String, String>();
		Class<Object> clazz = (Class<Object>) obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			KeywordsAnnotation meta = field.getAnnotation(KeywordsAnnotation.class);
			if(meta != null) {
				try {
					String getMethodName = "get" + StringTool.toUpperCaseFirstOne(field.getName());
					Method method = clazz.getMethod(getMethodName);
					Object val = method.invoke(obj);
					valMap.put(meta.annotation(), Objects.toString(val, ""));
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		String jsonKeys = JSON.toJSONString(valMap);
		return jsonKeys;
	}
	
	/**
	 * 获取有注解的属性信息 
	 *
	 * @Title: getClassFields 
	 * @param object
	 * @return 
	 * @return Map<String,List<String>>
	 * @throws
	 */
	public static Map<String, List<String>> getClassFields(Object object) {
		List<String> colNames = new ArrayList<String>();
		List<String> colModel = new ArrayList<String>();
		Map<String, List<String>> fieldsInfos = new HashMap<String, List<String>>();
		Field[] fields = object.getClass().getDeclaredFields();
		for(Field field : fields) {
			try {
				PropertyNameAnnotation meta = field.getAnnotation(PropertyNameAnnotation.class);
				if(meta != null) {
					colNames.add(meta.annotation());
					colModel.add(field.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		fieldsInfos.put("colNames", colNames);
		fieldsInfos.put("colModel", colModel);
		return fieldsInfos;
	}
}
