package jdbc.examples;

import java.sql.*;
public class Jdbc_connectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/javadb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
		//Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.55.4:3306/javadb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "exme","1q2w3e"); // JDBC 연결
		String id = "root";
		String password = "dongyang";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
			/*PreparedStatement psmt = con.prepareStatement("asdf");
			psmt.clearParameters();*/
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
	
	}

}
