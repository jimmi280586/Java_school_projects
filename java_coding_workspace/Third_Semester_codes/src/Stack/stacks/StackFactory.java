/*
 * 23.08.2011 Original version
 */

package stacks;

import arrayStack.ArrayStack;
import linkedStack.LinkedStack;
import stackInterface.StackADT;

public class StackFactory
{
   private static final int SWITCH_TO_LINKED = 20;


   public static <T> StackADT<T> createStack()
   {
      return new LinkedStack<T>();
   }


   public static <T> StackADT<T> createStack( int expectedMaxSize )
   {
      if( expectedMaxSize <= SWITCH_TO_LINKED )
         return new ArrayStack<T>( expectedMaxSize );
      else
         return new LinkedStack<T>();
   }
}