

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;



public class LendOutGui extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	
	private Item item;
	private Customer customers;
	private Item itemFinal;
	private Customer customerFinal;

	public LendOutGui() throws IOException
	{
		

		
		
		LibraryMaster library = new LibraryMaster();
		
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
					contentPane.setLayout(new BorderLayout(0, 0));

					ButtonGroup groupButtons = new ButtonGroup();
					
					groupButtons = new ButtonGroup();
					
					JPanel panel_3 = new JPanel();
					panel_3.setBounds(93, 107, 355, 75);
					contentPane.add(panel_3);
					panel_3.setLayout(new GridLayout(0, 1, 0, 0));
					
					JButton btnConfirmItem = new JButton("Confirm Item");
					panel_3.add(btnConfirmItem);
					
					JButton btnConfirmCustomer = new JButton("Confirm Customer");
					panel_3.add(btnConfirmCustomer);
					
					JButton btnLendOut = new JButton("Lend Out");
					panel_3.add(btnLendOut);
					
					JPanel panel = new JPanel();
					contentPane.add(panel, BorderLayout.NORTH);
							panel.setLayout(new GridLayout(0, 1, 0, 0));
					
							JPanel searchPanel = new JPanel();
							panel.add(searchPanel);
							FlowLayout flowLayout = (FlowLayout) searchPanel.getLayout();
							searchPanel.setBounds(93, 0, 355, 60);
							
									textField = new JTextField();
									searchPanel.add(textField);
									textField.setColumns(30);
									
									JButton btnSearch = new JButton("Search");
									searchPanel.add(btnSearch);
									
											JPanel radioPanel = new JPanel();
											panel.add(radioPanel);
											radioPanel.setBounds(93, 67, 355, 40);
											
													JRadioButton Itembutton = new JRadioButton("Item", true);
													radioPanel.add(Itembutton);
													
															JRadioButton customer = new JRadioButton("Customer");
															radioPanel.add(customer);
															groupButtons.add(Itembutton);
															groupButtons.add(customer);
															
															JPanel panel_1 = new JPanel();
															contentPane.add(panel_1, BorderLayout.SOUTH);
																													
															JPanel panel_2 = new JPanel();
															contentPane.add(panel_2, BorderLayout.EAST);
															panel_2.setLayout(new BorderLayout(0, 0));
															
															JTextArea txtrTextArea = new JTextArea();
															txtrTextArea.setPreferredSize(new Dimension(200, 100));
															panel_2.add(txtrTextArea);
															txtrTextArea.setEditable(false);
															txtrTextArea.setText("");
															txtrTextArea.setColumns(30);
															txtrTextArea.setLineWrap(true);
															txtrTextArea.setWrapStyleWord(true);
															
															JPanel panel_4 = new JPanel();
															panel_2.add(panel_4, BorderLayout.NORTH);
															
															JTextArea textArea = new JTextArea();
															textArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "System Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
															textArea.setPreferredSize(new Dimension(200, 70));
															panel_4.add(textArea);
															textArea.setLineWrap(true);
														    textArea.setWrapStyleWord(true);
														    textArea.setText("");
															textArea.setEditable(false);
															
															btnSearch.addActionListener(new ActionListener() {
																
																@Override
																public void actionPerformed(ActionEvent e)
																{
																	LibraryMaster library = null;
																	try {
																		library = new LibraryMaster();
																	} catch (IOException e1) {

																		textArea.setText("can not read file");

																		e1.printStackTrace();
																	}
																	
																	String searchfield = textField.getText();
																	
																	if (e.getSource() == btnSearch)
																	{
																		if(customer.isSelected() == true)
																		{
																			customers = library.searchCustomer(searchfield);
																			
																			txtrTextArea.setText(customers.toString());
																		}
																		
																		if (Itembutton.isSelected() == true)
																		{
																		try {
																			item = library.searchItem(searchfield);
																		} catch (IOException e1) {
																			
																			e1.printStackTrace();
																		}
																		txtrTextArea.setText(item.toString());
																		}
																	}
																	
																}
															});
															
														btnConfirmItem.addActionListener(new ActionListener() {
															
															@Override
															public void actionPerformed(ActionEvent e)
															{
																itemFinal = item;
																
															}
														});
														
														btnConfirmCustomer.addActionListener(new ActionListener() {
															
															@Override
															public void actionPerformed(ActionEvent e)
															{
																customerFinal = customers;
															
															}
														});
														
														btnLendOut.addActionListener(new ActionListener() {
															
															@Override
															public void actionPerformed(ActionEvent e)
															{
																LibraryMaster library = null;
																try {
																	library = new LibraryMaster();
																									
																	if (itemFinal.getStatus() == 1)
																	{
																		if(customerFinal.CustomerFine().startsWith(" $"))
																		{
																			textArea.setText("customer has a fine");
																		}
																		
																		library.LendOutItemToCustomer(itemFinal, customerFinal);
																		textArea.setText("item is lend out");
																		
																	}
																	if (itemFinal.getStatus() == 2)
																	{
																		textArea.setText("item is allready lend out but you can reserve it");
																	}
																	if(itemFinal.getStatus() == 3)
																	{
																		textArea.setText("item is allready reserved please come again");
																	}
																		for (int i = 0; i < library.lendOuts.getNumberOfLendOut(); i++)
																		{
																			txtrTextArea.setText(library.lendOuts.getLendOut(i).toString());
																		}
																	
																} catch (IOException e1) {

																	textArea.setText("unable to lend item out try again, if problem continue contact system suport");

																	e1.printStackTrace();
																}
																
															}
														});
															
															
														setSize(700, 400);										
					add(contentPane);										
	}
	


}
