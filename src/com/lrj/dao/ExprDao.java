package com.lrj.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ʵ��dao��
 * @author SXN
 *
 */
public class ExprDao {
	/**
	 * ��ѯ��ѡʵ��
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
