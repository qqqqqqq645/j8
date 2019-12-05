package kawibawi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class MainPanel extends JPanel {
	JLabel profileView;
	//ProfilePanel profileView;
	JLabel nameField;
	JLabel score;
	JLabel usrSelected;
	JLabel comSelected;
	int usrVic;	//유저가 승리한수
	int comVic; //컴터가 승리한수
	JLabel usrPic;
	JLabel comPic;
	public MainPanel() {
		profileView = new JLabel();

		add(profileView);
		
		nameField = new StyledLabel("___님\t");
		add(nameField);
		score = new StyledLabel(usrVic+"    :    "+comVic);
		add(score);
		add( new StyledLabel("\t컴퓨터"));
		usrSelected = new JLabel();
		add(usrSelected);
		comSelected = new StyledLabel();
		add(comSelected);
		usrPic = new StyledLabel();
		add(usrPic);
		comPic = new StyledLabel();
		add(comPic);
		setVisible(true);
		setSize(300,300);
		
	}
	public void kbbProcess() {
		
	}
	//getters and setters
	public void setProfile(String path) { //프로필설정
		ImageIcon icon = new ImageIcon(path);
		Image beforeSizing = icon.getImage();
		ImageIcon sizedIcon = new ImageIcon(); 
		sizedIcon.setImage(beforeSizing.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
		profileView.setIcon(sizedIcon);
	}
	
	
	public void setNameField(String name) {
		nameField.setText(name+"님");
	}
	public int getUsrVic() {
		return usrVic;
	}
	public void setUsrVic(int usrVic) {
		this.usrVic = usrVic;
	}
	public int getComVic() {
		return comVic;
	}
	public void setComVic(int comVic) {
		this.comVic = comVic;
	}
	public void addComVic() {
		this.comVic++;
		score.setText(usrVic+":"+comVic);
	}
	public void addUsrVic() {
		this.usrVic++;
		score.setText(usrVic+":"+comVic);
	}
	
	public void setKbbPics(ImageIcon usrpic, ImageIcon compic) {
		usrPic.setIcon(usrpic);
		comPic.setIcon(compic);
	}
	
	
}

	