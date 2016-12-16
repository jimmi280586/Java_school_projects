package chat.domain.mediator;

import javax.swing.text.View;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.model.PublicMessage;
import chat.domain.view.ClientView;

public class ClientController
{
	private ClientModelManager model; // Instance of modeManager
	private ClientView view;
	
	
	public ClientController(ClientModelManager model, ClientView view)
	{
		this.model = model;
		this.view = view;
		this.model.addObserver(view);
	}
	
	public void execute(String what) throws TransformerException, ParserConfigurationException
	{
		switch (what)
		{
		case "Send":
            String input = view.getAndRemoveInput();
            if (input.length() > 0)
            {
               model.add(new PublicMessage("Me", input));
            }
            break;
         case "Quit":
            System.exit(0);
		}
	}
}
