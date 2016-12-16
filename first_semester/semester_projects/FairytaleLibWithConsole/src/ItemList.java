import java.io.Serializable;
import java.util.ArrayList;

//This class is to list all the items that can be found in the library system
//books, articles, cd's and dvds

public class ItemList implements Serializable {
	/**
	 * 
	 */

	// This arrayList is to keep all the items in
	private ArrayList<Item> itemList;

	// The constructor
	public ItemList() {
		this.itemList = new ArrayList<Item>();
	}

	// Add items to the list
	public void addItem(Item item) 
	{
		this.itemList.add(item);
	}

	// Remove item from the list
	 public void removeItem(Item item)
	   {
	    this.itemList.remove(item);
	   }

	// Get item from list ()
	public Item getItem(int index)
		{
			return this.itemList.get(index);
		}

	// Get number of items in the list
	public int getNumberOfItems() {
		return this.itemList.size();
	}

	// Compare two itemLists to each other
	public boolean equals(Object obj) {

		if (!(obj instanceof ItemList)) {
			return false;
		}
		// Here we cast
		ItemList other = (ItemList) obj;
		return this.itemList.equals(other.itemList);
	}

	// Send everything to String
	public String toString() {
		return "ItemList "+ this.itemList; 
	}

}
