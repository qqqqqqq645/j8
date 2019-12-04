package kawibawi;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsrAdd extends JPanel {

	private String profilePath;
	private String usrName;
	private Container owner;
	
	
	public UsrAdd(Container owner) {
		super();
		this.owner = owner;
		setLayout(new FlowLayout());
		add(new JLabel("사용자 이름 :"));
		JTextField usrNameField = new JTextField(8);
		add(usrNameField);
		add(new JLabel("프로필 사진 :"));
		JButton profilePicker = new JButton("찾아보기");
		profilePicker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usrName = usrNameField.getText();
				JFileChooser chooser = new JFileChooser();			
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG,PNG,GIF파일", "jpg","png","gif");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(owner);
				if(result == JFileChooser.APPROVE_OPTION) { //열기버튼눌렀으먼
					profilePath = chooser.getSelectedFile().getPath();
					//String fileName = chooser.getSelectedFile().getName();
					//System.out.println(pathName);
					//System.out.println(fileName);
					}
			}
			
			
		});
		add(profilePicker);
	
		setPreferredSize(new Dimension(100,100));//jpanel 크기설정
		
		int result = JOptionPane.showConfirmDialog(owner,
                this,
                "유저추가 : ",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.CLOSED_OPTION) {
			//아무것도안함
		}
		else if(result == JOptionPane.OK_OPTION) {
			System.out.println("예");
			if((usrName == null) || (profilePath == null)) {
				JOptionPane.showMessageDialog(owner, "오류 : 이름과 프로필 사진을 올려주세요 !!");
								
			} else {
				System.out.println(profilePath+"\n"+usrName);
			
			}	
		}
		
	}

	//데이비드게터
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
