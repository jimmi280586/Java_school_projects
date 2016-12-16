package src.system.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LogIn extends JFrame {

	private static final long serialVersionUID = -3708314060372109715L;

	private JTextField userNameField;
	private JTextField passwordField;
	private JButton cancelButton;
	private JButton proceedButton;

	private String username;
	private String password;
	
	class ButtonListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == cancelButton){
				LogIn.this.dispose();
			}
			if(e.getSource() == proceedButton){
				username = userNameField.getText();
				password = passwordField.getText();
				if(username.equals("admin") && password.equals("admin")){
					JFrame superGui = new SuperUserGUI();
					superGui.setVisible(true);
					dispose();
				}
				else if(username.equals("guest") && password.equals("")){
					JFrame guestGui = new ClientUserGUI();
					guestGui.setVisible(true);
					dispose();
				}
				else{
					userNameField.setText(null);
					passwordField.setText(null);
				}
				
			}
			
		}
	}

	public LogIn() {
		super("Log In");
		setSize(880, 380);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(83, 63, 64));
		
		JLabel login = new JLabel("LOG IN");
		login.setBounds(413, 75, 66, 40);
		login.setFont(new Font("Arial", Font.PLAIN, 18));
		login.setForeground(Color.WHITE);
		getContentPane().add(login);

		userNameField = new JTextField("Username");
		userNameField.setFont(new Font("Arial", Font.PLAIN, 11));
		userNameField.setBounds(173, 125, 534, 40);
		getContentPane().add(userNameField);
		userNameField.addActionListener(new ButtonListner());

		passwordField = new JTextField("Password");
		passwordField.setFont(new Font("Arial", Font.PLAIN, 11));
		passwordField.setBounds(173, 175, 534, 40);
		getContentPane().add(passwordField);
		passwordField.addActionListener(new ButtonListner());

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 18));
		cancelButton.setBounds(173, 225, 265, 40);
		cancelButton.setBorder(null);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(new Color(189, 136, 138));
		cancelButton.setFocusPainted(false);
		getContentPane().add(cancelButton);
		cancelButton.addActionListener(new ButtonListner());

		proceedButton = new JButton("Proceed");
		proceedButton.setFont(new Font("Arial", Font.PLAIN, 18));
		proceedButton.setBounds(440, 225, 265, 40);
		proceedButton.setBorder(null);
		proceedButton.setForeground(Color.WHITE);
		proceedButton.setBackground(new Color(189, 136, 138));
		proceedButton.setFocusPainted(false);
		getContentPane().add(proceedButton);
		proceedButton.addActionListener(new ButtonListner());

	}
}
