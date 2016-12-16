package domain.mediator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientCommunicationThread implements Runnable
{
	Socket sock=null;
	PrintWriter print=null;
	BufferedReader brinput=null;
	String message;
	
	public ClientCommunicationThread(Socket sock, String what, String title, String type)
	{
		this.sock = sock;
		this.message = "" + what + "." + title + "." + type;
	}

	public void run()
	{
		try
		{
			if(sock.isConnected())
		{
			System.out.println("Client connected to " + sock.getInetAddress() + " on port " + sock.getPort());
			this.print = new PrintWriter(sock.getOutputStream(), true);	
		while(true)
		{
			System.out.println("type send to send command or exit to close program");
			brinput = new BufferedReader(new InputStreamReader(System.in));
			String msgtoServerString = null;
			msgtoServerString = brinput.readLine();
			if(msgtoServerString.equalsIgnoreCase("send"))
			{
				this.print.println(this.message);
				this.print.flush();
			}
			
			if(msgtoServerString.equalsIgnoreCase("exit"))
			break;
			}
		sock.close();
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}//end run method
}
