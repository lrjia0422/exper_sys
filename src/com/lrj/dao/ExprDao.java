package com.lrj.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 实验dao类
 * @author SXN
 *
 */
public class ExprDao {
	/**
	 * 查询可选实验
	 * @param con
	 * @param choose
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con)throws Exception{
		StringBuffer sb=new StringBuffer("select * from expr");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
}
