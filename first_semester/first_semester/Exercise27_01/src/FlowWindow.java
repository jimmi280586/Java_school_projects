import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FlowWindow extends JFrame
{	
	
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JTextField text;
	private JButton button;
	
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			label2.setText("Button pressed");
		}
		
		
	}
	
	public FlowWindow() {
		super("Flow layout");
		setLayout(new FlowLayout()); //Ugly, but works.
		label1 = new JLabel("This is a label");
		label2 = new JLabel("And another JLabel");
		text = new JTextField("Next is a textbox");
		button = new JButton("A JButton");
		button.addActionListener(new ButtonListener());
		add(label1);
		add(text);
		add(button);
		add(label2);
		pack();
		}
		
}
