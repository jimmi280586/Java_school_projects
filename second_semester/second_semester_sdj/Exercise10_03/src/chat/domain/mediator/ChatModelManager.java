package chat.domain.mediator;

import java.util.Observable;

import chat.domain.model.Message;
import chat.domain.model.MessageList;

public class ChatModelManager extends Observable implements ChatModel {
  private MessageList list;

  public ChatModelManager() {
    list = new MessageList();
  }

  @Override
  public void addMessage(Message message) {
    list.add(message);
    System.out.println("ADDED " + message);

    setChanged();
    notifyObservers(message);
  }

  @Override
  public void storeMessage(Message message) {
    System.out.println("STORING " + message);
  }

}
