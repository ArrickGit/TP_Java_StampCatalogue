package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class regScreen extends JPanel{
	private MainFrame main;
	private JTextField txtFieldUN;
	private JTextField txtFieldPW;
	private JLabel lblRegStatus;
	public regScreen(MainFrame main) {
		setBackground(Color.WHITE);
		this.main=main;
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(269, 120, 115, 32);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(269, 184, 115, 32);
		add(lblPassword);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRegister.setBounds(338, 61, 167, 31);
		add(lblRegister);
		
		this.txtFieldUN = new JTextField();
		this.txtFieldUN.setBounds(404, 122, 133, 22);
		add(this.txtFieldUN);
		this.txtFieldUN.setColumns(10);
		
		this.txtFieldPW = new JTextField();
		this.txtFieldPW.setBounds(404, 184, 136, 22);
		add(this.txtFieldPW);
		this.txtFieldPW.setColumns(10);
		
		this.lblRegStatus = new JLabel("Register Status");
		lblRegStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.lblRegStatus.setBounds(423, 248, 311, 22);
		add(this.lblRegStatus);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtFieldUN.getText().isEmpty()){
					lblRegStatus.setText("Please Enter a Username");
				}
				else if(txtFieldPW.getText().isEmpty()){
					lblRegStatus.setText("Please Enter a Password");
				}
				else{
					String user = txtFieldUN.getText();
					String pass = txtFieldPW.getText();
					Boolean a=main.getController().exisUser(user);
                    if(a==true){
                        lblRegStatus.setText("Existing User");			//disallow duplicate username
                    }
                    else if(a==false){
                    main.getController().regUser(user, pass);
                    lblRegStatus.setText("Successful!");
                    }
				}
			}
		});
		btnRegister.setBounds(380, 298, 161, 25);
		add(btnRegister);
		
		JButton btnReturnToLogin = new JButton("Return to Login");
		btnReturnToLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReturnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLogin();					//moves back to login page after button has been pressed
			}
		});
		btnReturnToLogin.setBounds(380, 348, 159, 25);
		add(btnReturnToLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("pic/GoodStamps.jpg"));
		label.setBounds(538, 688, 464, 57);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("pic/stampbackground.jpg"));
		label_1.setBounds(-473, 138, 1111, 728);
		add(label_1);
		
	}
}
