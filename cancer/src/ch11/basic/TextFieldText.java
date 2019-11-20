package ch11.basic;

import javax.swing.*;
import java.awt.*;
public class TextFieldText extends JFrame {

	public TextFieldText() {
		setLayout(new FlowLayout());
		add(new JTextField("field"));
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextFieldText();
	}

}
