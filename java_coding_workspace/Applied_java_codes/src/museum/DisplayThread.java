package museum;

public class DisplayThread extends Thread
{
	private IMuseum museum;
	
	
	public DisplayThread(IMuseum museum)
	{
		this.museum = museum;
		
	}
	
	public void run()
	{
		while (true)
		{
			int value = museum.getNumber();
			updateDisplay (value);
			
		}
		
	}
	
	private void updateDisplay(int value)
	{
		System.out.println("* Number Of Visitors: " + value);		
	}
}
