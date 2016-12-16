package java_t2.RMIhost;

import java.net.MalformedURLException;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java_t2.Data.*;
import java_t3.Server.*;
import java_t2.Data.Part;
import java_t2.service.ISlaughterHouse;

public class RMIslaughterhouse 

{

	
	private String name; // slaughter house name
	private static RMIslaughterhouse slaughterhouse;
	private IServer sendObject;

	public RMIslaughterhouse(String name) throws RemoteException, NotBoundException, MalformedURLException
	{
		this.name = name;

		Registry registry = LocateRegistry.getRegistry("localhost", 1099);

		this.sendObject = (IServer) registry.lookup("java_t3_Server");

		UnicastRemoteObject.exportObject(sendObject, 1034);
	}


	public static RMIslaughterhouse getInstance() throws RemoteException, MalformedURLException, NotBoundException
	{
		if (slaughterhouse == null) {
			slaughterhouse = new RMIslaughterhouse("SDJ3 Slaughter ");
			return slaughterhouse;
		}

		else
			return slaughterhouse;
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#putInPackage(java.lang.String, java.lang.String)
	 */
	public int putInPackage(String trayId, String orderId) 
	{
		try {
			return sendObject.updateOrder(orderId, trayId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#putInTray(java.lang.String, java.lang.String)
	 */
	public int putInTray(String trayId, String partId)
	{
		try {
			return sendObject.updateTray(trayId, partId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#addAnimal(java.lang.String, float)
	 */
	public String addAnimal(String id, String type, float weight) 
	{

		Animal animal = new Animal(id, type, weight);

		try {
			sendObject.saveAnimal(animal);
			System.out.println("Animal was sent to server.");
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}

		return animal.getAnimalID();
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#newPart(java.lang.String, java.lang.String, float)
	 */
	public String newPart(String animalId, String partid, String type, float weight) 
	{
		
		Part part =new Part(animalId, partid, type, weight);

		
		try {
			sendObject.savePart(part);
			System.out.println("Part was sent to server .");
		}
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}

		return part.getPartID();
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#newTray(java.lang.String, float)
	 */
	public String newTray(String id, String type, float maxWeight, ArrayList<String> list) 
	
	{
		
		Tray tray = new Tray(id, type, maxWeight, list);

		
		try {
			sendObject.saveTray(tray);
			System.out.println("Tray was sent to  server.");
		} 
		catch (RemoteException e)
		{
			e.printStackTrace();
		}

		return tray.getTrayID();
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#newOrder(java.lang.String, float)
	 */
	public String newOrder(String id, String type, float weight) 
	
	{
		
		Order newOrder = new Order(id, weight, type);

		
		try {
			sendObject.saveOrder(newOrder);
			System.out.println("Order was sent to  server .");
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}

		return newOrder.getOrderID();
	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#infectedMeat(java.lang.String)
	 */
	
	public ArrayList<String> infectedMeat(String orderId) {
		try {
			return sendObject.getComplains(orderId);
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#getTray(java.lang.String)
	 */
	
	public Tray getTray(String trayId) {
		try {
			return sendObject.getTray(trayId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	

//	public double getPartWeight(String partId) {
//		try {
//			return sendObject.getPart(partId).getWeight();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}

	/* (non-Javadoc)
	 * @see java_t2.RMIhost.ISlaughterHouse#getCurrentWeight(java.lang.String)
	 */
	
	public double getCurrentWeight(String trayId) {
		try {
			return sendObject.getTray(trayId).getCurrentWeight();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
