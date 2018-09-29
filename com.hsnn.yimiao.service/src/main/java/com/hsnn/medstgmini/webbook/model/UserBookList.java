package com.hsnn.medstgmini.webbook.model;

import java.util.Date;
import java.math.BigDecimal;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2018
 * @Description: TODO
 * @author ***
 * @date 2018-09-29 15:52:04
 *
 */
public class UserBookList  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "UserBookList";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private String id;
	
	/**
	 * @Fields userId:用户id
	 */
	private String userId;
	
	/**
	 * @Fields name:书名
	 */
	private String name;
	
	/**
	 * @Fields bookUrl:书籍地址
	 */
	private String bookUrl;
	
	/**
	 * @Fields imgUrl:书籍图片地址
	 */
	private String imgUrl;
	
	/**
	 * @Fields lastPageName:网站最后的章节，用于判断网站是否更新
	 */
	private String lastPageName;
	
	/**
	 * @Fields bookMark:最后一次阅读记录
	 */
	private String bookMark;
	
	//columns END

	public UserBookList(){
	}

	public UserBookList(String id){
		this.id = id;
	}

	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setBookUrl(String bookUrl){
		this.bookUrl = bookUrl;
	}
	
	public String getBookUrl(){
		return bookUrl;
	}
	
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	
	public String getImgUrl(){
		return imgUrl;
	}
	
	public void setLastPageName(String lastPageName){
		this.lastPageName = lastPageName;
	}
	
	public String getLastPageName(){
		return lastPageName;
	}
	
	public void setBookMark(String bookMark){
		this.bookMark = bookMark;
	}
	
	public String getBookMark(){
		return bookMark;
	}


	@Override
	public void setAddUserName(String addUserName) {

	}

	@Override
	public void setAddUserId(String addUserId) {

	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {

	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {

	}
}