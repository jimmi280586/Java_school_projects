package servers;

import java.rmi.Naming;
import java.rmi.RemoteException;

import model.*;


public class ApplicationServer implements Model
{
	private  DatabaseServerInterface server;
	
	public ApplicationServer() throws RemoteException
	{
		super();
		
		try 
		{
			prnt("trying to connect to the Database Server!");
			server = (DatabaseServerInterface) Naming.lookup("rmi://localhost:1099/SlaughterHouse");;
			prnt("connection to the Database Server successful!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void prnt(String message){
		System.out.println("{ApplicationServerClient} " + message);
	}

	public String greeting(String name) {
		String result = "";
		
		if (name == null) 
			result = "Hello";
		else 
			result = "Hello, " + name + "!";
		
		prnt(result);
		return result;
	}
	
	public boolean addAnimal(float weight, String type)
	{
		try 
		{
			return server.addAnimal(weight, type);
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean addPart(int animalId, String type, float weight) 
	{
		try 
		{
			return server.addPart(animalId, type, weight);
		} 
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean addTray(String type, float maxWeight) 
	{
		try 
		{
			return server.addtray(type, maxWeight);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean addToTray(int partId, int trayId) 
	{
		try 
		{
			return server.addToTray(partId, trayId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean addMarket(String address) 
	{
		try 
		{
			return server.addMarket(address);
		} 
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean packTraysToProduct(String type, float weight, Tray[] trays)
	{
		try 
		{
			return server.packTraysToProduct(type, weight, trays);
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean transportProductToMarket(int productId, int marketId) 
	{
		try
		{
			return server.transportTomarket(productId, marketId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return false;
	}

	public Animal[] getAllAnimals() {
		try
		{
			return server.getAllAnimals();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public Part[] getAllParts() {
		try
		{
			return server.getAllParts();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public Tray[] getAllTrays() {
		try
		{
			return server.getAllTrays();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public Product[] getAllProducts() {
		try
		{
			return server.getAllProducts();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public Market[] getAllMarkets() {
		try
		{
			return server.getAllMarkets();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
}
