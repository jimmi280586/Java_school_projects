package services;

import model.*;

public interface Tracking {

	public Animal[] getAnimals();

	public Product[] trackAnimal(int animalId);
	
	public Market trackProduct(int protuctId);
	
}
