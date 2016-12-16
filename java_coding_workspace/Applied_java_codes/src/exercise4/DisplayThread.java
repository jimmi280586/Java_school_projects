package exercise4;


public class DisplayThread extends Thread
{
	private IParkingPlace parkingPlace;
	//private ParkingPanel displayPanel = null;
	
	public DisplayThread(IParkingPlace parkinPlace)//, ParkingPanel displayPanel)
	{
		this.parkingPlace = parkingPlace;
		//this.displayPanel = displayPanel;
	}
	
	public void run()
	{
		while (true)
		{
			int value = parkingPlace.freePlaces();
			updateDisplay (value);
			
		}
		
	}
	
	private void updateDisplay(int value)
	{
		System.out.println("* FREE PLACES: " + value);
		/*if (displayPanel != null)
			displayPanel.updateDisplay(value);*/
		
	}
}
