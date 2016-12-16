package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Market implements Serializable
{
	private int marketId;
	private String address;
	private  ArrayList<Product> product;
	
	public Market() {
		this(0, "?");
	}
	
	public Market(int marketId, String address, ArrayList<Product> product)
	{
		this.marketId = marketId;
		this.address = address;
		this.product = product;
	}
	public Market(int marketId, String address){
		this.marketId = marketId;
		this.address = address;
		this.product = null;
	}

	public int getMarketId()
	{
		return marketId;
	}

	public String getAddress() 
	{
		return address;
	}	
	
	public void setProducts(ArrayList<Product> product){
		this.product = product;
	}
	
	public ArrayList<Product> getProducts(){
		return product;
	}
	
	
	
}
