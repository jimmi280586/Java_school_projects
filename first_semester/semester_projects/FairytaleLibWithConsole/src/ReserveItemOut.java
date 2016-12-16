import java.io.Serializable;


public class ReserveItemOut implements Serializable
{
	/**
	 * 
	 */
	
	private Item item;
	private Customer customer;
		
	//constructor
	public ReserveItemOut(Item item, Customer customer) 
	{
		this.item = item;
		this.customer = customer;
		
	}
	//getter for item
	public Item getItem()
	{
		return item;
	}
	//setter for item
	public void setItem(Item item)
{
		this.item = item;
	}
	//getter for customer
	public Customer getCustomer() 
	{
		return customer;
	}
	//setter for customer
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "ReserveItemOut item = " + item + ", customer = " + customer;
	}
	
	
	
	
	
	
	
	
	
}
