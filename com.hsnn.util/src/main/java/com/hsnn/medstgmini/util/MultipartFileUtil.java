package com.hsnn.medstgmini.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MultipartFileUtil {

	public static List<String> fileUpload(List<MultipartFile> multipartFileList,String fileUploadUrl) {
		//创建HttpClient
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建HttpPost请求
		HttpPost httpPost = new HttpPost(fileUploadUrl);
		//预防中文乱码
		ContentType contentType = ContentType.create("text/plain",Charset.forName("UTF-8"));
		InputStream stream = null;
		List<String> strList = new ArrayList<String>();
		try {
			if(null != multipartFileList) {
				for(MultipartFile multipartFile : multipartFileList) {
					MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
					//文件名
 					String originalName = multipartFile.getOriginalFilename();
					//后缀名
					String suffix = originalName.substring(originalName.lastIndexOf(".")+1).toLowerCase();
					multipartEntityBuilder.addTextBody("suffix", suffix);
					multipartEntityBuilder.addTextBody("originalName",originalName,contentType);
					multipartEntityBuilder.addTextBody("fileSize",String.valueOf(multipartFile.getSize()));
					stream = multipartFile.getInputStream();
					multipartEntityBuilder.addBinaryBody("file",stream);
					HttpEntity httpEntity = multipartEntityBuilder.build();
					httpPost.setEntity(httpEntity);
					CloseableHttpResponse response = httpClient.execute(httpPost);
					try {
						httpEntity = response.getEntity();
						String str = EntityUtils.toString(httpEntity);
						strList.add(str);
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						response.close();
					}
				}
				return strList;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
				if(null != stream) {
					stream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
