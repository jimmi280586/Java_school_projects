import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList
{
	private ArrayList<String> list = new ArrayList<String>();
	public RemoteMessageServer() throws RemoteException
	{
	super();
	}

	
	
	public static void main(String[] args)
	{
		try
		{
		Registry reg= LocateRegistry.createRegistry(1099);
		RemoteMessageList rmiServer = new RemoteMessageServer();
		Naming.rebind("toUpperCase", rmiServer);
		System.out.println("Starting server...");
		}
		catch (Exception ex)
		{
		ex.printStackTrace();
		}
		}		
		@Override
		public void addMessage(String msg)
		throws RemoteException
		{
		
		list.add(msg);
		 for (int i = 0; i < list.size(); i++)
		 {
			 
			 System.out.println("" + list.get(i).toUpperCase());
		}
		}
	}

