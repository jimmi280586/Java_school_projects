/**
 * An implementation of the Maxheap ADT (reworked from Lewis&Chase)
 *
 * 03.04.2016 Original version
 */

package interfaces;

import exceptions.EmptyCollectionException;

/**
 * An implementation of the Maxheap abstract data type
 *
 * @param <T> Generic type of objects stored in the heap
 */
public interface ArrayMaxHeapADT<T extends Comparable<T>>
{
   /**
    * Add an element to the heap
    *
    * @param element
    */

   public void addElement( T element );

   /**
    * Removes and returns the biggest element in the heap
    *
    * @return The biggest element in the heap
    *
    * @throws EmptyCollectionException Thrown if the heap is empty
    */

   public T removeMax() throws EmptyCollectionException;

   /**
    * Returns the biggest element in the heap
    *
    * @return The biggest element in the heap
    *
    * @throws EmptyCollectionException Thrown if the heap is empty
    */

   public T findMax() throws EmptyCollectionException;

   /**
    * return true if the heap contains no elements
    *
    * @return true if the heap is empty
    */

   public boolean isEmpty();

   /**
    * Returns the number of elements in the heap
    *
    * @return the number of elements in the heap
    */

   public int size();
}

