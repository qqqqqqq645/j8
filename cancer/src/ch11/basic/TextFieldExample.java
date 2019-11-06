package ch11.basic;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
public class TextFieldExample extends JFrame {

	JTextField field[];
	public TextFieldExample() {
		ThatListener lisner = new ThatListener();
		JPanel pan = new JPanel();
		field = new JTextField[2];
		field[0] = new JTextField(15);
		field[0].addKeyListener((KeyListener) lisner);
		//field[0].addActionListener((ActionListener) lisner);
		field[1] = new JTextField(15);
		field[1].setEditable(false);
		JButton submit = new JButton("OK");
		submit.addActionListener((ActionListener) lisner);
		pan.add(new JLabel("숫자 입력: "));
		pan.add(field[0]);
		pan.add(new JLabel("제곱한 값: "));
		pan.add(field[1]);
		pan.add(submit);
		pan.addKeyListener((KeyListener) lisner);
		Container c = getContentPane();
		c.add(pan);
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field[0].setFocusable(true);
		field[0].requestFocus();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextFieldExample();
	}

	public class ThatListener extends KeyAdapter implements ActionListener{
		
		Container pan;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//JButton submit = (JButton) e.getSource();
			if(!field[0].getText().equals(null)) {
				int result = Integer.parseInt(field[0].getText());
				result = result * result;
				field[1].setText(""+result);
			}
		}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(!field[0].getText().equals(null)) {
					int result = Integer.parseInt(field[0].getText());
					result = result * result;
					field[1].setText(""+result);
				}	
			}
		}
	}
}


