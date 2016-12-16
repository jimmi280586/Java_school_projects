package servers;

import model.*;

public interface Model
{
	public boolean addAnimal(float weight, String type);
	public boolean addPart(int animalId, String type, float weight);
	public boolean addTray(String type, float maxWeight);
	public boolean addToTray(int partId, int trayId);
	public boolean addMarket(String address);
	public boolean packTraysToProduct(String type, float weight, Tray trays[]);
	public boolean transportProductToMarket(int productId, int marketId);
	
	public Animal[] getAllAnimals();
	public Part[] getAllParts();
	public Tray[] getAllTrays();
	public Product[] getAllProducts();
	public Market[] getAllMarkets();
	
}
