package src.system.controller;

import src.system.domain.mediator.ServerModelManager;

/**
 * The Class ServerController.
 */
public class ServerController
{		
	/**
	 * Instantiates a new server controller.
	 *
	 * @throws Exception the exception
	 */
	public ServerController() throws Exception
	{
		
	}	
	
	/**
	 * Execute only starts the server model manager.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	public String execute() throws Exception
	{
		System.out.println("server starting");
		while (true) 
		{
			ServerModelManager s = new ServerModelManager();
			s.RunServer();;
			
		}
	}

}
