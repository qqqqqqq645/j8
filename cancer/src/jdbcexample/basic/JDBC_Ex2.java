package jdbcexample.basic;
import java.sql.*;
public class JDBC_Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement stmt;
		PreparedStatement pstmt;
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //1단계
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb?serverTimezone=UTC&autoReconnect=true&useSSL=false&useEncode=true&characterEncoding=utf8","root","dongyang");
			System.out.println("DB연결 완료");//2단계
			stmt = conn.createStatement();
			/*//처음 db비엇을때는 이거추가하고 했으면안함
			stmt.executeUpdate("insert into book (title,publisher, author) values('미움받을 용기','인플루엔셜','기시미 이치로');");
			pstmt = conn.prepareStatement("insert into book(title,publisher,author) values(?,?,?);");
			pstmt.setString(1,"글쓰기 특강");
			pstmt.setString(2,"생각의 길");
			pstmt.setString(3,"유시민");
			pstmt.executeUpdate();
			*/
			
			ResultSet srs = stmt.executeQuery("select * from book");
			while(srs.next()) {
				System.out.println(srs.getString("id")+"\t"+srs.getString("title")+"\t"+srs.getString("publisher")+"\t"+
			srs.getString("author"));
			}
			
			stmt.close();
			//pstmt.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			
		}

	}

}
//statement.excuteupdate
//statement.update
