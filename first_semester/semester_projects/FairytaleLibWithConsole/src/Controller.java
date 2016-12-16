import java.io.IOException;
import java.util.Scanner;


public class Controller 
{
	
	
	public static void main(String[] args) throws IOException
	{
		
		//variables used during the program
		int a1;
		int a = 05;
		int b = 06;
		int c = 2014;
		boolean b1 = false;
		String a2;
		// calls the scanner
		Scanner input = new Scanner(System.in);
		// prints to screen
		System.out.println("input date");
		System.out.println("type 1 for inputting 05-06-2014");
		System.out.println("type 2 for inputting date");
		//sets a1 to user input
		a1 = input.nextInt();
		//if user type 1 do this
		if (a1 == 1)
		{
			//sets variable to the specific date
			a = 05;
			b = 06;
			c = 2014;					
		}
		// if user typed 2 do this
		if (a1 == 2)
		{
			// asks user for the integers fro the date
		System.out.println("day");
		a = input.nextInt();
		System.out.println("month");
		b = input.nextInt();
		System.out.println("year");
		c = input.nextInt();
		}
		// sets the scanner to take a string nesesary
		input.nextLine();

		//creates the date using the variables fro mabove
		MyDate date = new MyDate(a, b, c);
		//cals the library class and sets a copy of the date in to the class
		LibraryMaster library = new LibraryMaster(date.copy());
		
		// cecks if the library have books overdue
		// or if they are due today or in the next four days
		library.checkOverdue();
		
		// infinity while loop
		while(b1 != true)
		{
			//prints the menu to screen
			System.out.println("chose what you want to do");
			System.out.println("type add c for adding customer");
			System.out.println("type add i for adding item");
			System.out.println("type search for searching library");
			System.out.println("type lend for lending out an item");
			System.out.println("type res for reserving an item");
			System.out.println("type ret for returning an item");
			System.out.println("type fine for paying fine");
			//sets user input to upper case letters so it does not matter
			//if user use small or big letters
			a2 = input.nextLine().toUpperCase();
			
			// if user input is close it closes the program
			if(a2.equals("CLOSE"))
			{
				b1 = true;
			}
			// if user input is add c do this
			if (a2.equals("ADD C"))
			{
				// calls the library add customer method
				library.addCustomerToCustomerList();
				// prints all the added customers to screen
				for(int i = 0; i < library.customers.getNumberOfCustomer(); i++)
				{
				System.out.println(library.customers.getCustomer(i));
				}
			}
			// if userinput is add i do this
			if(a2.equals("ADD I"))
			{
				// calls the library add item method
				library.addItemToItemList();
				//prints all added items to screen
				for(int i = 0; i < library.items.getNumberOfItems(); i++)
				{
				System.out.println(library.items.getItem(i));
				}
			}
			//if user input is search do this
			if(a2.equals("SEARCH"))
			{
				// prints to screen the choises
				System.out.println("type c for customer");
				System.out.println("type i for item");
				// sets user input
				a2 = input.nextLine();
				// if input is c do this
				if(a2.equals("c"))
				{
				//prints and calls the search customer method from library class
				System.out.println(library.searchCustomer());
				}
				// if user input is i do this
				if (a2.equals("i"))
				{
				//prints and calls the search item method from library class
				System.out.println(library.searchItem());
				}				
			}
			// if user input lend in menue do this
			if(a2.equals("LEND"))
			{
				// sets user input
				a2 = input.nextLine();
				//if user input is 1 do this
				if(a2.equals("1"))
				{
					//prints all the lend out objects from librarys lend out list
					for(int i = 0; i < library.lendOuts.getNumberOfLendOut(); i++)
					{
					System.out.println(library.lendOuts.getLendOut(i));
					}
				}
				//calls the lend out method from library class
				library.LendOutItemToCustomer();
				//prints all the lend out objects from librarys lend out list
				for(int i = 0; i < library.lendOuts.getNumberOfLendOut(); i++)
				{
				System.out.println(library.lendOuts.getLendOut(i));
				}
			}
			// if user typed res do this
			if(a2.equals("RES"))
			{
				// calls the reserved method from library class
				library.reserveItemToCustomer();
				//print all the reserved objects from librarys reserved list
				for(int i = 0; i < library.reserved.getNumberOfReserved(); i++)
				{
				System.out.println(library.reserved.getReserved(i));
				}
			}
			// if user typed ret do this
			if(a2.equals("RET"))
			{
				//cals the return method from library class
					library.returnItemToLibrary();
				//prints all the objects from the lendout and reserved lists
					for(int i = 0; i < library.reserved.getNumberOfReserved(); i++)
					{
					System.out.println(library.reserved.getReserved(i));
					}	
					
					for(int i = 0; i < library.lendOuts.getNumberOfLendOut(); i++)
					{
					System.out.println(library.lendOuts.getLendOut(i));
					}
			}
			//if user typed fine do this
			if (a2.equals("FINE"))
			{
				// cals the payed fine method from library class
				library.payedFine();
			}
		}
		
	}


}
