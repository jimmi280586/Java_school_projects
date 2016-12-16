/**
 * 03.04.2016 Original version
 */

package heap.test;

import Heaps.NimArrayMinHeap;
import exceptions.EmptyCollectionException;
import interfaces.ArrayMinHeapADT;

public class TryMinHeap
{
	public static void main( String[] args )
	{
		new TryMinHeap().run();
	}


	private void run()
	{
		ArrayMinHeapADT<Integer> heap = new NimArrayMinHeap<Integer>();

		heap.addElement( 17 );
		heap.addElement( 2 );
		heap.addElement( 14 );
		heap.addElement( 28 );
		heap.addElement( 3 );
		heap.addElement( 11 );
		heap.addElement( 18 );

		System.out.println( "Heap: " + heap );

		try {
			while( !heap.isEmpty() ) {
				System.out.println( "Min: " + heap.removeMin() );
				System.out.println( "Heap: " + heap );
			}
		} catch( EmptyCollectionException ex ) {
		}
	}
}
