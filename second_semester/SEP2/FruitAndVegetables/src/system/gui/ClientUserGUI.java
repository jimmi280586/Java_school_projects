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
import src.system.gui.SuperUserGUI.ButtonListner;
import src.system.gui.result.Compare;
import src.system.gui.result.Search;

public class ClientUserGUI extends JFrame{
	
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
				Compare.compareResult(display_two, control.returned());
			}
		}
	}

	public ClientUserGUI() {
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
				ClientUserGUI.this.dispose();
			}
		}
		JMenuItem close = file.add("Close");
		close.setFont(new Font("Arial", Font.PLAIN, 12));
		close.setForeground(Color.WHITE);
		close.setBackground(new Color(189, 136, 138));
		close.addActionListener(new CloseListener());

	}
}
