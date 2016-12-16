package utility.collection;

public class LinkedList<T> implements ListADT<T>
{
   private int count;
   private LinearNode<T> front;

   public LinkedList()
   {
      count = 0;
      front = null;
   }

   @Override
   public void add(int index, T element)
   {
      if (index < 0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }
      if (index == 0)
      {
         front = new LinearNode<T>(element, front);
      }
      else
      {
         LinearNode<T> previous = getNode(index - 1);
         LinearNode<T> newNode = new LinearNode<T>(element, previous.getNext());
         previous.setNext(newNode);
      }
      count++;
   }

   private LinearNode<T> getNode(int index)
   {
      if (index >= count)
      {
         throw new IndexOutOfBoundsException();
      }
      if (index < 0)
      {
         return null;
      }
      LinearNode<T> current = front;
      for (int i = 0; i < index; i++)
      {
         current = current.getNext();
      }
      return current;
   }

   @Override
   public void add(T element)
   {
      add(count, element);
   }

   @Override
   public void set(int index, T element)
   {
      if (index < 0 || index >= count)
      {
         throw new IndexOutOfBoundsException();
      }
      getNode(index).setElement(element);
   }

   @Override
   public T get(int index)
   {
      if (index < 0 || index >= count)
      {
         throw new IndexOutOfBoundsException();
      }
      LinearNode<T> node = getNode(index);
      return node.getElement();
   }

   @Override
   public T remove(int index)
   {
      if (index < 0 || index >= count)
      {
         throw new IndexOutOfBoundsException();
      }
      T toRemove = null;
      if (index == 0)
      {
         toRemove = front.getElement();
         front = front.getNext();
      }
      else
      {
         LinearNode<T> previous = getNode(index - 1);
         toRemove = previous.getNext().getElement();
         previous.setNext(previous.getNext().getNext());
      }
      count--;
      return toRemove;
   }

   @Override
   public T remove(T element)
   {
      int index = indexOf(element);
      if (index > -1)
      {
         return remove(index);
      }
      return null;
   }

   @Override
   public int indexOf(T element)
   {
      LinearNode<T> current = front;
      if (element != null)
      {
         for (int i = 0; i < count; i++)
         {
            if (element.equals(current.getElement()))
               return i;
            current = current.getNext();
         }
      }
      else
      {
         for (int i = 0; i < count; i++)
         {
            if (null == current.getElement())
               return i;
            current = current.getNext();
         }
      }
      return -1;
   }

   @Override
   public boolean contains(T element)
   {
      return indexOf(element) > -1;
   }

   @Override
   public boolean isEmpty()
   {
      return count == 0;
   }

   @Override
   public int size()
   {
      return count;
   }

   public String toString()
   {
      String s = "{";
      LinearNode<T> current = front;

      for (int i = 0; i < count; i++)
      {
         s += current.getElement();
         if (i < count - 1)
         {
            s += ", ";
         }
         current = current.getNext();
      }
      s += "}";
      return s;
   }
}
