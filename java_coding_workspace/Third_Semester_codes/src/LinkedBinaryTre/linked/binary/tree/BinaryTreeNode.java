/**
 * The node of a binary tree
 *
 * 16.02.2016 Original version
 */


package linked.binary.tree;


/**
 * A node to be used in a binary tree
 *
 * @param <T> Generic type of elements to be stored in the node
 */

public class BinaryTreeNode<T>
{
   /**
    * The value stored n the node
    */

   protected T element = null;

   /**
    * Reference to the left child of this node. Null if there isn't a left child of this node.
    */

   protected BinaryTreeNode<T> left = null;

   /**
    * Reference to the right child of this node. Null if there isn't a right child of this node.
    */

   protected BinaryTreeNode<T> right = null;


   /**
    * Constructor that creates a new node with the given element and no children
    *
    * @param element The value to be inserted in the node
    */

   public BinaryTreeNode( T element )
   {
      this.element = element;
   }

   /**
    * The empty constructor which set all fields to null
    */

   public BinaryTreeNode()
   {
   }

   /**
    * Copy constructor which gives the new node the same value as the original and create a copy of the subtrees below the original node
    *
    * @param original the node to copy
    */

   public BinaryTreeNode( BinaryTreeNode<T> original )
   {
      this( original.getElement() );

      if( original.getLeft() != null )
         this.left = new BinaryTreeNode<T>( original.getLeft() );

      if( original.getRight() != null )
         this.right = new BinaryTreeNode<T>( original.getRight() );
   }

   /**
    * Get the element of the node
    *
    * @return The element of the node
    */

   public T getElement()
   {
      return element;
   }

   /**
    * Set the element of the node
    *
    * @param element The element to be set in the node
    */

   public void setElement( T element )
   {
      this.element = element;
   }

   /**
    * Get a reference to the left child of the node
    *
    * @return reference to the left child. Null if no left child.
    */

   public BinaryTreeNode<T> getLeft()
   {
      return left;
   }

   /**
    * Set the left child reference of the node
    *
    * @param left left child reference. Null if no left child.
    */

   public void setLeft( BinaryTreeNode<T> left )
   {
      this.left = left;
   }

   /**
    * Get a reference to the right child of the node
    *
    * @return reference to the right child. Null if no right child.
    */

   public BinaryTreeNode<T> getRight()
   {
      return right;
   }

   /**
    * Set the right child reference of the node
    *
    * @param right right child reference. Null if no right child.
    */

   public void setRight( BinaryTreeNode<T> right )
   {
      this.right = right;
   }
}
