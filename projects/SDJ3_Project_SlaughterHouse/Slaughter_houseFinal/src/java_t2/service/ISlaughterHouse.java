package java_t2.service;

import java.util.ArrayList;

import java_t2.Data.Tray;

public interface ISlaughterHouse {

	//public int putInPackage(String trayId, String orderId);

	//public int putInTray(String trayId, String partId);

	public String addAnimal(String id, String type, float weight);

	public String newPart(String animalId, String partid, String type, float weight);

	public String newTray(String id, String type, float maxWeight, String partList);

	public String newOrder(String orderid, String type, float weight);	

	public String getTray(String trayId);

	public String getCurrentWeight(String trayId);

}



