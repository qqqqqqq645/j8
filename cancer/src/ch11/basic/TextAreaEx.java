package ch11.basic;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;

public class TextAreaEx extends JFrame {
	private JTextField tf = new JTextField(20);
	JTextArea ta = new JTextArea(7, 20); // 한줄에 20개 입력 가능, 7줄 입력창
	JButton btn1 = new JButton("저장1");
	JButton btn2 = new JButton("저장2");
	public TextAreaEx() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf);
		c.add(btn1);
		c.add(new JScrollPane(ta));
		c.add(btn2);
		// 텍스트필드에 <Enter> 키 입력 때 발생하는 Action 이벤트의 리스너 등록
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // 텍스트필드의 문자열을 텍스트영역 창에 붙임 
				t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
			}
		});

		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				FileWriter fout = null;
				int c;
				try {
					fout = new FileWriter("c:\\Temp\\test.txt", true); // 파일과 연결된 출력 문자 스트림 생성
					
						String line = tf.getText()+"\r\n";
						if(line.length() == 0) // 한 줄에 <Enter>키만 입력한 경우
						{ }
						
						fout.write(line); 
						
					    fout.close();
				} catch (IOException e1) {
					System.out.println("입출력 오류");
				}
				
			}
		});
		
		setSize(300,300);
		setVisible(true);
	}
		
	public static void main(String [] args) {
		new TextAreaEx();
	}
}