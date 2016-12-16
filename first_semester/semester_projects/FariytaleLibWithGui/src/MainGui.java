
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class MainGui extends JFrame
{
   
    private JPanel contentPane;
   
	public MainGui() throws IOException //MyDate date) throws HeadlessException 
	{
		super("Main Menu");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMainLibrary = new JLabel("MAIN LIBRARY");
		panel.add(lblMainLibrary);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(120, 200));
		panel_1.setPreferredSize(new Dimension(120, 200));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("ADD");
		panel_1.add(btnAdd);
		
		JButton btnSearch = new JButton("SEARCH");
		panel_1.add(btnSearch);
		
		JButton btnLendOut = new JButton("LEND OUT");
		panel_1.add(btnLendOut);
		
		JButton btnReserve = new JButton("RESERVE");
		panel_1.add(btnReserve);
		
		JButton btnReturn = new JButton("RETURN");
		panel_1.add(btnReturn);
		panel_1.setLayout(new GridLayout(5, 1, 20, 20));
		panel_1.setBorder(BorderFactory.createTitledBorder("Chose What to Add"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(new BorderLayout());
		
		JPanel panel_2 = new AddGui1();
		JPanel panel_3 = new Search();
		JPanel panel_5 = new Return();
		JPanel panel_6 = new LendOutGui();
		JPanel panel_7 = new ReserveGui();
		
		
		panel_4.add(panel_2, BorderLayout.CENTER);
		panel_4.add(panel_3, BorderLayout.CENTER);
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_4.add(panel_7, BorderLayout.CENTER);
		
		
		
		
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(panel_1, BorderLayout.WEST);
		contentPane.add(panel_4, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setSize(100, 100);
		panel_8.add(textArea, BorderLayout.CENTER);
		
		JLabel lblSystemInformation = new JLabel("System information");
		lblSystemInformation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblSystemInformation, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BorderLayout());
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(btnCancel, BorderLayout.EAST);
	
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_5.setVisible(false);
		panel_6.setVisible(false);
		panel_7.setVisible(false);
		panel_8.setVisible(true);
		panel_9.setVisible(true);
		textArea.setText("Welcome to our Awesome library! Here you can add customers and items in the system");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				contentPane.add(panel, BorderLayout.NORTH);
				contentPane.add(panel_1, BorderLayout.WEST);
				contentPane.add(panel_4, BorderLayout.CENTER);
				lblMainLibrary.setText("ADD MENU");
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_1.setVisible(true);
				panel.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(true);
				
				
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				contentPane.add(panel, BorderLayout.NORTH);
				contentPane.add(panel_1, BorderLayout.WEST);
				contentPane.add(panel_4, BorderLayout.CENTER);
				lblMainLibrary.setText("SEARCH MENU");
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_1.setVisible(true);
				panel.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(true);
				
					
			}
		});
		
		btnLendOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				contentPane.add(panel, BorderLayout.NORTH);
				contentPane.add(panel_1, BorderLayout.WEST);
				contentPane.add(panel_4, BorderLayout.CENTER);
				lblMainLibrary.setText("LEND OUT MENU");
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_1.setVisible(true);
				panel.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(true);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(true);
				
					
			}
		});

		btnReserve.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(panel_1, BorderLayout.WEST);
		contentPane.add(panel_4, BorderLayout.CENTER);
		lblMainLibrary.setText("RESERVE MENU");
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_1.setVisible(true);
		panel.setVisible(true);
		panel_5.setVisible(false);
		panel_6.setVisible(false);
		panel_7.setVisible(true);
		panel_8.setVisible(false);
		panel_9.setVisible(true);
		
			
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				contentPane.add(panel, BorderLayout.NORTH);
				contentPane.add(panel_1, BorderLayout.WEST);
				contentPane.add(panel_4, BorderLayout.CENTER);
				lblMainLibrary.setText("RETURN MENU");
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_1.setVisible(true);
				panel.setVisible(true);
				panel_5.setVisible(true);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(false);
				panel_9.setVisible(true);
					
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				contentPane.add(panel, BorderLayout.NORTH);
				contentPane.add(panel_1, BorderLayout.WEST);
				contentPane.add(panel_4, BorderLayout.CENTER);
				lblMainLibrary.setText("MAIN LIBRARY");
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_7.setVisible(false);
				panel_8.setVisible(true);
				panel_9.setVisible(true);
				
				
			}
		});
		
		setSize(800, 500);
	}
}
