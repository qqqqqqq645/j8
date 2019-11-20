package cmponent.prac;
import javax.swing.*;
import java.awt.*;


public class Asdf extends JFrame {

	public Asdf() {
		JPanel tooldori = new JPanel(); 
		tooldori.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar("Kitae Menu"); // 툴바의 이름 "Kitae Menu"
		toolBar.setBackground(Color.LIGHT_GRAY);
		// 툴바에 메뉴로 사용할 컴포넌트를 삽입한다.
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JLabel("search"));
		JTextField asdf = (JTextField) toolBar.add(new JTextField("text field"));
		asdf.setText("asdfasdf");
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		toolBar.add(new JTextField("text field"));
		tooldori.add(toolBar);
		add(tooldori,BorderLayout.NORTH);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String [] args) {
		new Asdf();
	}
}
