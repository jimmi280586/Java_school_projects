package functions;

import interfaces.math.Function;

public class RightSum 
{
	 public static double rightSum(double start, double finish, double partition)
		    {
	 	         
		 
		        double seperator = finish - start;
	 	        double increment = seperator / partition ;
	 	        double value = start + increment;
	 	        double totalArea = 0;
		        for(int x = 0; x < partition; x++){
		            totalArea += quadratic(value);
	 	            value = value + increment;
		         
		        }
		        return totalArea;
	 	 
		    }  
	
	 
	 public static double quadratic(double value)
		    {
		         
	 	        //quadratic equation
	 	        double total = ((value * value));
	 	         
	 	        return total;
	 	         
		    }

}
