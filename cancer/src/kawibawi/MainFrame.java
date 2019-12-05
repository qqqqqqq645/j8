package kawibawi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	private String usrName;
	private String profilePath;
	MainPanel panel;
	//ImageIcon [] kbbImg;
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
		add(panel,BorderLayout.CENTER);
		
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
		
	}
	//툴바 이벤트 리스너
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
				if(usrName != null)
					panel.setNameField(usrName);
			}
			
			else if(target.equals("끝내기")) {
				bye();
			}
			else if((profilePath != null) || (usrName != null)){
				int computerChoose;
				if(target.equals("게임하기")) {
					//대충 게임한다는내용
					GamePanel gamePanel = new GamePanel();
					gamePanel.gamePlay();
					int usrChoose =gamePanel.getUsrChoose();
					if(usrChoose !=0){
						computerChoose = kbbProcess(usrChoose);
						//ImageIcon [] kbbImg = gamePanel.getKbbImage();
						printKbbImg(gamePanel.getKbbImage(),usrChoose,computerChoose);
					}
					
				}
				
				if(target.equals("기록저장")) {
					//기록저장한다는내용
					JDialog saveGameData = new SaveGameResult(MainFrame.this,usrName,panel.getUsrVic(),panel.getComVic());
					saveGameData.setVisible(true);
					
				}
			}
			else {
				//유저를추가하라는경고
				noAccount();
			}

		}

	}
	
	public void noAccount() {//유저가없으니까 추가하라는내용
		JOptionPane.showMessageDialog(this, "유저를 먼저 추가해 주세요", "경고", JOptionPane.ERROR_MESSAGE);
				
	}
	public void bye() {
		int result = JOptionPane.showConfirmDialog(MainFrame.this,
				"정말로 끝내시겠씁니까??",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
		
		if(result == JOptionPane.YES_OPTION) {
			this.dispose(); //JFrame 종료료
		}
	}
	
	public int kbbProcess(int usrChoose) {
		int computerSelect = ((int) (Math.random()*3))+1;//컴퓨터 1~3 랜덤
		 System.out.println(usrChoose);
		 System.out.println(computerSelect);
		if(usrChoose != 0) {
			if(usrChoose == computerSelect) {//비김
				System.out.println("비김");
				
			}
			else if(((usrChoose%3)+1)==computerSelect) {//패베
				System.out.println("패베!!");
			
				panel.addComVic();
				
			}
			else {//2김
				panel.addUsrVic();
				System.out.println("승리");
			}
			return computerSelect;
		}
		else
			return -1;
	}
	
	public void printKbbImg(ImageIcon [] kbbImg,int usr, int com) {
		panel.setKbbPics(kbbImg[usr-1], kbbImg[com-1]);
	}
	
	
	
	
}
