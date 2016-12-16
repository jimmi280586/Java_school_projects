package src.system.database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import src.system.domain.model.Category;
import src.system.domain.model.Food;
import src.system.domain.model.FoodCollection;
import src.system.domain.model.SubCategory;

/**
 * Interface containing all methods for connecting and controlling information
 * in Database. 
 */
public interface DBPersistence {

	/**
	 * the Load method is used for loading all information from the database on the lokalhost
	 * into the desired collection.
	 *
	 * @return the array list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ArrayList<Category> load() throws IOException;
	
	/**
	 * gives you the last barcode added to the database table
	 * @throws SQLException 
	 */
	public int lastBarcode() throws SQLException;
	/**
	 * the Save all method takes a Food collection and saves all information from that collection into the lokalhost
	 * database.
	 *
	 * @param Collection
	 *            the collection is the desired collection whised added to database
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveCollection(FoodCollection Collection) throws IOException;
	
	/**
	 * Method for saving a new collection to the database
	 * will only be used when starting program up the first time
	 * and if you later whant to add some new collection
	 *
	 * @param category the category
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveCategory(Category category) throws IOException;
	
	/**
	 * Method for saving a new subCategory to database
	 *
	 * @param subcategory the subcategory
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveSubCategory(SubCategory subcategory) throws IOException;
	
	/**
	 * Method for saving food to the database
	 *
	 * @param food the food
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveFood(Food food) throws IOException;
	
	/**
	 * Update collection updates the collection in the database.
	 *
	 * @param collection the collection
	 * @throws SQLException the SQL exception
	 */
	public void updateCollection(FoodCollection collection) throws SQLException;

	
	/**
	 * Removes the category object from database on lokalhost.
	 *
	 * @param category            the category is the category object whised removed from database
	 * @throws IOException             Signals that an I/O exception has occurred.
	 * @precondition category can not contain any sub category elements
	 */
	public void removeCategory(Category category) throws IOException;

	/**
	 * Removes the sub category object from database on lokalhost.
	 *
	 * @param subCategory            the sub category is the Sub category object whised removed from database
	 * @throws IOException             Signals that an I/O exception has occurred.
	 * @precondition sub category can not contain any food elements
	 */
	public void removeSubCategory(SubCategory subCategory) throws IOException;

	/**
	 * Removes the food object from database on lokalhost.
	 *
	 * @param food            the food is the Food object whised removed from database
	 * @throws IOException             Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	public void removeFood(Food food) throws IOException, SQLException;

	/**
	 * Clear Database removes all information in all tables from the database.
	 * (this method is implemented but not used in program version 1.0 or tested).
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void clearDatabase() throws IOException; 
	
	/**
	 * Clear category  removes all information from category table.
	 * (this method is implemented but not used in program version 1.0 or tested).
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void clearCategory() throws IOException; 
	
	/**
	 * Clear sub category removes all information from subcategory table.
	 * (this method is implemented but not used in program version 1.0 or tested).
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void clearSubCategory() throws IOException;
	
	/**
	 * Clear food removes all information from all table related to food items.
	 * (this method is implemented but not used in program version 1.0 or tested).
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void clearFood() throws IOException; 

	/**
	 * Drops database and then
	 * Creates the new database if it does not exist and adds all desired tables and keys
	 * on the lokalhost.
	 */
	public void CreateDatabase();

	/**
	 * Creates the database from file,
	 * if it does not exist and adds all desired tables and keys
	 * on the lokalhost..
	 */
	public void CreateDatabaseFromFile();
	
	

}
