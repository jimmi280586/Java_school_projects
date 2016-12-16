import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class RemoteMessageClient extends UnicastRemoteObject implements ReplyTo, Serializable
{
	 private static final long serialVersionUID = -9154321877613063471L;
	 private RemoteMessageList server;
	
	 public RemoteMessageClient() throws RemoteException 
	 {
		 super();
	 
	 try
	 {
		server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
	 	String message;
	 	Scanner userInput = new Scanner(System.in);
	 
	 while (true) 
	 {
		 System.out.println("Input message: ");
	 	message = userInput.nextLine();
	 
	 if (message.equalsIgnoreCase("quit"))
	 {
		 System.exit(0);
	 } 
	 else
	 {
		 server.addMessage(message, this);
	 }
	 }
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }
	 
	 public static void main(String[] args) throws RemoteException
	 {
	 try 
	 {
		 RemoteMessageClient client = new RemoteMessageClient();
	 } 
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	 }
	 @Override
	 public void replyMessage(String message) throws RemoteException {
	 System.out.println(message);
	 }
}
