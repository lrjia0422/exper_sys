package com.lrj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBhelper {
	static String Driver = "com.mysql.cj.jdbc.Driver";
	 static String URL = "jdbc:mysql://localhost:3306/shiyan?useSSL=false&serverTimezone=CTT&allowPublicKeyRetrieval=true";  
	   //"jdbc:mysql://localhost:3307/LibraryManagerSystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";//mysql默认时区为本初子午线，中国是东八区，要改变时区
	 static String DBname = "root";
	 static String DBpassword = "lrj123";
	 //获取数据库连接
	 private static Connection getConn() {
	  Connection conn = null;
	  try {
	   Class.forName(Driver); //返回与给定字符串名称的类或接口相关联的类对象。
	   conn = DriverManager.getConnection(URL,DBname,DBpassword);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return conn;
	 }
	 public PreparedStatement getPStatement(String order)throws SQLException{
		 Connection conn=getConn();
		 PreparedStatement ps=null;
		 ps=conn.prepareStatement(order);
		 return ps;
	 }
	public static void closeConn(Connection conn) {
		   try{
		    if( conn != null)
		     conn.close();
		   }catch(SQLException e) {
		    e.printStackTrace();
		   }finally {
		    conn = null;
		   }
		  }
}
