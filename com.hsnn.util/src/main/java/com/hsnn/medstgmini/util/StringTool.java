package com.hsnn.medstgmini.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author he.fan
 */
public class StringTool {
	
	
	/**
	 * 首字母转小写
	 * @param s
	 * @return
	 */
    public static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /**
     * 首字母转大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /***
     * 非空验证
     * */
    public static boolean isEmpty(String str){
    	if(null==str||str.trim().equals("")){
    		return true;
    	}
    	return false;
    }
    
	/***
	 * 把字符串按照符号分割成数组形式
	 * @param str 待分割的字符串
	 * @param fuhao 用作分割的符号
	 * @return String[]
	 * ***/
	 public static String[] stringToArray(String str,String fuhao){
		String[] array=null;
		if(!StringTool.isEmpty(str)){
			str=truncateBothCharact(str,fuhao);
			if(str.indexOf(fuhao)!=-1){
				array=str.split(fuhao);
			}else{
				array=new String[]{str};
			}
		}
		return array=null==array?new String[]{}:array;
	}
	 
	/**
	 * 如果给定的字符串、的首尾字母包含符号的话，那么就截掉如:(,1,3,4,56,37,)截取后为:(1,3,4,56,37)
	 * @param str 待截取的字符
	 * @param fuhao 是否包含字符
	 * @return 截取后的新字符
	 * */
	public static String  truncateBothCharact(String str,String fuhao){
		if(str.startsWith(fuhao)){
			str=str.substring(1,str.length());
		}
		if(str.endsWith(fuhao)){
			str=str.substring(0,str.length()-1);
		}
		return str;
	}
	 
	 /**
	  * 把str剪切不超过count个长度;
	  * @param str 待剪切的字符
	  * @param count 剪切字符的最大长度;
	  * @return 剪切后的字符串
	  * ***/
	 public static String truncate(String str,int count){
		 if(null==str) return null;
		 char[] charArray=str.toCharArray();
		 int len=charArray.length;
		 for(int i=0;i<count && i<len;i++){
			 if(charArray[i]>0XFF){
				 count--;
			 }
		 }
		 count=count>0 ?count:0;
		 int currCount=count<len?count:len;
		 return str.substring(0,currCount);
	 }
	 
	 /****
	  * 如果str小于min的长度或大于max的长度将会返回false,如果str中包含汉字将会以二个字节处理。
	  * @param str 待处理的字符串
	  * @param min 最小长度
	  * @param max 最大长度 
	  * @return true|false
	  * **/
	 public static boolean truncateStr(String str,int min,int max){
		 if(null==str) return false;
		 char[] charArray=str.toCharArray();
		 int len=charArray.length;
		 int count=0;
		 for(int i=0;i<max && i<len;i++){
			 if(charArray[i]>0XFF){
				 count+=2;
			 }else{
				 count++;
			 }
		 }
		 if(count<min)return false;
		 if(count>max) return false;
		 return true;
	 }
	 
	 /**
	  * 如果要截取的字符串存在指定的字符那么会返回截取后的字符串;
	  * @param str 待截取的字符串
	  * @param character 待截取的字符
	  * @return 截取后的新字符串
	  * ***/
	 public static String getCutStr(String str,String character){
		 String newStr=null;
		 int index = str.indexOf(character);
		 if (index != -1) {
			 newStr = str.substring(0, index);
			 return newStr;
		 }else{
			return str; 
		 }
	 }
	 
	 /**
	  * 去除重复数据如:([1,3,5,7,1,3]，返回后为:[1,3,5,7])
	  * @param str[] 待去除重复的数组
	  * @return String[] 返回去除重复数组后的新数组
	  * **/
	 public static String[] repeated(String[] str){
			Map<String,String> map=new HashMap<String,String>();
			String newStr[]=null;
			if(null==str || str.length<=0){
				return newStr;
			}
			for(String s:str){
				if(!map.containsKey(s)){
					map.put(s, s);
				}
			}
			List<String> list=new ArrayList<String>();
			Iterator<String> iter=map.keySet().iterator();
			while(iter.hasNext()){
				 String key=iter.next();
				 list.add(key);
			}
			newStr=new String[list.size()];
			for(int i=0;i<list.size();i++){
				newStr[i]=list.get(i);
			}
			return newStr;
		}
	 
	 /**取登陆IP地址***/
	 public static String getIPAddress() {
			InetAddress addr;
			String ipAddress = null;
			try {
				addr = InetAddress.getLocalHost();
				// 获得本机IP
				ipAddress = addr.getHostAddress().toString();
				// 获得本机名称
				// address=addr.getHostName()toString;
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return ipAddress;
		}
    /**
	 *根据给定文件名、获取其后缀名，如果给定文件名为null或为空将会返回null或空。
	 *@param fileName 待获取后缀的文件名
	 *@param fuhao 以此符号为起点
	 *@return 后缀名 
	 ****/
	public static String getSuffixByFilename(String fileName,String fuhao){
		if(isEmpty(fileName)){
			return fileName;
		}
		return fileName.substring(fileName.lastIndexOf(fuhao)).toLowerCase();
	}
	
	/**
	 * 为要操作的字符串添加分隔符(/),条件是如果str最后一个字符不是/或\(分隔符)以这个为结尾则添加之。
	 * @param str 要操作的字符串
	 * @return 处理后的字符串
	 * */
	public static String addSeparatorChar(String str){
		String lastCharacter=str.substring(str.length()-1);
		if(!lastCharacter.equals("/") && !lastCharacter.equals(File.separatorChar)){
			str+=File.separatorChar;
		  }
		return str;
	}
	
	/**
	 * 遍历object中非空的属性进行参数组装 
	 * @param object 当object不为null时才会进行参数拼接...
	 * @param addMark 标记第一个参数中第一个参数是否要加?拼接符..
	 * @return 拼接后的url..
	 * **/
	public static String jointParameter(Object object,boolean addMark) throws Exception{
		if(null==object){
			return null;
		}
		StringBuffer sb=new StringBuffer();
		Field[] fields=object.getClass().getDeclaredFields();
		int count=0;
		for(Field field:fields){
		   Method method=object.getClass().getMethod("get" + StringTool.toUpperCaseFirstOne(field.getName()));
		   Object obj=method.invoke(object, new Object[]{});
		   if(null!=obj){
			    if(StringTool.isEmpty(obj.toString())){
			    	continue;
			    }
				if(count==0 && addMark){
					sb.append("?").append(field.getName()).append("=").append(obj.toString());
				}else{
					sb.append("&").append(field.getName()).append("=").append(obj.toString());
				}
				count++;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取数字前缀
	 * @param string
	 * @return
	 */
	public static String getNumberStrPrefix(String string){
		Matcher matcher = Pattern.compile("[^0-9]").matcher(string);
		if(matcher.find()) {
		    return string.substring(0, matcher.start());
		}
		return null;
	}
}
