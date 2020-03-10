package com.lrj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBhelper {
	static String Driver = "com.mysql.cj.jdbc.Driver";
	 static String URL = "jdbc:mysql://localhost:3306/shiyan?useSSL=false&serverTimezone=CTT&allowPublicKeyRetrieval=true";  
	   //"jdbc:mysql://localhost:3307/LibraryManagerSystem?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";//mysqlĬ��ʱ��Ϊ���������ߣ��й��Ƕ�������Ҫ�ı�ʱ��
	 static String DBname = "root";
	 static String DBpassword = "lrj123";
	 //��ȡ���ݿ�����
	 private static Connection getConn() {
	  Connection conn = null;
	  try {
	   Class.forName(Driver); //����������ַ������Ƶ����ӿ�������������
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
