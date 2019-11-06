package ch10.basic;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IndepClassListener extends JFrame {
	IndepClassListener(){
		setTitle("리스너-독립");//생략가능
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn1 = new JButton("Action");
		btn1.addActionListener(new MyActionListener());
		c.add(btn1);		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new IndepClassListener();
	}

}
