package test_04_05_2015.task3;


public class TeamMember extends Thread 
{
	private PizzaMethods slice;
	
	public TeamMember(PizzaMethods slice) 
	{
		this.slice = slice;
	}
	
	public void run() 
	{
		while(true)
		{
			try {
				slice.getAPizzaSlice();
				System.out.println("team member asking for slice");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			program();
			
		}
	}
	
	private void program()
	{
		try {
			System.out.println("teammember is programming");
			sleep(2000);
			} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
