package jdbcexample.basic;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class JDBC_Ex3 extends JFrame {
	public JDBC_Ex3() {
		Statement stmt;
		PreparedStatement pstmt;
		Connection conn;
		ResultSet srs;
		ResultSet fields;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //1단계
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb?serverTimezone=UTC&autoReconnect=true&useSSL=false&useEncode=true&characterEncoding=utf8","root","dongyang");
			System.out.println("DB연결 완료");//2단계
			stmt = conn.createStatement();
			srs = stmt.executeQuery("select * from book");
			//fields = stmt.executeQuery("explain book");
			
			/*while(srs.next()) {
				System.out.println(srs.getString("id")+"\t"+srs.getString("title")+"\t"+srs.getString("publisher")+"\t"+
			srs.getString("author"));
			}*/
			//fields.next();
			//String[][] recordData = new String [3][];
			/*ArrayList <String[]> recordData = new ArrayList<>();
			while(fields.next()) {
				String temp[] = new String[3];
				temp[0] = fields.getString(1);
				temp[1] = fields.getString(2);
				temp[2] = fields.getString(3);
			}*/
			setLayout(new GridLayout(4,2));
			int i=0;
			JTextField tf [] = new JTextField [3];
			while(i<tf.length) {
				tf[i++] = new JTextField();
			}
			i=0;
			while(i<3) { //상단표그리기
			//	fields.next();
				//add(new JLabel(fields.getString(1)));
				//add(new JTextField());
				add(tf[i++]);
			}
			
			JButton prev = new JButton("이전");
			prev.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if(srs.previous()) {
							int j=0;
							while(j<3)
							tf[j].setText(srs.getString(1+j++));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//if(recordData.g)
				}
			});
			JButton nxt = new JButton("다음");
			nxt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if(srs.next()) {
							int j=0;
							while(j<3)
							tf[j].setText(srs.getString(1+j++));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			add(prev);
			add(nxt);
			stmt.close();
			//pstmt.close();
			conn.close();
			
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			
		}
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JDBC_Ex3();
			
		

	}

}
//statement.excuteupdate
//statement.update

