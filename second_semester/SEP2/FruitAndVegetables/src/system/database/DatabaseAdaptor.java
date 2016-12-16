package src.system.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import src.system.domain.model.Category;
import src.system.domain.model.Food;
import src.system.domain.model.FoodCollection;
import src.system.domain.model.SubCategory;

/**
 * The Class DatabaseAdaptor contains all implementation of methods from DBPersistance interface.
 */
public class DatabaseAdaptor implements DBPersistence {
	
	
	private final String DB_NAME = "FruitAndVegetables";	
	private MyDatabase database;

	/**
	 * Instantiates a new database adaptor for connecting to the database using the right sql commands.
	 */
	public DatabaseAdaptor() {
		try {
			database = new MyDatabase(DB_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#load()
	 */
	@Override
	public ArrayList<Category> load() throws IOException {
		ArrayList<Food> foods = new ArrayList<>();
		ArrayList<SubCategory> sub = new ArrayList<>();
		ArrayList<Category> cat = new ArrayList<>();

		String sqlSub = "SELECT * FROM SubCategory;";

		String sqlCat = "SELECT * FROM Category;";

		String sqlfood = "SELECT * FROM Food;";

		try {

			ArrayList<Object[]> results = database.query(sqlfood);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int barcode = Integer.parseInt(row[0].toString());
				int subId = Integer.parseInt(row[1].toString());
				String name = row[2].toString();
				int secondNameId = Integer.parseInt(row[3].toString());
				int infoId = Integer.parseInt(row[4].toString());
				;
				double cookingtime = Double.parseDouble(row[5].toString());
				int originCountry = Integer.parseInt(row[6].toString());
				int growingPeriod = Integer.parseInt(row[7].toString());

				String sqlHistory = "SELECT Info.History FROM `Info` "
						+ "WHERE InfoID = (SELECT InfoID FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = " + barcode
						+ " AND GrowingPeriod = " + growingPeriod + " "
						+ "AND InfoID = " + infoId + " " + "AND Name2 = "
						+ secondNameId + " " + "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String sqlTaste = "SELECT Info.Taste FROM `Info` "
						+ "WHERE InfoID = (SELECT InfoID FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = " + barcode
						+ " AND GrowingPeriod = " + growingPeriod + " "
						+ "AND InfoID = " + infoId + " " + "AND Name2 = "
						+ secondNameId + " " + "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String sqlGrowingStart = "SELECT GrowingPeriods.StartMonth FROM `GrowingPeriods` "
						+ "WHERE GrowingPeriods.ID = (SELECT GrowingPeriod FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = "
						+ barcode
						+ " AND GrowingPeriod = "
						+ growingPeriod
						+ " "
						+ "AND InfoID = "
						+ infoId
						+ " "
						+ "AND Name2 = "
						+ secondNameId
						+ " "
						+ "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String sqlGrowingEnd = "SELECT GrowingPeriods.EndMonth FROM `GrowingPeriods` "
						+ "WHERE GrowingPeriods.ID = (SELECT GrowingPeriod FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = "
						+ barcode
						+ " AND GrowingPeriod = "
						+ growingPeriod
						+ " "
						+ "AND InfoID = "
						+ infoId
						+ " "
						+ "AND Name2 = "
						+ secondNameId
						+ " "
						+ "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String sqlOriginCountryName = "SELECT Country.CountryName FROM `Country` "
						+ "WHERE CountryID = (SELECT OriginCountry FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = "
						+ barcode
						+ " AND GrowingPeriod = "
						+ growingPeriod
						+ " "
						+ "AND InfoID = "
						+ infoId
						+ " "
						+ "AND Name2 = "
						+ secondNameId
						+ " "
						+ "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String sqlCountryCode = "SELECT Country.CountryCode FROM `Country` "
						+ "WHERE CountryID = (SELECT OriginCountry FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = "
						+ barcode
						+ " AND GrowingPeriod = "
						+ growingPeriod
						+ " "
						+ "AND InfoID = "
						+ infoId
						+ " "
						+ "AND Name2 = "
						+ secondNameId
						+ " "
						+ "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String sqlSecondName = "SELECT Name.Name FROM `Name` "
						+ "WHERE Name.ID = (SELECT Name2 FROM `food` "
						+ "USE INDEX (barcode, GrowingPeriod, InfoID, Name2, OriginCountry, SubId) "
						+ "WHERE barcode = " + barcode
						+ " AND GrowingPeriod = " + growingPeriod + " "
						+ "AND InfoID = " + infoId + " " + "AND Name2 = "
						+ secondNameId + " " + "AND OriginCountry = "
						+ originCountry + " AND SubId = " + subId + " );";

				String history = database.queryString(sqlHistory);

				String taste = database.queryString(sqlTaste);

				String growingStart = database.queryString(sqlGrowingStart);

				String growingEnd = database.queryString(sqlGrowingEnd);

				String originCountryName = database
						.queryString(sqlOriginCountryName);

				String countryCode = database.queryString(sqlCountryCode);

				String secondName = database.queryString(sqlSecondName);

				Food food = new Food(name, barcode, history, taste,
						cookingtime, growingStart, growingEnd, secondName,
						originCountryName, subId, countryCode, originCountry,
						secondNameId, infoId, growingPeriod);
				foods.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			ArrayList<Object[]> subs = database.query(sqlSub);
			for (int i = 0; i < subs.size(); i++) {
				Object[] row = subs.get(i);
				int subID = Integer.parseInt(row[0].toString());
				String name = row[1].toString();
				int catID = Integer.parseInt(row[2].toString());
				ArrayList<Food> a = new ArrayList<>();
				for (int j = 0; j < foods.size(); j++) {
					if (foods.get(j).getSubId() == subID)
						a.add(foods.get(j));
				}

				SubCategory sub1 = new SubCategory(name, subID, a, catID);
				sub.add(sub1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			ArrayList<Object[]> cats = database.query(sqlCat);
			for (int i = 0; i < cats.size(); i++) {
				Object[] row = cats.get(i);
				int ID = Integer.parseInt(row[0].toString());
				String name = row[1].toString();
				ArrayList<SubCategory> a = new ArrayList<>();
				for (int j = 0; j < sub.size(); j++) {
					if (sub.get(j).getCatID() == ID)
						a.add(sub.get(j));
				}

				Category cat1 = new Category(name, a, ID);
				cat.add(cat1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cat;
	}
	
	public int lastBarcode() throws SQLException
	{
		String sql = "SELECT MAX(`barcode`) AS `barcode` FROM `food`;";
		ArrayList<Object[]> code = database.query(sql);
		Object[] row = code.get(0);
		int ID = Integer.parseInt(row[0].toString());
		return ID;			
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#saveAll(src.system.domain.model.
	 * FoodCollection)
	 */
	@Override
	public void saveCollection(FoodCollection Collection) throws IOException {
		String sql;
		FoodCollection list = Collection;
		ArrayList<Category> cat = list.getMainCategories();
		

		for (int i = 0; i < list.getMainCategories().size(); i++) {
			sql = "INSERT INTO `category`(`Name`) VALUES ("
					+ list.getMainCategories().get(i).getCategoryName() + ");";

			try {
				database.update(sql);
			} catch (SQLException e) {
				System.out.println("unable to add to database");
				e.printStackTrace();
			}
		}

		for (int i = 0; i < cat.size(); i++) {
			for (int j = 0; j < cat.get(i).getSubCategory().size(); j++) {

				sql = "INSERT INTO `subcategory`(`Name`, `CategoryID`) VALUES"
						+ " (" + cat.get(i).getSubCategory().get(j).getName()
						+ "," + ""
						+ cat.get(i).getSubCategory().get(j).getCatID() + ""
						+ ");";

				try {
					database.update(sql);
				} catch (SQLException e) {
					System.out.println("unable to add to database");
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < cat.size(); i++) {
			for (int j = 0; j < cat.get(i).getSubCategory().size(); j++) {
				for (int j2 = 0; j2 < cat.get(i).getSubCategory().get(j)
						.getFoods().size(); j2++) {
					String sql1 = "INSERT INTO `country`(`CountryCode`, `CountryName`) VALUES"
							+ " ("
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getCountryCode()
							+ ","
							+ ""
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getOriginCountryName() + "" + ");";

					String sql2 = "INSERT INTO `name`(`name`, `CountryID`) VALUES"
							+ " ("
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getSecondName()
							+ ","
							+ ""
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getCountryId() + "" + ");";

					String sql3 = "INSERT INTO `GrowingPeriods`(`StartMonth`, `EndMonth`) VALUES"
							+ " ("
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getGrowingStart()
							+ ","
							+ ""
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getGrowingEnd() + "" + ");";

					String sql4 = "INSERT INTO `Info`(`Taste`, `History`) VALUES"
							+ " ("
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getTast()
							+ ","
							+ ""
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getHistory() + "" + ");";

					String sql5 = "INSERT INTO `Food`(`barcode`, `SubId`, `Name`, `name2`, `InfoID`, `CookingTime`, `OriginCountry`, `GrowingPeriod`) VALUES"
							+ " ("
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getBarcode()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getSubId()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getName()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getSecondNameId()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getInfoId()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getCookingtime()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getCountryId()
							+ ","
							+ cat.get(i).getSubCategory().get(j).getFoods()
									.get(j2).getGrowingPeriodId() + ");";

					try {

						database.update(sql1);
						database.update(sql2);
						database.update(sql3);
						database.update(sql4);
						database.update(sql5);
					} catch (SQLException e) {
						System.out.println("unable to add to database");
						e.printStackTrace();
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see src.system.database.DBPersistence#saveCategory(src.system.domain.model.Category)
	 */
	@Override
	public void saveCategory(Category category) throws IOException {
		String sql;
		
			sql = "INSERT INTO `category`(`Name`) VALUES ("
					+ category.getCategoryName() + ");";

			try {
				database.update(sql);
			} catch (SQLException e) {
				System.out.println("unable to add to database");
				e.printStackTrace();
			}
			
			for (int j = 0; j < category.getSubCategory().size(); j++) {

				sql = "INSERT INTO `subcategory`(`Name`, `CategoryID`) VALUES"
						+ " (" + category.getSubCategory().get(j).getName()
						+ "," + ""
						+ category.getSubCategory().get(j).getCatID() + ""
						+ ");";

				try {
					database.update(sql);
				} catch (SQLException e) {
					System.out.println("unable to add to database");
					e.printStackTrace();
				}
			}
		
			for (int j = 0; j < category.getSubCategory().size(); j++) {
				for (int j2 = 0; j2 < category.getSubCategory().get(j)
						.getFoods().size(); j2++) {
					String sql1 = "INSERT INTO `country`(`CountryCode`, `CountryName`) VALUES"
							+ " ("
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getCountryCode()
							+ ","
							+ ""
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getOriginCountryName() + "" + ");";

					String sql2 = "INSERT INTO `name`(`name`, `CountryID`) VALUES"
							+ " ("
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getSecondName()
							+ ","
							+ ""
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getCountryId() + "" + ");";

					String sql3 = "INSERT INTO `GrowingPeriods`(`StartMonth`, `EndMonth`) VALUES"
							+ " ("
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getGrowingStart()
							+ ","
							+ ""
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getGrowingEnd() + "" + ");";

					String sql4 = "INSERT INTO `Info`(`Taste`, `History`) VALUES"
							+ " ("
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getTast()
							+ ","
							+ ""
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getHistory() + "" + ");";

					String sql5 = "INSERT INTO `Food`(`barcode`, `SubId`, `Name`, `name2`, `InfoID`, `CookingTime`, `OriginCountry`, `GrowingPeriod`) VALUES"
							+ " ("
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getBarcode()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getSubId()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getName()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getSecondNameId()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getInfoId()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getCookingtime()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getCountryId()
							+ ","
							+ category.getSubCategory().get(j).getFoods()
									.get(j2).getGrowingPeriodId() + ");";

					try {

						database.update(sql1);
						database.update(sql2);
						database.update(sql3);
						database.update(sql4);
						database.update(sql5);
					} catch (SQLException e) {
						System.out.println("unable to add to database");
						e.printStackTrace();
					}
				}
			}
		}	

	/* (non-Javadoc)
	 * @see src.system.database.DBPersistence#saveSubCategory(src.system.domain.model.SubCategory)
	 */
	@Override
	public void saveSubCategory(SubCategory subcategory) throws IOException 
	{
		String sql;

			sql = "INSERT INTO `subcategory`(`Name`, `CategoryID`) VALUES"
					+ " (" + subcategory.getName()
					+ "," + ""
					+ subcategory.getCatID() + ""
					+ ");";

			try {
				database.update(sql);
			} catch (SQLException e) {
				System.out.println("unable to add to database");
				e.printStackTrace();
			}
			
			for (int j2 = 0; j2 < subcategory.getFoods().size(); j2++) 
			{
				String sql1 = "INSERT INTO `country`(`CountryCode`, `CountryName`) VALUES"
						+ " ("
						+ subcategory.getFoods()
								.get(j2).getCountryCode()
						+ ","
						+ ""
						+ subcategory.getFoods()
								.get(j2).getOriginCountryName() + "" + ");";

				String sql2 = "INSERT INTO `name`(`name`, `CountryID`) VALUES"
						+ " ("
						+ subcategory.getFoods()
								.get(j2).getSecondName()
						+ ","
						+ ""
						+ subcategory.getFoods()
								.get(j2).getCountryId() + "" + ");";

				String sql3 = "INSERT INTO `GrowingPeriods`(`StartMonth`, `EndMonth`) VALUES"
						+ " ("
						+ subcategory.getFoods()
								.get(j2).getGrowingStart()
						+ ","
						+ ""
						+ subcategory.getFoods()
								.get(j2).getGrowingEnd() + "" + ");";

				String sql4 = "INSERT INTO `Info`(`Taste`, `History`) VALUES"
						+ " ("
						+ subcategory.getFoods()
								.get(j2).getTast()
						+ ","
						+ ""
						+ subcategory.getFoods()
								.get(j2).getHistory() + "" + ");";

				String sql5 = "INSERT INTO `Food`(`barcode`, `SubId`, `Name`, `name2`, `InfoID`, `CookingTime`, `OriginCountry`, `GrowingPeriod`) VALUES"
						+ " ("
						+ subcategory.getFoods()
								.get(j2).getBarcode()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getSubId()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getName()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getSecondNameId()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getInfoId()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getCookingtime()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getCountryId()
						+ ","
						+ subcategory.getFoods()
								.get(j2).getGrowingPeriodId() + ");";

				try {

					database.update(sql1);
					database.update(sql2);
					database.update(sql3);
					database.update(sql4);
					database.update(sql5);
				} catch (SQLException e) {
					System.out.println("unable to add to database");
					e.printStackTrace();
				}
			}
		}	

	/* (non-Javadoc)
	 * @see src.system.database.DBPersistence#saveFood(src.system.domain.model.Food)
	 */
	@Override
	public void saveFood(Food food) throws IOException 
	{
		String sql1 = "INSERT INTO `country`(`CountryCode`, `CountryName`) VALUES"
				+ " ('"
				+ food.getCountryCode()
				+ "',"
				+ "'"
				+ food.getOriginCountryName() + "'" + ");";

		String sql2 = "INSERT INTO `name`(`name`, `CountryID`) VALUES"
				+ " ('"
				+ food.getSecondName()
				+ "',"
				+ ""
				+ food.getCountryId() + "" + ");";

		String sql3 = "INSERT INTO `GrowingPeriods`(`StartMonth`, `EndMonth`) VALUES"
				+ " ('"
				+ food.getGrowingStart()
				+ "','"
				+ ""
				+ food.getGrowingEnd() + "'" + ");";

		String sql4 = "INSERT INTO `Info`(`Taste`, `History`) VALUES"
				+ " ('"
				+ food.getTast()
				+ "',"
				+ "'"
				+ food.getHistory() + "'" + ");";

		String sql5 = "INSERT INTO `Food`(`barcode`, `SubId`, `Name`, `name2`, `InfoID`, `CookingTime`, `OriginCountry`, `GrowingPeriod`) VALUES"
				+ " ("
				+ food.getBarcode()
				+ ","
				+ food.getSubId()
				+ ",'"
				+ food.getName()
				+ "',"
				+ food.getSecondNameId()
				+ ","
				+ food.getInfoId()
				+ ","
				+ food.getCookingtime()
				+ ","
				+ food.getCountryId()
				+ ","
				+ food.getGrowingPeriodId() + ");";

		try {

			database.update(sql1);
			database.update(sql2);
			database.update(sql3);
			database.update(sql4);
			database.update(sql5);
		} catch (SQLException e) {
			System.out.println("unable to add to database");
			e.printStackTrace();
		}		
	}

	/* (non-Javadoc)
	 * @see src.system.database.DBPersistence#updateCollection(src.system.domain.model.FoodCollection)
	 */
	@Override
	public void updateCollection(FoodCollection collection) throws SQLException 
	{
		
		ArrayList<String> sql1 = new ArrayList<>();
		String sql;
		FoodCollection list = collection;
		ArrayList<Category> cat = list.getMainCategories();
		

		for (int i = 0; i < list.getMainCategories().size(); i++) {
			sql = "UPDATE `category` SET `Name`= '" + list.getMainCategories().get(i).getCategoryName() 
					+ "' WHERE `CategoryID` = " + list.getMainCategories().get(i).getId() + ";";
			sql1.add(sql);
					
		}

		for (int i = 0; i < cat.size(); i++) {
			for (int j = 0; j < cat.get(i).getSubCategory().size(); j++) {

				sql = "UPDATE `subcategory` SET `Name` = '" + cat.get(i).getSubCategory().get(j).getName() + "', `CategoryID` = " 
				+ cat.get(i).getSubCategory().get(j).getCatID() + " WHERE `SubCategoryID` = " + cat.get(i).getSubCategory().get(j).getid() + ";";
				
				sql1.add(sql);
			
			}
		}

		for (int i = 0; i < cat.size(); i++)
		{
			for (int j = 0; j < cat.get(i).getSubCategory().size(); j++)
			{
				for (int j2 = 0; j2 < cat.get(i).getSubCategory().get(j).getFoods().size(); j2++)
				{
					sql = "UPDATE `country` SET `CountryCode` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getCountryCode() 
							+ "', `CountryName` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getOriginCountryName() 
							+ "' WHERE `CountryID` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getCountryId() + ";";
					
					sql1.add(sql);

					sql = "UPDATE `Name` SET `name` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getSecondName() 
							+ "', `CountryId` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getCountryId() 
							+ "' WHERE `ID` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getSecondNameId() + ";";
					
					sql1.add(sql);

					sql = "UPDATE `GrowingPeriods` SET `StartMonth` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getGrowingStart() 
							+ "', `EndMonth` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getGrowingEnd() 
							+ "' WHERE `ID` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getGrowingPeriodId() + ";";
					
					sql1.add(sql);

					sql = "UPDATE `Info` SET `History` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getHistory() 
							+ "', `Taste` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getTast() 
							+ "' WHERE `InfoID` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getInfoId() + ";";
					
					sql1.add(sql);

					sql = "UPDATE `Food` SET `SubId` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getSubId()  
							+ ", `Name` = '" + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getName()  
							+ "', `name2` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getSecondNameId()  
							+ ", `InfoID` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getInfoId()  
							+ ", `CookingTime` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getCookingtime()  
							+ ", `OriginCountry` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getCountryId()  
							+ ", `GrowingPeriod` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getGrowingPeriodId()
							+ " WHERE `barcode` = " + cat.get(i).getSubCategory().get(j).getFoods().get(j2).getBarcode() + ";";
									
						sql1.add(sql);
						database.updateAll(sql1);					
				}
			}
		}		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * src.system.database.DBPersistence#removeCategory(src.system.domain.model
	 * .Category)
	 */
	@Override
	public void removeCategory(Category category) throws IOException {
		Category c = category;
		int Id = c.getId();

		String sql = "DELETE FROM category WHERE categoryID = " + Id + ";";
		try {
			database.update(sql);
			System.out.println("Category removed");
		} catch (SQLException e) {
			System.out.println("Category is not empty please remove subCategories first");
			throw new IOException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 *  
	 * @see
	 * src.system.database.DBPersistence#removeSubCategory(src.system.domain
	 * .model.SubCategory)
	 */
	@Override
	public void removeSubCategory(SubCategory subCategory) throws IOException {
		SubCategory c = subCategory;
		int Id = c.getid();

		String sql = "DELETE FROM subCategory WHERE SubCategoryID = " + Id + ";";
		System.out.println(sql);
		try {
			database.update(sql);
			System.out.println("SubCategory removed");
		} catch (SQLException e) {
			System.out.println("subCategory is not empty please remove foods first");
			throw new IOException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * src.system.database.DBPersistence#removeFood(src.system.domain.model.
	 * Food)
	 */
	@Override
	public void removeFood(Food food) throws IOException, SQLException {
		Food c = food;		
		ArrayList<String> sqls = new ArrayList<>();
		String sql;
		
			sql	= "  DELETE FROM `food` WHERE barcode = " + c.getBarcode() + ";";
			sqls.add(sql);
			sql = " DELETE FROM `info` WHERE `InfoID` = " + c.getBarcode() + ";";
			sqls.add(sql);
			sql	= "  DELETE FROM `Name` WHERE `ID` = " + c.getBarcode() + ";";			
			sqls.add(sql);
			sql	= "  DELETE FROM `Country` WHERE `CountryID` = " + c.getBarcode() + ";";
			sqls.add(sql);
			sql	= "  DELETE FROM `GrowingPeriods` WHERE `ID` = " + c.getBarcode() + ";";
			sqls.add(sql);
		
			for (int i = 0; i < sqls.size(); i++)
			{
				System.out.println(sqls.get(i));
			}			
			database.updateAll(sqls);
			System.out.println("removed");		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#clearFoodCollection()
	 */
	@Override
	public void clearDatabase() throws IOException {
		String sql;
		
		sql = "SET FOREIGN_KEY_CHECKS = 0; TRUNCATE `Category`;"
				+ " SET FOREIGN_KEY_CHECKS = 0; TRUNCATE `SubCategory`;"
				+ " SET FOREIGN_KEY_CHECKS = 0;  TRUNCATE `Info`;"
				+ " SET FOREIGN_KEY_CHECKS = 0; TRUNCATE `Name`;"
				+ " SET FOREIGN_KEY_CHECKS = 0;  TRUNCATE `Country`;"
				+ " SET FOREIGN_KEY_CHECKS = 0; TRUNCATE `GrowingPeriods`;"
				+ " SET FOREIGN_KEY_CHECKS = 0; TRUNCATE `Food`;"
				+ " SET FOREIGN_KEY_CHECKS = 1;";
		
		System.out.println(sql);
		
		try {
			database.update(sql);
		
		} catch (SQLException e)
		{

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#clearCategory()
	 */
	@Override
	public void clearCategory() throws IOException {
		String sql = "SET FOREIGN_KEY_CHECKS=0; TRUNCATE `Category`;"
				+ " SET FOREIGN_KEY_CHECKS=1;";		
		try {
			database.update(sql);
		
		} catch (SQLException e)
		{

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#clearSubCategory()
	 */
	@Override
	public void clearSubCategory() throws IOException {
		String sql = "SET FOREIGN_KEY_CHECKS=0; TRUNCATE `SubCategory`;"
					+ " SET FOREIGN_KEY_CHECKS=1;";		
		
		try {
			database.update(sql);
		
		} catch (SQLException e)
		{

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#clearFood()
	 */
	@Override
	public void clearFood() throws IOException {
		String sql = "SET FOREIGN_KEY_CHECKS=0;  TRUNCATE `Info`;"
				+ " SET FOREIGN_KEY_CHECKS=0; TRUNCATE `Name`;"
				+ " SET FOREIGN_KEY_CHECKS=0;  TRUNCATE `Country`;"
				+ " SET FOREIGN_KEY_CHECKS=0; TRUNCATE `GrowingPeriods`;"
				+ " SET FOREIGN_KEY_CHECKS=0; TRUNCATE `Food`;"
				+ " SET FOREIGN_KEY_CHECKS=1;";
			
		try {
			database.update(sql);
		
		} catch (SQLException e)
		{

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.system.database.DBPersistence#CreateDatabase()
	 */
	@Override
	public void CreateDatabase() {
		try {
			MyDatabase db = new MyDatabase();
			String sql = "DROP DATABASE FruitAndVegetables;";
			db.update(sql);

			sql = "CREATE DATABASE IF NOT EXISTS FruitAndVegetables";
			db.update(sql);

			db = new MyDatabase("FruitAndVegetables");

			sql = "CREATE TABLE IF NOT EXISTS Country ("
					+ "   CountryID int(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ "	 CountryCode varchar(20) NOT NULL,"
					+ "   CountryName varchar(50) NOT NULL);";
			db.update(sql);

			sql = "CREATE TABLE IF NOT EXISTS Name ("
					+ "   ID int PRIMARY KEY AUTO_INCREMENT,"
					+ "   Name varchar(50) NOT NULL,"
					+ "   CountryID int(20) NOT NULL,"
					+ "   FOREIGN KEY (CountryID) REFERENCES Country(CountryID));";
			db.update(sql);

			sql = "CREATE TABLE IF NOT EXISTS Category ("
					+ "   CategoryID int PRIMARY KEY AUTO_INCREMENT,"
					+ "   Name varchar(50) NOT NULL);";
			db.update(sql);

			sql = "CREATE TABLE IF NOT EXISTS SubCategory ("
					+ "   SubCategoryID int PRIMARY KEY AUTO_INCREMENT,"
					+ "   Name varchar(50) NOT NULL,"
					+ "   CategoryID int,"
					+ "   FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID));";
			db.update(sql);

			sql = "CREATE TABLE IF NOT EXISTS GrowingPeriods ("
					+ "   ID int PRIMARY KEY AUTO_INCREMENT,"
					+ "   StartMonth varchar(30) NOT NULL,"
					+ "   EndMonth varchar(30) NOT NULL);";
			db.update(sql);

			sql = "CREATE TABLE IF NOT EXISTS Info ("
					+ "   InfoID int PRIMARY KEY AUTO_INCREMENT,"
					+ "   Taste text," + "	 History text);";

			db.update(sql);

			sql = "CREATE TABLE IF NOT EXISTS Food ("
					+ "   barcode int PRIMARY KEY AUTO_INCREMENT,"
					+ "	 SubId int NOT NULL,"
					+ "   Name varchar(50) NOT NULL,"
					+ "	 name2 int,"
					+ "   InfoID int NOT NULL,"
					+ "   CookingTime double,"
					+ "   OriginCountry int(20),"
					+ "	 GrowingPeriod int,"
					+ "   FOREIGN KEY (OriginCountry) REFERENCES Country(CountryID),"
					+ "   FOREIGN KEY (InfoID) REFERENCES Info(InfoID),"
					+ "	 FOREIGN KEY (Growingperiod) REFERENCES GrowingPeriods(ID),"
					+ "	 FOREIGN KEY (SubId) REFERENCES SubCategory(SubCategoryID),"
					+ "   FOREIGN KEY (Name2) REFERENCES Name(ID));";
			db.update(sql);

			sql = "ALTER TABLE country ADD INDEX(CountryID);";
			db.update(sql);
			sql = "ALTER TABLE name ADD INDEX(ID);";
			db.update(sql);
			sql = "ALTER TABLE category ADD INDEX(CategoryID);";
			db.update(sql);
			sql = "ALTER TABLE subcategory ADD INDEX(SubCategoryID);";
			db.update(sql);
			sql = "ALTER TABLE growingPeriods ADD INDEX(ID);";
			db.update(sql);
			sql = "ALTER TABLE info ADD INDEX(InfoID);";
			db.update(sql);
			sql = "ALTER TABLE food ADD INDEX(barcode);";
			db.update(sql);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database issue");
			e.printStackTrace();
		}
	}

	/*
	 * implemented but will not be used or testet
	 * 
	 * @see src.system.database.DBPersistence#CreateDatabaseFromFile()
	 */
	/* (non-Javadoc)
	 * @see src.system.database.DBPersistence#CreateDatabaseFromFile()
	 */
	@Override
	public void CreateDatabaseFromFile() {
		final String FILENAME = "fandv.sql";
		int[] updates = null;
		try {
			MyDatabase db = new MyDatabase();
			updates = db.updateAll(FILENAME);
		} catch (FileNotFoundException | SQLException | ClassNotFoundException e) {
			System.out.println("Database issue");
			e.printStackTrace();
		}
		
		int sum = 0;
		for (int i = 0; i < updates.length; i++) {
			sum += updates[i];
		}
		System.out.println("Number of updates: " + sum);
	}
	
	
}
