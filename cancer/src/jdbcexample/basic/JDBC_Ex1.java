package jdbcexample.basic;
import java.sql.*;
public class JDBC_Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver"); //1단계
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb?serverTimezone=UTC&autoReconnect=true&useSSL=false","root","dongyang");
			System.out.println("DB연결 완료");//2단계
			
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}

	}

}
