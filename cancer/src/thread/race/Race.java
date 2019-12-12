package thread.race;

import javax.swing.*;
import java.awt.*;

public class Race extends JFrame {
	public Race() {
		ImageIcon car[] = new ImageIcon[3];
		JLabel carLabel[] = new JLabel[3];
		int y=0;
		for(int i=0;i<car.length;i++) {
			car[i] = new ImageIcon("images/car"+(i+1)+".gif");
			carLabel[i] = new JLabel(car[i]);
			carLabel[i].setSize(50,50);
			carLabel[i].setLocation(100,y);
			y+=40;
			add(carLabel[i]);
		}
		Container c = getContentPane();
		Runnable [] runnable = new Runnable[3];
		Thread th [] = new Thread[3];
		for(int i=0;i<runnable.length;i++) {
			runnable[i] = new CarThread(c,carLabel[i]);
			th[i] = new Thread(runnable[i]);
			th[i].start();
			
		}
		
		
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600,200);
		System.out.println(c.getWidth());
		
	}
	
	public static void main(String [] args) {
		new Race();
	}
}

class CarThread implements Runnable{
	
		JLabel  carLabel;
		Container c;
	public CarThread(Container c,JLabel  carLabel) {
		// TODO Auto-generated constructor stub
		this.carLabel = carLabel;
		this.c = c;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
					int x = (int) (Math.random()*10);
				carLabel.setLocation(carLabel.getX()+x,carLabel.getY());
				//c.repaint();
				//System.out.println(carLabel.getX());
				if((carLabel.getX())>=600) {
					System.out.println("끝");
					break;
					}
					
			
				try {
				Thread.sleep(200);
					}
			catch(InterruptedException e) {
					return;
				}
			}
	}
}