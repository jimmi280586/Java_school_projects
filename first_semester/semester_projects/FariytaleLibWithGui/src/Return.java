

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



public class Return extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel contentPane;
	private JTextField textField;
	private Item item;
	
	
	public Return() throws IOException
	{
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout(0, 0));

		ButtonGroup groupButtons = new ButtonGroup();
		
		groupButtons = new ButtonGroup();
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(50, 20));
		panel_3.setBounds(93, 107, 355, 75);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnConfirmItem = new JButton("Confirm");
		btnConfirmItem.setSize(getMaximumSize());
		btnConfirmItem.setMinimumSize(new Dimension(80, 23));
		btnConfirmItem.setMaximumSize(new Dimension(100, 23));
		btnConfirmItem.setPreferredSize(new Dimension(80, 23));
		panel_3.add(btnConfirmItem);
		
		JButton btnReturn = new JButton("Return");
		panel_3.add(btnReturn);
				
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(10, 20));
		panel_3.add(panel_5);
		
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
												
												JPanel panel_1 = new JPanel();
												contentPane.add(panel_1, BorderLayout.SOUTH);
																							
												JPanel panel_2 = new JPanel();
												contentPane.add(panel_2, BorderLayout.EAST);
												panel_2.setLayout(new BorderLayout(0, 0));
												
												JTextArea txtrTextArea = new JTextArea();
												txtrTextArea.setPreferredSize(new Dimension(200, 140));
												panel_2.add(txtrTextArea);
												txtrTextArea.setEditable(false);
												txtrTextArea.setText("");
												txtrTextArea.setColumns(30);
												txtrTextArea.setLineWrap(true);
												
												JPanel panel_4 = new JPanel();
												panel_2.add(panel_4, BorderLayout.NORTH);
												
												JTextArea textArea = new JTextArea();
												textArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "System Information", 
														TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
												textArea.setPreferredSize(new Dimension(200, 70));
												panel_4.add(textArea);
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
																												
															try {
																item = library.searchItem(searchfield);
															} catch (IOException e2) {
																
																e2.printStackTrace();
															}
															txtrTextArea.setText(item.toString());
																												
														
																if(item.getStatus() == 2)
																{
																	try {
																		library.returnItemToLibrary(item);
																	} catch (IOException e1) {
																		textArea.setText("item was not returned try again, or contact system suport");
																		e1.printStackTrace();
																	}
																	textArea.setText("item is returned");
																}
																if (item.getStatus() == 3)
																{
																	textArea.setText("item is returned but reserved");
																}
																										
														}
														
													}
												});
												
												
												
												setSize(700, 400);										
		add(contentPane);	
	}

}
