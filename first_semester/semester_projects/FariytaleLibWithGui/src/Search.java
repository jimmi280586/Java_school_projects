



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



public class Search extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel contentPane;
	private JTextField textField;
	private AbstractButton txtrTextArea;
	private Item item;
	private Customer customers;
	JButton btnSearch;
	JTextArea textArea;
	private Customer customerfinal;
	
	
	
	
	public Search() throws IOException
	{
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout());

		ButtonGroup groupButtons = new ButtonGroup();
		
		groupButtons = new ButtonGroup();
		
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
						
						btnSearch = new JButton("Search");
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
												
												JButton btnPayFine = new JButton("Pay fine");
												panel_1.add(btnPayFine);
												
												JButton btnconfirm = new JButton("Confirm");
												panel_1.add(btnconfirm);
																								
												JPanel panel_2 = new JPanel();
												contentPane.add(panel_2, BorderLayout.EAST);
												panel_2.setLayout(new BorderLayout(0, 0));
												
												JPanel panel_3 = new JPanel();
												contentPane.add(panel_3, BorderLayout.CENTER);
												
												JPanel panel_4 = new JPanel();
												panel_4.setLayout(new BorderLayout());
												panel_3.add(panel_4);
												
												textArea = new JTextArea();
												textArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "System Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
												textArea.setPreferredSize(new Dimension(200, 70));
												panel_4.add(textArea, BorderLayout.NORTH);
												textArea.setEditable(false);
												
												JPanel panel_5 = new JPanel();
												panel_5.setSize(200, 10);
												panel_4.add(panel_5, BorderLayout.CENTER);
												
												JPanel panel_6 = new JPanel();
												panel_6.setSize(200, 10);
												
												contentPane.add(panel_6, BorderLayout.EAST);
												
												JTextArea txtrTextArea = new JTextArea();
												panel_4.add(txtrTextArea, BorderLayout.SOUTH);
												txtrTextArea.setPreferredSize(new Dimension(200, 140));
												txtrTextArea.setEditable(false);
												txtrTextArea.setText("");
												txtrTextArea.setColumns(30);
												txtrTextArea.setLineWrap(true);
												btnPayFine.setVisible(true);
												btnconfirm.setVisible(true);
												
												
												
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
																if(item == null)
																{
																	textArea.setText("no item found");
																}
															} catch (IOException e1) {
																textArea.setText("no item found");
																e1.printStackTrace();
															}
															
															txtrTextArea.setText(item.toString());
															}
														}
														
													}
												});
												
												btnconfirm.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent e) 
													{
														customerfinal = customers;
														
													}
												});
												
												btnPayFine.addActionListener(new ActionListener() {
													
													@Override
													public void actionPerformed(ActionEvent e) 
													{
														
														
														LibraryMaster library = null;
														try {
															library = new LibraryMaster();
																											
														} catch (IOException e1) {
															
															e1.printStackTrace();
														}
														
														if (e.getSource() == btnPayFine)
														{
															try {
																																
																library.payedFine(customerfinal);
																
															} catch (IOException e1) {
																
																e1.printStackTrace();
															}
															
															for (int i = 0; i <library.customers.getNumberOfCustomer(); i++) 
															{
																txtrTextArea.setText(library.customers.getCustomer(i).toString());
															}
														}
														txtrTextArea.setText("");					
													}
												});
												
									
												
												setSize(800, 400);										
		add(contentPane);	
	}
	


}
