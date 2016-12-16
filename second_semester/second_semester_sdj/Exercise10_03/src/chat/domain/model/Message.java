package chat.domain.model;

import java.io.Serializable;

public class Message implements Serializable
{
  private String text;

  public Message(String text)
  {
    this.text = text;
  }

  public String getText()
  {
    return text;
  }

  public String toString()
  {
    return text;
  }

}
