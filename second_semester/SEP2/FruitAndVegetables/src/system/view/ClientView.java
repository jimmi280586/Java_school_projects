package src.system.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import src.system.database.DBPersistence;
import src.system.database.DatabaseAdaptor;
import src.system.domain.model.Category;
import src.system.domain.model.Food;
import src.system.domain.model.FoodCollection;
import src.system.domain.model.SubCategory;
import src.system.gui.LogIn;
import src.system.utill.HardCategoryMethod;
import src.system.utill.HardFoodMethod;
import src.system.utill.HardSubCategoryMethod;

/**
 * The Class ClientView is only for starting the Grafical user interface.
 */
public class ClientView
{
	private static DBPersistence d = new DatabaseAdaptor();	
	private static HardCategoryMethod cat = new HardCategoryMethod();	
	private static HardSubCategoryMethod subs = new HardSubCategoryMethod();
	private static HardFoodMethod fod;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException 
	{
		testcreateDb(); //only for testing
		testsavecollection(); // only for testing
		
		JFrame login = new LogIn();
		login.setVisible(true);

	}
	/*
	 * everything frmo here and down is only used for testing purpose will not be in the compleate program 
	 */
	private static void testsavecollection() throws IOException
	{
		FoodCollection b = new FoodCollection();
		
		ArrayList<Category> s = getCategory(); 

		ArrayList<SubCategory> s1 = getSubCategory();
		ArrayList<Food> s2 = getFoods(1);

		for (int i = 0; i < s.size(); i++) 
		{
			for (int j = 0; j < s1.size(); j++)	
			{
				if (s1.get(j).getCatID() == (s.get(i).getId() + 1))					
				{
					for (int j2 = 0; j2 < s2.size(); j2++) 
					{
						if (s1.get(j).getid() == (s2.get(j2).getSubId())) 							
						{
							s1.get(j).addNewFood(s2.get(j2));			
						}
					}
					s.get(i).addNewSubCategory(s1.get(j)); 
				}
			}
			b.addNewCategory(s.get(i));
		}
		d.saveCollection(b);
	}
	
	private static void testcreateDb()
	{
		d.CreateDatabase();
	}

	private static ArrayList<Category> getCategory() {
		ArrayList<Category> list = cat.createHardCategory();
		return list;
	}

	private static ArrayList<SubCategory> getSubCategory() {
		ArrayList<SubCategory> sublist = subs.createHardSubCategory();
		return sublist;
	}

	private static ArrayList<Food> getFoods(int subId) {
		fod = new HardFoodMethod();
		ArrayList<Food> foodlist = fod.createHardFoods(subId);
		return foodlist;
	}
}
