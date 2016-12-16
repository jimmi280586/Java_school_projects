/*
 * 20.04.2016 Reorganized
 * 30.10.2011 Original version
 */

package eventhandler;


import java.util.ArrayDeque;
import java.util.Queue;


public class ShopSimulation
	extends SimulationEngine
{
	private int noCustomers;
	private int timeOpen;
	private int minShoppingTime;
	private int maxShoppingTime;
	private int payingTime;

	private int sumWaitingToPayTime = 0;
	private int maxWaitingToPayTime = 0;

	private boolean someonePaying = false;
	private Queue<Actor> payingQueue = new ArrayDeque<Actor>(); // From the java API


	public ShopSimulation( int noCustomers, int timeOpen, int minShoppingTime, int maxShoppingTime,
	                       int payingTime )
	{
		this.noCustomers = noCustomers;
		this.timeOpen = timeOpen;
		this.minShoppingTime = minShoppingTime;
		this.maxShoppingTime = maxShoppingTime;
		this.payingTime = payingTime;
	}


	@Override
	protected void initializeSimulation()
	{
		for( int i = 0; i < noCustomers; ++i )
			new Customer( this, timeOpen, minShoppingTime, maxShoppingTime, payingTime );
	}


	@Override
	protected void displayStatistics()
	{
		System.out.println( "Average time waiting to pay: " + ( sumWaitingToPayTime / noCustomers ) );
		System.out.println( "Maximum time waiting to pay: " + maxWaitingToPayTime );
	}


	public void enterPayingQueue( Actor actor )
	{
		payingQueue.add( actor );

		checkPayingQueue( actor.getNextActionTime() );
	}


	private void checkPayingQueue( int now )
	{
		if( !someonePaying && !payingQueue.isEmpty() ) {
			Actor actor = payingQueue.remove();
			actor.setNextActionTime( now );
			actor.action();
		}
	}


	public void startPaying()
	{
		someonePaying = true;
	}


	public void stopPaying( int now )
	{
		someonePaying = false;
		checkPayingQueue( now );
	}


	public void registerWaitingToPayTime( int waitingTime )
	{
		sumWaitingToPayTime += waitingTime;

		if( waitingTime > maxWaitingToPayTime )
			maxWaitingToPayTime = waitingTime;
	}
}