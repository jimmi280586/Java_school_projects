package chat.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import  org.xml.sax.SAXException;

import chat.domain.model.AbstractMessage;

public class ClientReceiverThread extends Thread
{
	// synchronizes information so the that there is order, 
	private BufferedReader inFromServer;
	private ClientModelManager model;
	private MessageXmlReader reader;
	
	public ClientReceiverThread(BufferedReader in, ClientModelManager model, BufferedReader inFromServer)
	{
		this.inFromServer = inFromServer;
		this.model = model;
		reader = new MessageXmlReader();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			String xmlString = "";

	         while (true)
	         {
	            try
	            {
	               String line = inFromServer.readLine();
	               xmlString += line;

	               if (line.toLowerCase().endsWith("</message>"))
	                  break;
	            }
	            catch (IOException e)
	            {
	               e.printStackTrace();
	            }
	         }

	         try
	         {
	            AbstractMessage msg = reader.getMessageFromString(xmlString);
	            model.update(msg);
	         }
	         catch (ParserConfigurationException | SAXException | IOException e)
	         {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
	   }

		
	}
	
	

