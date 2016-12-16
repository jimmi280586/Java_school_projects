package chat.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;

import javax.annotation.processing.Messager;
import javax.xml.parsers.ParserConfigurationException;

import  org.xml.sax.SAXException;

import chat.domain.model.AbstractMessage;
import chat.domain.model.MessageList;

public class ClientReceiverThread extends Thread
{
	// synchronizes information so the that there is order, 
	private BufferedReader inFromServer;
	private ClientModelManager model;
	private MessageList reader;
	private int id;
	
	public ClientReceiverThread(ClientModelManager model, BufferedReader inFromServer)
	{
		this.inFromServer = inFromServer;
		this.model = model;
		reader = new MessageList();
		this.id = 0;
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

	         AbstractMessage msg = new AbstractMessage(id, " client ", xmlString) {
				
			};
			
			model.update(msg);
			id++;

	      }
	   }

		
	}
	
	

