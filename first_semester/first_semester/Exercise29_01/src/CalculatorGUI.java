import java.awt.*;
import javax.swing.*;

// * means call all the imports from that class object
public class CalculatorGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	public CalculatorGUI()
	{
		super("CalculatorGUI");
		// cals a new borderlayout if you change the cunstructor to 5, 5
		// it will give space of 5 pixel between the textfield and the button
		setLayout(new BorderLayout(5, 5));
		
		//adds a textfield and set it to the top
		add(new JTextField(), BorderLayout.NORTH); 
		
		//makes a new jpanel for the buttons
		// if you say 4, 4, 5, 5 in the gridlayout you get 5 pixel space between
		// the buttons but not on the outside
		JPanel centerPanel = new JPanel(new GridLayout(4, 4, 5, 5));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(8, 5, 5, 5));
		centerPanel.add(new JButton("7"));//buttons
		centerPanel.add(new JButton("8"));
		centerPanel.add(new JButton("9"));
		centerPanel.add(new JButton("/"));
		centerPanel.add(new JButton("4"));
		centerPanel.add(new JButton("5"));
		centerPanel.add(new JButton("6"));
		centerPanel.add(new JButton("*"));
		centerPanel.add(new JButton("1"));
		centerPanel.add(new JButton("2"));
		centerPanel.add(new JButton("3"));
		centerPanel.add(new JButton("-"));
		centerPanel.add(new JButton("0"));
		centerPanel.add(new JButton("."));
		centerPanel.add(new JButton("="));
		centerPanel.add(new JButton("+"));
		add(centerPanel);//adds the center panel
		pack();
	}
	
	
	
	
	
	
	

}
