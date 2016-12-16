package java_t3.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import java_t2.Data.Order;
import java_t2.Data.*;

public interface IServer extends Remote
{
	public void saveAnimal(Animal animal) throws RemoteException;
	public void savePart(Part part) throws RemoteException;
	public void saveTray(Tray tray) throws RemoteException;
	public int updateTray(String type, String part) throws RemoteException;
	public void saveOrder(Order order) throws RemoteException;
	public int updateOrder(String OrderID, String name) throws RemoteException;
	public Tray getTray(String tray) throws RemoteException;
	public  ArrayList<String>  getComplains(String OrderID) throws RemoteException;
	
	//public Order getOrder(String order) throws RemoteException ;
	//public Part getPart(String part) throws RemoteException;
	
	
	
	
	
	
	
	
}
