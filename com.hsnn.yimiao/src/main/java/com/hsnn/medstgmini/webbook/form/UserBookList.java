package com.hsnn.medstgmini.webbook.form;

/**
 * 用户书籍列表实体
 */
public class UserBookList {

	private String ID;// 图书ID

	private String userId;// 图书ID

	private String name;// 用户名

	private String bookUrl;// 书籍地址

	private String imgUrl;// 书籍图片地址

	private String lastPageName;// 最后更新章节

	private String bookMark;// 最后浏览章节

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getLastPageName() {
		return lastPageName;
	}

	public void setLastPageName(String lastPageName) {
		this.lastPageName = lastPageName;
	}

	public String getBookMark() {
		return bookMark;
	}

	public void setBookMark(String bookMark) {
		this.bookMark = bookMark;
	}
}
