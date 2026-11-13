package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	//DB 커넥션 준비를 위한 4개의 변수
	//사용하려는 DB의 드라이버이름, DB 서버의 주소(URL), 계정아이디, 계정비번
	private static final String driverName = "com.mysql.jdbc.Driver"; 
	private static final String url = "jdbc:mysql://localhost:3306/jsp_web"; //db이름(스키마이름)
	private static final String username = "root";
	private static final String password = "12345";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(driverName); //jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, username, password);
			//DB와 jsp 서버간의 connenction(연결통로)가 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
