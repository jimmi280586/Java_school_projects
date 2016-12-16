package test_04_05_2015.task3;

public class PizzaGuy extends Thread
{
	private PizzaMethods pizza;

	public PizzaGuy(PizzaMethods pizza) 
	{
		this.pizza = pizza;
	}

	public void run() 
	{
		while(true) 
		{
			try{
				pizza.reciveAPizzaOrder();;
				System.out.println("A pizza order is in");
			}
			catch (InterruptedException e) {}
			
			makePizza();
			
			try {
				pizza.deliverAPizza();
				System.out.println("A pizza has been delivered");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void makePizza()
	{
		try 
		{
			System.out.println("pizza is beeing made");
			sleep(1000);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
