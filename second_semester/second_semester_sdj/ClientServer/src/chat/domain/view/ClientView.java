package chat.domain.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.mediator.ClientController;
import chat.domain.model.AbstractMessage;

public class ClientView extends JFrame implements ActionListener, Observer
{
	private JTextField textFieldInput;
	   private JTextArea textAreaOutput;
	   private JButton buttonSend;
	   private JButton buttonQuit;
	   private ClientController controller;

	   public ClientView()
	   {
	      super("Client View");

	      initialize();
	      addComponentsToFrame();
	   }

	   public void start(ClientController controller)
	   {
	      this.controller = controller;
	      buttonSend.addActionListener(this);
	      buttonQuit.addActionListener(this);
	      textFieldInput.addActionListener(this);
	      setVisible(true);
	   }

	   public String getAndRemoveInput()
	   {
	      String txt = textFieldInput.getText();
	      textFieldInput.setText("");
	      return txt;
	   }
	   public String getNickName()
	   {
	      return JOptionPane.showInputDialog("Nickname?");
	   }

	   private void initialize()
	   {
	      textFieldInput = new JTextField();
	      textAreaOutput = new JTextArea();
	      textAreaOutput.setEditable(false);
	      textAreaOutput.setBackground(Color.LIGHT_GRAY);
	      buttonSend = new JButton("Send");
	      buttonQuit = new JButton("Quit");
	      setSize(400, 500); // set frame size
	      setLocationRelativeTo(null); // center of the screen
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }

	   private void addComponentsToFrame()
	   {
	      JPanel panelButtons = new JPanel();
	      panelButtons.add(buttonSend);
	      panelButtons.add(buttonQuit);

	      JPanel panel1 = new JPanel(new BorderLayout());
	      panel1.add(textFieldInput, BorderLayout.CENTER);
	      panel1.add(panelButtons, BorderLayout.EAST);

	      JScrollPane scrollPane = new JScrollPane(textAreaOutput);

	      JPanel contentPane = new JPanel(new BorderLayout());
	      contentPane.add(panel1, BorderLayout.NORTH);
	      contentPane.add(scrollPane, BorderLayout.CENTER);

	      setContentPane(contentPane);
	   }

	   @Override
	   public void actionPerformed(ActionEvent e)
	   {
	      if ((e.getSource() instanceof JTextField))
	      {
	         try
			{
				controller.execute("Send");
			} catch (TransformerException | ParserConfigurationException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }
	      else
	      {
	         try
			{
				controller.execute(((JButton) (e.getSource())).getText());
			} catch (TransformerException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParserConfigurationException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }
	   }

	   @Override
	   public void update(Observable o, Object arg)
	   {
	      String old = textAreaOutput.getText();
	      if (old.length() > 1)
	         old = "\n" + old;
	      AbstractMessage msg = (AbstractMessage) arg;
	      textAreaOutput.setText(msg.getFrom() + " >" + msg.getBody() + old);
	      textAreaOutput.setCaretPosition(0);
	   }
}
