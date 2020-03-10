package com.lrj.model;
/**
 * 学生选课实体
 * @author SXN
 *
 */
public class CHOOSE {
	private String stu_id;//学生id
	private String expr_name;//实验名称
	
	public CHOOSE() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public CHOOSE(String stu_id) {
		super();
		this.stu_id = stu_id;
	}

	public CHOOSE(String stu_id, String expr_name) {
		super();
		this.stu_id = stu_id;
		this.expr_name = expr_name;
	}

	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getExpr_name() {
		return expr_name;
	}
	public void setExpr_name(String expr_name) {
		this.expr_name = expr_name;
	}
	
	
}
