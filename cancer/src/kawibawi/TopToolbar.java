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
		
		add(new StytledBtn("유저추가"));
		add(new StytledBtn("게임하기"));
		add(new StytledBtn("기록저장"));
		add(new StytledBtn("끝내기"));
		
		setVisible(true);
		
	}	 
}
