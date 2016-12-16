import java.io.IOException;

import chat.domain.mediator.ClientController;
import chat.domain.mediator.ClientModelManager;
import chat.domain.view.ClientView;


public class Client
{
	public static void main(String[] args) throws IOException 
	{
		ClientModelManager manager = new ClientModelManager();
		ClientView view = new ClientView();
		ClientController control = new ClientController(manager, view);
		view.start(control);
	}
}
