package graphics.ui;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WrongLogin extends JDialog {

	private static final long serialVersionUID = 1L;

	public WrongLogin(JFrame parent, String title, String message) {
		super(parent, title);
		Point p = new Point(600, 300);
		setLocation(p.x, p.y);
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(message));
		getContentPane().add(messagePane);


		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Close me");
		buttonPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});

		// set action listener on the button
		getContentPane().add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
}

