
public class Circle
{
	private double radius;
	private Point center;
	
	public Circle(double radius, Point center) 
	{
		this.center = center.copy();
		this.radius = radius;
	}

	public double getRadius() 
	{
		return this.radius;
	}

	public Point getCenter() 
	{
		return this.center.copy();
	}
	
	public void moveTo(double x, double y)
	{
		this.center.moveTo(x, y);
	}

	
	
	public String toString() {
		return "radius " + this.radius + ", center " + this.center.toString();
	}
	
	
}
