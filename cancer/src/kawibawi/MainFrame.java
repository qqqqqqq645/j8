package kawibawi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private String usrName;
	private String profilePath;
	MainPanel panel;
	public MainFrame() {
		TopToolbar toolbar = new TopToolbar();
		add(toolbar,BorderLayout.NORTH);
		Component tools [] = toolbar.getComponents();
		int i=0;
		while(i<tools.length) {
			JButton temp = (JButton)tools[i];
			temp.addActionListener(new ToolBarListener());
			i++;
		}
		
		
		//메인화면 추가
		panel =  new MainPanel();
		add(panel);
		
		
		setSize(500,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
		
	}
	
	class ToolBarListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton)e.getSource();
			String target = btn.getText();
			if(target.equals("유저추가")) {
				//대충 다이얼로그 띄우라는 내용
				UsrAdd usrAdd = new UsrAdd(MainFrame.this);//유저추가 객체 생성
				profilePath = usrAdd.getProfilePath();
				usrName = usrAdd.getUsrName();
				panel.setProfile(profilePath);
			}
			else if(target.equals("게임하기")) {
				//유저추가되있으면 게임하고 아니면 경고
			}
			else if(target.equals("기록저장")) {
				//유저추가 되있는지 확인하고 기록저장
			}
			else {
				//게임을 끝낼건지 말건지 결정하라는 다이올로그
				
			}

		}

	}

}
