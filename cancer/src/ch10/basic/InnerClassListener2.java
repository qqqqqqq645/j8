package ch10.basic;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClassListener2 extends JFrame {
	//�̳�Ŭ����
	JButton btn1;
	class MyActionListener implements ActionListener {
		 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(btn1.getText().equals("Action")) 
					btn1.setText("액션"); 
				else
					btn1.setText("Action");
				
				InnerClassListener2.this.setTitle("asdf");
				setTitle("fdsa");
			}

		}
	
	InnerClassListener2(){
		setTitle("������-����");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		btn1 = new JButton("Action");
		btn1.addActionListener(new MyActionListener());
		c.add(btn1);		
		setSize(300,200);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new InnerClassListener2();
	}

}
