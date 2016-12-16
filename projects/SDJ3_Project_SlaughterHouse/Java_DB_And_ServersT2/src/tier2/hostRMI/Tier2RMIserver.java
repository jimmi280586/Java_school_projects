package tier2.hostRMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Tier2RMIserver extends UnicastRemoteObject  implements ITier1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Tier2RMIserver() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
public static void runServer()
{
	try{
		LocateRegistry.createRegistry(1099);
		ITier1 server = new Tier2RMIserver();
		Naming.rebind("Tier2Server", server);
		System.out.println("Server starting...");
		
	}catch(Exception e )
	{
		e.printStackTrace();
	}
}
}
