import java.io.IOException;
import java.io.Serializable;


public class LendOut implements Serializable
{


	/**
	 * 
	 */
	
	private Item item;
	private Customer customer;
	private MyDate date;
	


	public LendOut(Item item, Customer customer, MyDate date) throws IOException
	{	
		this.item = item;
		this.customer = customer;
		this.date = date.copy();
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
		return this.date.copy();
		
	}
	
	@Override
	public String toString() {
		
			
				return "LendOut item = " + item + ", customer = " + customer + ", date = " + date;
						
	}
}
