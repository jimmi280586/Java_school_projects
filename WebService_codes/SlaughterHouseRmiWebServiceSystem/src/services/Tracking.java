package services;

import model.Animal;
import model.Market;
import model.Product;

public interface Tracking 
{
	public Animal[] getAnimals();

	public Product[] trackAnimal(int animalId);
	
	public Market trackProduct(int protuctId);
}
