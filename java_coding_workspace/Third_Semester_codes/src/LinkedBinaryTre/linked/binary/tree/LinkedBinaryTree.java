/**
 * Linked implementation of the binary tree abstract data type
 *
 * 28.02.2016 findNode made protected
 * 23.02.2016 The two subtree constructor corrected
 * 16.02.2016 Original version
 */


package linked.binary.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.LinkedBinarysearchTreeADT;

/**
 * Linked implementation of the binary tree ADT
 *
 * @param <T> Generic type for the values stored in the tree
 */

public class LinkedBinaryTree<T>
   implements LinkedBinarysearchTreeADT<T>
{
   /**
    * Reference to the root of the tree. Protected so specializations might access it.
    */

   protected BinaryTreeNode<T> root = null;

   /**
    * The number of elements in the tree. Protected so specializations might access it.
    */

   protected int count = 0;


   /**
    * Constructor that creates an empty tree
    */

   public LinkedBinaryTree()
   {
   }

   /**
    * Constructor that creates a new tree with exactlt one node
    *
    * @param element the element to insert in the root of the new tree
    */

   public LinkedBinaryTree( T element )
   {
      root = new BinaryTreeNode<T>( element );
      count = 1;
   }

   /**
    * Constructor which creates a new tree with the given element as root and copies of the given subtrees inserted below the root.
    *
    * @param element the element to be inserted in the root of the new tree
    * @param leftSubTree this subtree will be added as the left child of the root
    * @param rightSubTree this subtree will be added as the right child of the root
    */

   public LinkedBinaryTree( T element, LinkedBinaryTree<T> leftSubTree, LinkedBinaryTree<T> rightSubTree )
   {
      this( element );

      if( leftSubTree != null ) {
         root.setLeft( new BinaryTreeNode<T>( leftSubTree.root ) );
         count += leftSubTree.count;
      }

      if( rightSubTree != null ) {
         root.setRight( new BinaryTreeNode<T>( rightSubTree.root ) );
         count += rightSubTree.count;
      }
   }

   @Override
public T getRoot ()
      throws EmptyCollectionException
   {
      if( size() == 0 )
         throw new EmptyCollectionException( "LinkedBInaryTree.getRoot()" );

      return root.getElement();
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
public boolean contains (T element)
   {
      return findNode( root, element ) != null;
   }


   @Override
public T find (T element)
      throws ElementNotFoundException
   {
      BinaryTreeNode<T> resultNode = findNode( root, element );

      if( resultNode == null )
         throw new ElementNotFoundException( "LinkedBinaryTree.find()" );

      return resultNode.getElement();
   }


   protected BinaryTreeNode<T> findNode( BinaryTreeNode<T> current, T element )
   {
      if( current == null )
         return null;
      else if( element.equals( current.getElement() ) )
         return current;
      else {
         BinaryTreeNode<T> result = findNode( current.getLeft(), element );

         if( result != null )
            return result;
         else
            return findNode( current.getRight(), element );
      }
   }


   @Override
public Iterator<T> iteratorInOrder()
   {
      ArrayList<T> result = new ArrayList<T>();

      inOrder( root, result );

      return result.iterator();
   }


   private void inOrder( BinaryTreeNode<T> current, ArrayList<T> result )
   {
      if( current != null ) {
         inOrder( current.getLeft(), result );
         result.add( current.getElement() );
         inOrder( current.getRight(), result );
      }
   }


   @Override
public Iterator<T> iteratorPreOrder()
   {
      ArrayList<T> result = new ArrayList<T>();

      preOrder( root, result );

      return result.iterator();
   }


   private void preOrder( BinaryTreeNode<T> current, ArrayList<T> result )
   {
      if( current != null ) {
         result.add( current.getElement() );
         preOrder( current.getLeft(), result );
         preOrder( current.getRight(), result );
      }
   }


   @Override
public Iterator<T> iteratorPostOrder()
   {
      ArrayList<T> result = new ArrayList<T>();

      postOrder( root, result );

      return result.iterator();
   }


   private void postOrder( BinaryTreeNode<T> current, ArrayList<T> result )
   {
      if( current != null ) {
         postOrder( current.getLeft(), result );
         postOrder( current.getRight(), result );
         result.add( current.getElement() );
      }
   }


   @Override
public Iterator<T> iteratorLevelOrder()
   {
      ArrayList<T> result = new ArrayList<T>();
      Queue<BinaryTreeNode<T>> queue = new ArrayDeque<BinaryTreeNode<T>>();

      if( root != null )
         queue.add( root );

      while( !queue.isEmpty() ) {
         BinaryTreeNode<T> current = queue.remove();
         result.add( current.getElement() );

         if( current.getLeft() != null )
            queue.add( current.getLeft() );

         if( current.getRight() != null )
            queue.add( current.getRight() );
      }

      return result.iterator();
   }


   @Override
public Iterator<T> iterator()
   {
      return iteratorInOrder();
   }


   @Override
public int height()
   {
      return height( root );
   }


   private int height( BinaryTreeNode<T> current )
   {
      if( current == null )
         return -1;
      else
         return 1 + Math.max( height( current.getLeft() ), height( current.getRight() ) );
   }


   @Override
public boolean isFull()
   {
      return isFull( root );
   }


   private boolean isFull( BinaryTreeNode<T> current )
   {
      if( current == null )
         return true;
      else
         return isFull( current.getLeft() ) && isFull( current.getRight() ) &&
                height( current.getLeft() ) == height( current.getRight() );
   }


   @Override
public boolean isBalanced()
   {
      return isBalanced( root );
   }


   private boolean isBalanced( BinaryTreeNode<T> current )
   {
      if( current == null )
         return true;
      else
         return isBalanced( current.getLeft() ) && isBalanced( current.getRight() ) &&
                Math.abs( height( current.getLeft() ) - height( current.getRight() ) ) <= 1;
   }


   @Override
public String toString()
   {
      String result = "";

      for( T element: this )
         result += " " + element;

      return result;
   }
}
