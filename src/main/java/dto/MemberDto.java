package dto;

import java.sql.Timestamp;

public class MemberDto {
	
	private String userid; //PK
	private String userpw;
	private String username;
	private String email;
	private Timestamp userdate; //가입일
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(String userid, String userpw, String username, String email, Timestamp userdate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
		this.userdate = userdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getUserdate() {
		return userdate;
	}
	public void setUserdate(Timestamp userdate) {
		this.userdate = userdate;
	}
	
	

}
