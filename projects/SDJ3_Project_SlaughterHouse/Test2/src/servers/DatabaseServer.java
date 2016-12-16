package servers;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


import mediator.*;
import model.*;

@SuppressWarnings("serial")
public class DatabaseServer extends UnicastRemoteObject implements DatabaseServerInterface {
	private Persistence database;
	private Animal[] animals;
	private Part[] parts;
	private Tray[] trays;
	private Product[] products;
	private Market[] markets;

	public DatabaseServer() throws RemoteException {
		super();
		try {
			database = new DatabaseAdapter();

			updateDatabase();
			
			System.out.println("{DatabaseServer} Models loaded from the database successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	private void updateDatabase() {
		try {
			animals = database.loadAnimals();
			parts = database.loadParts();
			trays = database.loadTrays();
			products = database.loadProducts();
			markets = database.loadMarkets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addAnimal(float weight, String type) throws RemoteException {
		try {
			database.saveAnimal(weight, type);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean addPart(int animalId, String type, float weight) throws RemoteException {
		try {
			Animal currentAnimal = null;
			
			for (Animal animal:animals) {
				if (animal.getAnimalId() == animalId) {
					currentAnimal = animal;
					break;
				}
			}
			
			database.updateAnimal(animalId, currentAnimal.getWeight()-weight);			
			database.savePart(animalId, type, weight);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean addtray(String type, float maxWeight) throws RemoteException {
		try {
			database.saveTray(type, maxWeight);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean addToTray(int partId, int trayId) throws RemoteException {
		try {
			database.addToTray(partId, trayId);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean addMarket(String address) throws RemoteException {
		try {
			database.saveMarket(address);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean packTraysToProduct(String type, float weight, Tray[] trays) throws RemoteException {
		try {
			database.packTraysToProduct(type, weight, trays);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public boolean transportTomarket(int productId, int marketId) throws RemoteException {
		try {
			database.transportTomarket(productId, marketId);
			updateDatabase();
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public Animal[] getAllAnimals() throws RemoteException {
		updateDatabase();
		return animals;
	}

	public Part[] getAllParts() throws RemoteException {
		updateDatabase();
		return parts;
	}

	public Tray[] getAllTrays() throws RemoteException {
		updateDatabase();
		return trays;
	}

	public Product[] getAllProducts() throws RemoteException {
		updateDatabase();
		return products;
	}

	public Market[] getAllMarkets() throws RemoteException {
		updateDatabase();
		return markets;
	}

}
