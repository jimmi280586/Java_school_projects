package mediator;

import java.io.IOException;
import java.util.ArrayList;

import model.Animal;
import model.Market;
import model.Part;
import model.Product;
import model.Tray;

public interface Persistence {

	   public Animal[] loadAnimals() throws IOException;
	   public Part[] loadParts() throws IOException;
	   public Tray[] loadTrays() throws IOException;
	   public Product[] loadProducts() throws IOException;
	   public Market[] loadMarkets() throws IOException;
	   public void saveAnimal(float weight, String type) throws IOException;
	   public void savePart(int animalId, String type, float weight) throws IOException;
	   public void saveTray(String type, float maxWeight) throws IOException;
	   public void addToTray(int partId, int trayId) throws IOException;
	   public void saveMarket(String address) throws IOException;
	   public void packTraysToProduct(String type, float weight, Tray[] trays) throws IOException;
	   public void transportTomarket(int productId, int marketId) throws IOException;
	   public void updateAnimal(int animalId, float weight) throws IOException;
} 
