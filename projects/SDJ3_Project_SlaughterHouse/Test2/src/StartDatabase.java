

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import servers.DatabaseServer;
import servers.DatabaseServerInterface;

public class StartDatabase {

	public static void main(String[] args) {
		try {
			System.out.println("{DatabaseServer} Starting server...");
			Registry reg = LocateRegistry.createRegistry(1099);
			DatabaseServerInterface rmiServer = new DatabaseServer();
			Naming.rebind("SlaughterHouse", rmiServer);
			System.out.println("{DatabaseServer} Server running...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
