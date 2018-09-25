package com.hsnn.medstgmini.base.sys.model;

import java.util.Date;
import java.math.BigDecimal;




import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-06-22 16:46:09
 *
 */
public class SysSequence  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "SysSequence";
	
	//columns START
	/**
	 * @Fields sequenceId:sequenceId
	 */
	private String sequenceId;
	
	/**
	 * @Fields sequenceNum:sequenceNum
	 */
	private String sequenceNum;
	
	/**
	 * @Fields remark:remark
	 */
	private String remark;
	
	//columns END

	public SysSequence(){
	}

	public SysSequence(String sequenceId,String sequenceNum){
		this.sequenceId = sequenceId;
		this.sequenceNum = sequenceNum;
	}

	
	public void setSequenceId(String sequenceId){
		this.sequenceId = sequenceId;
	}
	
	public String getSequenceId(){
		return sequenceId;
	}
	
	public void setSequenceNum(String sequenceNum){
		this.sequenceNum = sequenceNum;
	}
	
	public String getSequenceNum(){
		return sequenceNum;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAddUserName(String addUserName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAddUserId(String addUserId) {
		// TODO Auto-generated method stub
		
	}


}