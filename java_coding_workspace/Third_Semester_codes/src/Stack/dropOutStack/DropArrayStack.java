package dropOutStack;

import exceptions.EmptyCollectionException;
import stackInterface.StackADT;
/**
 * Array implementation of a stack. If the stack overflows the size is automatically increased
 */

public class DropArrayStack<T>
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

   public DropArrayStack( int initialCapacity )
   {
      stack = (T[]) new Object[initialCapacity];
   }

   /**
    * Constructor where the initial capacity (size of the array) is set to a default value
    */

   public DropArrayStack()
   {
      this( DEFAULT_CAPACITY );
   }


   @Override
public void push( T element )
   {
      if( size() == stack.length )
         removeButtom();

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

	  /**
      * Creates a new array to store the contents of this stack with
      * twice the capacity of the old one.
      */
     private void removeButtom()
     {

       T[] temp = (T[])(new Object[stack.length]);

       for (int index=1; index < stack.length; index++)
         temp[index-1] = stack[index];

       top--;
       stack = temp;


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
