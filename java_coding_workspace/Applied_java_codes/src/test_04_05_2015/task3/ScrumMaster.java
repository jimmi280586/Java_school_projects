package test_04_05_2015.task3;

public class ScrumMaster extends Thread
{
	private PizzaMethods master;

	public ScrumMaster(PizzaMethods master) 
	{
		this.master = master;
	}

	public void run() 
	{
		while(true) 
		{
			try{
				master.orderAPizza();
				System.out.println("A pizza has been ordered");
			}
			catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
			activities();
			
		}
	}
	
	private void activities()
	{
		try 
		{
			System.out.println("scrum master is doing something");
			sleep(1000);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
