package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.stampsDetails;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class addScreen extends JPanel{
	private MainFrame main;
	private JTextField Name, Year, Quantity, Perforation, Size, Designer, Printer, Method, Description;
	private JButton btnAddStamp;
	private JRadioButton rdbtnCommemorative, rdbtnDefinitive;
	private String type, country, picture;
	private JLabel label, resultlabel;
	private JComboBox countryBox;
	private ImageIcon imageresult;
	private String[] countries={"","Singapore", "Malaysia", "Brunei", "Jordan", "Chile", "Españope"};
	private JTable table;
	
	public addScreen(MainFrame main) {
		setBackground(Color.WHITE);
		this.main=main;
		setLayout(null);
		ButtonGroup btnGroup= new ButtonGroup();
		
		JLabel lblAddStamps = new JLabel("Add Stamps");
		lblAddStamps.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddStamps.setBounds(331, 13, 309, 32);
		add(lblAddStamps);
		
		JButton btnReturnToMenu = new JButton("Return to View Screen");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showView();				//moves to view screen after button has been pressed
			}
		});
		btnReturnToMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnToMenu.setBounds(58, 702, 269, 25);
		add(btnReturnToMenu);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(93, 105, 73, 25);
		add(lblName);
		
		JLabel lblYearOfIssue = new JLabel("Year Of Issue:");
		lblYearOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYearOfIssue.setBounds(38, 143, 128, 16);
		add(lblYearOfIssue);
		
		JLabel lblCountryOfIssue = new JLabel("Country Of Issue:");
		lblCountryOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCountryOfIssue.setBounds(12, 179, 154, 25);
		add(lblCountryOfIssue);
		
		JLabel lblQuantityOfStam = new JLabel("Quantity Of Issue:");
		lblQuantityOfStam.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantityOfStam.setBounds(12, 217, 154, 25);
		add(lblQuantityOfStam);
		
		JLabel lblPerforationStamp = new JLabel("Perforation Size:");
		lblPerforationStamp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPerforationStamp.setBounds(22, 255, 139, 25);
		add(lblPerforationStamp);
		
		JLabel lblSizeOfStamp = new JLabel("Size of Stamp:");
		lblSizeOfStamp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSizeOfStamp.setBounds(38, 293, 128, 26);
		add(lblSizeOfStamp);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblType.setBounds(93, 323, 56, 32);
		add(lblType);
		
		JLabel lblStampDesigner = new JLabel("Stamp Designer:");
		lblStampDesigner.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStampDesigner.setBounds(22, 367, 139, 25);
		add(lblStampDesigner);
		
		JLabel lblPrinter = new JLabel("Printer:");
		lblPrinter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrinter.setBounds(93, 405, 73, 16);
		add(lblPrinter);
		
		JLabel lblPrintingMethod = new JLabel("Printing Method:");
		lblPrintingMethod.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrintingMethod.setBounds(22, 434, 128, 25);
		add(lblPrintingMethod);
		
		JLabel lblShortDescription = new JLabel("Short Description:");
		lblShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblShortDescription.setBounds(12, 464, 146, 32);
		add(lblShortDescription);
		
		Name = new JTextField();
		Name.setBounds(178, 108, 167, 22);
		add(Name);
		Name.setColumns(10);
		
		this.Year = new JTextField();
		this.Year.setColumns(10);
		this.Year.setBounds(178, 142, 167, 22);
		add(this.Year);
		
		this.Quantity = new JTextField();
		this.Quantity.setColumns(10);
		this.Quantity.setBounds(178, 220, 167, 22);
		add(this.Quantity);
		
		this.Perforation = new JTextField();
		this.Perforation.setColumns(10);
		this.Perforation.setBounds(178, 258, 167, 22);
		add(this.Perforation);
		
		this.Size = new JTextField();
		this.Size .setColumns(10);
		this.Size .setBounds(178, 297, 167, 22);
		add(this.Size );
		
		this.Designer = new JTextField();
		this.Designer.setColumns(10);
		this.Designer.setBounds(178, 370, 167, 22);
		add(this.Designer);
		
		this.Printer = new JTextField();
		this.Printer.setColumns(10);
		this.Printer.setBounds(178, 404, 167, 22);
		add(this.Printer);
		
		this.Method = new JTextField();
		this.Method.setColumns(10);
		this.Method.setBounds(178, 437, 167, 22);
		add(this.Method);
		
		this.Description = new JTextField();
		this.Description.setColumns(10);
		this.Description.setBounds(178, 471, 167, 70);
		add(this.Description);
		
		this.btnAddStamp = new JButton("Add Stamp");
		btnAddStamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = Name.getText();
				int year = Integer.valueOf(Year.getText());
				int quantity = Integer.valueOf(Quantity.getText());
				Float perforation =Float.valueOf(Perforation.getText());
				String size= Size.getText();
				String designer = Designer.getText();
				String printer = Printer.getText();
				String method = Method.getText();
				String description = Description.getText();
				main.getController().addStampD(name, year, country, quantity, perforation, size, designer, printer, method, description, type);
				//saves data into vector stampList
				
				main.showViewScreen();		// moves to view screen after adding
				
				try{
					main.getController().writeStamp(name, year, country, quantity, perforation, size, type , designer, printer, method, description);
				//writes data into text file
				}
				catch(Exception e1){
					e1.printStackTrace();
					System.out.println("Something went wrong");
				}
				
			}
		});
		this.btnAddStamp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.btnAddStamp.setBounds(69, 620, 181, 44);
		add(this.btnAddStamp);
		
		this.rdbtnCommemorative = new JRadioButton("Commemorative");
		rdbtnCommemorative.setBackground(Color.WHITE);
		this.rdbtnCommemorative.addActionListener(new RadioButtonBoxListener());
		this.rdbtnCommemorative.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.rdbtnCommemorative.setBounds(178, 329, 149, 25);
		add(this.rdbtnCommemorative);
		btnGroup.add(rdbtnCommemorative);
		
		
		this.rdbtnDefinitive = new JRadioButton("Definitive");
		rdbtnDefinitive.setBackground(Color.WHITE);
		this.rdbtnDefinitive.addActionListener(new RadioButtonBoxListener());
		this.rdbtnDefinitive.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.rdbtnDefinitive.setBounds(331, 329, 127, 25);
		add(this.rdbtnDefinitive);
		btnGroup.add(this.rdbtnDefinitive);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("pic/GoodStamps.jpg"));
		label.setBounds(538, 688, 464, 57);
		add(label);
		
		this.countryBox = new JComboBox(this.countries);
		this.countryBox.setBackground(Color.WHITE);
		this.countryBox.addActionListener(new JComboBoxListener());
		this.countryBox.setBounds(178, 182, 167, 22);
		add(this.countryBox);
		
		this.resultlabel = new JLabel(imageresult);
		this.resultlabel.setBounds(511, 105, 322, 210);
		add(this.resultlabel);
		
		JButton btnRecallStamps = new JButton("Recall Stamps");
		btnRecallStamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					main.getController().file();					//reads data from text file

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				main.showViewScreen();								//moves to viewscreen if recall button is pressed
			}
		});
		btnRecallStamps.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRecallStamps.setBounds(370, 616, 128, 44);
		add(btnRecallStamps);
		
		
	}

	/**
	 * 
	 */
	public class RadioButtonBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(rdbtnCommemorative.isSelected()){
				type = "Commemorative";
			}
			else if(rdbtnDefinitive.isSelected()){
				type = "Definitive";
			}
			
		}
		
	}
	
	public class JComboBoxListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cCombo();
		}
				
	}
	public void cCombo(){
		String selectedcountry = this.countryBox.getSelectedItem().toString();
		ImageIcon imageresult = null;
		
		if(selectedcountry.equals("Singapore")){
			country="Singapore";
			imageresult = new ImageIcon("pic/singapore.jpg");
		}
		else if(selectedcountry.equals("Malaysia")){
			country="Malaysia";
			imageresult = new ImageIcon("pic/malaysia.jpg");
		}
		else if(selectedcountry.equals("Brunei")){
			country="Brunei";
			imageresult = new ImageIcon("pic/Brunei.jpg");
		}
		else if(selectedcountry.equals("Jordan")){
			country="Jordan";
			imageresult = new ImageIcon("pic/Jordan.jpg");
		}
		else if(selectedcountry.equals("Chile")){
			country="Chile";
			imageresult = new ImageIcon("pic/Chile.jpg");
		}
		else if(selectedcountry.equals("Españope")){
			country="Españope";
			imageresult = new ImageIcon("pic/spain.jpg");
		}
		resultlabel.setIcon(imageresult);					//display respective country picture
	}
	
	public void showView() { 
		this.main.showViewScreen();
	 } 
}
