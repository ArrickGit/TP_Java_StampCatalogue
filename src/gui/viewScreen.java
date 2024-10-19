package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.stampsDetails;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewScreen extends JPanel{
	private MainFrame main;
	private stampsDetails[] stamps;
 	private DefaultTableModel model = new DefaultTableModel();
	private JTextField textField = new JTextField();
	private JTable table = new JTable(model);
	private int index;
	private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
	
	public viewScreen(MainFrame main) {
		setBackground(Color.WHITE);
		table.setRowSorter(rowSorter);
		this.main=main;
		setLayout(null);
		
		model.addColumn("Name");				//adds column for respective data
		model.addColumn("Year");
		model.addColumn("Country");
		model.addColumn("Quantity");
		model.addColumn("Perforation");
		model.addColumn("Size");
		model.addColumn("Type");
		model.addColumn("Designer");
		model.addColumn("Printer");
		model.addColumn("Method");
		model.addColumn("Description");
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);				//disable auto resize
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		table.getColumnModel().getColumn(10).setPreferredWidth(500);
		
		JLabel lblViewScreen = new JLabel("View Screen");
		lblViewScreen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewScreen.setBounds(281, 40, 268, 32);
		add(lblViewScreen);

		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index == -1)
					return;
				stampsDetails stamp = stamps[index];
				main.showUpdateScreen(index, stamp);			//moves to update screen when pressed
			}
		});
		btnUpdate.setBounds(56, 524, 97, 25);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = table.getSelectedRow();
				if(index == -1)
					return;
				model.removeRow(index);
				stampsDetails stamp = stamps[index];
				main.getController().delStamps(index, stamp);			//deletes selected data
				
			}
		});
		btnDelete.setBounds(366, 524, 97, 25);
		add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(165, 101, 185, 22);
		add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));		//filter out data base on what's in the textfield
                }
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));		//filter out data base on what's in the textfield
                }
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				 String text = textField.getText();
				 if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));	//filter out data base on what's in the textfield
	                }
			}});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(46, 164, 768, 328);
		add(scrollPane);
		
		JButton btnAddMoreStamps = new JButton("Add more stamps");
		btnAddMoreStamps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showAddScreen();					//moves to add screen when pressed
			}
		});
		btnAddMoreStamps.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddMoreStamps.setBounds(22, 605, 196, 25);
		add(btnAddMoreStamps);
		
		JLabel lblEnterSearch = new JLabel("Enter Search:");
		lblEnterSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterSearch.setBounds(74, 94, 127, 32);
		add(lblEnterSearch);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("pic/GoodStamps.jpg"));
        label.setBounds(538, 688, 464, 57);
        add(label);
		this.populateStamp();
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("pic/stampbackground.jpg"));
		label_1.setBounds(513, 164, 1196, 821);
		add(label_1);
	}

	private void populateStamp()
	{
		this.stamps= this.main.getController().getAllStamps();
		for(int i=0; i<stamps.length; i++)
		{
			stampsDetails op = stamps[i];
			model.insertRow(table.getRowCount(), new Object[]{op.getName(), op.getYearOfIssue(), op.getCountryOfIssue(), op.getQuantityOfIssue() + ".0", "Comb " +op.getPerforationSize(), op.getSizeOfStamp() + " mm", op.gettype(), op.getStampDesigner(), op.getPrinter(), op.getPrintingMethod(), op.shortDescription});
			//insert row for JTable
		}
		this.table.setModel(model);
	}
}