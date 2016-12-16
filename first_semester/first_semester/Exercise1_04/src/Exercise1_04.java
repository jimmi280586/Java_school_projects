
public class Exercise1_04 
{

	public static void main(String[] args) 
	{
	    // makes 4 double varables
		double tax, total, x, y;
	      
	      // initialises 4 variables
	      x = 1.25;
	      y = 80;
	      tax = y * x - y;// makes te calculations
	      total = y * x;
	      //prints tax for y value
	      System.out.println("The tax for the item that cost " + y + 
	            " Is " + tax + " And the total is " + total);
	      x = 1.25;
	      y = 140;
	      tax = y * x - y;
	      total = y * x;
	      // prints tax for new y value
	      System.out.println("The tax for the item that cost " + y + 
	            " Is " + tax + " And the total is " + total);
	      
	      x = 1.25;
	      y = 230;
	      tax = y * x - y;
	      total = y * x;
	      // prints tax for new y value
	      System.out.println("The tax for the item that cost " + y + 
	            " Is " + tax + " And the total is " + total);
	      

	}

}
