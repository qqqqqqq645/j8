package ch09.prac;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("300*300 jframe");
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new MyFrame();
	}
}
