import java.io.IOException;

import domain.controller.ClientController;
import domain.mediator.ClientModelManager;
import domain.view.ClientView;


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
