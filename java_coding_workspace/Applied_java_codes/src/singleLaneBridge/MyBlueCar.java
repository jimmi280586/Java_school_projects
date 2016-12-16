package singleLaneBridge;


public class MyBlueCar extends Thread 
{
	private SingleLane bridge;
	
	public MyBlueCar(SingleLane bridge) 
	{
		this.bridge = bridge;
	}
	
	public void run() 
	{
		while(true)
		{
			try{
				bridge.enterFromTheRight();
				System.out.println("A Blue Car is on the bridge");
				}
			catch (InterruptedException e) {}
			try {
				sleep(5000);
				} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bridge.exitToTheLeft();
			System.out.println("The Blue Car has left the bridge");
		}
	}
}
