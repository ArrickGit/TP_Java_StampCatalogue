package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.stampsDetails;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class summary extends JPanel{
	private MainFrame main;
	private DefaultTableModel model;
	private JTable table;
	private stampsDetails[] stamps;
	
	public summary(MainFrame main){
		setBackground(Color.WHITE);
		this.main=main;
		
		this.model = new DefaultTableModel();
		this.table = new JTable(model);
		
		model.addColumn("Name");			//add column for name
		model.addColumn("Year");			//add column for year
		model.addColumn("Country");			//add column for country
		model.addColumn("Quantity");		//add column for quantity
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(477, 370, 294, 64);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);					//closes the program after button has been pressed
			}
		});
		setLayout(null);
		add(btnExit);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setBounds(170, 13, 375, 46);
		lblSummary.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblSummary);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 94, 801, 224);
		add(scrollPane);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon("pic/GoodStamps.jpg"));
		label.setBounds(538, 688, 464, 57);
		add(label);
		this.populateStamp();
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("pic/stampbackground.jpg"));
		label_1.setBounds(-473, 138, 1111, 728);
		add(label_1);
	}
	
	private int year;

	private String name;
	/**
	 * Getter of year
	 */
	public int getYear() {
	 	 return year; 
	}
	/**
	 * Setter of year
	 */
	public void setYear(int year) { 
		 this.year = year; 
	}
	/**
	 * Getter of name
	 */
	public String getName() {
	 	 return name; 
	}
	/**
	 * Setter of name
	 */
	public void setName(String name) { 
		 this.name = name; 
	}
	
	private void populateStamp()
	{
		this.stamps= this.main.getController().getAllStamps();
		for(int i=0; i<stamps.length; i++)
		{
			stampsDetails op = stamps[i];
			model.insertRow(table.getRowCount(), new Object[]{op.getName(), op.getYearOfIssue(), op.getCountryOfIssue(), op.getQuantityOfIssue()});
			//insert row into JTable
		}
		this.table.setModel(model);
	}
	
}
