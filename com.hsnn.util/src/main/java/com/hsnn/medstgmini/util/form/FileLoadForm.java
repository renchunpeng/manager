/**
 *@category 
 *@author 邱磊
 *@date 2015年11月13日 下午3:00:26
 */
package com.hsnn.medstgmini.util.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@category 
 *@author 邱磊
 *@date 2015年11月13日 下午3:00:26
 *@param 
 */
public class FileLoadForm {
	private  HttpServletRequest request;
	private HttpServletResponse response;
	private String filePath;
	private String fileName;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
