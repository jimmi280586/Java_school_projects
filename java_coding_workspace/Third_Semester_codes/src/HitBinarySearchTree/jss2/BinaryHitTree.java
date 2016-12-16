package jss2;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

/**
 * Created by David Weis on 02-Oct-15.
 */
public class BinaryHitTree<T> extends LinkedBinarySearchTree<T> implements BinaryHitTreeADT<T> {

     public BinaryHitTree(){
         super();
     }

    /**
     * Returns a reference to the specified target element if it is
     * found in the binary tree.  Throws a NoSuchElementException if
     * the specified target element is not found in this tree.
     *
     * @param targetElement  the element being sough in the binary tree
     * @throws ElementNotFoundException  if an element not found exception occurs
     * @throws EmptyCollectionException 
     */
    @Override
    public T find (T targetElement) throws ElementNotFoundException, EmptyCollectionException
    {
        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> temp = current;

        if (!(current.element.equals(targetElement)) && (current.left !=null)&&
                (((Comparable)current.element).compareTo(targetElement) > 0))
            current = findAgain( targetElement, current.left);

        else if (!(current.element.equals(targetElement)) && (current.right != null))
            current = findAgain( targetElement, current.right);

        if (!(current.element.equals(targetElement)))
            throw new ElementNotFoundException ("binary search tree");

        current.incrementHitCounter();//added hitting here
        reshuffle();
        return current.element;
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
     * found in this tree.
     *
     * @param targetElement  the element being sought in the tree
     * @param next           the tree node to being searching on
     */
    private BinaryTreeNode<T> findAgain (T targetElement, BinaryTreeNode<T> next)
    {
        BinaryTreeNode<T> current = next;

        if (!(next.element.equals(targetElement)) && (next.left !=null) &&
                (((Comparable)next.element).compareTo(targetElement) > 0))
            next = findAgain( targetElement, next.left);

        else if (!(next.element.equals(targetElement)) && (next.right != null))
            next = findAgain( targetElement, next.right);

        return next;
    }


    protected void reshuffle()throws EmptyCollectionException {
        if (isEmpty()){
            throw new EmptyCollectionException("binary search tree");
        }
        while (reshuffleAgain(null, root)); //keeps calling the reshuffleAgain until it returns false meaning that it has run without doing any changes
        //this operation has to be repeated in case there is an element at the bottom that has a higher hitCount thn several elements above it

    }

    /**
     * recursively called method that will rearrange the tree to be in order by hitcount
     * @param previous node -  this method needs a reference so that it can perform the rotation
     * @param next the node that is currently being tested
     * @return returns true if a change has been made and teh operation should be repeated until the method returns with false
     */
    private boolean reshuffleAgain(BinaryTreeNode<T> previous, BinaryTreeNode<T> next){
        if (next == null){
            return false;
        }
        int myHitCount = next.getHitCounter();
        BinaryTreeNode<T> left = next.left;
        if (left!=null){
            int leftHitCount = left.getHitCounter();
            if (leftHitCount > myHitCount){
                leftRotation(previous, next);
                return true;
            }
        }
        BinaryTreeNode<T> right = next.right;
        if (right!=null){
            int rightHitCounter = right.getHitCounter();
            if (rightHitCounter > myHitCount){
                rightRotation(previous, next);
                return true;
            }
        }
        previous = next;
        if (reshuffleAgain(previous, next.left)){
            return true;
        }
        return reshuffleAgain(previous, next.right);
    }

    /**
     * performs left rotation on the Node
     * @param previous node
     * @param next node that should be rotated
     */
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

    /**
     * performs right rotation on the Node
     * @param previous node
     * @param next node that should be rotated
     */
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

    /**
     * public method to recursively check if the tree is ordered by hitCount
     * @return true if it is ordered false if not
     */
    @Override
	public boolean isHitCountBalanced(){
        return isHitCountBalanced(root);
    }


    /**
     * Overloaded private method to recursively check if the tree is ordered by hitCount
     * @param next node to test
     * @return true if it is ordered false if not
     */
    private boolean isHitCountBalanced(BinaryTreeNode<T> next){
        if (next==null){
            return true;
        }
        int myHitCount = next.getHitCounter();
        BinaryTreeNode<T> left = next.left;
        if (left!=null){
            int leftHitCount = left.getHitCounter();
            if (leftHitCount>myHitCount){
                return false;
            }
        }
        BinaryTreeNode<T> right = next.right;
        if (right!=null){
            int rightHitCount = right.getHitCounter();
            if (rightHitCount>myHitCount){
                return false;
            }
        }
        return isHitCountBalanced(left) && isHitCountBalanced(right);
    }
}
