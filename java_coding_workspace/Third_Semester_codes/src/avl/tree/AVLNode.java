package tree;

/**
 * This class represents a Node in an AVLTree, which is a
 * balanced binary search tree. As such, all the AVLNodes must be
 * mutually Comparable to properly order the elements. Each AVLNode
 * also maintains the balance factor for its subtrees. A balance factor
 * less than 0 indicates more elements to the left of this AVLNode, and a
 * balance factor greater than 0 indicates more elements to the right of
 * this AVLNode.
 * @author jimmi andersen
 *
 * @param <E>
 */
public class AVLNode<E extends Comparable<? super E>>
{
   // private fields for left, right node and the element
   private AVLNode<E> left, right;
   private E element;

   //standard empty constructor
   public AVLNode()
   {
      this(null);
   }

   //constructor with the element for the node
   public AVLNode(E element)
   {
      this.element = element;
      left = right = null;
   }

   public E getElement()
   {
      return element;
   }

   public void setElement(E element)
   {
      this.element = element;
   }

   public AVLNode<E> getLeft()
   {
      return left;
   }

   public AVLNode<E> getRight()
   {
      return right;
   }

   //this setter creates a new left node with the element if parent
   //have no left child else it changes the element in the current node
   public void setLeft(E element)
   {
      if(left == null)
         this.left = new AVLNode<E>(element);
      else
         this.left.setElement(element);
   }

 //this setter creates a new right node with the element if parent
   //have no right child else it changes the element in the current node
   public void setRight(E element)
   {
      if(right == null)
         this.right = new AVLNode<E>(element);
      else
         this.right.setElement(element);
   }

   //setter for left child with a node
   public void setLeftNode(AVLNode<E> temp)
   {
      this.left = temp;
   }

   //setter for right child with node
   public void setRightNode(AVLNode<E> temp)
   {
      this.right = temp;
   }

   /*
    * this method gives you the balance level for the node
    * if the left node is null it uses 0 that is what ?0: is for it sets
    * the height of left to 0 if there is no node and the same for right
    */
   public int getBalance()
   {
      int leftHeight = (left == null)?0:left.height();
      int rightHeight = (right == null)?0:right.height();

      return rightHeight - leftHeight;
   }

   //private method for calculating the height of the node used for calculating the
   //balance value
   private int height()
   {
      int leftHeight = (left == null)?0:left.height();
      int rightHeight = (right == null)?0:right.height();

      return 1 + Math.max(leftHeight, rightHeight);
   }

   @Override
public String toString()
   {
      return assemble(this, 0);
   }

   /*
    * private method for printing a string this method works recursivly
    *
    */
   private String assemble(AVLNode<E> temp, int offset)
   {
      String ret = "";
      for (int i = 0; i < offset; i++)
         ret+= "\t";

      ret += temp.getElement() + "\n";

      if(temp.getLeft() != null)
      {
         ret += "Left: " + assemble(temp.getLeft(), offset + 1);
      }
      if(temp.getRight() != null)
      {
         ret += "Right: " + assemble(temp.getRight(), offset + 1);
      }

      return ret;


      }
   }

