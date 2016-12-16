package src.system.domain.model;

import java.io.IOException;
import java.util.ArrayList;

import src.system.database.DBPersistence;
import src.system.database.DatabaseAdaptor;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodCollection stores category objects in ArrayList.
 */
public class FoodCollection {

	private ArrayList<Category> mainCategories;

	private DBPersistence DB = new DatabaseAdaptor();

	/**
	 * Instantiates a new food collection and creates an empty arraylist for later use.
	 */
	public FoodCollection() {
		this.mainCategories = new ArrayList<>();
	}

	public ArrayList<Category> getMainCategories() {
		return mainCategories;
	}

	public void setMainCategories(ArrayList<Category> mainCategories) {
		this.mainCategories = mainCategories;
	}

	/**
	 * Adds the new category to the created list.
	 *
	 * @param category
	 *           
	 */
	public void addNewCategory(Category category) {
		this.mainCategories.add(category);
	}

	/**
	 * Loads a collection from the database into the collection.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void load() throws IOException {
		this.mainCategories = DB.load();
	}

	/**
	 * Saves the collection to the database .
	 * @throws IOException 
	 */
	public void save() throws IOException {
		
			DB.saveCollection(this);
		
	}
	public void remove(Category category)
	{
		mainCategories.remove(category);
	}



	public void remove(Food food) {
		// TODO Auto-generated method stub
		
	}

}
