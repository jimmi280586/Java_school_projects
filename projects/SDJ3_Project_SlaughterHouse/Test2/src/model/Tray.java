package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tray implements Serializable
{
	private String type;
	private int trayId;
	private float maxWeight;
	private ArrayList<Part> partsId;
	
	public Tray() {
		this("?", 0, 0);
	}
	
	public Tray(String type, int trayId, float maxWeight, ArrayList<Part> partsId) {
		this.type = type;
		this.trayId = trayId;
		this.maxWeight = maxWeight;
		this.partsId = partsId;
	}

	public Tray(String type, int trayId, float maxWeight) {
		this.type = type;
		this.trayId = trayId;
		this.maxWeight = maxWeight;
	}

	public String getType() {
		return this.type;
	}

	public int getTrayId() {
		return this.trayId;
	}

	public float getMaxWeight() {
		return this.maxWeight;
	}
	
	public ArrayList<Part> getParts(){
		return this.partsId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTrayId(int trayId) {

		this.trayId = trayId;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public float getCurrentWeight() {
		float result = 0;
		
		for (int i=0; i < partsId.size(); i++) {
			result += partsId.get(i).getWeight();
		}
		
		return result;
	}

}
