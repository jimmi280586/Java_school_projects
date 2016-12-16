
public class Laptop extends Computer
{
	private int screenSize;

	public Laptop(String brand, String model, int screenSize) 
	{
		super(brand, model);
		this.screenSize = screenSize;
	}

	public int getScreenSize() {
		return screenSize;
	}

	@Override
	public String toString() 
	{
		 // Only print the CPU if it exists
		if (this.getCpu() != null)
		{
		return super.toString() + ", "
		+ this.screenSize + ", "
		+ this.getCpu().toString();
		}
		return super.toString() + ", "
		+ this.screenSize;
		
	}
	
	
}
