
public class Ferry extends Ship
{
	   private double length;
	   private double weight;
	   private int passengers;
	   
	   public Ferry(double length, double weight, int passengers)
	   {
		  super(length, weight); 
	      this.length = length;
	      this.weight = weight;
	   }

	   public double getLength()
	   {
	      return this.length;
	   }

	   public void setLength(double length)
	   {
	      this.length = length;
	   }

	   public double getWeight()
	   {
	      return this.weight;
	   }

	   public void setWeight(double weight)
	   {
	      this.weight = weight;
	   }
	   
	   public int getPassengers()
	   {
	      return this.passengers;
	   }
	   
	   public void setPassengers(int passengers)
	   {
	      this.passengers = passengers;
	   }
	   
	   @Override
	   public String toString()
	   {
	      return "length = " + length + ", weight = " + weight + ", passengers = " + passengers;
	   }
}
