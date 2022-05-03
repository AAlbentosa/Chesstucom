package graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*; 

public class MainFrame extends JFrame {

	private JSplitPane splitPane;

	public MainFrame() {
		setTitle("Chess");
		setResizable(false);
		setBounds(0, 0, 1022, 585);		
		setFocusable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		setUndecorated(true);
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		setBackground(new Color(0, 0, 0, 0));
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}
	
	public void setLogin(JPanel panel) {
		getContentPane().removeAll();
		repaint();
		add(panel);
	}
	
	public void setMenu(JPanel leftpanel) {
		getContentPane().removeAll();
		repaint();
		
		splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 1022, 585);
		splitPane.setEnabled(false);
		splitPane.setBackground(new Color(0, 0, 0, 0));
		getContentPane().add(splitPane);
		splitPane.setLeftComponent(leftpanel);
	}
	
	public void setConsole(JPanel rightpanel) {
		splitPane.setRightComponent(rightpanel);
		splitPane.setDividerLocation(720);
		validate();
	}
}
