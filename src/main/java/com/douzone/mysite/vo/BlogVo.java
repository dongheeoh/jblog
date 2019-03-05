package com.douzone.mysite.vo;

public class BlogVo {
	private long user_no;
	private long post_no;
	private long category_no;
	private String title;
	private String logo;
	private String name;
	private String post_title;
	private String reg_date;
	private String content;
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	public long getPost_no() {
		return post_no;
	}
	public void setPost_no(long post_no) {
		this.post_no = post_no;
	}
	public long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(long category_no) {
		this.category_no = category_no;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BlogVo [user_no=" + user_no + ", post_no=" + post_no + ", category_no=" + category_no + ", title="
				+ title + ", logo=" + logo + ", name=" + name + ", post_title=" + post_title + ", reg_date=" + reg_date
				+ ", content=" + content + "]";
	}
	
	
	
	
	
}
