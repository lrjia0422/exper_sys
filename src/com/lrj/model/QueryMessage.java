package com.lrj.model;

public class QueryMessage {

	private String stu_id;

	public QueryMessage(String stu_id) {
		super();
		this.stu_id = stu_id;
	}

	public QueryMessage() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
}
