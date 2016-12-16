/**
 *  @author Lewis and Chase
 *
 *  Represents a linked implementation of a stack.
 */
package dropOutLinkedStack;
import exceptions.EmptyCollectionException;
import linkedStack.LinearNode;
import stackInterface.StackADT;

/**
 * Implementation of a stack using a linked list. The top of the stack is kept at the front of the list to make push and pop easier
 *
 * @param <T> Generic type of objects that can be pushed onto the stack
 */

public class DropLinkedStack<T>
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

   /**
    * max value keeps track of the max size of the stack
    */

   private int maxSize;

   public DropLinkedStack( int maxSize )
   {
     this.maxSize = maxSize;
   }

   @Override
public void push( T element )
   {
      if(count == maxSize)
         RemoveBottom();

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

   private void RemoveBottom()
   {
      LinearNode<T> previous = top;

      for (int i = 1; i < maxSize - 1; ++i)
         previous = previous.getNext();

      previous.setNext(null);
      count--;

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
