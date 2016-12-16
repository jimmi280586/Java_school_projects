
public class Square extends Shape
{
	 private double sideLength;
	
	 // Constructor
	public Square(double sideLength)
	{
		this.sideLength = sideLength;
	}
	
	// Getter and Setter
	public double getSideLength()
	{
		return this.sideLength;
	}
	
	public void setSideLength(double sideLength)
	{
		this.sideLength = sideLength;
	}
	
	// Return the area, as shown in the abstract superclass
	@Override
	public double getArea()
	{
		return this.sideLength * this.sideLength;
	}
	
	// Return a String representation
	public String toString()
	{
		return "Side length = " + this.sideLength;
	}
}
