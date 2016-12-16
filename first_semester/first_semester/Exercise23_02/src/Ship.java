
public class Ship
{

	   private double length;
	   private double weight;
	   
	   public Ship(double length, double weight)
	   {
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
	      return 0;
	   }
	   
	   @Override
	   public String toString()
	   {
	      return "length = " + length + ", weight = " + weight;
	   }
	  
}
