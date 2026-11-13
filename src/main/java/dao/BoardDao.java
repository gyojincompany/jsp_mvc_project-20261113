package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import dbutil.DBConnection;
import dto.BoardJoinDto;
import dto.MemberDto;

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
	
	//게시판 모든 글 목록 불러오는 메소드
	public ArrayList<BoardJoinDto> boardList() {
		
		String sql = "SELECT "
				+ "B.boardnum,"
				+ "B.title,"
				+ "B.content,"
				+ "B.regdate,"
				+ "B.hit,"
				+ "M.userid,"
				+ "M.username,"
				+ "M.email"
				+ " FROM board B "
				+ "INNER JOIN member M "
				+ "ON B.userid = M.userid "
				+ "ORDER BY B.boardnum DESC";
		
		ArrayList<BoardJoinDto> boardList = new ArrayList<BoardJoinDto>();
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) { //글 목록에서 글의 수만큼 반복
				int boardnum = rs.getInt("boardnum"); //글번호
				String userid = rs.getString("userid"); //글 제목
				String content = rs.getString("content"); //글 내용
				int hit = rs.getInt("hit"); //글번호
				String title = rs.getString("title"); //글 작성자 아이디
				String username = rs.getString("username"); //글 작성자 이름
				String email = rs.getString("email"); //글 작성자 이메일
				Timestamp regdate = rs.getTimestamp("regdate"); //글 작성일시
				
				BoardJoinDto BJDto = new BoardJoinDto(boardnum, title, content, userid, hit, regdate, username, email);
				
				boardList.add(BJDto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
		
	}
	
	
	
}
