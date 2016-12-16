package chat.view;

import java.util.Observer;

import chat.controller.ChatController;

public interface ChatView extends Observer {
  void start(ChatController controller);

  void show(String message);

  String getMessage();
}
