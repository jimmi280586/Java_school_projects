package chat.domain.mediator;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

import utility.xml.AbstractXmlWriter;
import chat.domain.model.AbstractMessage;
import chat.domain.model.PrivateMessage;
import chat.domain.model.PublicMessage;

public class MessageXmlWriter extends AbstractXmlWriter<AbstractMessage>
{
	 public MessageXmlWriter() throws ParserConfigurationException,
     TransformerException
{
  super();
}

public Element createXmlFromModel(AbstractMessage message)
{
  Element element = null;
  if (message instanceof PrivateMessage)
  {
     PrivateMessage privateMessage = (PrivateMessage) message;
     element = super.createElement("message", new String[] { "id", "from",
           "to", "body" },
           new Object[] { message.getId(), message.getFrom(),
                 privateMessage.getTo(), message.getBody() });
  }
  else
  {
     element = super.createElement("message", new String[] { "id", "from",
           "body" }, new Object[] { message.getId(), message.getFrom(),
           message.getBody() });
  }
  return element;
}

public String toXml(PublicMessage pmsg, boolean b)
{
	// TODO Auto-generated method stub
	return null;
}
}
