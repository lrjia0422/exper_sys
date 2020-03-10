package com.lrj.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lrj.util.DBConnection;

public class TeacherManger {
	public static boolean add(Teacher s) throws Exception {//添加成员
		Connection con=null;
		PreparedStatement psmt=null;
		boolean flag=false;
		try {
			con=DBConnection.getcon();
			String sql="insert into teacher(teacher_id,teacher_name,password)values(?,?,?)";
			psmt=con.prepareStatement(sql);
			psmt.setString(1,s.getId());
			psmt.setString(2,s.getUserName());
			psmt.setString(3,s.getPassword());
			if(psmt.executeUpdate()>0) {
				flag=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.closePstmt(psmt);
			DBConnection.closeConnection(con);
		}
		return flag;
	}
	public static Teacher check(String studentID, String password) throws PasswordNotFoundException,StudentNotFoundException, Exception {
		Teacher teacher = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getcon();
			String sql = "select * from teacher where teacher_id= ?";
			psmt = DBConnection.getPstmt(conn, sql);
			psmt.setString(1, studentID);
			rs = DBConnection.executeQuery(psmt);
			if (!rs.next()) {
				//System.out.print("用户不存在");
				throw new StudentNotFoundException();
			} else if (!rs.getString("password").trim().equals(password)) {
				// System.out.println(rs.getString("password"));
				// System.out.println(password);
				throw new PasswordNotFoundException();
			} else {
				teacher = new Teacher(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeRs(rs);
			DBConnection.closePstmt(psmt);
			DBConnection.closeConnection(conn);
		}
		return teacher;
	}


}
