/**
 *  @author Lewis and Chase
 *
 *  Represents a node in a linked list.
 */
package linkedStack;

/**
 * The node class used for all single linked lists
 *
 * @param <T> Generic types to be stored in the element part of the node
 */

public class LinearNode<T>
{
   /**
    * Reference to the next node in the list
    */

   private LinearNode<T> next = null;

   /**
    * The value stored in the node
    */

   private T element = null;


   /**
    * Constructor specifying the value of the node but leaving next equal to null
    *
    * @param element The value to be stored in the node
    */

   public LinearNode( T element )
   {
      this.element = element;
   }


   /**
    * Default constructor leaving all fields null
    */

   public LinearNode()
   {
      this( null );
   }


   /**
    * Get the next reference of the node
    *
    * @return The next reference
    */

   public LinearNode<T> getNext()
   {
      return next;
   }


   /**
    * Set the next reference of the node
    *
    * @param next The new next reference
    */

   public void setNext( LinearNode<T> next )
   {
      this.next = next;
   }


   /**
    * Get the value stored in the node
    *
    * @return The value stored in the node
    */

   public T getElement()
   {
      return element;
   }


   /**
    * Set the value of the node
    *
    * @param element The new value to ne stored in the node
    */

   public void setElement( T element )
   {
      this.element = element;
   }
}
