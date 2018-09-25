package com.hsnn.medstgmini.common.model;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.hsnn.medstgmini.base.std.model.StdAttachment;


/**
 *
 * @author ZXL
 * @date 2016-03-03
 * 基本思路：
 * 同一个页面，只能是一个实体对象的操作，如果是不同实体(targetTable),那么需要自己处理
 * file 对象的key就是targetKey字段，然后里面存放的是文件对象，
 * 在新增的时候去保存附件
 * 在修改的时候去根据delIds或者 clear删除附件
 * 在获取的时，会去查询附件
 */
public class Attachment  {
	//如果不是自动删除的话，可以指定删除那些附件
	private String[] delIds;
	//自动清理会删除历史的数据
//	private boolean clear;
	private String targetTable;
	
	private String targetId;
	//上传过来的对象
	private Map<String,MultipartFile[]> file;
	private Map<String,String> hasReplace;
	
	//可用于获取的对象
	private Map<String,List<StdAttachment>> atts;
	
	public String getTargetTable() {
		return targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public Map<String,MultipartFile[]> getFile() {
		return file;
	}

	public void setFile(Map<String,MultipartFile[]> file) {
		this.file = file;
	}

	public String[] getDelIds() {
		return delIds;
	}

	public void setDelIds(String[] delIds) {
		this.delIds = delIds;
	}

	public Map<String, String> getHasReplace() {
		return hasReplace;
	}

	public void setHasReplace(Map<String, String> hasReplace) {
		this.hasReplace = hasReplace;
	}

	public Map<String,List<StdAttachment>> getAtts() {
		return atts;
	}

	public void setAtts(Map<String,List<StdAttachment>> atts) {
		this.atts = atts;
	}
	
}