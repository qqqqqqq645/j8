package layout.prac;

import javax.swing.*;
import java.awt.*;

public class TwoLayouts extends JFrame {
	public TwoLayouts() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel a = new JPanel();
		a.add(new JButton("버튼1"));
		a.add(new JButton("Asdf"));
		a.setBackground(Color.cyan);
		a.setSize(150,150);
		JPanel b = new JPanel();
		b.add(new JButton("버튼2"));
		b.setBackground(Color.GREEN);
		add(a);
		add(b);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300,300);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TwoLayouts();
		}

}
