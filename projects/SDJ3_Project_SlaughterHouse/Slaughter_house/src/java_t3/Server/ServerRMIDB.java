package java_t3.Server;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java_t2.Data.Animal;
import java_t2.Data.Order;
import java_t2.Data.Part;
import java_t2.Data.Tray;
import java_t3.adapterDB.AdapterDatabase2;
import java_t3.adapterDB.IAdapterDatabase;

public class ServerRMIDB extends UnicastRemoteObject implements IServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdapterDatabase2 adapterDB;
	private String host,dataBase,user,password;
	private int portNr;

	 public ServerRMIDB() throws RemoteException
	   {
	      this("168.0.0.0", 1099, "postgresql", "Vitalie", "1234");

	   }

	@SuppressWarnings("unused")
	private ServerRMIDB (String host, int portNr, String database,String user,String password)throws RemoteException
	{
		this.adapterDB=new AdapterDatabase2(host,portNr,database,user,password) ;
		Registry reg = LocateRegistry.createRegistry(1099); 
		try
	      {
			 
	         Naming.rebind("server", this);
	         System.out.println("Starting server...");
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }	
			
			
		}

	@Override
	public Order getOrder(String order) throws RemoteException{
		// TODO Auto-generated method stub
		
		
		Order o=null;
		o=adapterDB.getOrder(order);
		return o;
	}

	@Override
	public Tray getTray(String tray) throws RemoteException {
		// TODO Auto-generated method stub
		
		Tray t = new Tray();
		t=null;
		t=adapterDB.getTray(tray);
		return t;
	}

	@Override
	public Part getPart(String part) throws RemoteException {
		// TODO Auto-generated method stub
		
		Part p =null;
		
		p=adapterDB.getPart(part);
		
		return p;
	}

	// Complains orders 
	@Override
	public ArrayList<String> getComplains(String OrderID) throws RemoteException {
		// TODO Auto-generated method stub
		return adapterDB.getComplainsOrders(OrderID);
	}

	@Override
	public void saveAnimal(Animal animal) throws RemoteException {
		// TODO Auto-generated method stub
		
		adapterDB.storageAnimal(animal);
	}

	@Override
	public void savePart(Part part) throws RemoteException {
		// TODO Auto-generated method stub
		
		 adapterDB.storagePart(part);
		
	}

	@Override
	public void saveTray(Tray tray) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Tary seved : " + adapterDB.storageTray(tray));
	}

	@Override
	public int updateTray(String type, String part) throws RemoteException {
		// TODO Auto-generated method stub
		if(adapterDB.updateTray(type, part))
		{
			System.out.println("Tray updated");
			return 1;
		}
		else{
			System.out.println("Tray not updated");
			return 0;
		}

	}

	@Override
	public void saveOrder(Order order) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Order saved : "+ adapterDB.storageOrder(order));
	}

	@Override
	public int updateOrder(String OrderID, String name) throws RemoteException {
		// TODO Auto-generated method stub
		if(adapterDB.updateTray(OrderID, name))
		{
			System.out.println("Order updated");
			return 1;
		}
		else{
			System.out.println("Order not updated");
			return 0;
		}
	}
			
}		