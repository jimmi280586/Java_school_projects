package src.system.domain.model;

import java.util.ArrayList;

/**
 * The Class Category stores sub category objects in ArrayList.
 */
public class Category {
	
	private String categoryName;
	private int Id;	
	private ArrayList<SubCategory> subCategory;

	/**
	 * Instantiates a new category taking an ArrayList of SubCategory.
	 *
	 * @param categoryName
	 *            the category name
	 * @param subCategory
	 *            the sub category
	 * @param id
	 *            the id
	 */
	public Category(String categoryName, ArrayList<SubCategory> subCategory,
			int id) {
		this.Id = id;
		this.categoryName = categoryName;
		this.subCategory = subCategory;
	}

	/**
	 * Instantiates a new category without ArrayList of SubCategory.
	 *
	 * @param categoryName
	 *            the category name
	 * @param id
	 *            the id
	 */
	public Category(String categoryName, int id) {
		this.Id = id;
		this.categoryName = categoryName;
		this.subCategory = new ArrayList<>();
	}

	public int getId() {
		return this.Id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ArrayList<SubCategory> getSubCategory() {
		return this.subCategory;
	}
	
	public SubCategory getSubCategory(int i) {
		return this.subCategory.get(i);
	}

	/**
	 * Adds the new sub category to the category object.
	 *
	 * @param sub
	 *            the food is the object wished added
	 */
	public void addNewSubCategory(SubCategory sub) {
		this.subCategory.add(sub);
	}

	/**
	 * Removes the sub category from the category object.
	 *
	 * @param sub
	 *            the sub is the object whised removed
	 */
	public void removeSubCategory(SubCategory sub) {
		for (int i = 0; i < this.subCategory.size(); i++) {
			if (this.subCategory.get(i).getid() == sub.getid())
				this.subCategory.remove(i);
		}
	}

	/*
	 * String method for printing all information about the category object to a String element
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category categoryName = " + categoryName + "," + " /&  /&CategoryId = "
				+ Id + "," + " /&  /&subCategory = " + subCategory + "";
	}

}
