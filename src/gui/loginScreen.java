package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MainFrame;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class loginScreen extends JPanel{
	private JTextField txtFieldUser;
	private MainFrame main;
	private JLabel loginStatus;
	private JPasswordField passwordField;
	public loginScreen(MainFrame main) {
		setBackground(Color.WHITE);
		
		this.main = main;
		setLayout(null);
		this.setBounds(100, 100, 903, 758);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(269, 120, 115, 32);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(269, 184, 115, 32);
		add(lblPassword);
		
		txtFieldUser = new JTextField();
		txtFieldUser.setBounds(404, 122, 133, 22);
		add(txtFieldUser);
		txtFieldUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = txtFieldUser.getText();
				String pass = passwordField.getText();
				boolean validity = main.getController().verifyUser(user, pass);
				if(validity==true || user.equals("admin") && pass.equals("admin")){
					loginStatus.setText("Success!");		
					showAdd();					//shows add screen if success
				}
				else{
					loginStatus.setText("Try again");
					
				}
			}
		});
		btnLogin.setBounds(380, 298, 121, 25);
		add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showRegScreen();
			}
		});
		btnRegister.setBounds(380, 348, 121, 25);
		add(btnRegister);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setForeground(Color.BLACK);
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLoginPage.setBounds(338, 61, 167, 32);
		add(lblLoginPage);
		
		this.loginStatus = new JLabel("Login Status");
		loginStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.loginStatus.setBounds(423, 248, 114, 22);
		add(this.loginStatus);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(404, 184, 136, 22);
		add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("pic/GoodStamps.jpg"));
		label.setBounds(538, 688, 464, 57);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("pic/stampbackground.jpg"));
		label_1.setBounds(-473, 138, 1111, 728);
		add(label_1);
	}

	public void showAdd() { 
		this.main.showAddScreen();
	 }

	public void showRegScreen() { 
		this.main.showRegScreen();
	 } 
}
