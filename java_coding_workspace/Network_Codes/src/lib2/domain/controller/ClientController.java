package lib2.domain.controller;


import javax.swing.text.View;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import lib2.domain.mediator.TCPClientManager;
import lib2.domain.view.ClientView;

public class ClientController 
{
	private TCPClientManager model;

	private ClientView view;
		
	public ClientController(ClientView view)
	{	
		
		this.view = view;		
	}
	
	public void execute(int choice) throws Exception
	{
		this.model = new TCPClientManager();
		switch (choice)
		{
		case 1:
			model.ClientManager(choice);
			break;
		case 2:
			model.ClientManager(choice);
			break;
		case 3:
			model.ClientManager(choice);
			break;
		case 4:
			System.out.println("here");
			model.ClientManager(choice);
			break;
		case 5:	
			model.ClientManager(choice);
			break;
         case 6:
            System.exit(0);
		}
	}
}
