package servers;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.*;


public interface DatabaseServerInterface extends Remote
{
	public boolean addAnimal(float weight, String type) throws RemoteException;
	
	public boolean addPart(int animalID, String type, float weight) throws RemoteException;
	
	public boolean addtray(String type, float maxWeight) throws RemoteException;
	
	public boolean addToTray(int partId, int trayId) throws RemoteException;
	
	public boolean addMarket(String address) throws RemoteException;
	
	public boolean packTraysToProduct(String type, float weight, Tray trays[]) throws RemoteException;
	
	public boolean transportTomarket(int productId, int marketId) throws RemoteException;
	
	public Animal[] getAllAnimals() throws RemoteException;
	
	public Part[] getAllParts() throws RemoteException;
	
	public Tray[] getAllTrays() throws RemoteException;
	
	public Product[] getAllProducts() throws RemoteException;
	
	public Market[] getAllMarkets() throws RemoteException;
	
}
