package chat.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageList implements Serializable
{
  private ArrayList<Message> list;

  public MessageList()
  {
    list = new ArrayList<Message>();
  }

  public Message getMessage(int index)
  {
    return list.get(index);
  }

  public void add(Message message)
  {
    list.add(message);
  }

  public int size()
  {
    return list.size();
  }

  public String toString()
  {
    String s = "{";
    for (int i = 0; i < list.size(); i++)
    {
      s += list.get(i);
      if (i < list.size() - 1)
      {
        s += "; ";
      }
    }
    s += "}";
    return s;
  }

}
