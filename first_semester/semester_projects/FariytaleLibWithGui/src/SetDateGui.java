


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class SetDateGui extends JFrame
{
	private JPanel contentPane;
	private JTextField textField_day;
	private JTextField textField_month;
	private JTextField textField_year;
	private MyDate date;

	
	public SetDateGui() throws IOException
	
	{
		LibraryMaster library = new LibraryMaster();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblInputCurrentDate = new JLabel("INPUT CURRENT DATE");
		lblInputCurrentDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblInputCurrentDate);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCurrentDay = new JLabel("CURRENT DAY");
		panel_1.add(lblCurrentDay);
		
		textField_day = new JTextField();
		panel_1.add(textField_day);
		textField_day.setColumns(10);
		
		JLabel lblCurrentMonth = new JLabel("CURRENT MONTH");
		panel_1.add(lblCurrentMonth);
		
		textField_month = new JTextField();
		panel_1.add(textField_month);
		textField_month.setColumns(10);
		
		JLabel lblCurrentYear = new JLabel("CURRENT YEAR");
		panel_1.add(lblCurrentYear);
		
		textField_year = new JTextField();
		panel_1.add(textField_year);
		textField_year.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("OK");
		panel_2.add(btnNewButton);
		
		setSize(200, 150);
		setResizable(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int day = Integer.parseInt(textField_day.getText());
				int month = Integer.parseInt(textField_month.getText());
				int year = Integer.parseInt(textField_year.getText());
				date = new MyDate(day, month, year);
				
				try {
					library.setDate(day, month, year);
				} catch (IOException e2) {
					
					e2.printStackTrace();
				}
				
				MainGui main = null;
				try {
					main = new MainGui();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			
				main.setVisible(true);
				dispose();
			
			}
		});

		
	}



	public MyDate getDate()
	{
		return this.date;
	}
	
	
}
