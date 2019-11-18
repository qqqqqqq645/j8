package dlrjtehahtgksiqudtlsdk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;
public class MoneyCounter4 extends JFrame implements ActionListener {
	String [] cash = {"오만원","일만원","일천원","500원","100원","50원","10원","1원"};
	int [] cashvals = {50000,10000,1000,500,100,50,10,1};
	JTextField inputMoney ;
	ArrayList <ListData> divList;
	Dimension frameSize;
	static final Color BGCOLOR = Color.getHSBColor(0.01f, 0.45f, 0.89f);
	
	public MoneyCounter4() {
		setLayout(null);
		divList = new ArrayList<>();
		frameSize = new Dimension(400,400);
		
		
		Container c = getContentPane();
		c.setBackground(BGCOLOR);
		Component anonymouscomp;
		anonymouscomp = add( new JLabel("금액",JLabel.RIGHT));
		anonymouscomp.setSize(80,25);
	
		inputMoney = new JTextField("",20);
		inputMoney.setSize(130,25);
		add(inputMoney);
		JButton calc = new JButton("   계산   ");
		calc.setSize(80,25);
		calc.addActionListener(this);
		add(calc);

			
			for(int i=0;i<cash.length;i++) {
				anonymouscomp = add(new JLabel(cash[i],JLabel.RIGHT));
				anonymouscomp.setSize(100,25);
				JTextField resultText = new JTextField("",10);
				resultText.setSize(100,25);
				JCheckBox chk = new JCheckBox();
				chk.setSize(25,25);
				chk.setBackground(BGCOLOR);
				resultText.setHorizontalAlignment(JTextField.CENTER);
				add(resultText);
				add(chk);
				divList.add(new ListData(resultText,cashvals[i],chk));
			
			}
		divList.get(divList.size()-1).getChk().setVisible(false); //마지막 1원의 체크박스를 안보이게하고 체크됨으로 설정
		divList.get(divList.size()-1).getChk().setSelected(true);
		

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
			int diff = (int)(frame.getWidth()-frameSize.getWidth())+0;
			Point p = new Point(diff,20);
			Component [] components = frame.getContentPane().getComponents();
			for(int i =0;i<components.length;i++) {
	
				if(i%3==0){
					p.y+=27;
					p.x=diff;
					if(i==3) {
						p.y+=20;
					}	
				}
				components[i].setLocation(p);
				p.x += ((int)components[i].getWidth()+30);
			}
		}
	}
	

	public static void main(String[] args) {
		new MoneyCounter4();
		}	
	}


