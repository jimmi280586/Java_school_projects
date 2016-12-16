import java.awt.*;

import javax.swing.*;


public class Form extends JFrame
{
	 private static final long serialVersionUID = 1L;
	// Declare window elements
	private JPanel formsPanel;
	private JPanel buttonsPanel;
	private JPanel buttonsPanelContainer;
	public Form()
	{
	super("Enter name and address");
	// Set to a border layout
	setLayout(new BorderLayout());
	// Initialize the forms panel
	formsPanel = new JPanel();
	// Give it a Grid Layout
	formsPanel.setLayout(new GridLayout(7,1));
	// Add labels and fields
	formsPanel.add(new JLabel("First name:"));
	formsPanel.add(new JTextField());
	formsPanel.add(new JLabel("Last name:"));
	formsPanel.add(new JTextField());
	formsPanel.add(new JLabel("Address:"));
	formsPanel.add(new JTextField());
	formsPanel.add(new JTextField());
	// Initialize the buttons panel
	buttonsPanel = new JPanel();
	// Give it a Grid Layout
	buttonsPanel.setLayout(new GridLayout(3,1));
	// Add buttons
	buttonsPanel.add(new JButton("OK"));
	buttonsPanel.add(new JButton("Cancel"));
	buttonsPanel.add(new JButton("Help"));
	// Initialize the container for the buttons panel
	buttonsPanelContainer = new JPanel();
	// Give it a Flow Layout
	buttonsPanelContainer.setLayout(new FlowLayout());
	// Add the buttons panel
	buttonsPanelContainer.add(buttonsPanel);
	// Add the forms panel to the center
	add(formsPanel, BorderLayout.CENTER);
	// Add the buttons panel to the east
	add(buttonsPanelContainer, BorderLayout.EAST);
	// Pack
	pack();
	}
	public static void main(String[] args)
	{
	// Set up and show the window
	JFrame frame = new Form();
	frame.setVisible(true);
	}
}
