package src.system.domain.mediator;


import java.net.Socket;
import java.util.Observable;

import src.system.controller.ClientController;

/**
 * The Class ClientModelManager.
 */
public class ClientModelManager extends Observable 
{		
	private String str;	
	private String returnedString = "";
	ClientController con;
	
	/**
	 * Instantiates a new client model manager.
	 *
	 * @param str the str
	 * @param con the con
	 */
	public ClientModelManager(String str, ClientController con)
	{		
		this.str = str;
		this.con = con;
	}
	
	/**
	 * Run client and then run the two threads in order 
	 * for communication with server and receiving information from server.
	 */
	public void runClient()
	{
		try {
			Socket sock = new Socket("localhost", 6789);
			ClientCommunicationThread sendThread = new ClientCommunicationThread(sock, str);
			Thread thread = new Thread(sendThread);
			thread.start();
						
			ClientReceiverThread recieveThread = new ClientReceiverThread(sock, this);
			Thread thread2 = new Thread(recieveThread);
			thread2.start();
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}		
	}
	
	public void setReturnedString(String msg)
	{
		this.returnedString = msg;
	}
	public String getReturnedString()
	{
		return this.returnedString;
	}
}
	
	
	

