package src.system.domain.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class SubCategory stores Food objects in ArrayList.
 */
public class SubCategory {
	
	private int id;
	private String name;
	private ArrayList<Food> foods;
	private int catID;

	/**
	 * Instantiates a new sub category with taking a complete food arraylist.
	 *
	 * @param name
	 *            the name
	 * @param id
	 *            the id
	 * @param foods
	 *            the foods
	 * @param catID
	 *            the cat id
	 */
	public SubCategory(String name, int id, ArrayList<Food> foods, int catID) {
		this.catID = catID;
		this.id = id;
		this.name = name;
		this.foods = foods;
	}

	/**
	 * Instantiates a new sub category without ArrayList of foods.
	 *
	 * @param name
	 *            the name
	 * @param id
	 *            the id
	 * @param subId
	 *            the sub id
	 */
	public SubCategory(String name, int id, int subId) {
		this.id = subId;
		this.catID = id;
		this.name = name;
		this.foods = new ArrayList<>();
	}

	public int getCatID() {
		return this.catID;
	}

	public int getid() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Food> getFoods() {
		return this.foods;
	}

	public Food getFood(int i) {
		return this.foods.get(i);
	}

	public void setCatId(int catID) {
		this.catID = catID;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds the new food object to the created ArrayList.
	 *
	 * @param food
	 *            the food is the object wished added
	 */
	public void addNewFood(Food food) {
		this.foods.add(food);
	}

	/**
	 * Removes the food element from subCategory.
	 *
	 * @param food
	 *            the food is the object whised removed
	 */
	public void removeFood(Food food) 
	{
		for (int i = 0; i < this.foods.size(); i++)
		{
			if (this.foods.get(i).getBarcode() == food.getBarcode())
			{
				this.foods.remove(i);
			}
		}
	}

	/*
	 * String method for printing all information about the Sub category object to a String element
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubCategory " + "id = " + this.id + "," + " /&  /&name = "
				+ this.name + "," + " /&  /&foods = " + this.foods + ","
				+ "/&  /&catID = " + this.catID + " ";
	}

}
