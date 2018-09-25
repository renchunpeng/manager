package com.hsnn.medstgmini.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.StringUtils;

public class UrlUtil {
    private static HttpClient httpClient = new HttpClient();  
    
    /** 
     * @Title: getDataFromURL 
     * @Description: 根据URL跨域获取输出结果，支持http 
     * @param strURL 
     *            要访问的URL地址 
     * @param param 
     *            参数 
     * @return 结果字符串 
     * @throws Exception 
     */  
    public static String getDataFromURL(String strURL, Map<String, String> param) throws Exception {  
        URL url = new URL(strURL);  
        URLConnection conn = url.openConnection();  
        conn.setDoOutput(true);  
  
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());  
         final StringBuilder sb = new StringBuilder(param.size() << 4); // 4次方  
         final Set<String> keys = param.keySet();  
        for (final String key : keys) {  
            String value = param.get(key);  
            sb.append(key); // 不能包含特殊字符  
            sb.append('='); 
            if(StringUtils.isNotBlank(value)){
            	value = value.replaceAll("&", "%26");
            	 sb.append(value);  
            }
            sb.append('&');  
        }  
        // 将最后的 '&' 去掉  
        sb.deleteCharAt(sb.length() - 1);  
        writer.write(sb.toString());  
        writer.flush();  
        writer.close();  
  
        InputStreamReader reder = new InputStreamReader(conn.getInputStream(), "utf-8");  
        BufferedReader breader = new BufferedReader(reder);  
        // BufferedWriter w = new BufferedWriter(new FileWriter("d:/1.txt"));  
        String content = null;  
        String result = null;  
        while ((content = breader.readLine()) != null) {  
            result = content;  
        }  
  
        return result;  
    }  
  
    /** 
     * @Title: postMethod 
     * @Description: 根据URL跨域获取输出结果，支持https 
     * @param url 
     *            要访问的URL地址(http://www.xxx.com?) 
     * @param urlParm 
     *            参数(id=1212&pwd=2332) 
     * @return 结果字符串 
     */  
    public static String postMethod(String url, String urlParm) {  
        if (null == url || "".equals(url)) {  
            // url = "http://www.baidu.com";  
            return null;  
        }  
        PostMethod post = new PostMethod(url); // new UTF8PostMethod(url);  
        if (null != urlParm && !"".equals(urlParm)) {  
            String[] arr = urlParm.split("&");  
            NameValuePair[] data = new NameValuePair[arr.length];  
            for (int i = 0; i < arr.length; i++) {  
                String name = arr[i].substring(0, arr[i].lastIndexOf("="));  
                String value = arr[i].substring(arr[i].lastIndexOf("=") + 1);  
                data[i] = new NameValuePair(name, value);  
            }  
            post.setRequestBody(data);  
        }  
        int statusCode = 0;  
        String pageContent = "";  
        try {  
            statusCode = httpClient.executeMethod(post);  
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {  
                pageContent = post.getResponseBodyAsString();  
                return pageContent;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        } finally {  
            post.releaseConnection();  
        }  
        return null;  
    }  
  
    public static String doPost(String url, String json) throws Exception {  
        PostMethod postMethod = new PostMethod(url);  
        StringRequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");  
        postMethod.setRequestEntity(requestEntity);  
        /* 发送请求，并获取响应对象 */  
        int statusCode = httpClient.executeMethod(postMethod);  
        String result = null;  
        if (statusCode == HttpStatus.SC_OK) {  
            result = postMethod.getResponseBodyAsString();  
        } else {  
            System.out.println("Method failed: " + postMethod.getStatusLine());  
        }  
        return result;  
    }  
 
    /**
	 * 将 url 格式的 String 转为 map
	 * @param param  aa=11&bb=22&cc=33
	 * @return
	 */
	 public static Map<String, Object> getUrlParams(String param) {
	      Map<String, Object> map = new HashMap<String, Object>();
	      if ("".equals(param) || null == param) {
	          return map;
	      }
	      String[] params = param.split("&");
	      for (int i = 0; i < params.length; i++) {
	          String[] p = params[i].split("=");
	          if (p.length == 2) {
	              map.put(p[0], p[1]);
	          }
	      }
	      return map;
	  }
    
    public static void main(String[] args) throws Exception {  
//        String url = "http://122.224.75.100:12006/com.hsnn.tradeInterface/v1/hospital/accessToken/getToken";  
//        Map<String, String> map = new HashMap<String, String>();  
//        map.put("orgId", "10");  
//        map.put("departmentId", "180");  
//        String msg = getDataFromURL(url, map);
    	
    }  
    
    public static void openDefaultLlq(String url) {
    	try {
            // 创建一个URI实例  
            java.net.URI uri = java.net.URI.create("http://www.baidu.com/");  
            // 获取当前系统桌面扩展  
            java.awt.Desktop dp = java.awt.Desktop.getDesktop() ;   
            // 判断系统桌面是否支持要执行的功能  
            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {  
                // 获取系统默认浏览器打开链接   
                dp.browse( uri ) ;  
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
