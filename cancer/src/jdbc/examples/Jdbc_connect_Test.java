package jdbc.examples;
import java.sql.*;

public class Jdbc_connect_Test {
	public static void main (String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이바
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "root","dongyang"); // JDBC ����
			//Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.55.4:3306/javadb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "exme","1q2w3e"); // JDBC ����
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 못찾다!");
		} catch (SQLException e) {
			System.out.println("DB연결 오류");
		}
	}
}