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

public class RMIslaughterhouse

{

	
	private String name; // slaughter house name
	private static RMIslaughterhouse slaughterhouse;
	private IServer sendObject;

	public RMIslaughterhouse(String name) throws RemoteException, NotBoundException, MalformedURLException
	{
		this.name = name;

		Registry registry = LocateRegistry.getRegistry("localhost", 1099);

		this.sendObject = (IServer) registry.lookup("java_t3Server");

		UnicastRemoteObject.exportObject(sendObject, 1034);
	}


	public static RMIslaughterhouse getInstance() throws RemoteException, MalformedURLException, NotBoundException
	{
		if (slaughterhouse == null) {
			slaughterhouse = new RMIslaughterhouse("SDJ3 Slaughter house");
			return slaughterhouse;
		}

		else
			return slaughterhouse;
	}

	public int putInPackage(String trayId, String orderId) 
	{
		try {
			return sendObject.updateOrder(orderId, trayId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int putInTray(String trayId, String partId)
	{
		try {
			return sendObject.updateTray(trayId, partId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String addAnimal( String type, float weight) 
	{

		Animal animal = new Animal(type, weight);

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

	public String newPart(String animalId, String type, float weight) 
	{
		
		Part part =new Part(animalId, type, weight);

		
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

	public String newTray(String type, float maxWeight) 
	
	{
		
		Tray tray = new Tray(type, maxWeight);

		
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

	public String newOrder(String type,float weight) 
	
	{
		
		Order newOrder = new Order(weight, type);

		
		try {
			sendObject.saveOrder(newOrder);
			System.out.println("Order was sent to  server .");
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}

		return newOrder.getOrderID();
	}

	public ArrayList<String> infectedMeat(String orderId) {
		try {
			return sendObject.getComplains(orderId);
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Part getPart(String partId) {
		try {
			return sendObject.getPart(partId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Tray getTray(String trayId) {
		try {
			return sendObject.getTray(trayId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Order getOrder(String orderId)  {
		
			try {
				return sendObject.getOrder(orderId);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	public double getPartWeight(String partId) {
		try {
			return sendObject.getPart(partId).getWeight();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double getCurrentWeight(String trayId) {
		try {
			return sendObject.getTray(trayId).getCurrentWeight();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
