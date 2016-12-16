import java.util.Scanner;


public class DayQuiz {

	public static void main(String[] args) 
	{
	
		int count = 0;
		
		  final int MONTHS = 12;
		  
	      int[] user = new int[MONTHS];
	      
	      int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	      
	      for (int index = 0; index < MONTHS; index++)
	      {
	    	  Scanner keyboard = new Scanner(System.in);
	    	  System.out.println("how many days does month " + (index + 1) + " have");
	    	  user[index] = keyboard.nextInt();
	    	  
	      }
	     
	      
	      for (int index = 0; index < MONTHS; index++)
	      {
	    	     	  
	    	
	    		  if (user[index] == days[index])
	    		  {
	    			  count++;
	    		  }
	    		  
	    	  
	    	  
	    	  
	      }
	    
	      System.out.println("you have " + count + " correct answers");
	
	 

	}

}
