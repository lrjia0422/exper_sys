package com.lrj.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lrj.model.*;

public class QueryMessageDao {

	public QueryMessage Query(Connection con,QueryMessage qm)throws Exception{
		QueryMessage resultqm=null;
		String sql="select * from mark where student_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qm.getStu_id());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultqm=new QueryMessage();
			resultqm.setStu_id("student_id");
		}
		return resultqm;
	}
}
