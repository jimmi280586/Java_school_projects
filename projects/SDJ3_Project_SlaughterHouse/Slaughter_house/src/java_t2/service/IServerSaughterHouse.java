package java_t2.service;

import java.util.ArrayList;

public interface IServerSaughterHouse {

  public void addAnimal(String IdAnimal, String type, double weight);//add new animal pig or cow
	
  public String getAnimal(String AnimalId);
  
  public String getPart(String partId);
	
	public void addPart(String IdAnimal, String typePart, double weight);
	//add part by id animal , type of part(ribs or legs) and weight part
	
	public void addTray(String typeOfMeat, String id, double maxWeight, String listParts);//add tray by type(legs or ribs)and maxWei
	
	public void addToTray(String Trayid, String Part);//add for ex. in tray ribs a part rib
	
	
	public void addOrder(String OrderID , double weight, String type, String listTrays);
	
	public String makeOrder(String TrayType, String OrderID);
	
	public String getTray(String trayId);
	
	public String recallPack(String packId);
	
	
}

//Generate the message and skeleton .java files with
//the command wsdl2java
