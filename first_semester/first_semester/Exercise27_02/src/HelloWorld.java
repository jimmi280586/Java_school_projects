import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class HelloWorld extends JFrame
{
	
	
	
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JLabel label1;
	
	public class ButtonListener	implements ActionListener
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		label1.setText("Hello World");
	}
	}
	
	public HelloWorld() 
	{
		super("Second Window");
		setLayout(new FlowLayout());
		label1 = new JLabel("press the button");
				
		button = new JButton("Press Me");
		button.addActionListener(new ButtonListener());
		add(label1);
		
		add(button);
		
		pack();
		
		setSize(800, 600);
		setDefaultCloseOperation(
		EXIT_ON_CLOSE);
		}
	
	
}
