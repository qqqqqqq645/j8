package ch10.basic;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//�͸�Ŭ������ ����Ŭ���� ��ġ�� ����
public class AnnonymousClassListner  extends JFrame {
	JButton btn1;
	AnnonymousClassListner(){
		setTitle("������-����");//��������
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
