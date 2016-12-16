/**
 * An implementation of the binary tree ADT (reworked from Lewis&Chase)
 *
 * 16.02.2016 Original version
 */

package interfaces;


import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

/**
 * Interface defining the operations of the binary tree abstract data type
 *
 * @param <T> the generic type of elements stored in the tree
 */

public interface BinaryBostTreeADT<T>
	extends Iterable<T> // Makes it possible to use a foreach statement to iterate through the tree
{
	/**
	 * Returns the value contained in the root node
	 *
	 * @return the value contained in the root node
	 *
	 * @throws EmptyCollectionException thrown if the tree is empty
	 */

	public T getRoot () throws EmptyCollectionException;

	/**
	 * return true if the tree contains no elements
	 *
	 * @return true if the tree is empty
	 */

	public boolean isEmpty();

	/**
	 * Returns the number of elements in the tree
	 *
	 * @return the number of elements in the tree
	 */

	public int size();

	/**
	 * Returns true if the specified element exists in the tree
	 *
	 * @param element the element to look up in the tree
	 *
	 * @return true if the element exists in the tree
	 */

	public boolean contains (T element);

	/**
	 * Finds and return an element from the tree
	 *
	 * @param element the element to be found
	 *
	 * @return the found element. The version stored in the tree is returned
	 *
	 * @throws ElementNotFoundException Thrown if the element can't be found
	 */

	public T find (T element) throws ElementNotFoundException;

	/**
	 * Inorder traversal of the tree
	 *
	 * @return an iterator that will make an inorder traversal of the tree
	 */

	public Iterator<T> iteratorInOrder();

	/**
	 * Preorder traversal of the tree
	 *
	 * @return an iterator that will make an preorder traversal of the tree
	 */

	public Iterator<T> iteratorPreOrder();

	/**
	 * Postorder traversal of the tree
	 *
	 * @return an iterator that will make an postorder traversal of the tree
	 */

	public Iterator<T> iteratorPostOrder();

	/**
	 * Level order traversal of the tree
	 *
	 * @return an iterator that will make an level order traversal of the tree
	 */

	public Iterator<T> iteratorLevelOrder();

	/**
	 * Returns an iterator for the tree. No specific order can be assumed
	 *
	 * @return an iterator for the tree
	 */

	@Override
	public Iterator<T> iterator();

	/**
	 * Returns the height of the tree
	 *
	 * @return the height of the tree
	 */

	public int height();

	/**
	 * Returns true of the tree is full
	 *
	 * @return true if the tree is full
	 */

	public boolean isFull();

	/**
	 * Returns true if the tree is balanced. Notice that different implementations might have different definitions of balanced
	 *
	 * @return true if the tree is balanced
	 */

	public boolean isBalanced();

	public boolean BribeBalanced();

   public void ChangeBribe(T element, int j) throws EmptyCollectionException;


}

