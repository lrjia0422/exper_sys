package com.lrj.model;
public class upscore {

	private String expr_name = null;
	private String student_id = null;
	private String pici = null;
	private int score = 0;
	
	
	
	

	public upscore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public upscore(String expr_name, String student_id, String pici, int score) {
		super();
		this.expr_name = expr_name;
		this.student_id = student_id;
		this.pici = pici;
		this.score = score;
	}



	public String getExpr_name() {
		return expr_name;
	}

	public void setExpr_name(String expr_name) {
		this.expr_name = expr_name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getPici() {
		return pici;
	}

	public void setPici(String pici) {
		this.pici = pici;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

