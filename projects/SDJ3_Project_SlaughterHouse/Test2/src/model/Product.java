package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable
{
	private ArrayList<Part> parts;
	private int productId;
	private String type;
	private float weight;
	
	public Product() {
		this(0, "?", 0);
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Product(ArrayList<Part> parts, int productId, String type, float weight) 
	{
		this.parts = parts;
		this.productId = productId;
		this.type = type;
		this.weight = weight;
	}
	public Product(int productId, String type, float weight) 
	{
		this.parts = null;
		this.productId = productId;
		this.type = type;
		this.weight = weight;
	}

	public int getProductId() 
	{
		return productId;
	}

	public String getType() 
	{
		return type;
	}

	public float getWeight() 
	{
		return weight;
	}
	
	public void setParts(ArrayList<Part> parts){
		this.parts = parts;
	}
	
	public ArrayList<Part> getParts(){
		return parts;
	}
	
}
