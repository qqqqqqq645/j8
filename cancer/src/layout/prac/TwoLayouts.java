package layout.prac;

import javax.swing.*;
import java.awt.*;

public class TwoLayouts extends JFrame {
	public TwoLayouts() {
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(null);
		JPanel a = new JPanel();
		a.add(new JButton("버튼1"));
		a.add(new JButton("Asdf"));
		a.setBackground(Color.cyan);
		a.setSize(75,150);
		a.setLocation(0,0);
		JPanel b = new JPanel();
		b.add(new JButton("버튼2"));
		b.setBackground(Color.GREEN);
		b.setBounds(75,0,75,150);
		add(a);
		add(b);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setSize(150,150);
		setVisible(true);
		//setSize(150,150);
		setSize(this.getSize().width+c.getSize().width,this.getSize().height+c.getSize().height);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TwoLayouts();
		}

}
