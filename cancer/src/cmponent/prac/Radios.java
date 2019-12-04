package cmponent.prac;

import javax.swing.*;
import java.awt.*;

public class Radios extends JFrame {
	public Radios(){
		setLayout(new FlowLayout());
		JRadioButton a = new JRadioButton("11");
		JRadioButton b = new JRadioButton("22");
		JRadioButton c = new JRadioButton("33");
		ButtonGroup g = new ButtonGroup();
		g.add(a);		g.add(b); 	g.add(c);
		setSize(300,200);
		setVisible(true);
		add(a); add(b); add(c);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Radios();
	}

}
