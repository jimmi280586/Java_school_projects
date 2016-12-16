package singleLaneBridge;

public class MyRedCar extends Thread
{
	private SingleLane bridge;

	public MyRedCar(SingleLane bridge) 
	{
		this.bridge = bridge;
	}

	public void run() 
	{
		while(true) 
		{
			try{
				bridge.enterFromTheLeft();
				System.out.println("A Red Car is on the bridge");
			}
			catch (InterruptedException e) {}
			try 
			{
				sleep(5000);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bridge.exitToTheRight();
			System.out.println("The Red Car has left the bridge");
		}
	}
}
