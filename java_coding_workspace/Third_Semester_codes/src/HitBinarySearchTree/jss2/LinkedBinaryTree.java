/*
 * 18.09.2011 jpe New constructor added
 */

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/19/08
 */

package jss2;
import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>
{
   protected int count;
   protected BinaryTreeNode<T> root;

   /**
    * Creates an empty binary tree.
    */
   public LinkedBinaryTree()
   {
      count = 0;
      root = null;
   }

   /**
    * Creates a binary tree with the specified element as its root.
    *
    * @param element  the element that will become the root of the new binary
    *                 tree
    */
   public LinkedBinaryTree (T element)
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }

   /* Added 18.09.2011 jpe */
   public LinkedBinaryTree( T element, LinkedBinaryTree<T> leftSubTree,
                            LinkedBinaryTree<T> rightSubTree )
   {
   	   this( element );

   	   if( leftSubTree != null ) {
   	   	   count += leftSubTree.size();
   	   	   root.left = leftSubTree.root;
   	   }

   	   if( rightSubTree != null ) {
   	   	   count += rightSubTree.size();
   	   	   root.right = rightSubTree.root;
   	   }
   }


   /**
    * Returns a reference to the element at the root
    *
    * @return                           a reference to the specified target
    * @throws EmptyCollectionException  if the tree is empty
    */
   @Override
public T getRoot() throws EmptyCollectionException
   {
      if (root == null)
         throw new EmptyCollectionException("binary tree");

      return (root.element);
   }

   /**
    * Returns true if this binary tree is empty and false otherwise.
    *
    * @return  true if this binary tree is empty
    */
   @Override
public boolean isEmpty()
   {
      return (count == 0);
   }

   /**
    * Returns the integer size of this tree.
    *
    * @return  the integer size of this tree
    */
   @Override
public int size()
   {
      return count;
   }

   /**
    * Returns true if this tree contains an element that matches the
    * specified target element and false otherwise.
    *
    * @param targetElement              the element being sought in this tree
    * @return                           true if the element in is this tree
    * @throws ElementNotFoundException  if an element not found exception occurs
    */
   @Override
public boolean contains (T targetElement)
   {
      T temp;
      boolean found = false;

      try
      {
         temp = find (targetElement);
         found = true;
      }
      catch (Exception ElementNotFoundException)
      {
         found = false;
      }

      return found;
   }

   /**
    * Returns a reference to the specified target element if it is
    * found in this binary tree.  Throws a NoSuchElementException if
    * the specified target element is not found in the binary tree.
    *
    * @param targetElement              the element being sought in this tree
    * @return                           a reference to the specified target
    * @throws ElementNotFoundException  if an element not found exception occurs
 * @throws EmptyCollectionException 
    */
   @Override
public T find(T targetElement) throws ElementNotFoundException, EmptyCollectionException
   {
      BinaryTreeNode<T> current = findAgain( targetElement, root );

       if( current == null ) {
           throw new ElementNotFoundException("binary tree");
       }
       current.incrementHitCounter();//added hitting here
       //reshuffle();
       return (current.element);
   }

   /**
    * Returns a reference to the specified target element if it is
    * found in this binary tree.
    *
    * @param targetElement  the element being sought in this tree
    * @param next           the element to begin searching from
    */
   private BinaryTreeNode<T> findAgain(T targetElement,
                                       BinaryTreeNode<T> next)
   {
      if (next == null)
         return null;

      if (next.element.equals(targetElement))
         return next;

      BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

      if (temp == null)
         temp = findAgain(targetElement, next.right);

      return temp;
   }

   /**
    * Returns a string representation of this binary tree.
    *
    * @return  a string representation of this binary tree
    */
   @Override
public String toString()
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      preorder (root, tempList);

      return tempList.toString();
   }

   /**
    * Performs an inorder traversal on this binary tree by calling an
    * overloaded, recursive inorder method that starts with
    * the root.
    *
    * @return  an in order iterator over this binary tree
    */
   @Override
public Iterator<T> iteratorInOrder()
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      inorder (root, tempList);

      return tempList.iterator();
   }

   /**
    * Performs a recursive inorder traversal.
    *
    * @param node      the node to be used as the root for this traversal
    * @param tempList  the temporary list for use in this traversal
    */
   protected void inorder (BinaryTreeNode<T> node,
                           ArrayUnorderedList<T> tempList)
   {
      if (node != null)
      {
         inorder (node.left, tempList);
         tempList.addToRear(node.element);
         inorder (node.right, tempList);
      }
   }

   /**
    * Performs an preorder traversal on this binary tree by calling
    * an overloaded, recursive preorder method that starts with
    * the root.
    *
    * @return  an pre order iterator over this tree
    */
   @Override
public Iterator<T> iteratorPreOrder()
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      preorder (root, tempList);

      return tempList.iterator();
   }

   /**
    * Performs a recursive preorder traversal.
    *
    * @param node  the node to be used as the root for this traversal
    * @param tempList  the temporary list for use in this traversal
    */
   protected void preorder (BinaryTreeNode<T> node,
                            ArrayUnorderedList<T> tempList)
   {
      if (node != null)
      {
         tempList.addToRear(node.element);
         preorder (node.left, tempList);
         preorder (node.right, tempList);
      }
   }

   /**
    * Performs an postorder traversal on this binary tree by calling
    * an overloaded, recursive postorder method that starts
    * with the root.
    *
    * @return  a post order iterator over this tree
    */
   @Override
public Iterator<T> iteratorPostOrder()
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      postorder (root, tempList);

      return tempList.iterator();
   }

   /**
    * Performs a recursive postorder traversal.
    *
    * @param node      the node to be used as the root for this traversal
    * @param tempList  the temporary list for use in this traversal
    */
   protected void postorder (BinaryTreeNode<T> node,
                             ArrayUnorderedList<T> tempList)
   {
      if (node != null)
      {
         postorder (node.left, tempList);
         postorder (node.right, tempList);
         tempList.addToRear(node.element);
      }
   }

   /**
    * Performs a levelorder traversal on this binary tree, using a
    * templist.
    *
    * @return  a levelorder iterator over this binary tree
 * @throws EmptyCollectionException 
    */
   @Override
public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException
   {
      ArrayUnorderedList<BinaryTreeNode<T>> nodes =
                       new ArrayUnorderedList<BinaryTreeNode<T>>();
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      BinaryTreeNode<T> current;

      nodes.addToRear (root);

      while (! nodes.isEmpty())
      {
         current = (nodes.removeFirst());

         if (current != null)
         {
            tempList.addToRear(current.element);
            if (current.left!=null)
               nodes.addToRear (current.left);
            if (current.right!=null)
               nodes.addToRear (current.right);
         }
         else
            tempList.addToRear(null);
      }

      return tempList.iterator();
   }

}

