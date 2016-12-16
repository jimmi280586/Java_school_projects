package src.system.utill;

import java.util.ArrayList;

import src.system.domain.model.Category;
import src.system.domain.model.SubCategory;

public class HardSubCategoryMethod {
	private static int categoryId = 1;

	public HardSubCategoryMethod() {

	}

	/*
	 * hard coded method for creating sub categories will only in version 1.0
	 * contain fruit and vegetable categories but can later on be extended
	 */
	public static ArrayList<SubCategory> createHardSubCategory() {
		ArrayList<SubCategory> a = new ArrayList<>();
		SubCategory b = new SubCategory("'Apples'", categoryId, 1);
		SubCategory c = new SubCategory("'Citrus'", categoryId, 2);
		SubCategory d = new SubCategory("'Kiwi'", categoryId, 3);
		SubCategory e = new SubCategory("'Avocados'", categoryId, 4);
		SubCategory f = new SubCategory("'Bananas'", categoryId, 5);
		SubCategory g = new SubCategory("'StoneFruit'", categoryId, 6);
		SubCategory h = new SubCategory("'Grapes'", categoryId, 7);
		SubCategory i = new SubCategory("'Pears'", categoryId, 8);
		SubCategory j = new SubCategory("'Pineapple'", categoryId, 9);
		SubCategory k = new SubCategory("'Melons'", categoryId, 10);
		SubCategory l = new SubCategory("'Carrots'", categoryId, 11);
		SubCategory m = new SubCategory("'Oniens'", categoryId, 12);
		SubCategory n = new SubCategory("'Pebers'", categoryId, 13);
		SubCategory o = new SubCategory("'Kale'", categoryId, 14);
		SubCategory p = new SubCategory("'Corn'", categoryId, 15);
		SubCategory q = new SubCategory("'Peas'", categoryId, 16);
		SubCategory r = new SubCategory("'PupkindFamilie'", categoryId, 17);
		SubCategory s = new SubCategory("'Salats'", categoryId, 18);
		SubCategory t = new SubCategory("'Baries'", categoryId, 19);
		SubCategory u = new SubCategory("'Spices'", categoryId, 20);
		SubCategory v = new SubCategory("'Roots'", categoryId, 21);
		SubCategory w = new SubCategory("'Nuts'", categoryId, 22);
		SubCategory x = new SubCategory("'Organic'", categoryId, 23);
		SubCategory y = new SubCategory("'SpecialFruits'", categoryId, 24);
		SubCategory z = new SubCategory("'SpecialVegetables'", categoryId, 25);
		SubCategory a1 = new SubCategory("'Tomatoes'", categoryId, 26);
		SubCategory a2 = new SubCategory("'Potatoes'", categoryId, 27);
		SubCategory a3 = new SubCategory("'Date'", categoryId, 28);
		SubCategory a4 = new SubCategory("'Fig'", categoryId, 29);
		SubCategory a5 = new SubCategory("'Mushrooms'", categoryId, 30);

		SubCategory[] b2 = new SubCategory[] { b, c, d, e, f, g, h, i, j, k, l,
				m, n, o, p, q, r, s, t, u, v, w, x, y, z, a1, a2, a3, a4, a5 };
		for (int int1 = 0; int1 < b2.length; int1++) 
		{
			a.add(b2[int1]);
		}

		return a;
	}
}
