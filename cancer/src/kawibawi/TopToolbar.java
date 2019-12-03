package kawibawi;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;

public class TopToolbar extends JToolBar {
	public TopToolbar() {
		add(new JButton("유저추가"));
		add(new JButton("게임하기"));
		add(new JButton("기록저장"));
		add(new JButton("끝내기"));
		//addActionListener()
		Component tools [] = getComponents();
		int i=0;
		while(i<tools.length) {
			JButton temp = (JButton)tools[i];
			temp.addActionListener(new ToolBarListener());
		}
		
	}
}
