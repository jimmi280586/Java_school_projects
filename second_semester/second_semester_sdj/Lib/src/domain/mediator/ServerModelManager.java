package domain.mediator;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerModelManager 
{
	String message;

	
		public void RunServer() throws IOException 
		{
			final int port =  6789;
			System.out.println("Server waiting for connection on port " + port);
			ServerSocket ss = new ServerSocket(port);
			while(true)
			{
			Socket clientSocket = ss.accept();
			System.out.println("Recieved connection from " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort());
			//create two threads to send and recieve from client
			ServerConnectionThread recieve = new ServerConnectionThread(clientSocket);
			Thread thread = new Thread(recieve);
			thread.start();
			
			ServerCommunicationThread send = new ServerCommunicationThread(clientSocket, this.message);
			Thread thread2 = new Thread(send);
			thread2.start();
			}
		}
		public void setMessage(String msg)
		{
			this.message = msg;
		}
}
