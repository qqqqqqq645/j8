package dlrjtehahtgksiqudtlsdk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
public class MoneyCounter extends JFrame implements ActionListener, ItemListener {
	String [] cash = {"오만원","일만원","일천원","500원","100원","10원","1원"};
	int [] cashvals = {50000,10000,1000,500,100,10,1};
	HashMap<Integer, Data> results;
	ArrayList <Object> keys ;
	JTextField inputMoney ;
	
	
	public MoneyCounter() {
		JPanel [] panels = new JPanel[2];
		panels[1] = new JPanel();
		results = new HashMap<>();
		keys =new ArrayList<>();
		panels[1].setLayout(new GridLayout(cash.length,3));
		//ArrayList<ListData> data = new ArrayList<ListData>();
	
		for(int i=0;i<cash.length;i++) {
			panels[1].add(new JLabel(cash[i]));
			JTextField result = new JTextField("",10);
			JCheckBox key = new JCheckBox();
			key.addItemListener(this);
			panels[1].add(result);
			panels[1].add(key);
			results.put(key.hashCode(), new Data(result,cashvals[i]));
			System.out.println(key.hashCode());
		}
	
		
		setLayout(new BorderLayout(30,0));
		panels[0] = new JPanel();
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
		
				//add(panels[0]);
		Container c = getContentPane();
		c.setBackground(Color.getHSBColor(0.01f, 0.45f, 0.89f));
		setSize(300,500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		int total = Integer.parseInt(inputMoney.getText());
		for(Object o:keys) {
			int div = (int)total/results.get(o).getVal();
			results.get(o).getResult().setText(div+"");
			total = (int)total%results.get(o).getVal();
		}
		keys.clear();
	}
	
	public void itemStateChanged(ItemEvent e) {
		//JCheckBox chkd = (JCheckBox) e.getSource();
		Object temp = e.getSource().hashCode();
		if(e.getStateChange()==ItemEvent.SELECTED) {
			keys.add(temp);
			System.out.println(e.getSource().hashCode());
		}
		else {
			if(keys.contains(temp)) {
				keys.remove(temp);
				System.out.println(e.getSource().hashCode());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoneyCounter();

	}

}
class Data{
	JTextField result;
	public JTextField getResult() {
		return result;
	}
	public int getVal() {
		return val;
	}
	int val;
	public Data(JTextField result,int val) {
		this.result = result;
		this.val = val;
	}
}