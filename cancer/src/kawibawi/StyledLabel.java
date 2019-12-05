package kawibawi;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

class StyledLabel extends JLabel {
	/**
	 * 직렬화가뭐죠
	 */
	private static final long serialVersionUID = 1L;
	public StyledLabel() {}
	public StyledLabel(String text) {
		super(text);
		setFont(new Font("고딕체",Font.BOLD,20));
	}
}

class DialogLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DialogLabel() {}
	public DialogLabel(String text) {
		super(text);
		setFont(new Font("고딕체",Font.BOLD,15));
	}
}

class StytledBtn extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  StytledBtn() {}
	public StytledBtn(String text) {
		super(text);
		setFont(new Font("고딕체",Font.BOLD,15));
	}
	
}