package com.hsnn.medstgmini.base.sys.model;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-05-23 09:58:08
 *
 */
public class SysDatainterfaceConfig{
	
	//alias
	public static final String TABLE_ALIAS = "SysDatainterfaceConfig";
	
	//columns START
	/**
	 * @Fields interfaceId:接口编号
	 */
	private String interfaceId;
	
	/**
	 * @Fields interfaceName:接口名称
	 */
	private String interfaceName;
	
	/**
	 * @Fields interfaceUrl:接口URL
	 */
	private String interfaceUrl;
	
	/**
	 * @Fields accessIntervalLimit:访问间隔限制
	 */
	private Integer accessIntervalLimit;
	
	/**
	 * @Fields inputDataCountLimit:输入数据限制
	 */
	private Integer inputDataCountLimit;
	
	/**
	 * @Fields outputDataCountLimit:输出数据颗粒度限制
	 */
	private Integer outputDataCountLimit;
	
	/**
	 * @Fields isUsing:是否启用
	 */
	private Integer isUsing;
	
	//columns END

	public SysDatainterfaceConfig(){
	}

	public SysDatainterfaceConfig(String interfaceId){
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