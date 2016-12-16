package src.system.domain.mediator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import src.system.controller.ClientController;

/**
 * The Class ClientReceiverThread.
 */
public class ClientReceiverThread implements Runnable
{
	private static String returnedString = "";	
	private Socket clientSocket;
	private static String ms;
	private ClientModelManager model;
	
	/**
	 * Instantiates a new client receiver thread.
	 * for receiving information from server
	 * @param sock the sock
	 * @param model the model
	 */
	public ClientReceiverThread(Socket sock, ClientModelManager model) 
	{
		this.clientSocket = sock;
		this.model = model;
	}

	/* (non-Javadoc)
	 * uses the buffer and socket for getting information from server
	 * and relays it to the clientController
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		while(true){
			
			BufferedReader inFromServer = null;
			try {
				System.out.println("Client receiving...");
				inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ms = null;
			try {
				ms = inFromServer.readLine();
				System.out.println("Received: " + ms);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			returnedString = "";
			String[] msg = ms.split("/&");
			
			for (int i = 0; i < msg.length; i++)
			{
				returnedString += msg[i] + "\n";
			}
			
			this.model.setReturnedString(returnedString);
			
			if(!ms.equals(null))
				break;
	}
		
}
	
	
}

	
	
	

