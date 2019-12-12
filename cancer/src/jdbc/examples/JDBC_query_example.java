package jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import smartProject.HttpServletRequest;
import smartProject.ProductBean;

public class JDBC_query_example {
	
	 public static Connection makeConnection()
	    {
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
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버를 찾을 수 없습니다.");
			} catch (SQLException e) {
				System.out.println("연결에 실패하였습니다.");
			}finally {
				con.close();
			}
		
			return con;
	    }
	 
	   public boolean insertProduct(HttpServletRequest req) {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        boolean result = false;
	        try {
	     

	            con = pool.getConnection();
	            String query = "insert into shop_product(name, price, detail, date, stock, image)"
	                    + "values(?, ?, ?, now(), ?, ?)";
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, multi.getParameter("name"));
	            pstmt.setString(2, multi.getParameter("price"));
	            pstmt.setString(3, multi.getParameter("detail"));
	            pstmt.setString(4, multi.getParameter("stock"));

	            if (multi.getFilesystemName("image") == null) {
	                pstmt.setString(5, "ready.gif");
	            } else {
	                pstmt.setString(5, multi.getFilesystemName("image"));
	            }
	            int count = pstmt.executeUpdate();
	            if (count == 1) result = true;

	        } catch (Exception ex) {
	            System.out.println("Exception :" + ex);
	        } finally {
	            pool.freeConnection(con, pstmt);
	        }
	        return result;
	    }
	   
	    public ProductBean getProduct(String no) {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        ProductBean product = null;

	        try {
	            con = pool.getConnection();
	            String query = "select * from shop_product where no=?";
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, no);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                product = new ProductBean();
	                product.setNo(rs.getInt("no"));
	                product.setName(rs.getString("name"));
	                product.setPrice(rs.getString("price"));
	                product.setDetail(rs.getString("detail"));
	                product.setDate(rs.getString("date"));
	                product.setStock(rs.getString("stock"));
	                product.setImage(rs.getString("image"));
	            }
	        } catch (Exception ex) {
	            System.out.println("Exception :" + ex);
	        } finally {
	            pool.freeConnection(con, pstmt, rs);
	        }
	        return product;

	    }
}
