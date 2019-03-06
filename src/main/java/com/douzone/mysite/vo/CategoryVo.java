package com.douzone.mysite.vo;

public class CategoryVo {
	private long no;
	private long postCount;
	private String name;
	private String description;
	private String reg_Date;
	private long user_No;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getPostCount() {
		return postCount;
	}
	public void setPostCount(long postCount) {
		this.postCount = postCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(String reg_Date) {
		this.reg_Date = reg_Date;
	}
	public long getUser_No() {
		return user_No;
	}
	public void setUser_No(long user_No) {
		this.user_No = user_No;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", postCount=" + postCount + ", name=" + name + ", description=" + description
				+ ", reg_Date=" + reg_Date + ", user_No=" + user_No + "]";
	}
	
	
	
	
	
	
}
