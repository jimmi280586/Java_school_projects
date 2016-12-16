
public class Controler {

	public static void main(String[] args) 
	{
	
		Point center = new Point(100, 100);
		Circle small = new Circle(50, center);
		Circle big = new Circle(200, center);
		
		System.out.println(small);
		
		small.moveTo(-50, 200);
		
		System.out.println(small);
		System.out.println(big);
		
	}

}
