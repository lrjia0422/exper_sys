package com.lrj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	static String jdbcName = "com.mysql.cj.jdbc.Driver";
	static String dbUrl = "jdbc:mysql://localhost:3306/shiyan?useSSL=false&serverTimezone=CTT";  
			//"jdbc:mysql://localhost:3307/LibraryManagerSystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";//mysql默认时区为本初子午线，中国是东八区，要改变时区
	static String dbUserName = "root";
	static String dbPassword = "lrj123";
	
	public Connection getConn() throws Exception  {
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		
		
		return conn;
	}
	
	public void closeCon(Connection con) throws Exception {
		if(con!=null);
		con.close();
	}
	
	public static void main(String[]args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getConn();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
