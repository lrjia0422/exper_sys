package com.lrj.model;
/**
 * 实验类别实体
 * @author SXN
 *
 */
public class Expr {

	private String name;
	private String date;
	private int classroom_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getClassroom_id() {
		return classroom_id;
	}
	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
}
