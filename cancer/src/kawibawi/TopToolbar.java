package kawibawi;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class TopToolbar extends JToolBar {

		
	public TopToolbar() {
		super();
		
		add(new JButton("유저추가"));
		add(new JButton("게임하기"));
		add(new JButton("기록저장"));
		add(new JButton("끝내기"));
		
		setVisible(true);
		
	}	 
}
