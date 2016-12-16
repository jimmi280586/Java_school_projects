package src.system.domain.mediator;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


// TODO: Auto-generated Javadoc
/**
 * The Class ServerModelManager.
 */
public class ServerModelManager 
{
	String message = "";	
	String returnmsg;
	
		/**
		 * Run server and the two threads for sending and receiving information to and from client.
		 *
		 * @throws IOException Signals that an I/O exception has occurred.
		 * @throws SQLException the SQL exception
		 * @throws InterruptedException the interrupted exception
		 */
		public void RunServer() throws IOException, SQLException, InterruptedException 
		{
			final int port =  6789;
			System.out.println("Server waiting for connection on port " + port);
			ServerSocket ss = new ServerSocket(port);
			
			
			while(true)
			{
			this.message = "";	
			this.returnmsg = "";
			Socket clientSocket = ss.accept();
			System.out.println("Recieved connection from " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort());
			//create two threads to send and receive from client
			ServerConnectionThread recieve = new ServerConnectionThread(clientSocket, this);
			Thread thread = new Thread(recieve);
			thread.start();				
			
			Thread.sleep(1000);
			
			ServerCommunicationThread send = new ServerCommunicationThread(clientSocket, this.message);
			Thread thread2 = new Thread(send);
			thread2.start();
			}
		}		
		
		public void setMessage(String msg)
		{
			this.returnmsg = msg;
		}		
		
		public void setFromClientMessage(String msg)
		{
			this.message = msg;
		}
}
