package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;

import dbutil.DBConnection;

public class MemberDao {
	
	//회원 가입 메소드
	public int insertMember(String userid, String userpw, String username, String email) {
		
		String sql="INSERT INTO "
				+ "member(userid, userpw, username, email)"
				+ "VALUES (?,?,?,?)";
		int result = 0;
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			pstmt.setString(3, username);
			pstmt.setString(4, email);
			
			result = pstmt.executeUpdate(); //가입 성공시 1이 반환
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result; //성공했을때 1이 반환, 실패했을때 0이 반환
	}
	

}
