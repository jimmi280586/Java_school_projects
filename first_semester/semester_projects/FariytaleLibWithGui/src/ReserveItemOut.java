
import java.io.Serializable;


/**
 * This class takes two object, this object class
 *  is for controlling the two objects in one 
 */
public class ReserveItemOut implements Serializable
{
	
	private Item item;
	private Customer customer;
		
	/** Constructs a new reserveItemOut containing item and customer objects
	 * @param item
	 * @param customer
	 */
	public ReserveItemOut(Item item, Customer customer) 
	{
	
		this.item = item;
		this.customer = customer;
		
	}
	
	public Item getItem()
	{
		return item;
	}
	
	public void setItem(Item item)
{
		this.item = item;
	}
	
	public Customer getCustomer() 
	{
		return customer;
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "ReserveItemOut item = " + item + ", customer = " + customer;
	}
	
	
	
	
	
	
	
	
	
}
