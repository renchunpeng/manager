package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-03-02 10:58:46
 *
 */
public class StdGoodsClear implements ICreateInfo,IUpdateInfo{
	
	private StdGoods stdGoods;//产品信息
	private StdProduct stdProduct;//药品信息
	
	//alias
	public static final String TABLE_ALIAS = "StdGoodsClear";
	
	//columns START
	/**
	 * @Fields clearId:clearId
	 */
	private Integer clearId;
	
	/**
	 * @Fields goodsId:产品ID
	 */
	private Integer goodsId;
	
	/**
	 * @Fields clearContent:clearContent
	 */
	private String clearContent;
	
	/**
	 * @Fields vbeforeProcess:申请处理前值
	 */
	private String vbeforeProcess;
	
	/**
	 * @Fields vafterProcess:申请处理后值
	 */
	private String vafterProcess;
	
	/**
	 * @Fields clearExplain:澄清说明
	 */
	private String clearExplain;
	
	/**
	 * @Fields sort:sort
	 */
	private Integer sort;
	
	/**
	 * @Fields clearPictures:clearPictures
	 */
	private String clearPictures;
	
	/**
	 * @Fields clearPicturesUseful:clearPicturesUseful
	 */
	private String clearPicturesUseful;
	
	/**
	 * @Fields clearUserId:clearUserId
	 */
	private String clearUserId;
	
	/**
	 * @Fields clearTime:clearTime
	 */
	private Date clearTime;
	
	/**
	 * @Fields clearSequence:澄清批次
	 */
	private Integer clearSequence;
	
	/**
	 * @Fields isOnlineClear:是否网上澄清0否1是
	 */
	private Integer isOnlineClear;
	
	/**
	 * @Fields clearStatus:澄清状态1保存2提交3审核通过4审核未通过
	 */
	private Integer clearStatus;
	
	/**
	 * @Fields onlineClearStatus:网上澄清审核状态1澄清待审核2澄清审核通过3澄清审核未通过
	 */
	private Integer onlineClearStatus;
	
	/**
	 * @Fields auditExplain:审核说明
	 */
	private String auditExplain;
	
	/**
	 * @Fields addUserId:记录添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:记录添加人
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:记录添加时间
	 */
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	private Date lastUpdateTime;
	
	/**
	 * @Fields clearColumn:澄清字段
	 */
	private String clearColumn;
	
	private String beforClearStatus;//更改前的状态
	private String beforOnlineClearStatus;
	
	//columns END

	public StdGoodsClear(){
	}

	public StdGoodsClear(Integer clearId){
		this.clearId = clearId;
	}

	
	public void setClearId(Integer clearId){
		this.clearId = clearId;
	}
	
	public Integer getClearId(){
		return clearId;
	}
	
	public void setGoodsId(Integer goodsId){
		this.goodsId = goodsId;
	}
	
	public Integer getGoodsId(){
		return goodsId;
	}
	
	public void setClearContent(String clearContent){
		this.clearContent = clearContent;
	}
	
	public String getClearContent(){
		return clearContent;
	}
	
	public void setVbeforeProcess(String vbeforeProcess){
		this.vbeforeProcess = vbeforeProcess;
	}
	
	public String getVbeforeProcess(){
		return vbeforeProcess;
	}
	
	public void setVafterProcess(String vafterProcess){
		this.vafterProcess = vafterProcess;
	}
	
	public String getVafterProcess(){
		return vafterProcess;
	}
	
	public void setClearExplain(String clearExplain){
		this.clearExplain = clearExplain;
	}
	
	public String getClearExplain(){
		return clearExplain;
	}
	
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	public Integer getSort(){
		return sort;
	}
	
	public void setClearPictures(String clearPictures){
		this.clearPictures = clearPictures;
	}
	
	public String getClearPictures(){
		return clearPictures;
	}
	
	public void setClearPicturesUseful(String clearPicturesUseful){
		this.clearPicturesUseful = clearPicturesUseful;
	}
	
	public String getClearPicturesUseful(){
		return clearPicturesUseful;
	}
	
	public void setClearUserId(String clearUserId){
		this.clearUserId = clearUserId;
	}
	
	public String getClearUserId(){
		return clearUserId;
	}
	
	public void setClearTime(Date clearTime){
		this.clearTime = clearTime;
	}
	
	public Date getClearTime(){
		return clearTime;
	}
	
	public void setClearSequence(Integer clearSequence){
		this.clearSequence = clearSequence;
	}
	
	public Integer getClearSequence(){
		return clearSequence;
	}
	
	public void setIsOnlineClear(Integer isOnlineClear){
		this.isOnlineClear = isOnlineClear;
	}
	
	public Integer getIsOnlineClear(){
		return isOnlineClear;
	}
	
	public void setClearStatus(Integer clearStatus){
		this.clearStatus = clearStatus;
	}
	
	public Integer getClearStatus(){
		return clearStatus;
	}
	
	public void setOnlineClearStatus(Integer onlineClearStatus){
		this.onlineClearStatus = onlineClearStatus;
	}
	
	public Integer getOnlineClearStatus(){
		return onlineClearStatus;
	}
	
	public void setAuditExplain(String auditExplain){
		this.auditExplain = auditExplain;
	}
	
	public String getAuditExplain(){
		return auditExplain;
	}
	
	public void setAddUserId(String addUserId){
		this.addUserId = addUserId;
	}
	
	public String getAddUserId(){
		return addUserId;
	}
	
	public void setAddUserName(String addUserName){
		this.addUserName = addUserName;
	}
	
	public String getAddUserName(){
		return addUserName;
	}
	
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	
	public Date getAddTime(){
		return addTime;
	}
	
	public void setLastUpdateUserId(String lastUpdateUserId){
		this.lastUpdateUserId = lastUpdateUserId;
	}
	
	public String getLastUpdateUserId(){
		return lastUpdateUserId;
	}
	
	public void setLastUpdateUserName(String lastUpdateUserName){
		this.lastUpdateUserName = lastUpdateUserName;
	}
	
	public String getLastUpdateUserName(){
		return lastUpdateUserName;
	}
	
	public void setLastUpdateTime(Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public Date getLastUpdateTime(){
		return lastUpdateTime;
	}

	public StdGoods getStdGoods() {
		return stdGoods;
	}

	public void setStdGoods(StdGoods stdGoods) {
		this.stdGoods = stdGoods;
	}

	public StdProduct getStdProduct() {
		return stdProduct;
	}

	public void setStdProduct(StdProduct stdProduct) {
		this.stdProduct = stdProduct;
	}

	public String getBeforClearStatus() {
		return beforClearStatus;
	}

	public void setBeforClearStatus(String beforClearStatus) {
		this.beforClearStatus = beforClearStatus;
	}

	public String getBeforOnlineClearStatus() {
		return beforOnlineClearStatus;
	}

	public void setBeforOnlineClearStatus(String beforOnlineClearStatus) {
		this.beforOnlineClearStatus = beforOnlineClearStatus;
	}

	public String getClearColumn() {
		return clearColumn;
	}

	public void setClearColumn(String clearColumn) {
		this.clearColumn = clearColumn;
	}
	
	
}