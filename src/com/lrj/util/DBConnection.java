package com.lrj.util;
import java.sql.*;
public class DBConnection{
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/expr?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","123qweasd");
		
		public static Connection getcon()throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shiyan?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","lrj123");
			return con;
	}
		public static void closeConnection(Connection con)throws Exception{
			if(con!=null) {
				con.close();
			}
		}
		public static PreparedStatement getPstmt(Connection conn, String sql)
				throws SQLException {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			return pstmt;
		}

		public static void closePstmt(PreparedStatement pstmt) {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		public static ResultSet executeQuery(PreparedStatement pstmt) throws SQLException {
			ResultSet rs = pstmt.executeQuery();
			return rs;
		}
		
		public static void closeRs(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		/*public static void main(String[] args) {
			try {
				DBConnection.getcon();
				System.out.println("连接成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}