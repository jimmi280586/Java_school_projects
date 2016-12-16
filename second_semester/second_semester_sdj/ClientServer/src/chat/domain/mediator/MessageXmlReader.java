package chat.domain.mediator;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.jar.Attributes;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import chat.domain.model.AbstractMessage;
import chat.domain.model.PrivateMessage;
import chat.domain.model.PublicMessage;

public class MessageXmlReader extends DefaultHandler
{
	private String value;
	   private int id;
	   private String from;
	   private String to;
	   private String body;
	   private AbstractMessage message;

	   public AbstractMessage getMessageFromFile(String filename)
	         throws ParserConfigurationException, SAXException, IOException
	   {
	      SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
	      parser.parse(new File(filename), this);

	      return message;
	   }
	   
	   public AbstractMessage getMessageFromString(String xmlString)
	         throws ParserConfigurationException, SAXException, IOException
	   {
	      SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
	      InputSource iSource = new InputSource( new StringReader( xmlString ) );
	      parser.parse( iSource, this );

	      return message;
	   }

	   public void startElement(String uri, String localName, String qName,
	         Attributes attributes) throws SAXException
	   {
	      value = "";
	      switch (qName)
	      {
	         case "id":
	            id = -1;
	            break;
	         case "from":
	            from = "";
	            break;
	         case "to":
	            to = "";
	            break;
	         case "body":
	            body = "";
	            break;
	         case "message":
	            message = null;
	            to = "";
	      }
	   }

	   public void endElement(String uri, String localName, String qName)
	         throws SAXException
	   {
	      switch (qName)
	      {
	         case "id":
	            try
	            {
	               id = Integer.parseInt(value);
	            }
	            catch (Exception e)
	            {
	            }
	            break;
	         case "from":
	            from = value;
	            break;
	         case "to":
	            to = value;
	            break;
	         case "body":
	            body = value;
	            break;
	         case "message":
	            if (to!= null && to.length() > 0)
	               message = new PrivateMessage(id, from, to, body);
	            else
	               message = new PublicMessage(id, from, body);
	            break;
	      }
	   }

	   public void characters(char ch[], int start, int length) throws SAXException
	   {
	      value += new String(ch, start, length);
	   }
}
