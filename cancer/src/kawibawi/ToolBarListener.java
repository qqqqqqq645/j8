package kawibawi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ToolBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton)e.getSource();
		String target = btn.getText();
		if(target.equals("유저추가")) {
			//대충 다이얼로그 띄우라는 내용
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
