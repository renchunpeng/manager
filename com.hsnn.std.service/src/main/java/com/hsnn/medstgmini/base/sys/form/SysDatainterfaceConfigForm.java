package com.hsnn.medstgmini.base.sys.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-05-23 09:58:08
 *
 */
public class SysDatainterfaceConfigForm  {

	//columns START
	
	/**
	 * @Fields interface_id:接口编号
	 */
	@NotEmpty(message = "请填写接口编号")
	@Length(max = 255, message = "接口编号的长度不能超过{1}")
	private String interfaceId;
	
	/**
	 * @Fields interface_name:接口名称
	 */
	@Length(max = 255, message = "接口名称的长度不能超过{1}")
	private String interfaceName;
	
	/**
	 * @Fields interface_url:接口URL
	 */
	@Length(max = 255, message = "接口URL的长度不能超过{1}")
	private String interfaceUrl;
	
	/**
	 * @Fields access_interval_limit:访问间隔限制
	 */
	@Range(message = "数值范围不正确")
	private Integer accessIntervalLimit;
	
	/**
	 * @Fields input_data_count_limit:输入数据限制
	 */
	@Range(message = "数值范围不正确")
	private Integer inputDataCountLimit;
	
	/**
	 * @Fields output_data_count_limit:输出数据颗粒度限制
	 */
	@Range(message = "数值范围不正确")
	private Integer outputDataCountLimit;
	
	/**
	 * @Fields is_using:是否启用
	 */
	@Range(message = "数值范围不正确")
	private Integer isUsing;
	//columns END
	

	public SysDatainterfaceConfigForm(){
	}

	public SysDatainterfaceConfigForm(String interfaceId){
		this.interfaceId = interfaceId;
	}

	
	public void setInterfaceId(String interfaceId){
		this.interfaceId = interfaceId;
	}
	public String getInterfaceId(){
		return interfaceId;
	}
	
	public void setInterfaceName(String interfaceName){
		this.interfaceName = interfaceName;
	}
	public String getInterfaceName(){
		return interfaceName;
	}
	
	public void setInterfaceUrl(String interfaceUrl){
		this.interfaceUrl = interfaceUrl;
	}
	public String getInterfaceUrl(){
		return interfaceUrl;
	}
	
	public void setAccessIntervalLimit(Integer accessIntervalLimit){
		this.accessIntervalLimit = accessIntervalLimit;
	}
	public Integer getAccessIntervalLimit(){
		return accessIntervalLimit;
	}
	
	public void setInputDataCountLimit(Integer inputDataCountLimit){
		this.inputDataCountLimit = inputDataCountLimit;
	}
	public Integer getInputDataCountLimit(){
		return inputDataCountLimit;
	}
	
	public void setOutputDataCountLimit(Integer outputDataCountLimit){
		this.outputDataCountLimit = outputDataCountLimit;
	}
	public Integer getOutputDataCountLimit(){
		return outputDataCountLimit;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	public Integer getIsUsing(){
		return isUsing;
	}

}