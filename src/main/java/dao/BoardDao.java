package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import dbutil.DBConnection;
import dto.BoardDto;
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
	
	//글 번호로 글의 상세내용을 반환하는 메소드
	public BoardDto boardView(String boardnum) {
		
		String sql="SELECT * FROM board WHERE boardnum=?";
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardnum);			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) { //참->상세 내용을 보려는 글이 존재한다는 이야기
				int bnum = rs.getInt("boardnum"); //글번호
				String title = rs.getString("title"); //글제목
				String content = rs.getString("content"); //글내용
				int hit = rs.getInt("hit"); //조회수
				String userid = rs.getString("userid"); //작성자
				Timestamp regdate = rs.getTimestamp("regdate"); //작성일
				
				BoardDto bDto = new BoardDto(bnum, title, content, userid, hit, regdate);
				return bDto;
			} else { //해당 글이 존재하지 않는다는 이야기
				return null;
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		return null;
		
	}		
	
	//글 조회수 증가 메소드
	public void updateHit(String boardnum) {
		String sql="UPDATE board SET hit=hit+1 WHERE boardnum=?";
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardnum);
			
			pstmt.executeUpdate(); //조회수 증가(결과값 필요없음)
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
