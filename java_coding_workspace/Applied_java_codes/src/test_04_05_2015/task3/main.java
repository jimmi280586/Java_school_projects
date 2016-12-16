package test_04_05_2015.task3;

public class main
{
	public static void main (String[] args) 
	{
		PizzaMethods pizza = new PizzaMethods();
		
		Thread pizzaguy = new PizzaGuy(pizza);
		Thread teammember0 = new TeamMember(pizza);
		Thread scrummaster = new ScrumMaster(pizza);
		Thread teammember1 = new TeamMember(pizza);
		Thread teammember2 = new TeamMember(pizza);
		
		scrummaster.start();
		pizzaguy.start();
		teammember0.start();
		teammember1.start();
		teammember2.start();
		
		
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
