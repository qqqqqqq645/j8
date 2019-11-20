package ch14.review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalcDialog extends JFrame {

	int result;
	JLabel resultOut;
	public CalcDialog() {
		setLayout(new FlowLayout());
		JButton btn1 = new JButton("calculate");
		
		add(btn1);
		resultOut = new JLabel("계산 결과 출력");
		resultOut.setBackground(Color.GREEN);
		resultOut.setOpaque(true);
		add(resultOut);
		
		Calculator calculator = new Calculator(this,"다이얼로그 만들기");
		calculator.setVisible(false);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculator.setVisible(true);
				
			}
		});
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private class Calculator extends JDialog{
		private Calculator(JFrame frame, String title) {
			super(frame,title);
			setLayout(new FlowLayout());
			add(new JLabel("두 수를 더합니다"));
			JTextField val1 =(JTextField) add(new JTextField(10));
			JTextField val2 =(JTextField)add(new JTextField(10));
			JButton adder = (JButton)add(new JButton("ADD"));
			this.setSize(180,200);
			adder.addActionListener(new ActionListener() {
			
			
				@Override
				public void actionPerformed(ActionEvent e) {
					result = Integer.parseInt(val1.getText())+Integer.parseInt(val2.getText());
					resultOut.setText(result+"");
					setVisible(false);
					
				}
			});
			
			
		}
		
	}
	public static void main(String[] args) {
		
		new CalcDialog();
	}

}
