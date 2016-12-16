
public class Ferry extends Ship
{
	private int passengers;

	public Ferry(double length, double weight, int passengers) {
		
		super(length, weight);
		this.passengers = passengers;
	}
	 

	public int getPassengers()
	{
		return this.passengers;
	}
	
	public void setPassengers(int passengers)
	{
		this.passengers = passengers;
	}
	
	public String toString()
	{
		return super.toString() + "passengers: " + this.passengers; 
	}
}
