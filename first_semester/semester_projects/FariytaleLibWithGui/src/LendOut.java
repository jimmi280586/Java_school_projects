
import java.io.IOException;
import java.io.Serializable;

/**
 * This object class takes three objects 
 * so the object can control three objects in one 
 */
public class LendOut implements Serializable
{


	
	
	private Item item;
	private Customer customer;
	private MyDate date;


	/**
	 * Constructs a new LendOut containing item, customer and date
	 * @param item
	 * @param customer
	 * @param date
	 */
	public LendOut(Item item, Customer customer, MyDate date) throws IOException
	{	
		
		
		this.item = item;
		this.customer = customer;
		this.date = date;
		
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
		
	public void setDate(MyDate date)
	{
		this.date = date;
	}
	
	public MyDate getDate()
	{
		return this.date;
	}
	
	
	
	@Override
	public String toString()
	{
		
			
	return "LendOut item = " + item + ", customer = " + customer + ", return date = " + date;
	}
	

}
