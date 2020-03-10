package com.lrj.dao;
import java.sql.*;

import com.lrj.model.PasswordNotFoundException;
import com.lrj.model.Student;
import com.lrj.model.StudentNotFoundException;
import com.lrj.util.DBConnection;;;
public class Manager {//管理学生信息
	public static boolean add(Student s) throws Exception {//添加学生信息
		Connection con=null;
		PreparedStatement psmt=null;
		boolean flag=false;
		try {
			con=DBConnection.getcon();
			String sql="insert into student(student_id,student_name,password)values(?,?,?)";
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
	public static boolean delete(int id) throws Exception {//删除学生信息
		Connection con=null;
		PreparedStatement psmt=null;
		boolean flag=false;
		try {
			con=DBConnection.getcon();
			String sql="delete student where student_id=?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1,id);
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
	/*public static Student check(String id, String password)
			throws Exception{
		Student student = null;
		Connection con = null;
		PreparedStatement psmt = null;
		//ResultSet rs = null;
		try {
			con =DBConnection.getcon();
			String sql = "select * from student where student_id = ?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
		}
		return student;
	}*/
	public static Student check(String studentID, String password) throws PasswordNotFoundException,StudentNotFoundException, Exception {
		Student student = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getcon();
			String sql = "select * from student where student_id= ?";
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
				student = new Student(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeRs(rs);
			DBConnection.closePstmt(psmt);
			DBConnection.closeConnection(conn);
		}
		return student;
	}

}
 