package chat.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;
import java.util.Observer;

import chat.domain.model.AbstractMessage;
import chat.domain.model.PublicMessage;
import chat.domain.model.SimpleDate;

public class ServerCommunicationThread extends Thread implements Observer
{
	// Makes the informationa to be in a write order,
	private ObjectInputStream inFromClient;
	   private ObjectOutputStream outToClient;
	   private ServerModelManager model;
	   private String client;
	   private String clientIP;
	   private int number;

	   public ServerCommunicationThread(Socket clientSocket,
	         ServerModelManager model) throws IOException
	   {
	      this.model = model;
	      inFromClient = new ObjectInputStream(clientSocket.getInputStream());
	      outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

	      clientIP = clientSocket.getInetAddress().getHostName();
	      if (!clientIP.equals(clientSocket.getInetAddress().getHostAddress()))
	         clientIP += " / " + clientSocket.getInetAddress().getHostAddress();
	      if (clientIP.equals("127.0.0.1"))
	         clientIP = "localhost";

	      this.start();
	   }

	   public void run()
	   {
	      try
	      {
	         number = model.countObservers();
	         model.addObserver(this);

	         Thread.sleep(1000);

	         while (true)
	         {
	            Object inObject = inFromClient.readObject();

	            AbstractMessage message = (AbstractMessage) inObject;
	            System.out.println(message);
	            AbstractMessage pl;
	            if (message.getBody().equalsIgnoreCase("login")
	                  && message.getId() == 0)
	            {
	               client = message.getFrom() + " (" + clientIP + ")";
	               pl = new PublicMessage(message.getId(), "Server", "[" + number
	                     + "] " + client + " logged on at "
	                     + new SimpleDate().getShortTime());
	            }
	            else if (message.getBody().equalsIgnoreCase("logout")
	                  && message.getId() == 0)
	            {
	               pl = new PublicMessage(message.getId(), "Server", "[" + number
	                     + "] " + client + " logged off at "
	                     + new SimpleDate().getShortTime());
	               System.out.println(pl);
	               model.add(pl);
	               break;
	            }
	            else
	            {
	               if (message.getBody().equalsIgnoreCase("login")
	                     || message.getBody().equalsIgnoreCase("logout"))
	               {
	                  pl = new PublicMessage(message.getId(), "Server", client
	                        + " --- NOT A CORRECT USE OF: " + message.getBody());
	                  System.out.println(pl);
	                  return;
	               }
	               else
	               {
	                  pl = new PublicMessage(message.getId(), client,
	                        message.getBody());
	               }
	            }
	            System.out.println(pl);
	            model.add(pl);
	         }
	      }
	      catch (SocketException e)
	      {
	         // ok
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	   }

	   @Override
	   public void update(Observable arg0, Object arg1)
	   {
	      try
	      {
	         AbstractMessage message = (AbstractMessage) arg1;
	         send(message);
	      }
	      catch (Exception e)
	      {
	         // no client connection
	         System.out.println("Exception for client broadcast to " + client
	               + " - " + e.getMessage());
	         model.deleteObserver(this);
	         AbstractMessage pl = new PublicMessage(client, "Server> " + client
	               + " disconnected " + new SimpleDate().getTime());
	         System.out.println(pl);
	         model.add(pl);
	      }
	   }

	   private void send(AbstractMessage message) throws Exception
	   {
	      System.out.println("Server> " + message);
	      outToClient.writeObject(message);
	   }

}
