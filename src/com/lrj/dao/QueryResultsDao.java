package com.lrj.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lrj.model.*;


public class QueryResultsDao {

	/**
	 * ѧ���鿴�ɼ�dao��
	 */
	public ResultSet list(Connection con,QueryResults qr)throws Exception{
		StringBuffer sb=new StringBuffer("select * from mark where student_id='"+qr.getStudent_id()+"'");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
}
