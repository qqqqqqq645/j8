package ch11.review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rsp extends JFrame {
	JLabel result;
	public Rsp() {
		JLabel desc = new JLabel("아래의 버튼 중에서 하나를 클릭하시오!");
		add(desc,BorderLayout.NORTH);
		JPanel sel = new JPanel();
		sel.setLayout(new GridLayout(1,3));
		JButton si = new JButton("0.가위");
		si.addActionListener(new rspListener());
		JButton ro = new JButton("1.바위");
		ro.addActionListener(new rspListener());
		JButton pa = new JButton("2.보");
		pa.addActionListener(new rspListener());
		sel.add(si); sel.add(ro); sel.add(pa);
		add(sel,BorderLayout.CENTER);
		result = new JLabel("Good Luck!");
		add(result,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300,200);
		
		
	}
	
	public class rspListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton)e.getSource();
			//int a =(clicked.getText().charAt(0))-48;
			int a =Integer.parseInt(String.valueOf(clicked.getText().charAt(0)));
			int temp = (int) (Math.random()*3);
			result.setText("인간: "+a+"컴퓨터: "+temp);
			if(a==temp) {
				result.setText(result.getText()+" -> 비겻습니다.");
			}
			else if(a==0||temp==2) {
				result.setText(result.getText()+" ->  인간 승리!!!");
			}
			else if(a==1 || temp == 0) {
				result.setText(result.getText()+" ->  인간 승리!!!");
			}
			else if(a==2||temp == 1) {
				result.setText(result.getText()+" ->  인간 승리!!!");
			}
			else {
				result.setText(result.getText()+" ->  컴퓨터 승리!!!");
			}
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rsp();
		
	
	}

}

