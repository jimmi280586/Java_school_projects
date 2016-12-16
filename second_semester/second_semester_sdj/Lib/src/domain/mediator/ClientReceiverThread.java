package domain.mediator;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiverThread implements Runnable
{
	Socket sock = null;
	BufferedReader recieve = null;
	
	public ClientReceiverThread(Socket sock) 
	{
		this.sock = sock;
	}

	public void run()
	{
		try
		{
			recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			String msgRecieved = null;
		while((msgRecieved = recieve.readLine())!= null)
		{
			System.out.println("From Server: " + msgRecieved);
			System.out.println("information given to customer");
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
	
	
	

