/**
 * 03.04.2016 Original version
 */

package heap.test;

import Heaps.NimArrayMaxHeap;
import exceptions.EmptyCollectionException;
import interfaces.ArrayMaxHeapADT;

public class TryMaxHeap
{
   public static void main( String[] args )
   {
      new TryMaxHeap().run();
   }


   private void run()
   {
      ArrayMaxHeapADT<Integer> heap = new NimArrayMaxHeap<Integer>();

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
            System.out.println( "Max: " + heap.removeMax() );
            System.out.println( "Heap: " + heap );
         }
      } catch( EmptyCollectionException ex ) {
      }
   }
}
