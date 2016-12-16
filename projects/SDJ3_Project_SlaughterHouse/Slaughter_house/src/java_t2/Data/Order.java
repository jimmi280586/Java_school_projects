package java_t2.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float weight;
	private String orderID;
	private ArrayList<String> trays;
	private String type;
	private int numberOfParts;

	public Order(float weight, String type) {
		this.type = type;
		this.weight = weight;
		numberOfParts = 0;
		orderID = addRanOrderID();
		trays = new ArrayList<String>();
	}

	private String addRanOrderID() {
		Random r = new Random();
		int rand = r.nextInt(20500);

		return "" + rand;
	}

	public String getOrderID() {
		return addRanOrderID();
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getType() {
		return type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int addTrayToList(String trayID) {
		trays.add(trayID);
		numberOfParts++;

		return 0;
	}

	public boolean contains(String trayId) {
		return trays.contains(trayId);
	}

	public String removeTrayFromList(String trayId) {
		if (contains(trayId)) {
			trays.remove((Object) trayId);
			numberOfParts--;
			return " The tray was removed ";
		}

		return "Can not  find the tray.";
	}

	public int getNumberOfParts() {
		return numberOfParts;
	}

	public String getTrayList() {
		return trays.toString();
	}

	public int getTraySize() {
		return trays.size();
	}

	public String getTray(int i) {
		return trays.get(i);
	}

	public String toString() {
		return "ID: " + orderID + "\nWeight: " + weight + "kg" + "\nNumbers of Parts: " + numberOfParts + "\nTrays: "
				+ getTrayList();
	}

}
