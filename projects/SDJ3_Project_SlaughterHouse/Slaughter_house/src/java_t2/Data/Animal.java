package java_t2.Data;

import java.io.Serializable;
import java.util.Random;

public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String animalID;
	private String type;
	private float weight;

	public Animal(String type, float weight) {
		this.type = type;
		this.weight = weight;
	}

	public Animal(String animalID, String type, float weight) {

		this.animalID = addRanAnimalID();
		this.type = type;
		this.weight = weight;

	}

	private String addRanAnimalID() {
		Random r = new Random();
		int rand = r.nextInt(20500);

		return "" + rand;
	}

	public String getAnimalID() {
		return addRanAnimalID();
	}

	public void setAnimal(String animalId) {
		this.animalID = animalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public boolean compare(Animal animal) {
		if (this.animalID == animal.animalID)
			return true;
		return false;
	}

	public String toString() {
		return "Type: " + type + "\nID: " + animalID + "\nW: " + weight + "kg";
	}

}
