package graphics.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Login extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton login;
	private JButton exit;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	
	public Login() {
		setBounds(0, 0, 1022, 586);
		setLayout(null);
		setOpaque(false);
		setBackground(new Color(0,0,0,0));
		usernameField = new JTextField();
		usernameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		usernameField.setForeground(Color.WHITE);
		usernameField.setBounds(362, 235, 281, 42);
		usernameField.setBorder(BorderFactory.createCompoundBorder(usernameField.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		usernameField.setOpaque(false);
		add(usernameField);
		usernameField.setColumns(10);
		
		login = new JButton("Sign In");
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Verdana", Font.BOLD, 14));
		login.setBackground(new Color(51, 204, 102));
		login.setBorderPainted(false);
		login.setFocusPainted(false);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setBounds(362, 352, 281, 42);
		add(login);
		
		exit = new JButton("Exit");
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Verdana", Font.BOLD, 14));
		exit.setBackground(new Color(250, 128, 114));
		exit.setBounds(362, 406, 281, 42);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		add(exit);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(BorderFactory.createCompoundBorder(passwordField.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordField.setBounds(362, 288, 281, 42);
		passwordField.setOpaque(false);
		add(passwordField);
		
		JLabel caballo = new JLabel("");
		caballo.setIcon(new ImageIcon(Login.class.getResource("/graphics/pictures/caballo.png")));
		caballo.setBounds(-26, 157, 218, 286);
		add(caballo);
		
		JLabel caballo_blanco = new JLabel("");
		caballo_blanco.setIcon(new ImageIcon(Login.class.getResource("/graphics/pictures/caballo_blanco.png")));
		caballo_blanco.setBounds(854, 157, 218, 286);
		add(caballo_blanco);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/graphics/pictures/logo.png")));
		logo.setBounds(146, 495, 93, 91);
		add(logo);
		
		JLabel chesslogo = new JLabel("");
		chesslogo.setIcon(new ImageIcon(Login.class.getResource("/graphics/pictures/ChessTucom.png")));
		chesslogo.setBounds(362, 53, 390, 125);
		add(chesslogo);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Login.class.getResource("/graphics/pictures/background.png")));
		background.setBounds(177, 0, 667, 598);
		add(background);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(191, 0, 625, 573);
		add(panel);
		
		
	}

	public JButton getLogin() {
		return login;
	}
	
	public JButton getExitButton() {
		return exit;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
