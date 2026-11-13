package dto;

import java.sql.Timestamp;

public class BoardDto {
	
	private int boardnum; //PK
	private String title;
	private String content;
	private String userid; //글 작성자
	private int hit;
	private Timestamp regdate; //글 등록일
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int boardnum, String title, String content, String userid, int hit, Timestamp regdate) {
		super();
		this.boardnum = boardnum;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.hit = hit;
		this.regdate = regdate;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
	
}
