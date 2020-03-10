package com.lrj.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lrj.model.*;


/**
 * 学生选课dao类
 * @author SXN
 *
 */
public class CHOOSEDao {
	/**
	 * 学生选课添加
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
	 * 学生选课查看dao类
	 */
	public ResultSet list(Connection con,CHOOSE choose)throws Exception{
		StringBuffer sb=new StringBuffer("select * from choose where student_id='"+choose.getStu_id()+"'");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 学生查看选课判断dao类
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
