package kawibawi;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsrAdd extends JPanel {

	private String profilePath;
	private String pathTemp;
	private String usrName;
	private Container owner;


	public UsrAdd(Container owner) {
		super();
		this.owner = owner;
		setLayout(new FlowLayout());
		add(new DialogLabel("사용자 이름 :"));
		JTextField usrNameField = new JTextField(8);
		add(usrNameField);
		add(new DialogLabel("프로필 사진 :"));

		JButton profilePicker = new StytledBtn("찾아보기");
		profilePicker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();			
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG,PNG,GIF파일", "jpg","png","gif");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(owner);
				if(result == JFileChooser.APPROVE_OPTION) { //열기버튼눌렀으먼
					pathTemp = chooser.getSelectedFile().getPath();

				}
			}


		});
		add(profilePicker);

		setPreferredSize(new Dimension(80,70));//jpanel 크기설정

		int result = JOptionPane.showConfirmDialog(owner,
				this,
				"유저추가 : ",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null);
		if(result == JOptionPane.OK_OPTION) {
					
			if((usrNameField.getText() == null) || (pathTemp == null)) {
				JOptionPane.showMessageDialog(owner, "오류 : 이름과 프로필 사진을 올려주세요 !!");
					

			} else {
				System.out.println(profilePath+"\n"+usrName);
				usrName = usrNameField.getText();
				profilePath = pathTemp;
			}	
		}

	}

	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
}
