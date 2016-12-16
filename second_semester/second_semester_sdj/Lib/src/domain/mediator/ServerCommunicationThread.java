package domain.mediator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;






public class ServerCommunicationThread extends Thread
{
	PrintWriter pwPrintWriter;
	Socket clientSock = null;
	private String message;
	
	public ServerCommunicationThread(Socket clientSock, String message)
	{
		this.clientSock = clientSock;
		this.message = message;
	}
	public void run() 
	{
		try
		{
			pwPrintWriter = new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
		
		while(true)
		{
			String msgToClientString = this.message;		
			
			pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
			pwPrintWriter.flush();//flush the PrintWriter
			
		}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}	
	}
	
}


