package dlrjtehahtgksiqudtlsdk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;
public class MoneyCounter3 extends JFrame implements ActionListener {
	String [] cash = {"오만원","일만원","일천원","500원","100원","50원","10원","1원"};
	int [] cashvals = {50000,10000,1000,500,100,50,10,1};
	JTextField inputMoney ;
	ArrayList <ListData> divList;
	Dimension frameSize;
	JPanel [] panels;
	static final Color BGCOLOR = Color.getHSBColor(0.01f, 0.45f, 0.89f);
	
	public MoneyCounter3() {
		setLayout(null);
		panels = new JPanel[5];
		for(int i=0;i<panels.length;i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(BGCOLOR);
		}
		//panels[2] = new JPanel();
		divList = new ArrayList<>();
		frameSize = new Dimension(400,600);
				
		
		//panels[1].setLayout(new GridLayout(cash.length,3,10,0));

		
		panels[0].setLayout(new FlowLayout(FlowLayout.CENTER ,20,20));
		//panels[0].setLayout(new GridLayout(1,3));
		panels[0].add( new JLabel("      금액      ",JLabel.CENTER));
		//JLabel money = new JLabel("금액",SwingConstants.CENTER);
		inputMoney = new JTextField("",13);
		panels[0].add(inputMoney);
		JButton calc = new JButton("   계산   ");
		calc.addActionListener(this);
		panels[0].add(calc);
		add(panels[0]);
		
		panels[2].setLayout(new GridLayout(cash.length,1,0,4));
		panels[4].setLayout(new GridLayout(cash.length,1,0,3));
		panels[3].setLayout(new GridLayout(cash.length,1));
	
		//panels[1].setLayout(new GridLayout(cash.length,1,5,0));
		for(int i=0;i<cash.length;i++) {
			panels[2].add(new JLabel(cash[i],JLabel.RIGHT));
			JTextField resultText = new JTextField("",10);
			JCheckBox chk = new JCheckBox();
			chk.setBackground(BGCOLOR);
			resultText.setHorizontalAlignment(JTextField.CENTER);
			panels[3].add(resultText);
			panels[4].add(chk);
			divList.add(new ListData(resultText,cashvals[i],chk));
			
		}
		divList.get(divList.size()-1).getChk().setVisible(false); //마지막 1원의 체크박스를 안보이게하고 체크됨으로 설정
		divList.get(divList.size()-1).getChk().setSelected(true);
		
		panels[1].setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		for(int i  = 2;i<panels.length;i++) {
			panels[1].add(panels[i]);
		}
	
		add(panels[1]);
		
		
		
		
		
	
		//add(panels[0],BorderLayout.NORTH);
	//	add(panels[1],BorderLayout.CENTER);
		//add(new JLabel(),BorderLayout.WEST);
	//	add(new JLabel(),BorderLayout.EAST);
		this.addComponentListener(new frameListener());
		this.setSize(frameSize.getSize());
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		int divided = Integer.parseInt(inputMoney.getText());
		//ArrayList를 확인할 Iterator객체생성
		Iterator<ListData> iterator = divList.iterator();
		while(iterator.hasNext()) {
			ListData temp = iterator.next();
			if(temp.getChk().isSelected()) {
				int result = (int)divided/temp.getVal();
				divided %= temp.getVal();
				temp.getResultText().setText(""+result);
			}
			else
				temp.getResultText().setText(""+0);
		}
	}
	
	class frameListener extends ComponentAdapter{

		public void componentResized(ComponentEvent e) {
			JFrame frame = (JFrame) e.getSource();
			Dimension windowSize = frame.getSize();
			panels[0].setSize((int) windowSize.getWidth(),50);
			panels[0].setLocation(0,0);
			panels[1].setSize((int) windowSize.getWidth(),(int) windowSize.getHeight()-panels[0].getHeight());
			panels[1].setLocation(-10,panels[0].getHeight());
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoneyCounter3();

	}

}


