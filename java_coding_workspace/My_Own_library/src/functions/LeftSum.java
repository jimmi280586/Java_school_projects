package functions;
public class LeftSum 
{
	public static double leftSum(double start, double finish, double partition){
			         
			    double seperator = finish - start;
		        double value = start;
			    double totalArea = 0;
			    double increment = seperator / partition ;
		        for(int x = 0; x < partition; x++){
			            totalArea += RightSum.quadratic(value);
			            value = value + increment;   
		             
			             
		        }
		       return totalArea;
		       
	}
}
