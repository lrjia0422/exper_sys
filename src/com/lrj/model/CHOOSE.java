package com.lrj.model;
/**
 * ѧ��ѡ��ʵ��
 * @author SXN
 *
 */
public class CHOOSE {
	private String stu_id;//ѧ��id
	private String expr_name;//ʵ������
	
	public CHOOSE() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
