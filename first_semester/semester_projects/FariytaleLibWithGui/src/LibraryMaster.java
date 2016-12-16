
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**This class contains all the methods for the library
 *  
 *   and controls the creation of reading and writing to binary files
 *    
 */
public class LibraryMaster implements Serializable
{
	
	
	
	 private MyDate date;
	 private Item item;
	
	 //the four lines below are for if the system can큧 read files
	 //then uncomment them and comment out the four readlists.
	
	//ItemList items = new ItemList();
	//CustomerList customers = new CustomerList();
	//LendOutList lendOuts = new LendOutList();
	//ReservedList reserved = new ReservedList();
	
	 private LendOutFile file2 = new LendOutFile("LendOutlist.obj");
	 private ReservedFile file3 = new ReservedFile("ReservedList.obj");
	 private ItemListFile file = new ItemListFile("itemslist.obj");
	 private CustomerListFile file1 = new CustomerListFile("customerlist.obj");
	
	 // The reason for these fields not to be private 
	 //  is that you have to be able to call them in the graphical user interface
	 ItemList items = file.readItemList();
	 CustomerList customers = file1.readCustomerList();
	 LendOutList lendOuts = file2.readLendOutList();
	 ReservedList reserved = file3.readReservedList();
		/**
		 * Empty constructor
		 */
	public LibraryMaster() throws IOException
	{
	
		
	}
	
	public void setDate(int a, int b, int c) throws IOException
	{
		
		this.date = new MyDate(a, b, c);
	}
	
	public MyDate getDate()
	{
		return date;
	}
	/**
	 * This method takes four variables and uses them for adding
	 * item objects to an ArrayList and save it to a binary files. 
	 */
	public void addItemToItemList(String title, String author, int type, String text ) throws IOException 
	{
		
		
		//sets the status of all items added to 1 = HOME
	   int status = 1;  
	  
		// if type variable is 1 add this item = Book
	   if (type == 1)
			{
				items.addItem( new Book(title, status, text, author, getDate()));
		 	}
			
			
			if (type == 2)
			{
				items.addItem(new CD(title, status, author, getDate(), getDate()));
			}
			
			
			if (type == 3)
			{
				items.addItem(new DVD(title, status, author, getDate(), getDate()));
			}
			
			
			if ( type == 4)
			{
				items.addItem(new Article(title, status, author, text, getDate()));
			
			}
			// writes the arraylist to file	
			ItemListFile file = new ItemListFile("itemslist.obj");
			file.writeItemList(items);
		}

		
	
	/**
	 *  This method takes four variables and uses them for adding
	 * customer objects to an ArrayList and save it to a binary files. 
	 */
	public void addCustomerToCustomerList(String name, String address, String email, int phoneNumber, int type) throws IOException
	{
		
		boolean fine = false;
		
		// if type is 1 add the lecturer customer.
			if (type == 1)
			{
				customers.addCustomer(new Lecturer(name, address, email, phoneNumber, fine));
			}
				
			
			if (type == 2)
			{
				customers.addCustomer(new Student(name, address, email, phoneNumber, fine));
			}
		
			// writes the arraylist to file
			CustomerListFile file1 = new CustomerListFile("customerlist.obj");
			file1.writeCustomerList(customers);
			
	}
			
	
	/**
	 * This method takes in a variable to search
	 *  for a customer
	 */
	public Customer searchCustomer(String searchPhrase)
	{	
		
		Customer customer = null;
			
				for (int index = 0; index < customers.getNumberOfCustomer(); index ++)
				{
					//returns a customer object
					customer = customers.getCustomer(index);
					
					// checks to se if the name and email of the two objects are the same
					if (customer.getName().equals(searchPhrase) || customer.getEmail().equals(searchPhrase))
					{
						customer = customers.getCustomer(index);
						//returns a customer object
						return customer;
						
					}
					
				}
				return customer;
	}
		
	/**
	 * This method takes in a variable to search
	 *  for a customer
	 */
	public Item searchItem(String searchPhrase) throws IOException
	{		
		

				for (int index = 0; index < items.getNumberOfItems(); index ++)
				{
					//returns a item object
					item = items.getItem(index);
					
					//checks to se if object title is the same as the variable
					if (item.getTitle().equals(searchPhrase))
					{
						 //return item object
						item = items.getItem(index);
						
						return item;
						
					}
					
				}
				
				for (int index = 0; index < items.getNumberOfItems(); index ++)
				{
					
					item = items.getItem(index);
					
					//if item object is a book
					if (item instanceof Book)
					{
						//checks the author of the object against the variable
						if (((Book) item).getAuthor().equals(searchPhrase))
						{
							//returns an item object
							item = items.getItem(index);
							
							return item;
						}
					}
				
			
					// same as above just for the cd objects
					if (item instanceof CD)
					{
						
						if (((CD) item).getArtist().equals(searchPhrase))
						{
							
							item = items.getItem(index);
							
							return item;
						}
					}
					
				//same as the two above just for dvd큦
					if (item instanceof DVD)
					{
						
						if (((DVD) item).getArtist().equals(searchPhrase))
						{
							
							item = items.getItem(index);
							
							return item;
						}
					}
					
					//same as before just articles
					if (item instanceof Article)
					{
						
						if (((Article) item).getAuthor().equals(searchPhrase))
						{
							
							item = items.getItem(index);
							
							return item;
						}
					}
					
				}
			
				
			return item;

	}
	
	/**
	 * This method takes in item and customer objects 
	 *  as variables and uses them for creating a lendout object
	 *  and adding it to an ArraList and save them to the file
	 */
	public void LendOutItemToCustomer(Item item, Customer customer) throws IOException
	{
		
		
		 Item lendOutItem = null;
			Customer lendOutCustomer = null;
				
				// checks the two arraylist of item and customer for objects that are the same as the
			//variables needed beecuse of some noise.
				for (int i = 0; i < items.getNumberOfItems(); i++)
				{
					
					if (items.getItem(i).equals(item))
					{
						lendOutItem = items.getItem(i);
					}
				}
				
				for (int i = 0; i < customers.getNumberOfCustomer(); i++)
				{
					
					if (customers.getCustomer(i).equals(customer))
					{
						lendOutCustomer = customers.getCustomer(i);
					}
				}
		
		//checks objects status if it큦 one
		if (lendOutItem.getStatus() == 1)
		{
			//checks to se if customer has a fine
			if (lendOutCustomer.CustomerFine().startsWith(" $"))
		{
				System.out.println("customer has fine");
		}
			
		else
			{	
			//creates object of item and customer objects and add it to the arraylist
				lendOuts.addLendOut(new LendOut(lendOutItem, lendOutCustomer, getDate()));
				lendOutItem.setStatus(2);
			
				//writes to the file
				ItemListFile file = new ItemListFile("itemslist.obj");
				file.writeItemList(items);
			}
			
		}
	
	
				
		
	//checks items status if it큦 2
		if (lendOutItem.getStatus() == 2)
		{
			System.out.println("item is not available");			
		}
			
		//checks items status if it큦 3
		if (lendOutItem.getStatus() == 3)
		{
			for (int index = 0; index < reserved.getNumberOfReserved(); index++)
			{
				//returns an reserved object
				ReserveItemOut reservation = reserved.getReserved(index);
				
				// checks the item from the reserved object and if they are the same
				if (reservation.getItem().equals(lendOutItem))
				{
					//return customer object
					customer = reservation.getCustomer();
				}
				System.out.println("the item is reserved to " + customer.toString());
			}
		}
		//writes to file
		LendOutFile file2 = new LendOutFile("LendOutlist.obj");
		file2.writeLendOutList(lendOuts);
	}
		

	/**
	 *  This method takes in item and customer objects 
		 *  as variables and uses them for creating a reservedItemOut object
		 *  and adding it to an ArraList and save them to the file 
	 *   
	 */
	public void reserveItemToCustomer(Item item, Customer customer) throws IOException
	{
	
		 Item reservedItem = null;
			Customer reservedCustomer = null;
				
				
				for (int i = 0; i < items.getNumberOfItems(); i++)
				{
					
					if (items.getItem(i).equals(item))
					{
						//returns a item object
						reservedItem = items.getItem(i);
					}
				}
				
				for (int i = 0; i < customers.getNumberOfCustomer(); i++)
				{
					
					if (customers.getCustomer(i).equals(customer))
					{
						//returns a customer object
						reservedCustomer = customers.getCustomer(i);
					}
				}
		
		

				//if objects status is 1 = HOME
		if (reservedItem.getStatus() == 1)
		{
			
			System.out.println("item is available");
		
		}	
		
		//if objects status is 2 = LEND OUT
		if (reservedItem.getStatus() == 2)
		{					
				//creates a reservedItemOut object of the two given objects
				reserved.addReserved(new ReserveItemOut(reservedItem, reservedCustomer));
				
				//sets the objects status to 3 = RESERVED				
				reservedItem.setStatus(3);
			
				// writes arraylist to file
				ItemListFile file = new ItemListFile("itemslist.obj");
				file.writeItemList(items);
			
		}
		
		//if objects status is 3 = RESERVED
		if (reservedItem.getStatus() == 3)
		{
			System.out.println("item is not available item is lend out and reserved");
		
		}
		
		//writes arraylist to file
		ReservedFile file3 = new ReservedFile("ReservedList.obj");
	    file3.writeReservedList(reserved);
		
	}
	/**
	 * 	This method takes in one item object
	 *  it checks the reservedIist and LendOutList and compares
	 *  those objects to the item object and removes the object
	 *  from the lendOutList changes the items status and saves the lists to files again.
	 */

	public void returnItemToLibrary(Item item) throws IOException
	{

		Item returnItem = null;
		LendOut returnLendOut;
		ReserveItemOut reservedItemOut;
		Customer customer;
		
		for (int i = 0; i < items.getNumberOfItems(); i++)
		{
			
			if (items.getItem(i).equals(item))
			{
				returnItem = items.getItem(i);
			}
		}
		
	
		
		//if objects status is 2 = LendOut
		if(returnItem.getStatus() == 2)
				{
					for (int index = 0; index < lendOuts.getNumberOfLendOut(); index++)
					{
						//returns a lendOut object
						returnLendOut = lendOuts.getLendOut(index);
						if(returnLendOut.getItem().equals(returnItem))
						{
							//removes the lendOut object from the arraylist
							lendOuts.removeLendOut(returnLendOut);
							
							System.out.println("item is returned");
							
							//sets the objects status to 1 = HOME
							returnItem.setStatus(1);
							
							//write arraylist to file
							ItemListFile file = new ItemListFile("itemslist.obj");
							file.writeItemList(items);
							
							LendOutFile file2 = new LendOutFile("LendOutlist.obj");
							file2.writeLendOutList(lendOuts);
						}
					}
								
				}
				//if the item object status is 3
				if(returnItem.getStatus() == 3)
				{					
					for (int index1 = 0; index1 < lendOuts.getNumberOfLendOut(); index1++)
					{
						//returns a lendOut object
						returnLendOut = lendOuts.getLendOut(index1);
						if(returnLendOut.getItem().equals(returnItem))
						{
							//removes the lendOut object from the arraylist
							lendOuts.removeLendOut(returnLendOut);
							
						System.out.println("item is returned");
												
						}
					}
					
					for (int index = 0; index < reserved.getNumberOfReserved(); index++) 
					{
						reservedItemOut = reserved.getReserved(index);
						customer = reserved.getReserved(index).getCustomer();
						
						//checks the two items against one another
						if(reservedItemOut.getItem().equals(returnItem))
						{
							System.out.println("The item is reserved to " + customer + " please contact customer");
						}
					}
					
				//writes arraylist to file
					ItemListFile file = new ItemListFile("itemslist.obj");
					file.writeItemList(items);
					
					LendOutFile file2 = new LendOutFile("LendOutlist.obj");									
					file2.writeLendOutList(lendOuts);
					
				}		
	}
	
	/**
	 * This method checks the lendOutList's objects returnDate against the current date
	 * and displays a message if the date큦 are the same.
	 * it checks if the return date are under four days until current date then it displays a message
	 * and if it is 2 days after current date it displays another message and changes the 
	 * customer to get a fine of 5$. 
	 */
	public String checkOverdue() throws IOException
	{

		int lendOutItemDay;
		int currentDateDay;
		int result;
		String text = null;
		
		for(int index = 0; index < lendOuts.getNumberOfLendOut(); index++)
		{
			//checks the two dates against one another
			if(lendOuts.getLendOut(index).getDate().equals(date))
			{
				System.out.println("item is due today " + lendOuts.getLendOut(index));
			}
			
				//checks to see if the month and year are the same
			if(((lendOuts.getLendOut(index).getDate().getMonth() == getDate().getMonth()) 
					&& (lendOuts.getLendOut(index).getDate().getYear() == getDate().getYear())))
			{
				lendOutItemDay = lendOuts.getLendOut(index).getDate().getDay();
				currentDateDay = getDate().getDay();
				
				result = lendOutItemDay - currentDateDay;
										
					System.out.println(result);
					
					//if result is between 4 and 0
					if (result <= 4 && result > 0)
					{
						System.out.println("item is due in " + result +" days " + lendOuts.getLendOut(index));
					}
				//if the result is below -2
					if (result <= -2)
					{
						//makes the result positive
						result = (result * -1);
						System.out.println("item was due " + result + " days ago" + lendOuts.getLendOut(index));
						Customer cust = lendOuts.getLendOut(index).getCustomer();
						
						for (int index1 = 0; index1 < customers.getNumberOfCustomer(); index1++)
						{
							//returns a customer object
							Customer cust1 = customers.getCustomer(index1);
							if(cust.equals(cust1))
							{
								//sets customer objects fine to true
								cust1.setFine(true);
							}
						}
						
						
						//writes the arraylist to file
						CustomerListFile file1 = new CustomerListFile("customerlist.obj");

					      file1.writeCustomerList(customers);
						
					}
				}
				
			}
		return text;
			
	}
	/**
	 *This method takes a customer object and checks the customerlist 
	 *and changes this customers fine to false. 
	 */
	public void payedFine(Customer customer) throws IOException
	{
		
		Customer hasFine = null;
		
		for (int i = 0; i < customers.getNumberOfCustomer(); i++)
		{
			//checks two objects are the same
			if (customers.getCustomer(i).equals(customer))
			{
				//returns a customer object
				hasFine = customers.getCustomer(i);
			}
		}
	
		{
			//sets customer objects fine to false
			hasFine.setFine(false);
		}
		CustomerListFile file1 = new CustomerListFile("customerlist.obj");
	    file1.writeCustomerList(customers);
		
	}
	/**
	 * This method checks the itemlist for item of Dvd or Cd and checks their date큦 against
	 * the current date, if the current date is more the the items getIsOldDate, it sets the item
	 * to be old.
	 */
	public void setItemIOld()
	{
	
		Item item;
		
		for (int index = 0; index < items.getNumberOfItems(); index ++)
		{
			//returns an item object
			item = items.getItem(index);
			if (item instanceof DVD || item instanceof CD)
			{
				//checks the objects date against the current date 
				if(item.getIsOldDate().getDay() < getDate().getDay()
						&& item.getIsOldDate().getMonth() < getDate().getMonth()
						&& item.getIsOldDate().getYear() < getDate().getYear())
				{
					item.setIsOld(true);
				}
			}
		}
	}
}

				


			
		
		
			


