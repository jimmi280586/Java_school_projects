package src.system.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import src.system.controller.ClientController;
import src.system.gui.result.Add;
import src.system.gui.result.Compare;
import src.system.gui.result.Remove;
import src.system.gui.result.Search;

public class SuperUserGUI extends JFrame {

	private static final long serialVersionUID = -2262040528589857133L;

	private JPanel menu;

	private JButton searchButton;
	private JButton proceedSearch;

	private JButton compareButton;
	private JButton proceedCompare;

	private JButton updateButton;
	private JButton proceedButtonUpdate;
	private JTextField nameUpdate;
	
	private JButton removeButton;
	private JButton proceedRemove;

	private JButton addButton;
	private JButton catProceed;
	private JButton upProceed;
	private JButton cancelButtonAdd;
	private JButton proceedButtonAdd;
	private JComboBox<String> categoryDropDown;
	private JTextField nameField;
	private JTextField historyField;
	private JTextField tasteField;
	private JTextField cookingTimeField;
	private JTextField growingStartField;
	private JTextField growingEndField;
	private JTextField secondNameField;
	private JTextField originsField;
	private JTextField countryCodeField;

	private JPanel display_one;
	private JPanel display_two;

	private JTextField searchField;
	private String searchValue;

	private JTextField compareField;
	private String compareValue;

	private JTextField removeField;
	private String removeFieldValue;
	
	private String buffer;

	private String categoryValue;
	private String nameFieldValue;
	private String historyFieldValue;
	private String tasteFieldValue;
	private String cookingTimeFieldValue;
	private String growingStartFieldValue;
	private String growingEndFieldValue;
	private String secondNameFieldValue;
	private String originsFieldValue;
	private String countryCodeFieldValue;
	private String nameUpdateValue;
	
	private static String str; // category fields into one string

	public static String getter(){
		return str;
	}

	private ClientController control;

	class ButtonListner implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchButton){				
				
				display_one.removeAll();
				display_two.removeAll();
				display_two.repaint();
				searchField = new JTextField("Enter item to search");
				searchField.setBounds(1, 1, 534, 40);
				display_one.add(searchField);
				display_one.repaint();
				searchField.addActionListener(new ButtonListner());
				
				proceedSearch = new JButton("Proceed");
				proceedSearch.setFont(new Font("Arial", Font.PLAIN , 18));
				proceedSearch.setBounds(1, 42, 534, 40);				
				proceedSearch.setBorder(null);							
				proceedSearch.setForeground(Color.WHITE);				
				proceedSearch.setBackground(new Color(189, 136, 138));	
				proceedSearch.setFocusPainted(false);					
				display_one.add(proceedSearch);
				proceedSearch.addActionListener(new ButtonListner());
				
			}
			if (e.getSource() == proceedSearch) {
				searchValue = searchField.getText();
				str = "Search" + "/" + searchValue;
				try {
					control = new ClientController(str);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Search.searchResult(display_one, control.returned());
			}

			if(e.getSource() == compareButton){
				
				display_one.removeAll();
				searchField = new JTextField("Enter item one");
				searchField.setBounds(1, 1, 534, 40);
				display_one.add(searchField);
				display_one.repaint();
				searchField.addActionListener(new ButtonListner());
				
				display_two.removeAll();
				compareField = new JTextField("Enter item two");
				compareField.setBounds(1, 1, 534, 40);
				display_two.add(compareField);
				display_two.repaint();
				compareField.addActionListener(new ButtonListner());
				
				cancelButtonAdd = new JButton("Cancel");
				cancelButtonAdd.setFont(new Font("Arial", Font.PLAIN , 18));
				cancelButtonAdd.setBounds(1, 636, 534, 40);				
				cancelButtonAdd.setBorder(null);							
				cancelButtonAdd.setForeground(Color.WHITE);				
				cancelButtonAdd.setBackground(new Color(189, 136, 138));	
				cancelButtonAdd.setFocusPainted(false);					
				display_one.add(cancelButtonAdd);
				cancelButtonAdd.addActionListener(new ButtonListner());
				
				proceedCompare = new JButton("Proceed");
				proceedCompare.setFont(new Font("Arial", Font.PLAIN , 18));
				proceedCompare.setBounds(1, 636, 534, 40);				
				proceedCompare.setBorder(null);							
				proceedCompare.setForeground(Color.WHITE);				
				proceedCompare.setBackground(new Color(189, 136, 138));	
				proceedCompare.setFocusPainted(false);					
				display_two.add(proceedCompare);
				proceedCompare.addActionListener(new ButtonListner());
				
			}
			if(e.getSource() == proceedCompare){
				searchValue = searchField.getText();
				compareValue = compareField.getText();
				str = "Compare" + "/" + searchValue + "/" + compareValue;
				try {
					control = new ClientController(str);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String[] buff = control.returned().split("/%");
				Compare.compareResult(display_one, buff[0]);
				Compare.compareResult(display_two, buff[1]);
			}
			if(e.getSource() == removeButton){
				display_one.removeAll();
				display_two.removeAll();
				
				removeField = new JTextField("Enter item to remove");
				removeField.setBounds(1, 1, 534, 40);
				display_one.add(removeField);
				display_one.repaint();
				removeField.addActionListener(new ButtonListner());
				
				cancelButtonAdd = new JButton("Cancel");
				cancelButtonAdd.setFont(new Font("Arial", Font.PLAIN , 18));
				cancelButtonAdd.setBounds(1, 636, 534, 40);				
				cancelButtonAdd.setBorder(null);							
				cancelButtonAdd.setForeground(Color.WHITE);				
				cancelButtonAdd.setBackground(new Color(189, 136, 138));	
				cancelButtonAdd.setFocusPainted(false);					
				display_one.add(cancelButtonAdd);
				cancelButtonAdd.addActionListener(new ButtonListner());
				
				proceedRemove = new JButton("Proceed");
				proceedRemove.setFont(new Font("Arial", Font.PLAIN , 18));
				proceedRemove.setBounds(1, 636, 534, 40);				
				proceedRemove.setBorder(null);							
				proceedRemove.setForeground(Color.WHITE);				
				proceedRemove.setBackground(new Color(189, 136, 138));	
				proceedRemove.setFocusPainted(false);					
				display_two.add(proceedRemove);
				proceedRemove.addActionListener(new ButtonListner());
				
				display_one.repaint();
				display_two.repaint();
			}
			if(e.getSource() == proceedRemove){
				removeFieldValue = removeField.getText();
				str = "Remove" + "/" + removeFieldValue;
				try {
					control = new ClientController(str);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Remove.removeResult(display_one, control.returned());
			}
			
			if(e.getSource() == updateButton){
				display_one.removeAll();
				display_two.removeAll();
				
				nameUpdate = new JTextField("Enter item to update");
				nameUpdate.setBounds(1, 1, 534, 40);
				display_two.add(nameUpdate);
				nameUpdate.addActionListener(new ButtonListner());
				
				upProceed = new JButton("Proceed");
				upProceed.setFont(new Font("Arial", Font.PLAIN , 18));
				upProceed.setBounds(1, 636, 534, 40);				
				upProceed.setBorder(null);							
				upProceed.setForeground(Color.WHITE);				
				upProceed.setBackground(new Color(189, 136, 138));	
				upProceed.setFocusPainted(false);					
				display_one.add(upProceed);
				upProceed.addActionListener(new ButtonListner());
				display_one.repaint();
				display_two.repaint();
			}
			
			if(e.getSource() == upProceed){
				
				nameUpdateValue = nameUpdate.getText();
				
				Add.form(display_one, display_two);
				//---
				nameField = new JTextField();
				nameField.setBounds(1, 41, 534, 40);
				display_one.add(nameField);
				nameField.addActionListener(new ButtonListner());
				//---
				historyField = new JTextField();
				historyField.setBounds(1, 200, 534, 40);
				display_one.add(historyField);
				historyField.addActionListener(new ButtonListner());
				//---
				tasteField = new JTextField();
				tasteField.setBounds(1, 359, 534, 40);
				display_one.add(tasteField);
				tasteField.addActionListener(new ButtonListner());
				//---
				cookingTimeField = new JTextField();
				cookingTimeField.setBounds(1, 518, 534, 40);
				display_one.add(cookingTimeField);
				cookingTimeField.addActionListener(new ButtonListner());
				//---
				growingStartField = new JTextField();
				growingStartField.setBounds(1, 41, 264, 40);
				display_two.add(growingStartField);
				growingStartField.addActionListener(new ButtonListner());
				//---
				growingEndField = new JTextField();
				growingEndField.setBounds(269, 41, 264, 40);
				display_two.add(growingEndField);
				growingEndField.addActionListener(new ButtonListner());
				//---
				secondNameField = new JTextField();
				secondNameField.setBounds(1, 200, 534, 40);
				display_two.add(secondNameField);
				secondNameField.addActionListener(new ButtonListner());
				//---
				originsField = new JTextField();
				originsField.setBounds(1, 359, 534, 40);
				display_two.add(originsField);
				originsField.addActionListener(new ButtonListner());
				//---
				countryCodeField = new JTextField();
				countryCodeField.setBounds(1, 518, 534, 40);
				display_two.add(countryCodeField);
				countryCodeField.addActionListener(new ButtonListner());
				//---
				cancelButtonAdd = new JButton("Cancel");
				cancelButtonAdd.setFont(new Font("Arial", Font.PLAIN , 18));
				cancelButtonAdd.setBounds(1, 636, 534, 40);				
				cancelButtonAdd.setBorder(null);							
				cancelButtonAdd.setForeground(Color.WHITE);				
				cancelButtonAdd.setBackground(new Color(189, 136, 138));	
				cancelButtonAdd.setFocusPainted(false);					
				display_one.add(cancelButtonAdd);
				cancelButtonAdd.addActionListener(new ButtonListner());
				
				proceedButtonUpdate = new JButton("Proceed");
				proceedButtonUpdate.setFont(new Font("Arial", Font.PLAIN , 18));
				proceedButtonUpdate.setBounds(1, 636, 534, 40);				
				proceedButtonUpdate.setBorder(null);							
				proceedButtonUpdate.setForeground(Color.WHITE);				
				proceedButtonUpdate.setBackground(new Color(189, 136, 138));	
				proceedButtonUpdate.setFocusPainted(false);					
				display_two.add(proceedButtonUpdate);
				proceedButtonUpdate.addActionListener(new ButtonListner());
			}
			
			if(e.getSource() == addButton){
				
				display_one.removeAll();
				display_two.removeAll();
				
				
				categoryDropDown = new JComboBox<String>();
				categoryDropDown.addItem("");
				categoryDropDown.addItem("Apples");
				categoryDropDown.addItem("Citrus");
				categoryDropDown.addItem("Kiwi");
				categoryDropDown.addItem("Avocados");
				categoryDropDown.addItem("Bananas");
				categoryDropDown.addItem("Stone fruit");
				categoryDropDown.addItem("Grapes");
				categoryDropDown.addItem("Pears");
				categoryDropDown.addItem("Pineapple");
				categoryDropDown.addItem("Melons");
				categoryDropDown.addItem("Carrots");
				categoryDropDown.addItem("Onions");
				categoryDropDown.addItem("Peppers");
				categoryDropDown.addItem("Kale");
				categoryDropDown.addItem("Corn");
				categoryDropDown.addItem("Peas");
				categoryDropDown.addItem("Pumpkin family");
				categoryDropDown.addItem("Salats");
				categoryDropDown.addItem("Berries");
				categoryDropDown.addItem("Spices");
				categoryDropDown.addItem("Roots");
				categoryDropDown.addItem("Organic");
				categoryDropDown.addItem("Special fruits");
				categoryDropDown.addItem("Special vegetables");
				categoryDropDown.addItem("Tomatoes");
				categoryDropDown.addItem("Potatoes");
				categoryDropDown.addItem("Date");
				categoryDropDown.addItem("Fig");
				categoryDropDown.addItem("Mushrooms");
								
				categoryDropDown.setEditable(false);
				categoryDropDown.setBounds(1, 1, 534, 40);
				categoryDropDown.setFont(new Font("Arial", Font.PLAIN, 18));
				categoryDropDown.setBackground(new Color(189, 136, 138));
				categoryDropDown.setForeground(Color.WHITE);
				display_two.add(categoryDropDown);
				categoryDropDown.addActionListener(new ButtonListner());				
				validate();
				

				Add.cat(display_one);
				
				catProceed = new JButton("Proceed");
				catProceed.setFont(new Font("Arial", Font.PLAIN , 18));
				catProceed.setBounds(1, 636, 534, 40);				
				catProceed.setBorder(null);							
				catProceed.setForeground(Color.WHITE);				
				catProceed.setBackground(new Color(189, 136, 138));	
				catProceed.setFocusPainted(false);					
				display_one.add(catProceed);
				catProceed.addActionListener(new ButtonListner());
				
				
				display_one.repaint();
				display_two.repaint();
			}
			if(e.getSource() == catProceed){
				
				//------------------------------------------------
				
				if(categoryDropDown.getSelectedIndex() == 1){
					categoryValue = "Apples";
				}
				if(categoryDropDown.getSelectedIndex() == 2){
					categoryValue = "Citrus";
				}
				if(categoryDropDown.getSelectedIndex() == 3){
					categoryValue = "Kiwi";
				}
				if(categoryDropDown.getSelectedIndex() == 4){
					categoryValue = "Avocados";
				}
				if(categoryDropDown.getSelectedIndex() == 5){
					categoryValue = "Bananas";
				}
				if(categoryDropDown.getSelectedIndex() == 6){
					categoryValue = "StoneFruit";
				}
				if(categoryDropDown.getSelectedIndex() == 7){
					categoryValue = "Grapes";
				}
				if(categoryDropDown.getSelectedIndex() == 8){
					categoryValue = "Pears";
				}
				if(categoryDropDown.getSelectedIndex() == 9){
					categoryValue = "Pineapple";
				}
				if(categoryDropDown.getSelectedIndex() == 10){
					categoryValue = "Melons";
				}
				if(categoryDropDown.getSelectedIndex() == 11){
					categoryValue = "Carrots";
				}
				if(categoryDropDown.getSelectedIndex() == 12){
					categoryValue = "Oniens";
				}
				if(categoryDropDown.getSelectedIndex() == 13){
					categoryValue = "Pebers";
				}
				if(categoryDropDown.getSelectedIndex() == 14){
					categoryValue = "Kale";
				}
				if(categoryDropDown.getSelectedIndex() == 15){
					categoryValue = "Corn";
				}
				if(categoryDropDown.getSelectedIndex() == 16){
					categoryValue = "Peas";
				}
				if(categoryDropDown.getSelectedIndex() == 17){
					categoryValue = "PupkindFamilie";
				}
				if(categoryDropDown.getSelectedIndex() == 18){
					categoryValue = "Salats";
				}
				if(categoryDropDown.getSelectedIndex() == 19){
					categoryValue = "Baries";
				}
				if(categoryDropDown.getSelectedIndex() == 20){
					categoryValue = "Spices";
				}
				if(categoryDropDown.getSelectedIndex() == 21){
					categoryValue = "Roots";
				}
				if(categoryDropDown.getSelectedIndex() == 22){
					categoryValue = "Organic";
				}
				if(categoryDropDown.getSelectedIndex() == 23){
					categoryValue = "SpecialFruits";
				}
				if(categoryDropDown.getSelectedIndex() == 24){
					categoryValue = "SpecialVegetables";
				}
				if(categoryDropDown.getSelectedIndex() == 25){
					categoryValue = "Tomatoes";
				}
				if(categoryDropDown.getSelectedIndex() == 26){
					categoryValue = "Potatoes";
				}
				if(categoryDropDown.getSelectedIndex() == 27){
					categoryValue = "Date";
				}
				if(categoryDropDown.getSelectedIndex() == 28){
					categoryValue = "Fig";
				}
				if(categoryDropDown.getSelectedIndex() == 29){
					categoryValue = "Mushrooms";
				}
				
				//----------------------------------------------
				
				
				
				Add.form(display_one, display_two);
				//---
				nameField = new JTextField();
				nameField.setBounds(1, 41, 534, 40);
				display_one.add(nameField);
				nameField.addActionListener(new ButtonListner());
				//---
				historyField = new JTextField();
				historyField.setBounds(1, 200, 534, 40);
				display_one.add(historyField);
				historyField.addActionListener(new ButtonListner());
				//---
				tasteField = new JTextField();
				tasteField.setBounds(1, 359, 534, 40);
				display_one.add(tasteField);
				tasteField.addActionListener(new ButtonListner());
				//---
				cookingTimeField = new JTextField();
				cookingTimeField.setBounds(1, 518, 534, 40);
				display_one.add(cookingTimeField);
				cookingTimeField.addActionListener(new ButtonListner());
				//---
				growingStartField = new JTextField();
				growingStartField.setBounds(1, 41, 264, 40);
				display_two.add(growingStartField);
				growingStartField.addActionListener(new ButtonListner());
				//---
				growingEndField = new JTextField();
				growingEndField.setBounds(269, 41, 264, 40);
				display_two.add(growingEndField);
				growingEndField.addActionListener(new ButtonListner());
				//---
				secondNameField = new JTextField();
				secondNameField.setBounds(1, 200, 534, 40);
				display_two.add(secondNameField);
				secondNameField.addActionListener(new ButtonListner());
				//---
				originsField = new JTextField();
				originsField.setBounds(1, 359, 534, 40);
				display_two.add(originsField);
				originsField.addActionListener(new ButtonListner());
				//---
				countryCodeField = new JTextField();
				countryCodeField.setBounds(1, 518, 534, 40);
				display_two.add(countryCodeField);
				countryCodeField.addActionListener(new ButtonListner());
				//---
				cancelButtonAdd = new JButton("Cancel");
				cancelButtonAdd.setFont(new Font("Arial", Font.PLAIN , 18));
				cancelButtonAdd.setBounds(1, 636, 534, 40);				
				cancelButtonAdd.setBorder(null);							
				cancelButtonAdd.setForeground(Color.WHITE);				
				cancelButtonAdd.setBackground(new Color(189, 136, 138));	
				cancelButtonAdd.setFocusPainted(false);					
				display_one.add(cancelButtonAdd);
				cancelButtonAdd.addActionListener(new ButtonListner());
				
//				if(buffer.equals("add")){
				proceedButtonAdd = new JButton("Proceed");
				proceedButtonAdd.setFont(new Font("Arial", Font.PLAIN , 18));
				proceedButtonAdd.setBounds(1, 636, 534, 40);				
				proceedButtonAdd.setBorder(null);							
				proceedButtonAdd.setForeground(Color.WHITE);				
				proceedButtonAdd.setBackground(new Color(189, 136, 138));	
				proceedButtonAdd.setFocusPainted(false);					
				display_two.add(proceedButtonAdd);
				proceedButtonAdd.addActionListener(new ButtonListner());
//				}
			}
			
			if(e.getSource() == cancelButtonAdd){
				display_one.removeAll();
				display_one.repaint();
				display_two.removeAll();
				display_two.repaint();
			}
			if(e.getSource() == proceedButtonAdd || e.getSource() == proceedButtonUpdate){
				nameFieldValue = nameField.getText();
				historyFieldValue = historyField.getText();
				tasteFieldValue = tasteField.getText();
				cookingTimeFieldValue = cookingTimeField.getText();
				growingStartFieldValue = growingStartField.getText();
				growingEndFieldValue = growingEndField.getText();
				secondNameFieldValue = secondNameField.getText();
				originsFieldValue = originsField.getText();
				countryCodeFieldValue = countryCodeField.getText();
				
				if(e.getSource() == proceedButtonAdd){
				str = "Add" + "/" + categoryValue + "/" + nameFieldValue + "/"
						+ historyFieldValue + "/"
						+ tasteFieldValue + "/"
						+ cookingTimeFieldValue + "/"
						+ growingStartFieldValue  + "/"
						+ growingEndFieldValue + "/"
						+ secondNameFieldValue + "/"
						+ originsFieldValue + "/"
						+ countryCodeFieldValue;
				}
				if(e.getSource() == proceedButtonUpdate){
					str = "Update" + "/" + nameUpdateValue + "/" + nameFieldValue + "/"
							+ historyFieldValue + "/"
							+ tasteFieldValue + "/"
							+ cookingTimeFieldValue + "/"
							+ growingStartFieldValue  + "/"
							+ growingEndFieldValue + "/"
							+ secondNameFieldValue + "/"
							+ originsFieldValue + "/"
							+ countryCodeFieldValue;
				}

				try {
					control = new ClientController(str);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				display_one.removeAll();
				display_two.removeAll();
				display_two.repaint();
				
				
				Add.addDisp(display_one, control.returned());
			}
		}
	}

	public SuperUserGUI() {
		super("Food Comparison System");
		setSize(1366, 768);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(83, 63, 64));

		menu = new JPanel();
		menu.setBounds(0, 0, 255, 768);
		menu.setBorder(new EmptyBorder(10, 10, 10, 10));
		menu.setLayout(null);
		menu.setBackground(new Color(83, 63, 64));
		getContentPane().add(menu);

		searchButton = new JButton("Search");
		searchButton.setFont(new Font("Arial", Font.PLAIN, 18));// font
		searchButton.setBounds(15, 11, 230, 40); // size
		searchButton.setBorder(null); // no borders
		searchButton.setForeground(Color.WHITE); // font color
		searchButton.setBackground(new Color(189, 136, 138)); // background
																// color
		searchButton.setFocusPainted(false); // so the writing would NOT be in a
												// square
		menu.add(searchButton);
		searchButton.addActionListener(new ButtonListner());

		compareButton = new JButton("Compare");
		compareButton.setFont(new Font("Arial", Font.PLAIN, 18));
		compareButton.setBounds(15, 170, 230, 40);
		compareButton.setBorder(null);
		compareButton.setForeground(Color.WHITE);
		compareButton.setBackground(new Color(189, 136, 138));
		compareButton.setFocusPainted(false);
		menu.add(compareButton);
		compareButton.addActionListener(new ButtonListner());

		updateButton = new JButton("Update");
		updateButton.setFont(new Font("Arial", Font.PLAIN, 18));
		updateButton.setBounds(15, 329, 230, 40);
		updateButton.setBorder(null);
		updateButton.setForeground(Color.WHITE);
		updateButton.setBackground(new Color(189, 136, 138));
		updateButton.setFocusPainted(false);
		menu.add(updateButton);
		updateButton.addActionListener(new ButtonListner());

		removeButton = new JButton("Remove");
		removeButton.setFont(new Font("Arial", Font.PLAIN, 18));
		removeButton.setBounds(15, 488, 230, 40);
		removeButton.setBorder(null);
		removeButton.setForeground(Color.WHITE);
		removeButton.setBackground(new Color(189, 136, 138));
		removeButton.setFocusPainted(false);
		menu.add(removeButton);
		removeButton.addActionListener(new ButtonListner());

		addButton = new JButton("Add");
		addButton.setFont(new Font("Arial", Font.PLAIN, 18));
		addButton.setBounds(15, 648, 230, 40);
		addButton.setBorder(null);
		addButton.setForeground(Color.WHITE);
		addButton.setBackground(new Color(189, 136, 138));
		addButton.setFocusPainted(false);
		menu.add(addButton);
		addButton.addActionListener(new ButtonListner());

		/** Displays **/
		display_one = new JPanel();
		display_two = new JPanel();

		display_one.setBounds(265, 11, 536, 677);
		display_two.setBounds(803, 11, 536, 677);

		display_one.setBackground(new Color(230, 198, 200));
		display_two.setBackground(new Color(230, 198, 200));

		getContentPane().add(display_one);
		getContentPane().add(display_two);

		/** Menu bar **/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.setBackground(new Color(83, 63, 64));
		this.setJMenuBar(menuBar);

		/** Menu bar items **/
		// menus
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		// font
		file.setFont(new Font("Arial", Font.PLAIN, 12));
		edit.setFont(new Font("Arial", Font.PLAIN, 12));
		help.setFont(new Font("Arial", Font.PLAIN, 12));
		// color of the font
		file.setForeground(Color.WHITE);
		edit.setForeground(Color.WHITE);
		help.setForeground(Color.WHITE);
		// add to the menu bar
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);

		/** inside the menu bar **/
		class CloseListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"You are about to leave the program");
				SuperUserGUI.this.dispose();
			}
		}
		JMenuItem close = file.add("Close");
		close.setFont(new Font("Arial", Font.PLAIN, 12));
		close.setForeground(Color.WHITE);
		close.setBackground(new Color(189, 136, 138));
		close.addActionListener(new CloseListener());

	}
}

