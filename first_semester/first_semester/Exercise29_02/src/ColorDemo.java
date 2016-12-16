import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ColorDemo extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public ColorDemo()
	{
		super("colorDemo");
				
		// add buttons
		JRadioButton radio1 = new JRadioButton("Blue");
		JRadioButton radio2 = new JRadioButton("Green");
		JRadioButton radio3 = new JRadioButton("Red");
		JRadioButton radio4 = new JRadioButton("Black");
		JRadioButton radio5 = new JRadioButton("Blue");
		JRadioButton radio6 = new JRadioButton("Green");
		JRadioButton radio7 = new JRadioButton("Red");
		JRadioButton radio8 = new JRadioButton("Black");
		
		//add textfield
		JTextField text = new JTextField("text");
		//sets background color to white
		text.setBackground(Color.WHITE);
		// sets forgroun(text color) to black
		text.setForeground(Color.BLACK);
		
		//add master jpanel
		JPanel buttonsPanelContainer = new JPanel();
		//set panel to gridlayout
		buttonsPanelContainer.setLayout(new GridLayout());
		
		//makes a jpanel
		JPanel panel1 = new JPanel(new GridLayout());
				
		//makes a jpanel
		JPanel panel = new JPanel(new GridLayout());
		
		//sets the layout of the program to borderlayout
		setLayout(new BorderLayout());
		
		//listens to when a button is selected		
		 class RadioButtonListener implements ActionListener
		{
			 // what action the program do when button i selected
			public void actionPerformed(ActionEvent e)
			{
				
				//this say that if radio1(blue button) is selected make the
				// background color blue and so on
				if(radio1.isSelected())
				{
					text.setBackground(Color.BLUE);
				}
				if(radio2.isSelected())
				{
					text.setBackground(Color.GREEN);
				}
				if(radio3.isSelected())
				{
					text.setBackground(Color.RED);
				}
				if(radio4.isSelected())
				{
					text.setBackground(Color.BLACK);
				}
				
				//this say that if radio5(blue button) is selected make the
				// text color blue and so on				
				if(radio5.isSelected())
				{
					text.setForeground(Color.BLUE);
				}
				if(radio6.isSelected())
				{
					text.setForeground(Color.GREEN);
				}
				if(radio7.isSelected())
				{
					text.setForeground(Color.RED);
				}
				if(radio8.isSelected())
				{
					text.setForeground(Color.BLACK);					
				}

			}
		}
		
		// groups buttons to group 1 together
		ButtonGroup group1 = new ButtonGroup();
		// buttons in group1
		group1.add(radio1);
		group1.add(radio2);
		group1.add(radio3);
		group1.add(radio4);
		
		// add buttons to group 2 together
		ButtonGroup group2 = new ButtonGroup();
		// buttons in group2
		group2.add(radio5);
		group2.add(radio6);
		group2.add(radio7);
		group2.add(radio8);
		
		//add action listener to all the buttons
		// and make the new button listener to them
		radio1.addActionListener(new RadioButtonListener());
		radio2.addActionListener(new RadioButtonListener());
		radio3.addActionListener(new RadioButtonListener());
		radio4.addActionListener(new RadioButtonListener());
		radio5.addActionListener(new RadioButtonListener());
		radio6.addActionListener(new RadioButtonListener());
		radio7.addActionListener(new RadioButtonListener());
		radio8.addActionListener(new RadioButtonListener());
		
		//sets layout to grid
		panel.setLayout(new GridLayout(5, 5, 5, 5));
		
		//makes an empty border around the jpanel
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 25));
		
		//add titel to empty border
		panel.setBorder(BorderFactory.createTitledBorder("Background"));
		
		// add buttons in jpanel even if they are groupt together
		panel.add(radio1);
		panel.add(radio2);
		panel.add(radio3);
		panel.add(radio4);
		
		//sets layout to grid
		panel1.setLayout(new GridLayout(5, 5, 5, 5));
		
		//makes an empty border around the jpanel
		panel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 25));
		
		//sets the jpanels preferredsize that the user can override by making
		//the window bigger ore smaller
		panel1.setPreferredSize(new Dimension(100, 50));
		
		//add titel to empty border
		panel1.setBorder(BorderFactory.createTitledBorder("foreground"));
		
		// add buttons in jpanel even if they are groupt together
		panel1.add(radio5);
		panel1.add(radio6);
		panel1.add(radio7);
		panel1.add(radio8);
		
		//add the jpanels to the master jpanel and set the layout using the compass notation		
		buttonsPanelContainer.add(panel, BorderLayout.EAST);
		buttonsPanelContainer.add(panel1, BorderLayout.CENTER);
		
		//add the text field to the master jpanel and set the layout
		buttonsPanelContainer.add(text, BorderLayout.WEST);
		
		//add the master jpanel to the jframe and implement the layout to CENTER
		add(buttonsPanelContainer, BorderLayout.CENTER);
			
		// closes the gui program
		pack();
	}

	// main method for the testing
	public static void main(String[] args)
	{
	// Set up and show the window
	JFrame frame = new ColorDemo();
	frame.setVisible(true);
	}

}
