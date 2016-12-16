package src.system.domain.mediator;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The Class ClientCommunicationThread.
 */
public class ClientCommunicationThread implements Runnable
{
	Socket sock=null;	
	BufferedReader brinput=null;	
	String str;
	
	/**
	 * Instantiates a new client communication thread
	 * for sending information to the server.
	 *
	 * @param sock the sock
	 * @param str the str
	 */
	public ClientCommunicationThread(Socket sock, String str)
	{
		this.sock = sock;
		this.str = "" + str + '\n';
	}

	/* (non-Javadoc)
	 * the run method runs the buffer and socket for sending information
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		try
		{
			if(sock.isConnected())
			{
				System.out.println("Client connected to " + sock.getInetAddress() + " on port " + sock.getPort());
				
				while(true)
				{
					System.out.println("Client sending...");
					DataOutputStream outToServer = new DataOutputStream(sock.getOutputStream());
					outToServer.writeBytes(str + '\n');
					System.out.println("Sent: " + str);
					
					break;
				}
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
