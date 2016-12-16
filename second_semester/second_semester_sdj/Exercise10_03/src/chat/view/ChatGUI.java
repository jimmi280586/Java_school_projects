package chat.view;

import java.awt.*;
import java.util.Observable;

import javax.swing.*;

import chat.controller.ChatController;

public class ChatGUI extends JFrame implements ChatView {
  private JButton[] buttons;
  private JTextField textField;
  private JTextArea textArea;
  private ChatController controller;
  private ChatGUIHandler listener;

  public ChatGUI() {
    super("Chat");

    buttons = new JButton[5];
    createComponents();
    initializeComponents();
    addComponentsToFrame();
  }

  @Override
  public void start(ChatController controller) {
    this.controller = controller;
    this.listener = new ChatGUIHandler(this.controller, this);
    for (int i = 0; i < buttons.length; i++) {
      if (buttons[i] != null)
        buttons[i].addActionListener(listener);
    }
    this.textField.addActionListener(listener);
    setVisible(true);
  }

  @Override
  public void show(String message) {
    if (message.length() <= 0) {
      return;
    }
    String all = message + "\n" + getLines(20);
    textArea.setText(all);
    textField.setText("");
  }

  @Override
  public String getMessage() {
    String what = textField.getText();
    textField.setText("");
    return what;
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    this.show(arg1.toString());

  }

  private String getLines(int size) {
    String all = "";
    String[] split = textArea.getText().split("\n");
    size = Math.min(size, split.length);
    for (int i = 0; i < size; i++) {
      all += split[i];
      if (i < size - 1)
        all += "\n";
    }
    return all;
  }

  private void createComponents() {
    buttons[0] = new JButton("Send");
    buttons[1] = new JButton("Quit");
    textArea = new JTextArea();
    textArea.setEditable(false);
    textField = new JTextField();
  }

  private void initializeComponents() {
    setSize(700, 450); // set frame size
    setLocationRelativeTo(null); // center of the screen
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void addComponentsToFrame() {
    JPanel panelButtons = new JPanel();
    for (int i = 0; i < buttons.length; i++) {
      if (buttons[i] != null)
        panelButtons.add(buttons[i]);
    }
    JScrollPane scrollPane = new JScrollPane(textArea);

    add(scrollPane, BorderLayout.CENTER);
    add(panelButtons, BorderLayout.SOUTH);
    add(textField, BorderLayout.NORTH);
  }

}
