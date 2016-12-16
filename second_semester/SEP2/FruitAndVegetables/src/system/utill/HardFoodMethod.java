package src.system.utill;

import java.util.ArrayList;

import src.system.domain.model.Food;
import src.system.domain.model.SubCategory;

public class HardFoodMethod {
	private static int subCategoryId = 0;

	int b = 1; // 'Apples'
	int c = 2; // 'Citrus'
	int d = 3; // 'Kiwi'
	int e = 4; // 'Avocados'
	int f = 5; // 'Bananas'
	int g = 6; // 'StoneFruit'
	int h = 7; // 'Grapes'
	int i = 8; // 'Pears'
	int j = 9; // 'Pineapple'
	int k = 10; // 'Melons'
	int l = 11; // 'Carrots'
	int m = 12; // 'Oniens'
	int n = 13; // 'Pebers'
	int o = 14; // 'Kale'
	int p = 15; // 'Corn'
	int q = 16; // 'Peas'
	int r = 17; // 'PupkindFamilie'
	int s = 18; // 'Salats'
	int t = 19; // 'Baries'
	int u = 20; // 'Spices'
	int v = 21; // 'Roots'
	int w = 22; // 'Nuts'
	int x = 23; // 'Organic'
	int y = 24; // 'SpecialFruits'
	int z = 25; // 'SpecialVegetables'
	int a1 = 26; // 'Tomatoes'
	int a2 = 27; // 'Potatoes'
	int a3 = 28; // 'Date'
	int a4 = 29; // 'Fig'
	int a5 = 30; // 'Mushrooms

	public HardFoodMethod() {

	}

	/*
	 * method for starting to create hard coded food elements containing to
	 * given sub category id
	 */
	public ArrayList<Food> createHardFoods(int subId) {
		ArrayList<Food> a = new ArrayList<>();
		switch (subId) {
		case 1:
			a = apples(subId);
			return a;
		case 2:
		}
		return null;
	}

	private int secondNameId = 1;
	private int infoId = 1;
	private int growingPeriodId = 1;
	private int countryId = 1;
	private Food food;

	/*
	 * hard coded method for creating food elements for sub category 1 (Apples)
	 */
	private ArrayList<Food> apples(int subId) {
		ArrayList<Food> a = new ArrayList<>();

		String name;
		int barcode;
		String history;
		String taste;
		double cookingtime;
		String growingStart;
		String growingEnd;
		String SecondName;
		String originCountryName;
		String CountryCode;
		int subId1;

		name = "'Granny_Smith'";
		barcode = 0;
		history = "'Granny Smith apples were discovered"
				+ " in Australia in the 1860’s, as a chance seedling"
				+ " in the compost pile on the orchard of Maria Ann Smith."
				+ " Granny Smith apples were first introduced commercially to"
				+ " the United Kingdom in the 1930’s and later to the United States"
				+ " in the 1970’s. They were one of the first varieties of apple widely"
				+ " available in supermarkets as their thick skin and excellent storing"
				+ " qualities made them suitable for shipping. Today Granny Smith apples"
				+ " grow in Australia, Europe, New Zealand, South America and the United States."
				+ " They tend to ripen best in warmer climates where they get a significant amount"
				+ " of sunshine.'";

		taste = "'Granny Smith apples have a bright green"
				+ " skin that is often speckled with faint white"
				+ " lenticels (spots). Medium to large in size and round"
				+ " in shape, they are a firm and juicy apple with thick skin."
				+ " Their flesh is bright white and crisp in texture with a tart,"
				+ " acidic, yet subtly sweet flavor. Granny Smith apples grown in colder"
				+ " climates will often take on a yellow to pink blush.'";

		cookingtime = 0.10;
		growingStart = "'january'";
		growingEnd = "'december'";
		SecondName = "'Granny_Smith'";
		originCountryName = "'Italy'";
		CountryCode = "'IT'";
		subId1 = subId;

		this.food = new Food(name, barcode, history, taste, cookingtime,
				growingStart, growingEnd, SecondName, originCountryName,
				subId1, CountryCode, countryId, secondNameId, infoId,
				growingPeriodId);
		a.add(this.food);

		this.countryId++;
		this.growingPeriodId++;
		this.infoId++;
		this.secondNameId++;

		name = "'Pink_Lady'";
		barcode = 0;
		history = "'Pink Lady apples were developed by a man"
				+ " named John Cripps of Western Australia’s Department of Agriculture."
				+ " They are the result of a cross between Lady Williams and Golden Delicious apples."
				+ " The variety can only be sold as ‘Pink Lady’ if the apple possesses the proper color"
				+ " intensity and has the right sugar vs. acid content. More than half of the season’s"
				+ " crop does not meet those standards and is sold instead as “Cripps Pink.” Pink Lady"
				+ " apples are grown in 15 different countries where the climate is ideal. They are"
				+ " considered to be Australia’s number one apple.'";

		taste = "'Pink Lady apples are elongated and have an asymmetrical shape."
				+ " The skin is a vivid green covered in a pinkish blush which"
				+ " becomes a deeper shade of red where the apple was exposed"
				+ " to more sun. Pink Lady apples have a crunchy texture and"
				+ " a tart taste with a sweet finish. The white flesh is juicy"
				+ " and crisp, and offers a “fizz-like” burst of flavor.'";

		cookingtime = 0.10;
		growingStart = "'june'";
		growingEnd = "'may'";
		SecondName = "'Cripps Pink'";
		originCountryName = "'Italy'";
		CountryCode = "'IT'";
		subId1 = subId;
		

		this.food = new Food(name, barcode, history, taste, cookingtime,
				growingStart, growingEnd, SecondName, originCountryName,
				subId1, CountryCode, countryId, secondNameId, infoId,
				growingPeriodId);
		a.add(this.food);

		this.countryId++;
		this.growingPeriodId++;
		this.infoId++;
		this.secondNameId++;

		name = "'Jonagold'";
		barcode = 0;
		history = "'A fairly new American variety the Jonagold"
				+ " apple was first discovered in 1968 at the New York"
				+ " State Agricultural Experiment Station. Jonagolds require"
				+ " mildly cool growing conditions and are not heat tolerant,"
				+ " something that has prevented them from having any real success"
				+ " as a commercial apple in the United States. They have however been"
				+ " extremely successful in Western Europe, particularly in Belgium where"
				+ " they make up approximately seventy percent of the apples grown and are"
				+ " responsible for making the region one of the leading apple producers in Europe.'";

		taste = "'The skin of the Jonagold apple has an under"
				+ " blush which varies in color from greenish yellow"
				+ " to rosy orange depending on the strain and the temperature"
				+ " the apples are grown in. The skin is also covered with red"
				+ " spotting and vertical striping. Large in size its flesh is crisp,"
				+ " juicy and creamy yellow in color. The Jonagold apple has a balanced"
				+ " blend of both its parents’ flavors offering the sweet-tart taste found"
				+ " in the Jonathan and the aromatic honey like scent of the Golden Delicious.'";

		cookingtime = 0.10;
		growingStart = "'September'";
		growingEnd = "'January'";
		SecondName = "'Jonagold'";
		originCountryName = "'Nederlands'";
		CountryCode = "'NL'";
		subId1 = subId;

		this.food = new Food(name, barcode, history, taste, cookingtime,
				growingStart, growingEnd, SecondName, originCountryName,
				subId1, CountryCode, countryId, secondNameId, infoId,
				growingPeriodId);
		a.add(this.food);

		this.countryId++;
		this.growingPeriodId++;
		this.infoId++;
		this.secondNameId++;

		return a;
	}

}
