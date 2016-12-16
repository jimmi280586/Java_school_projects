/**
 * BinaryTreeNode represents a node in a binary tree with a left and
 * right child.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/19/08
 */

package jss2;

public class BinaryTreeNode<T>
{
   protected T element;
   protected BinaryTreeNode<T> left, right;
   private int hitCounter; //added hit counter

   /**
    * Creates a new tree node with the specified data.
    *
    * @param obj  the element that will become a part of the new tree node
   */
   BinaryTreeNode (T obj)
   {
      element = obj;
      left = null;
      right = null;
      hitCounter = 0; //added initialization here to zero
   }

   /**
    * Returns the number of non-null children of this node.
    * This method may be able to be written more efficiently.
    *
    * @return  the integer number of non-null children of this node
    */
   public int numChildren()
   {
      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children = children + 1 + right.numChildren();

      return children;
   }

   /**
    * increases value by hitCounter by 1
    */
   public void incrementHitCounter(){
      hitCounter++;
   }

   /**
    * get's the value of hitCounter
    * @return int hitCounter
    */
   public int getHitCounter(){
      return hitCounter;
   }
}

