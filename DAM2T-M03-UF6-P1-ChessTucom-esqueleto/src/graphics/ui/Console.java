package graphics.ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Console extends JPanel {
		
	private JLabel tittle;
	private JTextArea content;
	
	public Console() {
		setBackground(Color.BLACK);
		setBounds(0, 0, 300, 586);
		setLayout(null);
		
		tittle = new JLabel("CONSOLE");
		tittle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tittle.setForeground(Color.WHITE);
		tittle.setBounds(27, 27, 239, 36);
		add(tittle);
		
		content = new JTextArea();
		content.setFont(new Font("Calibri", Font.BOLD, 16));
		content.setForeground(Color.WHITE);
		content.setBackground(Color.BLACK);
		content.setBounds(27, 73, 239, 472);
		add(content);
	}

	public JLabel getTittle() {
		return tittle;
	}

	public JTextArea getContent() {
		return content;
	}
}
