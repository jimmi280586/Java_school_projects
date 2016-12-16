/**
 * Linked implementation of the binary tree abstract data type
 *
 * 28.02.2016 findNode made protected
 * 23.02.2016 The two subtree constructor corrected
 * 16.02.2016 Original version
 */


package linkedbinarybosttree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.BinaryBostTreeADT;

/**
 * Linked implementation of the binary tree ADT
 *
 * @param <T> Generic type for the values stored in the tree
 */

public class LinkedBinaryBostTree<T>
	implements BinaryBostTreeADT<T>
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

	public LinkedBinaryBostTree()
	{
	}

	/**
	 * Constructor that creates a new tree with exactlt one node
	 *
	 * @param element the element to insert in the root of the new tree
	 */

	public LinkedBinaryBostTree( T element )
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

	public LinkedBinaryBostTree( T element, LinkedBinaryBostTree<T> leftSubTree, LinkedBinaryBostTree<T> rightSubTree )
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
	public void ChangeBribe(T element, int bribe) throws EmptyCollectionException
	{
	   Bribe(element, bribe);
	}

	protected void Bribe(T element, int bribe) throws EmptyCollectionException
	{
	   BinaryTreeNode<T> result = findNode( root, element );
	   result.setBribe(bribe);
	   System.out.println(result.getBribe());
	   ReorganizeTree();
	}

   protected void ReorganizeTree()throws EmptyCollectionException {
      if (isEmpty()){
          throw new EmptyCollectionException("binary search tree");
      }
      while (REorganizeTree(null, root));

  }

	private boolean REorganizeTree(BinaryTreeNode<T> previous, BinaryTreeNode<T> next){
      if (next == null){
         return false;
     }
     int mybribe = next.getBribe();
     BinaryTreeNode<T> left = next.left;
     if (left!=null){
         int leftbribe = left.getBribe();
         if (leftbribe > mybribe){
             leftRotation(previous, next);
             return true;
         }
     }
     BinaryTreeNode<T> right = next.right;
     if (right!=null){
         int rightbribe = right.getBribe();
         if (rightbribe > mybribe){
             rightRotation(previous, next);
             return true;
         }
     }
     previous = next;
     if (REorganizeTree(previous, next.left)){
         return true;
     }
     return REorganizeTree(previous, next.right);
 }

	  private void rightRotation(BinaryTreeNode<T> previous, BinaryTreeNode<T> next) {
        BinaryTreeNode<T> oldRoot = next;
        BinaryTreeNode<T> newRoot = next.right;
        if (previous==null){
            root = newRoot;
        }
        else if (previous.left==next){
            previous.left = newRoot;
        } else if (previous.right==next){
            previous.right= newRoot;
        }
        oldRoot.right=newRoot.left;
        newRoot.left=oldRoot;
    }

	    private void leftRotation(BinaryTreeNode<T> previous, BinaryTreeNode<T> next) {
	        BinaryTreeNode<T> oldRoot = next;
	        BinaryTreeNode<T> newRoot = next.left;
	        if (previous==null){
	            root = newRoot;
	        }
	        else if (previous.left==next){
	            previous.left = newRoot;
	        } else if (previous.right==next){
	            previous.right= newRoot;
	        }
	        oldRoot.left=newRoot.right;
	        newRoot.right=oldRoot;
	    }

   @Override
public boolean BribeBalanced(){
      return BribeBalanced(root);
  }

   private boolean BribeBalanced(BinaryTreeNode<T> next){
      if (next==null){
          return true;
      }
      int myBribe = next.getBribe();
      BinaryTreeNode<T> left = next.left;
      if (left!=null){
          int leftBribe = left.getBribe();
          if (leftBribe>myBribe){
              return false;
          }
      }
      BinaryTreeNode<T> right = next.right;
      if (right!=null){
          int rightBribe = right.getBribe();
          if (rightBribe>myBribe){
              return false;
          }
      }
      return BribeBalanced(left) && BribeBalanced(right);
  }

   @Override
public String toString()
	{
		String result = "";

		for( T element: this )
			result += " E " + element + " B " + findNode(root, element).getBribe();

		return result;
	}




}
