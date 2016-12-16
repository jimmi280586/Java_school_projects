import chat.controller.ChatController;
import chat.domain.mediator.ChatModelManager;
import chat.view.ChatGUI;
import chat.view.ChatView;

public class Main {
  public static void main(String args[]) {
    try {
      ChatModelManager model = new ChatModelManager();
      ChatView view = new ChatGUI();
      ChatController controller = new ChatController(model, view);

      view.start(controller);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
