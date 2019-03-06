package com.douzone.mysite.vo;

public class BlogVo {
	private long userNo;
	private String title;
	private String logo;
	private String contents;
	private String postTitle;
	private String categoryName;
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", title=" + title + ", logo=" + logo + ", contents=" + contents
				+ ", postTitle=" + postTitle + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
}
