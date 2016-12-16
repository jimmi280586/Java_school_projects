
public class Circle 
{
	//* from her
	
	public double radius;
	
	public Circle()
	{
		this.radius = 0.0;
	}
	
	public double setradius(double rad)
	{
		return rad;
	}
	
	public Circle(double rad)
	{
		this.radius = rad;
	}
	
	public double getArea()
	{
		return Math.PI * radius * radius;
	}
	
	public double getRadius()
	{
		return radius;
	}//* to her = a
}
