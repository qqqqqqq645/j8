package ch10.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = (JButton)arg0.getSource();
		if(b.getText().equals("Action")) 
			b.setText("¾×¼Ç"); 
		else
			b.setText("Action");

	}

}
