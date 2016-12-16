package singleLaneBridge;

public class main
{
	public static void main (String[] args) 
	{
		SingleLane bridge = new SingleLane();
		
		Thread red = new MyRedCar(bridge);
		Thread blue = new MyBlueCar(bridge);
		
		red.start();
		blue.start();
		try 
		{
			Thread.sleep(1000000);
		}
		catch (InterruptedException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.exit(0);
		
		}
}
