import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;


public class RemoteMessageClient implements Serializable
{
	private RemoteMessageList server;
	

	
	public RemoteMessageClient(String msg1) throws RemoteException
	{
	super();
	try
	{
	server = (RemoteMessageList) Naming
	.lookup("rmi://localhost:1099/toUpperCase");
	server.addMessage(msg1);
	System.out.println(msg1);
	}
	catch (Exception ex)
	{
	ex.printStackTrace();
	}
	}
	public static void main(String[] args)
	throws RemoteException
	{
		boolean d = false;
		while(d != true)
		{
			String msg = "";
			Scanner input = new Scanner(System.in);
			msg = input.nextLine();
			if(msg.equals("done"))
			{
				d = true;
			}
			RemoteMessageClient client = new RemoteMessageClient(msg);
		}
	}
}
