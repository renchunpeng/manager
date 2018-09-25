package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;

public class StdCataProdRelFile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 111225503649133864L;

	//alias
	public static final String TABLE_ALIAS = "StdCataProdRelFile";
	
	//columns START
	
	/**
	 * @Fields Id:基础库_目录药品关联表文件表id
	 */
	@PropertyNameAnnotation(annotation="基础库_目录药品关联表文件表id")
	private String id;
	
	/**
	 * @Fields fileName:文件名
	 */
	@PropertyNameAnnotation(annotation="文件名")
	private String fileName;
	
	/**
	 * @Fields fileOrginalName:文件原始名
	 */
	@PropertyNameAnnotation(annotation="文件原始名")
	private String fileOrginalName;
	
	/**
	 * @Fields status:状态
	 */
	@PropertyNameAnnotation(annotation="状态")
	private Integer status;
	
	/**
	 * @Fields fileType:文件类型
	 */
	@PropertyNameAnnotation(annotation="文件类型")
	private Integer fileType;
	
	
	/**
	 * @Fields userId:用户id
	 */
	@PropertyNameAnnotation(annotation="用户id")
	private String userId;
	
	/**
	 * @Fields uploadDatetime:上传时间
	 */
	@PropertyNameAnnotation(annotation="上传时间")
	private String uploadDatetime;
	
	/**
	 * @Fields filePath:文件路径
	 */
	@PropertyNameAnnotation(annotation="filePath")
	private String filePath;
	
	/**
	 * @Fields checkFilePath:审核文件路径
	 */
	@PropertyNameAnnotation(annotation="审核文件路径")
	private String checkFilePath;
		

	
	/**
	 * @Fields updUser:更新人
	 */
	@PropertyNameAnnotation(annotation="更新人")
	private String updUser;
	
	/**
	 * @Fields updDatetime:更新时间
	 */
	@PropertyNameAnnotation(annotation="更新时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updDatetime;

	//columns END
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOrginalName() {
		return fileOrginalName;
	}

	public void setFileOrginalName(String fileOrginalName) {
		this.fileOrginalName = fileOrginalName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUploadDatetime() {
		return uploadDatetime;
	}

	public void setUploadDatetime(String uploadDatetime) {
		this.uploadDatetime = uploadDatetime;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCheckFilePath() {
		return checkFilePath;
	}

	public void setCheckFilePath(String checkFilePath) {
		this.checkFilePath = checkFilePath;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}
	
	

	
	
	
}