package chat.domain.mediator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


import org.w3c.dom.Element;

import chat.domain.model.*;
import utility.xml.AbstractXmlWriter;


public class MessageListXmlWriter extends AbstractXmlWriter<MessageList>
{	
	 public MessageListXmlWriter() throws ParserConfigurationException,
     TransformerException
{
  super();
}

@Override
public Element createXmlFromModel(MessageList list)
{
  Element listElement = createElement("messagelist");
  for (int i = 0; i < list.count(); i++)
  {
     AbstractMessage message = list.getMessage(i);
     Element element = null;
     if (message instanceof PrivateMessage)
     {
        PrivateMessage privateMessage = (PrivateMessage) message;
        element = super.createElement("message", new String[] { "id",
              "from", "to", "body" },
              new Object[] { message.getId(), message.getFrom(),
                    privateMessage.getTo(), message.getBody() });
     }
     else
     {
        element = super.createElement(
              "message",
              new String[] { "id", "from", "body" },
              new Object[] { message.getId(), message.getFrom(),
                    message.getBody() });
     }
     listElement.appendChild(element);
  }
  return listElement;
}


}
