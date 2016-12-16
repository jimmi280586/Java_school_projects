/*
 * 20.04.2016 Reorganized
 * 31.10.2011 Statistics added
 * 30.10.2011 Original version
 */

package eventhandler;


import java.util.Random;


public class Customer
	extends Actor
{
	private static int nextNumber = 1;
	private int number = nextNumber++;

	private CustomerState state = CustomerState.CREATED;
	private int startWaitingToPay;
	private int endWaitingToPay;

	private ShopSimulation engine;
	private int minShoppingTime;
	private int maxShoppingTime;
	private int payingTime;

	private static Random random = new Random();


	public Customer( ShopSimulation engine, int timeOpen, int minShoppingTime, int maxShoppingTime,
	                 int payingTime )
	{
		this.engine = engine;
		this.minShoppingTime = minShoppingTime;
		this.maxShoppingTime = maxShoppingTime;
		this.payingTime = payingTime;

		nextActionTime = random.nextInt( timeOpen ); // When to enter shop
		engine.schedule( this );
	}


	@Override
	public void action()
	{
		switch( state ) {
			case CREATED:
				System.out.println( "Time=" + nextActionTime + ": Customer " + number + " enters shop" );

				int shoppingTime = minShoppingTime + random.nextInt( maxShoppingTime - minShoppingTime );
				System.out.println( "Customer " + number + " will shop in " + shoppingTime + " seconds" );

				nextActionTime += shoppingTime;
				state = CustomerState.SHOPPING;
				engine.schedule( this );
				break;

			case SHOPPING:
				System.out.println( "Time=" + nextActionTime + ": Customer " + number + " has shopped" );
				startWaitingToPay = nextActionTime;

				state = CustomerState.WAITINGTOPAY;
				engine.enterPayingQueue( this );
				break;

			case WAITINGTOPAY:
				System.out.println( "Time=" + nextActionTime + ": Customer " + number + " starts paying" );
				endWaitingToPay = nextActionTime;
				engine.registerWaitingToPayTime( endWaitingToPay - startWaitingToPay);
				engine.startPaying();

				state = CustomerState.PAYING;
				nextActionTime += payingTime;
				engine.schedule( this );
				break;

			case PAYING:
				System.out.println( "Time=" + nextActionTime + ": Customer " + number + " leaves the shop" );
				engine.stopPaying( nextActionTime );

				state = CustomerState.DONE;
				break;
		}
	}


	private enum CustomerState
	{
		CREATED,
		SHOPPING,
		WAITINGTOPAY,
		PAYING,
		DONE,
	}
}