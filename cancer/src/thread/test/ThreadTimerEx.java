package thread.test;

import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
	private JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel) { 
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n=0; 
		while(true) {
			n++; 
			timerLabel.setText(Integer.toString(n)); 
			try {
				super.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}

class TimerThread2 extends Thread {
	private JLabel timerLabel;
	
	public TimerThread2(JLabel timerLabel) { 
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n=0; 
		while(true) {
			timerLabel.setText(Integer.toString(n)); 
			n++; 
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				return;
			}
			
			
		}
	}
}

public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		setTitle("Threadtest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel("asdf");
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		
		JLabel timerLabel2 = new JLabel("asdf");
		timerLabel2.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel2);
		c.add(new JLabel("asdfasdfasdf"));
		TimerThread th = new TimerThread(timerLabel);
		TimerThread2 thh = new TimerThread2(timerLabel2);
		//th.start();
		thh.start();
		setSize(300,170);
		setVisible(true);

		th.start();
	}
	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}


