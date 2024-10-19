package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import data.stampsDetails;
import gui.addScreen;
import gui.loginScreen;
import gui.regScreen;
import gui.summary;
import gui.updateScreen;
import gui.viewScreen;

public class MainFrame extends JFrame implements WindowListener{
	private CardLayout card;
	private Controller cont;
	
	public MainFrame(){
		setBackground(Color.WHITE);
		this.card = new CardLayout();
		this.cont = new Controller();
		addWindowListener(this);
		
		JWindow window = new JWindow();
		window.getContentPane().add(
			    new JLabel("", new ImageIcon("pic/Project.gif"), SwingConstants.CENTER)); //enable window for loading screen
			window.setBounds(700, 400, 600, 300);
			window.setVisible(true);
			try {
			    Thread.sleep(10500); 								//loading window close after 10.5seconds
			} 
			catch (InterruptedException e) {
			    e.printStackTrace();
			}
			window.setVisible(false);
			window.dispose();										//closes the loading window

		this.setName("Stamp");
		this.setSize(900,800);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(this.card);
		this.showLogin();
		this.setVisible(true);
	}
	
	public updateScreen updatestamp;

	public loginScreen loginscreen;

	public regScreen regscreen;

	public viewScreen viewstamp;
	
	public summary summary;

	public addScreen addstamp;

	public updateScreen getUpdatestamp() {
	 	 return updatestamp; 
	}

	public void setUpdatestamp(updateScreen updatestamp) { 
		 this.updatestamp = updatestamp; 
	}

	public summary getSummary() {
	 	 return summary; 
	}

	public void setSummary(summary summary) { 
		 this.summary = summary; 
	}

	public Controller getController() {
	 	 return this.cont; 
	}

	public void setController(Controller controller) { 
		 this.cont = controller; 
	}

	public loginScreen getLoginscreen() {
	 	 return loginscreen; 
	}

	public void setLoginscreen(loginScreen loginscreen) { 
		 this.loginscreen = loginscreen; 
	}
 
	public regScreen getRegscreen() {
	 	 return regscreen; 
	}

	public void setRegscreen(regScreen regscreen) { 
		 this.regscreen = regscreen; 
	}

	public viewScreen getViewstamp() {
	 	 return viewstamp; 
	}

	public void setViewstamp(viewScreen viewstamp) { 
		 this.viewstamp = viewstamp; 
	}

	public addScreen getAddstamp() {
	 	 return addstamp; 
	}

	public void setAddstamp(addScreen addstamp) { 
		 this.addstamp = addstamp; 
	}

	public void showSummaryScreen() { 
		summary summary = new summary(this);
		getContentPane().add(summary, "summary");
		this.card.show(this.getContentPane(), "summary");
	 }

	public void showUpdateScreen(int index, stampsDetails stamp) { 
		updateScreen update = new updateScreen(this, index, stamp);
		getContentPane().add(update, "update");
		this.card.show(this.getContentPane(), "update");
	 }


	public void showLogin() { 
		loginScreen login = new loginScreen(this); 			//show login page
		getContentPane().add(login, "login");
		this.card.show(this.getContentPane(), "login");
	 }

	public void showViewScreen() {  						//show view page
		viewScreen view= new viewScreen(this);
		getContentPane().add(view, "view");
		this.card.show(this.getContentPane(), "view");
	 }

	public void showAddScreen() { 							//show add page
		addScreen add = new addScreen(this);
		getContentPane().add(add, "add");
		this.card.show(this.getContentPane(), "add");
	 } 
	
	public void showRegScreen(){							//show register page
		regScreen reg = new regScreen(this);
		getContentPane().add(reg, "reg");
		this.card.show(this.getContentPane(), "reg");
	}
	public static void main(String args[]) { 
		MainFrame gui = new MainFrame();
	 }

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("Closed");
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		showSummaryScreen();							//show summary screen when closing
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		//showSummaryScreen();
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
