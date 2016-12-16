package chat.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import chat.controller.ChatController;

public class ChatGUIHandler implements ActionListener
{
  private ChatController controller;

  public ChatGUIHandler(ChatController controller, ChatGUI gui)
  {
    this.controller = controller;
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    String what = e.getActionCommand();
    controller.execute(what);
  }
}