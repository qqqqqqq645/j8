package ch10.basic;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//익명클래스는 내부클래스 위치와 동힐
public class AnnonymousClassListner  extends JFrame {
	JButton btn1;
	AnnonymousClassListner(){
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
