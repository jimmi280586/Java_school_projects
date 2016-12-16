package java_t3.adapterDB;

import java.util.ArrayList;

import java_t2.Data.*;


public interface IAdapterDatabase {

//	public boolean storageAnimal(String animalID, String type , double d);
//	
	public boolean storageTray(Tray t);
	public boolean storageOrder(Order o);
	public boolean updateTray(String ref, String partRef);
	public boolean updateOrder(String orderRef, String ref);
	public ArrayList<String>  getComplainsOrders(String orderID);
	public Part getPart(String part);
	public Tray getTray(String tray);
	public Order getOrder(String order);
	public boolean storageAnimal(Animal animal);
	public boolean storagePart(Part p);

}
