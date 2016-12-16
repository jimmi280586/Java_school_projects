package Exercise2_01.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class CommunicationThread extends Thread
{
	
	  private BufferedReader inFromClient;
	  private PrintWriter outToClient;
	  private Socket clientSocket;

	  public CommunicationThread(Socket socket) throws IOException
	  {
	     clientSocket = socket;

	     // create input stream attached to the socket
	     inFromClient = new BufferedReader(new InputStreamReader(
	                           clientSocket.getInputStream()));     

	         // create output stream attached to the socket
	     outToClient = new PrintWriter(
	                           clientSocket.getOutputStream(), true);     
	         
	     this.start();
	}
	  
	  public void run()
	  {
	    try
	    {
	       // read line from client.
	       int clientSentence = inFromClient.read();
	         
	       System.out.println("Client> " + clientSentence);
	       double capitalizedSentence = clientSentence * clientSentence;
	       System.out.println("Server> " + (int) Math.round(capitalizedSentence));
	          
	       // Send line to client.
	       outToClient.println(capitalizedSentence);
	    }
	    catch (IOException e)
	    { 
	      e.printStackTrace();
	    }
	  }
	}



