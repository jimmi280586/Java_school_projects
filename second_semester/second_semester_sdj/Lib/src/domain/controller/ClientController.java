package domain.controller;


import javax.swing.text.View;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import domain.mediator.ClientModelManager;
import domain.view.ClientView;

public class ClientController
{
	private ClientModelManager model; // Instance of modeManager
	private ClientView view;
		
	public ClientController(ClientModelManager model, ClientView view)
	{
		this.model = model;
		this.view = view;
		
	}
	
	public void execute(int choice, String what, String command, int type) throws TransformerException, ParserConfigurationException
	{
		String t = "" + type;
		switch (choice)
		{
		case 1:
			model = new ClientModelManager(what, command, t);
			break;
		case 2:
			model = new ClientModelManager(what, command, t);
			break;
		case 3:
			model = new ClientModelManager(what, command, t);
			break;
		case 4:
			model = new ClientModelManager(what, command, t);
			break;
		case 5:	
			model = new ClientModelManager(what, command, t);
			break;
         case 6:
            System.exit(0);
		}
	}
}
