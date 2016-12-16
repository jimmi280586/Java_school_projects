import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;


public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList
{
	 private static final long serialVersionUID = 724887908984646040L;
	 private ArrayList<String> list = new ArrayList<String>();
	
	 public RemoteMessageServer() throws RemoteException 
	 {
	 super();
	 }
	 
	 @Override
	 public void addMessage(String message, ReplyTo sender) throws RemoteException 
	 {
	 this.list.add(message);
	 System.out.println("List: \n" + list.toString());
	 sender.replyMessage("Message received: " + message);
	 }
	 
	 public static void main(String[] args) 
	 {
	 try
	 {
	 Registry registry = LocateRegistry.createRegistry(1099);
	 RemoteMessageList rmiServer = new RemoteMessageServer();
	 Naming.rebind("addMessage", rmiServer);
	 System.out.println("Starting server");
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 }
		
		
		
	}

