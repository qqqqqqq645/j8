package dlrjtehahtgksiqudtlsdk;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

//ArrayList에 들어갈 	체크박스와 라벨, 화폐단위를 연결하는 클래스
public class ListData{
	JTextField resultText;
	int val;
	JCheckBox chk;
	
	
	public JCheckBox getChk() {
		return chk;
	}
	public void setChk(JCheckBox chk) {
		this.chk = chk;
	}
	public void setResultText(JTextField resultText) {
		this.resultText = resultText;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public JTextField getResultText() {
		return resultText;
	}
	public int getVal() {
		return val;
	}

	public ListData(JTextField resultText,int val,JCheckBox chk) {
		this.resultText = resultText;
		this.val = val;
		this.chk = chk;
	}
}