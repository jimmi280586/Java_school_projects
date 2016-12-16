
import java.io.Serializable;
import java.util.ArrayList;

/**This class is to handle an itemlist for all the items that can be 
 * found in the library system, that is books, articles, cd's and dvd's.
*Declare the list.
	 */
public class ItemList implements Serializable {


	private ArrayList<Item> itemList;
	/**
	 * Constructor initializes the list.
	 */
	public ItemList() {
		
		this.itemList = new ArrayList<Item>();
	}

	/** Add items to the list.
	 * 
	 * @param item object from the abstract Item class that has the
	 * subclasses book, article, cd and dvd.
	 */
	public void addItem(Item item) 
	{
	
		this.itemList.add(item);
	}

	/** Remove items from the list.
	 * 
	 * @param item object from the abstract Item class that has the
	 * subclasses book, article, cd and dvd.
	 */
	 public void removeItem(Item item)
	   {
		 
	    this.itemList.remove(item);
	   }

	
	public Item getItem(int index)
		{
			return this.itemList.get(index);
		}

	/** Get number of items in the list
	 * 
	 * @return returns the number of items as an int.
	 */
	public int getNumberOfItems() 
	{
		
		return this.itemList.size();
	}
	
	public String toString() 
	{
		return "ItemList "+ this.itemList; 
	}
	


}
