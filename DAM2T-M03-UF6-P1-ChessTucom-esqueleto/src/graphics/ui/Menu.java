package graphics.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Menu extends JPanel {
	private JTable table;
	private JScrollPane scrollPanel;
	private JButton playButton;
	private JButton closeButton;
	private JButton logoutButton;
	private JButton exitGameButton;
	private JLabel background;
	
	public Menu() {
		setLayout(null);
		setBounds(0, 0, 750, 586);
		
		playButton = new JButton("New game");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playButton.setBounds(80, 406, 280, 49);
		playButton.setForeground(new Color(255, 255, 255));
		playButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		playButton.setBackground(new Color(51, 204, 102));
		playButton.setBorderPainted(false);
		playButton.setFocusPainted(false);
		add(playButton);
		
		exitGameButton = new JButton("Exit");
		exitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitGameButton.setBounds(370, 406, 280, 49);
		exitGameButton.setForeground(Color.WHITE);
		exitGameButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		exitGameButton.setBackground(new Color(250, 128, 114));
		exitGameButton.setBorderPainted(false);
		exitGameButton.setFocusPainted(false);
		add(exitGameButton);
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		closeButton.setBounds(80, 465, 280, 49);
		closeButton.setForeground(Color.WHITE);
		closeButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		closeButton.setBackground(new Color(250, 128, 114));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		add(closeButton);
		closeButton.setVisible(false);
		
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		logoutButton.setBackground(new Color(255, 153, 102));
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setBounds(370, 465, 280, 49);
		add(logoutButton);
	}
	
	public void createTable(String[][] data) {
		if(scrollPanel!=null) {
			remove(scrollPanel);
			remove(background);
		}
		
		Object[] column = {"Name", "ACCION", "DATE"};

	    table = new JTable(data, column);
		table.setBounds(0, 0, 479, 265);
		table.setShowHorizontalLines(false);
		table.setBorder(null);
		table.setFont(new Font("Verdana", Font.PLAIN, 11));
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(80, 83, 556, 306);
		scrollPanel.setOpaque(false);
		add(scrollPanel);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(Login.class.getResource("/graphics/pictures/background.png")));
		background.setBounds(0, 0, 768, 650);
		add(background);
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
	
	public JButton getExitButton() {
		return exitGameButton;
	}

	public void hideStartButton() {
		exitGameButton.setVisible(false);
		logoutButton.setVisible(true);
		playButton.setVisible(false);
		closeButton.setVisible(true);
	}
	
	public void showStartButton() {
		closeButton.setVisible(false);
		logoutButton.setVisible(true);
		playButton.setVisible(true);
		exitGameButton.setVisible(true);
	}
}
