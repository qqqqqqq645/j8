package layout.prac;

import javax.swing.*;
import javax.swing.text.Position;

import java.awt.*;

public class NoLayoutManager extends JFrame {
	Point here;
	public NoLayoutManager() {
			setSize(500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setLayout(null);
			//setResizable(false);
			JLabel asdf = new JLabel("This is JLabel",JLabel.CENTER);
			asdf.setSize(500, 10);
			asdf.setLocation(0,0);
			here = asdf.get
			add(asdf);
			JPanel japan = new JPanel();
			japan.setSize(getWidth(),(int)getHeight()/10);
			japan.setLocation(0,10);
			japan.setBackground(Color.CYAN);
			japan.add(new JButton("버튼1"));	japan.add(new JButton("버튼2"));	japan.add(new JButton("버튼3"));
			add(japan);
			

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NoLayoutManager();
	}

}
