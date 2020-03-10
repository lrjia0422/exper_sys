package com.lrj.model;
/**
 * 学生选课填入的信息实体
 * @author SXN
 *
 */
public class ChooseMessage {

	public ChooseMessage(String student_id, String name) {
		super();
		this.student_id = student_id;
		this.name = name;
	}
	public ChooseMessage() {
		super();
		// TODO 自动生成的构造函数存根
	}
	private String student_id;
	private String name;
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
