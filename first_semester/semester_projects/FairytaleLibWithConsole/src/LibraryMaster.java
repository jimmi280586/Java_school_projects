import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class LibraryMaster implements Serializable
{
	private MyDate date1;
	
	public LibraryMaster(MyDate date1) throws IOException
	{
		this.date1 = date1.copy();
	}
	
	
	//ItemList items = new ItemList();
	//CustomerList customers = new CustomerList();
	//LendOutList lendOuts = new LendOutList();
	//ReservedList reserved = new ReservedList();
	
	LendOutFile file2 = new LendOutFile("LendOutlist.obj");
	ReservedFile file3 = new ReservedFile("ReservedList.obj");
	ItemListFile file = new ItemListFile("itemslist.obj");
	CustomerListFile file1 = new CustomerListFile("customerlist.obj");
	
	
	ItemList items = file.readItemList();
	CustomerList customers = file1.readCustomerList();
	LendOutList lendOuts = file2.readLendOutList();
	ReservedList reserved = file3.readReservedList();
		
	public void addItemToItemList() throws IOException 
	{
		//calls the scanner
		Scanner input = new Scanner(System.in);
		
		// initialises the values used
		boolean a = false;
		String b;
		String title;
		int status;
		String author;
		String isbn;
		String artist;
		String magazine;		
		// starts a while loop
		while (a != true)
		{	
			// prints to screen
			System.out.println("chose the type of item");
			// sets value b to the next input from user
			b = input.nextLine();
			
			// if the input from user is done the while loop closes
			if (b.equals("done") || b.equals("Done") || b.equals("DONE"))
			{
				// sets value a to true so the while loop closes
				a = true;
			}
			
			if (b.equals("1"))
			{
				items.addItem(new Book("title1", 1, "author1", "isbn", date1));
				items.addItem(new Book("title2", 1, "author2", "isbn", date1));
				items.addItem(new CD("title3", 1, "artist1", date1 ));
				items.addItem(new DVD("title4", 1, "artist2", date1));
			}
			
			// if the input from user is book or Book or BOOK it will do this 
			if (b.equals("book") || b.equals("Book") || b.equals("BOOK"))
			{
				// asks user for title
				System.out.println("title");
				//sets title to users input
				title = input.nextLine();
				//asks user for status of item
				System.out.println("status 1 for HOME 2 for LEND OUT 3 for RESERVED 4 for LEND OUT and RESERVED");
				//sets status to users input from 1-4
				status = input.nextInt();
				//needed to change the type og input to string after interger
				input.nextLine();
				//asks user for author
				System.out.println("author");
				//sets author to users input
				author = input.nextLine();
				//asks for isbn number
				System.out.println("ISBN number");
				//sets isbn to users input
				isbn = input.nextLine();
			
							items.addItem(new Book(title, status, author, isbn, date1));
				
			}
			
			//if user input is dvd do this
			if (b.equals("dvd") || b.equals("Dvd") || b.equals("DVD"))
			{
				// asks for title
				System.out.println("title");
				//sets title to users input
				title = input.nextLine();
				//asks for status
				System.out.println("status 1 for HOME 2 for LEND OUT 3 for RESERVED 4 for LEND OUT and RESERVED");
				//sets status to users input from 1-4
				status = input.nextInt();
				//needed to change the input to string after interger
				input.nextLine();
				//asks for artist
				System.out.println("artist");
				//sets artist to users input
				artist = input.nextLine();
				//creates the object using user input
				DVD b1 = new DVD(title, status, artist, date1);
				
							// puts the item inside the arraylist
							items.addItem(b1);
						
				
				
			}
			
			// if users input is cd do this
			if (b.equals("cd") || b.equals("Cd") || b.equals("CD"))
			{
				// asks for title
				System.out.println("title");
				//sets title to users input
				title = input.nextLine();
				//asks for status
				System.out.println("status 1 for HOME 2 for LEND OUT 3 for RESERVED 4 for LEND OUT and RESERVED");
				//sets status to users input from 1-4
				status = input.nextInt();
				//needed to change the input to string after interger
				input.nextLine();
				//asks for artist
				System.out.println("artist");
				//sets artist to users input
				artist = input.nextLine();
				//creates the object using user input	
				CD b1 = new CD(title, status, artist, date1);
				
							// puts the item inside the arraylist
							items.addItem(b1);
			
				
			}
			
			// if users input is article do this
			if (b.equals("article") || b.equals("Article") || b.equals("ARTICLE"))
			{
				//sets title to users input
				title = input.nextLine();
				//asks user for status of item
				System.out.println("status 1 for HOME 2 for LEND OUT 3 for RESERVED 4 for LEND OUT and RESERVED");
				//sets status to users input from 1-4
				status = input.nextInt();
				//needed to change the type og input to string after interger
				input.nextLine();
				//asks user for author
				System.out.println("author");
				//sets author to users input
				author = input.nextLine();
				//asks for magazine name
				System.out.println("magazine");
				//sets magazine to users input
				magazine = input.nextLine();
				//creates the item using user input
				Article b1 = new Article(title, status, author, magazine, date1);
				
						items.addItem(b1);
				
			}
		
			
			ItemListFile file = new ItemListFile("itemslist.obj");
			file.writeItemList(items);
		}
}

		
	
	
	public void addCustomerToCustomerList() throws IOException
	{
	
		//calls the scanner
		Scanner input = new Scanner(System.in);
		
		// initialises the values used
		boolean a = false;
		String b;
		
		String name;
		String address;
		String email;
		int phoneNumber;
		int monthsInYear;
		boolean fine;
		
		// starts a while loop
		while (a != true)
		{	
			// prints to screen
			System.out.println("chose the type of customer lecturer or student");
			// sets value b to the next input from user
			b = input.nextLine();
			
			// if the input from user is done the while loop closes
			if (b.equals("done") || b.equals("Done") || b.equals("DONE"))
			{
				// sets value a to true so the while loop closes
				a = true;
			     
			}
			
			if (b.equals("1"))
			{
				customers.addCustomer(new Student("soley", "address1", "mail1", 251245, 1, false));
				customers.addCustomer(new Student("alice", "address2", "mail2", 251245, 1, true));
				customers.addCustomer(new Lecturer("yvonne", "address3", "mail3", 251245, 6, false));
				customers.addCustomer(new Lecturer("jimmi", "address4", "mail4", 251245, 6, false));		
			}
			
			
			// if the input from user is lecturer it will do this 
			if (b.equals("lecturer") || b.equals("Lecturer") || b.equals("LECTURER"))
			{
				// asks user for name
				System.out.println("name");
				//sets name to users input
				name = input.nextLine();
				//asks user for address
				System.out.println("address");
				//sets address to users input
				address = input.nextLine();
				//asks user for e-mail
				System.out.println("e-mail");
				//sets email to users input
				email = input.nextLine();
				//asks user for phone number
				System.out.println("phone number");
				//sets phoneNumber to users input
				phoneNumber = input.nextInt();
				input.nextLine();
				//sets months to 6 for lecturer
				monthsInYear = 6;
				//sets fine to false from the beginning
				fine = false;
				//adds the customer object to the customerlist
				customers.addCustomer(new Lecturer(name, address, email, phoneNumber, monthsInYear, fine));
			}
				
			// if the input from user is student it will do this 
			if (b.equals("student") || b.equals("Student") || b.equals("STUDENT"))
			{
				// asks user for name
				System.out.println("name");
				//sets name to users input
				name = input.nextLine();
				//asks user for address
				System.out.println("address");
				//sets address to users input
				address = input.nextLine();
				//asks user for e-mail
				System.out.println("e-mail");
				//sets email to users input
				email = input.nextLine();
				//asks user for phone number
				System.out.println("phone number");
				//sets phoneNumber to users input
				phoneNumber = input.nextInt();
				input.nextLine();
				//sets months to 1 for lecturer
				monthsInYear = 1;
				//sets fine to false from the beginning
				fine = false;
				//adds the customer object to the customerlist
				customers.addCustomer(new Student(name, address, email, phoneNumber, monthsInYear, fine));
			}
		
			CustomerListFile file1 = new CustomerListFile("customerlist.obj");

		      file1.writeCustomerList(customers);
			
			}
			
			
		}

		
	//method for searching Customer from Customerlist
	
	public Customer searchCustomer()
	{
		//calls the scanner
		Scanner input = new Scanner(System.in);

		// enitialises the values used
		String d;
		Customer e;
		Customer e1 = null;
		
			// asks for name or email
			System.out.println("input name or email");
			//sets d to users input
			d = input.nextLine();
			
			//if users input is name do this
			if (d.equals("name") || d.equals ("Name") || d.equals("NAME"))
			{
				// asks for name
				System.out.println("input name");
				//sets d to users input
				d = input.nextLine();
				
				// for loop for going thure the customerlist array
				for (int index = 0; index < customers.getNumberOfCustomer(); index ++)
				{
					// sets e to object of the current index
					e = customers.getCustomer(index);
					
					// if get name is equal to users input do this
					if (e.getName().equals(d))
					{
						// sets e1 to the current object in index 
						e1 = customers.getCustomer(index);
						//returns e1 object
						return e1;
						
					}
					
				}
				
			}
			//if users input is email do this
			if (d.equals("email") || d.equals ("Email") || d.equals("EMAIL"))
			{
				// asks for email
				System.out.println("input email");
				//sets d to users input
				d = input.nextLine();
				
				// for loop for going thure the customerlist array
				for (int index = 0; index < customers.getNumberOfCustomer(); index ++)
				{
					// sets e to object of the current index
					e = customers.getCustomer(index);
					
					// if get email is equal to users input do this
					if (e.getEmail().equals(d))
					{
						// sets e1 to the current object in index 
						e1 = customers.getCustomer(index);
						//returns e1 object
						return e1;
						
					}
					
				}
				
			}
			
			return null;
	}
	
	//method for searching items from itemlist
	@SuppressWarnings("resource")
	public Item searchItem()
	{
		//calls the scanner
		Scanner input = new Scanner(System.in);

		// enitialises the values used
		String d;
		Item e;
		Item e1 = null;
		
			// asks for title or author or artist
			System.out.println("input title or author or artist");
			//sets d to users input
			d = input.nextLine();
			
			//if users input is title do this
			if (d.equals("title") || d.equals ("Title") || d.equals("TITLE"))
			{
				// asks for title
				System.out.println("input title");
				//sets d to users input
				d = input.nextLine();
				
				// for loop for going thure the itemlist array
				for (int index = 0; index < items.getNumberOfItems(); index ++)
				{
					// sets e to object of the current index
					e = items.getItem(index);
					
					// if get title is equal to users input do this
					if (e.getTitle().equals(d))
					{
						// sets e1 to the current object in index 
						e1 = items.getItem(index);
						//returns e1 object
						return e1;
						
					}
					
				}
				
			}
			
			// if user input is author or artist do this
			if(d.equals("author") || d.equals ("Author") || d.equals("AUTHOR") || d.equals("artist") 
					|| d.equals ("Artist") || d.equals("ARTIST"))
			{
				// asks user for author or artist
				System.out.println("input author or artist");
				// sets d to users input
				d = input.nextLine();
				
				//for loop for going thrue the array
				for (int index = 0; index < items.getNumberOfItems(); index ++)
				{
					// sets e to current object from current index
					e = items.getItem(index);
					
					// if object from array is a book do this
					if (e instanceof Book)
					{
						// if the get author is equal to user input do this
						if (((Book) e).getAuthor().equals(d))
						{
							// sets e1 to the current object from index
							e1 = items.getItem(index);
							//returns e1 object
							return e1;
						}
					}
				
			
					// if object from array is a cd do this
					if (e instanceof CD)
					{
						//if get artist is equal to user input do this
						if (((CD) e).getArtist().equals(d))
						{
							// sets e1 to current object from index
							e1 = items.getItem(index);
							//returns e1 object
							return e1;
						}
					}
					
					// if object from array is a dvd do this
					if (e instanceof DVD)
					{
						//if get artist is equal to user input do this
						if (((DVD) e).getArtist().equals(d))
						{
							// sets e1 to current object from index
							e1 = items.getItem(index);
							//returns e1 object
							return e1;
						}
					}
					
					// if object from array is an article do this
					if (e instanceof Article)
					{
						// if get author is equal to user input do this
						if (((Article) e).getAuthor().equals(d))
						{
							// sets e1 to current object from index
							e1 = items.getItem(index);
							//returns e1 object
							return e1;
						}
					}
					
				}
			}
			//if nothing of the above is true it will return null
			
			return null;
		
	}
	
	//method for lending out items
	public void LendOutItemToCustomer() throws IOException
	{
		//calls the scanner
		Scanner input = new Scanner(System.in);
		//initializes the variable used
		Item a;
		Customer b;
		String c;
	int g;
	
		Customer cust = null;
		//sets a to the searchitem method
		// this will start the search method and give you an item
		a = searchItem();
		
		//System.out.println(a.toString());
		g = a.getStatus();
		//if the status of the item is 1 do this
		if (g == 1)
		{
			//search for the customer
			b = searchCustomer();
			if (b.CustomerFine().startsWith(" $"))
			{
				System.out.println("customer has fine");
			}
			//adds the object of the to objects to the arraylist
			else
			{
				int day = date1.getDay();
				int dayofmonth = date1.getMonth();
				int year = date1.getYear();
				MyDate date2;
			
				if ((a instanceof CD && ((CD) a).isOld() == false)
						||(a instanceof CD && ((CD) a).isOld() == false) 
						||(a instanceof Article))
				{
					day = date1.getDay() + 14;
					if(date1.getMonth() == 2 && date1.isLeapYear())
					{
						if (day > 29)
						{
							day = day - 29;
							dayofmonth = date1.getMonth() + 1;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
						}
						date2 =  new MyDate(day, dayofmonth, year);
					}
					
					if(date1.getMonth() == 2)
					{
						if (day > 28)
						{
							day = day - 28;
							dayofmonth = date1.getMonth() + 1;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
						}
						 
						 date2 =  new MyDate(day, dayofmonth, year);
					}
					
					if(date1.getMonth() == 1 || date1.getMonth() == 3
							|| date1.getMonth() == 5 || date1.getMonth() ==  7
							|| date1.getMonth() == 8|| date1.getMonth() == 10
									|| date1.getMonth() == 12)
					{
						if (day > 31)
						{
							day = day - 31;
							dayofmonth = date1.getMonth() + 1;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
						}
						date2 =  new MyDate(day, dayofmonth, year);
					}
					
					if(date1.getMonth() == 4 || date1.getMonth() == 6
							|| date1.getMonth() == 9 || date1.getMonth() ==  11)
						
					{
						if (day > 30)
						{
							day = day - 30;
							dayofmonth = date1.getMonth() + 1;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
						}
						date2 =  new MyDate(day, dayofmonth, year);
					}
					
				}
			
			if((a instanceof CD && ((CD) a).isOld() == true)
					||(a instanceof CD && ((CD) a).isOld() == true) 
					|| a instanceof Book)
			{
				
				if (b instanceof Student)
				{
					if (date1.getMonth() == 1 || date1.getMonth() == 3
							|| date1.getMonth() == 5 || date1.getMonth() ==  7
									|| date1.getMonth() == 8|| date1.getMonth() == 10
											|| date1.getMonth() == 12)
					{
						dayofmonth =  date1.getMonth() + 1;
						if (dayofmonth > 12)
						{
							dayofmonth = dayofmonth - 12;
							year = date1.getYear() + 1;
						}
						date2 =  new MyDate(day, dayofmonth, year);
						
					}
					
					if (date1.getMonth() == 2)
					{
						if(date1.isLeapYear())
						{
							dayofmonth =  date1.getMonth() + 1;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
							date2 =  new MyDate(day, dayofmonth, year);
						}
						else
						{
						dayofmonth =  date1.getMonth() + 1;
						if (dayofmonth > 12)
						{
							dayofmonth = dayofmonth - 12;
							year = date1.getYear() + 1;
						}
						date2 =  new MyDate(day, dayofmonth, year);
						}
					}
					dayofmonth =  date1.getMonth() + 1;
					if (dayofmonth > 12)
					{
						dayofmonth = dayofmonth - 12;
						year = date1.getYear() + 1;
					}
					date2 =  new MyDate(day, dayofmonth, year);
				}
				
					if (b instanceof Lecturer)
					{
						if (date1.getMonth() == 1 || date1.getMonth() == 3
								|| date1.getMonth() == 5 || date1.getMonth() ==  7
										|| date1.getMonth() == 8|| date1.getMonth() == 10
												|| date1.getMonth() == 12)
						{
							dayofmonth = date1.getMonth() + 6;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
							
							date2 =  new MyDate(day, dayofmonth, year);
						}
						
						if (date1.getMonth() == 2)
						{
							if(date1.isLeapYear())
							{
								dayofmonth = date1.getMonth() + 6;
								if (dayofmonth > 12)
								{
									dayofmonth = dayofmonth - 12;
									year = date1.getYear() + 1;
								}
								date2 =  new MyDate(day, dayofmonth, year);
							}
							else
							{
							dayofmonth = date1.getMonth() + 6;
							if (dayofmonth > 12)
							{
								dayofmonth = dayofmonth - 12;
								year = date1.getYear() + 1;
							}
							date2 =  new MyDate(day, dayofmonth, year);
							}
						}
						dayofmonth = date1.getMonth() + 6;
						if (dayofmonth > 12)
						{
							dayofmonth = dayofmonth - 12;
							year = date1.getYear() + 1;
						}
						date2 =  new MyDate(day, dayofmonth, year);
					
				
			lendOuts.addLendOut(new LendOut(a, b, date2));
			a.setStatus(2);
			
			ItemListFile file = new ItemListFile("itemslist.obj");
			file.writeItemList(items);
					}
			}
		}
		}
		
		// if status of item is 2 do this
		if (g == 2)
		{
			//prints to screen
			System.out.println("item is not available");
			//ask for yes or no
			System.out.println("do you want to reserve the item yes or no");
			// sets c to users input
			c = input.nextLine();
			//if users input is yes do this
			if (c.equals("yes"))
			{
				b = searchCustomer();
				
				if (b.CustomerFine().startsWith(" $"))
				{
					System.out.println("customer has fine");
				}
				else
				{
				
				reserved.addReserved(new ReserveItemOut(a,b));
				a.setStatus(3);
				
				ItemListFile file = new ItemListFile("itemslist.obj");
				file.writeItemList(items);
				
				ReservedFile file3 = new ReservedFile("ReservedList.obj");
			    file3.writeReservedList(reserved);
				
				}
			}
		}
		
		// if items status is 3 or 4 do this
		if (g == 3)
		{
			//goes thrue the array
			for (int index = 0; index < reserved.getNumberOfReserved(); index++)
			{
				//enitialize variable f to the reserved item of current index
				ReserveItemOut f = reserved.getReserved(index);
				//if the item from reserved list is equal to the item from itemlist do this
				if (f.getItem().equals(a))
				{
					//sets cust to the customer from reserved list
					cust = f.getCustomer();
				}
			//prints to screen the customer info	
			System.out.println("the item is reserved to " + cust);
			}
			
			}
		
		LendOutFile file2 = new LendOutFile("LendOutlist.obj");
		file2.writeLendOutList(lendOuts);
		
		
		}
		
		
	
	
		
	
	public void reserveItemToCustomer() throws IOException
	{
		//calls the scanner
		Scanner input = new Scanner(System.in);
		//enitializes the variable used
		Item a;
		Customer b;
		String c;
		int g;
		//sets a to the item that the search method will return
		a = searchItem();
		g = a.getStatus();
		System.out.println(a.toString());

		//if item status is 1 do this
		if (g == 1)
		{
			//calls the lend item to customer method
			System.out.println("item is available");
			System.out.println("do you want to lend it yes or no");
			c = input.nextLine();
			if (c.equals("yes"))
			{
				//search for the customer
				b = searchCustomer();
				if (b.CustomerFine().startsWith(" $"))
				{
					System.out.println("customer has fine");
				}
				//adds the object of the to objects to the arraylist
				else
				{
				lendOuts.addLendOut(new LendOut(a, b, date1));
				a.setStatus(2);
				
				ItemListFile file = new ItemListFile("itemslist.obj");
				file.writeItemList(items);
				
				}
			}
			
		}
		
		//if item status is 2 do this
		if (g == 2)
		{
			
				b = searchCustomer();
				
			
				//adds item and customer and nr to teh reserved list
				reserved.addReserved(new ReserveItemOut(a, b));
				//sets item status to 4
				a.setStatus(3);
				
				System.out.println(a.toString());
				
				ItemListFile file = new ItemListFile("itemslist.obj");
				file.writeItemList(items);
			
		}
		
		// if item status is 3 or 4 do this
		if (g == 3)
		{
			System.out.println("item is not available");
			System.out.println("item is lend out and reserved");
		
		}
		
		ReservedFile file3 = new ReservedFile("ReservedList.obj");
	    file3.writeReservedList(reserved);
		
	}
	

	public void returnItemToLibrary() throws IOException
	{
		//enitializes the variables used
		Item a;
		Customer cust;
		ReserveItemOut f;
		LendOut b;
		int g;
		// sets a to the returned item the search method will give you
		a = searchItem();
		
		g = a.getStatus();
		System.out.println(a.toString());
		
		if(g == 2)
				{
					for (int index = 0; index < lendOuts.getNumberOfLendOut(); index++)
					{
						b = lendOuts.getLendOut(index);
						if(b.getItem().equals(a))
						{
							lendOuts.removeLendOut(b);
							
							System.out.println("item is returned");
							
							a.setStatus(1);
							
							System.out.println(a.toString());
							ItemListFile file = new ItemListFile("itemslist.obj");
							file.writeItemList(items);
							
							LendOutFile file2 = new LendOutFile("LendOutlist.obj");
							
							file2.writeLendOutList(lendOuts);
						}
					}
								
				}
				//if item status is 3 do this
				if(g == 3)
				{
					
					for (int index1 = 0; index1 < lendOuts.getNumberOfLendOut(); index1++)
					{
						b = lendOuts.getLendOut(index1);
						if(b.getItem().equals(a))
						{
							lendOuts.removeLendOut(b);
							
							System.out.println("item is returned");
							
							
							System.out.println(a.toString());
						
						}
					}
					
					for (int index = 0; index < reserved.getNumberOfReserved(); index++) 
					{
						f = reserved.getReserved(index);
						cust = reserved.getReserved(index).getCustomer();
						if(f.getItem().equals(a))
						{
												
							
							System.out.println("the item is reserved to " + cust);
							System.out.println("contact customer");
							
							System.out.println(a.toString());
						}
					}
					
				
					ItemListFile file = new ItemListFile("itemslist.obj");
					file.writeItemList(items);
					
					LendOutFile file2 = new LendOutFile("LendOutlist.obj");									
					file2.writeLendOutList(lendOuts);
					
				}		
	}
	
	
	public void checkOverdue() throws IOException
	{
		
		MyDate date3;
		
		int a;
		int b;
		
		for(int index = 0; index < lendOuts.getNumberOfLendOut(); index++)
		{
			if(lendOuts.getLendOut(index).getDate().equals(date1))
			{
				System.out.println("item is due today");
				System.out.println(lendOuts.getLendOut(index));
			}
			
					
			if(((lendOuts.getLendOut(index).getDate().getMonth() == date1.getMonth()) 
					&& (lendOuts.getLendOut(index).getDate().getYear() == date1.getYear())))
			{
				a = lendOuts.getLendOut(index).getDate().getDay();
				b = date1.getDay();
				
				int result = a - b;
				
				
					
							
					System.out.println(result);
					
					if (result <= 4 && result > 0)
					{
						System.out.println("item is due in " + result +" days " + lendOuts.getLendOut(index));
					}
				
					if (result <= -2)
					{
						result = (result * -1);
						System.out.println("item was due " + result + " days ago" + lendOuts.getLendOut(index));
						Customer cust = lendOuts.getLendOut(index).getCustomer();
						
						for (int index1 = 0; index1 < customers.getNumberOfCustomer(); index1++)
						{
							Customer cust1 = customers.getCustomer(index1);
							if(cust.equals(cust1))
							{
								cust1.setFine(true);
							}
						}
						
						CustomerListFile file1 = new CustomerListFile("customerlist.obj");

					      file1.writeCustomerList(customers);
						
					}
				}
				
			}
				
			
			}
	
	public void payedFine() throws IOException
	{
		Scanner input = new Scanner(System.in);
		String a;
		Customer cust = searchCustomer();
		
		System.out.println(cust.toString());
		System.out.println("fine was payed yes or no");
		a = input.nextLine();
		
		if (a.equals("yes"))
		{
			cust.setFine(false);
		}
		CustomerListFile file1 = new CustomerListFile("customerlist.obj");

	    file1.writeCustomerList(customers);
		
	}
		}

				


			
		
		
			


