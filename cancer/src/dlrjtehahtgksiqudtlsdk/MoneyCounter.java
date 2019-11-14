package dlrjtehahtgksiqudtlsdk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;
public class MoneyCounter extends JFrame implements ActionListener {
	String [] cash = {"오만원","일만원","일천원","500원","100원","50원","10원","1원"};
	int [] cashvals = {50000,10000,1000,500,100,50,10,1};
	JTextField inputMoney ;
	ArrayList <ListData> divList;
	static final Color bgColor = Color.getHSBColor(0.01f, 0.45f, 0.89f);
	public MoneyCounter() {
		JPanel [] panels = new JPanel[2];
		panels[0] = new JPanel();
		panels[1] = new JPanel();
		divList = new ArrayList<>();
		panels[1].setLayout(new GridLayout(cash.length,3,10,0));
		
		panels[1].setBackground(bgColor);
		panels[0].setBackground(bgColor);
	
	
		for(int i=0;i<cash.length;i++) {
			panels[1].add(new JLabel(cash[i],JLabel.RIGHT));
			JTextField resultText = new JTextField("",10);
			JCheckBox chk = new JCheckBox();
			chk.setBackground(bgColor);
			resultText.setHorizontalAlignment(JTextField.CENTER);
			panels[1].add(resultText);
			panels[1].add(chk);
			divList.add(new ListData(resultText,cashvals[i],chk));
			
		}
		divList.get(divList.size()-1).getChk().setVisible(false); //마지막 1원의 체크박스를 안보이게하고 체크됨으로 설정
		divList.get(divList.size()-1).getChk().setSelected(true);
	
		
		setLayout(new BorderLayout(30,0));
		
		//panels[0].setLayout(new GridLayout(1,3));
		panels[0].setLayout(new FlowLayout(FlowLayout.CENTER ,15,15));
		//panels[0].setLayout(new GridLayout(2,3, 5, 0));
		//panels[0].add(new JLabel());	panels[0].add(new JLabel());	panels[0].add(new JLabel());
		JLabel money = new JLabel("금액",JLabel.LEFT);
		//JLabel money = new JLabel("금액",SwingConstants.CENTER);
		panels[0].add(money);
		inputMoney = new JTextField("",10);
		panels[0].add(inputMoney);
		JButton calc = new JButton("계산");
		calc.addActionListener(this);
			
		panels[0].add(calc);
	
		//panels[1].setBackground(Color.BLACK);
		//add(new JLabel(""),BorderLayout.NORTH);
		add(panels[0],BorderLayout.NORTH);
		add(panels[1],BorderLayout.CENTER);
		add(new JLabel(),BorderLayout.WEST);
		add(new JLabel(),BorderLayout.EAST);
		Container c = getContentPane();
		c.setBackground(bgColor);
		setSize(300,300);
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoneyCounter();

	}

}
