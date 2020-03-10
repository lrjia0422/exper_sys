package com.lrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.lrj.model.upscore;

public class upscoreDao {

	public int addscore(Connection con,upscore up) throws Exception {
		String sql = "insert into mark values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, up.getExpr_name());
		pstmt.setString(2,up.getStudent_id());
		pstmt.setString(3, up.getPici());
		pstmt.setInt(4, up.getScore());
		return pstmt.executeUpdate();
	}
}
