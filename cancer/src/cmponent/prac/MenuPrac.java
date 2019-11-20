package cmponent.prac;

import javax.swing.*;
import java.awt.*;
public class MenuPrac extends JFrame {
	public MenuPrac() {
		setTitle("asdf");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menubar = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");
		
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("ReShow"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("Exit"));
		
		menubar.add(screenMenu);
		menubar.add(new JMenu("Edit"));
		menubar.add(new JMenu("Source"));
		menubar.add(new JMenu("Project"));
		menubar.add(new JMenu("Run"));
		
		add(menubar);
		setVisible(true);
		setSize(300,300);
		menubar.setSize(getWidth(),30);
		
	}
	public static void main(String [] args) {
		new MenuPrac();
	}
	
}
