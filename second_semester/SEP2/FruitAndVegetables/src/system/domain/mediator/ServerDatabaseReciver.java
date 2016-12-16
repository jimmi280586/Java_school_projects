package src.system.domain.mediator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import src.system.database.DBPersistence;
import src.system.database.DatabaseAdaptor;
import src.system.domain.model.Category;
import src.system.domain.model.Food;
import src.system.domain.model.FoodCollection;

/**
 * The Class ServerDatabaseReciver.
 */
public class ServerDatabaseReciver
{
	private ServerModelManager modelManager;
	private String msg;	
	private ArrayList<Category> k = new ArrayList<>();	
	private DBPersistence DB = new DatabaseAdaptor();	
	private FoodCollection d = new FoodCollection();
	private int Id = 5; 

	/**
	 * Instantiates a new server database receiver.
	 */
	public ServerDatabaseReciver(){}
	
	/**
	 * Instantiates a new server database receiver.
	 *
	 * @param model the model
	 */
	public ServerDatabaseReciver(ServerModelManager model)
	{
		this.modelManager = model;		
	}
	
	/**
	 * Execute uses the information from the client to connect to the database
	 * and getting the right information or changing the right information in the database.
	 *
	 * @param msg the msg
	 * @return the string
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String execute(String msg) throws SQLException, IOException
	{
		this.msg = msg;	
		String[] c = msg.split("/");
		this.k = DB.load();	
		
		for (int i = 0; i < k.size(); i++) {
			d.addNewCategory(this.k.get(i));
		}	
		System.out.println(msg);
		String returnmsg = "Could not find desired information please try again! If error continues please contact IT support.";
		switch (c[0])
		{
		case "Search":
		{			
			for (int i = 0; i < this.d.getMainCategories().size(); i++)
			{
				System.out.println(this.d.getMainCategories().get(i).getCategoryName());
				if(this.d.getMainCategories().get(i).getCategoryName().equalsIgnoreCase(c[1]))
				{					
					returnmsg = this.d.getMainCategories().get(i).toString();
				}
				for (int j = 0; j < this.d.getMainCategories().get(i).getSubCategory().size(); j++)
				{
					if(this.d.getMainCategories().get(i).getSubCategory().get(j).getName().equalsIgnoreCase(c[1]))
					{						
						returnmsg = this.d.getMainCategories().get(i).getSubCategory().get(j).toString();
					}
					for (int j2 = 0; j2 < this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().size(); j2++) 
					{
						if(this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).getName().equalsIgnoreCase(c[1]))
						{							
							returnmsg = this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).toString();
						}
					}
				}
			}
			return returnmsg;
			
		}
		
		case "Compare":
		{
			for (int i = 0; i < this.d.getMainCategories().size(); i++)
			{
				if(this.d.getMainCategories().get(i).getCategoryName().equalsIgnoreCase(c[1]))
				{
					returnmsg = this.d.getMainCategories().get(i) + "/%";
				}
				for (int j = 0; j < this.d.getMainCategories().get(i).getSubCategory().size(); j++)
				{
					if(this.d.getMainCategories().get(i).getSubCategory().get(j).getName().equalsIgnoreCase(c[1]))
					{
						returnmsg = this.d.getMainCategories().get(i).getSubCategory().get(j) + "/%";
					}
					for (int j2 = 0; j2 < this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().size(); j2++) 
					{
						if(this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).getName().equalsIgnoreCase(c[1]))
						{
							returnmsg = this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2) + "/%";
						}
					}
				}
			}
			
			
			for (int i = 0; i < this.d.getMainCategories().size(); i++)
			{
				if(this.d.getMainCategories().get(i).getCategoryName().equalsIgnoreCase(c[2]))
				{
					returnmsg += this.d.getMainCategories().get(i) + "/%";
				}
				for (int j = 0; j < this.d.getMainCategories().get(i).getSubCategory().size(); j++)
				{
					if(this.d.getMainCategories().get(i).getSubCategory().get(j).getName().equalsIgnoreCase(c[2]))
					{
						returnmsg += this.d.getMainCategories().get(i).getSubCategory().get(j) + "/%";
					}
					for (int j2 = 0; j2 < this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().size(); j2++) 
					{
						if(this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).getName().equalsIgnoreCase(c[2]))
						{
							returnmsg += this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2) + "/%";
						}
					}
				}
			}
			return returnmsg;
		}
		case "Update":
		{
			for (int i = 0; i < this.d.getMainCategories().size(); i++)
			{				
				if(this.d.getMainCategories().get(i).getCategoryName().equalsIgnoreCase(c[1]))
				{
					d.getMainCategories().get(i).setCategoryName(c[2]);
				}
				for (int j = 0; j < this.d.getMainCategories().get(i).getSubCategory().size(); j++)
				{
					if(this.d.getMainCategories().get(i).getSubCategory().get(j).getName().equalsIgnoreCase(c[1]))
					{
						d.getMainCategories().get(i).getSubCategory().get(j).setName(c[2]);						
					}
					for (int j2 = 0; j2 < this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().size(); j2++) 
					{
						if(this.d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).getName().equalsIgnoreCase(c[1]))
						{							
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setName(c[2]);
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setSecondName(c[8]);;
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setOriginCountryName(c[9]);
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setCookingtime(Double.parseDouble(c[5]));
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setCountryCode(c[10]);
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setGrowingEnd(c[7]);
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setGrowingStart(c[6]);
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setHistory(c[3]);
							d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).setTast(c[4]);							
						}
					}
				}
			}			
			try {
				DB.updateCollection(d);
				returnmsg = "Database updated";
			} catch (SQLException e) {
				returnmsg = "unable to update Database return please contact it support";
				
			}
			return returnmsg;
		}
		case "Add":
		{
			Food a;		
			
			for (int i = 0; i < d.getMainCategories().get(0).getSubCategory().size(); i++) 
			{
				if(d.getMainCategories().get(0).getSubCategory().get(i).getName().equalsIgnoreCase(c[1]))
				{
					if(d.getMainCategories().get(0).getSubCategory().get(i).getFoods().size() == 0)
					{
						String name = c[2];
						int barcode = 0;
						String history = c[3];
						String taste = c[4];
						double cookingtime = Double.parseDouble(c[5]);
						String growingStart = c[6];
						String growingEnd = c[7];
						String SecondName = c[8];
						String originCountryName = c[9];
						String CountryCode = c[10];
						int id1 = DB.lastBarcode();
						int id = ++id1;
						int subId1 = d.getMainCategories().get(0).getSubCategory().get(i).getid();
						a = new Food(name, barcode, history, taste, cookingtime, growingStart, growingEnd, SecondName, originCountryName, subId1, CountryCode, id, id, id, id);
						try {
							DB.saveFood(a);
							returnmsg = "Food Item succesfuly added to Database";
						} catch (Exception e) {
							returnmsg = "unable to add food element please contact it support";
						}
					}
					else
					{
					for (int j = 0; j < d.getMainCategories().get(0).getSubCategory().get(i).getFoods().size(); j++)
					{										
						if(d.getMainCategories().get(0).getSubCategory().get(i).getFoods().get(j).getName().equalsIgnoreCase(c[2]))
						{							
							returnmsg = "Food item already exists consider updating";
						}
						String name = c[2];
						int barcode = 0;
						String history = c[3];
						String taste = c[4];
						double cookingtime = Double.parseDouble(c[5]);
						String growingStart = c[6];
						String growingEnd = c[7];
						String SecondName = c[8];
						String originCountryName = c[9];
						String CountryCode = c[10];
						int id1 = DB.lastBarcode();
						int id = ++id1;
						int subId1 = d.getMainCategories().get(0).getSubCategory().get(i).getid();
						a = new Food(name, barcode, history, taste, cookingtime, growingStart, growingEnd, SecondName, originCountryName, subId1, CountryCode, id, id, id, id);
						try {
							DB.saveFood(a);
							returnmsg = "Food Item succesfuly added to Database";
						} catch (Exception e) {
							returnmsg = "unable to add food element please contact it support";
						}
						
					}
					}
				}
			}
			
			return returnmsg;
		}
		
		case "Remove":
		{
			for (int i = 0; i < d.getMainCategories().size(); i++) 
			{
				if((d.getMainCategories().get(i).getCategoryName().equalsIgnoreCase(c[1])) )
						{
							try {
								DB.removeCategory(d.getMainCategories().get(i));
								returnmsg = "Category removed";
							} catch (Exception e) {
								returnmsg = "Category is not empty please remove subCategories first";
							}
						}
								
				for (int j = 0; j < d.getMainCategories().get(i).getSubCategory().size(); j++) 
				{
					if((d.getMainCategories().get(i).getSubCategory().get(j).getName().equalsIgnoreCase(c[1])))						
							{
								try {
									DB.removeSubCategory(d.getMainCategories().get(i).getSubCategory().get(j));
									returnmsg = "SubCategory removed";
								} catch (Exception e) {
									returnmsg = "subCategory is not empty please remove foods first";
								}
							}
					
					for (int j2 = 0; j2 < d.getMainCategories().get(i).getSubCategory().get(j).getFoods().size(); j2++) 
					{
						if(d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2).getName().equalsIgnoreCase(c[1]))
								{
									try {
										DB.removeFood(d.getMainCategories().get(i).getSubCategory().get(j).getFoods().get(j2));
										returnmsg = "food element removed";
									} catch (Exception e) {
										returnmsg = "unable to remove food element please contact it support";
									}
								}
											
					}
				}
			}
			
		}
		return returnmsg;
	}
		return returnmsg;		
	}
}
