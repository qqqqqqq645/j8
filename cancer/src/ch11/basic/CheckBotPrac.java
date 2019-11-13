package ch11.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBotPrac extends JFrame {

	public CheckBotPrac () {
		setLayout(new FlowLayout());
		JCheckBox btn1 = new JCheckBox("버튼 비활성화");
		add(btn1);
		JCheckBox btn2 = new JCheckBox("버튼 숨기기");
		add(btn2);
		JButton tester = new JButton("Test Button");
		add(tester);
		btn1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					tester.setEnabled(false);
				else
					tester.setEnabled(true);
				
			}
		});
			btn2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					tester.setVisible(false);
				else
					tester.setVisible(true);
				
			}
		});
			tester.setVisible(true);
			setSize(300,200);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBotPrac();
	}

}
