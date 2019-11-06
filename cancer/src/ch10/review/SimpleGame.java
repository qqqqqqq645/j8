package ch10.review;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class SimpleGame extends JFrame {

		JButton buttons [];
	
	public SimpleGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan = new JPanel();
		buttons = new JButton [3];
		buttons[0] = new JButton(""+0);
		buttons[1] = new JButton(""+0);
		buttons[2] = new JButton(""+0);
		for(JButton temp : buttons) {
			pan.add(temp);
		}
	
		pan.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					for(JButton temp:buttons) {
						//temp.setText(""+(int)Math.floor(Math.random()*10+1));
						temp.setText(""+(int)(Math.random()*11));
					}
					
				}
				
			}
		});
		Container c = getContentPane();
		c.add(pan);
		
		setSize(300,200);
		setVisible(true);
		pan.setFocusable(true);
		pan.requestFocus();
		
	}
	public static void main(String[] args) {
		
		new SimpleGame();
	}

}
