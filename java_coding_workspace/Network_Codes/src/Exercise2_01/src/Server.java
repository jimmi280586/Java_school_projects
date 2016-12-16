package Exercise2_01.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{
	private int numberOfConnections;
	private int portnumber;
	
	public Server(int portnumber)
	{
		this.portnumber = portnumber;
	}
	
	public void startServer() throws IOException
	{
		ServerSocket welcomeSocket = new ServerSocket(this.portnumber);
		
		while(true)
		{
	        System.out.println("Waiting for a client...");
	           
	        // Wait, on welcoming socket for contact by client
	        Socket connectionSocket = welcomeSocket.accept();
	           
	        // Start a thread with the client communication
	        CommunicationThread c = new CommunicationThread(connectionSocket);

			this.numberOfConnections ++;
			
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		Server server = new Server(6789);
		server.startServer();
	}
}
