package com.lrj.model;

public class Teacher {
	public String id;
	public String userName;//用户登录注册的姓名
	 public String password;//用户密码
	 //public String id;//登录学号
	 public Teacher() {
	 }
	 public Teacher(String student_id,String student_name) {
		 this.id=student_id;
		 this.userName=student_name;
	 }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
