package chat.domain.mediator;

import chat.domain.model.Message;

public interface ChatModel {
  public void addMessage(Message message);

  public void storeMessage(Message message);
}
