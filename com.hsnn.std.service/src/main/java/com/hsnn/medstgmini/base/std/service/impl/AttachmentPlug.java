package com.hsnn.medstgmini.base.std.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.hsnn.medstgmini.base.std.dao.StdAttachmentDao;
import com.hsnn.medstgmini.base.std.model.StdAttachment;
import com.hsnn.medstgmini.base.std.service.StdAttachmentManager;
import com.hsnn.medstgmini.common.model.Attachment;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.util.ParseDate;
import com.hsnn.medstgmini.util.SessionUtil;
import com.hsnn.medstgmini.util.StringTool;

@Service
public class AttachmentPlug {
	@Autowired
	private StdAttachmentManager stdAttachmentManager;
	@Autowired
	private StdAttachmentDao stdAttachmentDao;
	
	@Value("${system.uploadPath}")
	private String uploadPath;
	
	@Value("${system.sysId}")
	private String sysId;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void processAttachment(IAttachment<?> model){
		String modelId = model.getId().toString();
		String targetTable = model.getClass().getName();
		
		
		if(model.getAttachment()==null){
			model.setAttachment(new Attachment());
		}
		//获取数据(这个暂时放到这里，以后再移动)
		model.getAttachment().setAtts(getAttInfo(modelId,targetTable));
		//清理数据,如果配置了参数，并且传值过来，就进行清理
		int replaceAttachment = replaceAttachment(model.getAttachment());
		
		Map<String, MultipartFile[]> files = model.getAttachment().getFile();
		if(files==null){
			return;
		}
		List<StdAttachment> attas = new ArrayList<StdAttachment>();
		for (Map.Entry<String,MultipartFile[]> fileItem : files.entrySet()) {
			for (MultipartFile mf : fileItem.getValue()) {
				
				StdAttachment item = new StdAttachment();
				item.setAttrId(UUID.randomUUID().toString());
				item.setTargetTable(targetTable);
				item.setTargetField(fileItem.getKey());
				item.setTargetId(modelId);
				item.setUpdUser(SessionUtil.getSysUser().getUserName());
				item.setSysId(sysId);
				item.setDownloadCount(0);
				
				//文件相关信息
				String filename = mf.getOriginalFilename();
				String suffix = filename.substring(filename.lastIndexOf(".")).toLowerCase();
				item.setType(mf.getContentType());
				item.setOriginName(filename);
				item.setSuffix(suffix);
				item.setName(item.getAttrId()+suffix);
				item.setRemark(""+mf.getSize());//暂时的文件大小
				item.setUrl("/attachment/download.html?id="+item.getAttrId());
				
				String dirPath = ParseDate.parseYearMonthFormat(new Date()).replaceAll("-", "\\"+File.separator);
				String relPath = dirPath+File.separator+item.getName();
				item.setRelPath(relPath);
				
				File destFile = new File(uploadPath+relPath);
				try {
					FileUtils.copyInputStreamToFile(mf.getInputStream(), destFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				attas.add(item);
			}
		}
		if(attas.size()>0){
			stdAttachmentDao.insertBatch(attas );
		}
	}
	
	private Map<String, List<StdAttachment>> getAttInfo(String targetId,String targetTable){
		Map<String, List<StdAttachment>> atts = new HashMap<String, List<StdAttachment>>();
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("targetTable", targetTable);
		params.put("targetId", targetId);
		List<StdAttachment> StdAttachments = stdAttachmentDao.queryAll(params);
		for (StdAttachment sa : StdAttachments) {
			String field = sa.getTargetField();
			if(atts.get(field)==null){
				atts.put(field, new ArrayList<StdAttachment>());
			}
			List<StdAttachment> list = atts.get(field);
			list.add(sa);
		}
		return atts;
	}
	
	private int replaceAttachment(Attachment attachment){
		if(attachment.getFile()==null){
			return 0;
		}
		Set<Entry<String,MultipartFile[]>> entrySet = attachment.getFile().entrySet();
		Map<String, String> hasReplace = attachment.getHasReplace();
		if(hasReplace == null){
			return 0;
		}
		for (Entry<String, MultipartFile[]> entry : entrySet) {
			if(entry.getValue()!=null && Boolean.parseBoolean(hasReplace.get(entry.getKey()))){
				List<StdAttachment> list = attachment.getAtts().get(entry.getKey());
				if(list!=null)
				for (StdAttachment stdAtt : attachment.getAtts().get(entry.getKey())) {
					int count=stdAttachmentDao.delete(stdAtt.getAttrId());
					if(count>0){
						deleteFile(uploadPath+File.separator+stdAtt.getRelPath());
					}
				}
			}
		}
		return 0;
	}
	
	private void deleteFile(String filePath){
		if(StringTool.isEmpty(filePath)){
			return;
		}
		File file=new File(filePath);
		if(!file.exists()){
			return;
		}
		file.delete();
	}
}
