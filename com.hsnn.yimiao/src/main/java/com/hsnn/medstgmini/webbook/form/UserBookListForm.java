package com.hsnn.medstgmini.webbook.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

/**
 *
 * @Since 2010-2018
 * @Description: TODO
 * @author ***
 * @date 2018-09-29 15:52:04
 *
 */
public class UserBookListForm  {

	//columns START
	
	/**
	 * @Fields id:id
	 */
	@NotEmpty(message = "请填写id")
	@Length(max = 32, message = "id的长度不能超过{1}")
	private String id;
	
	/**
	 * @Fields user_id:用户id
	 */
	@NotEmpty(message = "请填写用户id")
	@Length(max = 32, message = "用户id的长度不能超过{1}")
	private String userId;
	
	/**
	 * @Fields name:书名
	 */
	@NotEmpty(message = "请填写书名")
	@Length(max = 255, message = "书名的长度不能超过{1}")
	private String name;
	
	/**
	 * @Fields book_url:书籍地址
	 */
	@NotEmpty(message = "请填写书籍地址")
	@Length(max = 255, message = "书籍地址的长度不能超过{1}")
	private String bookUrl;
	
	/**
	 * @Fields img_url:书籍图片地址
	 */
	@NotEmpty(message = "请填写书籍图片地址")
	@Length(max = 255, message = "书籍图片地址的长度不能超过{1}")
	private String imgUrl;
	
	/**
	 * @Fields last_page_name:网站最后的章节，用于判断网站是否更新
	 */
	@Length(max = 255, message = "网站最后的章节，用于判断网站是否更新的长度不能超过{1}")
	private String lastPageName;
	
	/**
	 * @Fields book_mark:最后一次阅读记录
	 */
	@Length(max = 255, message = "最后一次阅读记录的长度不能超过{1}")
	private String bookMark;
	//columns END
	

	public UserBookListForm(){
	}

	public UserBookListForm(String id){
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

}