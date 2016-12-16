package model;

import java.io.Serializable;

public class Part implements Serializable
{	
	private int animalId;
	private String type; //what part from the animal
	private int partId;  //ID to that part
	private float weight;
	
	public Part() {
		this(0, "?", 0, 0);
	}
	
	public Part(int animalId, String type, int partId, float weight)
	{
		this.animalId = animalId; // or Animal.getAnimalId();
		this.type = type;
		this.partId = partId;
		this.weight = weight;		
	}

	public float getWeight() 
	{
		return weight;
	}

	public int getPartId()
	{
		return partId;
	}
	
	public int getAnimalId()
	{
		return animalId;
	}

	public String getType() 
	{
		return type;
	}	
}
