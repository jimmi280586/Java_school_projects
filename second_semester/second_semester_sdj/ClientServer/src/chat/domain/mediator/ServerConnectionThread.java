package chat.domain.mediator;

import java.io.IOException;
import java.net.*;

public class ServerConnectionThread
{
	// synchronizes information so the that there is order, 
	private static int PORT = 2112;
	private ServerModelManager model;
	
	public ServerConnectionThread(ServerModelManager model)
	{
		this.model = model;
	}
	
	public void run() throws IOException
	{
		
	
	System.out.println("starting server...");
	
	// Creating a welcome socket port 901
	
	ServerSocket welcomeSocket = new ServerSocket(PORT); 
	
	while(true)
	{
		// Wait, on welcoming socket for contact by client
		System.out.println("Waiting for a client....");
		Socket connectionSocket = welcomeSocket.accept();
		
		// Start a thread with the client communication
		ServerCommunicationThread c = new ServerCommunicationThread(connectionSocket, model);
		
		
	}
	}
	

	

}