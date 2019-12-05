package kawibawi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GamePanel extends JPanel {
	private int usrChoose;


	private ImageIcon [] kbbImage = { 
			new ImageIcon("images/gawi.jpg"),
			new ImageIcon("images/bawi.jpg"),
			new ImageIcon("images/bo.jpg")
	};
	JRadioButton kbbBtn [];
	public GamePanel() {
		//창화면그리기
		add(new JLabel("선택해주세요"));
		kbbBtn = new JRadioButton[3];
		ButtonGroup kbbGroup = new ButtonGroup();
		int i=0;
		KbbItemListner kbbListener = new KbbItemListner();
		while(i<kbbBtn.length) {
			kbbBtn[i] = new JRadioButton(" ");
		
			kbbGroup.add(kbbBtn[i]);
			kbbBtn[i].addItemListener(kbbListener);
			add(kbbBtn[i]);
			add(new JLabel(kbbImage[i]));
			i++;
		}
	}
	
	class KbbItemListner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			int i=0;
			while(i<kbbBtn.length) {
					if(kbbBtn[i].isSelected())
						break;
					i++;
			}
			usrChoose = i+1;
		}
		
	}
	
	public void gamePlay() {
		int result = JOptionPane.showConfirmDialog(null,//부모
                this,//JPanel
                "게임하기",//타이틀
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) { //확인버튼누르면
			
				if(usrChoose == 0) {
					JOptionPane.showMessageDialog(this, "가위 바위 보 중 하나를 선택하새요", "경고", JOptionPane.ERROR_MESSAGE);
				}
							
		}
	}
	
	public int getUsrChoose() {
		return usrChoose;
	}

	public ImageIcon[] getKbbImage() {
		return kbbImage;
	}


}
