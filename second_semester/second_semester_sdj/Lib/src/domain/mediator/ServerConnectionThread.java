package domain.mediator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import domain.controller.ServerController;


public class ServerConnectionThread implements Runnable
{
	
		Socket clientSocket=null;
		BufferedReader brBufferedReader = null;
		ServerController con;
		
		public ServerConnectionThread(Socket clientSocket)
		{
			this.clientSocket = clientSocket;
		}

		public void run()
		{
			try
			{
				brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));		
			
			String messageString;
			while(true)
			{
			while((messageString = brBufferedReader.readLine())!= null)
			{
				
				if(messageString.equalsIgnoreCase("EXIT"))
				{
					break;
				}
				System.out.println("From Client: " + messageString);
				con.setMessage(messageString);
			}
			this.clientSocket.close();
			System.exit(0);
		}
			
		}
		catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	
}
