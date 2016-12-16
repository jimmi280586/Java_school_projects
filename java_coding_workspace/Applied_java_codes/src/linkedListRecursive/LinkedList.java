package linkedListRecursive;

// *****************************************************************************
// File name  : LinkedList.java
// Start date : Mar 1, 2014
// Programmer : Hans So.
// Java       : Java 1.6.0
// Description:
//
// Revision history:
//   date     init  comment
//
// *****************************************************************************



public class LinkedList<T> implements IList<T>
{
  private Node<T> head = null;

  private class Node<T>
  {
    T elem;
    Node<T> next;

    public Node (T elem, Node<T> next)
    {
      this.elem = elem;
      this.next = next;
    }
  }

  @Override
  public void addFirst (T element)
  {
    head = new Node<T>(element, head);
  }

  @Override
  public void addLast (T element)
  {
     // TODO Auto-generated method stub
  }

  @Override
  public T removeFirst ()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T removeLast ()
  {
    return null;
  }

  @Override
  public int size ()
  {
    return recSize (head);
  }

  @Override
  public void print ()
  {
    recPrint (head);
  }

  @Override
  public void printReverse ()
  {
    recPrintReverse (head);
  }

  // recursive help methods:

  private int recSize (Node<T> list)
  {
    return -1;
  }

  private void recPrint (Node<T> list)
  {

  }

  private void recPrintReverse (Node<T> list)
  {

  }
}
