package kawibawi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	JLabel profileView;
	JLabel nameField;
	JLabel score;
	public MainPanel() {
		profileView = new JLabel();
		add(profileView);
		nameField = new JLabel("___님");
		add(nameField);
		score = new JLabel(0+":"+0);
		add(score);
		add( new JLabel("컴피터"));
		setVisible(true);
		
	}
	//getters and setters
	public void setProfile(String path) {
		if(path !=null) 
		profileView.setIcon(new ImageIcon(path));
	}
}
