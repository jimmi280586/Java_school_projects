package chat.domain.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chat.controller.ServerController;

public class ServerView extends JFrame implements ActionListener, Observer
{
	private JTextField textFieldInput;
	   private JTextArea textAreaOutput;
	   private JButton buttonSend;
	   private JButton buttonQuit;
	   private ServerController controller;

	   public ServerView()
	   {
	      super("Chat Application - Server");

	      initialize();
	      addComponentsToFrame();
	   }

	   public void start(ServerController controller)
	   {
	      this.controller = controller;
	      buttonSend.addActionListener(this);
	      buttonQuit.addActionListener(this);
	      textFieldInput.addActionListener(this);
	      setVisible(true);
	   }

	   public String getAndRemoveInput()
	   {
	      String txt = textFieldInput.getText().trim();
	      textFieldInput.setText("");
	      return txt;
	   }

	   private void initialize()
	   {
	      textFieldInput = new JTextField();
	      textAreaOutput = new JTextArea();
	      textAreaOutput.setEditable(false);
	      textAreaOutput.setBackground(Color.GREEN);
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
	   // ActionListener
	   public void actionPerformed(ActionEvent e)
	   {
	      if (e.getSource() instanceof JTextField)
	      {
	         controller.execute("Send");
	      }
	      else
	      {
	         controller.execute(e.getActionCommand());
	      }
	   }

	   @Override
	   // Observer
	   public void update(Observable arg0, Object arg1)
	   {
	      if (arg1 == null || arg1.toString().length() < 1)
	      {
	         return;
	      }
	      String old = textAreaOutput.getText();
	      if (old.length() > 1)
	         old += "\n";
	      textAreaOutput.setText(old + arg1);
	   }
}
