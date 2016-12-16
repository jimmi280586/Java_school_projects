package src.system.controller;

import src.system.domain.mediator.ClientModelManager;

/**
 * The Class ClientController mediate information between 
 * Grafical user interface and clientmodelmanager.
 */
public class ClientController {
	
	
	private static String msg;		
	private String returned;	
	private String returnedString;
	
	/**
	 * Instantiates a new client controller.
	 * and starts the client model manager and send the information from User to clientmodelmanager
	 * @param msg the msg
	 * @throws Exception the exception
	 */
	public ClientController(String msg) throws Exception
	{
		this.msg = "";
		this.msg = msg;
		ClientModelManager c = new ClientModelManager(this.msg, this);
		c.runClient();
		Thread.sleep(3000);
		this.returned = c.getReturnedString();
	}
	
	public String returned()
	{
		return this.returned;
	}	

	public void setReturnedString(String msge)
	{
		this.returned = msge;
	}
}
