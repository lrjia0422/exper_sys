package com.lrj.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lrj.model.*;


/**
 * ѧ��ѡ��dao��
 * @author SXN
 *
 */
public class CHOOSEDao {
	/**
	 * ѧ��ѡ�����
	 * @param con
	 * @param choose
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,CHOOSE choose)throws Exception{
		String sql="insert into choose values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, choose.getStu_id());
		pstmt.setString(2, choose.getExpr_name());
		return pstmt.executeUpdate();
	}
	/**
	 * ѧ��ѡ�β鿴dao��
	 */
	public ResultSet list(Connection con,CHOOSE choose)throws Exception{
		StringBuffer sb=new StringBuffer("select * from choose where student_id='"+choose.getStu_id()+"'");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * ѧ���鿴ѡ���ж�dao��
	 */
	public CHOOSE judge(Connection con,CHOOSE choose)throws Exception{
		CHOOSE resultchoose=null;
		String sql="select * from choose where student_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, choose.getStu_id());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultchoose=new CHOOSE();
			resultchoose.setStu_id("student_id");
		}
		return resultchoose;
	}

	
}
