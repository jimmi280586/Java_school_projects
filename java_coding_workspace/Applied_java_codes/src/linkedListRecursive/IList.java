package linkedListRecursive;

// *****************************************************************************
// File name  : IList.java
// Start date : Mar 1, 2014
// Programmer : Hans So.
// Java       : Java 1.6.0 
// Description: 
//
// Revision history:
//   date     init  comment
//
// *****************************************************************************



public interface IList<T>
{
  void addFirst(T element);
  void addLast(T element);
  
  T removeFirst();
  T removeLast();
  
  int size();
  
  void print();
  void printReverse();
}
