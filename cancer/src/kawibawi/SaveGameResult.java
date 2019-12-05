package kawibawi;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class SaveGameResult extends JDialog {
	String path;
	public SaveGameResult(JFrame owner, String usrName, int usrVic, int comVic) {
		super(owner);
		setModal(true);
		setLocationRelativeTo(owner);
		Calendar saveDay = Calendar.getInstance();
		setTitle("저장하기");
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel nameField = new DialogLabel("◎사용자:"+usrName);
		JLabel scoreField = new DialogLabel("◎점수 : "+usrVic+"승 "+comVic+"패");
		JLabel dateField  = new DialogLabel(""+saveDay.get(Calendar.YEAR)+
				"."+(saveDay.get(Calendar.MONTH)+1)+"."+saveDay.get(Calendar.DATE));
		JButton fileSaveBtn = new StytledBtn ("찾아보기");
		fileSaveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					String filePath = chooser.getSelectedFile().getPath();
					path = filePath;
				}
			}
		});
		JButton save = new StytledBtn("저장");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileWriter fout = null;
				try {
					fout = new FileWriter(path);
					fout.write(usrName+","+usrVic+"승 "+comVic+"패, "+dateField.getText());
					fout.close();
					SaveGameResult.this.dispose();
				} catch (IOException ee) {
					JOptionPane.showMessageDialog(SaveGameResult.this, "입출력 오류", "경고", JOptionPane.ERROR_MESSAGE);
				} catch(NullPointerException ee) {
					JOptionPane.showMessageDialog(SaveGameResult.this, "저장 경로를 지정해 주세요", "경고", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		JButton cancel = new StytledBtn("취소");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveGameResult.this.dispose();
			}
		});
		
		add(nameField);
		add(scoreField);
		add(new DialogLabel("◎날짜 : "));
		add(dateField);
		add(new DialogLabel("저장 파일"));
		add(fileSaveBtn);
		//add(save);
		//add(cancel);
		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		bottomPane.add(save);
		bottomPane.add(cancel);

		
		add(bottomPane);
		
		setSize(193,214);
		setVisible(false);
	}
}