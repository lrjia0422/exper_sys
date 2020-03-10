package com.lrj.dao;

import com.lrj.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 学生选课填入的信息dao类
 * @author SXN
 *
 */
public class ChooseMessageDao {

	public ChooseMessage choose(Connection con,ChooseMessage cm)throws Exception{
		ChooseMessage resultcm=null;
		String sql="select * from student natural join expr where student_id=? and name=? ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,cm.getStudent_id());
		pstmt.setString(2,cm.getName() );
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultcm=new ChooseMessage();
			resultcm.setStudent_id("student_id");
			resultcm.setName("name");
		}
		return resultcm;
	}
}
