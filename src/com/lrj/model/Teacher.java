package com.lrj.model;

public class Teacher {
	public String id;
	public String userName;//�û���¼ע�������
	 public String password;//�û�����
	 //public String id;//��¼ѧ��
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
