package src.system.utill;

import java.util.ArrayList;

import src.system.domain.model.Category;

public class HardCategoryMethod {
	public HardCategoryMethod() {

	}

	/*
	 * hard coded method for creating categories will in version 1.0 only
	 * contain fruits and vegetables but can later be extended
	 */
	public static ArrayList<Category> createHardCategory() {
		ArrayList<Category> a = new ArrayList<>();
		Category b = new Category("'FruitAndVegetable'", 0);		
		a.add(b);
		

		return a;
	}
}
