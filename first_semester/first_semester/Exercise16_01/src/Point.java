
public class Point 
{
	private double x;
	private double y;
	
	public Point(double x, double y) 
	{
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	

	public void moveTo(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	
	public String toString() {
		return x + " and " + y + ":";
	}
	
	public Point copy()
	{
		return new Point(this.x, this.y);
	}

}	

