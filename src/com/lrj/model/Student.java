package com.lrj.model;
import java.sql.*;
import java.util.*;
@SuppressWarnings("unused")
public class Student{
 public  String userName;//�û���¼ע�������
 public  String password;//�û�����
 public  String id;//��¼ѧ��
 public Student() {
 }
 public Student(String student_id,String student_name) {
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