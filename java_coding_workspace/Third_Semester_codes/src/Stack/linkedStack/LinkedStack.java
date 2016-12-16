/**
 *  @author Lewis and Chase
 *
 *  Represents a linked implementation of a stack.
 */
package linkedStack;
import exceptions.EmptyCollectionException;
import stackInterface.StackADT;

/**
 * Implementation of a stack using a linked list. The top of the stack is kept at the front of the list to make push and pop easier
 *
 * @param <T> Generic type of objects that can be pushed onto the stack
 */

public class LinkedStack<T>
   implements StackADT<T>
{
   /**
    * count keeps track of the number of elements in the stack
    */

   private int count = 0;

   /**
    * top is a reference to the first element in the aka the top of the stack
    */

   private LinearNode<T> top = null;


   @Override
public void push( T element )
   {
      LinearNode<T> newNode = new LinearNode<T>( element );

      newNode.setNext( top );
      top = newNode;
      ++count;
   }


   @Override
public T pop()
      throws EmptyCollectionException
   {
      if( isEmpty() )
         throw new EmptyCollectionException( "in ArrayStack.peek()" );

      T result = top.getElement();
      top = top.getNext();
      count--;

      return result;
   }


   @Override
public T peek()
      throws EmptyCollectionException
   {
      if( isEmpty() )
         throw new EmptyCollectionException( "in ArrayStack.peek()" );

      return top.getElement();
   }


   @Override
public boolean isEmpty()
   {
      return size() == 0;
   }


   @Override
public int size()
   {
      return count;
   }


   @Override
public String toString()
   {
      String result = "";

      for( LinearNode<T> c = top; c != null; c = c.getNext() )
         result += " " + c.getElement();

      return result;
   }
}