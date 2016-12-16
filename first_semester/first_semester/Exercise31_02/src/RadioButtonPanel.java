import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class RadioButtonPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JRadioButton[] radioButtons;
	
	public RadioButtonPanel(String title, String[] captions)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		radioButtons = new JRadioButton[captions.length];
		ButtonGroup backgroundGroup = new ButtonGroup();
		
		for(int i = 0; i < radioButtons.length; i++)
		{
		radioButtons[i] = new JRadioButton(captions[i]);
		backgroundGroup.add(radioButtons[i]);
		radioButtons[i].setBorder(
		BorderFactory.createEmptyBorder(5, 5, 5, 25));
		add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);
		setBorder(BorderFactory.createTitledBorder(title));
	}
	
	public void addActionListener(int index,
			ActionListener listener)
			{
			radioButtons[index].addActionListener(listener);
			}
}
