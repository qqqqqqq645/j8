package ch10.basic;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ChangeBackground extends JFrame {
	JButton btn1;
	JButton btn2;
	Container c;
	class MyActionListener implements ActionListener {
		 Color bgcol;
		 MyActionListener(Color bgcol){
			 this.bgcol = bgcol;
		 }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			c.setBackground(bgcol);
			
		}

	}
	ChangeBackground(){
		setTitle("배경 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		/*어차피 jframe에 붙이는거는 contentpane에 붙이는거라서 그냥 add()가능*/
		c.setLayout(new FlowLayout());
		btn1 = new JButton("노란색");
		btn1.addActionListener(new MyActionListener(Color.YELLOW));
		btn2 = new JButton("핑크색");
		btn2.addActionListener(new MyActionListener(Color.PINK));
		c.add(btn1);	
		c.add(btn2);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChangeBackground();
	}
	
}
