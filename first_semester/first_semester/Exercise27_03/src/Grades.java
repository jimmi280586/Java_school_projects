import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class Grades extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JTextField text;
	private JButton button;
	private JTextField text1;
	private JButton button1;
	private JLabel label3;
	private JLabel label4;
	
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			label2.setText(celsius());
			
		}
		
		
	}
	
	private class ButtonListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			label4.setText(fahren());
			
		}
		
		
	}
	
	
	
	public Grades() {
		super("Flow layout");
		setLayout(new FlowLayout()); //Ugly, but works.
		label1 = new JLabel("Centigrade");
		label2 = new JLabel("result");
		text = new JTextField("imput Centigrade here");
		button = new JButton("convert to Fahrenheit");
		button.addActionListener(new ButtonListener());
		add(label1);
		add(text);
		add(button);
		add(label2);
		pack();
		setLayout(new FlowLayout()); //Ugly, but works.
		label3 = new JLabel("Fahrenheit");
		label4 = new JLabel("result");
		text1 = new JTextField("imput Fahrenheit here");
		button1 = new JButton("convert to Centigrade");
		button1.addActionListener(new ButtonListener1());
		add(label3);
		add(text1);
		add(button1);
		add(label4);
		pack();
		
		
		setDefaultCloseOperation(
		EXIT_ON_CLOSE);
	
	}
	public double calculat()
	{
			 double cel = (new Double(text1.getText())).doubleValue();
			 return cel;
				
	}
	
	public double fahrenheit()
	{
			double fah = (new Double(text1.getText())).doubleValue();
			return fah;
	}
	
	public String celsius()
	{
		double cel1 = ((calculat() * 9) / 5) + 32;
		return Double.toString(cel1);
	}
	
	public String fahren()
	{
		
		double fah1 = (((fahrenheit()-32) * 5) / 9);
		return Double.toString(fah1);
	}
}
