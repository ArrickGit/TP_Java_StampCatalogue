package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.MainFrame;
import data.stampsDetails;
import gui.addScreen.JComboBoxListener;
import gui.addScreen.RadioButtonBoxListener;
import javax.swing.ImageIcon;
import java.awt.Color;

public class updateScreen extends JPanel{
	private MainFrame main;
	private JTextField Name, Year, Quantity, Perforation, Size, Designer, Printer, Method, Description;
	private JButton btnAddStamp;
	private JRadioButton rdbtnCommemorative, rdbtnDefinitive;
	private JComboBox countryBox;
	private JLabel resultlabel;
	private ImageIcon imageresult;
	private stampsDetails op;
	private String type, country;
	private String[] countries={"","Singapore", "Malaysia", "Brunei", "Jordan", "Chile", "Españope"};

	public updateScreen(MainFrame main, int index, stampsDetails stamp) {
		setBackground(Color.WHITE);
		this.main=main;
		this.index = index;
		this.op = stamp;
		setLayout(null);
		ButtonGroup btnGroup= new ButtonGroup();
		
		JLabel lblAddStamps = new JLabel("Update Stamps");
		lblAddStamps.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddStamps.setBounds(331, 13, 309, 32);
		add(lblAddStamps);
		
		JButton btnReturnToMenu = new JButton("Return to View Stamps");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showView();
			}
		});
		btnReturnToMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnToMenu.setBounds(62, 686, 283, 25);
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
		
		this.Name = new JTextField();
		this.Name.setBounds(178, 108, 167, 22);
		add(this.Name);
		this.Name.setColumns(10);
		Name.setText(op.getName());					//set text base on what data selected
		
		this.Year = new JTextField();
		this.Year.setColumns(10);
		this.Year.setBounds(178, 142, 167, 22);
		add(this.Year);
		Year.setText(""+ op.getYearOfIssue());		//set text base on what data selected
		
		this.Quantity = new JTextField();
		this.Quantity.setColumns(10);
		this.Quantity.setBounds(178, 220, 167, 22);
		add(this.Quantity);
		Quantity.setText(""+ op.getQuantityOfIssue());	//set text base on what data selected
		
		this.Perforation = new JTextField();
		this.Perforation.setColumns(10);
		this.Perforation.setBounds(178, 258, 167, 22);
		add(this.Perforation);
		Perforation.setText(""+ op.getPerforationSize());	//set text base on what data selected
		
		this.Size = new JTextField();
		this.Size .setColumns(10);
		this.Size .setBounds(178, 297, 167, 22);
		add(this.Size );
		Size.setText(""+ op.getSizeOfStamp());	//set text base on what data selected
		
		this.Designer = new JTextField();
		this.Designer.setColumns(10);
		this.Designer.setBounds(178, 370, 167, 22);
		add(this.Designer);
		Designer.setText(""+ op.getStampDesigner());	//set text base on what data selected
		
		this.Printer = new JTextField();
		this.Printer.setColumns(10);
		this.Printer.setBounds(178, 404, 167, 22);
		add(this.Printer);
		Printer.setText(""+ op.getPrinter());			//set text base on what data selected
		
		this.Method = new JTextField();
		this.Method.setColumns(10);
		this.Method.setBounds(178, 437, 167, 22);
		add(this.Method);
		Method.setText(""+ op.getPrintingMethod());		//set text base on what data selected
		
		this.Description = new JTextField();
		this.Description.setColumns(10);
		this.Description.setBounds(178, 471, 167, 70);
		add(this.Description);
		Description.setText(""+ op.getShortDescription());		//set text base on what data selected
		
		this.countryBox = new JComboBox(this.countries);
		this.countryBox.setBackground(Color.WHITE);
		this.countryBox.addActionListener(new JComboBoxListener());
		this.countryBox.setBounds(178, 182, 167, 22);
		add(this.countryBox);
		countryBox.setSelectedItem(this.countries);			//set text base on what data selected
		
		this.resultlabel = new JLabel(imageresult);
		this.resultlabel.setBounds(511, 105, 322, 210);
		add(this.resultlabel);
		
		this.btnAddStamp = new JButton("Update Stamp");
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
				stampsDetails newStamp = new stampsDetails(name, year, country, quantity, perforation, size, designer, printer, method, description, type);
				main.getController().updateStamp(index, newStamp);
				//updates data into vector stampList
				
				main.showViewScreen();
				//shows view screen when pressed
				
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
		this.btnAddStamp.setBounds(105, 604, 181, 44);
		add(this.btnAddStamp);
		
		this.rdbtnCommemorative = new JRadioButton("Commemorative");
		rdbtnCommemorative.setBackground(Color.WHITE);
		this.rdbtnCommemorative.addActionListener(new RadioButtonBoxListener());
		this.rdbtnCommemorative.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.rdbtnCommemorative.setBounds(178, 329, 149, 25);
		add(this.rdbtnCommemorative);
		btnGroup.add(rdbtnCommemorative);
		this.rdbtnCommemorative.setSelected(true);
		
		
		this.rdbtnDefinitive = new JRadioButton("Definitive");
		rdbtnDefinitive.setBackground(Color.WHITE);
		this.rdbtnDefinitive.addActionListener(new RadioButtonBoxListener());
		this.rdbtnDefinitive.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.rdbtnDefinitive.setBounds(331, 329, 127, 25);
		add(this.rdbtnDefinitive);
		btnGroup.add(this.rdbtnDefinitive);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("pic/GoodStamps.jpg"));
		label.setBounds(538, 688, 464, 57);
		add(label);
	}

	public int index;

	public stampsDetails StampD;

	public int getIndex() {
	 	 return index; 
	}

	public void setIndex(int index) { 
		 this.index = index; 
	}

	public stampsDetails getStampD() {
	 	 return StampD; 
	}

	public void setStampD(stampsDetails StampD) { 
		 this.StampD = StampD; 
	}
	
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
		resultlabel.setIcon(imageresult);
	}

	public void showView() { 
		this.main.showViewScreen();
	 } 
}
