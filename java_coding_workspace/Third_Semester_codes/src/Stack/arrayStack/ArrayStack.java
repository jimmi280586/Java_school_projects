/**
 *  @author Lewis and Chase
 *
 *  Represents an array implementation of a stack.
 */
package arrayStack;

import exceptions.EmptyCollectionException;
import stackInterface.StackADT;

/**
 * Array implementation of a stack. If the stack overflows the size is automatically increased
 */

public class ArrayStack<T>
   implements StackADT<T>
{
   private static final int DEFAULT_CAPACITY = 100;

   /**
    * top is the index where the next push operation should insert the value. At the same time it indicates the number of elements on the stack
    */

   private int top = 0;

   /**
    * The elements of the stack is placed in this array with index between 0 and top-1. The top of the stack is at index top-1.
    */

   private T[] stack;

   /**
    * Constructor where the initial capacity (size of the array) is given by the user of the stack
    *
    * @param initialCapacity The initial capacity
    */

   public ArrayStack( int initialCapacity )
   {
      stack = (T[]) new Object[initialCapacity];
   }

   /**
    * Constructor where the initial capacity (size of the array) is set to a default value
    */

   public ArrayStack()
   {
      this( DEFAULT_CAPACITY );
   }


   @Override
public void push( T element )
   {
      if( size() == stack.length )
         expandCapacity();

      stack[top++] = element;
   }


   @Override
public T pop()
      throws EmptyCollectionException
   {
      if( isEmpty() )
         throw new EmptyCollectionException( "in ArrayStack.peek()" );

      T result = stack[--top];
      stack[top] = null; // this is a hint to the garbage collector

      return result;
   }


   @Override
public T peek()
      throws EmptyCollectionException
   {
      if( isEmpty() )
         throw new EmptyCollectionException( "in ArrayStack.peek()" );

      return stack[top - 1];
   }


   @Override
public boolean isEmpty()
   {
      return size() == 0;
   }


   @Override
public int size()
   {
      return top;
   }


   private void expandCapacity()
   {
      // Create a new array of double size and copy all elements from the old to the new array

      T[] newStack = (T[]) new Object[2 * stack.length];

      for( int i = 0; i < stack.length; ++i )
         newStack[i] = stack[i];

      // Let the new array be the stack

      stack = newStack;
   }


   @Override
public String toString()
   {
      String result = "";

      for( int i = top - 1; i >= 0; i-- )
         result += " " + stack[i];

      return result;
   }
}
