package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbutil.DBConnection;

public class BoardDao {

	//새글을 db에 저장하는 메소드
	public int writeBoard(String userid, String title, String content) {
		
		String sql = "INSERT INTO board(userid, title, content, hit)"
				+ "VALUES(?,?,?,0)";
		
		int result = 0;
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);			
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate(); //가입 성공시 1이 반환
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result; //성공했을때 1이 반환, 실패했을때 0이 반환
		
	}
	
	
	
}
