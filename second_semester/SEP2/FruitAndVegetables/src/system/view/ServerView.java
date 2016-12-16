package src.system.view;

import src.system.controller.ServerController;
import src.system.domain.mediator.ServerModelManager;

/**
 * The Class ServerView is only for starting the server.
 */
public class ServerView 
{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception 
	{		
		ServerController controller = new ServerController();
		controller.execute();
	}

}
