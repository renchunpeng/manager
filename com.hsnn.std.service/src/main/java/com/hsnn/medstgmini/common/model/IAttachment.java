package com.hsnn.medstgmini.common.model;


/**
 * 附件接口
 * @author ZXL
 *
 */
public interface IAttachment<KEY> extends IPrimaryKey<KEY>{
	Attachment getAttachment();
	void setAttachment(Attachment attachment);
}
