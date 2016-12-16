/*
 * 20.04.2016 Reorganized, switch back to ArrayMinHeap
 * 31.10.2011 Switched to LinkedHeap due to bug in ArrayHeap ...
 * 30.10.2011 Original version
 */

package eventhandler;

import exceptions.EmptyCollectionException;
import heap.ArrayMinHeap;
import heap.MinHeapADT;

public abstract class SimulationEngine
{
	private MinHeapADT<Actor> eventQueue = new ArrayMinHeap<Actor>();


	public final void run()
	{
		initializeSimulation();

		try {
			while( !eventQueue.isEmpty() ) {
				Actor a = eventQueue.removeMin();
				a.action();
			}
		} catch( EmptyCollectionException ex ) {
			ex.printStackTrace();
			System.out.println( "*** WHAT??? ***" );
			System.exit(1);
		}

		displayStatistics();
	}


	protected abstract void initializeSimulation();


	protected abstract void displayStatistics();


	public void schedule( Actor actor )
	{
		eventQueue.addElement( actor );
	}
}